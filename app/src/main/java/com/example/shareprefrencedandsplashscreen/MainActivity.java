package com.example.shareprefrencedandsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);

                Boolean check=sharedPreferences.getBoolean("flag",false);
                if(check){
                    Intent intent=new Intent(MainActivity.this,LogOutActivity.class);
                    startActivity(intent);
                }
            else {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                }
                finish();
            }

        },  SPLASH_DISPLAY_LENGTH);
    }
}
