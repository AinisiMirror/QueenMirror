package com.ainisi.queenmirror.queenmirrorcduan.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.ainisi.queenmirror.common.commonwidget.StatusBarCompat;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;

import butterknife.ButterKnife;

public abstract class BaseNewActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, com.ainisi.queenmirror.common.R.color.white));
        StatusBarUtil.getStatusBarLightMode(getWindow());

        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        initView();
        doFirstRequest();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    protected void initView() {
    }

    protected void initData() {
    }


    protected void doFirstRequest() {

    }

    protected abstract int getLayoutId();
}
