package com.hnq40.myapplication.tuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

import com.hnq40.myapplication.R;

import java.util.ArrayList;

public class T3ac2MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<T3Contact> ls = new ArrayList<>();
    T32Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t3ac2_main);
        gridView=findViewById(R.id.demo32Gridview);
        ls.add(new T3Contact("NguyenVanA",22, R.drawable.dell));
        ls.add(new T3Contact("NguyenVanB",23, R.drawable.chrome));
        ls.add(new T3Contact("NguyenVanC",24, R.drawable.facebook));
        ls.add(new T3Contact("NguyenVanC",25, R.drawable.hp));
        adapter = new T32Adapter(this, ls);
        gridView.setAdapter(adapter);
    }
}