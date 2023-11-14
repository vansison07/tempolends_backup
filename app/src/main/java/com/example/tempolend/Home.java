package com.example.tempolend;

import static com.example.tempolend.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Home extends AppCompatActivity {

    BottomNavigationView nav;
    private Button c1, c2, c3, c4, c5, c6;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        nav = findViewById(id.nav);
        nav.setSelectedItemId(id.Home);

        //for bottom navigation
        //open Home, Categories, Favorite, Notification and Account
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case id.Home:
                        return true;

                    case id.Category:
                        startActivity(new Intent(getApplicationContext(), Category.class));
                        overridePendingTransition(anim.fade_in, anim.fade_out);
                        return true;

                    case id.Cart:
                        startActivity(new Intent(getApplicationContext(), Orders.class));
                        overridePendingTransition(anim.fade_in, anim.fade_out);
                        return true;

                    case id.Me:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(anim.fade_in, anim.fade_out);
                        return true;
                }
                return false;
            }
        });

        c1 = findViewById(R.id.c1);
        //open MB_view_product1 activity
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Electric_View_P3.class);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.c2);
        //open MB_view_product1 activity
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Electric_View_P1.class);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.c3);
        //open MB_view_product1 activity
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Guitar_View_P1.class);
                startActivity(intent);
            }
        });

        c4 = findViewById(R.id.c4);
        //open MB_view_product1 activity
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Guitar_View_P8.class);
                startActivity(intent);
            }
        });

        c5 = findViewById(R.id.c5);
        //open MB_view_product1 activity
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Electric_View_P5.class);
                startActivity(intent);
            }
        });

        c6 = findViewById(R.id.c6);
        //open MB_view_product1 activity
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Electric_View_P10.class);
                startActivity(intent);
            }
        });

    }
}