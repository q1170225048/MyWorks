package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class DeleteNote extends AppCompatActivity {

    private DB db;
    private  String strno="";
    private SQLiteDatabase dbo;
    private  static String Username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, DeleteNote.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }
    //点击查询按钮事件
    public void btnEditDeleteNote_Click(View view)
    {
        Log.d("ReadingNote","调用删除的读书笔记按钮");
        AutoCompleteTextView bookText=(AutoCompleteTextView)findViewById(R.id.strbooknoND);
        strno=bookText.getText().toString();

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        dbo = db.getWritableDatabase();

        String strSQL="select * from Note where Username='"+Username+"' and BookNo='"+bookText.getText().toString()+"'";
        Log.d("ReadingNote",strSQL);

        Cursor cursor;
        cursor = dbo.rawQuery(strSQL,null);

        if(cursor.getCount()==0)
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("没有相关笔记！").setPositiveButton("确定", null).show();
            return;
        }
        else
        {
            int length=cursor.getCount();
            final String[] choose=new String[length];
            final String[] date=new String[length];
            String[] show=new String[length];
            int i=0;
            while(cursor.moveToNext())
            {
                choose[i]=cursor.getString(cursor.getColumnIndex("Content"));
                Log.d("ReadingNote",choose[i]);
                date[i]=cursor.getString(cursor.getColumnIndex("Date"));
                show[i]=choose[i]+"\n"+date[i];
                i++;
            }

            new AlertDialog.Builder(this).setTitle("请选择")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setSingleChoiceItems(show, 0,
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    DeleteNoteMothed(date[which]);
                                }
                            }
                    )
                    .setNegativeButton("取消", null)
                    .show();
        }
    }


    public void  DeleteNoteMothed(String datestr)
    {
        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        dbo = db.getWritableDatabase();

        String strSQL="delete from Note where Username='"+Username+"' and BookNo='"+strno+"' and Date='"+datestr+"'";
        Log.d("ReadingNote",strSQL);
        dbo.execSQL(strSQL);
        new AlertDialog.Builder(this).setTitle("提示").setMessage("删除成功！").setPositiveButton("确定", null).show();
        MainActivity.actionStart(DeleteNote.this,Username);
    }
}
