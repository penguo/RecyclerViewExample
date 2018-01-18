package com.afordev.recyclerviewexample;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by penguo on 2018-01-17.
 */

public class RcvAdapter extends RecyclerView.Adapter<RcvAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<DataForm> dataList;

    public RcvAdapter(Activity activity, ArrayList<DataForm> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.item_iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.item_tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "click " + dataList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(activity, "remove " + dataList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    removeItemView(getAdapterPosition());
                    return false;
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        DataForm data = dataList.get(position);

        holder.tvName.setText(data.getName());

        switch(data.getImageNumber()){
            case 1:
                holder.ivIcon.setImageResource(R.drawable.ic_number_1);
                break;
            case 2:
                holder.ivIcon.setImageResource(R.drawable.ic_number_2);
                break;
            case 3:
                holder.ivIcon.setImageResource(R.drawable.ic_number_3);
                break;
            case 4:
                holder.ivIcon.setImageResource(R.drawable.ic_number_4);
                break;
        }
    }

    private void removeItemView(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataList.size()); // 지워진 만큼 다시 채워넣기.
    }
}
