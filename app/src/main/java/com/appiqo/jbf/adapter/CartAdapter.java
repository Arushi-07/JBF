package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.views.fragments.CartStepOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arushi on 8/3/17.
 */

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    Context context;
    private List<String> mDataSet = new ArrayList<>();
    private LayoutInflater mInflater;
    List sizes;


    public CartAdapter(Context context, List<String> dataSet) {
        this.context=context;
        mDataSet = dataSet;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cart_list, parent, false);
        view.setOnClickListener(this);
      /*  init(view);
        createSize();
        sizeSpinner.setAdapter(new Spinner_adapter(context,R.layout.spinner_layout,sizes));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cloth_count.setText((Integer.parseInt((cloth_count.getText()).toString()))+1);
            }
        });

        reduceItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt((cloth_count.getText()).toString())>0)
                    cloth_count.setText((Integer.parseInt((cloth_count.getText()).toString()))-1);
            }
        });*/
        return new CartAdapter.itemViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CartAdapter.itemViewHolder itemViewHolder = (CartAdapter.itemViewHolder)holder;
        itemViewHolder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemViewHolder.cloth_count.setText((Integer.parseInt((itemViewHolder.cloth_count.getText()).toString()))+1 + "");
            }
        });

        itemViewHolder.reduceItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt((itemViewHolder.cloth_count.getText()).toString())>0)
                    itemViewHolder.cloth_count.setText((Integer.parseInt((itemViewHolder.cloth_count.getText()).toString()))-1+"");
            }
        });

        createSize();
        itemViewHolder.sizeSpinner.setAdapter(new Spinner_adapter(context,R.layout.spinner_layout,sizes));

    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }

    @Override
    public void onClick(View v) {
        int itemPosition = CartStepOne.recyclerView.getChildLayoutPosition(v);
       // String item = mList.get(itemPosition);
        Log.e("position click",""+itemPosition);
    }
    private void createSize() {
        sizes=new ArrayList<String>();
        sizes.add("XS");
        sizes.add("S");
        sizes.add("M");
        sizes.add("L");
        sizes.add("XL");
        sizes.add("XXL");
    }

    private static class itemViewHolder extends RecyclerView.ViewHolder {

        Spinner sizeSpinner;
        TextView cloth_count;
        ImageView addItem,reduceItem;

        public itemViewHolder(View view) {
            super(view);
            init(view);


        }
        private void init(View view) {
            sizeSpinner=(Spinner)view.findViewById(R.id.cloth_size);
            cloth_count=(TextView)view.findViewById(R.id.cloth_count);
            addItem=(ImageView)view.findViewById(R.id.add_item);
            reduceItem=(ImageView)view.findViewById(R.id.reduce_item);
        }




    }




}