package com.dems_care.demscare.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dems_care.demscare.R;
import com.dems_care.demscare.dao.video.VideoItemDao;
import com.dems_care.demscare.fragment.VideoListFragment;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initInstances();

        VideoItemDao dao = getIntent().getParcelableExtra("dao");

        // Add Main Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.contentContainer, MoreInfoArticleFragment.newInstance(dao))
//                    .commit();
                    .add(R.id.contentContainer, VideoListFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // Handle button on actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle back button
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
