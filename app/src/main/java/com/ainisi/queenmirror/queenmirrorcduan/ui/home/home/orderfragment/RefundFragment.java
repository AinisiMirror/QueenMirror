package com.ainisi.queenmirror.queenmirrorcduan.ui.home.home.orderfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 退款
 */

public class RefundFragment extends BaseFragment{
    @Bind(R.id.rc_refund)
    RecyclerView refund;
    private List<SortBean> list=new ArrayList<>();
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_refund;
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
        MyAdapter sbmitWholeAdapter=new MyAdapter(getActivity(),list,R.layout.item_refundrecycler);
        refund.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false));
        refund.setAdapter(sbmitWholeAdapter);
    }
}
