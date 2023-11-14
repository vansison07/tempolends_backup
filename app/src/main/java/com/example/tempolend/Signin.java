package com.example.tempolend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

import pl.droidsonroids.gif.GifImageView;


public class Signin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText Loginemail, Loginpassword;
    private Button LoginButton;
    private TextView SignupNow;
    GifImageView loadinganim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //Initialize all variables
        auth = FirebaseAuth.getInstance();
        Loginemail = findViewById(R.id.login_email);
        Loginpassword = findViewById(R.id.login_password);
        LoginButton = findViewById(R.id.login_button);
        SignupNow = findViewById(R.id.toSignup);
        loadinganim = findViewById(R.id.loading);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Loginemail.getText().toString();
                String pass = Loginpassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Signin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Signin.this, Home.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Signin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Loginpassword.setError("Password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    Loginemail.setError("Email cannot be empty");
                } else {
                    Loginemail.setError("Please enter valid Email");

                }

            }
        });

                SignupNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Signin.this, Signup.class));
                    }
                });

    }

}