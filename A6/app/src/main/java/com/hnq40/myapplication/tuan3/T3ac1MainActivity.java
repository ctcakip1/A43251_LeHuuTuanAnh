package com.hnq40.myapplication.tuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.hnq40.myapplication.R;

import java.util.ArrayList;

public class T3ac1MainActivity extends AppCompatActivity {
    ListView ListView;

    ArrayList<T3Contact> ls = new ArrayList<>();
    T3ac1Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t3ac1_main);
        ListView = findViewById(R.id.t3ac1lv1);
        ls.add(new T3Contact("Nguyen van a", 22, R.drawable.android));
        ls.add(new T3Contact("Nguyen van b", 23, R.drawable.apple));
        ls.add(new T3Contact("Nguyen van c", 24, R.drawable.firefox));
        adapter =new T3ac1Adapter(this, ls);
        ListView.setAdapter(adapter);
    }
}