package com.example.fanxiaofan.reading_one;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

public class LookBook extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_book);

        Log.d("ReadingNote","DBNew");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getReadableDatabase完毕");
        // 显示数据
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()完毕");

        Log.d("ReadingNote","调用dbo.execSQL(strSql)");
        //dbo.insert("",null,contentValues);
        Log.d("ReadingNote","完成");
        String strSql = "";
        strSql = "select * from Book where Username="+"'"+Username+"'";
        Cursor cursor;
        Log.d("ReadingNote","查询之前");
        cursor = dbo.rawQuery(strSql,null);
        String strTemp = "";
        Log.d("ReadingNote","查询书籍信息");
        String strno="";
        String strname="";
        String strauthor="";
        String strpress="";
        String strISBN="";
        String strclass="";
        int i=1;
        while (cursor.moveToNext())
        {
            strTemp+="第"+i+"本书："+"\n";
            strno = cursor.getString(cursor.getColumnIndex("No"));
            strTemp+="书籍编号："+strno+"\n";
            strname=cursor.getString(cursor.getColumnIndex("Name"));
            strTemp+="书籍名称："+strname+"\n";
            strauthor=cursor.getString(cursor.getColumnIndex("Author"));
            strTemp+="书籍作者："+strauthor+"\n";
            strpress=cursor.getString(cursor.getColumnIndex("Press"));
            strTemp+="出版社："+strpress+"\n";
            strISBN=cursor.getString(cursor.getColumnIndex("ISBN"));
            strTemp+="ISBN："+strISBN+"\n";
            strclass=cursor.getString(cursor.getColumnIndex("ClassNo"));
            strTemp+="分类："+strclass+"\n";
            strTemp+="\n";
            i++;
        }
        Log.d("ReadingNote","查询书籍信息完毕");
        TextView xianshi=(TextView)findViewById(R.id.textView2);
        if(!strTemp.equals(""))
        {
            xianshi.setText(strTemp);
        }
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context,String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, LookBook.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
}
