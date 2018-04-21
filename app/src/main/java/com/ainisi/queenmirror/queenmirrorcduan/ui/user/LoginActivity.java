package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.title_right)
    TextView loginRighrTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        loginTitle.setText(R.string.login);
        loginRighrTitle.setText(R.string.register);
    }

    @OnClick({R.id.title_back, R.id.title_right,R.id.tv_forgetcipher})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
                //注册
            case R.id.title_right:
                Toast.makeText(mContext, "你点击了注册", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            //忘记密码
            case R.id.tv_forgetcipher:
                startActivity(new Intent(this,ForgetcipherActivity.class));
                break;

        }


    }
}
