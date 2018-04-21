package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 拼单
 */
public class FightaloneActivity extends BaseActivity {
    @Bind(R.id.full_recycler)
    RecyclerView frecycler;
    @Bind(R.id.full_recyclertwo)
    RecyclerView frecyclertwo;
    @Bind(R.id.title_title)
    TextView fullTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;
    private List<SortBean> fulllist = new ArrayList<>();
    private List<SortBean> fulllist2 = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_fightalone;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        initText();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            fulllist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter( R.layout.item_fullrecycler,fulllist);
        frecycler.setLayoutManager(new GridLayoutManager(this, 2));
        frecycler.setAdapter(sortAdapter);
        for (int i = 0; i < 8; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            fulllist2.add(sortBean);
        }
        MyAdapter sortAdapter2 = new MyAdapter(R.layout.item_fullrecyclertwo,fulllist2);

        frecyclertwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        frecyclertwo.setAdapter(sortAdapter2);
    }

    private void initText() {
        fullTitle.setText("纯色美甲");
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back, R.id.relative_look_more})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //拼单剩余人数（查看更多）
            case R.id.relative_look_more:
                Toast.makeText(mContext, "您点击了我", Toast.LENGTH_SHORT).show();
                break;

        }


    }

}
