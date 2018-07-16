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
import com.example.fzp.mykotlinandroid.forKotlin.Chapter4Activity;

/**
 * 类、对象和接口（Java）
 * Created by Fuzp on 2018/06/12
 */
public class Chapter4JavaActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * 知识点1按钮（定义类继承结构）
     */
    private LinearLayout layFirst = null;
    /**
     * 标题栏左按钮
     */
    private LinearLayout layTitleLeft = null;
    /**
     * 标题栏右边按钮
     */
    private LinearLayout layTitleRight = null;
    /**
     * 标题栏文本
     */
    private TextView tvTitleText = null;
    /**
     * 标题栏右按钮图标
     */
    private ImageView ivTitleRight = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);

        initView();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        layFirst.setOnClickListener(this);
    }


    /**
     * 初始化布局
     */
    private void initView() {
        layTitleLeft = findViewById(R.id.layout_title_left);
        layTitleRight = findViewById(R.id.layout_title_right);
        tvTitleText = findViewById(R.id.tv_title_title);
        ivTitleRight = findViewById(R.id.iv_title_right);
        initTitleBar();
        layFirst = findViewById(R.id.layout_first);
    }

    /**
     * 初始化标题栏
     */
    private void initTitleBar() {
        layTitleLeft.setOnClickListener(this);
        tvTitleText.setText("类、对象和接口");
        ivTitleRight.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_kotlin));
        layTitleRight.setOnClickListener(this);
    }

    /**
     * 当点击某个视图时调用
     *
     * @param v 所点击的视图
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_title_left:
                finish();
                break;

            case R.id.layout_title_right:
                Intent toKotlinChapter4 = new  Intent(
                        Chapter4JavaActivity.this, Chapter4Activity.class);
                startActivity(toKotlinChapter4);
                finish();
                break;

            case R.id.layout_first:
                Toast.makeText(
                        Chapter4JavaActivity.this, "进入定义类结构界面", Toast.LENGTH_LONG ).show();
                break;

            default:
                Toast.makeText(
                        Chapter4JavaActivity.this, "未知控件", Toast.LENGTH_LONG ).show();
                break;
        }
    }
}
