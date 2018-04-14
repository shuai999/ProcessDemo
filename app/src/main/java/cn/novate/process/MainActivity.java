package cn.novate.process;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        // 屏幕管理者的单例
//        final ScreenManager screenManager = ScreenManager.getInstance(MainActivity.this);
//        // 屏幕广播监听器
//        ScreenBroadcastListener listener = new ScreenBroadcastListener(this);
//        listener.registerListener(new ScreenBroadcastListener.ScreenStateListener() {
//            @Override
//            public void onScreenOn() {
//                // 屏幕打开时候，关闭一个像素的Activity
//                screenManager.finishActivity();
//            }
//
//            @Override
//            public void onScreenOff() {
//                // 屏幕锁屏的时候，开启一个像素的SinglePixelActivity
//                screenManager.startActivity();
//            }
//        });

        // 不用上边的写法，把上边的逻辑放到 Service中，直接从 MainActivity中开启Service即可
        LiveService.toLiveService(this) ;

    }
}