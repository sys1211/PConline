package com.example.tf.pconline.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/7.
 */

public class EnterActivity extends FragmentActivity implements View.OnClickListener,EnterDialog.LoginInputListener {

    private RelativeLayout enteritem1,enteritem2,enteritem3,enteritem4,enteritem5,enteritem6,enteritem7,enteritem8;
    private CheckBox gesture,push;
    private ImageView enterfush;
    private TextView enterfonts,enterwifi,enterline,clearcache;

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
        enterfonts = (TextView) findViewById(R.id.enterfonts);
        enterwifi = (TextView) findViewById(R.id.enterwifi);
        enterline = (TextView) findViewById(R.id.enterline);
        clearcache = (TextView) findViewById(R.id.clearcache);

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
                Intent intent1 = new Intent(this, DengLu_Activity.class);
                startActivity(intent1);
                break;

            case R.id.enteritem2:
                Intent intent2 = new Intent(this, Fonts.class);
                intent2.putExtra("name",enterfonts.getText());
                startActivityForResult(intent2, 1);
                break;

            case R.id.enteritem3:
                Intent intent3 = new Intent(this, Wifi.class);
                intent3.putExtra("name",enterwifi.getText());
                startActivityForResult(intent3, 2);
                break;

            case R.id.enteritem4:
                Intent intent4 = new Intent(this, Line.class);
                intent4.putExtra("name",enterline.getText());
                startActivityForResult(intent4, 3);
                break;

            case R.id.enteritem5:
                Intent intent5 = new Intent(this, DengLu_Activity.class);
                startActivity(intent5);
                break;

            case R.id.enteritem6:
                Intent intent6 = new Intent(this, Share.class);
                startActivity(intent6);
                break;

            case R.id.enteritem7:
                Intent intent7 = new Intent(this, AboutUs.class);
                startActivity(intent7);
                break;

            case R.id.enteritem8:
                EnterDialog dlg=new EnterDialog();
                dlg.show(getFragmentManager(),"");
                break;

            case R.id.gesture:
                break;

            case R.id.push:
                break;

            case R.id.enterfush:
                finish();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 1:
                if (resultCode == 200) {
                    enterfonts.setText(data.getStringExtra("text"));
                }
                break;

            case 2:
                if (resultCode == 300) {
                    enterwifi.setText(data.getStringExtra("text"));
                }
                break;

            case 3:
                if (resultCode == 400) {
                    enterline.setText(data.getStringExtra("text"));
                }
                break;

        }
    }

    @Override
    public void onLoginInputComplete(String username)
    {
        clearcache.setText(username);
    }
}
