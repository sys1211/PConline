package com.example.tf.pconline.Adapter;

import android.content.Context;
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
 * Created by le on 2017/6/10.
 */

public class RJListAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Channel> arrayList;


    public RJListAdapter(Context context, ArrayList<Channel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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
            convertView = inflater.inflate(R.layout.toutiaolist__dot4,null);

            vh.list_tvrj = (TextView) convertView.findViewById(R.id.list_tvrj);
            vh.list_dot1image = (ImageView) convertView.findViewById(R.id.list_dot1image);


            convertView.setTag(vh);

        }else{

            vh = (ViewHolder) convertView.getTag();

        }


        Channel channel = arrayList.get(position);
        vh.list_tvrj.setText(channel.getName());
        Picasso.with(context)
                .load(channel.getImgUrl())
                .into(vh.list_dot1image);




        return convertView;
    }



    class ViewHolder {
        TextView list_tvrj;
        ImageView list_dot1image;
    }
}
