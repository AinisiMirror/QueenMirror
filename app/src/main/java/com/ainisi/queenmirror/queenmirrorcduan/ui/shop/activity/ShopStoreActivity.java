package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
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

    private List<SortBean> beanList=new ArrayList<>();
    private CustomPopWindow popWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_store;
    }

    @Override
    protected void initView() {
        super.initView();
        storeTitle.setText("DLOVES婚介定制中心");
        storeTitle.setTextColor(Color.BLACK);


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
    @OnClick({R.id.title_back,R.id.re_product_two,R.id.re_invincible})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.re_invincible:
                View popview = View.inflate(this, R.layout.item_shop_get_ticket, null);
                //弹出popWindow时，背景是否变暗
// 控制亮度
                popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                        .setView(popview)
                        .setFocusable(true)
                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT)
                        .setOutsideTouchable(true)
                        .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
                        .setBgDarkAlpha(0.5f) // 控制亮度
                        .setAnimationStyle(R.style.CustomPopWindowStyle)
                        .create()
                        .showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM, 0, 0);
                break;
            case R.id.re_product_two:
                startActivity(new Intent(this, ProductActivity.class));
                break;
            default:
                break;

        }


    }
}
