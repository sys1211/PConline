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
import com.example.tf.pconline.Adapter.RJListAdapter;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;
import com.example.tf.pconline.domain.Channel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Fragment_DIYwaishe extends Fragment{
    private ListView DIYList;
    private ArrayList<Channel> datelist;
    private RefreshLayout found_refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__diy,null);
        DIYList = (ListView) view.findViewById(R.id.DIYList);
        datelist=new ArrayList<>();
        found_refreshLayout= (RefreshLayout) view.findViewById(R.id.DIY_refreshlayout);
        initwebview();

        initVolley();
        return view;
    }

    private void initVolley() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest("http://mrobot.pconline.com.cn/v2/cms/channels/120?pageNo=", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jo1=new JSONObject(response);
                    JSONArray ja=jo1.getJSONArray("articleList");
                    for(int i=0;i<ja.length();i++){
                        JSONObject jo2= ja.getJSONObject(i);
                        datelist.add(new Channel(jo2.getString("image"),jo2.getString("title")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
        DIYList.setAdapter(new RJListAdapter(getContext(),datelist));


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
