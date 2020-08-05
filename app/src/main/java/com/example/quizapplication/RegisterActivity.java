package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,password;
    Button register;
    private static final String TAG = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.emailText);
        password=findViewById(R.id.passwordText);
        register=findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String mail=email.getText().toString().trim();
                final String pass=password.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(mail,pass)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");

                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Toast.makeText(RegisterActivity.this, "Authentication Success.",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, task.getException().toString(),Toast.LENGTH_LONG).show();
                                    Log.d("RegisterActivity",task.getException().toString());
//                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                }

                                // ...
                            }
                        });
            }
        });


    }
}