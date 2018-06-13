package com.example.fzp.mykotlinandroid.forJava.javachapter3;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fzp.mykotlinandroid.R;
import com.example.fzp.mykotlinandroid.forKotlin.Chapter3;
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.FunCallActivity;
import java.util.List;


public class FunCallJavaActivity extends AppCompatActivity implements OnClickListener{
    /**
     * 参数命名按钮
     */
    private TextView tvNameParam = null;
    /**
     * 默认参数按钮
     */
    private TextView tvDefaultParam = null;
    /**
     * 扩展按钮
     */
    private TextView tvExtend = null;
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
        setContentView(R.layout.activity_fun_call);

        initView();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        tvNameParam.setOnClickListener(this);
        tvDefaultParam.setOnClickListener(this);
        tvExtend.setOnClickListener(this);
    }

    /**
     * 初始化布局
     */
    private void initView() {
        layTitleLeft = findViewById(R.id.layout_title_left);
        layTitleRight = findViewById(R.id.layout_title_right);
        ivTitleRight = findViewById(R.id.iv_title_right);
        tvTitleText = findViewById(R.id.tv_title_title);
        initTitleBar();
        tvNameParam = findViewById(R.id.tv_name_param);
        tvDefaultParam = findViewById(R.id.tv_default_param);
        tvExtend = findViewById(R.id.tv_extend);
    }

    /**
     * 初始化标题栏
     */
    private void initTitleBar() {
        layTitleLeft.setOnClickListener(this);
        tvTitleText.setText("函数调用");
        ivTitleRight.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_kotlin));
        layTitleRight.setOnClickListener(this);
    }

    /**
     * 点击某个视图时调用
     *
     * @param v 所点击的视图
     */
    @Override
    public void onClick(View v) {
        List<Integer> list = Chapter3.getList();
        int flag = Chapter3.FLAG;
        switch (v.getId()){
            case R.id.layout_title_left:
                finish();
                break;
            case R.id.layout_title_right:
                Intent toFunCallKotlin = new Intent(FunCallJavaActivity.this, FunCallActivity.class);
                startActivity(toFunCallKotlin);
                finish();
                break;
            case R.id.tv_name_param:
                String resultStr1 = Chapter3.joinToString(list, "; ", "< ", " >");
                Toast.makeText(FunCallJavaActivity.this, flag +" === "+ resultStr1, Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_default_param:
                String resultStr2 = Chapter3.joinString(list);
                Toast.makeText(FunCallJavaActivity.this, flag +" === "+ resultStr2, Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_extend:
                Toast.makeText(FunCallJavaActivity.this,Chapter3.lastChar("Java"), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(FunCallJavaActivity.this, "未知控件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
