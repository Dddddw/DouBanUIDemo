package com.example.wjj.doubanuidemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;


public class MainActivity extends AppCompatActivity {

    String[] title;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = getResources().getStringArray(R.array.title);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tab);
        tabStrip.setViewPager(mViewPager);

//        DisplayMetrics dm = getResources().getDisplayMetrics();
//        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, dm);

    }


    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0){
            super.onBackPressed();

        }else {
            mViewPager.setCurrentItem(0);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter{
        Fragment mFragment;
        private final Bundle mData;

        PagerAdapter(FragmentManager fm) {
            super(fm);
            mData = new Bundle();
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                mFragment = new ReListFragment();
            }else {
                mFragment = new PageFragment();
            }
            mData.putInt("pageNum", position);
            mFragment.setArguments(mData);

            return mFragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
