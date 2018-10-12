package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import dotcom.com.sam.Adapters.VaccinationListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.VaccinationResponse;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VacccinationHome extends AppCompatActivity {
    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;
    private ProgressDialog pDialog;
    private ArrayList<VaccinationResponse.ResponseBean> arrSubCateogry;
    AutoCompleteTextView acTextView;
    ImageView pdnitm;
    private ArrayAdapter<String> adapter;
    Button searchdoct;
    List<String> locationTypeList = new ArrayList<>();
    ArrayList<String> item = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacccination_home);
        intitViewS();
        searchDrawer();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Vaccination");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // setViewVisiblity();
        initList();
        if (Utils.isOnline(VacccinationHome.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(VacccinationHome.this);
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
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });

        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(VacccinationHome.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final VaccinationListAdapter vaccinationListAdapter = new VaccinationListAdapter(VacccinationHome.this, arrSubCateogry);

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

                    vaccinationListAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    vaccinationListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(vaccinationListAdapter);
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

    private void initList() {
        RecyclerView.Adapter adapter = null;
        if (MainActivity.module_name == Constats.Module.MATING || MainActivity.module_name == Constats.Module.ADOPTED) {
            adapter = new MatingAdapter(this);
        } else if (MainActivity.module_name == Constats.Module.PET_OLDAGE_HOME) {
            //adapter =new PetOldageListAdapter(this);
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

        pDialog = new ProgressDialog(VacccinationHome.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
        pDialog.show();
        pDialog.setContentView( R.layout.progress_bar );
        final Call<VaccinationResponse> vaccinationResponseCall = Utilss.getWebService().VACCINATION_RESPONSE_CALL();
        vaccinationResponseCall.enqueue(new Callback<VaccinationResponse>() {
            @Override
            public void onResponse(Call<VaccinationResponse> call, Response<VaccinationResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    VaccinationResponse vaccinationResponse = response.body();
                    Log.e("Vetlist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < vaccinationResponse.getResponse().size(); i++) {
                        locationTypeList.add(vaccinationResponse.getResponse().get(i).getLocation());
                        // initList();
                        VaccinationListAdapter vaccinationListAdapter = new VaccinationListAdapter(VacccinationHome.this, vaccinationResponse.getResponse());
                        vaccinationListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(VacccinationHome.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(vaccinationListAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<VaccinationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

}


