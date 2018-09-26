package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.Duration;

import dotcom.com.sam.Adapters.DoggroomingListAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.MatingSearchAdapter;
import dotcom.com.sam.Adapters.PetSetterSearchAdapter;
import dotcom.com.sam.Adapters.PetsitterAdapter;
import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.Credentials.Splash;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.Response.MatingsearchResponse;
import dotcom.com.sam.Response.PetSitterResponse;
import dotcom.com.sam.Response.PetSittersearchResponse;
import dotcom.com.sam.SingaltonsClasses.MatingSingalton;
import dotcom.com.sam.SingaltonsClasses.PetSitterSingalton;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.MatingsearchRequest;
import dotcom.com.sam.request.PetSettersearchRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetSetter extends AppCompatActivity {
    CardView up_button, down_button;

    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;
    final Calendar myCalendar = Calendar.getInstance();
    private ProgressDialog pDialog;
    private ArrayList<PetSitterSingalton> arrSubCateogry;
    AutoCompleteTextView acTextView, duration;
    ImageView pdnitm;
    private ArrayAdapter<String> adapter;
    Button searchdoct;
    List<String> locationTypeList = new ArrayList<>();
    private ArrayList<PetSettersearchRequest> tripSingaltonsas;
    List<String> Durationtype = new ArrayList<>();
    ArrayList<String> item = new ArrayList<>();
    boolean isforeGground = true;
    DatePicker datePicker;
    String shorttimee;
    TextView resultdata;
    EditText getdate, enddtae, starttime, endtime;
    LinearLayout strtdatelayt, enddatelayt, srttymlyot, endtymlayt, duratnlayout;
    ArrayList tripSingaltonss;
    String durtn = "";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_setter);
        intitViewS();
        searchDrawer();
        initList();
        if (Utils.isOnline(PetSetter.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PetSetter.this);
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
        acTextView = (AutoCompleteTextView) findViewById(R.id.languages);
        resultdata = (TextView) findViewById(R.id.resultdata);
        getdate = (EditText) findViewById(R.id.getdate);
        enddtae = (EditText) findViewById(R.id.enddate);
        starttime = (EditText) findViewById(R.id.starttime);
        endtime = (EditText) findViewById(R.id.endtime);
        duration = (AutoCompleteTextView) findViewById(R.id.duration);
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        strtdatelayt = (LinearLayout) findViewById(R.id.startdatelayout);
        enddatelayt = (LinearLayout) findViewById(R.id.enddatelayout);
        srttymlyot = (LinearLayout) findViewById(R.id.starttimelayout);
        endtymlayt = (LinearLayout) findViewById(R.id.endtimelayout);
        duratnlayout = (LinearLayout) findViewById(R.id.durationlayout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("PetSetter");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tripSingaltonss = new ArrayList<>();
        tripSingaltonsas = new ArrayList<>();
        tripSingaltonsas.clear();
        tripSingaltonss.clear();
        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int second = mcurrentTime.get(Calendar.SECOND);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(PetSetter.this, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(PetSetter.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        endtime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });
        duration.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                duration.showDropDown();
                return false;
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(PetSetter.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);


        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(PetSetter.this, R.layout.custom_spinner_item, Durationtype);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        duration.setThreshold(1);
        duration.setAdapter(loadTypeArrayAdapter1);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final PetsitterAdapter petsitterAdapter = new PetsitterAdapter(PetSetter.this, arrSubCateogry);


        Durationtype.add("Short-time care(1 Day care)");
        Durationtype.add("Long-time care(More than 1 day)");


        duration.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (i == 0) {
                    durtn = "short";
                    strtdatelayt.setVisibility(View.GONE);
                    enddatelayt.setVisibility(View.GONE);
                    srttymlyot.setVisibility(View.VISIBLE);
                    endtymlayt.setVisibility(View.VISIBLE);
                    duratnlayout.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    getdate.getText().clear();
                    enddtae.getText().clear();
                    ;
                } else if (i == 1) {
                    durtn = "long";
                    duratnlayout.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    srttymlyot.setVisibility(View.GONE);
                    endtymlayt.setVisibility(View.GONE);
                    strtdatelayt.setVisibility(View.VISIBLE);
                    enddatelayt.setVisibility(View.VISIBLE);
                    starttime.getText().clear();
                    endtime.getText().clear();

                }

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
        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel1();
            }

        };
        getdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(PetSetter.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        enddtae.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(PetSetter.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        acTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
                return false;
            }
        });
        // locationTypeList.add(tripSingalton.getLocation());
        acTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    petsitterAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    petsitterAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(petsitterAdapter);
                } catch (Exception e) {
                    acTextView.getText().clear();
                    acTextView.setText("");

                }


            }
        });


        searchdoct = (Button) findViewById(R.id.seachbtn);
        searchdoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loc = acTextView.getText().toString().trim();
                String dur = durtn.toString().trim();
                String Strttime = starttime.getText().toString().trim();
                String endtym = endtime.getText().toString().trim();
                String strtdate = getdate.getText().toString().trim();
                String enddatee = enddtae.getText().toString().trim();
                if (validate()) {
                    Searchmatingdata(loc, dur, strtdate, enddatee, Strttime, endtym);

                    acTextView.setAdapter(loadTypeArrayAdapter);
                    ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", -seachlayout.getHeight());
                    animation.setDuration(800);
                    animation.start();
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                }
                try {
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                }
            }
        });
//        searchdoct.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    hideKeyboard(v);
//                }
//            }
//        });
        // final VetListAdapter vetListAdapter = new VetListAdapter(VetList.this,  tripSingaltonss);
        acTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acTextView.getText().clear();
            }
        });
        duration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duration.getText().clear();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private boolean validate() {


        if (acTextView.getText().toString().equals("")) {

            Toast.makeText(PetSetter.this, "Please Select location", Toast.LENGTH_LONG).show();
            return false;
        }

        if (duration.getText().toString().equals("")) {
            Toast.makeText(PetSetter.this, "Please select duration time", Toast.LENGTH_LONG).show();
            return false;
        }


        return true;
    }

    private void setViewVisiblity() {
        if (MainActivity.module_name == Constats.Module.ADOPTED) {// invisible search drawer for adapted
            seachlayout.setVisibility(View.GONE);
            down_button.setVisibility(View.GONE);
        } else {
            seachlayout.setVisibility(View.VISIBLE);
            down_button.setVisibility(View.VISIBLE);
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    void searchDrawer() {
        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* down_button.setVisibility(View.VISIBLE);
                seachlayout.setVisibility(View.GONE);
                seachlayout.setAnimation(visbile_anim);*/


                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", -seachlayout.getHeight());
                animation.setDuration(800);
                animation.start();
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 /*               seachlayout.setVisibility(View.VISIBLE);
               seachlayout.setAnimation(invisible_anim);
*/
                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", 0);
                animation.setDuration(800);
                animation.start();
            }
        });

    }


    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        getdate.setText(sdf.format(myCalendar.getTime()));
        // enddtae.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateLabel1() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //getdate.setText(sdf.format(myCalendar.getTime()));
        enddtae.setText(sdf.format(myCalendar.getTime()));
    }

    void intitViewS() {
        up_button = findViewById(R.id.crad_buttonup);
        down_button = findViewById(R.id.crad_buttondown);
        seachlayout = findViewById(R.id.seach_layout);
        visbile_anim = AnimationUtils.loadAnimation(this, R.anim.visible_animation_);
        invisible_anim = AnimationUtils.loadAnimation(this, R.anim.invisible_animation);
        recyclerView = findViewById(R.id.recyclerview);


    }

    private void initList() {
        RecyclerView.Adapter adapter = null;
        if (MainActivity.module_name == Constats.Module.MATING || MainActivity.module_name == Constats.Module.ADOPTED) {
            adapter = new MatingAdapter(this);
        } else if (MainActivity.module_name == Constats.Module.PET_OLDAGE_HOME) {
            //adapter =new PetOldageListAdapter(this,arrSubCateogry);
        } else {
            if (PetDoctor.categeory == Constats.VET_AT_HOME || PetDoctor.categeory == Constats.VET_NEAR_ME || PetDoctor.categeory == Constats.VACCINATION) {
            }
//            else if (PetDoctor.categeory == Constats.DIAGNOSTICS) {
//                adapter = new DiagnosticListAdapter(this);
//            }

        }


        //   GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(PetSetter.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<PetSitterResponse> petSitterResponseCall = Utilss.getWebService().PET_SITTER_RESPONSE_CALL();
        petSitterResponseCall.enqueue(new Callback<PetSitterResponse>() {
            @Override
            public void onResponse(Call<PetSitterResponse> call, Response<PetSitterResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    PetSitterResponse petSitterResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < petSitterResponse.getResponse().size(); i++) {

                        PetSitterSingalton petSitterSingalton = new PetSitterSingalton();
                        petSitterSingalton.setName(petSitterResponse.getResponse().get(i).getName());
                        petSitterSingalton.setLocation(petSitterResponse.getResponse().get(i).getLocation());
                        petSitterSingalton.setAddress(petSitterResponse.getResponse().get(i).getAddress());
                        petSitterSingalton.setDescription(petSitterResponse.getResponse().get(i).getDescription());
                        petSitterSingalton.setServicesType(petSitterResponse.getResponse().get(i).getServicesType());
                        petSitterSingalton.setStartTime(petSitterResponse.getResponse().get(i).getStartTime());
                        petSitterSingalton.setEndTime(petSitterResponse.getResponse().get(i).getEndTime());
                        petSitterSingalton.setStartDate(petSitterResponse.getResponse().get(i).getStartDate());
                        petSitterSingalton.setEndDate(petSitterResponse.getResponse().get(i).getEndDate());
                        petSitterSingalton.setFees(petSitterResponse.getResponse().get(i).getFees());
                        petSitterSingalton.setPetAvailability(petSitterResponse.getResponse().get(i).getPetAvailability());
                        petSitterSingalton.setImage(petSitterResponse.getResponse().get(i).getImage());
                        petSitterSingalton.setSR_Id(petSitterResponse.getResponse().get(i).getSR_Id());

                        tripSingaltonss.add(petSitterSingalton);
                        locationTypeList.add(petSitterResponse.getResponse().get(i).getLocation());
                        PetsitterAdapter petsitterAdapter = new PetsitterAdapter(PetSetter.this, tripSingaltonss);
                        petsitterAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(PetSetter.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(petsitterAdapter);

                    }

                } else if (response.code() == 404) {
                    pDialog.dismiss();
                    Utils.customMessage(PetSetter.this, "Sorry no data found.!!");
                }
            }

            @Override
            public void onFailure(Call<PetSitterResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

    private void Searchmatingdata(String loc, String duratn, String strtday, String endday, String strtym, String endtym) {
        tripSingaltonss = new ArrayList<>();
        pDialog = new ProgressDialog(PetSetter.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        Call<PetSittersearchResponse> petSittersearchResponseCall = Utilss.getWebService().PET_SITTERSEARCH_RESPONSE_CALL(strtday, endday, strtym, endtym, loc, duratn);
        petSittersearchResponseCall.enqueue(new Callback<PetSittersearchResponse>() {
            @Override
            public void onResponse(Call<PetSittersearchResponse> call, Response<PetSittersearchResponse> response) {
                if (response.code() == 200) {
                    pDialog.dismiss();
                    PetSittersearchResponse petSittersearchResponse = response.body();
                    Log.e("searchresponse", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < petSittersearchResponse.getResponse().size(); i++) {
                        tripSingaltonsas.clear();
                        tripSingaltonss.clear();
                        resultdata.setVisibility(View.GONE);
                        PetSettersearchRequest petSettersearchRequest = new PetSettersearchRequest();
                        petSettersearchRequest.setName(petSittersearchResponse.getResponse().get(i).getName());
                        petSettersearchRequest.setLocation(petSittersearchResponse.getResponse().get(i).getLocation());
                        petSettersearchRequest.setAddress(petSittersearchResponse.getResponse().get(i).getAddress());
                        petSettersearchRequest.setDescription(petSittersearchResponse.getResponse().get(i).getDescription());
                        petSettersearchRequest.setServicesType(petSittersearchResponse.getResponse().get(i).getServicesType());
                        petSettersearchRequest.setStartTime(petSittersearchResponse.getResponse().get(i).getStartTime());
                        petSettersearchRequest.setEndTime(petSittersearchResponse.getResponse().get(i).getEndTime());
                        petSettersearchRequest.setStartDate(petSittersearchResponse.getResponse().get(i).getStartDate());
                        petSettersearchRequest.setEndDate(petSittersearchResponse.getResponse().get(i).getEndDate());
                        petSettersearchRequest.setFees(petSittersearchResponse.getResponse().get(i).getFees());
                        petSettersearchRequest.setPetAvailability(petSittersearchResponse.getResponse().get(i).getPetAvailability());
                        petSettersearchRequest.setImage(petSittersearchResponse.getResponse().get(i).getImage());
                        tripSingaltonsas.add(petSettersearchRequest);
                        tripSingaltonss.clear();
                        PetSetterSearchAdapter petSetterSearchAdapter = new PetSetterSearchAdapter(PetSetter.this, tripSingaltonsas);
                        petSetterSearchAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(PetSetter.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(petSetterSearchAdapter);
                        petSetterSearchAdapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();

                        // initList();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }

                } else
                    resultdata.setVisibility(View.VISIBLE);
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PetSittersearchResponse> call, Throwable t) {

                Log.e("ssdfsdfsdfsdv", "onFailure: " + t);
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                pDialog.dismiss();

            }


        });

    }
}
