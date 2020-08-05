package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static com.example.quizapplication.R.color.green;
import static com.example.quizapplication.R.color.red;

public class HomeActivity2 extends AppCompatActivity {
    int score=0;
    Button button,button2,button3,next;
    TextView tv,tv2;
    private static final String TAG = "HomeActivity2";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        button= findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        tv2=findViewById(R.id.textView2);
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
                tv2.setText("Score: "+score);


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
                intent.putExtra("score",score);
                startActivity(intent);
            }
        });

        update();
    }

    private void update() {
        db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Log.d("Retrieval", "onSuccess: ");
                for(QueryDocumentSnapshot document:queryDocumentSnapshots)
                {
                    score=Integer.parseInt(document.get("score").toString());
                    updateScore();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(HomeActivity2.this,"#Fail",Toast.LENGTH_LONG).show();

            }
        });

    }

    private void updateScore() {
        tv2.setText(String.valueOf(score));
    }

    @Override
    protected void onStart() {
        super.onStart();
        final DocumentReference docRef = db.collection("cities").document("SF");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    Log.d(TAG, "Current data: " + snapshot.getData());

                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }
}

