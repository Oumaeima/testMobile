package com.example.miniapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.miniapplication.Models.Citation;
import com.example.miniapplication.R;
import com.example.miniapplication.adapter.CitationAdapter;

import java.util.ArrayList;
import java.util.List;

public class favorit extends AppCompatActivity {

    CitationAdapter citationAdapter;
    RecyclerView recyclerView;
    List<Citation> citationList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);



        recyclerView = findViewById(R.id.recyclerViewPlat);
        recyclerView.setHasFixedSize(true);
        Cursor cursor=new DBmanager(this).readalldata();

        while(cursor.moveToNext())
        {
            Citation obj=new Citation(cursor.getString(1));
            citationList.add(obj);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        citationAdapter = new CitationAdapter(this,citationList);
        recyclerView.setAdapter(citationAdapter);
    }
}