package com.hnq40.myapplication.tuan2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hnq40.myapplication.R
class T2ac4MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t2ac4_main)
        var tv1=findViewById<TextView>(R.id.demo2Ac4Tv1);
        var intent1: Intent = getIntent()
        var chuoi1=intent1.getStringExtra("so1")
        var chuoi2=intent1.getStringExtra("so2")
        var so1: Float = chuoi1!!.toFloat()
        var so2: Float = chuoi2!!.toFloat()
        var tong=so1+so2
        tv1.setText(tong.toString())


    }
}