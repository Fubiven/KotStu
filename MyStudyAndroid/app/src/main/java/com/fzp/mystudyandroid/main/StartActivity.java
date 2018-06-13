package com.fzp.mystudyandroid.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.fzp.mystudyandroid.R;
import com.fzp.mystudyandroid.utils.PreCacheUtil;
import com.fzp.mystudyandroid.utils.WindowImmersiveUtil;

public class StartActivity extends AppCompatActivity  {

    /**
     * 控制跳转逻辑
     */
    private StartHandle mHandler = null;
    /**
     * 启动页睡眠时间
     */
    private static final int SLEEP_TIME = 1000;

    /**
     * 跳转到登录界面标识
     */
    private static final int TO_LOGIN = 100001;
    /**
     * 跳转到主界面标识
     */
    private static final int TO_HOME = 100002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowImmersiveUtil.statusBarHide(this);
        setContentView(R.layout.activity_start);
        mHandler = new StartHandle();
        if (PreCacheUtil.getIsLogin()){ /* 已登录 */
            mHandler.sendEmptyMessage(TO_HOME);
        }else{ /* 未登录 */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendEmptyMessage(TO_LOGIN);
                }
            }).start();
        }
    }

    /**
     * 界面跳转控制
     */
    @SuppressLint("HandlerLeak")
    private class StartHandle extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = null;
            switch (msg.what){
                case TO_LOGIN:
                    intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.show, R.anim.hide);/* 淡入淡出平滑过渡 */
                    break;
                case TO_HOME:
                    intent = new Intent(StartActivity.this, HomeActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
            finish();
        }
    }
}


