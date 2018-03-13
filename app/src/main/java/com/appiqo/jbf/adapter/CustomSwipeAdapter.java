package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.appiqo.jbf.R;

import java.util.ArrayList;


public class CustomSwipeAdapter extends PagerAdapter {
    private ArrayList<Integer> image_resource;
    private Context ctx;
    private LayoutInflater layoutInflater;
    String names[];

    public CustomSwipeAdapter(Context ctx , ArrayList<Integer> img) {
        this.ctx = ctx;
        this.image_resource =img;

    }

    @Override
    public int getCount() {
        return image_resource.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View item_view = layoutInflater.inflate(R.layout.pager_layout, container, false);
        ImageView imageview = (ImageView) item_view.findViewById(R.id.offer);
        imageview.setColorFilter(ContextCompat.getColor(ctx,R.color.tintColor));
        imageview.setImageResource(image_resource.get(position));

        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
