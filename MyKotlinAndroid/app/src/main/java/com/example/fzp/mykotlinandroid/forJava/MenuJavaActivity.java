package com.example.fzp.mykotlinandroid.forJava;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fzp.mykotlinandroid.R;
import com.example.fzp.mykotlinandroid.forKotlin.MenuActivity;

/**
 * 菜单界面 对应的Javaclass文件
 * Created by Fuzp on 2018/06/07.
 */
public class MenuJavaActivity extends AppCompatActivity implements View.OnClickListener{
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
     * 前往第一章节学习
     */
    private LinearLayout layChapter1 = null;
    /**
     * 前往第二章节学习
     */
    private LinearLayout layChapter2 = null;
    /**
     * 前往第三章节学习
     */
    private LinearLayout layChapter3 = null;
    /**
     * 前往第s四章节学习
     */
    private LinearLayout layChapter4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
        initEvent();

    }

    private void initEvent() {
        layChapter1.setOnClickListener(this);
        layChapter2.setOnClickListener(this);
        layChapter3.setOnClickListener(this);
        layChapter4.setOnClickListener(this);

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
        layChapter1 = findViewById(R.id.layout_chapter_1);
        layChapter2= findViewById(R.id.layout_chapter_2);
        layChapter3 = findViewById(R.id.layout_chapter_3);
        layChapter4 = findViewById(R.id.layout_chapter_4);
    }

    /**
     * 初始化标题栏
     */
    private void initTitleBar() {
        layTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitleText.setText(R.string.menu_java);
        ivTitleRight.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_kotlin));
        layTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toKotlinMenu = new Intent(
                        MenuJavaActivity.this, MenuActivity.class);
                startActivity(toKotlinMenu);
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.layout_chapter_1:
                Toast.makeText(MenuJavaActivity.this,
                        "前往第一章节：Kotlin简介", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_chapter_2:
                Toast.makeText(MenuJavaActivity.this,
                        "前往第二章节：Kotlin基础", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_chapter_3:
                Intent toChapter3 = new Intent(
                        MenuJavaActivity.this, Chapter3JavaActivity.class);
                startActivity(toChapter3);
                break;

            case R.id.layout_chapter_4:
                Intent toChapter4 = new Intent(
                        MenuJavaActivity.this, Chapter4JavaActivity.class);
                startActivity(toChapter4);
                break;

            default:
                Toast.makeText(MenuJavaActivity.this,
                        "课程章节异常", Toast.LENGTH_SHORT).show();
                break;

        }


    }
}
