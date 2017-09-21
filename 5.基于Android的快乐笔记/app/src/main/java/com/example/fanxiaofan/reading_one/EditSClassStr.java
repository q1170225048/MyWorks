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

public class EditSClassStr extends AppCompatActivity {

    private static String Username;
    private static String ClassNo;
    private static String ClassName;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sclass_str);

        AutoCompleteTextView textView1=(AutoCompleteTextView)findViewById(R.id.ClassnoE);
        AutoCompleteTextView textView2=(AutoCompleteTextView)findViewById(R.id.EditSName);

        textView1.setText(ClassNo);
        textView2.setText(ClassName);
    }
    public static void actionStart(Context context, String no,String name,String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, EditSClassStr.class);
        context.startActivity(intent);
        ClassNo=no;
        ClassName=name;
        Username=username;
        Log.d("ReadingNote","结束");
    }

    //点击添加按钮事件
    public void btnEditSaveClass_Click(View view) {
        Log.d("ReadingNote", "调用修改分类保存按钮");
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        AutoCompleteTextView noteText=(AutoCompleteTextView)findViewById(R.id.EditSName);
        strSql = "update ClassStr set Name='"+noteText.getText().toString()+"'"
                +" where Username='"+Username
                +"' and No='"
                +ClassNo+"'";
        Log.d("ReadingNote",strSql);
        try
        {
            dbo.execSQL(strSql);
            new AlertDialog.Builder(this).setTitle("提示").setMessage("修改成功").setPositiveButton("确定", null).show();
            MainActivity.actionStart(EditSClassStr.this,Username);
        }
        catch (Exception e)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("修改失败").setPositiveButton("确定", null).show();
        }
    }
}
