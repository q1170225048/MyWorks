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

public class AddClassStr extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class_str);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, AddClassStr.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击添加按钮事件
    public void btnAddClass_Click(View view) {
        Log.d("ReadingNote", "调用添加分类按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        AutoCompleteTextView Strno=(AutoCompleteTextView)findViewById(R.id.ClassNo);
        AutoCompleteTextView Strname=(AutoCompleteTextView)findViewById(R.id.ClassName);

        strSql="insert into ClassStr values('"+Strno.getText().toString() +"','"
                                                   +Strname.getText().toString()+"','"
                                                   +Username+"')";
        Log.d("ReadingNote",strSql);
        try
        {
            if(Strno.getText().toString()=="")
            {
                new AlertDialog.Builder(this).setTitle("提示").setMessage("分类编号为必填项！").setPositiveButton("确定", null).show();
                return;
            }
            String strSql2 = "";
            strSql2 = "select * from ClassStr where No="+"'"+Strno.getText().toString()+"' and Username="+"'"+Username+"'";
            Log.d("ReadingNote",strSql2);
            Cursor cursor;
            Log.d("ReadingNote","查询之前");
            cursor = dbo.rawQuery(strSql2,null);
            if(cursor.getCount()==0)
            {
                dbo.execSQL(strSql);
            }
            else
            {
                new AlertDialog.Builder(this).setTitle("提示").setMessage("分类编号重复！").setPositiveButton("确定", null).show();
                return;
            }
        }
        catch (Exception e)
        {

        }
        new AlertDialog.Builder(this).setTitle("提示").setMessage("添加成功").setPositiveButton("确定", null).show();

        MainActivity.actionStart(AddClassStr.this,Username);
    }
}
