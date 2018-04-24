package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ShopStoreActivity;

/**
 * Created by Mloong on 2017/11/25.
 */

public class GridViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;

    public GridViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
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


            convertView = inflater.inflate(R.layout.item_recycler_waterfall, parent, false);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShopStoreActivity.class);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{

    }
}
