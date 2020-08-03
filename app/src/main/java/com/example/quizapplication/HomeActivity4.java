package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.quizapplication.R.color.green;
import static com.example.quizapplication.R.color.red;

public class HomeActivity4 extends AppCompatActivity {
    int score=0;
    Button button,button2,button3,next;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);
        button= findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        next=findViewById(R.id.next);
        tv=findViewById(R.id.textView4);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("Didn’t you watch \"The Walking Dead\"? When the power goes out, ATMs and banks are down for the count. Have extra cash on hand before the storm; otherwise, you won’t have any way to pay for necessities.");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.parseColor("#45CE30"));
                tv.setText("Didn’t you watch \"The Walking Dead\"? When the power goes out, ATMs and banks are down for the count. Have extra cash on hand before the storm; otherwise, you won’t have any way to pay for necessities.");
                score+=1;


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("Didn’t you watch \"The Walking Dead\"? When the power goes out, ATMs and banks are down for the count. Have extra cash on hand before the storm; otherwise, you won’t have any way to pay for necessities.");


            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity4.this,HomeActivity5.class);
                startActivity(intent);
            }
        });


    }
}

