package com.fzp.mystudyandroid.utils;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 全局缓存键值对操作类
 * Created by Administrator on 2018/4/8.
 */

public class PreCacheUtil {
    private static SharedPreferences mPreCacheUtil = null;
    private static SharedPreferences.Editor mEditor = null;
    public static final String BASICINFO = "BasicInfo";

    /**
     * 登录状态
     */
    private static final String PRE_ISLOGIN = "isLogin";
    /**
     * 用户名
     */
    private static final String PRE_USERNAME = "UserName";
    /**
     * 登录密码
     */
    private static final String PRE_PSW = "password";


    /**
     * 缓存登录状态
     * @param isLogin 是否已登录
     */
    public static void setIsLogin(boolean isLogin){
        mEditor.putBoolean(PRE_ISLOGIN, isLogin);
        mEditor.commit();
    }

    /**
     * 获取登录状态
     * @return  （默认未登录）
     */
    public static boolean getIsLogin(){
        return mPreCacheUtil.getBoolean(PRE_ISLOGIN, false);
    }

    /**
     * 缓存用户名
     * @param userName 用户名
     */
    public static void setUserName(String userName){
        mEditor.putString(PRE_USERNAME, userName);
        mEditor.commit();
    }

    /**
     * 获取用户名
     * @return  （默认""）
     */
    public static String getUserName(){
        return mPreCacheUtil.getString(PRE_USERNAME, "");
    }

    /**
     * 缓存密码
     * @param password 密码
     */
    public static void setPassword(String password){
        mEditor.putString(PRE_PSW, password);
        mEditor.commit();
    }

    /**
     * 获取密码
     * @return  （默认""）
     */
    public static String getPassword(){
        return mPreCacheUtil.getString(PRE_PSW, "");
    }


    /**
     * 清空共享缓存
     */
    public static void clearCache(){
        if (mEditor != null){
            mEditor.clear().commit();
        }
    }

    /**
     * 初始化共享缓存实例
     * @param context   所使用上下文
     * @param fileName  文件名
     */
    @SuppressLint("CommitPrefEdits")
    public static  void initPreCache(Context context, String fileName){
        mPreCacheUtil = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mEditor = mPreCacheUtil.edit();
    }


}
