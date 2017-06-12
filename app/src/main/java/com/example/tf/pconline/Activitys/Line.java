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

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/9.
 */

public class Line extends Activity implements View.OnClickListener {

    private RelativeLayout lineitem1,lineitem2;
    private TextView linewu,lineda;
    private ImageView lineimv1,lineimv2,linefush;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.line);
        initView();
    }

    private void initView() {

        lineitem1 = (RelativeLayout) findViewById(R.id.lineitem1);
        lineitem2 = (RelativeLayout) findViewById(R.id.lineitem2);
        lineimv1 = (ImageView) findViewById(R.id.lineimv1);
        lineimv2 = (ImageView) findViewById(R.id.lineimv2);
        linefush = (ImageView) findViewById(R.id.linefush);
        linewu = (TextView) findViewById(R.id.linewu);
        lineda = (TextView) findViewById(R.id.lineda);

        linefush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String a=intent.getStringExtra("name");

        if (a.equals("手动下载")){

            linewu.setTextColor(Color.BLUE);
            lineimv1.setImageResource(R.drawable.imofan_submit_img);

        }else if (a.equals("Wi-Fi网络下自动下载")){

            lineda.setTextColor(Color.BLUE);
            lineimv2.setImageResource(R.drawable.imofan_submit_img);

        }

        lineitem1.setOnClickListener(this);
        lineitem2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.lineitem1:
                han("手动下载");
                break;

            case R.id.lineitem2:
                han("Wi-Fi网络下自动下载");
                break;

        }
    }

    private void han(String i) {

        Intent intent = new Intent();
        intent.putExtra("text",i);
        setResult(400, intent);
        finish();

    }

}

