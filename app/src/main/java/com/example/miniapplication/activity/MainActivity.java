package com.example.miniapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fav, like, dislike;
    SQLiteDatabase db;
    TextView textView;
    DBmanager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fav = findViewById(R.id.fav);
        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);
        textView = findViewById(R.id.citation);

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String str = new String(responseBody);
                textView.setText(str);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, favorit.class);
                startActivity(intent);
            }
        });

        // Création de la base de données ou ouverture de connexion
        db = openOrCreateDatabase("MiniApp",MODE_PRIVATE,null);

        // Création de la table "favoris"
        db.execSQL("CREATE TABLE IF NOT EXISTS FAVORIS (citation varchar primary key);");

        /*like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    db.execSQL("insert into FAVORIS (citation) values (?);", new String[] {textView.getText().toString()});
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });*/

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(textView.getText().toString());
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://jsonplaceholder.typicode.com/posts/6";
                new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                            textView.setText(str);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
            }
        });

    }

    private void processinsert(String n)
    {
        String res=new DBmanager(this).addrecord(n);
        textView.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}