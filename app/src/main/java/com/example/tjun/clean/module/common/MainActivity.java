package com.example.tjun.clean.module.common;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tjun.clean.R;
import com.example.tjun.clean.base.BaseActiviry;
import com.example.tjun.clean.base.LazyFragment;
import com.example.tjun.clean.module.home.BlankFragment;
import com.example.tjun.clean.module.order.OrderFragment;
import com.example.tjun.clean.module.user.UserFragment;
import com.example.tjun.clean.utils.BottomNavigationViewHelper;
import com.example.tjun.clean.utils.FragmentUtils;
import com.example.tjun.clean.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActiviry implements LazyFragment.OnFragmentInteractionListener {
    @BindView(R.id.navigation)
    BottomNavigationView nNavigation;

    BlankFragment statisticsFragment;
    UserFragment userFragment;
    OrderFragment orderFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initListener();
        //初始化Fragment
        initFragments();
        //初始底部导航
        initNavigationView();
        //初始化标题栏
        initToolBar();
    }

    /**
     * 初始化Listener
     */
    private void initListener() {
        //导航栏
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentUtils.hideFragments(getSupportFragmentManager());
                switch (item.getItemId()) {
                    case R.id.navigation_home:

                        if (statisticsFragment == null) {
                            statisticsFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame) instanceof BlankFragment
                                    ? ((BlankFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame))
                                    : null;
                            statisticsFragment = BlankFragment.newInstance("1", "2");
                            FragmentUtils.addFragment(getSupportFragmentManager(), statisticsFragment, R.id.contentFrame);
                        } else {
                            FragmentUtils.showFragment(statisticsFragment);
                            Logger.d("showMain");
                        }
                        return true;
                    case R.id.navigation_dashboard:
                        if (orderFragment == null) {
                            orderFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame) instanceof OrderFragment
                                    ? ((OrderFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame))
                                    : null;
                            orderFragment = OrderFragment.newInstance("1", "2");
                            FragmentUtils.addFragment(getSupportFragmentManager(), orderFragment, R.id.contentFrame);
                        } else {
                            FragmentUtils.showFragment(orderFragment);
                            Logger.d("showorderFragment");
                        }
                        return true;
                    case R.id.navigation_user:
                        if (userFragment == null) {
                            userFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame) instanceof UserFragment
                                    ? ((UserFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame))
                                    : null;
                            userFragment = UserFragment.newInstance("1", "2");
                            FragmentUtils.addFragment(getSupportFragmentManager(), userFragment, R.id.contentFrame);
                        } else {
                            FragmentUtils.showFragment(userFragment);
                            Logger.d("showuser");
                        }
                        return true;
                }
                return false;
            }
        };
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
    }

    /**
     * 初始化NavigationView，以及内容
     */
    private void initNavigationView() {
        nNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //BottomNavigationViewHelper.disableShiftMode(nNavigation);
    }

    /**
     * 初始化Fragment
     */
    private void initFragments() {
        if (statisticsFragment == null) {
            statisticsFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame) instanceof BlankFragment
                    ? ((BlankFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame))
                    : null;
            statisticsFragment = BlankFragment.newInstance("1", "2");
            FragmentUtils.addFragment(getSupportFragmentManager(), statisticsFragment, R.id.contentFrame);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Logger.d("onOptionsItemSelected");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String str) {
        ToastUtils.showShort(str);
    }
}
