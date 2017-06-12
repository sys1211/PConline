package com.example.tf.pconline.Activitys;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.tf.pconline.R;

/**
 * Created by lenovo on 2017/6/10.
 */

public class EnterDialog extends DialogFragment {
    private TextView Oktv,fishtv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View v=inflater.inflate(R.layout.enterdialog,null);
        Oktv= (TextView) v.findViewById(R.id.oktv);
        fishtv = (TextView) v.findViewById(R.id.fishtv);
        Oktv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginInputListener listener = (LoginInputListener) getActivity();
                listener.onLoginInputComplete("0M");
                dismiss();
            }
        });
        fishtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }
    public interface LoginInputListener
    {
        void onLoginInputComplete(String username);
    }

}
