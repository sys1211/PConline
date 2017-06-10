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

public class Overflow_Latest_Fragment extends Fragment{
    WebView latest_web;
    private RefreshLayout latest_refreshLayout ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.overflow_latest_layout,null);
        initwebview(view);
        return view;
    }

    private void initwebview(View view) {
        latest_refreshLayout= (RefreshLayout) view.findViewById(R.id.latest_refreshLayout);
        if (latest_refreshLayout != null) {
            // 刷新状态的回调
            latest_refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 延迟2秒后刷新成功
                    latest_refreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            latest_refreshLayout.refreshComplete();
                            latest_web.reload();
                        }
                    }, 1000);
                }
            });
        }
        QQRefreshHeader header  = new QQRefreshHeader(getActivity());
        latest_refreshLayout.setRefreshHeader(header);
        latest_refreshLayout.autoRefresh();
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
