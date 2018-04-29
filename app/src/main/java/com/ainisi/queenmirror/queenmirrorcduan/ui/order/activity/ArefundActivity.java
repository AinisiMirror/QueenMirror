package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 退款
 */
public class ArefundActivity extends BaseNewActivity {
    @Bind(R.id.re_arefund)
    RecyclerView areRecyclerView;

    @Bind(R.id.title_title)
    TextView areTitle;

    private List<SortBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_arefund;
    }

    @Override
    protected void initView() {
        super.initView();
        areTitle.setText(R.string.arefund);

    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 4; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter = new MyAdapter(R.layout.arefund_re_listitem, list);
        areRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        areRecyclerView.setAdapter(sbmitWholeAdapter);
    }

    @OnClick({R.id.title_back, R.id.bt_confirm_refund})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
           //确认退款
            case R.id.bt_confirm_refund:
            startActivity(new Intent(this,ConfirmRefundActivity.class));
                break;
        }
    }
}
