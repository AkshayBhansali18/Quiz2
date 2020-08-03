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

public class HomeActivity5 extends AppCompatActivity {
    int score=0;
    Button button,button2,button3,next;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home5);
        button= findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
//        next=findViewById(R.id.next);
        tv=findViewById(R.id.textView4);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button.setBackgroundColor(Color.parseColor("#45CE30"));

                tv.setText("you should have enough food to last three days. Of course, it couldn't hurt to have extra beyond this.");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("you should have enough food to last three days. Of course, it couldn't hurt to have extra beyond this.");
                score+=1;


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("You should have enough food to last three days. Of course, it couldn't hurt to have extra beyond this.");


            }
        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent=new Intent(HomeActivity5.this,HomeActivity6.class);
////                startActivity(intent);
//            }
//        });


    }
}

