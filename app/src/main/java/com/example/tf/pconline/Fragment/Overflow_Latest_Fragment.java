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

public class Overflow_Latest_Fragment extends Fragment{
    WebView latest_web;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.overflow_latest_layout,null);
        initwebview(view);
        return view;
    }

    private void initwebview(View view) {
        String url="http://g.pconline.com.cn/best/infoapp/haitao.jsp";
        latest_web= (WebView) view.findViewById(R.id.latest_web);
        latest_web.getSettings().setJavaScriptEnabled(true);
        latest_web.getSettings().setSupportZoom(true);
        latest_web.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });

        latest_web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && latest_web.canGoBack()) {
                        latest_web.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        latest_web.loadUrl(url);
        latest_web.requestFocus();
    }
}
