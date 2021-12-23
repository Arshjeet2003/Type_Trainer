package com.example.android.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Wrong_words extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_words);
        list = findViewById(R.id.list);
        Intent intent = getIntent();
        ArrayList<String> finalList = intent.getStringArrayListExtra("finalList");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Wrong_words.this, android.R.layout.simple_list_item_1,finalList);
        list.setAdapter(adapter);
    }
}