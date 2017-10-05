package com.dems_care.demscare.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dems_care.demscare.R;
import com.dems_care.demscare.adapter.QuizListAdapter;
import com.dems_care.demscare.dao.quiz.Quiz;
import com.dems_care.demscare.dao.quiz.QuizItemCollectionDao;
import com.dems_care.demscare.manager.HttpManager;
import com.dems_care.demscare.manager.QuizListManager;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Bon on 14/9/2560.
 */
@SuppressWarnings("unused")
public class QuizListFragment extends Fragment {

    // Listener zone
    final AdapterView.OnItemClickListener listViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//            if (position < listAdapter.getCount() ) {
//                Quiz dao = ( Quiz) parent.getItemAtPosition(position);
//
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.contentContainer, MoreInfoQuizFragment.newInstance(dao))
//                        .addToBackStack(null)
//                        .commit();
//            }


        }
    };
    ListView listView;
    QuizListAdapter listAdapter;

    SwipeRefreshLayout swipeRefreshLayout;

    QuizListManager quizListManager;

    public QuizListFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static QuizListFragment newInstance() {
        QuizListFragment fragment = new QuizListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_quiz, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView) rootView.findViewById(R.id.listQuizView);
        listAdapter = new QuizListAdapter();
        listView.setAdapter(listAdapter);

        // Handle click item in ListView
        listView.setOnItemClickListener(listViewItemClickListener);

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Logic to Load Data
                reloadData();
            }
        });

        // แก้บัค Swipe กับ ListView
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
            }
        });
        // Logic to Load Data
        reloadData();

    }

    private void reloadData() {
        Call<QuizItemCollectionDao> call = HttpManager.getInstance().getService().loadQuizList();
        call.enqueue(new Callback<QuizItemCollectionDao>() {
            @Override
            public void onResponse(Call<QuizItemCollectionDao> call,
                                   Response<QuizItemCollectionDao> response) {
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful()) {
                    QuizItemCollectionDao dao = response.body();
                    listAdapter.setDao(dao);
                    listAdapter.notifyDataSetChanged();
                    Toast.makeText(Contextor.getInstance().getContext(),
                            dao.getQuizs().get(0).getTitle(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    // Handle when Reaponse เข้ามาแต่ ไม่ success
                    try {
                        Toast.makeText(Contextor.getInstance().getContext(),
                                response.errorBody().string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<QuizItemCollectionDao> call,
                                  Throwable t) {
                // Handle
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.toString(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    // Variable
    public interface FragmentListener {
        void onQuizItemClicked(Quiz dao);
    }

}
