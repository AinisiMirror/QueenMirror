package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.common.commonutils.ToastUtils;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 待评价
 */

public class AssessedFragment extends BaseFragment{
    @Bind(R.id.rc_assessde)
    RecyclerView assessde;
    private List<SortBean> list=new ArrayList<>();
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_order_assessde;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        for (int i = 0; i <10 ; i++) {
            SortBean sortBean=new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter=new MyAdapter(getActivity(),list,R.layout.item_sbmitrecycler);
        assessde.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false));
        assessde.setAdapter(sbmitWholeAdapter);
        sbmitWholeAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {

                Toast.makeText(getActivity(), "你点击了我", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
