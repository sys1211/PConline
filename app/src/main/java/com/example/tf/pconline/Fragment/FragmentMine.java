package com.example.tf.pconline.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tf.pconline.Activitys.EnterActivity;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Tools.CircleImageView;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentMine extends Fragment implements View.OnClickListener {
    private RelativeLayout item10,item9,item8,item7,item6,item5,item4,item3;
    private TextView entertv1,entertv2,download;
    private Button publish,news,inbox,collecting;
    private CircleImageView enterimv;
    private CheckBox switchry;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_mine,null);
        initView();
        return v;
    }

    private void initView() {
        item10 = (RelativeLayout) v.findViewById(R.id.item10);
        item9 = (RelativeLayout) v.findViewById(R.id.item9);
        item8 = (RelativeLayout) v.findViewById(R.id.item8);
        item7 = (RelativeLayout) v.findViewById(R.id.item7);
        item6 = (RelativeLayout) v.findViewById(R.id.item6);
        item5 = (RelativeLayout) v.findViewById(R.id.item5);
        item4 = (RelativeLayout) v.findViewById(R.id.item4);
        item3 = (RelativeLayout) v.findViewById(R.id.item3);
        entertv1 = (TextView) v.findViewById(R.id.entertv1);
        entertv2 = (TextView) v.findViewById(R.id.entertv2);
        download = (TextView) v.findViewById(R.id.download);
        publish = (Button) v.findViewById(R.id.publish);
        news = (Button) v.findViewById(R.id.news);
        inbox = (Button) v.findViewById(R.id.inbox);
        collecting = (Button) v.findViewById(R.id.collecting);
        enterimv = (CircleImageView) v.findViewById(R.id.enterimv);
        switchry = (CheckBox) v.findViewById(R.id.switchry);

        item10.setOnClickListener(this);
        item9.setOnClickListener(this);
        item8.setOnClickListener(this);
        item7.setOnClickListener(this);
        item6.setOnClickListener(this);
        item5.setOnClickListener(this);
        item4.setOnClickListener(this);
        item3.setOnClickListener(this);
        entertv1.setOnClickListener(this);
        entertv2.setOnClickListener(this);
        download.setOnClickListener(this);
        publish.setOnClickListener(this);
        news.setOnClickListener(this);
        inbox.setOnClickListener(this);
        collecting.setOnClickListener(this);
        enterimv.setOnClickListener(this);
        switchry.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.item10:
                Intent intent = new Intent(getActivity(), EnterActivity.class);
                startActivity(intent);
                break;
            case R.id.item9:
                Toast.makeText(getActivity(),"精品应用分享",Toast.LENGTH_LONG).show();
                break;
            case R.id.item8:
                Toast.makeText(getActivity(),"帮助与反馈",Toast.LENGTH_LONG).show();
                break;
            case R.id.item7:
                Toast.makeText(getActivity(),"每日任务",Toast.LENGTH_LONG).show();
                break;
            case R.id.item6:
                Toast.makeText(getActivity(),"积分商城",Toast.LENGTH_LONG).show();
                break;
            case R.id.item5:
                Toast.makeText(getActivity(),"新品免费试用中心",Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Toast.makeText(getActivity(),"福利资源哪里下载？",Toast.LENGTH_LONG).show();
                break;
            case R.id.entertv1:
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_LONG).show();
                break;
            case R.id.entertv2:
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_LONG).show();
                break;
            case R.id.download:
                Toast.makeText(getActivity(),"下载",Toast.LENGTH_LONG).show();
                break;
            case R.id.publish:
                Toast.makeText(getActivity(),"我的发表",Toast.LENGTH_LONG).show();
                break;
            case R.id.news:
                Toast.makeText(getActivity(),"我的消息",Toast.LENGTH_LONG).show();
                break;
            case R.id.inbox:
                Toast.makeText(getActivity(),"我的私信",Toast.LENGTH_LONG).show();
                break;
            case R.id.collecting:
                Toast.makeText(getActivity(),"我的收藏",Toast.LENGTH_LONG).show();
                break;
            case R.id.enterimv:
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_LONG).show();
                break;
            case R.id.switchry:
                Toast.makeText(getActivity(),"日/夜间模式",Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(getActivity(),"2017开学季数码导购",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
