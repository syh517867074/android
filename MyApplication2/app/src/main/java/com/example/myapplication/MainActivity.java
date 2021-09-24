package com.example.myapplication;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// A pak 开始  2016-07-23
public class MainActivity extends  Activity {

    private  Button  but;
    private Context  mContext;
    private TextView tk;
    private Timer tim =new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        registerReceiver(loginrevcer, new IntentFilter("kkk"));  // 注册广播
        tk = (TextView) findViewById(R.id.tk);
        but = (Button) findViewById(R.id.bu_t);
        // 定时发送广播
        tim.schedule(timT, 1000, 1000); // 1s后执行task,经过1s再次执行
    }

    TimerTask  timT = new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent("mmm");
            mContext.sendBroadcast(intent); // 发送广播给 B apk
        }
    };

    private BroadcastReceiver loginrevcer = new BroadcastReceiver(){// 接受B apk发过来的广播
        @Override
        public void onReceive(Context arg0, Intent intent) {
            int sk = intent.getIntExtra("tx", 000);// B APK 发送过来的数据
            tk.setText(sk+"");
        }
    };
}