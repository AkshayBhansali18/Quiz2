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

public class HomeActivity2 extends AppCompatActivity {
    int score=0;
    Button button,button2,button3,next;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
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
                tv.setText("For decades, many people believed that opening windows reduced pressure inside homes during tornadoes. But the theory doesn’t hold water, and actually, opening windows can let in high winds that may add more damage to the structure.");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.parseColor("#45CE30"));
                tv.setText("For decades, many people believed that opening windows reduced pressure inside homes during tornadoes. But the theory doesn’t hold water, and actually, opening windows can let in high winds that may add more damage to the structure.");
                score+=1;


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("For decades, many people believed that opening windows reduced pressure inside homes during tornadoes. But the theory doesn’t hold water, and actually, opening windows can let in high winds that may add more damage to the structure.");


            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity2.this,HomeActivity3.class);
                startActivity(intent);
            }
        });


    }
}

