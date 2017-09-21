package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class AddUser extends AppCompatActivity {

    //变量
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AddUser.class);
        context.startActivity(intent);
    }
    //注册用户事件
    public void btnAddUserTURE_Click(View view)
    {
        Log.d("ReadingNote","调用注册确定按钮");
        AutoCompleteTextView StrEmail=(AutoCompleteTextView)findViewById(R.id.EmailStr);
        AutoCompleteTextView StrNmae=(AutoCompleteTextView)findViewById(R.id.NameStr);
        AutoCompleteTextView StrPassword=(AutoCompleteTextView)findViewById(R.id.PasswordStr);
        AutoCompleteTextView StrPasswordRe=(AutoCompleteTextView)findViewById(R.id.PasswordStrRe);

        String email = StrEmail.getText().toString();
        String name=StrNmae.getText().toString();
        String password = StrPassword.getText().toString();
        String passwordre=StrPasswordRe.getText().toString();
        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (email.isEmpty()) {
            StrEmail.setError("邮箱为必填项！");
            focusView = StrEmail;
            return;
        }
        if(password.isEmpty())
        {
            StrPassword.setError("密码为必填项！");
            focusView = StrPassword;
            return;
        }
        if(!isEmailValid(email))
        {
            StrEmail.setError("请输入合法的邮箱！");
            focusView = StrEmail;
            return;
        }
        if (email.length()<=4)
        {
            StrEmail.setError("邮箱长度太短！");
            focusView = StrEmail;
            return;
        }
        if(password.length()<=4)
        {
            StrPassword.setError("密码长度太短！");
            focusView = StrPassword;
            return;
        }
        if(!password.equals(passwordre))
        {
            StrPasswordRe.setError("两次密码输入不一致");
            focusView=StrPasswordRe;
            return;
        }

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        //获取读取数据库权限
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "insert into Userinformation values('"+email +"','"
                                                                     +name+"','"
                                                                     +password+"')";
        Log.d("ReadingNote",strSql);
        String strSql2 = "";
        strSql2 = "select * from Userinformation where Email="+"'"+email+"'";
        Cursor cursor;
        Log.d("ReadingNote","查询之前");
        cursor = dbo.rawQuery(strSql2,null);
        if(cursor.getCount()==0)
        {
            dbo.execSQL(strSql);
        }
        else
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("此邮箱已经注册！").setPositiveButton("确定", null).show();
            return;
        }
        new AlertDialog.Builder(this).setTitle("提示").setMessage("注册成功").setPositiveButton("确定", null).show();
        LoginActivity.actionStart(AddUser.this);
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
