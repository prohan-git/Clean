package com.example.kjpro.networkframesample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kjpro.networkframesample.model.ZhuangbiImage;
import com.example.kjpro.networkframesample.network.RetrofitHelper;
import com.example.kjpro.networkframesample.network.requestBody.PostRequestBody;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    protected Subscription subscription;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
        //初始化Fragment
        initFragments();
        //初始化侧滑菜单
        initNavigationView();
        //初始化标题栏
        initToolBar();
    }

    private void initListener() {
        //抽屉点击
        navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_camera:
                        search("装逼");
                        return true;
                }
                toggleDrawer();
                return false;
            }
        };
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
        View headerView = navigationView.getHeaderView(0);
        TextView mUserName = (TextView) headerView.findViewById(R.id.textView);
        mUserName.setText("tijun");
    }

    private void initFragments() {
    }

    @Override
    public void onBackPressed() {
        toggleDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }


    private void search(String key) {

        subscription = RetrofitHelper.getBaseApi()
                //.search2("Converse诞生于1908","1","comp")
                // .search1(new PostAction("Converse诞生于1908", "1", "comp"))
                .search3(new PostRequestBody("Converse诞生于1908", "1", "comp").init())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ZhuangbiImage>>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("onError" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<ZhuangbiImage> zhuangbiImages) {
                        Logger.d("onNext你好");
                    }
                });
    }
}
