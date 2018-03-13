package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.helper.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arushi on 8/6/17.
 */

public class AddressViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Address> mDataSet = new ArrayList<>();
    private LayoutInflater mInflater;
    int defaultAddress=0;
    Context context;
    GestureDetector gestureDetector;
    public AddressViewPagerAdapter(Context context, List<Address> dataSet) {
        mDataSet = dataSet;
        mInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.address_list, parent, false);
        return new AddressViewPagerAdapter.itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final AddressViewPagerAdapter.itemViewHolder itemViewHolder = (AddressViewPagerAdapter.itemViewHolder)holder;
        bind(itemViewHolder,position);
        if(mDataSet.get(position).getDef()==1) {
            itemViewHolder.checked.setVisibility(View.VISIBLE);
        }
        else
        {
            itemViewHolder.checked.setVisibility(View.INVISIBLE);

        }

        itemViewHolder.address_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  itemViewHolder.checked.setVisibility(View.VISIBLE);
                defaultAddress=position;
                mDataSet.get(position).setDef(1);
                for(int i=0;i<mDataSet.size();i++)
                {
                    if(i!=defaultAddress)
                        mDataSet.get(i).setDef(0);
                    else
                        mDataSet.get(i).setDef(1);


                }
                notifyDataSetChanged();

             }
            }
        );
        itemViewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        itemViewHolder.newAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void bind(itemViewHolder itemViewHolder,int position) {
        itemViewHolder.name.setText(mDataSet.get(position).getName());
        itemViewHolder.line1.setText(mDataSet.get(position).getLine1());
        itemViewHolder.line2.setText(mDataSet.get(position).getLine2());
        itemViewHolder.line3.setText(mDataSet.get(position).getLine3());
        itemViewHolder.line4.setText(mDataSet.get(position).getLine4());
        itemViewHolder.line5.setText(mDataSet.get(position).getLine5());
        itemViewHolder.contact.setText(mDataSet.get(position).getContactNo());
        itemViewHolder.cod.setText(mDataSet.get(position).getCod());
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }

    private static class itemViewHolder extends RecyclerView.ViewHolder {
        TextView line1,line2,line3,line4,line5,contact,name,cod;
        ImageView checked;
        LinearLayout address_root;
        Button edit,newAddress;
        public itemViewHolder(View view) {
            super(view);
            init(view);


        }

        private void init(View view) {

            name=(TextView)view.findViewById(R.id.address_name);
            line1=(TextView)view.findViewById(R.id.address_line1);
            line2=(TextView)view.findViewById(R.id.address_line2);
            line3=(TextView)view.findViewById(R.id.address_line3);
            line4=(TextView)view.findViewById(R.id.address_line4);
            line5=(TextView)view.findViewById(R.id.address_line5);
            contact=(TextView)view.findViewById(R.id.address_contact);
            cod=(TextView)view.findViewById(R.id.cod_availability);
            checked=(ImageView)view.findViewById(R.id.default_address);
            address_root=(LinearLayout)view.findViewById(R.id.address_root);
            edit=(Button)view.findViewById(R.id.edit_address);
            newAddress=(Button)view.findViewById(R.id.addNewAddress);
        }
    }


}
