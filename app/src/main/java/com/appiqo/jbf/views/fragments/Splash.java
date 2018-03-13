package com.appiqo.jbf.views.fragments;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.views.activities.LoginHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class Splash extends Fragment {

    View view;

    public Splash() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_splash, container, false);


        final ImageView backgroundOne = (ImageView) view.findViewById(R.id.scroll);
        final ImageView backgroundTwo = (ImageView) view.findViewById(R.id.scroll1);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight();
                final float translationY = height * progress;
                backgroundOne.setTranslationY((-1)*(translationY));
                backgroundTwo.setTranslationY((-1)*(translationY - height));
            }
        });
        animator.start();


        Handler handler=new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // getActivity().startActivity(new Intent(getContext(),LoginHandler.class));
                // getActivity().finish();

                ((LoginHandler)getContext()).changeFragment("SignIn",new SignIn());


            }
        },2000);

        return view;
    }

}
