package com.example.tf.pconline.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/8.
 */

public class Fonts extends Activity implements View.OnClickListener {
    private RelativeLayout fontsitem1,fontsitem2,fontsitem3;
    private ImageView fontsimv1,fontsimv2,fontsimv3,fontsfush;
    private TextView fontsxiao,fontszhong,fontsda;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fonts);
        initView();
    }

    private void initView() {
        fontsitem1 = (RelativeLayout) findViewById(R.id.fontsitem1);
        fontsitem2 = (RelativeLayout) findViewById(R.id.fontsitem2);
        fontsitem3 = (RelativeLayout) findViewById(R.id.fontsitem3);
        fontsimv1 = (ImageView) findViewById(R.id.fontsimv1);
        fontsimv2 = (ImageView) findViewById(R.id.fontsimv2);
        fontsimv3 = (ImageView) findViewById(R.id.fontsimv3);
        fontsfush = (ImageView) findViewById(R.id.fontsfush);
        fontsxiao = (TextView) findViewById(R.id.fontsxiao);
        fontszhong = (TextView) findViewById(R.id.fontszhong);
        fontsda = (TextView) findViewById(R.id.fontsda);

        fontsfush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String a=intent.getStringExtra("name");
        if (a.equals("小体字")){
            fontsxiao.setTextColor(Color.BLUE);
            fontsimv1.setImageResource(R.drawable.imofan_submit_img);
        }else if (a.equals("中体字")){
            fontszhong.setTextColor(Color.BLUE);
            fontsimv2.setImageResource(R.drawable.imofan_submit_img);
        }else if (a.equals("大体字")){
            fontsda.setTextColor(Color.BLUE);
            fontsimv3.setImageResource(R.drawable.imofan_submit_img);
        }

        fontsitem1.setOnClickListener(this);
        fontsitem2.setOnClickListener(this);
        fontsitem3.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fontsitem1:
                han("小体字");
                break;
            case R.id.fontsitem2:
                han("中体字");
                break;
            case R.id.fontsitem3:
                han("大体字");
                break;
        }
    }

    private void han(String i) {
        Intent intent = new Intent();
        intent.putExtra("text",i);
        setResult(200, intent);
        finish();
    }

}