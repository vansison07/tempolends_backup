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

public class Piano_Category extends AppCompatActivity {

    BottomNavigationView nav;
    private Button all_btn, electric_btn, guitar_btn, drums_btn, violin_btn, cajon_btn;
    private ImageView c1, c2, c3, c4, c5, c6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_category);

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
                Intent intent = new Intent(Piano_Category.this, Category.class);
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
                Intent intent = new Intent(Piano_Category.this, Electric_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        //initialization
        guitar_btn = findViewById(R.id.guitar_btn);

        //open ChildBike_Category
        guitar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Guitar_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        drums_btn = findViewById(R.id.drums_btn);

        //open ChildBike_Category
        drums_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Drums_Category.class);
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
                Intent intent = new Intent(Piano_Category.this, Violin_Category.class);
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
                Intent intent = new Intent(Piano_Category.this, Cajon_Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        c1 = findViewById(R.id.c1);
        //open MB_view_product1 activity
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P1.class);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.c2);
        //open MB_view_product1 activity
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P2.class);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.c3);
        //open MB_view_product1 activity
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P3.class);
                startActivity(intent);
            }
        });

        c4 = findViewById(R.id.c4);
        //open MB_view_product1 activity
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P4.class);
                startActivity(intent);
            }
        });

        c5 = findViewById(R.id.c5);
        //open MB_view_product1 activity
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P5.class);
                startActivity(intent);
            }
        });

        c6 = findViewById(R.id.c6);
        //open MB_view_product1 activity
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Piano_Category.this, Piano_View_P6.class);
                startActivity(intent);
            }
        });
    }
}