package com.example.tempolend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountsSecurity extends AppCompatActivity {

    ImageView leftarrow;
    Button buttonedit;

    ImageView imageViewProf;
    private static final int REQUEST_CODE = 22;
    private static final String FILE_NAME = "myFile";//sharedpref
    private Bitmap capturedImage; // Store the captured image here

    private TextView welcomeUsername, welcomeEmail, welcomeNumber;//sharedpref

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_security);

        //sharedpref
        welcomeUsername = findViewById(R.id.textView8);
        welcomeEmail = findViewById(R.id.textView12);
        welcomeNumber = findViewById(R.id.textView10);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username","N/A");
        String email = sharedPreferences.getString("email","N/A");
        String contact = sharedPreferences.getString("contact","N/A");

        welcomeUsername.setText(username);
        welcomeNumber.setText(contact);
        welcomeEmail.setText(email);




        leftarrow = findViewById(R.id.imageView11);
        buttonedit = findViewById(R.id.button);
        imageViewProf = findViewById(R.id.profile_image);

        //Profile Button will go to the More page
        String encodedImage = sharedPreferences.getString("profileImage", null);
        if (encodedImage != null) {
            // Decode the Base64 string and set it as the profile image
            byte[] decodedImage = Base64.decode(encodedImage, Base64.DEFAULT);
            Bitmap profileImage = BitmapFactory.decodeByteArray(decodedImage, 0, decodedImage.length);
            imageViewProf.setImageBitmap(profileImage);
        }

        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AccountsSecurity.this,Profile.class));
            }
        });


        //Edit button will go to edit profile page
        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountsSecurity.this,Editprofilepage.class));
            }
        });


    }

    //backpressbutton
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(AccountsSecurity.this, Profile.class);
        startActivity(intent);

    }
}