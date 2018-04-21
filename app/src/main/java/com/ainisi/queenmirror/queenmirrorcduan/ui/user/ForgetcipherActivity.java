package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;
import butterknife.OnClick;

public class ForgetcipherActivity extends BaseActivity{


    @Bind(R.id.title_title)
    TextView loginTitle;
    @Override
    public int getLayoutId() {
        return R.layout.activity_forgetcipher;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initText();
    }

    private void initText() {
        loginTitle.setText(R.string.forgetcipher);
    }
    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;

        }


    }
}
