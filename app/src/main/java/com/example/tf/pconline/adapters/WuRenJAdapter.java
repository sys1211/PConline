package com.example.tf.pconline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tf.pconline.Datas.WurenJ;
import com.example.tf.pconline.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.tf.pconline.R.id.list_dot1image;

/**
 * Created by Administrator on 2017/6/12.
 */

public class WuRenJAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<WurenJ> arrayList;
    public WuRenJAdapter(Context context, ArrayList<WurenJ> arrayList) {
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
            vh.listwr_title = (TextView) convertView.findViewById(R.id.list_tvrj);

            vh.listwr_dot1image = (ImageView) convertView.findViewById(list_dot1image);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        WurenJ wrj = arrayList.get(position);
        vh.listwr_title.setText(wrj.getWRCtitle());
        vh.listwr_Message.setText(wrj.getWRMessage());
        Picasso.with(context)
                .load(wrj.getImage())
                .into(vh.listwr_dot1image);
        return convertView;
    }
    class ViewHolder {
        TextView listwr_title,listwr_Message;
        ImageView listwr_dot1image;
    }
}

