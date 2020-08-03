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

public class HomeActivity3 extends AppCompatActivity {
    int score=0;
    Button button,button2,button3,next;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
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
                tv.setText("In hurricane-heavy areas, permanent storm shutters are the best protection for your windows. Plus, it beats having to nail plywood to your house (although that will work in a pinch). Tape simply ensures that the glass breaks into guillotine-sized pieces that can cause horrific bodily harm.");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("In hurricane-heavy areas, permanent storm shutters are the best protection for your windows. Plus, it beats having to nail plywood to your house (although that will work in a pinch). Tape simply ensures that the glass breaks into guillotine-sized pieces that can cause horrific bodily harm.");
                score+=1;


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.parseColor("#45CE30"));
                tv.setText("In hurricane-heavy areas, permanent storm shutters are the best protection for your windows. Plus, it beats having to nail plywood to your house (although that will work in a pinch). Tape simply ensures that the glass breaks into guillotine-sized pieces that can cause horrific bodily harm.");


            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity3.this,HomeActivity4.class);
                startActivity(intent);
            }
        });


    }
}

