@file:JvmName("Chapter3")
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
import com.example.fzp.mykotlinandroid.forJava.Chapter3JavaActivity
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.FunCallActivity
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.LocalAndExtendActivity
import com.example.fzp.mykotlinandroid.forKotlin.chapter3.StrRegexActivity
import java.lang.StringBuilder

/**
 * 数组转字符串输出
 */
 @JvmOverloads
 fun<T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "( ",
        postfix: String = " )"):String{
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()){
        if (index > 0){
            result.append(separator)
        }
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

@JvmOverloads
fun <T> Collection<T>.joinString(
        separator: String = ", ",
        prefix: String = "( ",
        postfix: String = " )"
): String{
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if (index > 0){
            result.append(separator)
        }
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

/**
 * 字符串扩展函数： 获取字符串最后一个字节
 */
fun String.lastChar(): String = this.get(this.length -1).toString()

/**
 * 顶层属性
 */
val list = listOf(1, 2, 3, 4, 8, 10, 12)

/**
 * 字符串和正则测试字符串
 */
val STRREGEX = "12.345-6.A"

/**
 * 固定标识
 */
const val FLAG = 10086;

/**
 * 函数定义与调用(Kotlin)
 * Created by Fuzp on 2018/06/07
 */
class Chapter3Activity(
        /**
         * 知识点1按钮
         */
        private var layFirst: LinearLayout? = null,
        /**
         * 知识点2按钮
         */
        private var laySecond: LinearLayout? = null,
        /**
         * 知识点3按钮
         */
        private var layThird: LinearLayout? = null,
        /**
         * 知识点4按钮
         */
        private var layFourth: LinearLayout? = null,
        /**
         * 知识点5按钮
         */
        private var layFifth: LinearLayout? = null,
        /**
         * 知识点6按钮
         */
        private var laySixth: LinearLayout? = null,
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

) : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter3)
        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        layFirst?.setOnClickListener(this)
        laySecond?.setOnClickListener(this)
        layThird?.setOnClickListener(this)
        layFourth?.setOnClickListener(this)
        layFifth?.setOnClickListener(this)
        laySixth?.setOnClickListener(this)
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
        laySecond = findViewById(R.id.layout_second)
        layThird = findViewById(R.id.layout_third)
        layFourth = findViewById(R.id.layout_fourth)
        layFifth = findViewById(R.id.layout_fifth)
        laySixth = findViewById(R.id.layout_sixth)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener(this)
        tvTitleText?.setText("函数定义与调用")
        ivTitleRight?.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.icon_java))
        layTitleRight?.setOnClickListener(this)
    }

    /**
     * 点击某个视图时调用
     *
     * @param v 所点击视图
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layout_title_left -> {
                finish()
            }

            R.id.layout_title_right -> {
                val toJavaChapter = Intent(this@Chapter3Activity, Chapter3JavaActivity::class.java)
                startActivity(toJavaChapter)
                finish()
            }

            R.id.layout_first -> {
                Toast.makeText(this@Chapter3Activity, "Kotlin集合创建", Toast.LENGTH_SHORT).show()
            }

            R.id.layout_second -> {
                val toSecond = Intent(this@Chapter3Activity, FunCallActivity::class.java)
                startActivity(toSecond)
            }

            R.id.layout_third -> {
                Toast.makeText(this@Chapter3Activity, "扩展函数", Toast.LENGTH_SHORT).show()
            }

            R.id.layout_fourth -> {
                Toast.makeText(this@Chapter3Activity, "处理集合", Toast.LENGTH_SHORT).show()
            }

            R.id.layout_fifth -> {
                val toStrRegex = Intent(this@Chapter3Activity, StrRegexActivity::class.java)
                startActivity(toStrRegex)
            }

            R.id.layout_sixth -> {
                val toLocalExtend = Intent(this@Chapter3Activity, LocalAndExtendActivity::class.java)
                startActivity(toLocalExtend)
            }

            else -> {
                Toast.makeText(this@Chapter3Activity, "未知控件", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
