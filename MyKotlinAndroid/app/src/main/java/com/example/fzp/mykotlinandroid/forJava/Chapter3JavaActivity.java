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
import com.example.fzp.mykotlinandroid.forJava.javachapter3.FunCallJavaActivity;
import com.example.fzp.mykotlinandroid.forKotlin.Chapter3Activity;
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.LocalAndExtendActivity;
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.StrRegexActivity;

/**
 * 函数定义与调用（Java）
 * Created by Fuzp on 2018/06/05
 */
public class Chapter3JavaActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 知识点1按钮
     */
    private LinearLayout layFirst = null;
    /**
     * 知识点2按钮
     */
    private LinearLayout laySecond = null;
    /**
     * 知识点3按钮
     */
    private LinearLayout layThrid = null;
    /**
     * 知识点4按钮
     */
    private LinearLayout layFourth = null;
    /**
     * 知识点5按钮
     */
    private LinearLayout layFifth = null;
    /**
     * 知识点6按钮
     */
    private LinearLayout laySixth = null;
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
        setContentView(R.layout.activity_chapter3);

        initView();
        initEvent();

    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        layFirst.setOnClickListener(this);
        laySecond.setOnClickListener(this);
        layThrid.setOnClickListener(this);
        layFourth.setOnClickListener(this);
        layFifth.setOnClickListener(this);
        laySixth.setOnClickListener(this);
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
        laySecond = findViewById(R.id.layout_second);
        layThrid = findViewById(R.id.layout_third);
        layFourth = findViewById(R.id.layout_fourth);
        layFifth = findViewById(R.id.layout_fifth);
        laySixth = findViewById(R.id.layout_sixth);

    }

    /**
     * 初始化标题栏
     */
    private void initTitleBar() {
        layTitleLeft.setOnClickListener(this);
        tvTitleText.setText("函数定义与调用");
        ivTitleRight.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_kotlin));
        layTitleRight.setOnClickListener(this);

    }

    /**
     * 点击某个视图时调用
     *
     * @param v 所点击视图
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_left:
                finish();
                break;

            case R.id.layout_title_right:
                Intent toKotlinChapter = new Intent(Chapter3JavaActivity.this, Chapter3Activity.class);
                startActivity(toKotlinChapter);
                finish();
                break;

            case R.id.layout_first:
                Toast.makeText(Chapter3JavaActivity.this, "Kotlin集合创建", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_second:
                Intent toSecond = new Intent(Chapter3JavaActivity.this, FunCallJavaActivity.class);
                startActivity(toSecond);
                break;

            case R.id.layout_third:
                Toast.makeText(Chapter3JavaActivity.this, "扩展函数", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_fourth:
                Toast.makeText(Chapter3JavaActivity.this, "处理集合", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_fifth:
                Intent toStrRegex = new Intent(Chapter3JavaActivity.this, StrRegexActivity.class);
                startActivity(toStrRegex);
                break;

            case R.id.layout_sixth:
                Intent toLocalExtend = new Intent(Chapter3JavaActivity.this, LocalAndExtendActivity.class);
                startActivity(toLocalExtend);
                break;

            default:
                Toast.makeText(Chapter3JavaActivity.this, "为止控件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
