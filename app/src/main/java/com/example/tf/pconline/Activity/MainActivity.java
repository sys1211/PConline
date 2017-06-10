package com.example.tf.pconline.Activity;

import android.content.pm.ActivityInfo;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tf.pconline.Fragment.FragmentForum;
import com.example.tf.pconline.Fragment.FragmentInfo;
import com.example.tf.pconline.Fragment.FragmentMine;
import com.example.tf.pconline.Fragment.FragmentOverflow;
import com.example.tf.pconline.Fragment.FragmentProduct;
import com.example.tf.pconline.R;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg;
    private RadioButton[] rbarr;
    private ArrayList<Fragment> list;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        rg= (RadioGroup) findViewById(R.id.home_rg);
        manager=getSupportFragmentManager();
        list=new ArrayList<>();
        FragmentInfo fi=new FragmentInfo();
        FragmentForum ff=new FragmentForum();
        FragmentProduct fp=new FragmentProduct();
        FragmentOverflow fo=new FragmentOverflow();
        FragmentMine fm=new FragmentMine();
        list.add(fi);
        list.add(ff);
        list.add(fp);
        list.add(fo);
        list.add(fm);
        rbarr=new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            rbarr[i]= (RadioButton) rg.getChildAt(i);
        }
        rbarr[0].setChecked(true);
        rg.setOnCheckedChangeListener(this);
        manager.beginTransaction().add(R.id.home_fl1, list.get(0)).commit();
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.home_rb1:
                rbshow(checkedId);
                break;
            case R.id.home_rb2:
                rbshow(checkedId);
                break;
            case R.id.home_rb3:
                rbshow(checkedId);
                break;
            case R.id.home_rb4:
                rbshow(checkedId);
                break;
            case R.id.home_rb5:
                rbshow(checkedId);
                break;
            default:
                break;
        }
    }
    private int num=0;
    private void rbshow(int checkedId) {
        FragmentTransaction ft=manager.beginTransaction();
        for (int i = 0; i < rg.getChildCount(); i++) {
            if (rbarr[i].getId() == checkedId) {
                if (list.get(i).isAdded()) {
                    ft.show(list.get(i)).hide(list.get(num)).commit();
                } else {
                    ft.add(R.id.home_fl1, list.get(i)).hide(list.get(num)).commit();
                }
                num = i;
            }
        }
    }
}
