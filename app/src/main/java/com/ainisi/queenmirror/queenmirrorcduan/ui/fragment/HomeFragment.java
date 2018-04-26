package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomePageAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyRecyclerCardviewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.DetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.barlibrary.ImmersionBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MarqueeView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.lzy.okgo.cache.CacheMode;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 首页
 */

public class HomeFragment extends BaseFragment implements HttpCallBack{
    @Bind(R.id.rv_home_fragment)
    RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.home_refresh)
    MaterialRefreshLayout home_refresh;

    LinearLayout li_top,layout_stick_header;


    MyRecyclerCardviewAdapter myRecyclerCardviewAdapter;

    private int top = -1;
    private int mScrollY = 0;

    List<SortBean> data;
    MarqueeView marqueeview;
    LinearLayoutManager layoutManager;
    int bannerHeight;
    private int mCurrentPosition = 0;

    String[] contentArray = new String[]{
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",};

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), mToolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.home_fragment_new;
    }

    @Override
    protected void initData() {
        super.initData();
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            data.add(sortBean);
        }
    }

    @Override
    protected void initView() {
        super.initView();

        //创建布局管理
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myRecyclerCardviewAdapter = new MyRecyclerCardviewAdapter();
        recyclerView.setAdapter(myRecyclerCardviewAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int currentposition= layoutManager.getPosition(layoutManager.getChildAt(0));
                if(currentposition>=1){
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                }else{
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });

        home_refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                T.show("下拉刷新");
                // 结束上拉刷新...
                home_refresh.finishRefreshLoadMore();

                home_refresh.finishRefresh();
            }
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                //上拉加载更多...
                T.show("已经加载完了");
                // 结束下拉刷新...
                home_refresh.finishRefresh();
            }
        });
     /*   // 结束下拉刷新...
        home_refresh.finishRefresh();

        // 结束上拉刷新...
        home_refresh.finishRefreshLoadMore();*/
    }
    private View headView,headView2;
    private void addHeaderView() {
        headView = LayoutInflater.from(mActivity).inflate(R.layout.activity_home_shop, (ViewGroup) recyclerView.getParent(), false);

       /* headView2 = LayoutInflater.from(mActivity).inflate(R.layout.home_appbarlayout, (ViewGroup) recyclerView.getParent(), false);
        homePageAdapter.addHeaderView(headView2);*/

        li_top = headView.findViewById(R.id.li_top);
        layout_stick_header = headView.findViewById(R.id.layout_stick_header);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int currentposition= layoutManager.getPosition(layoutManager.getChildAt(0));
                if(currentposition>=1){
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                }else{
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });

        /**
         * Banner
         */
        Banner banner = headView.findViewById(R.id.banner);

        List<String> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();

        marqueeview = headView.findViewById(R.id.marqueeview);
        /**
         * 跑马灯
         */
        initQuee();
        LinearLayout linear_home_freetrial = headView.findViewById(R.id.linear_home_freetrial);
        linear_home_freetrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CeshiData();

            }
        });
    }


    /**
     * 点击首页跑马灯效果
     */
    private void initQuee() {
        marqueeview.setTextArray(contentArray);
        marqueeview.setOnItemClickListener(new MarqueeView.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("content", contentArray[position]);
                startActivity(intent);
            }
        });

    }
    /**
     * 测试
     */
    private void CeshiData() {

        //传参数
        HashMap<String,String> params = new HashMap<>();
        params.put("telNo", "1");

        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.REGIST,params, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res){
        switch (action){
            case ACTION.REGIST://注册
                LoginBean loginBean = GsonUtil.toObj(res,LoginBean.class);
                String msg = loginBean.getMsg();
                T.show(msg);
                L.e("??????");
                break;
            case ACTION.LOGIN://登录

                break;
        }

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarColorTransformEnable(false)
                .navigationBarColor(R.color.colorPrimary)
                .init();
    }

}
