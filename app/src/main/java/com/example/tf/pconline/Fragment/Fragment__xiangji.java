package com.example.tf.pconline.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.tf.pconline.Datas.XiangJ;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;
import com.example.tf.pconline.adapters.XiangJiAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/6/9.
 */


public class Fragment__xiangji extends Fragment {

    private ListView listViewpc;
    private XiangJiAdapter xiangJiAdapter;
    private ArrayList<XiangJ> arrayList;
    private RefreshLayout found_refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__xiangji, null);
        listViewpc = (ListView) v.findViewById(R.id.xiangjilist);
        found_refreshLayout= (RefreshLayout) v.findViewById(R.id.xj_refreshlayout);
        arrayList = new ArrayList<>();
        RequestQueue mQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest("http://mrobot.pconline.com.cn/v2/cms/channels/14?pageNo=",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String aa = response;
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(aa);
                            JSONArray jsonarray = jsonObject.getJSONArray("articleList");
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                String title = jsonobject.getString("channel");
                                String Message = jsonobject.getString("summary");
                                String Image = jsonobject.getString("image");
                                arrayList.add(new XiangJ(Image, title, Message));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(stringRequest);
        xiangJiAdapter = new XiangJiAdapter(getContext(), arrayList);
        listViewpc.setAdapter(xiangJiAdapter);
        initwebview();
        return v;
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

