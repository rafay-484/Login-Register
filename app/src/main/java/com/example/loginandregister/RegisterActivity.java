package com.example.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPassword, etConfirmPassword;
    Button btnRegister, btnGoToLogin;
    TextView tvResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        tvResults = findViewById(R.id.tvResult);

        btnRegister.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();
            String confirm = etConfirmPassword.getText().toString();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() ||confirm.isEmpty()) {
                Toast.makeText(this, "All Fields Are Required!", Toast.LENGTH_SHORT).show();}
            else if (!password.equals(confirm)) {
                Toast.makeText(this, "Passwords do not match! ", Toast.LENGTH_SHORT).show();}
            else {
                tvResults.setText("Username: " + username + "\nEmail: " + email + "\npassword: " + password);
            }
        });
        btnGoToLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        });
    }
}