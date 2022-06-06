package com.example.kg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.headViewHolder> {

    private ArrayList<String> knowWayHead ;
    private ArrayList<String> details ;
    private ArrayList<Integer>imageList ;
    private Context context;

    public RecyclerAdapter(ArrayList<String> knowWayHead, ArrayList<String> details, ArrayList<Integer> imageList, Context context) {
        this.knowWayHead = knowWayHead;
        this.details = details;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public headViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design2,parent,false);
        return new headViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull headViewHolder holder, int position) {
   holder.textViewHead.setText(knowWayHead.get(position));
   holder.textViewDetail.setText(details.get(position));
   holder.imageView.setImageResource(imageList.get(position));
   holder.cardView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if (holder.getAdapterPosition()==0) {

           }
    //         Intent i = new Intent(context, class10.class);
//               i.putExtra("context",position);
   //           context.startActivity(i);
           Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
       }
   });




    }

    @Override
    public int getItemCount() {
        return knowWayHead.size();
    }

    public class headViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewHead ,textViewDetail;
        private ImageView imageView;
        private CardView cardView;
        public headViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead =itemView.findViewById(R.id.textViewHead);
            textViewDetail=itemView.findViewById(R.id.textViewDetail);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);

        }


    }
}
