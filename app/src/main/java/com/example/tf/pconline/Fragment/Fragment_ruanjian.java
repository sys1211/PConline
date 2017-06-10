package com.example.tf.pconline.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tf.pconline.R;

/**
 * Created by le on 2017/6/10.
 */

public class Fragment_ruanjian extends Fragment{
    private ListView ruanjianList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ruanjian,null);

        ruanjianList = (ListView) view.findViewById(R.id.ruanjianList);


        return view;
    }
}
