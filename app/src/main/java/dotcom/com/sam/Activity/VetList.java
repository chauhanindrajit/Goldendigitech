package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.VetListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.VetNearMeResponse;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.SingaltonsClasses.TripSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;

public class VetList extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    ArrayList tripSingaltonss;
    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;
    RecyclerView categeoryLayout;
    Button searchdoct;
    private ProgressDialog pDialog;
    private static String url = "http://worldindia.in/SamApi/api/SamVC/getShopByPetCategoryList";
    List<TripSingalton> tripSingalton;
    public static List<TripSingalton> tripSingaltona;
    private ArrayList<TripSingalton> arrSubCateogry;
    private ArrayAdapter<TripSingalton> stationListAdapter;
    TextView catname;

    List<String> locationTypeList = new ArrayList<>();
    ImageView pdnitm;
    public static Boolean isfilter = false;
    ArrayList<String> item = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    Toolbar toolbar;
    AutoCompleteTextView acTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_list);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Vet Near Me");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        intitViewS();
        searchDrawer();
        setViewVisiblity();
        //initList();

        if (Utils.isOnline(VetList.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(VetList.this);
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
        acTextView.setCursorVisible(true);
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });

        // locationTypeList.add("Select Location");

        //locType = (Spinner) findViewById(R.id.loadtype);

//        locType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if (categoryId.size() > 0) {
//                    selectedCat = locType.getSelectedItem().toString();
//
//                    if (!selectedCat.equals("Select Location")) {
//                        catId = categoryId.get(i - 1);
//                        myStr = locType.getSelectedItem().toString();
//                        //textsearch.setText(myStr);
//                    } else {
//                    }
//
//                } else {
//                }
//              /*  String myStr = locType.getSelectedItem().toString();
//                textsearch.setText(myStr);*/
//                // locationTypeList.add(tripSingalton.getLocation());
//            }
//
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                locType.clearFocus();
//
//            }
//        });


        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(VetList.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final VetListAdapter vetListAdapter = new VetListAdapter(VetList.this, tripSingaltonss);

        acTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
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

                    vetListAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    vetListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(vetListAdapter);
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

                acTextView.setAdapter(loadTypeArrayAdapter);
                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", -seachlayout.getHeight());
                animation.setDuration(800);
                animation.start();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


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

    private void setViewVisiblity() {
        if (MainActivity.module_name == Constats.Module.ADOPTED) {// invisible search drawer for adapted
            seachlayout.setVisibility(View.GONE);
            down_button.setVisibility(View.GONE);
        } else {
            seachlayout.setVisibility(View.VISIBLE);
            down_button.setVisibility(View.VISIBLE);
        }
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

    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }

    private void initList() {
        RecyclerView.Adapter adapter = null;
        if (MainActivity.module_name == Constats.Module.MATING || MainActivity.module_name == Constats.Module.ADOPTED) {
            adapter = new MatingAdapter(this);
        } else if (MainActivity.module_name == Constats.Module.PET_OLDAGE_HOME) {
            // adapter = new PetOldageListAdapter(this);
        }
//        else if (PetDoctor.categeory == Constats.DIAGNOSTICS) {
//            adapter = new DiagnosticListAdapter(this);
//        }
        else {
            if (PetDoctor.categeory == Constats.VET_AT_HOME || PetDoctor.categeory == Constats.VET_NEAR_ME || PetDoctor.categeory == Constats.VACCINATION) {
            }

        }


        //   GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void checkAcceptTrip() {

        arrSubCateogry = new ArrayList<>();
        pDialog = new ProgressDialog(VetList.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<VetNearMeResponse> vetNearMeResponseCall = Utilss.getWebService().VET_NEAR_ME_RESPONSE_CALL();
        vetNearMeResponseCall.enqueue(new Callback<VetNearMeResponse>() {
            @Override
            public void onResponse(Call<VetNearMeResponse> call, Response<VetNearMeResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    VetNearMeResponse vetNearMeResponse = response.body();
                    Log.e("Vetlist", new GsonBuilder().create().toJson(response));
                    // initList();

                    for (int i = 0; i < vetNearMeResponse.getResponse().size(); i++) {


                        TripSingalton tripSingalton = new TripSingalton();
                        tripSingalton.setDoctorName(vetNearMeResponse.getResponse().get(i).getDoctorName());
                        tripSingalton.setQualification(vetNearMeResponse.getResponse().get(i).getQualification());
                        tripSingalton.setWorkExperience(vetNearMeResponse.getResponse().get(i).getWorkExperience());
                        tripSingalton.setNearMeFees(vetNearMeResponse.getResponse().get(i).getNearMeFees());
                        tripSingalton.setAvailableTime(vetNearMeResponse.getResponse().get(i).getAvailableTime());
                        tripSingalton.setDescription(vetNearMeResponse.getResponse().get(i).getDescription());
                        tripSingalton.setLocation(vetNearMeResponse.getResponse().get(i).getLocation());
                        tripSingalton.setDoctorType(vetNearMeResponse.getResponse().get(i).getDoctorType());
                        tripSingalton.setImage(vetNearMeResponse.getResponse().get(i).getImage());

                        tripSingaltonss.add(tripSingalton);
                        // acTextView.setText("");


                        item.add(vetNearMeResponse.getResponse().get(i).getLocation());
                        locationTypeList.add(vetNearMeResponse.getResponse().get(i).getLocation());

                        VetListAdapter vetListAdapter = new VetListAdapter(VetList.this, tripSingaltonss);
                        vetListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(VetList.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(vetListAdapter);
                        vetListAdapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<VetNearMeResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }


}
