package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.os.Handler;
import android.support.v4.app.Fragment;
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
 * A simple {@link Fragment} subclass.
 * （余额明细）
 * 全部
 */
public class AllDetailFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.rc_all_detail)
    RecyclerView detailrecycle;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private List<SortBean> list=new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_all_detail;
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
    protected void initView() {
        for (int i = 0; i <8 ; i++) {
            SortBean sortBean=new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            list.add(sortBean);
        }
        MyAdapter sortAdapter2=new MyAdapter(R.layout.item_rcbean,list);
        detailrecycle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        detailrecycle.setAdapter(sortAdapter2);

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
}
