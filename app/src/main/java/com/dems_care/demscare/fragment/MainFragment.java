package com.dems_care.demscare.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.dems_care.demscare.R;
import com.dems_care.demscare.activity.ArticleActivity;
import com.dems_care.demscare.activity.EbookActivity;
import com.dems_care.demscare.activity.QuizActivity;
import com.dems_care.demscare.activity.VideoActivity;


/**
 * Created by Bon on 14/9/2560.
 */
@SuppressWarnings("unused")
public class MainFragment extends Fragment implements View.OnClickListener {

    /*
     * Main Menu Button
     */
    ImageButton btnArticleMenu;
    ImageButton btnVideoMenu;
    ImageButton btnBookMenu;
    ImageButton btnTestMenu;

    public MainFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        btnArticleMenu = (ImageButton) rootView.findViewById(R.id.btnArticleMenu);
        btnVideoMenu = (ImageButton) rootView.findViewById(R.id.btnVideoMenu);
        btnBookMenu = (ImageButton) rootView.findViewById(R.id.btnBookMenu);
        btnTestMenu = (ImageButton) rootView.findViewById(R.id.btnTestMenu);

        // Event OnClick
        btnArticleMenu.setOnClickListener(this);
        btnVideoMenu.setOnClickListener(this);
        btnBookMenu.setOnClickListener(this);
        btnTestMenu.setOnClickListener(this);

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

    /*
     * OnClick Menu Button
     */
    @Override
    public void onClick(View v) {
        if (v == btnArticleMenu) {
            Intent intent = new Intent(getContext(),
                    ArticleActivity.class);
            startActivity(intent);
        }

        if (v == btnVideoMenu) {
            Intent intent = new Intent(getContext(),
                    VideoActivity.class);
            startActivity(intent);
        }

        if (v == btnBookMenu) {
            Intent intent = new Intent(getContext(),
                    EbookActivity.class);
            startActivity(intent);
        }

        if (v == btnTestMenu) {
            Intent intent = new Intent(getContext(),
                    QuizActivity.class);
            startActivity(intent);
        }
    }
}
