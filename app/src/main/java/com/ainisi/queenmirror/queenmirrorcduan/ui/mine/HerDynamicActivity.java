package com.ainisi.queenmirror.queenmirrorcduan.ui.mine;

import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;

/**
 * 动态（是否让看）
 */
public class HerDynamicActivity extends BaseActivity
{
    @Bind(R.id.newtitle_title)
    TextView hertitle;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_her_dynamic;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title =getIntent().getStringExtra("dynamic");
        hertitle.setText(title);
    }
}
