package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ProblemBean;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

public class BeanstalkActivity extends BaseActivity {

    @Bind(R.id.datepicker)
    DatePicker datePicker;
    @Bind(R.id.tv_date)
    TextView date;
    @Bind(R.id.title_title)
    TextView dateTitle;
    @Bind(R.id.title_right)
    TextView rightTitle;
    private int day;
    private int month;
    private int year;


    @Override
    public int getLayoutId() {
        return R.layout.activity_beanstalk;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        initText();
        initDate();
    }

    private void initText() {
        dateTitle.setText("选择时间");
        rightTitle.setText("完成");

    }

    private void initDate() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DATE);
        date.setText(year + "-" + "-" + (month + 1) + "-" + day);
        datePicker.setMaxDate(new Date().getTime() - 86400);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            //            当dp日期改变时回调onDateChanged方法
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                获取dp的年月日的值，在textView上显示出来
                date.setText(datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth());
            }
        });
    }

    @OnClick({R.id.title_back, R.id.iv_delete, R.id.tv_date})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_date:
                datePicker.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_delete:
                datePicker.setVisibility(View.GONE);
                date.setText("选择时间");
                break;

        }


    }

}
