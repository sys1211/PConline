package com.example.tf.pconline.Fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.tf.pconline.R;
import com.example.tf.pconline.adapters.ChannelAdapter;
import com.example.tf.pconline.adapters.ChannelGridAdapter;
import com.example.tf.pconline.adapters.InfoViewPagerAdapter;
import com.example.tf.pconline.domain.Channel;
import com.example.tf.pconline.domain.NumClick;
import com.example.tf.pconline.helper.ItemDragHelperCallback;
import com.example.tf.pconline.views.CustomGridView;
import com.example.tf.pconline.views.CustomRecyclerView;

import java.util.ArrayList;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentInfo extends Fragment implements  ChannelAdapter.onclickListener,View.OnClickListener,AdapterView.OnItemClickListener{
    View v;
    private ViewPager infovp;
    private ImageView infodialog;
    private int numClick=0;
    public InfoViewPagerAdapter infoViewPagerAdapter;
    public ArrayList<Fragment> fragmentArrayList;
    public ArrayList<String> stringArrayList;
    public ArrayList<Fragment> fragmentArrayList2;
    public ArrayList<String> stringArrayList2;
    public TabLayout infotablayout;
    private ArrayList<Channel> channelArrayList;
    private ArrayList<Channel> channelArrayList2;
    private ArrayList<NumClick> numClickArrayList;
    private  TextView textViewdeletesorting;
    private ChannelAdapter channelAdapter;
    //,"平板","DIY外设","智能硬件","无人机","智能家电","软件","网络圈","导购","相机","企业圈","直播","汽车科技","视频", "笔记本"



    private ChannelGridAdapter channelGridAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_info,null);
        infovp = (ViewPager) v.findViewById(R.id.infovp);
        infodialog = (ImageView) v.findViewById(R.id.infodialog);
        infotablayout = (TabLayout) v.findViewById(R.id.infotablayout);
        channelArrayList = new ArrayList<>();
        channelArrayList2 = new ArrayList<>();

        fragmentArrayList = new ArrayList<>();
        stringArrayList = new ArrayList<>();
        fragmentArrayList2 = new ArrayList<>();
        stringArrayList2 = new ArrayList<>();

        numClickArrayList = new ArrayList<>();

        stringArrayList.add("头条");
        stringArrayList.add("排行榜");
        stringArrayList.add("资讯");
        stringArrayList.add("评测");

        stringArrayList2.add("图赏");
        stringArrayList2.add("PCLive");
        stringArrayList2.add("手机");
        Fragment_toutiao f1 = new Fragment_toutiao();
        Fragment_paihang f2 = new Fragment_paihang();
        Fragment_zixun f3 = new Fragment_zixun();
        Fragment_pingce f4 = new Fragment_pingce();

        Fragment_tushang f5 = new Fragment_tushang();
        Fragment_Pc f6 = new Fragment_Pc();
        Fragment_shouji f7 = new Fragment_shouji();

        fragmentArrayList.add(f1);
        fragmentArrayList.add(f2);
        fragmentArrayList.add(f3);
        fragmentArrayList.add(f4);

        fragmentArrayList2.add(f5);
        fragmentArrayList2.add(f6);
        fragmentArrayList2.add(f7);

        infodialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 利用layoutInflater获得View
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialogview, null);

                ImageView dismissdialog = (ImageView) view.findViewById(R.id.dismissdialog);
                textViewdeletesorting = (TextView) view.findViewById(R.id.deletesorting);





                CustomRecyclerView recyclerViewdialogadd = (CustomRecyclerView) view.findViewById(R.id.dialogadd);
                NumClick numclick = new NumClick(numClick);
                numClickArrayList.clear();
                numClickArrayList.add(numclick);
                channelArrayList.clear();
                for (int i = 0; i < stringArrayList.size(); i++) {
                    channelArrayList.add(new Channel(null,stringArrayList.get(i)));
                }
                channelAdapter = new ChannelAdapter(numClickArrayList,channelArrayList,getActivity(),FragmentInfo.this,recyclerViewdialogadd);
                textViewdeletesorting.setOnClickListener(FragmentInfo.this);



                recyclerViewdialogadd.setHasFixedSize(true);

                // 长按拖拽打开
                ItemDragHelperCallback callback = new ItemDragHelperCallback() {
                    @Override
                    public boolean isLongPressDragEnabled() {
                        return true;
                    }
                };
                ItemTouchHelper helper = new ItemTouchHelper(callback);
                helper.attachToRecyclerView(recyclerViewdialogadd);
                //设置adapter

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
                recyclerViewdialogadd.setLayoutManager(gridLayoutManager);
                recyclerViewdialogadd.setAdapter(channelAdapter);

                //设置RecyclerView的每一项的点击事件
                channelAdapter.setRecyclerViewOnItemClickListener(new ChannelAdapter.RecyclerViewOnItemClickListener() {
                            @Override
                            public void onItemClickListener(View view, int position) {
                                Snackbar.make(view, "点击了：" + position, Snackbar.LENGTH_SHORT).show();
                            }
                        });
                        //设置RecyclerView的每一项的长按事件
                        channelAdapter.setOnItemLongClickListener(new ChannelAdapter .RecyclerViewOnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClickListener(View view, int position) {
                                Snackbar.make(view, "长按了：" + position, Snackbar.LENGTH_SHORT).show();
                                return true;
                    }
                });


















                channelArrayList2.clear();
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    channelArrayList2.add(new Channel(null,stringArrayList2.get(i)));
                }
                CustomGridView gridViewdialogadd = (CustomGridView) view.findViewById(R.id.dialogdelete);

                channelGridAdapter = new ChannelGridAdapter(channelArrayList2,getActivity());

                gridViewdialogadd.setAdapter(channelGridAdapter);

                gridViewdialogadd.setOnItemClickListener(FragmentInfo.this);


                // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

                final PopupWindow window = new PopupWindow(view,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);

                // 设置popWindow弹出窗体可点击
                window.setFocusable(true);


                // 实例化一个ColorDrawable颜色为半透明
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                window.setBackgroundDrawable(dw);


                // 设置popWindow的显示和消失动画
                window.setAnimationStyle(R.style.mypopwindow_anim_style);
                // 在底部显示
                window.showAtLocation(view, Gravity.TOP, 0, 0);



                //popWindow消失监听方法
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {

                    }
                });
                dismissdialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        window.dismiss();
                    }
                });

            }
        });

        initViewPager();

        return v;
    }


    private void initViewPager() {


        for (int i = 0; i < stringArrayList.size(); i++) {
            infotablayout.addTab(infotablayout.newTab().setText(stringArrayList.get(i)));
        }













        infoViewPagerAdapter = new InfoViewPagerAdapter(getChildFragmentManager(),fragmentArrayList,stringArrayList);
        infovp.setAdapter(infoViewPagerAdapter);
        infotablayout.setupWithViewPager(infovp);
        //设置可以滑动
        infotablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    public void onclicklistener(int postion) {
        if (numClick%2==1) {

            String s = stringArrayList.remove(postion);
            channelArrayList.remove(postion);
            channelArrayList2.add(new Channel(null,s));
            stringArrayList2.add(s);
            channelAdapter.notifyItemRemoved(postion);
            channelGridAdapter.notifyDataSetChanged();

            Fragment fragment = fragmentArrayList.remove(postion);
            fragmentArrayList2.add(fragment);
            infoViewPagerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onclicklonglistener(int postion) {


    }

    @Override
    public void onClick(View v) {
        if (numClick%2==0) {
            textViewdeletesorting.setText("完成");
            numClick++;
            NumClick numclick = new NumClick(numClick);
            numClickArrayList.clear();
            numClickArrayList.add(numclick);
            channelAdapter.notifyDataSetChanged();

        }else{
            textViewdeletesorting.setText("删除/排序");
            numClick++;
            NumClick numclick = new NumClick(numClick);
            numClickArrayList.clear();
            numClickArrayList.add(numclick);
            channelAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (numClick%2==1) {
            String s = stringArrayList2.remove(position);
            channelArrayList2.remove(position);
            stringArrayList.add(s);
            channelArrayList.add(new Channel(null,s));
            channelAdapter.notifyDataSetChanged();
            channelGridAdapter.notifyDataSetChanged();


            Fragment fragment = fragmentArrayList2.remove(position);
            fragmentArrayList.add(fragment);
            infoViewPagerAdapter.notifyDataSetChanged();

        }

    }
}

