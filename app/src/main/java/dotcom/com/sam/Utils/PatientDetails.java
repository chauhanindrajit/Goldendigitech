package dotcom.com.sam.Utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.Activity.ServicesLastPage;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ServiceLastPageResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ServicelastpageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientDetails extends AppCompatActivity {
    LinearLayout vet_near_layout;
    TextInputLayout vet_at_home_address_layout;
    TextView time, date;
    Button btnconfm;
    TextView actname, srid, buypetcnt;
    AutoCompleteTextView pettype;
    LinearLayout buypetcont;
    List<String> Pettype = new ArrayList<>();
    EditText fullname, email_add, contactno, address, message;
    private ProgressDialog pDialog;
    Toolbar toolbar;
    RadioGroup visitGrp;
    private String visitype = "";
    public String TAG = ServicesLastPage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
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
        initView();
        setVisiblityLayout();
        time = (TextView) findViewById(R.id.patenttime);
        date = (TextView) findViewById(R.id.patentdate);
        btnconfm = (Button) findViewById(R.id.btnconform);
        fullname = (EditText) findViewById(R.id.full_name);
        email_add = (EditText) findViewById(R.id.emai_id);
        contactno = (EditText) findViewById(R.id.contact_no);
        address = (EditText) findViewById(R.id.address_detail);
        message = (EditText) findViewById(R.id.message);
        pettype = (AutoCompleteTextView) findViewById(R.id.pet_type);
        visitGrp = (RadioGroup) findViewById(R.id.gender_grp);
        time.setText(SingletonClass.getInstance().getTime());
        date.setText(SingletonClass.getInstance().getDate());
        visitGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked) {
                    visitype = String.valueOf(checkedRadioButton.getText());
                    Log.e(" Gender Group ", "onCheckedChanged: " + checkedRadioButton.getText());
                }
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(PatientDetails.this, R.layout.custom_spinner_item, Pettype);
        loadTypeArrayAdapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        pettype.setThreshold(1);
        pettype.setAdapter(loadTypeArrayAdapter1);
        Pettype.add("Dogs");
        Pettype.add("Cats");
        Pettype.add("Ferrets");
        Pettype.add("Guinea Pigs");
        Pettype.add("Rabbits");
        Pettype.add("Hamsters");
        Pettype.add("Gerbils");
        pettype.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pettype.showDropDown();
                return false;
            }
        });
        btnconfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.isOnline(PatientDetails.this)) {
                    if (validate()) {

                        String username = fullname.getText().toString().trim();
                        String emailId = email_add.getText().toString().trim();
                        String mob = contactno.getText().toString().trim();
                        String msg = pettype.getText().toString().trim();
                        String add = address.getText().toString().trim();
                        String tym = time.getText().toString().trim();
                        String dat = date.getText().toString().trim();
                        String naturevist = visitype;
                        String activity = SingletonClass.getInstance().getActivityname();
                        String srid = (SingletonClass.getInstance().getSRID());
                        String centrname = SingletonClass.getInstance().getCentername();

                        if (validate1()) {
                            submit(username, emailId, mob, add, activity, srid, centrname, msg, tym, dat, naturevist);
                        }

                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PatientDetails.this);
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


    private void initView() {
        vet_near_layout = findViewById(R.id.vet_near_layout);
        vet_at_home_address_layout = findViewById(R.id.vet_at_home_address_layout);


    }

    private void setVisiblityLayout() {
        if (PetDoctor.categeory == Constats.VET_NEAR_ME || PetDoctor.categeory == Constats.VACCINATION) {
            vet_at_home_address_layout.setVisibility(View.GONE);
            vet_near_layout.setVisibility(View.VISIBLE);
        } else if (PetDoctor.categeory == Constats.VET_AT_HOME) {
            vet_near_layout.setVisibility(View.GONE);
            vet_at_home_address_layout.setVisibility(View.VISIBLE);
        }


    }

    private void submit(String username, String emailId, String mob, String add, String activity, String srid, String centrname, String msg, String tym, String dat, String naturevist) {
        final Dialog dialog = new Dialog(PatientDetails.this);
        pDialog = new ProgressDialog(PatientDetails.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        // Getting Device Unique ID.
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("HardwareIds")

        ServicelastpageRequest servicelastpageRequest = new ServicelastpageRequest();
        servicelastpageRequest.setName(username);
        servicelastpageRequest.setEmail(emailId);
        servicelastpageRequest.setMOB(mob);
        servicelastpageRequest.setDate(dat);
        servicelastpageRequest.setDateAndtime(tym);
        servicelastpageRequest.setNatureOfVisit(naturevist);
        if (!add.equals("")) {
            servicelastpageRequest.setAddress(add);
        } else {
            servicelastpageRequest.setAddress("NULL");
        }
        if (!msg.equals("")) {
            servicelastpageRequest.setPetType(msg);
        } else {
            servicelastpageRequest.setPetType("NULL");
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
                    pDialog.hide();
                    //  startActivity(new Intent(ServicesLastPage.this, LoginActivity.class));
                    Utils.customMessage(PatientDetails.this, "Thank You.");
                    finish();
                } else if (response.code() == 400) {
                    pDialog.hide();
                    Utils.customMessage(PatientDetails.this, "Something went wrong.");
                } else if (response.code() == 404) {
                    pDialog.hide();
                    Utils.customMessage(PatientDetails.this, "There is problem to register.");
                } else if (response.code() == 409) {
                    pDialog.hide();
                    Utils.customMessage(PatientDetails.this, "Email id already exists.");
                } else if (response.code() == 500) {
                    pDialog.hide();
                    Utils.customMessage(PatientDetails.this, "Internal server error.");
                }
            }

            @Override
            public void onFailure(Call<ServiceLastPageResponse> call, Throwable t) {
                pDialog.hide();
                Utils.customMessage(PatientDetails.this, t.getMessage());
            }


        });


    }

    private boolean validate1() {
        boolean temp = true;
        String checkemail = email_add.getText().toString();

        if (!isValidEmaillId(checkemail)) {
            Toast.makeText(PatientDetails.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            temp = false;
        }

        return temp;
    }


    private boolean validate() {


        if (fullname.getText().toString().equals("")) {
            Toast.makeText(PatientDetails.this, "Please Enter Valid User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (email_add.getText().toString().equals("")) {
            Toast.makeText(PatientDetails.this, "Please enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (contactno.getText().toString().equals("")) {
            Toast.makeText(PatientDetails.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (toolbar.getTitle() == "Vet At Home") {
            if (address.getText().toString().equals("")) {
                Toast.makeText(PatientDetails.this, "Please Enter Your Address", Toast.LENGTH_LONG).show();
                return false;
            } else if (address.getText().length() < 12) {
                Toast.makeText(PatientDetails.this, "Please Provide Your valid Address", Toast.LENGTH_LONG).show();
                return false;
            }
        }
//        if (toolbar.getTitle() == "Adopt A Pet") {
//            if (message.getText().toString().equals("")) {
//                Toast.makeText(PatientDetails.this, "Please write your comments", Toast.LENGTH_LONG).show();
//                return false;
//            }
//        }
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
