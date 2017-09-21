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

public class EditNote extends AppCompatActivity {

    private static String Username;
    private static String bookNo;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
    }

    public static void actionStart(Context context, String username) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, EditNote.class);
        context.startActivity(intent);
        Username=username;
        Log.d("ReadingNote","结束");
    }

    //点击添加按钮事件
    public void btnEditNoteFindBook_Click(final View view)
    {
        Log.d("ReadingNote","查询书籍，修改笔记");
        AutoCompleteTextView bookText=(AutoCompleteTextView)findViewById(R.id.bookNOEN);
        Log.d("ReadingNote",bookText.getText().toString());

        bookNo=bookText.getText().toString();

        db = new DB(this,"dbReadingNote.db",null,1);
        Log.d("ReadingNote","调用db.getReadableDatabase");
        db.getReadableDatabase();
        Log.d("ReadingNote","调用db.getWritableDatabase()");
        SQLiteDatabase dbo = db.getWritableDatabase();

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
                                    EditSNote.actionStart(EditNote.this,Username,choose[which],date[which],bookNo);
                                }
                            }
                    )
                    .setNegativeButton("取消", null)
                    .show();
        }
    }
}
