package dotcom.com.sam.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.regex.Pattern;

import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.RegisttnResponsemain;
import dotcom.com.sam.Response.ServiceLastPageResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.RegistrationRequest;
import dotcom.com.sam.request.ServicelastpageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesLastPage extends AppCompatActivity {
    TextView actname, srid, buypetcnt;
    LinearLayout buypetcont;
    EditText fullname, email_add, contactno, address, message;
    Button btnsubmit;
    private ProgressDialog pDialog;
    Toolbar toolbar;
    TextInputLayout adopypetcont, serviceadd;
    public String TAG = ServicesLastPage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_last_page);
        actname = (TextView) findViewById(R.id.actname);
        //buypetcnt = (TextView) findViewById(R.id.buypetcontent);
        buypetcont = (LinearLayout) findViewById(R.id.buypetcont);
        adopypetcont = (TextInputLayout) findViewById(R.id.adoptpetcont);
        serviceadd = (TextInputLayout) findViewById(R.id.vet_at_home_address_layout);
        //  srid=(TextView)findViewById(R.id.srid);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(SingletonClass.getInstance().getActivityname());
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (toolbar.getTitle() == "Buy Pet") {
            buypetcont.setVisibility(View.VISIBLE);
        } else {
            buypetcont.setVisibility(View.GONE);
        }

        if (toolbar.getTitle() == "Adopt A Pet") {
            adopypetcont.setVisibility(View.VISIBLE);
            serviceadd.setVisibility(View.GONE);
        } else {
            adopypetcont.setVisibility(View.GONE);
            serviceadd.setVisibility(View.VISIBLE);
        }
        fullname = (EditText) findViewById(R.id.full_name);
        email_add = (EditText) findViewById(R.id.emai_id);
        contactno = (EditText) findViewById(R.id.contact_no);
        address = (EditText) findViewById(R.id.address_detail);
        message = (EditText) findViewById(R.id.message);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        // actname.setText(SingletonClass.getInstance().getActivityname());
        // srid.setText(SingletonClass.getInstance().getSRID());


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.isOnline(ServicesLastPage.this)) {
                    if (validate()) {

                        String username = fullname.getText().toString().trim();
                        String emailId = email_add.getText().toString().trim();
                        String mob = contactno.getText().toString().trim();
                        String msg = message.getText().toString().trim();
                        String add = address.getText().toString().trim();
                        String activity = SingletonClass.getInstance().getActivityname();
                        String srid = (SingletonClass.getInstance().getSRID());
                        String centrname = SingletonClass.getInstance().getCentername();

                        if (validate1()) {
                            submit(username, emailId, mob, add, activity, srid, centrname, msg);
                        }

                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ServicesLastPage.this);
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

    private void submit(String username, String emailId, String mob, String add, String activity, String srid, String centrname, String msg) {
        final Dialog dialog = new Dialog(ServicesLastPage.this);
        pDialog = new ProgressDialog(ServicesLastPage.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
        pDialog.show();
        pDialog.setContentView( R.layout.progress_bar );
        // Getting Device Unique ID.
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("HardwareIds")

        ServicelastpageRequest servicelastpageRequest = new ServicelastpageRequest();
        servicelastpageRequest.setName(username);
        servicelastpageRequest.setEmail(emailId);
        servicelastpageRequest.setMOB(mob);
        if (!add.equals("")) {
            servicelastpageRequest.setAddress(add);
        } else {
            servicelastpageRequest.setAddress("NULL");
        }
        if (!msg.equals("")) {
            servicelastpageRequest.setMessage(msg);
        } else {
            servicelastpageRequest.setMessage("NULL");
        }
        servicelastpageRequest.setType2(centrname);

        servicelastpageRequest.setSmsCategoryType(activity);
        if (srid == String.valueOf(0)) {
            servicelastpageRequest.setTime("0");
        } else {
            servicelastpageRequest.setTime(srid);
        }
        Log.e(TAG, "registration request : " + new GsonBuilder().create().toJson(servicelastpageRequest));
        Call<ServiceLastPageResponse> serviceLastPageResponseCall = Utilss.getWebService().SERVICE_LAST_PAGE_RESPONSE_CALL(servicelastpageRequest);
        serviceLastPageResponseCall.enqueue(new Callback<ServiceLastPageResponse>() {
            @Override
            public void onResponse(@NonNull Call<ServiceLastPageResponse> call, @NonNull Response<ServiceLastPageResponse> response) {
                ServiceLastPageResponse serviceLastPageResponse = response.body();
                Log.e(TAG, "onResponse: " + new GsonBuilder().create().toJson(serviceLastPageResponse));
                if (response.code() == 200) {
                    pDialog.dismiss();
                    //  startActivity(new Intent(ServicesLastPage.this, LoginActivity.class));
                    Utils.customMessage(ServicesLastPage.this, "Thank You.");
                    finish();
                } else if (response.code() == 400) {
                    pDialog.dismiss();
                    Utils.customMessage(ServicesLastPage.this, "Something went wrong.");
                } else if (response.code() == 404) {
                    pDialog.dismiss();
                    Utils.customMessage(ServicesLastPage.this, "There is problem to register.");
                } else if (response.code() == 409) {
                    pDialog.dismiss();
                    Utils.customMessage(ServicesLastPage.this, "Email id already exists.");
                } else if (response.code() == 500) {
                    pDialog.dismiss();
                    Utils.customMessage(ServicesLastPage.this, "Internal server error.");
                }
            }

            @Override
            public void onFailure(Call<ServiceLastPageResponse> call, Throwable t) {
                pDialog.dismiss();
                Utils.customMessage(ServicesLastPage.this, t.getMessage());
            }


        });


    }

    private boolean validate1() {
        boolean temp = true;
        String checkemail = email_add.getText().toString();

        if (!isValidEmaillId(checkemail)) {
            Toast.makeText(ServicesLastPage.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            temp = false;
        }

        return temp;
    }


    private boolean validate() {


        if (fullname.getText().toString().equals("")) {
            Toast.makeText(ServicesLastPage.this, "Please Enter Valid User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (email_add.getText().toString().equals("")) {
            Toast.makeText(ServicesLastPage.this, "Please enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (contactno.getText().toString().equals("")) {
            Toast.makeText(ServicesLastPage.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (toolbar.getTitle() != "Adopt A Pet") {
            if (address.getText().toString().equals("")) {
                Toast.makeText(ServicesLastPage.this, "Please Enter Your Address", Toast.LENGTH_LONG).show();
                return false;
            } else if (address.getText().length() < 12) {
                Toast.makeText(ServicesLastPage.this, "Please Provide Your valid Address", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        if (toolbar.getTitle() == "Adopt A Pet") {
            if (message.getText().toString().equals("")) {
                Toast.makeText(ServicesLastPage.this, "Please write your comments", Toast.LENGTH_LONG).show();
                return false;
            }
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
