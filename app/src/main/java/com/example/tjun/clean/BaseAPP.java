package com.example.tjun.clean;

import android.app.Application;

import com.example.tjun.clean.utils.Utils;
import com.squareup.leakcanary.LeakCanary;


/****
 * </pre> 
 *  Project_Name:    clean
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/7/31 0031 14:09.
 *  E-mail:          prohankj@outlook.com
 *  Desc: 
 * </pre>            
 ****/
public class BaseAPP extends Application {
    private static BaseAPP mInstance;

    public static BaseAPP getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Utils.init(this);
        //初始化Leak内存泄露检测工具
        LeakCanary.install(this);
    }
}
