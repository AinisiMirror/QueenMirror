package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ScoreActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 全部订单
 */

public class WholeFragment extends BaseFragment {
    @Bind(R.id.rc_whole)
    RecyclerView whole;
    private List<SortBean> list = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_whole;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter = new MyAdapter(R.layout.item_sbmitrecycler, list);
        whole.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        whole.setAdapter(sbmitWholeAdapter);

        sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), ScoreActivity.class));
            }
        });
    }

}
