package com.example.fzp.mykotlinandroid.forKotlin.chapter3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.fzp.mykotlinandroid.R


class LocalAndExtendActivity(
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
         * 传统代码格式按钮
         */
        private var tvTraditionCode: TextView? = null,
        /**
         * 局部函数优化代码按钮
         */
        private var tvLocalCode: TextView? = null,
        /**
         * 局部函数和扩展优化代码按钮
         */
        private var tvLocalExtend: TextView? = null
        ) : AppCompatActivity(), OnClickListener {

    /**
     * 点击某个视图时调用
     *
     * @param v 所点击的视图
     */
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.layout_title_left ->{
                finish()
            }

            R.id.tv_tradition_code ->{
                traditionCode(LocalUser(id = 1, address = "厦禾路120号1022室"))
            }

            R.id.tv_local_code ->{
                localCode(LocalUser(id = 2, name = "老王", address = "莲前街道西林路112号504室"))
            }

            R.id.tv_local_extend ->{
                localExtend(LocalUser(3, "老张", "禾祥西路205号A栋202室"))
            }

            else ->{
                Toast.makeText(this@LocalAndExtendActivity, "未知控件", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_and_extend)

        initView()
        initEvent()
    }

    /**
     * 初始化事件
     */
    private fun initEvent() {
        tvTraditionCode?.setOnClickListener(this)
        tvLocalCode?.setOnClickListener(this)
        tvLocalExtend?.setOnClickListener(this)
    }

    /**
     * 初始化界面
     */
    private fun initView() {
        layTitleLeft = findViewById(R.id.layout_title_left)
        layTitleRight = findViewById(R.id.layout_title_right)
        tvTitleText = findViewById(R.id.tv_title_title)
        initTitleBar()
        tvTraditionCode = findViewById(R.id.tv_tradition_code)
        tvLocalCode = findViewById(R.id.tv_local_code)
        tvLocalExtend = findViewById(R.id.tv_local_extend)
    }

    /**
     * 初始化标题栏
     */
    private fun initTitleBar() {
        layTitleLeft?.setOnClickListener(this)
        tvTitleText?.setText("局部函数和扩展")
        layTitleRight?.visibility = View.INVISIBLE
    }

    private fun localExtend(user: LocalUser){
        val canSave = user.validateBeforeSave()
        if (canSave) {
            saveUserData(user.id, user.name, user.address)
        }
    }

    /**
     * 局部函数和扩展检查用户信息
     */
    private fun LocalUser.validateBeforeSave():Boolean{
        var canSave = true
        fun validate(value: String, fieldName: String) {
            if(TextUtils.isEmpty(value)){
                Toast.makeText(this@LocalAndExtendActivity, "无法保存用户 $id: $fieldName 非法", Toast.LENGTH_LONG).show()
                canSave = false
            }
        }

        validate(name, "姓名")
        if (canSave){
            validate(address, "住址")
        }

        return canSave
    }

    /**
     * 使用局部函数进行适当优化后
     */
    private fun localCode(user: LocalUser){
        fun validate(value: String, fieldName: String){
            if(TextUtils.isEmpty(value)){
                Toast.makeText(this@LocalAndExtendActivity, "无法保存用户 ${user.id}: $fieldName 非法", Toast.LENGTH_LONG).show()
            }
        }
        validate(user.name, "姓名")
        validate(user.address, "住址")

        saveUserData(user.id, user.name, user.address)
    }

    /**
     * 传统代码编写方式
     */
    private fun traditionCode(user: LocalUser){
        /* 检查用户名称合法性 */
        if(TextUtils.isEmpty(user.name)){
            Toast.makeText(this@LocalAndExtendActivity, "无法保存用户 ${user.id}: 姓名非法", Toast.LENGTH_LONG).show()
            return
        }

        /* 检查地址合法性 */
        if(TextUtils.isEmpty(user.address)){
            Toast.makeText(this@LocalAndExtendActivity, "无法保存用户 ${user.id}: 住址非法", Toast.LENGTH_LONG).show()
            return
        }

        saveUserData(user.id, user.name, user.address)

    }

    /**
     * 保存用户信息
     */
    private fun saveUserData(id: Int, name: String , address: String) {
        val toShow = """录入用户信息:
            |id：$id,
            |姓名：$name,
            |住址：$address
        """
        Toast.makeText(this@LocalAndExtendActivity, toShow.trimMargin("|").trimMargin(), Toast.LENGTH_LONG).show()
    }

    /**
     * 局部测试用户类
     */
    class  LocalUser(val id: Int, val name: String = "", val address: String)

}

