package com.example.tf.pconline.Fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.tf.pconline.Activitys.Collect;
import com.example.tf.pconline.Activitys.DengLu_Activity;
import com.example.tf.pconline.Activitys.EnterActivity;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Tools.BrightnessTools;
import com.example.tf.pconline.Tools.CircleImageView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentMine extends Fragment implements View.OnClickListener {
    private RelativeLayout item10,item9,item8,item7,item6,item5,item4,item3;
    private TextView entertv1,entertv2,download,itemyejian;
    private Button publish,news,inbox,collecting;
    private CircleImageView enterimv;
    private CheckBox switchry;
    private ContentResolver contentresolver;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_mine,null);
        initView();
        return v;
    }

    private void initView() {

        contentresolver = getActivity().getContentResolver();
        itemyejian = (TextView) v.findViewById(R.id.itemyejian);
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



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("OP",MODE_PRIVATE);
        int i=sharedPreferences.getInt("name",1);

        if (i==1){
            switchry.setChecked(false);
            itemyejian.setText("夜间模式");
        }else {
            switchry.setChecked(true);
            itemyejian.setText("日间模式");
        }


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
                Intent intent1 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent1);
                break;
            case R.id.item7:
                Intent intent9 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent9);
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
                Intent intent2 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent2);
                break;
            case R.id.entertv2:
                Intent intent3 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent3);
                break;
            case R.id.download:
                Toast.makeText(getActivity(),"下载",Toast.LENGTH_LONG).show();
                break;
            case R.id.publish:
                Intent intent8 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent8);
                break;
            case R.id.news:
                Intent intent7 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent7);
                break;
            case R.id.inbox:
                Intent intent6 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent6);
                break;
            case R.id.collecting:
                Intent intent5 = new Intent(getActivity(), Collect.class);
                startActivity(intent5);
                break;
            case R.id.enterimv:
                Intent intent4 = new Intent(getActivity(), DengLu_Activity.class);
                startActivity(intent4);
                break;
            case R.id.switchry:
                if (switchry.isChecked()) {
                    BrightnessTools.stopAutoBrightness(getActivity());
                    int s=BrightnessTools.getScreenBrightness(getActivity());
                    SharedPreferences preferences=getActivity().getSharedPreferences("OP", MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putInt("name",s);
                    editor.commit();
                    BrightnessTools.saveBrightness(contentresolver,10);
                    itemyejian.setText("日间模式");
                }else {
                    BrightnessTools.startAutoBrightness(getActivity());
                    SharedPreferences preferences=getActivity().getSharedPreferences("OP", MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putInt("name",1);
                    editor.commit();
                    BrightnessTools.saveBrightness(contentresolver,10);
                    itemyejian.setText("夜间模式");
                }
                break;
            case R.id.item3:
                Toast.makeText(getActivity(),"2017开学季数码导购",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
