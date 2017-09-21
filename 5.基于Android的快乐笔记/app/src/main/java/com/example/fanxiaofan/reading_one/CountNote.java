package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class CountNote extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_note);
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, CountNote.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击添加按钮事件
    public void btnCountNote_Click(View view) {
        Log.d("ReadingNote", "调用统计按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        db.getReadableDatabase();
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";
        AutoCompleteTextView UserText=(AutoCompleteTextView)findViewById(R.id.UsernameStr);
        Username=UserText.getText().toString();
        Log.d("ReadingNote", Username);
        String strSql2="select * from Userinformation where Email="+"'"+Username+"'";
        Log.d("ReadingNote", strSql2);
        Cursor cursor3;
        cursor3=dbo.rawQuery(strSql2,null);
        if(cursor3.getCount()==0)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("没有相关用户！").setPositiveButton("确定", null).show();
            return;
        }

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

        int i=0;
        int count=0;
        strTemp+="用户名称："+Username+"\n";
        strTemp+="书籍名称："+bookname+"\n";

        while (cursor.moveToNext())
        {
            if(bookno.equals(cursor.getString(cursor.getColumnIndex("BookNo"))))
            {
                i++;
                strTemp+="第"+i+"条笔记："+"\n";
                strTemp+="内容："+cursor.getString(cursor.getColumnIndex("Content"))+"\n";
                strTemp+="时间："+cursor.getString(cursor.getColumnIndex("Date"))+"\n";
            }
            else
            {
                strTemp+="总计："+i+"条笔记。\n";
                count+=i;
                bookno= cursor.getString(cursor.getColumnIndex("BookNo"));
                Log.d("ReadingNote",bookno);
                cursor2 = dbo.rawQuery(strSql1,null);
                while (cursor2.moveToNext())
                {
                    bookname=cursor2.getString(cursor2.getColumnIndex("Name"));
                    Log.d("ReadingNote",bookname);
                }
                i=0;
                strTemp+="\n"+"书籍名称："+bookname+"\n";
            }
        }
        strTemp+="总计："+i+"条笔记。\n";
        count+=i;
        strTemp+="\n"+"总计："+count+"条笔记。\n";
        Log.d("ReadingNote","查询书籍信息完毕");
        TextView xianshi=(TextView)findViewById(R.id.textView4);

        xianshi.setText(strTemp);


    }
}
