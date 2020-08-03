package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home6);
        Intent intent=getIntent();
        TextView tv=findViewById(R.id.tv);
        tv.setText("Final Score: "+String.valueOf(intent.getIntExtra("score",0))+"/5");

    }
}