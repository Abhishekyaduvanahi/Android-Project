package com.example.careerway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView class10,class12,Btech,Mtech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        class10=(CardView) findViewById(R.id.class10);
        class12=(CardView) findViewById(R.id.class12th);
        Btech=(CardView) findViewById(R.id.Btech);
        Mtech=(CardView) findViewById(R.id.Mtech);

        class10.setOnClickListener(this);
        Btech.setOnClickListener(this);
        class12.setOnClickListener(this);
        Mtech.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent i ;

        switch (v.getId()){

            case R.id.class10:

                i = new Intent(this,Class10th.class);
                startActivity(i);
                break;
            case R.id.class12th:
                i = new Intent(this,Class12th.class);
                startActivity(i);
                break;
            case R.id.Btech:
                i = new Intent(this,Btech.class);
                startActivity(i);
                break;
            case R.id.Mtech:
                i = new Intent(this,Mtech.class);
                startActivity(i);
                break;
        }
    }
}