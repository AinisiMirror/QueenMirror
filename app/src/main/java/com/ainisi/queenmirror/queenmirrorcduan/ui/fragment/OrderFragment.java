package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.AssessedFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.RefundFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.WholeFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;
/**
 * Created by EWorld on 2018/3/6.
 *
 */
public class OrderFragment extends BaseFragment {
    @Bind(R.id.or_tab)
    TabLayout otablayout;
    @Bind(R.id.or_mypager)
    NoScrollViewPager omypager;
    @Bind(R.id.title_photo)
    ImageView title_photo;
    private List<String> tablist = new ArrayList<>();
    private List<Fragment> pagerlist = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_order;
    }

    @Override
    public void initPresenter() {

    }

    @OnClick({R.id.title_photo})
    public void onClick(View view){

        switch (view.getId()){
            case R.id.title_photo:
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void initView() {

        initDate();
    }
    private void initDate() {
        tablist.add("全部订单");
        tablist.add("待评价");
        tablist.add("退款");
        for (int i = 0; i < tablist.size(); i++) {
            otablayout.addTab(otablayout.newTab().setText(tablist.get(i)));
        }
        /**
         //全部订单
         //待评价
         //退款
         */
        pagerlist.add(new WholeFragment());
        pagerlist.add(new AssessedFragment());
        pagerlist.add(new RefundFragment());
        ViewPager viewPager = new ViewPager(getActivity().getSupportFragmentManager(), pagerlist, tablist);
        omypager.setAdapter(viewPager);
        omypager.setScanScroll(true);
        otablayout.setupWithViewPager(omypager);
        otablayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(otablayout, 30, 30);
            }
        });
    }


    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }


}
