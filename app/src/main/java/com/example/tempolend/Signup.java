package com.example.tempolend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText Signup_username, Signup_email, Signup_password, Signup_confirm, Signup_address, Signup_contactno;
    private Button Sign_Button;
    private TextView Login_Now;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        Signup_username = findViewById(R.id.username);
        Signup_email = findViewById(R.id.email);
        Signup_password = findViewById(R.id.password);
        Signup_confirm = findViewById(R.id.confirm);
        Signup_address = findViewById(R.id.address);
        Signup_contactno = findViewById(R.id.contactno);
        Sign_Button = findViewById(R.id.SignupButton);
        Login_Now = findViewById(R.id.LoginNow);




        Sign_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_name = Signup_username.getText().toString().trim();
                String Email = Signup_email.getText().toString().trim();
                String signup_pass = Signup_password.getText().toString().trim();
                String confirm_pass = Signup_confirm.getText().toString();
                String Address = Signup_address.getText().toString();
                String contact_no = Signup_contactno.getText().toString();

                if (Email.isEmpty()) {
                    Signup_email.setError("Email cannot be empty");
                }
                if (signup_pass.isEmpty()) {
                    Signup_password.setError("Password cannot be empty");
                }
                if (confirm_pass.isEmpty()) {
                    Signup_confirm.setError("Confirm Password cannot be empty");
                }
                if (user_name.isEmpty()) {
                    Signup_username.setError("Username cannot be empty");
                }
                if (Address.isEmpty()) {
                    Signup_address.setError("Address cannot be empty");
                }
                if (contact_no.isEmpty()){
                    Signup_contactno.setError("Contact cannot be empty");

                } else {
                    auth.createUserWithEmailAndPassword(Email, signup_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup.this, Signin.class));
                            } else {
                                Toast.makeText(Signup.this, "Signup Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        Login_Now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, Signin.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}