package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.view.View;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class SubmitActivity extends BaseActivity {
    @Bind(R.id.img_wechat_unpayment)
    ImageView wcunpayment;
    @Bind(R.id.img_queen_unpayment)
    ImageView queenunpayment;
    @Bind(R.id.img_wechat_payment)
    ImageView wcpayment;
    @Bind(R.id.img_queen_payment)
    ImageView queenpayment;
    @Bind(R.id.img_wechat_unalipay)
    ImageView unalipay;
    @Bind(R.id.img_wechat_alipay)
    ImageView alipay;


    @Override
    public int getLayoutId() {
        return R.layout.activity_submit;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.img_wechat_unpayment, R.id.img_queen_unpayment, R.id.title_back, R.id.img_alipay,R.id.img_wechat_unalipay
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.img_wechat_unpayment:
                wcpayment.setVisibility(View.VISIBLE);
                queenpayment.setVisibility(View.GONE);
                alipay.setVisibility(View.GONE);
                break;

            case R.id.img_queen_unpayment:
                queenpayment.setVisibility(View.VISIBLE);
                alipay.setVisibility(View.GONE);
                wcpayment.setVisibility(View.GONE);
                break;
            case R.id.img_wechat_unalipay:
                alipay.setVisibility(View.VISIBLE);
                queenpayment.setVisibility(View.GONE);
                wcpayment.setVisibility(View.GONE);
                break;

        }

    }
}
