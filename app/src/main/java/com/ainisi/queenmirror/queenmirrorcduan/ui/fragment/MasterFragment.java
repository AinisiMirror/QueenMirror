package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RecyclerVarietyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.BigshotBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 大咖
 */

public class MasterFragment extends BaseFragment{
    @Bind(R.id.re_big_shot)
    RecyclerView reBigshot;
    private List<BigshotBean> mData;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_master;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    protected void initView() {
        initDate();
    }

    private void initDate() {
        mData = new ArrayList<>();
//        随机数 用来标记item界面的类型
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            BigshotBean more = new BigshotBean();
            more.type = random.nextInt(3);
            mData.add(more);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            reBigshot.setLayoutManager(linearLayoutManager);
            RecyclerVarietyAdapter adapter = new RecyclerVarietyAdapter(getActivity(),mData);
            reBigshot.setAdapter(adapter);

        }

    }
}
