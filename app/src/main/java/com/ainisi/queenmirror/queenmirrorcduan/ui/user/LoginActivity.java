package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.title_right)
    TextView loginRighrTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitle();
    }

    private void initTitle() {
        loginTitle.setText(R.string.login);
        loginRighrTitle.setText(R.string.register);
    }

    @OnClick({R.id.title_back, R.id.title_right, R.id.tv_forgetcipher})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //注册
            case R.id.title_right:
                //CeshiData();
                // Toast.makeText(mContext, "你点击了注册", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            //忘记密码
            case R.id.tv_forgetcipher:
                startActivity(new Intent(this, ForgetcipherActivity.class));
                break;
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
    /**
     * 测试
     */
    private void CeshiData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", "17365387881");
        params.put("userPass", "1");
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.REGIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.REGIST://注册
                LoginBean loginBean = GsonUtil.toObj(res, LoginBean.class);
                String msg = loginBean.getMsg();
                T.show(msg);
                L.e("??????");
                break;

            case ACTION.LOGIN://登录

                break;
        }

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


}
