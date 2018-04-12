package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseRecyclerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BaseViewHolder;

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

public class MyShopAdapter extends BaseRecyclerAdapter<ShopBean> {

    public MyShopAdapter(Context context, List<ShopBean> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, ShopBean data, int position) {
           ImageView imageTitle= holder.getView(R.id.image_title);
           TextView name= holder.getView(R.id.text_name);
           imageTitle.setImageResource(data.getImageTitle());
           name.setText(data.getTextName());

    }
}
