package com.dems_care.demscare.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dems_care.demscare.R;
import com.dems_care.demscare.dao.book.Book;
import com.dems_care.demscare.fragment.BookListFragment;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initInstances();

        Book dao = getIntent().getParcelableExtra("dao");

        // Add Main Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.contentContainer, MoreInfoArticleFragment.newInstance(dao))
//                    .commit();
                    .add(R.id.contentContainer, BookListFragment.newInstance())
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
