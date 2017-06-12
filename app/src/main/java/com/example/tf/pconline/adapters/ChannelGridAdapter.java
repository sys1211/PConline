package com.example.tf.pconline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tf.pconline.R;
import com.example.tf.pconline.domain.Channel;

import java.util.ArrayList;

/**
 * Created by le on 2017/6/8.
 */

public class ChannelGridAdapter extends BaseAdapter{
    private ArrayList<Channel> channelArrayList;
    private Context context;
    private LayoutInflater inflater;

    public ChannelGridAdapter(ArrayList<Channel> channelArrayList, Context context) {
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
            convertView = inflater.inflate(R.layout.channelitem,null);

            vh.imageView = (ImageView) convertView.findViewById(R.id.channelimg);
            vh.imgdelete = (ImageView) convertView.findViewById(R.id.imgdelete);
            vh.textView = (TextView) convertView.findViewById(R.id.channeltv);
            convertView.setTag(vh);

        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        Channel channel = channelArrayList.get(position);
        vh.textView.setText(channel.getName());
        vh.imgdelete.setVisibility(View.GONE);
        vh.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView,imgdelete;

        TextView textView;

    }
}
