package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button enter;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mail = findViewById(R.id.editTextSignUpEmail);
        password = findViewById(R.id.editTextSignUpPassword);
        enter = findViewById(R.id.buttonEntero);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = mail.getText().toString();
                String userPassword =password.getText().toString();
                signupFirebase(userEmail,userPassword);

            }
        });

    }
    public void signupFirebase(String userEmail ,String userPassword)
    {
        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(SignUp.this, "Your Account has been Created ", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUp.this,MainActivity.class);
                            startActivity(i);

                        }
                        else {

                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUp.this, "Pleas try again something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

    }

}