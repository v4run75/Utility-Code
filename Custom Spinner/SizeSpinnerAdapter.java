package com.webpulse.ecommerce.Product.SortAndFilter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.webpulse.ecommerce.R;
import com.webpulse.ecommerce.Server.Response.SizeResponseData;

import java.util.ArrayList;

public class SizeSpinnerAdapter extends ArrayAdapter<SizeResponseData> {

    private final ArrayList<SizeResponseData> item;
    private final LayoutInflater mInflater;
    private final Context mContext;
    private final int mResource;

    public SizeSpinnerAdapter(@NonNull Context context, int resource, ArrayList<SizeResponseData> items) {
        super(context, resource, items);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        item = items;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public SizeResponseData getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String getSizeId(int position) {
        return item.get(position).getSizeId();
    }

    public String getSizeName(int position) {
        return item.get(position).getSizeName();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        TextView offTypeTv = view.findViewById(R.id.title);

        SizeResponseData offerData = item.get(position);

        offTypeTv.setText(offerData.getSizeName());

        return view;
    }


}