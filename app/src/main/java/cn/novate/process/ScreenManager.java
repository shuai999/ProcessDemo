package cn.novate.process;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/4/13 13:57
 * Version 1.0
 * Params:
 * Description:   screen屏幕管理者
*/
public class ScreenManager {

    private Context mContext;

    private WeakReference<Activity> mActivityWref;

    public static ScreenManager gDefualt;

    public static ScreenManager getInstance(Context pContext) {
        if (gDefualt == null) {
            gDefualt = new ScreenManager(pContext.getApplicationContext());
        }
        return gDefualt;
    }
    private ScreenManager(Context pContext) {
        this.mContext = pContext;
    }

    public void setActivity(Activity pActivity) {
        mActivityWref = new WeakReference<Activity>(pActivity);
    }

    public void startActivity() {
        // 开启一个像素的SinglePixelActivity
        SinglePixelActivity.actionToSinglePixelActivity(mContext);
    }

    public void finishActivity() {
        //结束掉SinglePixelActivity
        if (mActivityWref != null) {
            Activity activity = mActivityWref.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

}
