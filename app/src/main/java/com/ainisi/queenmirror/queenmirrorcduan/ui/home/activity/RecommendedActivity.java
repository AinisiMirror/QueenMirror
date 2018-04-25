package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class RecommendedActivity extends BaseNewActivity {
    @Bind(R.id.re_recommended)
    RecyclerView reRecommended;
    private List<SortBean> beanList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recommended;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            beanList.add(sortBean);
        }
        MyAdapter myAdapter = new MyAdapter(R.layout.item_shortrecycler, beanList);
        reRecommended.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
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
