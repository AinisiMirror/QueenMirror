package com.ainisi.queenmirror.queenmirrorcduan.ui.shop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商户信息
 */
public class WorkRoomDetailActivity extends BaseNewActivity implements HttpCallBack,HoveringScrollview.OnScrollListener  {

    @Bind(R.id.iv_common_back)
    ImageView iv_common_back;
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

    List<SortBean> sortlist=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_room_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_common_title.setText("MOCO形象工作室");
        whs_workroom_scroll.setOnScrollListener(this);
    }

    @Override
    protected void initData() {
        super.initData();

        for (int i = 0; i <10 ; i++) {
            SortBean sortBean=new SortBean();
            sortlist.add(sortBean);
        }
        MyAdapter sortAdapter=new MyAdapter(this,sortlist,R.layout.re_full_recommend);
        re_recommendable_projects_shop.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        re_recommendable_projects_shop.setAdapter(sortAdapter);
    }

    @OnClick({R.id.iv_common_back})
    public void OnClick(View view){
        switch (view.getId()){
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
