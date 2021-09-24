package com.example.myapplication1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends  Activity {

    private TextView tex;
    private int tx;
    private Context  mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        tex = (TextView) findViewById(R.id.tex);
        registerReceiver(loginrevcer, new IntentFilter("mmm")); // 注册广播接受者
    }

    private BroadcastReceiver loginrevcer = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            tx ++;
            tex.setText("=="+tx);
            senBroadcast();// 收到A apk 发过来的广播后，再发广播给A apk
        }
    };

    private void senBroadcast(){
        Intent intent = new Intent("kkk");
        intent.putExtra("tx", tx);// 广播带参数
        mContext.sendBroadcast(intent);
    }

}