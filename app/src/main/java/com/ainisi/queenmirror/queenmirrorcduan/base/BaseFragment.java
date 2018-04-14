package com.ainisi.queenmirror.queenmirrorcduan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;

import butterknife.ButterKnife;

/**
 * 作者： jl
 * 日期： 2017/2/25.
 */

public abstract class BaseFragment extends Fragment implements HttpCallBack {

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), null, false);
            ButterKnife.bind(this, rootView);
            initData();
            initView();
            doFirstRequest();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
        }
        return rootView;
    }

    protected void initView() {
    }

    protected void initData() {

    }

    protected void doFirstRequest() {

    }

    /**
     * 返回布局id
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void onResume() {
        super.onResume ();
    }
}
