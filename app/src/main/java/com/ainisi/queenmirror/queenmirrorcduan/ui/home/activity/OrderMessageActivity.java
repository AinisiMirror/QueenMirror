package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的订单信息
 */
public class OrderMessageActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.recycler_ordmessage)
    RecyclerView ordrecycler;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private List<SortBean> orelist = new ArrayList<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, OrderMessageActivity.class));
    }

    //    @Override
//    public int getLayoutId() {
//        return R.layout.activity_order_mgs;
//    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_mgs;
    }


    @Override
    protected void initView() {
        super.initView();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            orelist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.item_oremesage, orelist);
        ordrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ordrecycler.setAdapter(sortAdapter);
        title.setText(R.string.message_center);
    }

    @Override
    protected void initData() {
        super.initData();
        /**
         * canRefresh 是否下拉刷新
         * canLoadMore 是否上拉加载更多
         * autoLoadMore 自动加载更多（默认不自动加载更多）
         * showLastRefreshTime 是否显示上次刷新时间（默认不显示）
         * multiTask 下拉刷新上拉加载更多可同时进行（默认下拉刷新和上拉加载更多不能同时进行）
         */

            mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                    .canLoadMore(true)
                    .autoLoadMore()

                    .showLastRefreshTime(
                            RefreshLoadMoreLayout.class,
                            "yyyy-MM-dd")
                    .multiTask());


    }
    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("下拉成功");
                mRefreshLoadMoreLayout.stopRefresh();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("上拉成功");
                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
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
