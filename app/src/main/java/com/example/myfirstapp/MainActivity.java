package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myFirstApp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        // Intent constructor takes two parameters: Context and a Class
        // the Class parameter is the activity to start
        // view is a specific button that invoked this function
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        // .putExtra() method adds the value of EditText
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void disable(View v) {
        Button button2 = findViewById(R.id.button2);
        button2.setEnabled(false);
        Log.d("success", "button disabled");
        button2.setText("button disabled");
    }

    public void enableAgain(View v) {
        Button button2 = findViewById(R.id.button2);
        button2.setEnabled(true);
        button2.setText("click only once");
    }

    public void alert(View v) {
        Toast.makeText(this, "alert!", Toast.LENGTH_LONG).show();
    }

    public void launchShoppingList(View v) {
        Intent intent = new Intent(this, ShoppingListActivity.class);
        startActivity(intent);
    }
}