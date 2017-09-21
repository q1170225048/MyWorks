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

import java.util.Date;

public class EditSNote extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;
    private static String Content;
    private static String strDate;
    private static String strBookno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_snote);
        AutoCompleteTextView noteText=(AutoCompleteTextView)findViewById(R.id.AddNoteSFs);
        noteText.setText(Content);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username,String content,String strdate,String bookno) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, EditSNote.class);
        context.startActivity(intent);
        Username=username;
        Content=content;
        strDate=strdate;
        strBookno=bookno;
        Log.d("ReadingNote",Username+Content+strDate);
        Log.d("ReadingNote","结束");
    }
    public void btnSaveBookNote_Clicks(View view)
    {
        Log.d("ReadingNote","点击修改");

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        AutoCompleteTextView noteText=(AutoCompleteTextView)findViewById(R.id.AddNoteSFs);

        strSql = "update Note set Content='"+noteText.getText().toString()+"'"
                +" where Username='"+Username
                +"' and BookNo='"+strBookno
                +"' and Date='"
                +strDate+"'";
        Log.d("ReadingNote",strSql);

        try
        {
            dbo.execSQL(strSql);
            new AlertDialog.Builder(this).setTitle("提示").setMessage("修改成功").setPositiveButton("确定", null).show();
            MainActivity.actionStart(EditSNote.this,Username);
        }
        catch (Exception e)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("修改失败").setPositiveButton("确定", null).show();
        }
    }
}
