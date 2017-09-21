package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNoteS extends AppCompatActivity {

    private DB db;
    private SQLiteDatabase dbo;
    private static String Username;
    private static String Bookmo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_s);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username,String bookno) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, AddNoteS.class);
        context.startActivity(intent);
        Username=username;
        Bookmo=bookno;
        Log.d("ReadingNote","结束");
    }

    //保存笔记
    public void btnSaveBookNote_Click(View view)
    {
        Log.d("ReadingNote","调用保存笔记按钮");
        Log.d("ReadingNote","调用添加图书按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();

        Log.d("ReadingNote","调用db.getWritableDatabase()");
        //插入数据

        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        AutoCompleteTextView noteText=(AutoCompleteTextView)findViewById(R.id.AddNoteSF);

        SimpleDateFormat formatter  =   new  SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String strDate = formatter.format(curDate);

        strSql = "insert into Note values('"+Username+"','"
                                               +Bookmo+"','"
                                               +noteText.getText().toString()+"','"
                                               +strDate+"')";
        Log.d("ReadingNote",strSql);
        try
        {
            dbo.execSQL(strSql);
            new AlertDialog.Builder(this).setTitle("提示").setMessage("保存成功").setPositiveButton("确定", null).show();
            MainActivity.actionStart(AddNoteS.this,Username);
        }
        catch (Exception e)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("保存失败").setPositiveButton("确定", null).show();
            return;
        }
    }
}
