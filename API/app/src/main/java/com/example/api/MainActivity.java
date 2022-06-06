package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

//
//    TextView texta,textb,textc,textd;
  RecyclerView recyclerView;
  RecyclerView.LayoutManager layoutManager;

  List<ModelClass> data;
  RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        texta = findViewById(R.id.textViewa);
//        textb = findViewById(R.id.textViewb);
//        textc = findViewById(R.id.textViewc);
//        textd = findViewById(R.id.textViewd);

        recyclerView = findViewById(R.id.recyclerView);
        // layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        Call<List<ModelClass>> call = retrofitApi.getModelClass();

        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {

//                if(!response.isSuccessful())
//                {
//                    texta.setText("error");
//                    textb.setText("error");
//                    textc.setText("error");
//                    textd.setText("error");
//                }
//               List<ModelClass> data = response.body();
//
//                texta.setText("" + data.get(0).getUserId());
//                textb.setText("" + data.get(0).getId());
//                textc.setText("" + data.get(0).getTitle());
//                textd.setText("" + data.get(0).getBody());

                data = response.body();
                adapter = new RecyclerAdapter(data);
                recyclerView.setAdapter(adapter);




            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "There is an error."
                        , Toast.LENGTH_SHORT).show();



            }
        });

    }
}