package dotcom.com.sam.Utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.transition.Explode;

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




}
