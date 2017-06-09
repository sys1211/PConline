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
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;

/**
 * Created by fengmai on 2017/6/7.
 */

public class Overflow_Sun_Fragment extends Fragment{
    private WebView sun_web;
    private RefreshLayout sun_refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.overflow_sun_layout,null);
        initwebview(view);
        return view;
    }

    private void initwebview(View view) {
        sun_refreshLayout= (RefreshLayout) view.findViewById(R.id.sun_refreshLayout);
        if (sun_refreshLayout != null) {
            // 刷新状态的回调
            sun_refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 延迟2秒后刷新成功
                    sun_refreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sun_refreshLayout.refreshComplete();
                            sun_web.reload();
                        }
                    }, 1000);
                }
            });
        }
        QQRefreshHeader header  = new QQRefreshHeader(getActivity());
        sun_refreshLayout.setRefreshHeader(header);
        sun_refreshLayout.autoRefresh();
        String url="http://g.pconline.com.cn/best/infoapp/shaiwu.jsp";
        sun_web= (WebView) view.findViewById(R.id.sun_web);
        sun_web.getSettings().setJavaScriptEnabled(true);
        sun_web.getSettings().setSupportZoom(true);
        sun_web.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });

        sun_web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && sun_web.canGoBack()) {
                        sun_web.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        sun_web.loadUrl(url);
        sun_web.requestFocus();
    }
}
