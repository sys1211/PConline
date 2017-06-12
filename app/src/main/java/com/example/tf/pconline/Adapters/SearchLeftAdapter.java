package com.example.tf.pconline.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tf.pconline.Datas.SearchLeftData;
import com.example.tf.pconline.R;

import java.util.ArrayList;

/**
 * Created by joker on 2017/6/9.
 */

public class SearchLeftAdapter extends BaseAdapter {

    private ArrayList<SearchLeftData> list;
    private Context mcontext;
    private int selectItem = -1;
    public SearchLeftAdapter(ArrayList<SearchLeftData> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(list!=null){
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }


    private ImageView img;
    private TextView up;
    private TextView below;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mcontext).inflate(R.layout.searchlist_item,null);

        img = (ImageView) convertView.findViewById(R.id.leftlistimg);
        up = (TextView) convertView.findViewById(R.id.leftlistup);
        below = (TextView) convertView.findViewById(R.id.leftlistbelow);

        img.setImageResource(list.get(position).getImg());
        up.setText(list.get(position).getUp());
        below.setText(list.get(position).getBelow());

        if (selectItem == position) {

            convertView.setBackgroundColor(Color.WHITE);
        } else {

            convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        return convertView;
    }


}
