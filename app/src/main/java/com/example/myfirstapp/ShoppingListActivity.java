package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.widget.EditText;

public class ShoppingListActivity extends AppCompatActivity {

    ArrayList<String> products = new ArrayList<String>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        // products.add("marchew");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(this, products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addProduct(View v) {
        String product = ((EditText)findViewById(R.id.input_field)).getText().toString();
        products.add(product);
        adapter = new MyAdapter(this, products);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        // adapter.notifyDataSetChanged();

        ((EditText)findViewById(R.id.input_field)).setText("");
    }
}