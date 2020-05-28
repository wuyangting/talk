package com.example.talk2;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.talk2.adapter.MainPageAdapter;
import com.example.talk2.base.BaseActivity;
import com.example.talk2.base.BasePre;
import com.example.talk2.fragment.DontTaiFragment;
import com.example.talk2.fragment.MessageFragment;
import com.example.talk2.fragment.PeopleFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mTool;
    private ViewPager mViewpageMain;
    private TabLayout mTabRecommend;
    private NavigationView mNavigation;
    private DrawerLayout mDraw;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> tabs;
    private ImageView mBarImgMain;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {

        mTool = (Toolbar) findViewById(R.id.tool);
        mViewpageMain = (ViewPager) findViewById(R.id.main_viewpage);
        mTabRecommend = (TabLayout) findViewById(R.id.main_tab);
        mNavigation = (NavigationView) findViewById(R.id.main_navigation);
        mBarImgMain = (ImageView) findViewById(R.id.main_bar_img);
        mBarImgMain.setOnClickListener(this);
        mDraw = (DrawerLayout) findViewById(R.id.draw);
        mDraw.setOnClickListener(this);
        mTabRecommend.setSelectedTabIndicator(0);
        initFragment();
        initTabs();
        setSupportActionBar(mTool);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDraw, mTool, R.string.open, R.string.close);
        mDraw.addDrawerListener(drawerToggle);
//        drawerToggle.syncState();
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager(), fragments, tabs);
        mViewpageMain.setAdapter(adapter);
        mTabRecommend.setupWithViewPager(mViewpageMain);

    }

    private void initTabs() {
        tabs = new ArrayList<>();
        tabs.add("消息");
        tabs.add("联系人");
        tabs.add("动态");

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new PeopleFragment());
        fragments.add(new DontTaiFragment());
    }

    @Override
    protected BasePre initPre() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.draw:
                // TODO 20/05/28

                break;
            case R.id.main_bar_img:// TODO 20/05/28
                mDraw.openDrawer(mNavigation);
                break;
            default:
                break;
        }
    }
}
