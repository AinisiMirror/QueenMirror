package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
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
 * 退款原因
 */
public class RefundReasonActivity extends BaseNewActivity {
    @Bind(R.id.re_refundReason)
    RecyclerView recyclerView;
    @Bind(R.id.title_title)
    TextView refundReasonTitle;
    private List<SortBean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_refund_reason;

    }

    @Override
    protected void initView() {
        super.initView();
        refundReasonTitle.setText(R.string.arefund_reason);
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 4; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter = new MyAdapter(R.layout.refundreason_re_listitem, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(sbmitWholeAdapter);
    }
    @OnClick({R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;

        }
    }
}
