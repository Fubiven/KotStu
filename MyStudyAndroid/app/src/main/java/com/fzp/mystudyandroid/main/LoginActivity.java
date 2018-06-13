package com.fzp.mystudyandroid.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fzp.mystudyandroid.R;
import com.fzp.mystudyandroid.myEvent.MyClickListener;
import com.fzp.mystudyandroid.utils.PreCacheUtil;
import com.fzp.mystudyandroid.utils.WindowImmersiveUtil;
import com.fzp.mystudyandroid.views.aboutDialog.PromptDialog;

/**
 * 登录界面
 * Created by Fuzp on 2018/4/8.
 */

public class LoginActivity extends AppCompatActivity {
    private static final int TO_HOME = 100002;
    /**
     * 账号
     */
    private String mAccount = "";
    /**
     * 密码
     */
    private String mPSW = "";

    /**
     * 账号输入框
     */
    private EditText edtAccount = null;
    /**
     * 密码输入框
     */
    private EditText edtPSW = null;
    /**
     * 登录按钮
     */
    private LinearLayout layoutLoginBtn = null;
    /**
     * 忘记密码文本
     */
    private TextView tvForgotPSW = null;
    /**
     * 用户注册文本
     */
    private TextView tvUserRegistration = null;
    /**
     * 服务条款文本
     */
    private TextView tvTerms = null;
    private LoginHandler mHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowImmersiveUtil.statusBarHide(this);
        setContentView(R.layout.activity_login);
        initData();
        initView();
        initEvent();
    }

    /**
     * 初始化事件监听
     */
    private void initEvent() {
        edtAccount.addTextChangedListener(mAccountWatcher);
        edtPSW.addTextChangedListener(mPSWtWatcher);
        tvForgotPSW.setOnClickListener(onFogetPSWClick);
        tvUserRegistration.setOnClickListener(onRegistrationClick);
        tvTerms.setOnClickListener(onTermsClick);
        layoutLoginBtn.setOnClickListener(onLoginClick);
    }

    /**
     * 初始化布局
     */
    private void initView() {
        bindView();
        edtAccount.setText(mAccount);
        edtPSW.setText(mPSW);
    }

    private void bindView() {
        edtAccount = this.findViewById(R.id.edt_login_account);
        edtPSW = this.findViewById(R.id.edt_login_psw);
        layoutLoginBtn = this.findViewById(R.id.layout_login_btn);
        tvForgotPSW = this.findViewById(R.id.tv_forgot_psw);
        tvUserRegistration = this.findViewById(R.id.tv_user_registration);
        tvTerms = this.findViewById(R.id.tv_terms);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mHandler = new LoginHandler();
        mAccount = PreCacheUtil.getUserName();
        mPSW = PreCacheUtil.getPassword();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    /**
     * 登录按钮点击事件监听
     */
    private MyClickListener onLoginClick = new MyClickListener() {
        @Override
        protected void myClick(View view) {
            if (TextUtils.isEmpty(mAccount)){
                new PromptDialog(LoginActivity.this, "友情提示", "请输入账号").show();
                return;
            }
            if (TextUtils.isEmpty(mPSW)){
                new PromptDialog(LoginActivity.this, "友情提示", "请输入密码").show();
                return;
            }
            PreCacheUtil.setIsLogin(true);
            PreCacheUtil.setUserName(mAccount);
            PreCacheUtil.setPassword(mPSW);
            mHandler.sendEmptyMessage(TO_HOME);

        }
    };

    /**
     * 服务条款文本点击事件监听
     */
    private MyClickListener onTermsClick = new MyClickListener() {
        @Override
        protected void myClick(View view) {
            new PromptDialog(LoginActivity.this,"友情提示", "压根没这个东西！").show();
        }
    };

    /**
     * 账号注册文本点击事件监听
     */
    private MyClickListener onRegistrationClick = new MyClickListener() {
        @Override
        protected void myClick(View view) {
            new PromptDialog(LoginActivity.this,"友情提示", "不需要注册，随便登录！").show();
        }
    };

    /**
     * 忘记密码文本点击事件监听
     */
    private MyClickListener onFogetPSWClick = new MyClickListener() {
        @Override
        protected void myClick(View view) {
            new PromptDialog(LoginActivity.this,"友情提示", "忘记了怪谁？").show();
        }
    };

    /**
     * 账号输入框监听器
     */
    private TextWatcher mAccountWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mAccount = s.toString();
        }
    };

    /**
     * 密码输入框监听器
     */
    private TextWatcher mPSWtWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mPSW = s.toString();
        }
    };

    @SuppressLint("HandlerLeak")
    private class  LoginHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = null;
            switch (msg.what){
                case TO_HOME:
                    intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
            finish();
        }
    }

}
