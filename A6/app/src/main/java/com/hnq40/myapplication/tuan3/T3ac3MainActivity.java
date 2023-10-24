package com.hnq40.myapplication.tuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hnq40.myapplication.R;

public class T3ac3MainActivity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t3ac3_main);
        spinner = findViewById(R.id.t3ac3spinner1);
        String[] item = {"item1", "item2", "item3", "item4","item5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item);
        spinner.setAdapter(adapter);



    }
}