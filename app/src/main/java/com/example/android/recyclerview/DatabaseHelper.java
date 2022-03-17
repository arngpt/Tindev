package com.example.android.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_name= "tindev.db";


    public DatabaseHelper(Context context) {
        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table user(username text PRIMARY KEY ,Name Text ,password Text) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user" );
    }
    public boolean insert(String username,String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("name",name);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues );
        if(ins==-1) return false;
        else return true;
    }
    public boolean checkusername(String username){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where username=?",new String[]{username});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}