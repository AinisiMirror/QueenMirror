package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 * （余额明细）
 * 全部
 */
public class AllDetailFragment extends BaseFragment {
    @Bind(R.id.rc_all_detail)
    RecyclerView detailrecycle;
    private List<SortBean> list=new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_all_detail;
    }

    @Override
    public void initPresenter() {

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


}
