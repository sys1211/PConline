package com.example.tf.pconline.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tf.pconline.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/6/7.
 */

public class Fragment_toutiao extends Fragment {

    private RollPagerView rollPV = null;
    private RollPagerAdapter rollPagerAdapter;
    private ArrayList<String> zuxunlunbo;
    private ListView listView;
    private int[] image = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmenttoutiao,null);


        rollPV = (RollPagerView)v.findViewById(R.id.rollPV);
        init();
        zuxunlunbo=new ArrayList<>();

        return v;
    }
    private void init() {
        rollPV.setPlayDelay(3000);
        //设置图片切换动画时间
        rollPV.setAnimationDurtion(500);
        //设置指示器:
        // rollPV.setHintView(new IconHintView());
        //rollPV.setHintView(new IconHintView(this,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        rollPV.setHintView(new ColorPointHintView(getContext(),
                getResources().getColor(R.color.colorPrimary),
                Color.WHITE));
        //设置适配器
        rollPagerAdapter=new RollPagerAdapter(zuxunlunbo);
        rollPV.setAdapter(rollPagerAdapter);
    }
    //适配器
    private class RollPagerAdapter extends StaticPagerAdapter {

        ArrayList<String> zuxunlunbo;


        public RollPagerAdapter(ArrayList<String> mainRollPagerBeanArrayList) {
            this.zuxunlunbo = mainRollPagerBeanArrayList;
        }

        @Override
        public View getView(ViewGroup container, int position) {

            ImageView view=new ImageView(container.getContext());
            //设置图片资源
            Picasso.with(getContext()).load(zuxunlunbo.get(position)).into(view);
            //设置高度和宽度
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置拉伸方式
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);


            return view;
        }
        @Override
        public int getCount() {
            return zuxunlunbo.size();
        }

    }
}


