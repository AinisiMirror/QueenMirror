package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.FulldistanFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.FullsalesFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.FullscreenFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.FullshortFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 美学汇（美甲美手）
 */
public class EstheticsActivity extends BaseActivity {
    @Bind(R.id.full_rb_sort)
    TextView hSort;
    @Bind(R.id.re_recommendable_projects)
    RecyclerView reProjects;
    @Bind(R.id.full_rb_sales)
    TextView hSales;
    @Bind(R.id.full_rb_distance)
    TextView hDistance;
    @Bind(R.id.full_rb_screen)
    TextView hscreen;
    @Bind(R.id.iv_sort)
    ImageView ivsort;
    @Bind(R.id.iv_sort1)
    ImageView ivsort1;
    @Bind(R.id.pager_home_full)
    NoScrollViewPager fullpager;

    //综合排序
    FullshortFragment sortFragment = new FullshortFragment();
    //销量最高
    FullsalesFragment salesFragment = new FullsalesFragment();
    //距离最近
    FulldistanFragment distanceFragment = new FulldistanFragment();
    //筛选
    FullscreenFragment screenFragment = new FullscreenFragment();
    private CustomPopWindow popWindow;
    private View popview1;
    private PopupWindow pop;
    private List<Fragment> pagerList = new ArrayList<>();
    List<SortBean> sortlist=new ArrayList<>();
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};
    @Override
    public int getLayoutId() {
        return R.layout.activity_esthetics;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initDate();
        initfragment();
       
    }
    private void initfragment() {
        pagerList.add(sortFragment);
        pagerList.add(salesFragment);
        pagerList.add(distanceFragment);
        pagerList.add(screenFragment);
        ViewPager pager = new ViewPager(getSupportFragmentManager(), pagerList, null);
        fullpager.setScanScroll(true);
        fullpager.setAdapter(pager);
    }

    private void initDate() {

        for (int i = 0; i <10 ; i++) {
            SortBean sortBean=new SortBean();
            sortlist.add(sortBean);
        }
        MyAdapter sortAdapter=new MyAdapter(R.layout.re_full_recommend,sortlist);
        reProjects.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        reProjects.setAdapter(sortAdapter);
        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(EstheticsActivity.this, FullActivity.class));
            }
        });
        pop = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        popview1 = View.inflate(this, R.layout.pop_myitem, null);
        initpop(popview1);
        pop.setContentView(popview1);
        pop.setBackgroundDrawable(new ColorDrawable(0));
        pop.setOutsideTouchable(true);
        pop.setAnimationStyle(R.style.CustomPopWindowStyle);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
            }
        });
        pop.dismiss();


    }

    private void initpop(View popview1) {
        final RecyclerView ce = popview1.findViewById(R.id.rc_popview);
        for (int i = 0; i < problem.length; i++) {
            ProblemBean problemBean = new ProblemBean();
            problemBean.setName(problem[i]);
            list.add(problemBean);
        }
        ProblemAdapter problemAdapter = new ProblemAdapter(R.layout.item_pop_sort,list);
        ce.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ce.setAdapter(problemAdapter);
        problemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                hSort.setText(problem[position]);
                pop.dismiss();
            }
        });
    }


    @OnClick({R.id.ed_keyword,R.id.iv_back,R.id.full_rb_sort, R.id.full_rb_sales,
            R.id.full_rb_distance, R.id.full_rb_screen, R.id.iv_sort, R.id.iv_sort1
    ,R.id.tv_more})
    public void click(View view) {
        switch (view.getId()) {
            //搜素
            case R.id.ed_keyword:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_back:
                finish();
                break;
//            //订单详情
//            case R.id.full_guijiao:
//                startActivity(new Intent(this, FullActivity.class));
//                break;
            case R.id.tv_more:
                startActivity(new Intent(this,RecommendedActivity.class));
                break;
            //综合选择
            case R.id.iv_sort:
                ivsort.setVisibility(View.GONE);
                ivsort1.setVisibility(View.VISIBLE);
                pop.showAsDropDown(hSort);
                break;
            case R.id.iv_sort1:
                pop.dismiss();
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
                break;
            //综合排序
            case R.id.full_rb_sort:
                fullpager.setCurrentItem(0);
                break;
            //销量最高
            case R.id.full_rb_sales:
                fullpager.setCurrentItem(1);
                break;
            //距离最近
            case R.id.full_rb_distance:
                fullpager.setCurrentItem(2);
                break;
            //筛选
            case R.id.full_rb_screen:
                View popview = View.inflate(this, R.layout.pop_right, null);

                initview(popview);
                popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                        .setView(popview)
                        .setFocusable(true)
                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT)
                        .setOutsideTouchable(true)
                        .setAnimationStyle(R.style.CustomPopWindowStyle)
                        .create()

                        .showAtLocation(hscreen, Gravity.RIGHT, 0, 0);
                break;
            default:
                break;

        }


    }

    private void initview(final View popview) {
        TextView eliminateTv = popview.findViewById(R.id.tv_eliminate);
        TextView okTv = popview.findViewById(R.id.tv_ok);
        eliminateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dissmiss();

            }
        });
    }


}