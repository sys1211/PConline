package com.example.tf.pconline.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tf.pconline.R;
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentOverflow extends Fragment{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>(); //标签名称
    private ViewHolder holder;
  //  private RefreshLayout refreshLayout ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_overflow,null);
     //   refreshLayout = (RefreshLayout) view.findViewById(R.id.refreshLayout);

        initData();
        initView(view);
        return view;
    }
    private void initData() {
//        if (refreshLayout != null) {
//            // 刷新状态的回调
//            refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
//                @Override
//                public void onRefresh() {
//                    // 延迟2秒后刷新成功
//                    refreshLayout.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            refreshLayout.refreshComplete();
//
//                        }
//                    }, 1000);
//                }
//            });
//        }
//        QQRefreshHeader header  = new QQRefreshHeader(getActivity());
//        refreshLayout.setRefreshHeader(header);
//        refreshLayout.autoRefresh();
        tabs.add("最新" );
        tabs.add("海淘");
        tabs.add("发现");
        tabs.add("晒物");
        tabs.add("经验");
        Overflow_Found_Fragment overflow_found_fragment=new Overflow_Found_Fragment();
        Overflow_Latest_Fragment overflow_latest_fragment=new Overflow_Latest_Fragment();
        Overflow_Suffer_Fragment overflow_suffer_fragment=new Overflow_Suffer_Fragment();
        Overflow_Sun_Fragment overflow_sun_fragment=new Overflow_Sun_Fragment();
        Overflow_Treasure_Fragment overflow_treasure_fragment=new Overflow_Treasure_Fragment();
        fragments.add(overflow_found_fragment);
        fragments.add(overflow_latest_fragment);
        fragments.add(overflow_suffer_fragment);
        fragments.add(overflow_sun_fragment);
        fragments.add(overflow_treasure_fragment);
    }

    private void initView(View view) {
        tabLayout = (TabLayout)view. findViewById(R.id.tayLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置分割线
        //LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        // linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        // linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
        //         R.drawable.divider)); //设置分割线的样式
        // linearLayout.setDividerPadding(dip2px(10)); //设置分割线间隔
        viewPager.setAdapter(new TabAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        setTabView();
    }


     // 设置Tab的样式

    private void setTabView() {
        holder = null;
        for (int i = 0; i < tabs.size(); i++) {
            //依次获取标签
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //为每个标签设置布局
            tab.setCustomView(R.layout.tab_item);
            holder = new ViewHolder(tab.getCustomView());
            //为标签填充数据
            holder.tvTabName.setText(tabs.get(i));
            // holder.tvTabNumber.setText(String.valueOf(tabNumbers.get(i)));
            //默认选择第一项
            if (i == 0){
                holder.tvTabName.setSelected(true);
                //  holder.tvTabNumber.setSelected(true);
                holder.tvTabName.setTextSize(21);
                //   holder.tvTabNumber.setTextSize(18);
            }
        }

        //tab选中的监听事件
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(true);
                //选中后字体变大
                holder.tvTabName.setTextSize(21);
                //让Viewpager跟随TabLayout的标签切换
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(false);
                //恢复为默认字体大小
                holder.tvTabName.setTextSize(16);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class ViewHolder{
        TextView tvTabName;

        public ViewHolder(View tabView) {
            tvTabName = (TextView) tabView.findViewById(R.id.tv_tab_name);
        }
    }

    class TabAdapter extends FragmentPagerAdapter {

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
