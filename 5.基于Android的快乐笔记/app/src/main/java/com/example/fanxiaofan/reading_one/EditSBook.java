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

public class EditSBook extends AppCompatActivity {

    private static String Username;
    private static  String no="";
    private static  String name;
    private static String author;
    private static String press;
    private static String ISBN;
    private static String classno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sbook);

        AutoCompleteTextView textView1=(AutoCompleteTextView)findViewById(R.id.booknoE);
        AutoCompleteTextView textView2=(AutoCompleteTextView)findViewById(R.id.bookNameE);
        AutoCompleteTextView textView3=(AutoCompleteTextView)findViewById(R.id.bookauthorE);
        AutoCompleteTextView textView4=(AutoCompleteTextView)findViewById(R.id.bookpressE);
        AutoCompleteTextView textView5=(AutoCompleteTextView)findViewById(R.id.bookISBNE);
        AutoCompleteTextView textView6=(AutoCompleteTextView)findViewById(R.id.bookclassE);

        textView1.setText(no);
        textView2.setText(name);
        textView3.setText(author);
        textView4.setText(press);
        textView5.setText(ISBN);
        textView6.setText(classno);

        Log.d("ReadingNote",no+name+author+press+ISBN+classno+textView1.getText().toString());
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context,String str1,String str2,String str3,String str4,String str5,String str6,String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, EditSBook.class);
        context.startActivity(intent);
        no=str1;
        name=str2;
        author=str3;
        press=str4;
        ISBN=str5;
        classno=str6;
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击添加按钮事件
    public void btnEditSaveBook_Click(View view)
    {
        Log.d("ReadingNote","调用修改保存按钮");

        AutoCompleteTextView textView1=(AutoCompleteTextView)findViewById(R.id.booknoE);
        AutoCompleteTextView textView2=(AutoCompleteTextView)findViewById(R.id.bookNameE);
        AutoCompleteTextView textView3=(AutoCompleteTextView)findViewById(R.id.bookauthorE);
        AutoCompleteTextView textView4=(AutoCompleteTextView)findViewById(R.id.bookpressE);
        AutoCompleteTextView textView5=(AutoCompleteTextView)findViewById(R.id.bookISBNE);
        AutoCompleteTextView textView6=(AutoCompleteTextView)findViewById(R.id.bookclassE);

        String strSQL="update Book set Name="
                    +"'"+textView2.getText().toString()+"',"
                    +"Author="
                    +"'"+textView3.getText().toString()+"',"
                    +"Press="
                    +"'"+textView4.getText().toString()+"',"
                    +"ISBN="
                    +"'"+textView5.getText().toString()+"',"
                    +"ClassNo="
                    +"'"+textView6.getText().toString()+"'"
                    +" where No="
                    +"'"+textView1.getText().toString()+"'"
                    +" and Username="
                    +"'"+Username+"'";

        Log.d("ReadingNote","SQL语句："+strSQL);
        DB db;

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();

        Log.d("ReadingNote","调用db.getWritableDatabase()");
        //修改数据

        SQLiteDatabase dbo = db.getWritableDatabase();
        Log.d("ReadingNote","更新之前");
        dbo.execSQL(strSQL);
        Log.d("ReadingNote","更新完毕");
        new AlertDialog.Builder(this).setTitle("提示").setMessage("修改成功").setPositiveButton("确定", null).show();

        MainActivity.actionStart(EditSBook.this,Username);
    }
}
