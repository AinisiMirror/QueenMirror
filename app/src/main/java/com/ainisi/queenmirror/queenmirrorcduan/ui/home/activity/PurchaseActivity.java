package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseListViewAdapter;


import butterknife.Bind;
import butterknife.OnClick;
//提交订单
public class PurchaseActivity extends BaseActivity {
    @Bind(R.id.list_order)
    ListView listOrder;
    @Bind(R.id.title_title)
    TextView purtitle;
    private PurchaseListViewAdapter listadapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_purchase;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        purtitle.setText("提交订单");
        listadapter = new PurchaseListViewAdapter(this);
        listOrder.setAdapter(listadapter);


    }
    @OnClick({R.id.tv_submit,R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //提交订单
            case R.id.tv_submit:
                startActivity(new Intent(PurchaseActivity.this,SubmitActivity.class));
                break;
        }


    }

}
