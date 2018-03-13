package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.helper.CardDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arushi on 8/17/17.
 */

public class CardRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CardDetails> mDataSet = new ArrayList<>();
    private LayoutInflater mInflater;
    int defaultAddress=0;
    Context context;
    GestureDetector gestureDetector;
    public CardRecyclerAdapter(Context context, List<CardDetails> dataSet) {
        mDataSet = dataSet;
        mInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_layout, parent, false);
        return new CardRecyclerAdapter.itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CardRecyclerAdapter.itemViewHolder itemViewHolder = (CardRecyclerAdapter.itemViewHolder)holder;
        bind(itemViewHolder,position);


    }

    private void bind(CardRecyclerAdapter.itemViewHolder itemViewHolder, int position) {
        itemViewHolder.holder_name.setText( mDataSet.get(position).getCardHolderName());
        itemViewHolder.no1.setText(mDataSet.get(position).getCardNo1());
        itemViewHolder.no2.setText(mDataSet.get(position).getCardNo2());
        itemViewHolder.no3.setText(mDataSet.get(position).getCardNo3());
        itemViewHolder.no4.setText(mDataSet.get(position).getCardNo4());
        itemViewHolder.validFrom.setText(mDataSet.get(position).getValid_from());
        itemViewHolder.validTo.setText(mDataSet.get(position).getValid_to());
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }

    private static class itemViewHolder extends RecyclerView.ViewHolder {

        TextView no1,no2,no3,no4,holder_name,validFrom,validTo;
        public itemViewHolder(View view) {
            super(view);
            init(view);


        }

        private void init(View view) {

            no1=(TextView)view.findViewById(R.id.cardNo1);
            no2=(TextView)view.findViewById(R.id.cardNo2);
            no3=(TextView)view.findViewById(R.id.cardNo3);
            no4=(TextView)view.findViewById(R.id.cardNo4);
            holder_name=(TextView)view.findViewById(R.id.card_holder_name);
            validFrom=(TextView)view.findViewById(R.id.valid_from);
            validTo=(TextView)view.findViewById(R.id.valid_to);

        }
    }


}
