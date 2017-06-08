package com.example.tf.pconline.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.tf.pconline.R;

/**
 * Created by fengmai on 2017/6/7.
 */

public class Overflow_Suffer_Fragment extends Fragment{
    WebView suffer_web;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.overflow_suffer_layout,null);
        initwebview(view);
        return view;
    }
    private void initwebview(View view) {
        String url="http://g.pconline.com.cn/best/infoapp/discovery.jsp";
        suffer_web= (WebView) view.findViewById(R.id.suffer_web);
        suffer_web.getSettings().setJavaScriptEnabled(true);
        suffer_web.getSettings().setSupportZoom(true);
        suffer_web.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });

        suffer_web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && suffer_web.canGoBack()) {
                        suffer_web.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        suffer_web.loadUrl(url);
        suffer_web.requestFocus();
    }
}
