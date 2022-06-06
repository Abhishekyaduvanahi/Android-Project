package com.example.kg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<String>knowWayHead = new ArrayList<>();
    private ArrayList<String> details = new ArrayList<>();
    private ArrayList<Integer>imageList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        // HERE THIS THE LIST OF HEAD --> FIRST TEXTVIEW
        knowWayHead.add("Class 10th");
        knowWayHead.add("Class 12th");
        knowWayHead.add("BA");
        knowWayHead.add("MA");
        knowWayHead.add("BSC");
        knowWayHead.add("MSC");
        knowWayHead.add("B.COM");
        knowWayHead.add("M.COM");
        knowWayHead.add("B.TECH");
        knowWayHead.add("M.TECH");
        knowWayHead.add("PHD");
        knowWayHead.add("MBBS");

        //  THIS IS THE LIST OF HEAD ----> SECOND TEXTVIEW
        details.add("Know the way of after class 10th");
        details.add("Know the way of after class 12th");
        details.add("Know the way of after class BA");
        details.add("Know the way of after class MA");
        details.add("Know the way of after class BSC ");

        // the given below is code for entering the images in the list :--

        imageList.add(R.drawable.class10th);
        imageList.add(R.drawable.class10th);
        imageList.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);
//        imagelist.add(R.drawable.class10th);

        adapter = new RecyclerAdapter(knowWayHead,details,imageList,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }
}