package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText name, email, password, confirmPassword;
    private Button signUpButton;

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
        signUpButton = findViewById(R.id.buttonSignUp);
        loginButton = findViewById(R.id.Loginbtn);

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        });

        signUpButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String userName = name.getText().toString().trim();
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        String userConfirmPassword = confirmPassword.getText().toString().trim();

        if (userName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty() || userConfirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else if (!userPassword.equals(userConfirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
