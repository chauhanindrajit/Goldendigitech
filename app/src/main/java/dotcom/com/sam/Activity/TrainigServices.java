package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.TrainingservicesListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.Response.TrainingServicesResponse;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.PetWalkingRequest;
import dotcom.com.sam.request.TrainingRequest;
import dotcom.com.sam.request.WalkingsearchRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainigServices extends AppCompatActivity {
    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;

    private ProgressDialog pDialog;
    private ArrayList<TrainingRequest> arrSubCateogry;
    AutoCompleteTextView acTextView, selectservices;
    ImageView pdnitm;
    private ArrayAdapter<String> adapter;
    Button searchdoct;
    List<String> locationTypeList = new ArrayList<>();
    List<String> serviceslist = new ArrayList<>();
    ArrayList<String> item = new ArrayList<>();
    ArrayList tripSingaltonss;
    private ArrayList<TrainingRequest> tripSingaltonsas;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainig_services);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonsas = new ArrayList<>();
        tripSingaltonsas.clear();
        tripSingaltonss.clear();
        intitViewS();
        searchDrawer();
        //setViewVisiblity();
        initList();
        if (Utils.isOnline(TrainigServices.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(TrainigServices.this);
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
        selectservices = (AutoCompleteTextView) findViewById(R.id.selectservice);
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Training Services");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(TrainigServices.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);

        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(TrainigServices.this, R.layout.custom_spinner_item, serviceslist);
        loadTypeArrayAdapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        selectservices.setThreshold(1);
        selectservices.setAdapter(loadTypeArrayAdapter1);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final TrainingservicesListAdapter trainingservicesListAdapter = new TrainingservicesListAdapter(TrainigServices.this, arrSubCateogry);

        acTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
                return false;
            }
        });
        selectservices.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectservices.showDropDown();
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

                    trainingservicesListAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    trainingservicesListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(trainingservicesListAdapter);
                } catch (Exception e) {
                    acTextView.getText().clear();
                    acTextView.setText("");

                }


            }
        });
        selectservices.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    trainingservicesListAdapter.filter(selectservices.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    trainingservicesListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(trainingservicesListAdapter);
                } catch (Exception e) {
                    selectservices.getText().clear();
                    selectservices.setText("");

                }


            }
        });


        searchdoct = (Button) findViewById(R.id.seachbtn);
        searchdoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                acTextView.setAdapter(loadTypeArrayAdapter);
                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", -seachlayout.getHeight());
                animation.setDuration(800);
                animation.start();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


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
            // adapter =new PetOldageListAdapter(this);
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

        pDialog = new ProgressDialog(TrainigServices.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<TrainingServicesResponse> trainingServicesResponseCall = Utilss.getWebService().TRAINING_SERVICES_RESPONSE_CALL();
        trainingServicesResponseCall.enqueue(new Callback<TrainingServicesResponse>() {
            @Override
            public void onResponse(Call<TrainingServicesResponse> call, Response<TrainingServicesResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    TrainingServicesResponse trainingServicesResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < trainingServicesResponse.getResponse().size(); i++) {

                        TrainingRequest trainingRequest = new TrainingRequest();
                        trainingRequest.setCenterName(trainingServicesResponse.getResponse().get(i).getCenterName());
                        trainingRequest.setLocation(trainingServicesResponse.getResponse().get(i).getLocation());
                        trainingRequest.setAddress(trainingServicesResponse.getResponse().get(i).getAddress());
                        trainingRequest.setFees(trainingServicesResponse.getResponse().get(i).getFees());
                        trainingRequest.setOpenDay(trainingServicesResponse.getResponse().get(i).getOpenDay());
                        trainingRequest.setCloseDay(trainingServicesResponse.getResponse().get(i).getCloseDay());
                        trainingRequest.setServices(trainingServicesResponse.getResponse().get(i).getServices());
                        trainingRequest.setImage(trainingServicesResponse.getResponse().get(i).getImage());
                        trainingRequest.setMobile(trainingServicesResponse.getResponse().get(i).getMobile());
                        trainingRequest.setSR_Id(trainingServicesResponse.getResponse().get(i).getSR_Id());

                        tripSingaltonss.add(trainingRequest);

                        serviceslist.add(trainingServicesResponse.getResponse().get(i).getServices());
                        locationTypeList.add(trainingServicesResponse.getResponse().get(i).getLocation());
                        // initList();
                        TrainingservicesListAdapter trainingservicesListAdapter = new TrainingservicesListAdapter(TrainigServices.this, tripSingaltonss);
                        trainingservicesListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(TrainigServices.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(trainingservicesListAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TrainingServicesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

}
