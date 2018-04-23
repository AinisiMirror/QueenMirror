package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

public class ScoreActivity extends BaseNewActivity implements HttpCallBack {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
