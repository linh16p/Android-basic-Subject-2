package com.example.mycountrylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Country> {
    Context context;
    ArrayList<Country> arrayList;
    int layoutResource;

    // khoi tao ham
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<Country> objects) {
        super(context, resource,objects);
        this.context = context;
        this.arrayList = objects;
        this.layoutResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource,null);
        // ham khoi tao
        TextView txt1 = (TextView)convertView.findViewById(R.id.tv);
        txt1.setText(arrayList.get(position).getName());

        TextView txt2 = (TextView)convertView.findViewById(R.id.tv1);
        txt2.setText(arrayList.get(position).getName());

        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        img.setImageResource(arrayList.get(position).getImg());

        return convertView;
    }
}
