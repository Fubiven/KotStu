package com.example.fzp.mykotlinandroid.forJava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fzp.mykotlinandroid.R;
import com.example.fzp.mykotlinandroid.forKotlin.MainActivity;

/**
 * 主界面 对应的Javaclass文件
 * Created by Fuzp on 2018/05/06.
 */

public class MainJavaActivity extends AppCompatActivity {
    /**
     * 标题栏左按钮
     */
    private LinearLayout layTitleLeft = null;
    /**
     * 标题栏右按钮
     */
    private LinearLayout layTitleRight = null;
    /**
     * 标题栏文本
     */
    private TextView tvTitleText = null;
    /**
     * 标题栏左按钮图标
     */
    private ImageView ivTitleLeft = null;
    /**
     * 标题栏右按钮图标
     */
    private ImageView ivTitleRight = null;
    /**
     * 主页文本
     */
    private TextView tvSayHelo = null;
    /**
     * 前往菜单按钮
     */
    private TextView tvMenu = null;
    /**
     * 是否使用契机
     */
    private Switch swIsUse = null;
    /**
     * 是否调用方法
     */
    private boolean isUseFun = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        tvSayHelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUseFun){
                    autoSum(10, 22);
                }else{
                    Toast.makeText(
                            MainJavaActivity.this,  sum(10, 22), Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toJavaMenu = new Intent(
                        MainJavaActivity.this, MenuJavaActivity.class);
                startActivity(toJavaMenu);
            }
        });
        swIsUse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isUseFun = isChecked;
            }
        });
    }

    /**
     * 初始化布局
     */
    private void initView() {
        layTitleLeft = findViewById(R.id.layout_title_left);
        layTitleRight = findViewById(R.id.layout_title_right);
        tvTitleText = findViewById(R.id.tv_title_title);
        ivTitleLeft = findViewById(R.id.iv_title_left);
        ivTitleRight = findViewById(R.id.iv_title_right);
        initTitleBar();
        tvSayHelo = findViewById(R.id.tv_say_hello);
        tvMenu = findViewById(R.id.tv_menu);
        swIsUse = findViewById(R.id.sw_is_use);
    }

    /**
     * 初始化标题栏
     */
    private void initTitleBar() {
        layTitleLeft.setVisibility(View.INVISIBLE);
        tvTitleText.setText(R.string.main_java);
        ivTitleRight.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_kotlin));
        layTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toKotlinMain = new Intent(
                        MainJavaActivity.this, MainActivity.class);
                startActivity(toKotlinMain);
                finish();
            }
        });
    }

    /**
     * 自动提示结果
     */
    private void autoSum(int a, int b) {
        Toast.makeText(this, a + " 加上 " + b + " 等于 " + (a+b), Toast.LENGTH_SHORT).show();
    }

    /**
     * 计算两个整数总和返回结果
     */
    private  int sum (int a, int b){
        return a + b;
    }
}
