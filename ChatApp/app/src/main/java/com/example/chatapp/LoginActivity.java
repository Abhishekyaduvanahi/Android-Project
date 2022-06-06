package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText editTextEmail,editTextPassword;
    private Button  buttonSignin,buttonSignup;
    private TextView textViewForget;

    // Create an object from firebase authentication
     FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonSignin = findViewById(R.id.buttonSignIn);
        buttonSignup = findViewById(R.id.buttonSignUp);
        textViewForget = findViewById(R.id.textViewForget);

        // firebase auth --
        auth =FirebaseAuth.getInstance();

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String password =editTextPassword.getText().toString();

                if(!email.equals("") && !password.equals("")){
                    signin(email,password);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Please enter an email and password  ", Toast.LENGTH_SHORT).show();
                }


            }
        });
       buttonSignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
               startActivity(intent);

           }
       });

       textViewForget.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
               startActivity(intent);


           }
       });
    }

    public void signin(String email, String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // here Using task  object here we will check to see whether the operation is taking place it task is successful.
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    Toast.makeText(LoginActivity.this, "Signed Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, " Error occured ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}