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

import com.appiqo.jbf.R;
import com.appiqo.jbf.adapter.CardRecyclerAdapter;
import com.appiqo.jbf.helper.CardDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditCardFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    CardRecyclerAdapter cardRecyclerAdapter;
    ArrayList<CardDetails> cardDetails;

    public CreditCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_credit_card, container, false);
        init();

        return view;
    }

    private void init() {
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        cardRecyclerAdapter=new CardRecyclerAdapter(getContext(),createList());
        recyclerView.setAdapter(cardRecyclerAdapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }

    private List<CardDetails> createList() {
        ArrayList<CardDetails> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CardDetails a1=new CardDetails();
            a1.setCardHolderName("PANDAV KISHAN R");
            a1.setCardNo1("9737");
            a1.setCardNo2("9737");
            a1.setCardNo3("9737");
            a1.setCardNo4("9737");
            a1.setValid_from("02/17");
            a1.setValid_to("08/36");
            list.add(a1);
        }
        return list;
    }

}
