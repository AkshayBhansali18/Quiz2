package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import static com.example.quizapplication.R.color.green;
import static com.example.quizapplication.R.color.red;

public class HomeActivity extends AppCompatActivity {
    int score = 0;
    Button button, button2, button3, next;
    TextView name;
    TextView tv, tv2;
    private FirebaseAuth mAuth;
    private static final String TAG = "HomeActivity";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        next = findViewById(R.id.next);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String username = "";
//        Intent intent=new Intent(this,MapsActivity.class);
//        startActivity(intent);
        if (user != null) {
            username = user.getEmail();
        }

        tv = findViewById(R.id.textView4);
        name = findViewById(R.id.name);
        name.setText(username);
        tv2 = findViewById(R.id.textView2);
        tv2.setText("Score: 0");
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                button.setBackgroundColor(Color.parseColor("#45CE30"));
                score += 1;
                tv.setText("Contrary to popular belief, doorways really aren’t much safer than other areas of a modern building. If you’re stuck inside when a tremor begins, hide under a very sturdy table or similar object to protect yourself from falling debris.");
                tv2.setText("Score: " + String.valueOf(score));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("Contrary to popular belief, doorways really aren’t much safer than other areas of a modern building. If you’re stuck inside when a tremor begins, hide under a very sturdy table or similar object to protect yourself from falling debris.");


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setBackgroundColor(Color.parseColor("#E84342"));
                tv.setText("Contrary to popular belief, doorways really aren’t much safer than other areas of a modern building. If you’re stuck inside when a tremor begins, hide under a very sturdy table or similar object to protect yourself from falling debris.");


            }
        });
        tv2.setText("Score: " + score);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity2.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

        addData();
    }

    private void addData() {

        Map<String, Object> scores = new HashMap<>();
        scores.put("score", this.score);
// Add a new document with a generated ID
        db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot querySnapshot: queryDocumentSnapshots)
                {
                    querySnapshot.get("score");
                    Toast.makeText(HomeActivity.this,String.valueOf(score),Toast.LENGTH_LONG).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}