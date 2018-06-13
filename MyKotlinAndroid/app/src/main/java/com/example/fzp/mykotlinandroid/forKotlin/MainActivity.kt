package com.example.fzp.mykotlinandroid.forKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.*
import com.example.fzp.mykotlinandroid.forJava.MainJavaActivity
import com.example.fzp.mykotlinandroid.R

/**
 * 主界面 对应Kotlin文件
 * Created by Fuzp on 2018/05/06.
 */
class MainActivity(
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
        private var tvSayHelo: TextView? = null,
        private var tvMenu: TextView? = null,
        private var swIsUse: Switch? = null,
        private var isUseFun: Boolean = false
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        tvSayHelo?.setOnClickListener {
            if (isUseFun) {
                autoSum(10, 22)
            } else {
                Toast.makeText(this, sum(10, 22).toString(), Toast.LENGTH_SHORT).show()
            }
        }
        tvMenu?.setOnClickListener(View.OnClickListener {
            val toKotlinMenu = Intent(this, MenuActivity::class.java)
            startActivity(toKotlinMenu)
        })
        swIsUse?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            isUseFun = isChecked
        })
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
        tvSayHelo = findViewById(R.id.tv_say_hello)
        tvMenu = findViewById(R.id.tv_menu)
        swIsUse = findViewById(R.id.sw_is_use)

    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setVisibility(View.INVISIBLE)
        tvTitleText?.setText(R.string.main_kotlin)
        ivTitleRight?.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_java))
        layTitleRight?.setOnClickListener {
            val toKotlinMain = Intent(this@MainActivity, MainJavaActivity::class.java)
            startActivity(toKotlinMain)
            finish()
        }
    }

    /**
     * 自动提示结果
     */
    private fun autoSum(a: Int, b: Int) {
        Toast.makeText(this, "$a 加上 $b 等于 ${a + b}", Toast.LENGTH_SHORT).show()
    }

    /**
     * 计算两个整数总和返回结果
     */
    private fun sum(a: Int, b: Int): Int {
        return a + b
    }


}
