package com.hnq40.myapplication.tuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hnq40.myapplication.R;
public class T12MainActivity extends AppCompatActivity {
    EditText txt1,txt2;//khai bao bien
    Button btn1;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t12_main);
        //anh xa
        txt1=findViewById(R.id.t11Txt1);
        txt2=findViewById(R.id.t11Txt2);
        btn1=findViewById(R.id.t11BtnTT);
        tv1=findViewById(R.id.t11TvKQ1);
        //xu ly su kien
        btn1.setOnClickListener((v)->{
            //goi ham
            if(txt1.getText().equals("")|| txt2.getText().equals(""))
            {
                tv1.setText("Khong duoc de trong");
                return;
            }
            else
            {
                TinhTong();
            }



        });

    }
    void TinhTong()
    {
        //lay du lieu nguoi dung nhap vao o 1, chuyen sang so
        float so1= Float.parseFloat(txt1.getText().toString());
        //lay du lieu tu nguoi dung nhap vao o 2, chuyen sang so
        float so2=Float.parseFloat(txt2.getText().toString());
        float tong=so1+so2;//tinh tong
        //dua ket qua len man hinh
        tv1.setText(String.valueOf(tong));
    }
}