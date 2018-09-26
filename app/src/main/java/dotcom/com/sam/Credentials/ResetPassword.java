package dotcom.com.sam.Credentials;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.ChangePassResponse;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ChangePassRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPassword extends AppCompatActivity {
    Toolbar toolbar;
    TextView signup;
    EditText oPassword, nPassword,emails,cPassword;
    Button changePassword;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        signup =(TextView)findViewById(R.id.signupfromchanepass);
        oPassword =(EditText)findViewById(R.id.oldpassword);
        nPassword =(EditText)findViewById(R.id.newpassword);
        emails =(EditText)findViewById(R.id.emailid);
        cPassword =(EditText)findViewById(R.id.conformpassword);
        changePassword =(Button)findViewById(R.id.resetpasswrd);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResetPassword.this,Registration.class);
                startActivity(i);
            }
        });
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Reset Password");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Utils.isOnline(ResetPassword.this)) {

                    final String oldPassw = oPassword.getText().toString().trim();
                    final String newPassw = nPassword.getText().toString().trim();
                    final String emailadd = emails.getText().toString().trim();
                    final String cnfrmpass = cPassword.getText().toString().trim();


                    if (validate())
                        changePassword(newPassw, oldPassw,emailadd,cnfrmpass);
                } else {

                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ResetPassword.this);
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

    private void changePassword(String newPass, String oldPass, final String email, String cnfrmpasrd) {

        pDialog = new ProgressDialog(ResetPassword.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        ChangePassRequest changePassRequest = new ChangePassRequest();
        changePassRequest.setEmail(email);
        changePassRequest.setPassword(oldPass);
        changePassRequest.setCnfPassword(cnfrmpasrd);
        changePassRequest.setCreatedBy(newPass);

        Call<ChangePassResponse> changePassResponseCall = Utilss.getWebService().getChangePassword(changePassRequest);
        changePassResponseCall.enqueue(new Callback<ChangePassResponse>() {
            @Override
            public void onResponse(Call<ChangePassResponse> call, Response<ChangePassResponse> response) {
                //    ChangePasswordResponse guestFeedbackResponse = response.body();
                //  Log.e("FunctionResponse ", "onResponse: " + new GsonBuilder().create().toJson(guestFeedbackResponse));
                if (response.code() == 200) {

                    Utils.customMessage(ResetPassword.this, "Password Change successfully");
                    oPassword.setText("");
                    nPassword.setText("");
                    emails.setText("");
                    cPassword.setText("");

                } else if (response.code() == 400) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ResetPassword.this);
                    builder.setMessage("Old Password does not match")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                    oPassword.setText("");
                                    nPassword.setText("");
                                    emails.setText("");
                                    cPassword.setText("");

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                } else if (response.code() == 404) {
                    Utils.customMessage(ResetPassword.this, "Old Password does not match");
                    oPassword.setText("");
                    nPassword.setText("");
                    emails.setText("");
                    cPassword.setText("");

                } else if (response.code() == 500) {
                    Utils.customMessage(ResetPassword.this, "Internal Server Error");
                    oPassword.setText("");
                    nPassword.setText("");
                    emails.setText("");
                    cPassword.setText("");
                } else {
                    Utils.customMessage(ResetPassword.this, "Something is wroung");
                    oPassword.setText("");
                    nPassword.setText("");
                    emails.setText("");
                    cPassword.setText("");
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ChangePassResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }


    private boolean validate() {
        String pass=nPassword.getText().toString();
        String cpass=cPassword.getText().toString();
        if (oPassword.getText().toString().length() == 0) {
            Utils.customMessage(ResetPassword.this, "Pleas Enter Old Password");
            return false;
        } else if (nPassword.getText().toString().length() == 0) {
            Utils.customMessage(ResetPassword.this, "Pleas Enter New Password");
            return false;
        }
        else if (!pass.equals(cpass)){
            Toast.makeText(ResetPassword.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }

}
