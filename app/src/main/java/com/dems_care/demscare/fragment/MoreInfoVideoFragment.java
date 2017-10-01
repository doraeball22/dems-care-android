package com.dems_care.demscare.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dems_care.demscare.R;
import com.dems_care.demscare.dao.ArticleItemDao;


/**
 * Created by Bon on 14/9/2560.
 */
@SuppressWarnings("unused")
public class MoreInfoVideoFragment extends Fragment {

    WebView myWebView;
    String pdf;

    ArticleItemDao dao;

    public MoreInfoVideoFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static MoreInfoVideoFragment newInstance(ArticleItemDao dao) {
        MoreInfoVideoFragment fragment = new MoreInfoVideoFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao", dao);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        dao = getArguments().getParcelable("dao");

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_moreinfo_video, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
//        pdf = "https://blog.mozilla.org/security/files/2015/05/HTTPS-FAQ.pdf";
        pdf = dao.getBodyUrl().toString();
        myWebView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
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

}
