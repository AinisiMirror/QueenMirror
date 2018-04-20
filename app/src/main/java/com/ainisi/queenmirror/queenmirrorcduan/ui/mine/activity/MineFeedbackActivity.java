package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 意见与反馈
 */
public class MineFeedbackActivity extends BaseActivity {
    @Bind(R.id.title_title)
    TextView feedTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_feedback;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        feedTitle.setText(R.string.opinion_and_feedback);
    }
    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;



        }


    }
}
