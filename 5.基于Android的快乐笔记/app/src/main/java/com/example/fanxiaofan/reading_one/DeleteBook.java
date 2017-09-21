package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class DeleteBook extends AppCompatActivity {

    private DB db;
    private  String strno="";
    private  SQLiteDatabase dbo;
    private  static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context,String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, DeleteBook.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击查询按钮事件
    public void btnEditDeleteBook_Click(View view)
    {
        Log.d("ReadingNote","调用删除的查询图书按钮");
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
        AutoCompleteTextView bookno=(AutoCompleteTextView)findViewById(R.id.InbookNoNumD);
        String strSql = "";
        strSql = "select * from Book where No="+"'"+bookno.getText().toString()+"' and Username='"+Username+"'";
        Cursor cursor;
        Log.d("ReadingNote","查询之前");
        cursor = dbo.rawQuery(strSql,null);
        String strTemp = "";
        Log.d("ReadingNote","查询书籍信息");
        strno="";
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
        else
        {
            while (cursor.moveToNext())
            {
                strno = cursor.getString(cursor.getColumnIndex("No"));
                strname=cursor.getString(cursor.getColumnIndex("Name"));
                strauthor=cursor.getString(cursor.getColumnIndex("Author"));
                strpress=cursor.getString(cursor.getColumnIndex("Press"));
                strISBN=cursor.getString(cursor.getColumnIndex("ISBN"));
                strclass=cursor.getString(cursor.getColumnIndex("ClassNo"));
            }

            AlertDialog.Builder builder =  new AlertDialog.Builder(DeleteBook.this);
            builder.setTitle("确定删除？");
            builder.setItems(new String[]{"编号："+strno, "书籍名称："+strname, "作者："+strauthor, "出版社："+strpress,"ISBN："+strISBN,"分类："+strclass}, null);
            builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {

                }
                });

            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    String strSQL="delete from Book where No='"+ strno +"' and Username='"+Username+"'";
                    dbo.execSQL(strSQL);
                    MainActivity.actionStart(DeleteBook.this,Username);
                }
            });
            builder.show();
            //new AlertDialog.Builder(this).setTitle("提示").setMessage(strno+strname+strauthor+strpress+strISBN+strclass).setPositiveButton("确定", null).show();
        }
    }
}
