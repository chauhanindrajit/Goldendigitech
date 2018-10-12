package dotcom.com.sam.Credentials;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.ForgotPassResponse;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ForgetPassRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    Toolbar toolbar;
    TextView reset;
    EditText emaiId;
    Button submitPassword;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        reset = (TextView) findViewById(R.id.resetpass);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Forgot Password");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotPassword.this, ResetPassword.class);
                startActivity(i);
            }
        });
        emaiId = (EditText) findViewById(R.id.member_email);
        submitPassword = (Button) findViewById(R.id.submit_password);

        submitPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isOnline(ForgotPassword.this)) {

                    if (validate()) {
                        final String id = emaiId.getText().toString().trim();
                        forgotPassword(id);
                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ForgotPassword.this);
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


    private void forgotPassword(String emailId) {
        pDialog = new ProgressDialog(ForgotPassword.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
        pDialog.show();
        pDialog.setContentView( R.layout.progress_bar );
        final ForgetPassRequest forgetPassRequest = new ForgetPassRequest(emailId);
        Call<ForgotPassResponse> changePasswordResponseCall = Utilss.getWebService().getForgotPassword(forgetPassRequest);
        changePasswordResponseCall.enqueue(new Callback<ForgotPassResponse>() {
            @Override
            public void onResponse(Call<ForgotPassResponse> call, Response<ForgotPassResponse> response) {
                if (response.code() == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
                    builder.setMessage("Password send on your email id. Please check your email id")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                } else if (response.code() == 400) {
                    Utils.customMessage(ForgotPassword.this, "Please Enter correct email id");
                } else if (response.code() == 404) {
                    Utils.customMessage(ForgotPassword.this, "Email Id Not Found");
                } else if (response.code() == 500) {
                    Utils.customMessage(ForgotPassword.this, "Internal Server Error");
                } else {
                    Utils.customMessage(ForgotPassword.this, "Something is wroung");
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ForgotPassResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }

    private boolean validate() {
        if (emaiId.getText().toString().length() == 0) {
            Utils.customMessage(ForgotPassword.this, "Pleas Enter Email Id");
            return false;
        }
        return true;

    }


}
