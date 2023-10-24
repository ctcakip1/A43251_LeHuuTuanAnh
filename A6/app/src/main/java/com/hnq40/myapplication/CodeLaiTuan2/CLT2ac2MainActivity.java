package com.hnq40.myapplication.CodeLaiTuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hnq40.myapplication.R;

public class CLT2ac2MainActivity extends AppCompatActivity {
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clt2ac2_main);
        tv1 = findViewById(R.id.clt2ac2tv1);
        Intent intent1 = getIntent();
        String chuoi1 = intent1.getExtras().getString("so1");
        String chuoi2 = intent1.getExtras().getString("so2");
        float so1 = Float.parseFloat(chuoi1);
        float so2 = Float.parseFloat(chuoi2);
        float tong = so1 + so2;
        tv1.setText(String.valueOf(tong));
    }
}