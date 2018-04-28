package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qbw.log.XLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 更多
 */
public class RecommendedActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.re_recommended)
    RecyclerView reRecommended;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private List<SortBean> beanList = new ArrayList<>();
    private MyAdapter myAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_recommended;
    }

    @Override
    protected void initView() {
        super.initView();
        initRefresh();
    }

    /**
     * canRefresh 是否下拉刷新
     * canLoadMore 是否上拉加载更多
     * autoLoadMore 自动加载更多（默认不自动加载更多）
     * showLastRefreshTime 是否显示上次刷新时间（默认不显示）
     * multiTask 下拉刷新上拉加载更多可同时进行（默认下拉刷新和上拉加载更多不能同时进行）
     */
    private void initRefresh() {
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
        XLog.v("onRefresh");
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
        XLog.v("onLoadMore");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               T.show("上拉成功");
                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            beanList.add(sortBean);
        }
        myAdapter = new MyAdapter(R.layout.item_shortrecycler, beanList);
        reRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reRecommended.setAdapter(myAdapter);
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
