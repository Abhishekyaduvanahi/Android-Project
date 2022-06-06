package com.example.intentoimplicitexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openApp(View view){
        // application package name for whatsapp is com.whatsapp
        // here intent is used for opening whatsapp on clicking button
           Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");

           if(LaunchIntent!=null){
               startActivity(LaunchIntent);
           }
           else{
               Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
           }

    }
}