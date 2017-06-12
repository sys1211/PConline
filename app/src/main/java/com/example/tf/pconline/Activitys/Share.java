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
 * Created by lenovo on 2017/6/10.
 */

public class Share extends Activity {

    private ImageView sharefush;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);
        initView();
    }
    private void initView() {

        sharefush = (ImageView) findViewById(R.id.sharefush);

        sharefush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
