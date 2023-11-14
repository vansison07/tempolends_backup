package com.example.tempolend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.Cart:
                        startActivity(new Intent(getApplicationContext(),Orders.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Category:
                        startActivity(new Intent(getApplicationContext(), Category.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;

                    case R.id.Me:
                        return true;
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
    }

    public void toAccountSecurity(View v) {
        startActivity(new Intent(Profile.this, AccountsSecurity.class));
    }

    public void toAddress(View v) {
        startActivity(new Intent(Profile.this, Address.class));
    }
    public void toReturn(View v) {
        startActivity(new Intent(Profile.this, ToReturn.class));
    }


    public void toCards(View v) {
        startActivity(new Intent(Profile.this, AccountsSecurity.class));
    }

    public void toHistory(View v) {
        startActivity(new Intent(Profile.this, PurchaseHistory.class));
    }


    public void toLogout(View v){

        Dialog mdialog = new Dialog(this);

        mdialog.setContentView(R.layout.popout_logout);


        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mdialog.show();
        Button logout = mdialog.findViewById(R.id.logout_btn);
        Button cancel = mdialog.findViewById(R.id.cancel_btn);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.dismiss();
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.dismiss();
                startActivity(new Intent(Profile.this, Signin.class));
            }
        });


    }
}