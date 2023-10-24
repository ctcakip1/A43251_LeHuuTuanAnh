package com.hnq40.myapplication.tuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hnq40.myapplication.R;

public class T4ac1MainActivity extends AppCompatActivity {
    Button btnGet;
    TextView tvKq;
    Context context = this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t4ac1_main);
        btnGet = findViewById(R.id.t4ac1btn1);
        tvKq = findViewById(R.id.t4ac1tv1);
        Volleyfn fn = new Volleyfn();
        btnGet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fn.getJSON_Array_Of_Objects(context,tvKq);
            }
        });

    }
}