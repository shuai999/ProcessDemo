package cn.novate.process;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/4/13 15:10
 * Version 1.0
 * Params:
 * Description:   方法1：把MainActivity的业务逻辑放到Service中，使得进程更加轻量
*/
public class LiveService extends Service {

    public  static void toLiveService(Context pContext){
        Intent intent=new Intent(pContext,LiveService.class);
        pContext.startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 屏幕管理者的单例
        final ScreenManager screenManager = ScreenManager.getInstance(this);
        // 屏幕广播监听器
        ScreenBroadcastListener listener = new ScreenBroadcastListener(this);
        listener.registerListener(new ScreenBroadcastListener.ScreenStateListener() {
            @Override
            public void onScreenOn() {
                // 屏幕打开时候，关闭一个像素的Activity
                screenManager.finishActivity();
            }

            @Override
            public void onScreenOff() {
                // 屏幕锁屏的时候，开启一个像素的SinglePixelActivity
                screenManager.startActivity();
            }
        });
        return START_REDELIVER_INTENT;
    }
}