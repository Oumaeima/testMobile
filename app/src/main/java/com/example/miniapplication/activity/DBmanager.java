package com.example.miniapplication.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmanager extends SQLiteOpenHelper {
    private static final String dbname="MiniApp";

    public DBmanager(@Nullable Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qry="create table FAVORIS2 ( id integer primary key autoincrement, citation text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        String qry="DROP TABLE IF EXISTS FAVORIS2";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public  String addrecord(String text)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("citation",text);

        float res=db.insert("FAVORIS2",null,cv);

        if(res==-1)
            return "Failed";
        else
            return  "Successfully inserted";

    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String qry="select * from FAVORIS2 ";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }
}
