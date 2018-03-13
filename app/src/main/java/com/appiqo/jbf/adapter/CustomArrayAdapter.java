package com.appiqo.jbf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appiqo.jbf.R;

import java.util.ArrayList;

/**
 * Created by arushi on 7/7/17.
 */

public class CustomArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private ArrayList<String> values;
    TextView textView;
    View rowView;

    public CustomArrayAdapter(Context context, ArrayList<String> values) {
        super(context,-1,values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(R.layout.search_list, parent, false);
        textView = (TextView) rowView.findViewById(R.id.search_name);
        textView.setText(values.get(position));



        return rowView;
    }

    public void setBackground(int position) {

       /* TextView selected=(TextView)rowView.findViewWithTag(position);
        Toast.makeText(context, "selected = " + selected.getText(), Toast.LENGTH_SHORT).show();
*/
    }
}
