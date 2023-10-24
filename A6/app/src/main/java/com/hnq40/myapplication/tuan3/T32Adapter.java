package com.hnq40.myapplication.tuan3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hnq40.myapplication.R;

import java.util.ArrayList;

public class T32Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<T3Contact> ls;

    public T32Adapter(Context context, ArrayList<T3Contact> ls) {
        this.context = context;
        this.ls = ls;
    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = LayoutInflater.from(context).inflate(R.layout.demo32_item_view, null);
        ImageView imageView = convertView.findViewById(R.id.demo32_item_hinh);
        imageView.setImageResource(ls.get(position).getHinh());
        return convertView;

    }
}
