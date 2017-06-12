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
 * Created by lenovo on 2017/6/8.
 */

public class Wifi extends Activity implements View.OnClickListener {

    private RelativeLayout wifiitem1,wifiitem2;
    private TextView wifiwu,wifida;
    private ImageView wifiimv1,wifiimv2,wififush;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wifi);
        initView();
    }

    private void initView() {

        wifiitem1 = (RelativeLayout) findViewById(R.id.wifiitem1);
        wifiitem2 = (RelativeLayout) findViewById(R.id.wifiitem2);
        wifiimv1 = (ImageView) findViewById(R.id.wifiimv1);
        wifiimv2 = (ImageView) findViewById(R.id.wifiimv2);
        wififush = (ImageView) findViewById(R.id.wififush);
        wifiwu = (TextView) findViewById(R.id.wifiwu);
        wifida = (TextView) findViewById(R.id.wifida);

        wififush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String a=intent.getStringExtra("name");

        if (a.equals("无图")){
            wifiwu.setTextColor(Color.BLUE);
            wifiimv1.setImageResource(R.drawable.imofan_submit_img);
        }else if (a.equals("大图")){
            wifida.setTextColor(Color.BLUE);
            wifiimv2.setImageResource(R.drawable.imofan_submit_img);
        }

        wifiitem1.setOnClickListener(this);
        wifiitem2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.wifiitem1:
                han("无图");
                break;
            case R.id.wifiitem2:
                han("大图");
                break;
        }
    }

    private void han(String i) {

        Intent intent = new Intent();
        intent.putExtra("text",i);
        setResult(300, intent);
        finish();

    }

}
