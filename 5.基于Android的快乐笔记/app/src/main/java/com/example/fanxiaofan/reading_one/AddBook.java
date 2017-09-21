package com.example.fanxiaofan.reading_one;

import android.content.ContentValues;
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

public class AddBook extends AppCompatActivity {

    //变量
    private DB db;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context,String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, AddBook.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击添加按钮事件
    public void btnAddBook_Click(View view)
    {
        Log.d("ReadingNote","调用添加图书按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();

        Log.d("ReadingNote","调用db.getWritableDatabase()");
        //插入数据

        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";
        AutoCompleteTextView Strno=(AutoCompleteTextView)findViewById(R.id.bookno);
        AutoCompleteTextView Strname=(AutoCompleteTextView)findViewById(R.id.bookName);
        AutoCompleteTextView Sttauthor=(AutoCompleteTextView)findViewById(R.id.bookauthor);
        AutoCompleteTextView Strpress=(AutoCompleteTextView)findViewById(R.id.bookpress);
        AutoCompleteTextView StrISBN=(AutoCompleteTextView)findViewById(R.id.bookISBN);
        AutoCompleteTextView Strclass=(AutoCompleteTextView)findViewById(R.id.bookclass);

        strSql = "insert into Book values('"+Strno.getText().toString() +"','"
                                                +Strname.getText().toString()+"','"
                                                +Sttauthor.getText().toString()+"','"
                                                +Strpress.getText().toString()+"','"
                                                +StrISBN.getText().toString()+"','"
                                                +Strclass.getText().toString()+"','"
                                                +Username+"')";

        //new AlertDialog.Builder(this).setTitle("提示").setMessage(strSql).setPositiveButton("确定", null).show();


//        ContentValues contentValues = new ContentValues();
//        contentValues.put("No",Strno.getText().toString());
//        contentValues.put("Name",Strname.getText().toString());
//        contentValues.put("Author",Sttauthor.getText().toString());
//        contentValues.put("Press",Strpress.getText().toString());
//        contentValues.put("ISBN",StrISBN.getText().toString());
//        contentValues.put("ClassNo",Strclass.getText().toString());

        try
        {
            if(Strno.getText().toString()=="")
            {
                new AlertDialog.Builder(this).setTitle("提示").setMessage("图书编号为必填项！").setPositiveButton("确定", null).show();
                return;
            }
            String strSql2 = "";
            strSql2 = "select * from Book where No="+"'"+Strno.getText().toString()+"' and Username="+"'"+Username+"'";
            Cursor cursor;
            Log.d("ReadingNote","查询之前");
            cursor = dbo.rawQuery(strSql2,null);
            if(cursor.getCount()==0)
            {
                dbo.execSQL(strSql);
            }
            else
            {
                new AlertDialog.Builder(this).setTitle("提示").setMessage("图书编号重复！").setPositiveButton("确定", null).show();
                return;
            }
            //dbo.insert("",null,contentValues);
        }
        catch (Exception e)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("图书编号重复！").setPositiveButton("确定", null).show();
        }

        Log.d("ReadingNote","完成");


        Log.d("ReadingNote","添加成功");
        new AlertDialog.Builder(this).setTitle("提示").setMessage("添加成功").setPositiveButton("确定", null).show();

        MainActivity.actionStart(AddBook.this,Username);
    }
}
