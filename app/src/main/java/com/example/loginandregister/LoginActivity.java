package com.example.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginUsername, etLoginPassword;
    Button btnLogin, btnBackToRegister;
    TextView tvLoginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_login);

     etLoginUsername = findViewById(R.id.etLoginUsername);
     etLoginPassword = findViewById(R.id.etLoginPassword);
     btnLogin = findViewById(R.id.btnLogin);
     btnBackToRegister = findViewById(R.id.BackToRegister);
     tvLoginResult = findViewById(R.id.tvLoginResult);

     btnLogin.setOnClickListener(v -> {
         String username = etLoginUsername.getText().toString().trim();
         String password = etLoginPassword.getText().toString();

         if (username.isEmpty() || password.isEmpty()) {
             Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
         }
         else {
             tvLoginResult.setText("Username: " + username + "\nPassword: " + password);
         }
     });
     btnBackToRegister.setOnClickListener(v -> {
         startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
     });
    }
}

