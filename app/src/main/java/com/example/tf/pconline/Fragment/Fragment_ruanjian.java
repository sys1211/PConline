package com.example.tf.pconline.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;

/**
 * Created by le on 2017/6/10.
 */

public class Fragment_ruanjian extends Fragment{
    private ListView ruanjianList;


    private RefreshLayout found_refreshLayout ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ruanjian,null);

        ruanjianList = (ListView) view.findViewById(R.id.ruanjianList);

        found_refreshLayout= (RefreshLayout) view.findViewById(R.id.rj_refreshlayout);
        initwebview();

        initVolley();
        return view;
    }

    private void initVolley() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest("http://mrobot.pconline.com.cn/v2/cms/channels/1000?pageNo=0", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);



    }

    private void initwebview() {

        if (found_refreshLayout != null) {
            // 刷新状态的回调
            found_refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 延迟x秒后刷新成功
                    found_refreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            found_refreshLayout.refreshComplete();

                        }
                    }, 1500);
                }
            });
        }
        QQRefreshHeader header  = new QQRefreshHeader(getActivity());
        found_refreshLayout.setRefreshHeader(header);
        found_refreshLayout.autoRefresh();

    }



}
