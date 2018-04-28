package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
//我的位置
public class MinePositionActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    TextView postitleright;
    @Bind(R.id.rc_position)
    RecyclerView posrctcle;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    public List<SortBean> sortlist=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_position;
    }


    @Override
    protected void initView() {
        super.initView();
        postitle.setText(R.string.myposition);
        postitleright.setText(R.string.administration);
        postitle.setTextColor(ContextCompat.getColor(this,R.color.alpha_95_black));
        for (int i = 0; i <10 ; i++) {
            SortBean sortBean=new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            sortlist.add(sortBean);
        }

        MyAdapter sortAdapter=new MyAdapter(R.layout.item_rcposition,sortlist);
        posrctcle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        posrctcle.setAdapter(sortAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
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
}
