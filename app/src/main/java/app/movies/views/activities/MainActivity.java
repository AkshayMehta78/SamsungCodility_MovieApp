package app.movies.views.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.movies.R;
import app.movies.views.adapters.MoviePagerAdapter;
import app.movies.views.fragments.NowPlayingFragment;
import app.movies.views.fragments.UpcomingFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setUpToolbar();
        setUpViewPager();

        /**
         * Binding viewpager with tablayout
         */
        mTabLayout.setupWithViewPager(mViewPager);
    }


    /*
    Set up MoviePagerAdapter to add fragments into it
     */
    private void setUpViewPager() {
        MoviePagerAdapter moviePagerAdapter = new MoviePagerAdapter(getSupportFragmentManager());
        moviePagerAdapter.addFragment(new NowPlayingFragment(), getString(R.string.nowplaying));
        moviePagerAdapter.addFragment(new UpcomingFragment(), getString(R.string.upcoming));
        mViewPager.setAdapter(moviePagerAdapter);
    }


    /**
     * Set up toolbar with title
     */
    private void setUpToolbar() {
        mToolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(mToolbar);
    }


    /**
     * Init all views
     */
    private void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);
    }
}
