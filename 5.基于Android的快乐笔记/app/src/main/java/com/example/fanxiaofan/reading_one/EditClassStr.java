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

public class EditClassStr extends AppCompatActivity {

    private static String Username;
    private static String ClassNo;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class_str);
    }
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, EditClassStr.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击添加按钮事件
    public void btnEditFindClass_Click(View view) {
        Log.d("ReadingNote", "调用查询分类按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        AutoCompleteTextView bookno=(AutoCompleteTextView)findViewById(R.id.ClassNoF);
        String strSql = "";
        strSql = "select * from ClassStr where No="+"'"+bookno.getText().toString()+"' and Username="+"'"+Username+"'";
        Cursor cursor;
        Log.d("ReadingNote","查询之前");
        cursor = dbo.rawQuery(strSql,null);
        String strno="";
        String strname="";
        if(cursor.getCount()==0)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("分类编号不存在！").setPositiveButton("确定", null).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                strno = cursor.getString(cursor.getColumnIndex("No"));
                strname=cursor.getString(cursor.getColumnIndex("Name"));
            }
            EditSClassStr.actionStart(EditClassStr.this,strno,strname,Username);

        }
    }

}
