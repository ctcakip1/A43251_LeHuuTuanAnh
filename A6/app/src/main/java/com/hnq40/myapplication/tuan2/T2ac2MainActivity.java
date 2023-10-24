package com.hnq40.myapplication.tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hnq40.myapplication.R;
public class T2ac2MainActivity extends AppCompatActivity {
    TextView tvKQ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2ac2_main);
        tvKQ=findViewById(R.id.demo2Ac2Tv1);
        //b4- Don intent tu Ac1
        Intent intent1=getIntent();
        //b5- lay du lieu
        String chuoi1=intent1.getExtras().getString("so1");
        String chuoi2=intent1.getExtras().getString("so2");
        //chuyen du lieu sang so
        float so1= Float.parseFloat(chuoi1);
        float so2=Float.parseFloat(chuoi2);
        float tong=so1+so2;
        tvKQ.setText(String.valueOf(tong));
    }
}