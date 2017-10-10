package com.dems_care.demscare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dems_care.demscare.R;
import com.dems_care.demscare.dao.article.ArticleItemDao;
import com.dems_care.demscare.fragment.ArticleListFragment;
import com.dems_care.demscare.fragment.MainFragment;
import com.dems_care.demscare.fragment.VideoListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ArticleListFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Add Main Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_video) {
            // Do what you want
            Intent intent = new Intent(MainActivity.this,
                    VideoActivity.class);
            startActivity(intent);
//            openVideo();
            // Handle
            return true;

        } else if (id == R.id.nav_article) {
            Intent intent = new Intent(MainActivity.this,
                    ArticleActivity.class);
            startActivity(intent);
//            openArticle();
            return true;

        } else if (id == R.id.nav_book) {
            Intent intent = new Intent(MainActivity.this,
                    BookActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_test) {
            Intent intent = new Intent(MainActivity.this,
                    QuizActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_facebook) {

        } else if (id == R.id.nav_contract) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openVideo() {
        Fragment fragment = getSupportFragmentManager()
                .findFragmentById(R.id.contentContainer);
        // check isNewFragment?: add new fragment
        if (fragment instanceof VideoListFragment == false) {
            getSupportFragmentManager().beginTransaction()
                    // Fragment standard transition always add before .replace  (TRANSIT_FRAGMENT_OPEN is animation when change fragment )
                    //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(
                            // next animation
                            R.anim.from_right, R.anim.to_left,
                            // back animation
                            R.anim.from_left, R.anim.to_right
                    )

                    .replace(R.id.contentContainer,
                            VideoListFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        Toast.makeText(MainActivity.this,
                "Video List Fragment",
                Toast.LENGTH_SHORT).show();
    }

    private void openArticle() {
        Fragment fragment = getSupportFragmentManager()
                .findFragmentById(R.id.contentContainer);
        // check isNewFragment?: add new fragment
        if (fragment instanceof ArticleListFragment == false) {
            getSupportFragmentManager().beginTransaction()
                    // Fragment standard transition always add before .replace  (TRANSIT_FRAGMENT_OPEN is animation when change fragment )
                    //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(
                            // next animation
                            R.anim.from_right, R.anim.to_left,
                            // back animation
                            R.anim.from_left, R.anim.to_right
                    )
                    .replace(R.id.contentContainer,
                            ArticleListFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        Toast.makeText(MainActivity.this,
                "Article List Fragment",
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onArticleItemClicked(ArticleItemDao dao) {
        Intent intent = new Intent(MainActivity.this,
                ArticleActivity.class);
        intent.putExtra("dao", dao);
        startActivity(intent);
    }
}
