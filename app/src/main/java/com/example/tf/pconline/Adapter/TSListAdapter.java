package com.example.tf.pconline.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tf.pconline.R;
import com.example.tf.pconline.domain.Channel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by le on 2017/6/11.
 */

public class TSListAdapter extends BaseAdapter{
    private ArrayList<Channel> channelArrayList;
    private Context context;
    private LayoutInflater inflater;

    public TSListAdapter(ArrayList<Channel> channelArrayList, Context context) {
        this.channelArrayList = channelArrayList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return channelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return channelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;

        if (convertView == null) {

            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.tslistitem,null);


            vh.tslistimg = (ImageView) convertView.findViewById(R.id.tslistimg);
            vh.tslisttv = (TextView) convertView.findViewById(R.id.tslisttv);

            convertView.setTag(vh);

        }

        else {

            vh = (ViewHolder) convertView.getTag();

        }



        Channel channel = channelArrayList.get(position);

        vh.tslisttv.setText(channel.getName());


        Picasso.with(context)
                .load(channel.getImgUrl())
                .error(R.mipmap.ic_launcher)
                .config(Bitmap.Config.RGB_565)
                .into(vh.tslistimg);












        return convertView;
    }

    class ViewHolder{
        ImageView tslistimg;
        TextView tslisttv;

    }
}
