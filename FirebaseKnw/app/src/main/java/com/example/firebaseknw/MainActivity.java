package com.example.firebaseknw;

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

public class MainActivity extends AppCompatActivity {


        EditText mail;
    EditText password;
   Button signIn;
   Button signUp;

    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mail =findViewById(R.id.editTextEmailb);
        password = findViewById(R.id.editTextPasswordb);
        signIn = findViewById(R.id.buttonsigninb);
       signUp = findViewById(R.id.buttonsignupb);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userMail =mail.getText().toString();
                String userPassword = password.getText().toString();
                SignInFirebase(userMail,userPassword);

            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });


    }

    public void SignInFirebase(String userMail ,String userPassword){

        auth.signInWithEmailAndPassword( userMail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Intent i = new Intent(MainActivity.this,MainMenu.class);
                            startActivity(i);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Mail or Password is not Correct", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}