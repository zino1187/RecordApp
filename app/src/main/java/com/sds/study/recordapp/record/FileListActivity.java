package com.sds.study.recordapp.record;

/*
 녹음으로 인하여 생성된 파일을 목록으로 보여주고,
 해당 파일 선택하면 재생시키자!!
*/

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sds.study.recordapp.R;

public class FileListActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    String TAG;
    ViewPager viewPager;
    RecordPagerAdapter pagerAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        Log.d(TAG, "FileListActivity : "+this);
        setContentView(R.layout.list_layout);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        /*리스너와의 연결*/
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Log.d(TAG, "onPageScrolled");
    }

    /*페이지가 선택이 확정되면...commit 되면...*/
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected");

        DetailFragment detailFragment=(DetailFragment) pagerAdapter.fragments[1];
        ListFragment listFragment=(ListFragment) pagerAdapter.fragments[0];
        detailFragment.txt_filename.setText(listFragment.filename);

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "onPageScrollStateChanged");
    }
}










