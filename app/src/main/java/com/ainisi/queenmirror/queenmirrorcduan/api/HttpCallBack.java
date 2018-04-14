package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 作者： jl
 *
 */

public interface HttpCallBack {

    void onSuccess(int action, String res);

    void showLoadingDialog();

    void showErrorMessage(String s);

}
