package com.ainisi.queenmirror.queenmirrorcduan.ui.home.home.fragment;
import android.widget.TextView;
import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import butterknife.Bind;
/**
 * Created by EWorld on 2018/3/6.
 */

public class ShopMallFragment extends BaseFragment{
    @Bind(R.id.title_title)
    TextView shopTitle;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_shop_mall;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

        shopTitle.setText("商城");
    }


}
