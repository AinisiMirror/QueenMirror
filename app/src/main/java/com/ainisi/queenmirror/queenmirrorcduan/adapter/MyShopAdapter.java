package com.ainisi.queenmirror.queenmirrorcduan.adapter;


import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 *
 *
 *贾亮测试提交消息，王军超提交测试信息
 * lp
 *
 * jl
 */

public class MyShopAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {


    public MyShopAdapter(int layoutResId, @Nullable List<ShopBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        helper.setImageResource(R.id.image_title,item.getImageTitle());
        helper.setText(R.id.text_name,item.getTextName());
    }
}
