package com.example.tf.pconline.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/8.
 */

public class AboutUs extends Activity{
    private ImageView AboutUsfush;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        AboutUsfush = (ImageView) findViewById(R.id.aboutusfush);
        AboutUsfush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
