package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseRecyclerAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 * 拼团
 */
public class HomeFightaloneFragment extends BaseFragment {
    @Bind(R.id.recycler_fragment_fightalone)
    RecyclerView reFightalone;
    private List<SortBean> list=new ArrayList<>();
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home_fightalone;
    }
    @Override
    public void initPresenter() {
    }
    @Override
    protected void initView() {
            initDate();
    }

    private void initDate() {

        for (int i = 0; i <15 ; i++) {
            SortBean sortBean=new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            list.add(sortBean);
        }
        MyAdapter sortAdapter=new MyAdapter(R.layout.re_home_fightalone,list);
        reFightalone.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        reFightalone.setAdapter(sortAdapter);
        sortAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), FightaloneActivity.class));
            }
        });
    }

}
