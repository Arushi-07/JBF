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
 * Created by Warlock on 7/1/2017.
 */

public class BestSellingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mDataSet = new ArrayList<>();
    private LayoutInflater mInflater;
    public BestSellingsAdapter(Context context, List<String> dataSet) {
        mDataSet = dataSet;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.best_selling_list, parent, false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final itemViewHolder itemViewHolder = (itemViewHolder)holder;
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