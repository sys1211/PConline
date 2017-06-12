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
import com.example.tf.pconline.Adapter.TSListAdapter;
import com.example.tf.pconline.R;
import com.example.tf.pconline.Refresh.QQRefreshHeader;
import com.example.tf.pconline.Refresh.RefreshLayout;
import com.example.tf.pconline.domain.Channel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/6/11.
 */

public class TSFragment extends Fragment {
    private RefreshLayout found_refreshLayout ;
    private ListView tslist;
    private TSListAdapter tsListAdapter;
    private ArrayList<Channel> channelArrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tsfragment,null);
        found_refreshLayout= (RefreshLayout) view.findViewById(R.id.ts_refreshlayout);
        tslist = (ListView) view.findViewById(R.id.tslist);
        channelArrayList = new ArrayList<>();
        initList();


        initwebview();
        return view;
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
                    }, 1000);
                }
            });
        }
        QQRefreshHeader header  = new QQRefreshHeader(getActivity());
        found_refreshLayout.setRefreshHeader(header);
        found_refreshLayout.autoRefresh();

    }

    private void initList() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest("http://mrobot.pconline.com.cn/v2/cms/channels/11?pageSize=20&pageNo=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArraygroups = jsonObject.getJSONArray("groups");
                    for (int i = 0; i < jsonArraygroups.length(); i++) {
                        JSONObject jsonObject1 = jsonArraygroups.getJSONObject(i);
                        String cover = jsonObject1.getString("cover");
                        String name = jsonObject1.getString("name");
                        Channel channel = new Channel(cover,name);
                        channelArrayList.add(channel);

                    }



                    tsListAdapter = new TSListAdapter(channelArrayList,getActivity());
                    tslist.setAdapter(tsListAdapter);




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

    }
}
