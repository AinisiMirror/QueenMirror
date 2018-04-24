package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;

/**
 * Created by Mloong on 2017/11/25.
 */

public class PurchaseListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;

    public PurchaseListViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 1;
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
            convertView = inflater.inflate(R.layout.item_purchase, parent, false);
            holder.checkTitle = convertView.findViewById(R.id.purchase_check_title);
            holder.checkNameOne = convertView.findViewById(R.id.purchase_check_nameone);
            holder.checkNameTwo = convertView.findViewById(R.id.purchase_check_nametwo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (compoundButton.getId()) {

                    case R.id.purchase_check_nameone:
                        if (holder.checkNameOne.isChecked() && holder.checkNameTwo.isChecked()) {
                            holder.checkTitle.setChecked(true);
                        } else {
                            holder.checkTitle.setChecked(false);
                        }
                        break;
                    case R.id.purchase_check_nametwo:
                        if (holder.checkNameOne.isChecked() && holder.checkNameTwo.isChecked()) {
                            holder.checkTitle.setChecked(true);
                        } else {
                            holder.checkTitle.setChecked(false);
                        }
                        break;
                    case R.id.purchase_check_title:
                        if (holder.checkTitle.isChecked()) {
                            holder.checkNameOne.setChecked(true);
                            holder.checkNameTwo.setChecked(true);
                        } else if (holder.checkNameOne.isChecked() && !holder.checkNameTwo.isChecked()) {
                            holder.checkNameOne.setChecked(true);
                            holder.checkNameTwo.setChecked(false);
                        } else if (!holder.checkNameOne.isChecked() && holder.checkNameTwo.isChecked()) {
                            holder.checkNameOne.setChecked(false);
                            holder.checkNameTwo.setChecked(true);
                        } else if (holder.checkNameOne.isChecked() && holder.checkNameTwo.isChecked()) {
                            holder.checkNameOne.setChecked(false);
                            holder.checkNameTwo.setChecked(false);
                        }
                        break;


                }
            }
        };
        holder.checkTitle.setOnCheckedChangeListener(changeListener);
        holder.checkNameOne.setOnCheckedChangeListener(changeListener);
        holder.checkNameTwo.setOnCheckedChangeListener(changeListener);


        return convertView;

    }


    //就是View的持有
    public final class ViewHolder {
        private CheckBox checkTitle;
        private CheckBox checkNameOne;
        private CheckBox checkNameTwo;

    }
}
