package com.example.e3.myapplication3;

/**
 * Created by e3 on 13/06/2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class lstAdapter extends ArrayAdapter<String> {
    int groupid;
    String[] item_list;
    ArrayList<String> desc;
    Context context;

    public lstAdapter(Context context, int vg, int id, String[] item_list) {
        super(context, vg, id, item_list);
        this.context = context;
        groupid = vg;
        this.item_list = item_list;
    }

    // Hold views of the ListView to improve its scrolling performance
    static class ViewHolder {
        public TextView textname;
        public TextView textprice;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // Inflate the rowlayout.xml file if convertView is null
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textname = (TextView) rowView.findViewById(R.id.txtname);
            viewHolder.textprice = (TextView) rowView.findViewById(R.id.txtprice);
            rowView.setTag(viewHolder);
        }
        // Set text to each TextView of ListView item
        String[] items = item_list[position].split("__");
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textname.setText(items[0]);
        holder.textprice.setText(items[1]);
        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.rgb(213, 229, 241));
        } else {
            rowView.setBackgroundColor(Color.rgb(255, 255, 255));
        }

        return rowView;
    }
}
