package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkShopAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;

    public WorkShopAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.re_workroom_coupon, parent, false);


            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;

    }
}
