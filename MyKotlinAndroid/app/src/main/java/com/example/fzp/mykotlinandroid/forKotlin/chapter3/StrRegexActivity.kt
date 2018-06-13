package com.example.fzp.mykotlinandroid.forKotlin.chapter3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.fzp.mykotlinandroid.R
import com.example.fzp.mykotlinandroid.forKotlin.STRREGEX

class StrRegexActivity(
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
         * 分割字符串按钮
         */
        private var tvSplitStr: TextView ? = null,
        /**
         * substring扩展函数按钮
         */
        private var tvSubString: TextView ? = null,
        /**
         * 三重引号按钮
         */
        private var tvRegexThree: TextView ? = null,
        /**
         * 多行三重引号按钮
         */
        private var tvMultiline: TextView ? = null
) : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_str_regex)

        initView()
        initEvent()

    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        tvSplitStr?.setOnClickListener(this)
        tvSubString?.setOnClickListener(this)
        tvRegexThree?.setOnClickListener(this)
        tvMultiline?.setOnClickListener(this)
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        layTitleLeft = findViewById(R.id.layout_title_left)
        layTitleRight = findViewById(R.id.layout_title_right)
        tvTitleText = findViewById(R.id.tv_title_title)
        initTitleBar()
        tvSplitStr = findViewById(R.id.tv_split_str)
        tvSubString = findViewById(R.id.tv_substring_extend)
        tvRegexThree = findViewById(R.id.tv_regex_three)
        tvMultiline = findViewById(R.id.tv_multiline)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener(this)
        tvTitleText?.setText("字符串和正则表达式")
        layTitleRight?.visibility = View.INVISIBLE

    }

    /**
     * 点击某个视图时调用
     *
     * @param v 所点击视图
     */
    override fun onClick(v: View?) {
        val txtPath = "E:/傅子鹏/工作/任务工作/安卓相关工作/问题70SR位置信息、地址重新采集/细节.txt"
        when(v?.id){
            R.id.layout_title_left -> {
                finish()
            }

            R.id.tv_split_str ->{
                val result = STRREGEX.split("[.-]".toRegex())
                Toast.makeText(this@StrRegexActivity, result.toString(), Toast.LENGTH_LONG).show()
            }

            R.id.tv_substring_extend ->{
                parsePath(txtPath)
            }

            R.id.tv_regex_three ->{
                parsePathByThree(txtPath)
            }

            R.id.tv_multiline ->{
                val kotlinLogo = """
                                    .|  //
                                    .| //
                                    .|/  \
                """
                val toShow = kotlinLogo.trimMargin(".")
                val price = """$toShow $99.9"""
                Toast.makeText(this@StrRegexActivity, price, Toast.LENGTH_LONG).show()
            }

            else ->{
                Toast.makeText(this@StrRegexActivity, "未知控件", Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * 解析文件路径并提示详情（三重引号）
     */
    private fun parsePathByThree(txtPath: String){
        val regex = """(.+)/(.+)\.(.+)""".toRegex()
        val matchResult = regex.matchEntire(txtPath)
        if (matchResult != null){
            val (directory, fileName, extension) = matchResult.destructured
            Toast.makeText(this@StrRegexActivity, "目录：$directory, 文件名：$fileName, 扩展名：$extension", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * 解析文件路径并提示详情（扩展函数）
     */
    private fun parsePath(txtPath: String) {
        val directory = txtPath.substringBeforeLast("/") //文件目录
        val fullName = txtPath.substringAfterLast("/") //文件完整名称：文件名.扩展名

        val fileName = fullName.substringBeforeLast(".")//文件名
        val extension = fullName.substringAfterLast('.')//扩展名

        Toast.makeText(this@StrRegexActivity,"目录：$directory, 文件名：$fileName, 扩展名：$extension", Toast.LENGTH_LONG).show()
    }
}
