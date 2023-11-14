package com.example.tempolend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guitar_Category extends AppCompatActivity {

    BottomNavigationView nav;
    private Button all_btn, electric_btn, piano_btn, drums_btn, violin_btn, cajon_btn;
    private ImageView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar_category);

        nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.Category);

        //for bottom navigation
        //open Home, Categories, Favorite, Notification and Account
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;

                    case R.id.Category:
                        return true;

                    case R.id.Cart:
                        startActivity(new Intent(getApplicationContext(), Orders.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;

                    case R.id.Me:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;
                }
                return false;
            }
        });

        //initialization
        all_btn = findViewById(R.id.all_btn);

        //open MountainBike_Category
        all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        //initialization
        electric_btn = findViewById(R.id.electric_btn);

        //open RoadBike_Category
        electric_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Electric_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        //initialization
        piano_btn = findViewById(R.id.piano_btn);

        //open ChildBike_Category
        piano_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Piano_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        drums_btn = findViewById(R.id.drums_btn);

        //open ChildBike_Category
        drums_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Drums_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        //initialization
        violin_btn = findViewById(R.id.violin_btn);

        //open ChildBike_Category
        violin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Violin_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        //initialization
        cajon_btn = findViewById(R.id.cajon_btn);

        //open ChildBike_Category
        cajon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Cajon_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        c1 = findViewById(R.id.c1);
        //open MB_view_product1 activity
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P1.class);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.c2);
        //open MB_view_product1 activity
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P2.class);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.c3);
        //open MB_view_product1 activity
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P3.class);
                startActivity(intent);
            }
        });

        c4 = findViewById(R.id.c4);
        //open MB_view_product1 activity
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P4.class);
                startActivity(intent);
            }
        });

        c5 = findViewById(R.id.c5);
        //open MB_view_product1 activity
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P5.class);
                startActivity(intent);
            }
        });

        c6 = findViewById(R.id.c6);
        //open MB_view_product1 activity
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P6.class);
                startActivity(intent);
            }
        });

        c7 = findViewById(R.id.c7);
        //open MB_view_product1 activity
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P7.class);
                startActivity(intent);
            }
        });

        c8 = findViewById(R.id.c8);
        //open MB_view_product1 activity
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P8.class);
                startActivity(intent);
            }
        });

        c9 = findViewById(R.id.c9);
        //open MB_view_product1 activity
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P9.class);
                startActivity(intent);
            }
        });

        c10 = findViewById(R.id.c10);
        //open MB_view_product1 activity
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guitar_Category.this, Guitar_View_P10.class);
                startActivity(intent);
            }
        });
    }
}