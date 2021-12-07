package com.moringaschool.android_ip_1.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ListAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mArrayOfItems;

    public ListAdapter(Context mContext,  int resource, String[] mArrayOfItems) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mArrayOfItems = mArrayOfItems;
    }
    @Override
    public Object getItem(int position) {
        String itemFromArray = mArrayOfItems[position];
        return String.format("%s, \n Are these the droids you're looking for?", itemFromArray);
    }

    @Override
    public int getCount() {
        return mArrayOfItems.length;
    }
}
