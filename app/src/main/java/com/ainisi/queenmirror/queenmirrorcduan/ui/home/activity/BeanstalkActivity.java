package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.common.commonutils.TUtil;
import com.ainisi.queenmirror.common.commonutils.ToastUtils;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ProblemBean;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

public class BeanstalkActivity extends BaseActivity {

    private static final int TELVERSION = 0;
    @Bind(R.id.datepicker)
    DatePicker datePicker;
    @Bind(R.id.tv_date)
    TextView date;
    @Bind(R.id.title_title)
    TextView dateTitle;
    @Bind(R.id.title_right)
    TextView rightTitle;
    @Bind(R.id.re_branstalk)
    RelativeLayout branstalkmoth;
    @Bind(R.id.re_branstalkday)
    RelativeLayout branstalkmothday;
    @Bind(R.id.layout_date)
    LinearLayout linearDate;
    @Bind(R.id.ed_starttime)
    EditText startTime;
    @Bind(R.id.ed_endtime)
    EditText endtime;
    private int day;
    private int month;
    private int year;
    private int flag=0;

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
        initTime();
        hidePicker(datePicker);
    }

    private void initTime() {
        //可以对每个时间域单独修改
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DATE);
        date.setText(year + "-" + "-" + (month + 1) + "-" + day);
        datePicker.setMaxDate(System.currentTimeMillis() - 86400000);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            //            当dp日期改变时回调onDateChanged方法
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                获取dp的年月日的值，在textView上显示出来
                date.setText(datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth());
            }
        });
    }

    @OnClick({R.id.title_back, R.id.iv_delete, R.id.tv_date, R.id.re_branstalk})
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
            case R.id.re_branstalk:

        }


    }




    /**
     * @param picker 传入一个DatePicker对象,隐藏或者显示相应的时间项
     */
    public static void hidePicker(DatePicker picker) {
        // 利用java反射技术得到picker内部的属性，并对其进行操作
        Class<? extends DatePicker> c = picker.getClass();
        try {
            Field fd = null, fm = null, fy = null;
            // 系统版本大于5.0
            if (Build.VERSION.SDK_INT >= TELVERSION) {
                int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
                if (daySpinnerId != 0) {
                    View daySpinner = picker.findViewById(daySpinnerId);
                    if (daySpinner != null) {
                        daySpinner.setVisibility(View.GONE);
                        return;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                // 系统版本大于4.0
                fd = c.getDeclaredField("mDaySpinner");
                fm = c.getDeclaredField("mMonthSpinner");
                fy = c.getDeclaredField("mYearSpinner");
            } else {
                fd = c.getDeclaredField("mDayPicker");
                fm = c.getDeclaredField("mMonthPicker");
                fy = c.getDeclaredField("mYearPicker");
            }
            // 对字段获取设置权限
            fd.setAccessible(true);
            fm.setAccessible(true);
            fy.setAccessible(true);
            // 得到对应的控件
            View vd = (View) fd.get(picker);
            View vm = (View) fm.get(picker);
            View vy = (View) fy.get(picker);

            vd.setVisibility(View.GONE);
            vm.setVisibility(View.VISIBLE);
            vy.setVisibility(View.VISIBLE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param picker 传入一个DatePicker对象,隐藏或者显示相应的时间项
     */
    public static void showPicker(DatePicker picker) {
        // 利用java反射技术得到picker内部的属性，并对其进行操作
        Class<? extends DatePicker> c = picker.getClass();
        try {
            Field fd = null, fm = null, fy = null;
            // 系统版本大于5.0
            if (Build.VERSION.SDK_INT >= TELVERSION) {
                int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
                if (daySpinnerId != 0) {
                    View daySpinner = picker.findViewById(daySpinnerId);
                    if (daySpinner != null) {
                        daySpinner.setVisibility(View.VISIBLE);
                        return;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                // 系统版本大于4.0
                fd = c.getDeclaredField("mDaySpinner");
                fm = c.getDeclaredField("mMonthSpinner");
                fy = c.getDeclaredField("mYearSpinner");
            } else {
                fd = c.getDeclaredField("mDayPicker");
                fm = c.getDeclaredField("mMonthPicker");
                fy = c.getDeclaredField("mYearPicker");
            }
            // 对字段获取设置权限
            fd.setAccessible(true);
            fm.setAccessible(true);
            fy.setAccessible(true);
            // 得到对应的控件
            View vd = (View) fd.get(picker);
            View vm = (View) fm.get(picker);
            View vy = (View) fy.get(picker);

            vd.setVisibility(View.VISIBLE);
            vm.setVisibility(View.VISIBLE);
            vy.setVisibility(View.VISIBLE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}