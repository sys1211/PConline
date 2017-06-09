package com.example.tf.pconline.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by le on 2017/6/7.
 */

public class InfoViewPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> stringArrayList;
    public InfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public InfoViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList, ArrayList<String> stringArrayList) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
        this.stringArrayList = stringArrayList;
    }

    @Override
    public CharSequence getPageTitle(int position) {






        return stringArrayList.get(position);
    }

    @Override
    public Fragment getItem(int position) {



        Fragment page = null;
            if (fragmentArrayList.size() > position) {
                page = fragmentArrayList.get(position);
                if (page != null) {
                    return page;
                }
            }


        return null;
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


}
