package dotcom.com.sam.Utils;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import dotcom.com.sam.Activity.PetSetter;
import dotcom.com.sam.Activity.ServicesLastPage;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ServiceLastPageResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ServicelastpageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiagnosticForm extends AppCompatActivity {
    Toolbar toolbar;
    Button btnconfm;
    final Calendar myCalendar = Calendar.getInstance();
    EditText fullname, email_add, contactno, address, message, time, getdate, age, starttime, endtime;
    private ProgressDialog pDialog;
    RadioGroup visitGrp;
    List<String> Gender = new ArrayList<>();
    List<String> Pettype = new ArrayList<>();
    List<String> Breed = new ArrayList<>();
    List<String> Sample = new ArrayList<>();
    private String visitype = "";
    AutoCompleteTextView gender, breed, pettype, samplefor;
    public String TAG = DiagnosticForm.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_form);
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
        btnconfm = (Button) findViewById(R.id.btnconform);
        fullname = (EditText) findViewById(R.id.full_name);
        email_add = (EditText) findViewById(R.id.emai_id);
        contactno = (EditText) findViewById(R.id.contact_no);

        message = (EditText) findViewById(R.id.message);
        pettype = (AutoCompleteTextView) findViewById(R.id.pet_type);
        visitGrp = (RadioGroup) findViewById(R.id.gender_grp);

        breed = (AutoCompleteTextView) findViewById(R.id.pet_breed);
        getdate = (EditText) findViewById(R.id.selectdate);
        age = (EditText) findViewById(R.id.age);
        gender = (AutoCompleteTextView) findViewById(R.id.gender);
        starttime = (EditText) findViewById(R.id.starttime);
        endtime = (EditText) findViewById(R.id.endtime);
        samplefor = (AutoCompleteTextView) findViewById(R.id.samplefor);

        // time.setText(SingletonClass.getInstance().getTime());
        //date.setText(SingletonClass.getInstance().getDate());
        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(DiagnosticForm.this, R.layout.custom_spinner_item, Gender);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        gender.setThreshold(1);
        gender.setAdapter(loadTypeArrayAdapter);
        Gender.add("Male");
        Gender.add("Female");
        gender.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gender.showDropDown();
                return false;
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(DiagnosticForm.this, R.layout.custom_spinner_item, Pettype);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
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
        final ArrayAdapter<String> loadTypeArrayAdapter3 = new ArrayAdapter<>(DiagnosticForm.this, R.layout.custom_spinner_item, Breed);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        breed.setThreshold(1);
        breed.setAdapter(loadTypeArrayAdapter3);
        Breed.add("Afghan HoundAfghan Hound");
        Breed.add("Airedale TerrierAiredale Terrier");
        Breed.add("AkitaAkita");
        Breed.add(" Alaskan Klee KaiAlaskan Klee Kai");
        Breed.add("American BulldogAmerican Bulldog");
        Breed.add(" Barbet");
        Breed.add("BasenjiBasenji");
        Breed.add("Bearded CollieBearded Collie");
        Breed.add("BeagleBeagle");


        breed.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                breed.showDropDown();
                return false;
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter4 = new ArrayAdapter<>(DiagnosticForm.this, R.layout.custom_spinner_item, Sample);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        samplefor.setThreshold(1);
        samplefor.setAdapter(loadTypeArrayAdapter4);
        Sample.add("sample1");
        Sample.add("sample2");
        samplefor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                samplefor.showDropDown();
                return false;
            }
        });

        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int second = mcurrentTime.get(Calendar.SECOND);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DiagnosticForm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        starttime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        endtime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DiagnosticForm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        endtime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        getdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(DiagnosticForm.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
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
        btnconfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.isOnline(DiagnosticForm.this)) {
                    if (validate()) {

                        String username = fullname.getText().toString().trim();
                        String emailId = email_add.getText().toString().trim();
                        String mob = contactno.getText().toString().trim();
                        String msg = pettype.getText().toString().trim();
                        String strttym = starttime.getText().toString().trim();
                        String endtym = endtime.getText().toString().trim();
                        String dat = getdate.getText().toString().trim();
                        String petbreed = breed.getText().toString().trim();
                        String petage = age.getText().toString().trim();
                        String gendr = gender.getText().toString().trim();
                        String naturevist = visitype;
                        String sample = samplefor.getText().toString().trim();
                        String activity = SingletonClass.getInstance().getActivityname();
                        String srid = (SingletonClass.getInstance().getSRID());
                        String centrname = SingletonClass.getInstance().getCentername();

                        if (validate1()) {
                            submit(username, emailId, mob, activity, srid, centrname, msg, strttym, endtym, naturevist, dat, petbreed, petage, gendr, sample);

                        }

                    }

                } else {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(DiagnosticForm.this);
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

    private void submit(String username, String emailId, String mob, String activity, String srid, String centrname, String msg, String dat, String strttym, String endtym, String naturevist, String petbreed, String petage, String gendr, String sample) {
        final Dialog dialog = new Dialog(DiagnosticForm.this);
        pDialog = new ProgressDialog(DiagnosticForm.this);
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
        servicelastpageRequest.setDate(naturevist);
        servicelastpageRequest.setTimeSlotFrom(strttym);
        servicelastpageRequest.setTimeSlotTo(dat);
        servicelastpageRequest.setPetBreed(petbreed);
        servicelastpageRequest.setAge(petage);
        servicelastpageRequest.setGender(gendr);
        servicelastpageRequest.setSelectSamplefrom(sample);
        servicelastpageRequest.setCollectReportAt(endtym);
//        if (!add.equals("")) {
//            servicelastpageRequest.setAddress(add);
//        } else {
//            servicelastpageRequest.setAddress("NULL");
//        }
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
                    Utils.customMessage(DiagnosticForm.this, "Thank You.");
                    finish();
                } else if (response.code() == 400) {
                    pDialog.hide();
                    Utils.customMessage(DiagnosticForm.this, "Something went wrong.");
                } else if (response.code() == 404) {
                    pDialog.hide();
                    Utils.customMessage(DiagnosticForm.this, "There is problem to register.");
                } else if (response.code() == 409) {
                    pDialog.hide();
                    Utils.customMessage(DiagnosticForm.this, "Email id already exists.");
                } else if (response.code() == 500) {
                    pDialog.hide();
                    Utils.customMessage(DiagnosticForm.this, "Internal server error.");
                }
            }

            @Override
            public void onFailure(Call<ServiceLastPageResponse> call, Throwable t) {
                pDialog.hide();
                Utils.customMessage(DiagnosticForm.this, t.getMessage());
            }


        });


    }

    private boolean validate1() {
        boolean temp = true;
        String checkemail = email_add.getText().toString();

        if (!isValidEmaillId(checkemail)) {
            Toast.makeText(DiagnosticForm.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            temp = false;
        }

        return temp;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        getdate.setText(sdf.format(myCalendar.getTime()));
        // enddtae.setText(sdf.format(myCalendar.getTime()));
    }

    private boolean validate() {


        if (fullname.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Valid User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (email_add.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (contactno.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (breed.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Pet breed name.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (pettype.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Pettype.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (age.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (gender.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Age.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (samplefor.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Sample type.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (starttime.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Start time", Toast.LENGTH_LONG).show();
            return false;
        }
        if (endtime.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter End time.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (getdate.getText().toString().equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Enter Date.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (visitype.equals("")) {
            Toast.makeText(DiagnosticForm.this, "Please Select Collect Report At", Toast.LENGTH_LONG).show();
            return false;
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
