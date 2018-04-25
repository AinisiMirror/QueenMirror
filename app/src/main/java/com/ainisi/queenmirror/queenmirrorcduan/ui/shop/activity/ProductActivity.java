package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
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

public class ProductActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView productTitle;
    //本店成品
    @Bind(R.id.re_product)
    RecyclerView reProduct;
    private List<SortBean> beanList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product;
    }
    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        productTitle.setText("全部成品");
        productTitle.setTextColor(Color.BLACK);
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            beanList.add(sortBean);
        }

        MyAdapter myAdapter = new MyAdapter(R.layout.re_shop_store, beanList);
        reProduct.setLayoutManager(new GridLayoutManager(this, 2));
        reProduct.setAdapter(myAdapter);

    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }


    }
}
