package com.example.tf.pconline.Activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tf.pconline.R;

public class SearchActivity extends Activity {
    private WebView mweb;
//    private ImageView img;
    private EditText editText;
    private String url="http://g.pconline.com.cn/best/infoapp/discovery.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        initview();
    }
    InputMethodManager imm;
    private void initview() {
//        img= (ImageView) findViewById(R.id.search_back_img);
        editText= (EditText) findViewById(R.id.search_edittext);
        mweb= (WebView) findViewById(R.id.search_web);
        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.getSettings().setSupportZoom(true);
        mweb.setHorizontalScrollBarEnabled(false);
        mweb.setVerticalScrollBarEnabled(false);
        mweb.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });

        mweb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mweb.canGoBack()) {
                        mweb.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
//        img.setOnClickListener(this);

        mweb.loadUrl(url);
        mweb.requestFocus();
        imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!imm.isActive()){
            mweb.setVisibility(View.VISIBLE);
        }else{
            mweb.setVisibility(View.GONE);
        }
        return true;
    }

    //    @Override
//    public void onClick(View v) {
//
//            mweb.setOnKeyListener(new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                        if (keyCode == KeyEvent.KEYCODE_BACK && mweb.canGoBack()) {
//                            mweb.goBack();   //后退
//                            return true;    //已处理
//                        }
//                    }
//                    return false;
//                }
//            });
//
//    }


}
