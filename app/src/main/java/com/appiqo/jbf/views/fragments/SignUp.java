package com.appiqo.jbf.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.views.activities.LoginHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    View view;
    TextView acc;

    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        init();
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginHandler)getContext()).changeFragment("SignIn",new SignIn());
            }
        });
        return view;
    }
    public void init()
    {
       acc=(TextView)view.findViewById(R.id.acc);
    }

}
