package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by fanxiaofan on 2017/4/13.
 */

public class DB extends SQLiteOpenHelper {
    // 函数 *********************************************************************
    // 构造
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        Log.d("ReadingNote","调用DB构造函数");
    }

    // 创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String strSQL = "create table Userinformation("
                + "Email text not null,"
                + "Name text not null,"
                + "Password text not null,"
                + "constraint PK_Userinformation primary key(Email)"
                + ")";
       String strSQL1 ="create table Book("
                     +"No text not null,"
                     +"Name text not null,"
                     +"Author text not null,"
                     +"Press text not null,"
                     +"ISBN text not null,"
                     +"ClassNo text not null,"
                     +"Username text not null,"
                     +"constraint PK_Book primary key(No,Username)"
                     +")";
        String strSQL2="create table Note("
                        +"Username text not null,"
                        +"BookNo text not null,"
                        +"Content text not null,"
                        +"Date text not null,"
                        +"constraint PK_Note primary key(Username,BookNo,Date)"
                        +")";
        String strSQL3="create table ClassStr("
                        +"No text not null,"
                        +"Name text not null,"
                        +"Username text not null,"
                        +"constraint PK_ClassStr primary key(No,Username)"
                        +")";
        db.execSQL(strSQL);
        db.execSQL(strSQL1);
        db.execSQL(strSQL2);
        db.execSQL(strSQL3);
        Log.d("ReadingNote","调用DB.onCreate()");
    }

    // 升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("ReadingNote","调用DB.onUpgrade()");
    }
}
