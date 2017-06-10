package com.example.tf.pconline.paihang;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tf.pconline.R;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/6/7.
 */

public class Fragment_paihang extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    private RadioButton[] rbarr;
    private ArrayList<Fragment> list;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragmentpaihang);
        initview();
    }

    private void initview() {
        rg= (RadioGroup) findViewById(R.id.paihang_rg);
        manager=getSupportFragmentManager();
        list=new ArrayList<>();
        BanYue bt=new BanYue();
        Sanri sr=new Sanri();
        YiZhou yz=new YiZhou();
        list.add(bt);
        list.add(sr);
        list.add(yz);
        rbarr=new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            rbarr[i]= (RadioButton) rg.getChildAt(i);
        }
        rbarr[0].setChecked(true);
        rg.setOnCheckedChangeListener(this);
        manager.beginTransaction().add(R.id.radioutton1, list.get(0)).commit();
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.radioutton1:
                rbshow(checkedId);
                break;
            case R.id.radioutton2:
                rbshow(checkedId);
                break;
            case R.id.radioutton3:
                rbshow(checkedId);
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
                    ft.add(R.id.fraglayout, list.get(i)).hide(list.get(num)).commit();
                }
                num = i;
            }
        }
    }

}
