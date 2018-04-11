package com.ainisi.queenmirror.queenmirrorcduan.ui.home.home.fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    @Bind(R.id.title_back)
    ImageView back;
    @Bind(R.id.root_title)
    RelativeLayout re_root;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_shop_mall;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        back.setVisibility(View.GONE);
        shopTitle.setText("商城");
        shopTitle.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        re_root.setBackgroundResource(R.drawable.icon_home);
    }


}
