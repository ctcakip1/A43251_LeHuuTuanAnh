package com.hnq40.myapplication.OrderFood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hnq40.myapplication.R;

public class SignIn_Out extends AppCompatActivity {
    Button btnSignIn, btnSignUp;
    TextView txtSlogan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_out);
        btnSignIn = (Button) findViewById(R.id.btnSignin);
        btnSignUp = (Button) findViewById(R.id.btnSignup);
        txtSlogan = (TextView) findViewById(R.id.txtslogan);

        btnSignIn.setOnClickListener((v) -> {

        });
        btnSignUp.setOnClickListener((v) -> {

        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(SignIn_Out.this, SignUp.class);
                startActivity(signUp);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(SignIn_Out.this, Signin.class);
                startActivity(signIn);
            }
        });
    }
}