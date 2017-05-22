package com.example.pol_elektroniki.my_garden3;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pol_elektroniki.my_garden3.Tab.MyAdapter;
import com.example.pol_elektroniki.my_garden3.Tab.SlidingTabLayout;

public class SlidingActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

}
