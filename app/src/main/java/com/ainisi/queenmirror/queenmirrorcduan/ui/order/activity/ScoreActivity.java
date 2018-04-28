package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;;

import butterknife.Bind;
import butterknife.OnClick;

public class ScoreActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView scoreTitle;
    @Bind(R.id.title_right)
    TextView scoreRightTitle;
    @Bind(R.id.score_custom)
    CustomRatingBar customRatingBar;
    @Bind(R.id.tv_score)
    TextView scoreText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    protected void initView() {
        super.initView();

        initTitle();
        initDate();
    }


    private void initDate() {
        customRatingBar.setTouchAble(true);
        customRatingBar.setmOnStarChangeListener(new CustomRatingBar.onStarChangedListener() {
            @Override
            public void onStarChange(CustomRatingBar ratingBar, float mark) {
                initcoustom(mark);
            }
        });
    }

    private void initcoustom(float mark) {
        switch ((int) mark) {
            case 1:
                scoreText.setText("差");
                break;
            case 2:
                scoreText.setText("差");
                break;
            case 3:
                scoreText.setText("一般");
                break;
            case 4:
                scoreText.setText("一般");
                break;
            case 5:
                scoreText.setText("非常好");
                break;
        }
    }

    private void initTitle() {
        scoreTitle.setText(R.string.published_order);
        scoreTitle.setTextColor(Color.BLACK);
        scoreRightTitle.setText(R.string.release);
        scoreRightTitle.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.title_back,R.id.iv_add})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_add:
                T.show("您点击了我");
                break;

        }


    }
}
