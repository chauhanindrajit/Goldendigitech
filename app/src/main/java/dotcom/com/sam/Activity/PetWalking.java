package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Adapters.CatgroomingListAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.PetSetterSearchAdapter;
import dotcom.com.sam.Adapters.PetWalkingListAdapter;
import dotcom.com.sam.Adapters.PetsitterAdapter;
import dotcom.com.sam.Adapters.WalkingSearchAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.Response.PetSitterResponse;
import dotcom.com.sam.Response.PetSittersearchResponse;
import dotcom.com.sam.Response.PetWalkingResponse;
import dotcom.com.sam.Response.WalkingsearchResponse;
import dotcom.com.sam.SingaltonsClasses.PetSitterSingalton;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.PetSettersearchRequest;
import dotcom.com.sam.request.PetWalkingRequest;
import dotcom.com.sam.request.WalkingsearchRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetWalking extends AppCompatActivity {
    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;

    private ProgressDialog pDialog;
    private ArrayList<PetWalkingRequest> arrSubCateogry;
    AutoCompleteTextView acTextView, duration, selctday;
    ImageView pdnitm, drpdnin, loctnicon, duratinicon;
    private ArrayAdapter<String> adapter;
    Button searchdoct;
    List<String> Durationtype = new ArrayList<>();
    List<String> Selectdaytype = new ArrayList<>();
    List<String> locationTypeList = new ArrayList<>();
    ArrayList<String> item = new ArrayList<>();
    EditText starttime, endtime;
    ArrayList tripSingaltonss;
    private ArrayList<WalkingsearchRequest> tripSingaltonsas;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petwalking);
        intitViewS();
        searchDrawer();
        //duration = (AutoCompleteTextView) findViewById(R.id.duration);
        selctday = (AutoCompleteTextView) findViewById(R.id.selectday);
        starttime = (EditText) findViewById(R.id.starttime);
        endtime = (EditText) findViewById(R.id.endtime);
        drpdnin = (ImageView) findViewById(R.id.dropdwnicon);
        loctnicon = (ImageView) findViewById(R.id.loctndropicn);
        //duratinicon = (ImageView) findViewById(R.id.duratindrpicn);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonsas = new ArrayList<>();
        tripSingaltonsas.clear();
        tripSingaltonss.clear();
//        Durationtype.add("Morning");
//        Durationtype.add("Afternoon");
//        Durationtype.add("Evening");
//        Durationtype.add("Night");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("PetWalker");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Selectdaytype.add("Monday");
        Selectdaytype.add("Tuesday");
        Selectdaytype.add("Wednesday");
        Selectdaytype.add("Thursday");
        Selectdaytype.add("Friday");
        Selectdaytype.add("Saturday");


        starttime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(PetWalking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        starttime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
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
                mTimePicker = new TimePickerDialog(PetWalking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        endtime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        drpdnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selctday.showDropDown();
            }
        });
//        duratinicon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                duration.showDropDown();
//            }
//        });
        loctnicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.showDropDown();
            }
        });
        //setViewVisiblity();
        initList();
        if (Utils.isOnline(PetWalking.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PetWalking.this);
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
        // pdnitm =(ImageView)findViewById(R.id.pdnitm);
//        pdnitm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                acTextView.moveCursorToVisibleOffset();
//            }
//        });

        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(PetWalking.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);


//        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(PetWalking.this, R.layout.custom_spinner_item, Durationtype);
//        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
//        duration.setThreshold(1);
//        duration.setAdapter(loadTypeArrayAdapter1);


        final ArrayAdapter<String> loadTypeArrayAdapter2 = new ArrayAdapter<>(PetWalking.this, R.layout.custom_spinner_item, Selectdaytype);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        selctday.setThreshold(1);
        selctday.setAdapter(loadTypeArrayAdapter2);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final PetWalkingListAdapter petWalkingListAdapter = new PetWalkingListAdapter(PetWalking.this, arrSubCateogry);
        acTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
                return false;
            }
        });
//        duration.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                duration.showDropDown();
//                return false;
//            }
//        });
        selctday.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selctday.showDropDown();
                return false;
            }
        });

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

                    petWalkingListAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    petWalkingListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(petWalkingListAdapter);
                } catch (Exception e) {
                    acTextView.getText().clear();
                    acTextView.setText("");

                }


            }
        });

//
//        duration.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                duration.showDropDown();
//                return false;
//            }
//        });
        searchdoct = (Button) findViewById(R.id.seachbtn);
        searchdoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String loc = acTextView.getText().toString().trim();
                String strtday = selctday.getText().toString().trim();
                String Strttime = starttime.getText().toString().trim();
                String endtym = endtime.getText().toString().trim();

                if(validate()) {
                    Searchmatingdata(loc,strtday, Strttime, endtym);

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
        searchdoct.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        // final VetListAdapter vetListAdapter = new VetListAdapter(VetList.this,  tripSingaltonss);
        acTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acTextView.getText().clear();
            }
        });
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
            //adapter =new PetOldageListAdapter(this);
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

        pDialog = new ProgressDialog(PetWalking.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<PetWalkingResponse> petWalkingResponseCall = Utilss.getWebService().PET_WALKING_RESPONSE_CALL();
        petWalkingResponseCall.enqueue(new Callback<PetWalkingResponse>() {
            @Override
            public void onResponse(Call<PetWalkingResponse> call, Response<PetWalkingResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    PetWalkingResponse petWalkingResponse = response.body();
                    Log.e("walking", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < petWalkingResponse.getResponse().size(); i++) {

                        PetWalkingRequest petWalkingRequest = new PetWalkingRequest();
                        petWalkingRequest.setName(petWalkingResponse.getResponse().get(i).getName());
                        petWalkingRequest.setLocation(petWalkingResponse.getResponse().get(i).getLocation());
                        petWalkingRequest.setAddress(petWalkingResponse.getResponse().get(i).getAddress());
                        petWalkingRequest.setDuration(petWalkingResponse.getResponse().get(i).getDuration());
                        petWalkingRequest.setDay(petWalkingResponse.getResponse().get(i).getDay());
                        petWalkingRequest.setStarttime(petWalkingResponse.getResponse().get(i).getStarttime());
                        petWalkingRequest.setEndTime(petWalkingResponse.getResponse().get(i).getEndTime());
                        petWalkingRequest.setOpratingLocation(petWalkingResponse.getResponse().get(i).getOpratingLocation());
                        petWalkingRequest.setOpenDays(petWalkingResponse.getResponse().get(i).getOpenDays());
                        petWalkingRequest.setCloseDays(petWalkingResponse.getResponse().get(i).getCloseDays());
                        petWalkingRequest.setEmail(petWalkingResponse.getResponse().get(i).getEmail());
                        petWalkingRequest.setImage(petWalkingResponse.getResponse().get(i).getImage());
                        petWalkingRequest.setMobile(petWalkingResponse.getResponse().get(i).getMobile());
                        petWalkingRequest.setPerhoureCost(petWalkingResponse.getResponse().get(i).getPerhoureCost());
                        petWalkingRequest.setPerDayCost(petWalkingResponse.getResponse().get(i).getPerDayCost());
                        petWalkingRequest.setSR_Id(petWalkingResponse.getResponse().get(i).getSR_Id());
                        petWalkingRequest.setDescription(petWalkingResponse.getResponse().get(i).getDescription());
                        petWalkingRequest.setProfile(petWalkingResponse.getResponse().get(i).getProfile());

                        tripSingaltonss.add(petWalkingRequest);
                        locationTypeList.add(petWalkingResponse.getResponse().get(i).getLocation());
                        PetWalkingListAdapter petWalkingListAdapter = new PetWalkingListAdapter(PetWalking.this, tripSingaltonss);
                        petWalkingListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(PetWalking.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(petWalkingListAdapter);

                    }

                }else if (response.code() == 404) {
                    pDialog.hide();
                    Utils.customMessage(PetWalking.this, "Sorry no data found.!!");
                }}

            @Override
            public void onFailure(Call<PetWalkingResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

    private void Searchmatingdata(String loc, String strtday, String strtym, String endtym) {
        tripSingaltonss = new ArrayList<>();
        pDialog = new ProgressDialog(PetWalking.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        Call<WalkingsearchResponse> walkingsearchResponseCall = Utilss.getWebService().WALKINGSEARCH_RESPONSE_CALL(loc,strtday, strtym, endtym);
        walkingsearchResponseCall.enqueue(new Callback<WalkingsearchResponse>() {
            @Override
            public void onResponse(Call<WalkingsearchResponse> call, Response<WalkingsearchResponse> response) {
                if (response.code() == 200) {
                    pDialog.hide();
                    WalkingsearchResponse petSittersearchResponse = response.body();
                    Log.e("searchresponse", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < petSittersearchResponse.getResponse().size(); i++) {
                        tripSingaltonsas.clear();
                        tripSingaltonss.clear();
                        WalkingsearchRequest walkingsearchRequest = new WalkingsearchRequest();
                        walkingsearchRequest.setName(petSittersearchResponse.getResponse().get(i).getName());
                        walkingsearchRequest.setLocation(petSittersearchResponse.getResponse().get(i).getLocation());
                        walkingsearchRequest.setAddress(petSittersearchResponse.getResponse().get(i).getAddress());
                        walkingsearchRequest.setDescription(petSittersearchResponse.getResponse().get(i).getDescription());
                        walkingsearchRequest.setStarttime(petSittersearchResponse.getResponse().get(i).getStarttime());
                        walkingsearchRequest.setEndTime(petSittersearchResponse.getResponse().get(i).getEndTime());
                        walkingsearchRequest.setProfile(petSittersearchResponse.getResponse().get(i).getProfile());
                        walkingsearchRequest.setPerhoureCost(petSittersearchResponse.getResponse().get(i).getPerhoureCost());
                        walkingsearchRequest.setPerDayCost(petSittersearchResponse.getResponse().get(i).getPerDayCost());
                        walkingsearchRequest.setImage(petSittersearchResponse.getResponse().get(i).getImage());
                        tripSingaltonsas.add(walkingsearchRequest);
                        tripSingaltonss.clear();
                        WalkingSearchAdapter walkingSearchAdapter = new WalkingSearchAdapter(PetWalking.this, tripSingaltonsas);
                        walkingSearchAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(PetWalking.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(walkingSearchAdapter);
                        walkingSearchAdapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();

                        // initList();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }

                } else

                pDialog.hide();
            }

            @Override
            public void onFailure(Call<WalkingsearchResponse> call, Throwable t) {

                Log.e("ssdfsdfsdfsdv", "onFailure: " + t);
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                pDialog.hide();

            }


        });

    }
    private boolean validate() {



        if (acTextView.getText().toString().equals("")) {

            Toast.makeText(PetWalking.this,"Please Select location",Toast.LENGTH_LONG).show();
            return false;
        }

        if (selctday.getText().toString().equals("")) {
            Toast.makeText(PetWalking.this,"Please select day",Toast.LENGTH_LONG).show();
            return false;
        }


        return true;
    }

}
