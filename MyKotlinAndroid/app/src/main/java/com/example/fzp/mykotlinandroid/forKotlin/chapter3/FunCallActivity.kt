package com.example.fzp.mykotlinandroid.forKotlin.chapter3

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
import com.example.fzp.mykotlinandroid.forJava.javachapter3.FunCallJavaActivity
import com.example.fzp.mykotlinandroid.forKotlin.*

class FunCallActivity (
        /**
         * 参数命名按钮
         */
        private var tvNameParam: TextView ?= null,
        /**
         * 默认参数按钮
         */
        private var tvDefaultParam: TextView ?= null,
        /**
         * 扩展按钮
         */
        private var tvExtend: TextView? = null,
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
) : AppCompatActivity(), View.OnClickListener{
    /**
     * 点击某个视图时调用
     *
     * @param v 所点击的视图
     */
    override fun onClick(v: View?) {

        when(v?.id){
            R.id.layout_title_left ->{ // 标题栏左按钮
                finish()
            }

            R.id.layout_title_right ->{ // 标题栏右按钮
                val toFunCallJava = Intent(this@FunCallActivity, FunCallJavaActivity::class.java)
                startActivity(toFunCallJava)
                finish()
            }

            R.id.tv_name_param ->{ //参数命名
                val resultStr = joinToString(list, separator = "; ", prefix = "< ", postfix = " >")
                Toast.makeText(this@FunCallActivity, FLAG.toString() + " === " + resultStr, Toast.LENGTH_LONG).show()
            }

            R.id.tv_default_param ->{ //默认参数
                val resultStr = list.joinString(prefix = "{ ", postfix = " }")
                Toast.makeText(this@FunCallActivity, FLAG.toString() + " === "+ resultStr, Toast.LENGTH_LONG).show()
            }

            R.id.tv_extend -> { //扩展函数和属性
               Toast.makeText(this@FunCallActivity, "Kotlin".lastChar(), Toast.LENGTH_SHORT).show()
            }

            else ->{
                Toast.makeText(this@FunCallActivity, "未知控件", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_call)

        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        tvNameParam?.setOnClickListener(this)
        tvDefaultParam?.setOnClickListener(this)
        tvExtend?.setOnClickListener(this)
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        layTitleLeft = findViewById(R.id.layout_title_left)
        layTitleRight = findViewById(R.id.layout_title_right)
        ivTitleRight =findViewById(R.id.iv_title_right)
        tvTitleText = findViewById(R.id.tv_title_title)
        initTitleBar()
        tvNameParam = findViewById(R.id.tv_name_param)
        tvDefaultParam = findViewById(R.id.tv_default_param)
        tvExtend = findViewById(R.id.tv_extend)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener(this)
        tvTitleText?.setText("函数调用")
        ivTitleRight?.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_java))
        layTitleRight?.setOnClickListener(this)
    }

}
