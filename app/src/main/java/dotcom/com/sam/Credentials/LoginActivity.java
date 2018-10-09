package dotcom.com.sam.Credentials;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import dotcom.com.sam.Activity.DogGrooming;
import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.LoginResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.ESPreferences;
import dotcom.com.sam.Utils.UserSessionManager;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText ed_username, ed_pass;
    String username, password;
    Button btn_login;
    TextView txt_skip, reg_txt, forgotpass;
    private ProgressDialog pDialog;
    public String TAG = Registration.class.getSimpleName();
    String loginstatus = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        reg_txt = (TextView) findViewById(R.id.regstetext);
        forgotpass = (TextView) findViewById(R.id.forgotpassword);

        reg_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Registration.class);
                startActivity(i);
                // finish();
            }
        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(i);
                // finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = ed_username.getText().toString();
                password = ed_pass.getText().toString();


                if (Utils.isOnline(LoginActivity.this)) {
                    if (validate()) {
                        Login(username, password);

                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Internet problem");
                    builder.setMessage("Oops! seems you have lost internet connectivity. Please try again later.");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    android.app.AlertDialog alert = builder.create();
                    alert.show();
                    Button nbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                    nbutton.setTextColor(Color.rgb(30, 144, 255));
                }


            }
        });

    }

    private void Login(String email, String pass) {
        final Dialog dialog = new Dialog(LoginActivity.this);
        LoginResponse loginResponse = new LoginResponse();
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        Log.e(TAG, "sendSignIn: " + email + " " + pass);
        Call<LoginResponse> loginResponseCall = Utilss.getWebService().login(email, pass);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                Log.e(TAG, "onResponse: " + new GsonBuilder().create().toJson(loginResponse));
                if (response.code() == 200) {
                    pDialog.dismiss();
                    assert loginResponse != null;
                    Utils.saveUserPreference(LoginActivity.this, Constants.FIRST_NAME, loginResponse.getFullName());
                    Utils.saveUserPreference(LoginActivity.this, Constants.USER_NAME, loginResponse.getEmail());
                    Utils.saveUserPreference(LoginActivity.this, Constants.RJ_ID, String.valueOf(loginResponse.getRJ_ID()));
                    Utils.saveUserPreference(LoginActivity.this, Constants.ADDRESS, loginResponse.getAddress());
                    Utils.saveUserPreference(LoginActivity.this, Constants.MOBILE, loginResponse.getMobNo());
                    SingletonClass.getInstance().setUSERID(String.valueOf(loginResponse.getRJ_ID()));

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("KEY", String.valueOf(String.valueOf(loginResponse.getRJ_ID())));
                    editor.apply();
                    loginstatus = "true";
                    new UserSessionManager(getApplicationContext()).setUrlData(getApplicationContext(), loginstatus, UserSessionManager.LOGIN_STATUS);
                    Utils.saveUserPreference(LoginActivity.this, Constants.FIRST_NAME, loginResponse.getFullName());
                    getCartList();
                } else if (response.code() == 404) {
                    pDialog.dismiss();
                    Utils.customMessage(LoginActivity.this, "Please check email id and password.!!");
                } else if (response.code() == 400) {
                    pDialog.dismiss();
                    Utils.customMessage(LoginActivity.this, "Please check email id and password.!!");
                } else if (response.code() == 500) {
                    pDialog.dismiss();
                    Utils.customMessage(LoginActivity.this, "Internal server error.!!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Utils.customMessage(LoginActivity.this, t.getMessage());
                pDialog.dismiss();
            }
        });

    }

    private void initView() {
        ed_username = (EditText) findViewById(R.id.username);
        ed_pass = (EditText) findViewById(R.id.pass);
        btn_login = (Button) findViewById(R.id.btn_login);


    }


    private boolean validation(String username, String password) {
        boolean flag = true;
        if (username == null || username.equalsIgnoreCase("")) {
            ed_username.setError("enter user name");
            flag = false;
        } else if (password == null || password.equalsIgnoreCase("")) {
            ed_pass.setError("enter password");
            flag = false;
        } else if (password.length() <= 6) {
            ed_pass.setError("password should contain minimum 6 character");
            flag = false;

        }

        return flag;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LoginActivity.this.finish();
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

    private boolean validate() {


        if (ed_username.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Please enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (ed_pass.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Please enter password.", Toast.LENGTH_LONG).show();
            return false;
        } else if (ed_pass.getText().length() < 6) {
            Toast.makeText(LoginActivity.this, "Password must be at least 6 characters long.", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void getCartList() {
        //    pDialog = new ProgressDialog(Categeory.this);
//        pDialog.setMessage("Please wait...");
//        pDialog.setCancelable(false);
//        pDialog.show();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
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
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String cont = String.valueOf(getCartResponse.getResponse().size());
                        editor.putString("COU", cont);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();

                    } else if (getCartResponse.getStatus() == 404) {
                        startActivity = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(startActivity);
                        finish();
                    } else if (response.code() == 404) {

                    } else if (response.code() == 500) {
                        Utils.timeOutDialog(LoginActivity.this, true);
                    } else {
                        Utils.customMessage(LoginActivity.this, "Something went wrong.");
                    }

                    //pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<GetCartResponse> call, Throwable t) {
                // pDialog.dismiss();
                Utils.customMessage(LoginActivity.this, "Something went wrong.");
            }
        });
    }

}
