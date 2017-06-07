package com.example.tf.pconline.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/7.
 */

public class EnterActivity extends Activity implements View.OnClickListener {
    private RelativeLayout enteritem1,enteritem2,enteritem3,enteritem4,enteritem5,enteritem6,enteritem7,enteritem8;
    private CheckBox gesture,push;
    private ImageView enterfush;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enteractivity);
        initView();
    }

    private void initView() {
        enteritem1 = (RelativeLayout) findViewById(R.id.enteritem1);
        enteritem2 = (RelativeLayout) findViewById(R.id.enteritem2);
        enteritem3 = (RelativeLayout) findViewById(R.id.enteritem3);
        enteritem4 = (RelativeLayout) findViewById(R.id.enteritem4);
        enteritem5 = (RelativeLayout) findViewById(R.id.enteritem5);
        enteritem6 = (RelativeLayout) findViewById(R.id.enteritem6);
        enteritem7 = (RelativeLayout) findViewById(R.id.enteritem7);
        enteritem8 = (RelativeLayout) findViewById(R.id.enteritem8);
        gesture = (CheckBox) findViewById(R.id.gesture);
        push = (CheckBox) findViewById(R.id.push);
        enterfush = (ImageView) findViewById(R.id.enterfush);

        enteritem1.setOnClickListener(this);
        enteritem2.setOnClickListener(this);
        enteritem3.setOnClickListener(this);
        enteritem4.setOnClickListener(this);
        enteritem5.setOnClickListener(this);
        enteritem6.setOnClickListener(this);
        enteritem7.setOnClickListener(this);
        enteritem8.setOnClickListener(this);
        gesture.setOnClickListener(this);
        push.setOnClickListener(this);
        enterfush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enteritem1:
                Toast.makeText(this,"绑定分享平台",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem2:
                Toast.makeText(this,"文章字号大小",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem3:
                Toast.makeText(this,"非wifi下显示",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem4:
                Toast.makeText(this,"离线阅读管理",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem5:
                Toast.makeText(this,"推荐给好友",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem6:
                Toast.makeText(this,"零流量分享",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem7:
                Toast.makeText(this,"关于我们",Toast.LENGTH_LONG).show();
                break;
            case R.id.enteritem8:
                Toast.makeText(this,"清除缓存",Toast.LENGTH_LONG).show();
                break;
            case R.id.gesture:
                Toast.makeText(this,"手势滑动",Toast.LENGTH_LONG).show();
                break;
            case R.id.push:
                Toast.makeText(this,"推送开关",Toast.LENGTH_LONG).show();
                break;
            case R.id.enterfush:
                finish();
                break;
        }
    }
}
