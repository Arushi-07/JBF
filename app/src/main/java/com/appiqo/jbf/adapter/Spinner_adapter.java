package com.appiqo.jbf.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appiqo.jbf.R;

import java.util.List;

/**
 * Created by arushi on 6/15/17.
 */

public class Spinner_adapter extends ArrayAdapter<String> {


    Context context;
    List<String> spinnerValues;
    public Spinner_adapter(@NonNull Context context, @LayoutRes int resource) {

        super(context, resource);
        this.context=context;
    }

    public Spinner_adapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
        this.context=context;
    }

    public Spinner_adapter(@NonNull Context context, @LayoutRes int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.context=context;

    }

    public Spinner_adapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull String[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
    }

    public Spinner_adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.spinnerValues=objects;
    }

    @Override
    public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
        return getCustomView(position, cnvtView, prnt);
    }
    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt) {
        return getCustomView(pos, cnvtView, prnt);
    }


    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mySpinner = inflater.inflate(R.layout.spinner_layout, parent,
                false);

        TextView subSpinner = (TextView) mySpinner
                .findViewById(R.id.size);
        subSpinner.setText(spinnerValues.get(position));

      /*  ImageView left_icon = (ImageView) mySpinner
                .findViewById(R.id.left_pic);
        left_icon.setImageResource(total_images[position]);
*/
        return mySpinner;
    }
}



