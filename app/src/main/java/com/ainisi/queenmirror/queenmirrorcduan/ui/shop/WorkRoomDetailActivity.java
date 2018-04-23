package com.ainisi.queenmirror.queenmirrorcduan.ui.shop;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkCreditAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkRoomAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkSingleAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商户信息
 */
public class WorkRoomDetailActivity extends BaseNewActivity implements HttpCallBack, HoveringScrollview.OnScrollListener {


    @Bind(R.id.tab_workroom)
    TabLayout tabWorkRoom;
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.li_workroom_xuan)
    LinearLayout li_workroom_xuan;
    @Bind(R.id.search01)
    LinearLayout search01;
    @Bind(R.id.search2)
    LinearLayout search2;
    @Bind(R.id.whs_workroom_scroll)
    HoveringScrollview whs_workroom_scroll;
    @Bind(R.id.li_workroom_top)
    LinearLayout li_workroom_top;
    @Bind(R.id.re_recommendable_projects_shop)
    RecyclerView re_recommendable_projects_shop;
    private int searchLayoutTop;
    @Bind(R.id.listView)
    NoScrollListview listView;
    @Bind(R.id.tv_shop)
    TextView tvShop;
    @Bind(R.id.list_shop)
    NoScrollListview listShop;
    @Bind(R.id.tv_single)
    TextView tvSingle;
    @Bind(R.id.list_single)
    NoScrollListview listSingle;
    @Bind(R.id.re_workroom_coupon)
    RelativeLayout reCoupu;
    @Bind(R.id.re_infor_massage)
    RelativeLayout reMassage;
    List<SortBean> sortlist = new ArrayList<>();
    List<String> tabList = new ArrayList<>();
    private WorkRoomAdapter listadapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_room_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        initTab();
        tv_common_title.setText("MOCO形象工作室");
        whs_workroom_scroll.setOnScrollListener(this);
    }

    private void initTab() {
        listView.setVisibility(View.VISIBLE);
        listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this);
        listView.setAdapter(listadapter);
        tabList.add("门店服务");
        tabList.add("门店信用");
        tabList.add("商家信息");
        tabList.add("优惠券");
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(0)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(1)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(2)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(3)));
        tabWorkRoom.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private WorkCreditAdapter creditAdapter;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    //门店服务
                    case 0:
                        listView.setVisibility(View.VISIBLE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this);
                        listView.setAdapter(listadapter);
                        break;
                    //门店信用
                    case 1:
                        listView.setVisibility(View.VISIBLE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        creditAdapter = new WorkCreditAdapter(WorkRoomDetailActivity.this);
                        listView.setAdapter(creditAdapter);
                        break;
                    //商家信息
                    case 2:
                        listView.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.VISIBLE);
                        break;
                    //优惠券
                    case 3:
                        listView.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.VISIBLE);
                        WorkShopAdapter shopAdapter = new WorkShopAdapter(WorkRoomDetailActivity.this);
                        listShop.setAdapter(shopAdapter);
                        WorkSingleAdapter singleAdapter = new WorkSingleAdapter(WorkRoomDetailActivity.this);
                        listSingle.setAdapter(singleAdapter);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            sortlist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.re_full_recommend,sortlist);
        re_recommendable_projects_shop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        re_recommendable_projects_shop.setAdapter(sortAdapter);
    }

    @OnClick({R.id.iv_common_back})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_common_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub


        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = li_workroom_top.getBottom();// 获取searchLayout的顶部位置

        }
    }

    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= searchLayoutTop) {
            if (li_workroom_xuan.getParent() != search01) {
                search2.removeView(li_workroom_xuan);
                search01.addView(li_workroom_xuan);
            }
        } else {
            if (li_workroom_xuan.getParent() != search2) {
                search01.removeView(li_workroom_xuan);
                search2.addView(li_workroom_xuan);
            }
        }
    }
}
