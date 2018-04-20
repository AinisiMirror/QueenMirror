package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * 订单详情
 */

public class OrderDetailActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.rv_orderdetail_order)
    RecyclerView rv_orderdetail_order;

    private List<SortBean> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_common_title.setText("订单详情页");

        for (int i = 0; i <4 ; i++) {
            SortBean sortBean=new SortBean();
            list.add(sortBean);
        }
        MineAdapter sbmitWholeAdapter=new MineAdapter(this,list,R.layout.order_detail_listitem);
        rv_orderdetail_order.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        rv_orderdetail_order.setAdapter(sbmitWholeAdapter);
    }

    @OnClick({R.id.iv_common_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_common_back:
                finish();
                break;
        }
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
