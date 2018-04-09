package com.ainisi.queenmirror.queenmirrorcduan.app;

import android.os.StrictMode;

import com.ainisi.queenmirror.common.baseapp.BaseApplication;
import com.ainisi.queenmirror.common.commonutils.CrashHandler;
import com.ainisi.queenmirror.common.commonutils.ToastUtils;


/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    private static final String TAG = "AppApplication";

    /*
    友盟分享静态加载注册信息
    */
    static {
       // PlatformConfig.setSinaWeibo("263819347", "235e107f378a3440c78928d55dcb688c", "http://sns.whalecloud.com");
       // PlatformConfig.setQQZone("1106548988", "ppRwmD6Zb8I2gZt3");
       // PlatformConfig.setWeixin(APP_ID, APP_SECRET);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //QueuedWork.isUseThreadPool = false;
        //初始化吐司
        ToastUtils.getInstance(this);

        //解决API大于等于24 调用相机图库崩溃问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);

    }


}
