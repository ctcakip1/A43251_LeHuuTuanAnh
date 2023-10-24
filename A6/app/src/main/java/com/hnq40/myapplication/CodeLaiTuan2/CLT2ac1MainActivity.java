package com.hnq40.myapplication.CodeLaiTuan2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hnq40.myapplication.R;

public class CLT2ac1MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clt2ac1_main);
        et1 = findViewById(R.id.clt2ac1et1);
        et2 = findViewById(R.id.clt2ac1et2);
        btn1 = findViewById(R.id.clt2ac1btn1);
        btn1.setOnClickListener((v)->{
            Intent intent = new Intent(CLT2ac1MainActivity.this,
                    CLT2ac2MainActivity.class);
            intent.putExtra("so1", et1.getText()).toString();
            intent.putExtra("so2", et2.getText()).toString();
            startActivity(intent);
        });
    }
}