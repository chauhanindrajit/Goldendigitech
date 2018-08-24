package dotcom.com.sam.Utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.transition.Explode;
import android.view.Gravity;
import android.widget.Toast;

import static dotcom.com.sam.extras.Utilss.SETTING_PREFERENCE;
import static dotcom.com.sam.extras.Utilss.USER_PREFERENCE;

/**
 * Created by sanjay on 3/15/2018.
 */

public class Utils {


    public  static void setExplodTransition(Context context)
    {
        Explode explode=new Explode();
        explode.setDuration(400);
        ((Activity)context).getWindow().setEnterTransition(explode);
    }




    public static void moveNextWithAnimation(Context context,Class activity)
    {
       ActivityOptions activityOptions= ActivityOptions.makeSceneTransitionAnimation(((Activity) context));
        Intent intent=new Intent(context,activity);
        context.startActivity(intent,activityOptions.toBundle());

    }
    public static Toast customMessage(Context ctx, String message) {

        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return toast;

    }
    public static String getStringUserPreference(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPref.getString(key, null);
    }
    public static void saveUserPreference(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean clearAllPreference(Context context) {
        SharedPreferences sharedUserPref = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences sharedSettingPref = context.getSharedPreferences(SETTING_PREFERENCE, Context.MODE_PRIVATE);
        return sharedUserPref.edit().clear().commit() && sharedSettingPref.edit().clear().commit();
    }
    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }


}
