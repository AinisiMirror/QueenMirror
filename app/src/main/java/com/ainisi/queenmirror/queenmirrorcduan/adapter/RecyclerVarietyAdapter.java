package com.ainisi.queenmirror.queenmirrorcduan.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.BigshotBean;
import java.util.List;

/**
 * Created by Administrator on 2018/4/13.
 * 大咖多个item
 */

public class RecyclerVarietyAdapter extends RecyclerView.Adapter {

    //定义三种常量  表示三种条目类型
    public static final int TYPE_PULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_THREE_IMAGE = 2;
    private List<BigshotBean> mData;
    boolean flag;
    public RecyclerVarietyAdapter(List<BigshotBean> data) {
        this.mData = data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建不同的 ViewHolder
        View view;
        //根据viewtype来创建条目
        if (viewType == TYPE_PULL_IMAGE) {
            view = View.inflate(parent.getContext(), R.layout.item_one_bigsort, null);
            return new PullImageHolder(view);
        } else if (viewType == TYPE_RIGHT_IMAGE) {
            view = View.inflate(parent.getContext(), R.layout.item_two_bigsort, null);
            return new RightImageHolder(view);
        } else {
            view = View.inflate(parent.getContext(), R.layout.item_three_bigsort, null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    //根据条件返回条目的类型
    @Override
    public int getItemViewType(int position) {

        BigshotBean BigshotBean = mData.get(position);
        if (BigshotBean.type == 0) {
            return TYPE_PULL_IMAGE;
        } else if (BigshotBean.type == 1) {
            return TYPE_RIGHT_IMAGE;
        } else {
            return TYPE_THREE_IMAGE;
        }
    }
    /**
     * 创建三种ViewHolder
     */
    private class PullImageHolder extends RecyclerView.ViewHolder {

        private final ImageView praise;

        public PullImageHolder(View itemView) {
            super(itemView);
            praise = itemView.findViewById(R.id.iv_big_praise);
            praise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag) {
                        flag = false;
                        praise.setImageResource(R.drawable.icon_big_unpraise);
                    } else {
                        praise.setImageResource(R.drawable.icon_big_praise);
                        flag = true;
                    }
                }
            });
        }
    }
    private class RightImageHolder extends RecyclerView.ViewHolder {
        private final ImageView praise;

        public RightImageHolder(View itemView) {
            super(itemView);
            praise = itemView.findViewById(R.id.iv_big_praise);
            praise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag) {
                        flag = false;
                        praise.setImageResource(R.drawable.icon_big_unpraise);
                    } else {
                        praise.setImageResource(R.drawable.icon_big_praise);
                        flag = true;
                    }
                }
            });
        }
    }

    private class ThreeImageHolder extends RecyclerView.ViewHolder {

        private final ImageView praise;

        public ThreeImageHolder(View itemView) {
            super(itemView);
            praise = itemView.findViewById(R.id.iv_big_praise);
            praise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag) {
                        flag = false;
                        praise.setImageResource(R.drawable.icon_big_unpraise);
                    } else {
                        praise.setImageResource(R.drawable.icon_big_praise);
                        flag = true;
                    }
                }
            });
        }
    }
}
