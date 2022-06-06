package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();




    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.h1,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));
        userList.add(new ModelClass(R.drawable.class10,"Anjali","10:45","fggg","___________-"));



    }

    private void initRecyclerView() {

        recyclerView =findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter(userList);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
}