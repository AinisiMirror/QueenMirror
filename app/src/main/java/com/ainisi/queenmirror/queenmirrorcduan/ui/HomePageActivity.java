package com.ainisi.queenmirror.queenmirrorcduan.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseOneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeFragmentOne;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.MasterFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.MineFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.OrderFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.ShopMallFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomViewPager;

import java.util.ArrayList;

import butterknife.Bind;

public class HomePageActivity extends BaseOneActivity  implements View.OnClickListener, ViewPager.OnPageChangeListener{

    @Bind(R.id.viewPager)
    CustomViewPager viewPager;
    @Bind(R.id.ll_home)
    LinearLayout ll_home;
    @Bind(R.id.ll_category)
    LinearLayout ll_category;
    @Bind(R.id.ll_service)
    LinearLayout ll_service;
    @Bind(R.id.ll_mine)
    LinearLayout ll_mine;
    @Bind(R.id.ll_daka)
    LinearLayout ll_daka;
    private ArrayList<Fragment> mFragments;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        HomeFragmentOne homeOneFragment = new HomeFragmentOne();
        ShopMallFragment categoryOneFragment = new ShopMallFragment();
        OrderFragment serviceOneFragment = new OrderFragment();
        MasterFragment mineOneFragment = new MasterFragment();
        MineFragment mineFragment = new MineFragment();
        mFragments.add(homeOneFragment);
        mFragments.add(categoryOneFragment);
        mFragments.add(serviceOneFragment);
        mFragments.add(mineOneFragment);
        mFragments.add(mineFragment);
    }

    @Override
    protected void initView() {
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        ll_home.setSelected(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tabSelected(ll_home);
                break;
            case 1:
                tabSelected(ll_category);
                break;
            case 2:
                tabSelected(ll_service);
                break;
            case 3:
                tabSelected(ll_daka);
                break;
            case 4:
                tabSelected(ll_mine);
                break;
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    protected void setListener() {
        ll_home.setOnClickListener(this);
        ll_category.setOnClickListener(this);
        ll_service.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
        ll_daka.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                viewPager.setCurrentItem(0);
                tabSelected(ll_home);
                break;
            case R.id.ll_category:
                viewPager.setCurrentItem(1);
                tabSelected(ll_category);
                break;
            case R.id.ll_service:
                viewPager.setCurrentItem(2);
                tabSelected(ll_service);
                break;
            case R.id.ll_mine:
                viewPager.setCurrentItem(4);
                tabSelected(ll_mine);
                break;
            case R.id.ll_daka:
                viewPager.setCurrentItem(3);
                tabSelected(ll_daka);
                break;
        }
    }

    private void tabSelected(LinearLayout linearLayout) {
        ll_home.setSelected(false);
        ll_category.setSelected(false);
        ll_service.setSelected(false);
        ll_daka.setSelected(false);
        ll_mine.setSelected(false);
        linearLayout.setSelected(true);
    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
