package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LookClassStr extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_class_str);

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";
        strSql = "select * from ClassStr where Username="+"'"+Username+"'";
        Cursor cursor;
        Log.d("ReadingNote","查询之前");
        cursor = dbo.rawQuery(strSql,null);
        String strTemp = "";
        int i=1;
        while (cursor.moveToNext())
        {
            strTemp+="分类编号"+i+"："+cursor.getString(cursor.getColumnIndex("No"))+"\n";
            strTemp+="书籍编号："+cursor.getString(cursor.getColumnIndex("Name"))+"\n";
            strTemp+="\n";
            i++;
        }
        TextView xianshi=(TextView)findViewById(R.id.textViewClass);
        xianshi.setText(strTemp);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, LookClassStr.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
}
