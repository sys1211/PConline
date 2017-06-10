package com.example.tf.pconline.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tf.pconline.Activity.SearchActivity;
import com.example.tf.pconline.R;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentProduct extends Fragment{
    View v;
    private Button bt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_product,null);
        initview();
        return v;
    }

    private void initview() {
        bt= (Button) v.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), SearchActivity.class);
                startActivity(i);
            }
        });
    }
}
