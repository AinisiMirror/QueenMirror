package com.ainisi.queenmirror.queenmirrorcduan.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.MainActivity;

/**
 * 启动画面
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        handler.sendEmptyMessageDelayed(1,1000*3);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what)
            {
                case 1:
                    startActivity(new Intent(SplashActivity.this,HomePageActivity.class));
                    SplashActivity.this.finish();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    };
}
