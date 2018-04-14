package cn.novate.process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/4/13 13:58
 * Version 1.0
 * Params:
 * Description:   监听 系统锁屏的广播监听器
*/

public class ScreenBroadcastListener {
    private Context mContext;

    private ScreenBroadcastReceiver mScreenReceiver;

    private ScreenStateListener mListener;

    public ScreenBroadcastListener(Context context) {
        mContext = context.getApplicationContext();
        mScreenReceiver = new ScreenBroadcastReceiver();
    }

    interface ScreenStateListener {

        void onScreenOn();

        void onScreenOff();
    }

    /**
     * screen状态广播接收者
     */
    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏
                mListener.onScreenOn();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
                mListener.onScreenOff();
            }
        }
    }

    public void registerListener(ScreenStateListener listener) {
        mListener = listener;
        registerListener();
    }

    private void registerListener() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mContext.registerReceiver(mScreenReceiver, filter);
    }

//    private Context mContext;
//
//    private ScreenBroadcastReceiver mScreenReceiver;
//
//    private ScreenStateListener mListener;
//
//    public ScreenBroadcastListener(Context context) {
//        mContext = context.getApplicationContext();
//        mScreenReceiver = new ScreenBroadcastReceiver();
//    }
//
//    interface ScreenStateListener {
//        void onScreenOn();  // 屏幕打开
//        void onScreenOff(); // 锁屏
//    }
//
//    /**
//     * screen状态广播接收者
//     */
//    private class ScreenBroadcastReceiver extends BroadcastReceiver {
//        private String action = null;
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            action = intent.getAction();
//            if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏
//                mListener.onScreenOn();
//            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
//                mListener.onScreenOff();
//            }
//        }
//    }
//
//    public void registerListener(ScreenStateListener listener) {
//        mListener = listener;
//        registerListener();
//    }
//
//    private void registerListener() {
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Intent.ACTION_SCREEN_ON);
//        filter.addAction(Intent.ACTION_SCREEN_OFF);
//        mContext.registerReceiver(mScreenReceiver, filter);
//    }
}
