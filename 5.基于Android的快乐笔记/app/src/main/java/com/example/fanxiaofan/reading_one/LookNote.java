package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LookNote extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_note);
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
        strSql = "select * from Note where Username="+"'"+Username+"' order by BookNo";
        Cursor cursor;
        Cursor cursor1;
        Log.d("ReadingNote","查询之前");
        Log.d("ReadingNote",strSql);
        cursor = dbo.rawQuery(strSql,null);
        cursor1=dbo.rawQuery(strSql,null);

        String strTemp = "";
        Log.d("ReadingNote","查询笔记信息");
        String bookno="";
        while (cursor1.moveToNext())
        {
            bookno = cursor1.getString(cursor1.getColumnIndex("BookNo"));
            Log.d("ReadingNote",bookno);
            break;
        }

        Log.d("ReadingNote",bookno);

        String bookname="";
        String strSql1 = "select * from Book where No="+"'"+bookno+"' and Username='"+Username+"'";
        Cursor cursor2;
        Log.d("ReadingNote","查询书籍之前");
        Log.d("ReadingNote",strSql1);
        cursor2 = dbo.rawQuery(strSql1,null);
        while (cursor2.moveToNext())
        {
            bookname=cursor2.getString(cursor2.getColumnIndex("Name"));
            Log.d("ReadingNote",bookname);
        }
        String content="";

        int i=1;
        strTemp+="书籍名称："+bookname+"\n";
        while (cursor.moveToNext())
        {
            if(bookno.equals(cursor.getString(cursor.getColumnIndex("BookNo"))))
            {
                strTemp+="第"+i+"条笔记："+"\n";
                strTemp+="内容："+cursor.getString(cursor.getColumnIndex("Content"))+"\n";
                strTemp+="时间："+cursor.getString(cursor.getColumnIndex("Date"))+"\n";
                i++;
            }
            else
            {
                bookno= cursor.getString(cursor.getColumnIndex("BookNo"));
                Log.d("ReadingNote",bookno);
                cursor2 = dbo.rawQuery(strSql1,null);
                while (cursor2.moveToNext())
                {
                    bookname=cursor2.getString(cursor2.getColumnIndex("Name"));
                    Log.d("ReadingNote",bookname);
                }
                i=1;
                strTemp+="\n"+"书籍名称："+bookname+"\n";
            }
        }
        Log.d("ReadingNote","查询书籍信息完毕");
        TextView xianshi=(TextView)findViewById(R.id.textView3);
        if(!strTemp.equals("书籍名称："))
        {
            xianshi.setText(strTemp);
        }
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, LookNote.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
}
