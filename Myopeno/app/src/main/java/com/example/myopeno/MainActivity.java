package com.example.myopeno;

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

    public void openWhatsapp(View view){
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
    public void openUdemy(View view){
        // application package name for whatsapp is com.udemy.android
        // here intent is used for opening whatsapp on clicking button
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.udemy.android");

        if(LaunchIntent!=null){
            startActivity(LaunchIntent);
        }
        else{
            Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
        }

    }
    public void openYoutube(View view){
        // application package name for  com. google. android. youtube
        // here intent is used for opening whatsapp on clicking button
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

        if(LaunchIntent!=null){
            startActivity(LaunchIntent);
        }
        else{
            Toast.makeText(this, "Sorry there is some error ", Toast.LENGTH_SHORT).show();
        }

    }
//    public void openPhone(View view){
//        // application package name for whatsapp is com.whatsapp
//        // here intent is used for opening whatsapp on clicking button
//        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
//
//        if(LaunchIntent!=null){
//            startActivity(LaunchIntent);
//        }
//        else{
//            Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
//        }
//
//    }
    public void openLinkdin(View view){
        // application package name for linkdin is com.linkedin.android
        // here intent is used for opening whatsapp on clicking button
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.linkedin.android");

        if(LaunchIntent!=null){
            startActivity(LaunchIntent);
        }
        else{
            Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
        }

    }

    public void openTelegram(View view){
        // application package name for whatsapp is org.telegram.messenger
        // here intent is used for opening whatsapp on clicking button
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("org.telegram.messenger");

        if(LaunchIntent!=null){
            startActivity(LaunchIntent);
        }
        else{
            Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
        }

    }
    public void openChrome(View view){
        // application package name for whatsapp is com.android.chrome
        // here intent is used for opening whatsapp on clicking button
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");

        if(LaunchIntent!=null){
            startActivity(LaunchIntent);
        }
        else{
            Toast.makeText(this, "Sorry your phone don't have the application which you want to open ", Toast.LENGTH_SHORT).show();
        }

    }
}