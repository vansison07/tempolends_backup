package com.example.tempolend;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class Editprofilepage extends AppCompatActivity {

    ImageView leftarrow;
    Button savebtn;
    private static final int REQUEST_CODE = 22; //cameraSomething
    ImageView camerabtn, imageViewProf;
    private Bitmap capturedImage;
    private static final String FILE_NAME = "myFile"; //sharedpref
    EditText inputsername, inputcontact, inputemail; //for sharedpref

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofilepage);
        leftarrow = findViewById(R.id.imageView11);
        savebtn = findViewById(R.id.button);

        // SharedPref for edit profile
        inputsername = findViewById(R.id.usernameEditText);
        inputemail = findViewById(R.id.usernameEditText3);
        inputcontact = findViewById(R.id.usernameEditText2);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String contact = sharedPreferences.getString("contact", "");

        inputsername.setText(username);
        inputcontact.setText(contact);
        inputemail.setText(email);
        imageViewProf = findViewById(R.id.profile_image);

        // Left arrow will go to the Profile page
        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Editprofilepage.this);
                alertDialog.setMessage("Changes are unsaved, are you sure you want to leave?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        Intent intent = new Intent(Editprofilepage.this, AccountsSecurity.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });


        //Save button will go to profile page
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
                String username=inputsername.getText().toString();
                String email=inputemail.getText().toString();
                String contact=inputcontact.getText().toString();

//                StoredDataUsingSHaredPref(username,email, contact);
                if (capturedImage != null) {
                    SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
                    editor.putString("username", username);
                    editor.putString("email", email);
                    editor.putString("contact", contact);

                    // Store the captured image as a Base64-encoded string
                    String encodedImage = encodeImageToBase64(capturedImage);
                    editor.putString("profileImage", encodedImage);

                    editor.apply();
                }
            }
        });


        camerabtn=findViewById(R.id.imageView6);
        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,REQUEST_CODE);
            }
        });
    }



    private void checkCredentials() { //for validation shit
        String username = inputsername.getText().toString();
        String email = inputemail.getText().toString();
        String contact=inputcontact.getText().toString();

        if (username.isEmpty() || username.length() < 7) {
            showError(inputsername, "Please enter username.");
        } else if (email.isEmpty() || !email.contains("@")) {
            showError(inputemail, "Email is invalid.");
        }  else if(contact.isEmpty() || contact.length() < 11) {
            showError(inputcontact, "Please enter mobile number.");
        }  else if(username.contains(" ")) {
            showError(inputsername, "Username should not contain whitespaces.");
        } else if(contact.isEmpty() || contact.length() < 11) {
            showError(inputemail, "Email should not contain whitespaces.");
        } else {
            Intent intent = new Intent(Editprofilepage.this, AccountsSecurity.class);
            startActivity(intent);
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.setError(s);
        input.requestFocus(); //help show the  error kasama to sa checkcredentials
    }

    private void StoredDataUsingSHaredPref(String username, String email, String contact) {
        SharedPreferences.Editor editor=getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("username", username);
        editor.putString("email", email);

        editor.putString("contact", contact);
        editor.apply();
    }


    //para sa camera ata to lahat ahhahaha
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageViewProf.setImageBitmap(photo);
            capturedImage = photo; // Store the captured image
        }
    }
    private String encodeImageToBase64(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }


    //backpressbutton
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Editprofilepage.this);
        alertDialog.setMessage("Changes are unsaved, are you sure you want to leave?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                Intent intent = new Intent(Editprofilepage.this, AccountsSecurity.class);
                startActivity(intent);

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        alertDialog.show();

    }

}