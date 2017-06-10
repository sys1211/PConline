package com.example.tf.pconline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tf.pconline.R;
import com.example.tf.pconline.domain.Channel;
import com.example.tf.pconline.domain.NumClick;
import com.example.tf.pconline.helper.OnDragVHListener;
import com.example.tf.pconline.helper.OnItemMoveListener;
import com.example.tf.pconline.views.CustomRecyclerView;

import java.util.ArrayList;

/**
 * Created by le on 2017/6/8.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> implements View.OnClickListener, View.OnLongClickListener,OnItemMoveListener {

    private RecyclerViewOnItemClickListener onItemClickListener;
    private RecyclerViewOnItemLongClickListener onItemLongClickListener;


    private ArrayList<Channel> channelArrayList;
    private Context context;
    private onclickListener onclickListener;
    private LayoutInflater inflater;
    private CustomRecyclerView recyclerView;
    private ArrayList<NumClick> numClickArrayList;
    public ChannelAdapter(ArrayList<NumClick> numClickArrayList,ArrayList<Channel> channelArrayList, Context context,onclickListener onclickListener,CustomRecyclerView recyclerView) {
        this.channelArrayList = channelArrayList;
        this.context = context;
        this.onclickListener = onclickListener;
        this.recyclerView = recyclerView;
        this.numClickArrayList = numClickArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.channelitem,null);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new MyViewHolder(view);
    }




    public interface onclickListener{
        public void onclicklistener(int postion);
        public void onclicklonglistener(int postion);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Channel channel = channelArrayList.get(position);
        holder.textView.setText(channel.getName());
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        holder.itemView.setTag(position);
        NumClick numClick = numClickArrayList.get(0);
        if (numClick.getNum()%2==0) {

            holder.imgdelete.setVisibility(View.GONE);
        }else{

            holder.imgdelete.setVisibility(View.VISIBLE);
        }
    }




    /**
     * 拖拽排序相关
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Channel channel = channelArrayList.get(fromPosition);
        channelArrayList.remove(fromPosition);
        channelArrayList.add(toPosition, channel);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            onItemClickListener.onItemClickListener(v, (Integer) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return onItemLongClickListener != null && onItemLongClickListener.onItemLongClickListener(v, (Integer) v.getTag());
    }

    /*设置点击事件*/
    public void setRecyclerViewOnItemClickListener(RecyclerViewOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /*设置长按事件*/
    public void setOnItemLongClickListener(RecyclerViewOnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public interface RecyclerViewOnItemClickListener {

        void onItemClickListener(View view, int position);

    }

    public interface RecyclerViewOnItemLongClickListener {

        boolean onItemLongClickListener(View view, int position);

    }






















    @Override
    public int getItemCount() {

        return channelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements OnDragVHListener {
        TextView textView;
        ImageView imageView,imgdelete;
        private View itemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.channelimg);
            textView = (TextView) itemView.findViewById(R.id.channeltv);
            imgdelete = (ImageView) itemView.findViewById(R.id.imgdelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int postion=recyclerView.getChildPosition(view);
                    onclickListener.onclicklistener(postion);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int postion=recyclerView.getChildPosition(view);
                    onclickListener.onclicklonglistener(postion);
                    return true;
                }
            });
        }

        @Override
        public void onItemSelected() {

        }

        @Override
        public void onItemFinish() {

        }
    }
}
