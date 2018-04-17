package com.ainisi.queenmirror.queenmirrorcduan.ui.home.mineactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.common.commonutils.ToastUtils;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的设置
 */
public class InstallActivity extends BaseActivity {
    @Bind(R.id.title_title)
    TextView settitle;
    @Bind(R.id.iv_unselected)
    ImageView unselscetd;
    private boolean isClick;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, InstallActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_install;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        settitle.setText("隐私");
    }

    @OnClick({R.id.title_back, R.id.iv_unselected,  R.id.layout_privacy
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //隐私
            case R.id.layout_privacy:
                ReplaceActivity.startActivity(InstallActivity.this);
                break;

            case R.id.iv_unselected:
                if(isClick){
                    unselscetd.setImageResource(R.drawable.icon_install_unselected);
                    isClick=false;
                }else {
                    unselscetd.setImageResource(R.drawable.icon_install_selected);
                    ToastUtils.showLong("你点击了我");
                    isClick=true;
                }
                break;
            default:
                break;

        }


    }
}
