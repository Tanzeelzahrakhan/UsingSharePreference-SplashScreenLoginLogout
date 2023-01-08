package com.example.shareprefrencedandsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LogOutActivity extends AppCompatActivity {
Button btnLogout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putBoolean("flag",false);
                myEdit.apply();
                Toast.makeText(LogOutActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
            }
        });










    }
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}