package com.appiqo.jbf.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.adapter.AddressViewPagerAdapter;
import com.appiqo.jbf.helper.Address;
import com.appiqo.jbf.views.activities.HomeHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartStepTwo extends Fragment {


    View view;
    RecyclerView addresses;
    TextView addressCount;
    AddressViewPagerAdapter addressViewPagerAdapter;
    TextView placeOrder;

    public CartStepTwo() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cart_step_two, container, false);
        init();

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeHandler)getContext()).changeCartContainer("CartStepThree","PAYMENT",3,new CartStepThree());
            }
        });
        return view;
    }

    private void init() {
        addressCount=(TextView)view.findViewById(R.id.addressCount);
        addresses=(RecyclerView)view.findViewById(R.id.address_recyclerView);
        addresses.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        createAddressList();
        addressViewPagerAdapter =new AddressViewPagerAdapter(getContext(),createAddressList());
        addresses.setAdapter(addressViewPagerAdapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(addresses);
        placeOrder=(TextView)view.findViewById(R.id.address_placeOrder);
    }


    private List<Address> createAddressList() {
        ArrayList<Address> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Address a1=new Address();
            a1.setName("name");
            a1.setLine1("line1");
            a1.setLine2("line2");
            a1.setLine3("line3");
            a1.setLine4("line4");
            a1.setLine5("line5");
            a1.setContactNo("1234567891");
            a1.setCod("COD available");
            list.add(a1);
        }
        return list;
    }


}
