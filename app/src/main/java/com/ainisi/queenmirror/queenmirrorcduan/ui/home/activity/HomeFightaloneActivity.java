package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.FullshortFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;
/**
 * 拼单
 */
public class HomeFightaloneActivity extends BaseActivity {
    @Bind(R.id.tab_home_fightalone)
    TabLayout tabFightalone;
    @Bind(R.id.pager_home_fightalone)
    NoScrollViewPager pagerFightalone;
    @Bind(R.id.title_title)
    TextView titleFightalone;
    List<String> tabList=new ArrayList<>();
    List<Fragment> pagerList=new ArrayList<>();
    String[] tabName={"全部","美容美体","美发订制","美甲美手","美学汇","半永久"};
    @Override
    public int getLayoutId() {
        return R.layout.activity_home_fightalone;
    }
    @Override
    public void initPresenter() {
    }
    @Override
    public void initView() {
        initDate();
    }
    private void initDate() {
        titleFightalone.setText("拼团");
        for (int i = 0; i < tabName.length; i++) {
            tabList.add(tabName[i]);

            tabFightalone.addTab(tabFightalone.newTab().setText(tabList.get(i)));
        }
        ViewPager viewPager=new ViewPager(getSupportFragmentManager(),pagerList,tabList);
        pagerFightalone.setAdapter(viewPager);
        tabFightalone.setupWithViewPager(pagerFightalone);
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
}
