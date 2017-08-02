package com.example.kjpro.networkframesample;

import android.app.Application;

import com.example.kjpro.networkframesample.utils.Utils;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
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
    }
}
