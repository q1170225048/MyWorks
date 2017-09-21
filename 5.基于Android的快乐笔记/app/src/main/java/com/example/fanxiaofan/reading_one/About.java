package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    // 函数自定义 ******************************************************************
    public static void actionStart(Context context) {
        Log.d("ReadingNote","开始");
        Intent intent = new Intent(context, About.class);
        context.startActivity(intent);
        Log.d("ReadingNote","结束");
    }
}
