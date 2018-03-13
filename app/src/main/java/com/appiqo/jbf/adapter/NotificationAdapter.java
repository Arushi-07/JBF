package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appiqo.jbf.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arushi on 8/2/17.
 */

public class NotificationAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mDataSet = new ArrayList<>();
    private LayoutInflater mInflater;
    public NotificationAdapter(Context context, List<String> dataSet) {
        mDataSet = dataSet;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.notification_list, parent, false);
        return new NotificationAdapter.itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NotificationAdapter.itemViewHolder itemViewHolder = (NotificationAdapter.itemViewHolder)holder;
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }

    private static class itemViewHolder extends RecyclerView.ViewHolder {
        public itemViewHolder(View view) {
            super(view);

        }
    }
}