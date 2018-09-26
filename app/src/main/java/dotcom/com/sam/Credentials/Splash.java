package dotcom.com.sam.Credentials;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.UserSessionManager;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;

public class Splash extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    String loginstatus = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loginstatus = new UserSessionManager(getApplicationContext()).getUrlData(getApplicationContext(), UserSessionManager.LOGIN_STATUS);
                String userToken = Utils.getStringUserPreference(Splash.this, Constants.RJ_ID);
                Log.e("User Token :: ", "run: " + userToken);
                Intent startActivity = null;
                if (userToken != null) {

                    startActivity = new Intent(Splash.this, MainActivity.class);
                    startActivity(startActivity);
                    finish();

                } else {
                    startActivity = new Intent(Splash.this, LoginActivity.class);
                    startActivity(startActivity);
                    finish();

                }

            }
        }, 50);

    }

    private void startSplash() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginstatus = new UserSessionManager(getApplicationContext()).getUrlData(getApplicationContext(), UserSessionManager.LOGIN_STATUS);
                String userToken = Utils.getStringUserPreference(Splash.this, Constants.USER_NAME);
                Log.e("User Token :: ", "run: " + userToken);
                Intent startActivity = null;
                if (loginstatus.equalsIgnoreCase("true")) {
                    startActivity = new Intent(Splash.this, MainActivity.class);
                    startActivity(startActivity);
                    finish();

                } else {
                    startActivity = new Intent(Splash.this, LoginActivity.class);
                    startActivity(startActivity);
                    finish();

                }
            }
        }, 3000);
    }
}

