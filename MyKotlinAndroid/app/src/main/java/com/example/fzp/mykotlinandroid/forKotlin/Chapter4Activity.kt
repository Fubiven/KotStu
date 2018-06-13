package com.example.fzp.mykotlinandroid.forKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.fzp.mykotlinandroid.R
import com.example.fzp.mykotlinandroid.forJava.Chapter4JavaActivity

/**
 * 类、对象和接口(Kotlin)
 * Created by Fuzp on 2018/06/12
 */
class Chapter4Activity (
        /**
         * 知识点1按钮（定义类继承结构）
         */
        private var layFirst: LinearLayout? = null,
        /**
         * 标题栏左按钮
         */
        private var layTitleLeft: LinearLayout? = null,
        /**
         * 标题栏右边按钮
         */
        private var layTitleRight: LinearLayout? = null,
        /**
         * 标题栏文本
         */
        private var tvTitleText: TextView? = null,
        /**
         * 标题栏右按钮图标
         */
        private var ivTitleRight: ImageView? = null
): AppCompatActivity(),View.OnClickListener {
    /**
     * 当点击某个视图时调用
     *
     * @param v 所点击的视图
     */
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.layout_title_left ->{
                finish()
            }

            R.id.layout_title_right ->{
                val toJavaChapter4 = Intent(
                        this@Chapter4Activity, Chapter4JavaActivity::class.java)
                startActivity(toJavaChapter4)
                finish()
            }

            R.id.layout_first ->{

            }

            else ->{
                Toast.makeText(
                        this@Chapter4Activity, "未知控件", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4)

        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        layFirst?.setOnClickListener(this)
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        layTitleLeft = findViewById(R.id.layout_title_left)
        layTitleRight = findViewById(R.id.layout_title_right)
        tvTitleText = findViewById(R.id.tv_title_title)
        ivTitleRight = findViewById(R.id.iv_title_right)
        initTitleBar()
        layFirst = findViewById(R.id.layout_first)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener(this)
        tvTitleText?.setText("类、对象和接口")
        ivTitleRight?.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_java))
        layTitleRight?.setOnClickListener(this)

    }


}
