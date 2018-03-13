package com.appiqo.jbf.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.appiqo.jbf.R;
import com.appiqo.jbf.adapter.CartAdapter;
import com.appiqo.jbf.views.activities.HomeHandler;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class CartStepOne extends Fragment {

    View view;
    public static RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List sizes;
    Spinner sizeSpinner;
    LinearLayout placeOrder;

    public CartStepOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart_step_one, container, false);
        init();

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((HomeHandler)getContext()).changeCartContainer("CartStepTwo","ADDRESSES",2,new CartStepTwo());
            }
        });

        return view;
    }


    private void init() {

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        cartAdapter = new CartAdapter(getActivity().getApplicationContext(), createList(10));
        recyclerView.setAdapter(cartAdapter);

       /* recyclerView.addOnItemTouchListener(new CartItemClickListener(getContext(), new CartItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                      //  Toast.makeText(getContext(), "position = " + position, Toast.LENGTH_SHORT).show();
                    }
                })
        );*/
        placeOrder=(LinearLayout)view.findViewById(R.id.placeOrder);
    }

    private List<String> createList(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add("View " + i);
        }

        return list;
    }

}
