package com.example.shareprefrencedandsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btnLogin;
EditText etName,etDept,etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName=findViewById(R.id.etOne);
        etDept=findViewById(R.id.ettwo);
        etEmail=findViewById(R.id.etthree);
        etPassword=findViewById(R.id.etfour);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putBoolean("flag",true);
                myEdit.apply();

                if (etName.getText().toString().equals("")||etDept.getText().toString().equals("")||etEmail.getText().toString().equals("")||etPassword.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "file your Edit Text", Toast.LENGTH_SHORT).show();
                }
                else{
                    myEdit.putString("Name",etName.getText().toString());
                    myEdit.putString("City",etDept.getText().toString());
                    myEdit.putString("Email",etEmail.getText().toString());
                    myEdit.putString("Password",etPassword.getText().toString());
                    myEdit.commit();
                }
                Intent intent =new Intent(LoginActivity.this,LogOutActivity.class);
                startActivity(intent);
            }
        });
    }
}