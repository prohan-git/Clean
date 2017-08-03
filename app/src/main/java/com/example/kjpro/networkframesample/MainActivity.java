package com.example.kjpro.networkframesample;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kjpro.networkframesample.module.module1.BlankFragment;
import com.example.kjpro.networkframesample.utils.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

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

    /**
     * 初始化Listener
     */
    private void initListener() {
        //抽屉点击
        navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_camera:
                        return true;
                }
                toggleDrawer();
                return false;
            }
        };
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });
    }

    /**
     * 初始化NavigationView，以及内容
     */
    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
        View headerView = navigationView.getHeaderView(0);
        TextView mUserName = (TextView) headerView.findViewById(R.id.textView);
        mUserName.setText("tijun");
    }

    /**
     * 初始化Fragment
     */
    private void initFragments() {
        BlankFragment statisticsFragment = (BlankFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        if (statisticsFragment == null) {
            statisticsFragment = BlankFragment.newInstance("1", "2");
            FragmentUtils.addFragment(getSupportFragmentManager(), statisticsFragment, R.id.contentFrame);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
