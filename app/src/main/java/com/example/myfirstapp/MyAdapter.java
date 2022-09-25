package com.example.myfirstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> products;

    // constructor
    public MyAdapter(Context context, ArrayList<String> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // giving a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created
        holder.productView.setText(products.get(position)); //*
    }

    @Override
    public int getItemCount() {
        // returns the number of items
        return products.size();
    }

    // nested MyViewHolder class (earlier it was static)
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productView;
        Button button_delete;

        // constructor
        public MyViewHolder(@NonNull View v) {
            super(v);
            productView = v.findViewById(R.id.textView2);
            button_delete = v.findViewById(R.id.button_delete);

            button_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    MyAdapter.this.products.remove(position);
                    MyAdapter.this.notifyItemRemoved(position);
                }
            });
        }
    }
}
