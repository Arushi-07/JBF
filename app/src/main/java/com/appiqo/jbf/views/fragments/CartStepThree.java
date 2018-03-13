package com.appiqo.jbf.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.views.activities.HomeHandler;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartStepThree extends Fragment {

    View view;
    PagerSlidingTabStrip  pagerSlidingTabStrip;
    ViewPager viewPager;
    LinearLayout pay;
    TextView payAmount;

    public CartStepThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cart_step_three, container, false);
        init();
        setupViewPager(viewPager);
        pagerSlidingTabStrip.setViewPager(viewPager);

        payAmount.setText("$100");
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeHandler)getContext()).changeContainer("OrderDetails",new CartStepThree(),"ORDER DETAILS");
            }
        });

        return view;
    }
    public void init()
    {
        viewPager=(ViewPager)view.findViewById(R.id.view_pager);
        pagerSlidingTabStrip=(PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pay=(LinearLayout)view.findViewById(R.id.pay);
        payAmount=(TextView)view.findViewById(R.id.pay_amount);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new NetBankingFragment(),"Card");
        adapter.addFrag(new CreditCardFragment(),"Credit/Debit Card");
        adapter.addFrag(new NetBankingFragment(),"Net Banking");
        adapter.addFrag(new NetBankingFragment(),"Cash On Delivery");
        viewPager.setAdapter(adapter);
    }

     static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }


    }


}
