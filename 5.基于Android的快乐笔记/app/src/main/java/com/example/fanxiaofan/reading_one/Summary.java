package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        Log.d("ReadingNote","完成");
        String strSql = "";
        strSql = "select * from Note order by Username";

        Cursor cursor;
        Cursor cursor1;
        Log.d("ReadingNote","查询之前");
        Log.d("ReadingNote",strSql);
        cursor = dbo.rawQuery(strSql,null);
        cursor1=dbo.rawQuery(strSql,null);

        String bookno="";
        while (cursor1.moveToNext())
        {
            bookno = cursor1.getString(cursor1.getColumnIndex("Username"));
            Log.d("ReadingNote",bookno);
            break;
        }

        String strTemp = "";
        int i=0;
        int count=0;
        strTemp+="用户名："+bookno+"\n";
        while (cursor.moveToNext())
        {
            if(bookno.equals(cursor.getString(cursor.getColumnIndex("Username"))))
            {
                i++;
                strTemp+="第"+i+"条笔记："+"\n";
                strTemp+="内容："+cursor.getString(cursor.getColumnIndex("Content"))+"\n";
                strTemp+="时间："+cursor.getString(cursor.getColumnIndex("Date"))+"\n";
            }
            else
            {
                bookno= cursor.getString(cursor.getColumnIndex("Username"));
                Log.d("ReadingNote",bookno);
                strTemp+="总计："+i+"条笔记\n\n";
                count+=i;
                strTemp+="用户名："+bookno+"\n";
                i=0;

            }
        }

        strTemp+="总计："+i+"条笔记\n\n";
        count+=i;

        strTemp+="所有用户共有"+count+"条笔记\n\n";
        TextView xianshi=(TextView)findViewById(R.id.SummaryText);
        xianshi.setText(strTemp);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, Summary.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
}
