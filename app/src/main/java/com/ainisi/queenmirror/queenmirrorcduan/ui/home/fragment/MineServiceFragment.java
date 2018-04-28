package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 服务进度
 */
public class MineServiceFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.rc_shedule)
    RecyclerView rcshedule;
    List<SortBean> sortlist = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine2;
    }

    @Override
    public void initPresenter() {
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

@Override
protected void initView(){
        for(int i=0;i<10;i++){
        SortBean sortBean=new SortBean();
        sortBean.setName("MOCO美容美发沙龙");
        sortBean.setTime("营业时间 9:00-20:00");
        sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
        sortBean.setStars(R.drawable.icon_home_recommend);
        sortBean.setDistance("875m");
        sortlist.add(sortBean);
        }
        MyAdapter sortAdapter=new MyAdapter(R.layout.item_rcshedule,sortlist);
        rcshedule.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rcshedule.setAdapter(sortAdapter);
        }


        }
