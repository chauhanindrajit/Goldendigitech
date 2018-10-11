package dotcom.com.sam.Credentials;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.gson.GsonBuilder;

import dotcom.com.sam.Activity.Categeory;
import dotcom.com.sam.Activity.CheckInternetScreen;
import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Utils.UserSessionManager;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    String loginstatus = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.isOnline(getApplicationContext())) {
            getPermission();
        } else {
            Intent intent = new Intent(Splash.this, CheckInternetScreen.class);
            startActivity(intent);
        }
    }

    private void getPermission() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginstatus = new UserSessionManager(getApplicationContext()).getUrlData(getApplicationContext(), UserSessionManager.LOGIN_STATUS);
                String userToken = Utils.getStringUserPreference(Splash.this, Constants.RJ_ID);
                Log.e("User Token :: ", "run: " + userToken);
                Intent startActivity = null;
                if (userToken != null) {
                    getCartList();
                } else {
                    startActivity = new Intent(Splash.this, LoginActivity.class);
                    startActivity(startActivity);
                    finish();

                }

            }
        }, 200);


    }



    private void getCartList() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Splash.this);
        String value = sharedPreferences.getString("KEY", "");
        Call<GetCartResponse> getCartResponseCall = Utilss.getWebService().getAllCartList(Integer.valueOf((value)));
        Log.e("115 ", ": :" + getCartResponseCall.request().url().toString());
        getCartResponseCall.enqueue(new Callback<GetCartResponse>() {
            @Override
            public void onResponse(Call<GetCartResponse> call, Response<GetCartResponse> response) {
                GetCartResponse getCartResponse = response.body();
                Intent startActivity = null;
                if (response.code() == 200) {
                    if (getCartResponse.getStatus() == 200) {
                        // pDialog.dismiss();
                        // ESPreferences.SSP().putLong(CART_COUNT, Long.valueOf(getCartResponse.getResponse().size()));
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Splash.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String cont = String.valueOf(getCartResponse.getResponse().size());
                        editor.putString("COU", cont);
                        editor.apply();
                        startActivity = new Intent(Splash.this, MainActivity.class);
                        startActivity(startActivity);
                        finish();

                    } else if (getCartResponse.getStatus() == 404) {
                        startActivity = new Intent(Splash.this, MainActivity.class);
                        startActivity(startActivity);
                        finish();
                    } else if (response.code() == 404) {


                    } else if (response.code() == 500) {
                        Utils.timeOutDialog(Splash.this, true);
                    } else {
                        Utils.customMessage(Splash.this, "Something went wrong.");
                    }
                    //pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<GetCartResponse> call, Throwable t) {
                // pDialog.dismiss();
                Utils.customMessage(Splash.this, "Something went wrong.");
            }
        });
    }
}

