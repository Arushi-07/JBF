package com.appiqo.jbf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appiqo.jbf.views.fragments.CreditCardFragment;
import com.appiqo.jbf.views.fragments.NetBankingFragment;

/**
 * Created by arushi on 6/23/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "Card", "Credit/Debit Card", "Net Banking","Cash On Delivery" };
    private Fragment fragments[]=new Fragment[]{new CreditCardFragment(),new NetBankingFragment(),new NetBankingFragment(),new NetBankingFragment(),};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}