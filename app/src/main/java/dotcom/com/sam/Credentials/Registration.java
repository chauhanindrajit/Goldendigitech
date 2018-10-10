package dotcom.com.sam.Credentials;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.RegisttnResponsemain;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.RegistrationRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    Toolbar toolbar;
    TextView signintxt;
    EditText use_name, email_add, cont_no, password, cnfrpassword, location;
    Button sign_up;
    private ProgressDialog pDialog;
    public String TAG = Registration.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        toolbar = findViewById(R.id.toolbar);
        signintxt = (TextView) findViewById(R.id.signintxt);
        use_name = (EditText) findViewById(R.id.usernames);
        email_add = (EditText) findViewById(R.id.Email_Address);
        cont_no = (EditText) findViewById(R.id.conttctno);
        password = (EditText) findViewById(R.id.passswords);
        cnfrpassword = (EditText) findViewById(R.id.confrmpaswd);
        location = (EditText) findViewById(R.id.Address);
        sign_up = (Button) findViewById(R.id.btn_signup);
        toolbar.setTitle("Register");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        signintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isOnline(Registration.this)) {
                    if (validate()) {

                        String username = use_name.getText().toString().trim();
                        String emailId = email_add.getText().toString().trim();
                        String mob = cont_no.getText().toString().trim();
                        String cnPassword = cnfrpassword.getText().toString().trim();
                        String uPassword = password.getText().toString().trim();
                        String loctn = location.getText().toString().trim();
                        if (validate1()) {
                            registration(username, emailId, mob, uPassword, cnPassword, loctn);
                        }

                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Registration.this);
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

    private void registration(String uName, String emailId, String mob, String uPassword, String cnfimpasswrd, String loctn) {
        final Dialog dialog = new Dialog(Registration.this);
        pDialog = new ProgressDialog(Registration.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        // Getting Device Unique ID.
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("HardwareIds")

        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFullName(uName);
        registrationRequest.setEmail(emailId);
        registrationRequest.setMobNo(mob);
        registrationRequest.setPassword(uPassword);
        registrationRequest.setCnfPassword(cnfimpasswrd);
        registrationRequest.setAddress(loctn);


        Log.e(TAG, "registration request : " + new GsonBuilder().create().toJson(registrationRequest));

        Call<RegisttnResponsemain> registtnResponsemainCall = Utilss.getWebService().registration(registrationRequest);
        registtnResponsemainCall.enqueue(new Callback<RegisttnResponsemain>() {
            @Override
            public void onResponse(@NonNull Call<RegisttnResponsemain> call, @NonNull Response<RegisttnResponsemain> response) {
                RegisttnResponsemain registtnResponsemain = response.body();
                Log.e(TAG, "onResponse: " + new GsonBuilder().create().toJson(registtnResponsemain));
                if (response.code() == 200) {

                    pDialog.dismiss();
                    startActivity(new Intent(Registration.this, LoginActivity.class));
                    Utils.customMessage(Registration.this, "Register Successful");
                    finish();
//                        else {
//                        pDialog.dismiss();
//                        Toast.makeText(Registration.this, registtnResponsemain.getMessege(), Toast.LENGTH_SHORT).show();
//                        }
                } else if (response.code() == 400) {
                    pDialog.dismiss();
                    Utils.customMessage(Registration.this, "Email id already exists.");
                } else if (response.code() == 404) {
                    pDialog.dismiss();
                    Utils.customMessage(Registration.this, "There is problem to register.");
                } else if (response.code() == 409) {
                    pDialog.dismiss();
                    Utils.customMessage(Registration.this, "Email id already exists.");
                } else if (response.code() == 500) {
                    pDialog.dismiss();
                    Utils.customMessage(Registration.this, "Internal server error.");
                }
            }

            @Override
            public void onFailure(Call<RegisttnResponsemain> call, Throwable t) {
                pDialog.dismiss();
                Utils.customMessage(Registration.this, t.getMessage());
            }


        });

    }


    private boolean validate1() {
        boolean temp = true;
        String checkemail = email_add.getText().toString();
        String pass = password.getText().toString();
        String cpass = cnfrpassword.getText().toString();
        if (!isValidEmaillId(checkemail)) {
            Toast.makeText(Registration.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            temp = false;
        }
        if (!pass.equals(cpass)) {
            Toast.makeText(Registration.this, "Password Not matching", Toast.LENGTH_SHORT).show();
            temp = false;
        }
        return temp;
    }


    private boolean validate() {


        if (use_name.getText().toString().equals("")) {
            Toast.makeText(Registration.this, "Please Enter Valid User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (email_add.getText().toString().equals("")) {
            Toast.makeText(Registration.this, "Please enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (cont_no.getText().toString().equals("")) {
            Toast.makeText(Registration.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (password.getText().toString().equals("")) {
            Toast.makeText(Registration.this, "Please enter password.", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.getText().length() < 6) {
            Toast.makeText(Registration.this, "Password must be at least 6 characters long.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (cnfrpassword.getText().toString().equals("")) {
            Toast.makeText(Registration.this, "Please enter Confirm password.", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.getText().length() < 6) {
            Toast.makeText(Registration.this, "Password must be at least 6 characters long.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public static boolean isValidEmaillId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}
