package com.hnq40.myapplication.tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hnq40.myapplication.R;
public class T2ac1MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2ac1_main);
        txt1=findViewById(R.id.demo2Ac1Txt1);
        txt2=findViewById(R.id.demo2Ac1Txt2);
        btn1=findViewById(R.id.demo2Ac1Btn1);
        btn1.setOnClickListener((v)->{
            //b1- dinh huong van chuyen
            Intent intent=new Intent(T2ac1MainActivity.this,
                    T2ac2MainActivity.class);
            //b2- dua du lieu vao intent
            intent.putExtra("so1",txt1.getText().toString());
            intent.putExtra("so2",txt2.getText().toString());
            //b3- bat dau van chuyen
            startActivity(intent);
        });
    }
}