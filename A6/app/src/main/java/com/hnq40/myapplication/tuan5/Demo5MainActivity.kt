package com.hnq40.myapplication.tuan5

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hnq40.myapplication.R

class Demo5MainActivity : AppCompatActivity() {
    var btnGetData: Button? = null
    var tvKq: TextView? = null
    var context: Context = this
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo5_main)
        btnGetData = findViewById(R.id.demo51btn1);
        tvKq = findViewById(R.id.demo51tvkq)
        var fn = VolleyKotlinFn()
        btnGetData!!.setOnClickListener{
            fn.getData(context,tvKq!!)
        }
    }
}