package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class ForgetcipherActivity extends BaseNewActivity implements HttpCallBack{


    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.tv_phonenumber)
    TextView phoneNumber;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.tv_validation)
    TextView validation;
    private boolean click;
    private MyCountDownTimer myCountDownTimer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetcipher;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(30000,1000);
        initText();

        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private void initText() {
        loginTitle.setText(R.string.forgetcipher);
    }
    @OnClick({R.id.title_back,R.id.iv_remove_text,R.id.iv_login_see,R.id.tv_validation})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_remove_text:
                phoneNumber.setText("");
                break;
            case R.id.tv_validation:
                initValidation();
                myCountDownTimer.start();
                break;
                //密码是否可见
            case R.id.iv_login_see:
                if(click){
                    loginSee.setImageResource(R.drawable.icon_login_nosee);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    click=false;
                }else {
                    //如果选中，显示密码
                    loginSee.setImageResource(R.drawable.icon_login_see);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    click=true;
                }
                break;
        }


    }
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            validation.setClickable(false);
            validation.setText((l/1000)+"s后重新获取");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            validation.setText("重新获取验证码");
            //设置可点击
            validation.setClickable(true);
        }
    }

}
