package com.example.fzp.mykotlinandroid.forKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.fzp.mykotlinandroid.R
import com.example.fzp.mykotlinandroid.forJava.MenuJavaActivity

/**
 * 菜单界面 对应Kotlin文件
 * Created by Fuzp on 2018/06/07.
 */
class MenuActivity(
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
         * 标题栏左按钮图标
         */
        private var ivTitleLeft: ImageView? = null,
        /**
         * 标题栏右按钮图标
         */
        private var ivTitleRight: ImageView? = null,

        /**
         * 前往第一章节学习
         */
        private var layChapter1: LinearLayout? = null,
        /**
         * 前往第二章节学习
         */
        private var layChapter2: LinearLayout? = null,
        /**
         * 前往第三章节学习
         */
        private var layChapter3: LinearLayout? = null,
        /**
         * 前往第四章节学习
         */
        private var layChapter4: LinearLayout? = null
) : AppCompatActivity(), OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        layChapter1?.setOnClickListener(this)
        layChapter2?.setOnClickListener(this)
        layChapter3?.setOnClickListener(this)
        layChapter4?.setOnClickListener(this)
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        layTitleLeft = findViewById(R.id.layout_title_left)
        layTitleRight = findViewById(R.id.layout_title_right)
        tvTitleText = findViewById(R.id.tv_title_title)
        ivTitleLeft = findViewById(R.id.iv_title_left)
        ivTitleRight = findViewById(R.id.iv_title_right)
        initTitleBar()
        layChapter1 = findViewById(R.id.layout_chapter_1)
        layChapter2 = findViewById(R.id.layout_chapter_2)
        layChapter3 = findViewById(R.id.layout_chapter_3)
        layChapter4 = findViewById(R.id.layout_chapter_4)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener { finish() }
        tvTitleText?.setText(R.string.menu_kotlin)
        ivTitleRight?.setImageDrawable(ContextCompat.getDrawable(this@MenuActivity, R.mipmap.icon_java))
        layTitleRight?.setOnClickListener {
            val toJavaMenu = Intent(this@MenuActivity, MenuJavaActivity::class.java)
            startActivity(toJavaMenu)
            finish()
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layout_chapter_1 -> {
                Toast.makeText(this@MenuActivity,
                        "前往第一章节：Kotlin简介", Toast.LENGTH_SHORT).show()
            }

            R.id.layout_chapter_2 -> {
                Toast.makeText(this@MenuActivity,
                        "前往第二章节：Kotlin基础", Toast.LENGTH_SHORT).show()

            }

            R.id.layout_chapter_3 -> {
                val toChapter = Intent(this@MenuActivity, Chapter3Activity::class.java)
                startActivity(toChapter)
            }

            R.id.layout_chapter_4 ->{
                val toChapter = Intent(this@MenuActivity, Chapter4Activity::class.java)
                startActivity(toChapter)
            }

            else ->{
                Toast.makeText(this@MenuActivity,
                        "课程章节异常", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
