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

public class AddNote extends AppCompatActivity {

    private DB db;
    private SQLiteDatabase dbo;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, AddNote.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //查询图书
    public void btnFindBookNote_Click(View view)
    {
        Log.d("ReadingNote","调用添加笔记的查询图书按钮");
        Log.d("ReadingNote","DBNew");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getReadableDatabase完毕");
        // 显示数据
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        dbo = db.getWritableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()完毕");

        AutoCompleteTextView bookno=(AutoCompleteTextView)findViewById(R.id.AddNoteF);
        String strSql = "";
        strSql = "select * from Book where No="+"'"+bookno.getText().toString()+"' and Username='"+Username+"'";
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
        if(cursor.getCount()==0)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("图书编号不存在！").setPositiveButton("确定", null).show();
            return;
        }
        else {
            while (cursor.moveToNext()) {
                strno = cursor.getString(cursor.getColumnIndex("No"));
                strname = cursor.getString(cursor.getColumnIndex("Name"));
                strauthor = cursor.getString(cursor.getColumnIndex("Author"));
                strpress = cursor.getString(cursor.getColumnIndex("Press"));
                strISBN = cursor.getString(cursor.getColumnIndex("ISBN"));
                strclass = cursor.getString(cursor.getColumnIndex("ClassNo"));
            }
            AddNoteS.actionStart(AddNote.this,Username,strno);
        }


    }
}
