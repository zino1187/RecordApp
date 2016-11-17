package com.sds.study.recordapp.record;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

public class RecordPagerAdapter extends FragmentStatePagerAdapter{
    String TAG;
    Fragment[] fragments=new Fragment[2];

    public RecordPagerAdapter(FragmentManager fm) {
        super(fm);

        TAG=this.getClass().getName();

        fragments[0]=new ListFragment();
        fragments[1]=new DetailFragment();


    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

}
