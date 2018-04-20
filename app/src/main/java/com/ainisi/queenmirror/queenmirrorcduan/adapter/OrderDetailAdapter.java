package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;

import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseRecyclerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseViewHolder;

import java.util.List;

class OrderDetailAdapterextends extends BaseRecyclerAdapter<SortBean> {
    public OrderDetailAdapterextends(Context context, List<SortBean> datas, int layoutId) {
        super(context, datas, layoutId);

    }

    @Override
    protected void bindData(BaseViewHolder holder, SortBean data, int position) {

    }
}
