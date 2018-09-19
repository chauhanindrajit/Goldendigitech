package dotcom.com.sam.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by priyankam on 19-07-2016.
 */
public class NotificationCountSetClass extends Activity {
    private static ImageView icon;

    public NotificationCountSetClass() {
        //constructor
    }

    public static void setAddToCart(Context context, ImageView imageView, int numMessages) {
        icon = (ImageView) imageView;
        SetNotificationCount.setBadgeCount(context, imageView, NotificationCountSetClass.setNotifyCount(numMessages));

    }

    public static int setNotifyCount(int numMessages) {
        int count = numMessages;
        return count;

    }


}
