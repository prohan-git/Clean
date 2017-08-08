package com.example.tjun.clean.base;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.tjun.clean.R;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

/****
 * <pre>
 *  Project_Name:    Clean
 *  Copyright:       Copyright  2017-2017 
 *  Version:         1.0.0.1
 *  Created:         proha on 2017/8/6 0006 18:54.
 *  E-mail:          kjprohan@outlook.com
 *  Desc:            
 * </pre> 
 ****/

public abstract class BaseActiviry extends AppCompatActivity {
    protected Unbinder unbind;
    protected Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        unbind = ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    getResources().getColor(R.color.colorPrimary));
            setTaskDescription(description);
        }

    }

    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
        unbind.unbind();
    }

    protected void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    getResources().getColor(R.color.colorPrimary));
            setTaskDescription(description);
        }
    }
}
