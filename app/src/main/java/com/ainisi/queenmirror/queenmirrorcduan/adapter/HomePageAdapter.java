package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.LayoutRes;

import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SortBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class HomePageAdapter extends BaseQuickAdapter<SortBean, BaseViewHolder> {
    public HomePageAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SortBean item) {
    }
}