package com.example.tf.pconline.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/7.
 */

public class TablayoutFragmentadaptr extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList;
    private Context context;
    private ArrayList<String> title;
    public TablayoutFragmentadaptr(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> title) {
        super(fm);
        this.arrayList=arrayList;

        this.title=title;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}