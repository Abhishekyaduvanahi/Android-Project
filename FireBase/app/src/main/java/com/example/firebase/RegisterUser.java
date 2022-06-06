package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private Button registerUser;
    private EditText editTextFullName,editTextAge,editTextPassword,editTextEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerUser = findViewById(R.id.buttonRegisterUser);
        editTextAge =findViewById(R.id.editTextAge);
        editTextEmail =findViewById(R.id.editTextEmail);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPassword =findViewById(R.id.editTextPassword);
        registerUser.setOnClickListener(this);


//        registerUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterUser.this,MainActivity.class);
//                startActivity(i);
//            }
//        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonRegisterUser:
                Register();
                break;
        }

    }
    private void Register(){
        String email =editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullName =editTextFullName.getText().toString().trim();
        String Age = editTextAge.getText().toString().trim();

        if(fullName.isEmpty())
        {
           editTextFullName.setError("Full name is empty ");
           editTextFullName.requestFocus();
           return;

        }
        if(Age.isEmpty())
        {
            editTextAge.setError(" Age is required ");
            editTextAge.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required ");
            editTextEmail.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError(" Please provide Valid email Id ");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required ");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            editTextPassword.setError("Min password length is 6 characters !");
            editTextPassword.requestFocus();
            return;
        }

    }


}