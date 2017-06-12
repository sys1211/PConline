package com.example.tf.pconline.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.tf.pconline.Fragment.Find_hotCollectionFragment;
import com.example.tf.pconline.Fragment.Find_hotMonthFragment;
import com.example.tf.pconline.Fragment.Find_hotRecommendFragment;
import com.example.tf.pconline.Fragment.Find_hotToday;
import com.example.tf.pconline.R;
import com.example.tf.pconline.adapters.Find_tab_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/12.
 */

public class Collect extends FragmentActivity {

    private ImageView collectfush;

    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private Find_hotRecommendFragment hotRecommendFragment;              //热门推荐fragment
    private Find_hotCollectionFragment hotCollectionFragment;            //热门收藏fragment
    private Find_hotMonthFragment hotMonthFragment;                      //本月热榜fragment
    private Find_hotToday hotToday;                                      //今日热榜fragment

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collect);
        initControls();
    }

    private void initControls() {

        collectfush = (ImageView) findViewById(R.id.collectfush);
        collectfush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tab_FindFragment_title = (TabLayout)findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager)findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        hotRecommendFragment = new Find_hotRecommendFragment();
        hotCollectionFragment = new Find_hotCollectionFragment();
        hotMonthFragment = new Find_hotMonthFragment();
        hotToday = new Find_hotToday();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        list_fragment.add(hotMonthFragment);
        list_fragment.add(hotToday);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("文章");
        list_title.add("图片");
        list_title.add("帖子");
        list_title.add("论坛");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));

        fAdapter = new Find_tab_Adapter(getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }


}