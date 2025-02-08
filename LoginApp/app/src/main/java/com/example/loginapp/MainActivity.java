package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button loginButton;
    private TextView signUp, forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        signUp = findViewById(R.id.textSignUp);
        forgotPassword = findViewById(R.id.textForgotPassword);

        loginButton.setOnClickListener(v -> validateLogin());

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        forgotPassword.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Reset password option clicked", Toast.LENGTH_SHORT).show();
        });
    }

    private void validateLogin() {
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();

        if (userEmail.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            // Add authentication logic here (e.g., Firebase Auth or local database)
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
    }
}
