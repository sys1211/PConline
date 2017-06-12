package com.example.tf.pconline.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.tf.pconline.R;

/**
 * Created by Administrator on 2017/6/7.
 */

public class Fragment_tushang extends Fragment {
    private RadioButton tsrb1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmenttushang,null);


        getChildFragmentManager().beginTransaction().add(R.id.tsfm,new TSFragment()).commit();
        tsrb1 = (RadioButton) v.findViewById(R.id.tsrb1);
        tsrb1.setChecked(true );


        return v;
    }


}
