package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FlowLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2017/11/12.
 * 搜索
 */

public class SearchActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.titleimg_right)
    ImageView imgright;
    @Bind(R.id.title_search)
    TextView search;
    @Bind(R.id.layout_title)
    LinearLayout layouttitle;
    @Bind(R.id.root_title)
    RelativeLayout poplayout;
    @Bind(R.id.title_layout)
    LinearLayout titlelayout;

    @Bind(R.id.his_flowLayout)
    FlowLayout his_flowLayout;
    private List<SortBean> list=new ArrayList<>();
    public static void startActivity(Context context) {
        Intent in = new Intent(context, SearchActivity.class);
        context.startActivity(in);
    }

    @Override
    public int getLayoutId() {
        StatusBarUtil.getStatusBarLightMode(getWindow());
        return R.layout.activity_search;
    }

    @Override
    public void initView(){

        showpopid();
        initHot();
        initHistory();
        initHotTag();
    }
    private void initHot() {

    }
    private void initHistory() {

    }


    private void showpopid() {
        title.setVisibility(View.GONE);
        imgright.setVisibility(View.GONE);
        titlelayout.setVisibility(View.VISIBLE);
        poplayout.setBackgroundColor(ContextCompat.getColor(this,R.color.alpha_05_black));
    }


    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }
    }
    /**
     * 热门搜索
     */
    private void initHotTag() {
        String[] mStrings = {"apple", "百度CEO", "阿里巴巴", "绩效股", "中国股市", "美团", "google", "淘宝", "雷军 小米公司", "大疆无人机"};
        his_flowLayout.setColorful(false);//设置是否是多彩的颜色
        his_flowLayout.setData(mStrings);
        his_flowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void TagClick(String text) {
            }
        });
    }

}
