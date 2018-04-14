package cn.novate.process;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/4/14 8:50
 * Version 1.0
 * Params:
 * Description:   方法5：粘性服务与捆绑进程
*/
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationLiveService extends NotificationListenerService {

    public NotificationLiveService() {

    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
    }
}