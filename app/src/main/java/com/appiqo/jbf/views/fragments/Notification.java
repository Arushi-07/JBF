package com.appiqo.jbf.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appiqo.jbf.R;
import com.appiqo.jbf.adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.List;
/*
 * A simple {@link Fragment} subclass.
 */
public class Notification extends Fragment {

    View view;
    RecyclerView recyclerView;
    NotificationAdapter notificationAdapter;

    public Notification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_notification, container, false);
        init();
        return view;
    }

    private void init() {

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        notificationAdapter = new NotificationAdapter(getActivity().getApplicationContext(), createList(10));
        recyclerView.setAdapter(notificationAdapter);
    }

    private List<String> createList(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add("View " + i);
        }

        return list;
    }
}
