package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ProductActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 异业
 */
public class ShopStoreActivity extends BaseNewActivity{
    @Bind(R.id.iv_shop)
    ImageView ivShop;
    @Bind(R.id.title_title)
    TextView storeTitle;
    //本店成品
    @Bind(R.id.re_product)
    RecyclerView reProduct;
    //网友评论
    @Bind(R.id.recycler_boutique)
    RecyclerView reBoutique;
    String url="http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg";
    private List<SortBean> beanList=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_store;
    }

    @Override
    protected void initView() {
        super.initView();
        storeTitle.setText("DLOVES婚介定制中心");
        storeTitle.setTextColor(Color.BLACK);
        Glide.with(this).load(url).into(ivShop);

    }
    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i <6 ; i++) {
            SortBean sortBean=new SortBean();
            beanList.add(sortBean);
        }
        MyAdapter myAdapter=new MyAdapter(R.layout.re_shop_store,beanList);
        reProduct.setLayoutManager(new GridLayoutManager(this,2));
        reProduct.setAdapter(myAdapter);
        MyAdapter myAdapter1=new MyAdapter(R.layout.re_store_boutique,beanList);
        reBoutique.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        reBoutique.setAdapter(myAdapter1);

    }
    @OnClick({R.id.title_back,R.id.re_product_two
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.re_product_two:
                startActivity(new Intent(this, ProductActivity.class));
                break;
            default:
                break;

        }


    }
}
