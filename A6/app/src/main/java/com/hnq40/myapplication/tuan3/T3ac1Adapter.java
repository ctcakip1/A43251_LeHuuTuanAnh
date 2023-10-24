package com.hnq40.myapplication.tuan3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hnq40.myapplication.R;

import java.util.ArrayList;

public class T3ac1Adapter extends BaseAdapter {
    private Context context;
    ArrayList<T3Contact> ls;
    // khoi tao
    public T3ac1Adapter(Context context, ArrayList<T3Contact> ls) {
        this.context = context;
        this.ls = ls;
    }

    //tong item
    @Override
    public int getCount() {
        return ls.size();
    }
    //tra ve 1 item theo vi tri
    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }
    // lay ve id cua item
    @Override
    public long getItemId(int position) {
        return position;
    }
    // tao view = tao layout + gan du lieu
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // 1.tao layout
        ViewAnhXa vax;
        if(convertView==null)// neu chua co view thi tao view moi
        {
            vax = new ViewAnhXa();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_t3ac1_main, null);
            vax.img_hinh= convertView.findViewById(R.id.demo31_item_hinh);
            vax.tv_ten= convertView.findViewById(R.id.demo31_item_ten);
            vax.tv_tuoi= convertView.findViewById(R.id.demo31_item_tuoi);
            // tao template de lan sau su dung
            convertView.setTag(vax);
        }
        else // neu ton tai view tu truoc thi lay ra su dung
        {
            vax =(ViewAnhXa) convertView.getTag();
        }
        // 2. gan du lieu
        vax.img_hinh.setImageResource(ls.get(position).getHinh());
        vax.tv_ten.setText(ls.get(position).getTen());
        vax.tv_tuoi.setText(ls.get(position).getTuoi());
        return convertView;
    }
    public class ViewAnhXa
    {
        public ImageView img_hinh;
        public TextView tv_ten;
        public TextView tv_tuoi;

    }
}
