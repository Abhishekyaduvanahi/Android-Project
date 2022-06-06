package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ModelClass> data;

    public RecyclerAdapter(List<ModelClass> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

  View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_layout_item
  ,parent,false);

  return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.texta.setText("" + data.get(position).getUserId());
        holder.textb.setText("" +  data.get(position).getId());
        holder.textc.setText("" +  data.get(position).getTitle());
        holder.textd.setText("" +  data.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

          TextView texta ,textb,textc,textd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            texta =itemView.findViewById(R.id.textView1);
            textb =itemView.findViewById(R.id.textView2);
            textc =itemView.findViewById(R.id.textView3);
            textd =itemView.findViewById(R.id.textView4);


        }
    }


}
