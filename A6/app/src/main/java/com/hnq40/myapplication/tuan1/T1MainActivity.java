package com.hnq40.myapplication.tuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hnq40.myapplication.R;
public class T1MainActivity extends AppCompatActivity {
    Button btn1;//khai bao control
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1_main);
        btn1=findViewById(R.id.t11Btn2);//anh xa control
        tv1=findViewById(R.id.t11TvKQ);
        btn1.setOnClickListener((v)->{//xu ly su kien
            //hien thi text
            tv1.setText("Xin chao cac ban sinh vien DHTL");
        });
    }
}