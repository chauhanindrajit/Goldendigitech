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
import android.widget.AdapterView;
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

import dotcom.com.sam.Adapters.CatgroomingListAdapter;
import dotcom.com.sam.Adapters.CatsearchListAdapter;
import dotcom.com.sam.Adapters.DogsearchListAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.CatGroomingResponse;
import dotcom.com.sam.Response.CatsearchResponse;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.Response.DogsearchResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatGrooming extends AppCompatActivity {
    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;

    private ProgressDialog pDialog;
    private ArrayList<CatGroomingResponse.ResponseBean> arrSubCateogry;
    AutoCompleteTextView acTextView, selectbreed, selectage, sleectsize, salonlocation;
    ImageView pdnitm;
    private ArrayAdapter<String> adapter;
    Button searchdoct;
    List<String> locationTypeList = new ArrayList<>();
    List<String> breedarray = new ArrayList<>();
    List<String> agearray = new ArrayList<>();
    List<String> sizearray = new ArrayList<>();
    List<String> salonarray = new ArrayList<>();
    String athomeoratsalon;
    String pos, sizepos, salonpos;
    ArrayList<String> item = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgroming_home);
        intitViewS();
        searchDrawer();
        //setViewVisiblity();
        initList();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CatGrooming");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (Utils.isOnline(CatGrooming.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CatGrooming.this);
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
        selectbreed = (AutoCompleteTextView) findViewById(R.id.breedlist);
        selectage = (AutoCompleteTextView) findViewById(R.id.selectage);
        sleectsize = (AutoCompleteTextView) findViewById(R.id.selectsize);
        salonlocation = (AutoCompleteTextView) findViewById(R.id.salonloctn);
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });

        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(CatGrooming.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final CatgroomingListAdapter catgroomingListAdapter = new CatgroomingListAdapter(CatGrooming.this, arrSubCateogry);

        acTextView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
                return false;
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(CatGrooming.this, R.layout.custom_spinner_item, breedarray);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        selectbreed.setThreshold(1);
        selectbreed.setAdapter(loadTypeArrayAdapter1);
        selectbreed.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectbreed.showDropDown();
                return false;
            }
        });

        final ArrayAdapter<String> loadTypeArrayAdapter2 = new ArrayAdapter<>(CatGrooming.this, R.layout.custom_spinner_item, agearray);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        selectage.setThreshold(1);
        selectage.setAdapter(loadTypeArrayAdapter2);
        agearray.add("<1 Year");
        agearray.add("1-3 Years");
        agearray.add("3-5 Years");
        agearray.add("5-8 Years");
        agearray.add("8+ Years");
        selectage.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                pos = String.valueOf(i + 1);
                Log.e("POPSSSS", "onItemClick: " + pos);
            }
        });
        selectage.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectage.showDropDown();
                return false;
            }
        });
        final ArrayAdapter<String> loadTypeArrayAdapter3 = new ArrayAdapter<>(CatGrooming.this, R.layout.custom_spinner_item, sizearray);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        sleectsize.setThreshold(1);
        sleectsize.setAdapter(loadTypeArrayAdapter3);
        sizearray.add("Small (5-11 kg, 6-12 inches)");
        sizearray.add("Medium (11-20 kg, 12-16 inches)");
        sizearray.add("Large (20-35 kg, 16-24 inches)");
        sizearray.add("Giant (35-50 kg, 24-35 inches)");
        sleectsize.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sleectsize.showDropDown();
                return false;
            }
        });
        sleectsize.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                sizepos = String.valueOf(i + 1);
                Log.e("sizepos", "onItemClick: " + sizepos);
            }
        });

        final ArrayAdapter<String> loadTypeArrayAdapter4 = new ArrayAdapter<>(CatGrooming.this, R.layout.custom_spinner_item, salonarray);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        salonlocation.setThreshold(1);
        salonlocation.setAdapter(loadTypeArrayAdapter4);
        salonarray.add("Salon Service");
        salonarray.add("At Home Service");
        salonlocation.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                salonlocation.showDropDown();
                return false;
            }
        });
        salonlocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (i == 0) {
                    salonpos = "Salon";
                } else if (i == 1) {
                    salonpos = "Home";
                }
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

                    catgroomingListAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    catgroomingListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(catgroomingListAdapter);
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
                if (validate()) {
                    if (salonpos.equals("Salon")) {
                        athomeoratsalon = "Salon";
                    } else if (salonpos.equals("Home")) {
                        // SingletonClass.getInstance().setSalonorhomeradio("Home");
                        athomeoratsalon = "Home";
                    }
                    String breedselected = selectbreed.getText().toString().trim();
                    String loc = acTextView.getText().toString().trim();
                    String ageselctd = pos.toString().trim();
                    String size = sizepos.toString().trim();
                    String salonlctn = salonpos.toString().trim();
                    Searchdoggrooming(breedselected, loc, ageselctd, size, salonlctn);
                }
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

        pDialog = new ProgressDialog(CatGrooming.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<CatGroomingResponse> catGroomingResponseCall = Utilss.getWebService().CAT_GROOMING_RESPONSE_CALL();
        catGroomingResponseCall.enqueue(new Callback<CatGroomingResponse>() {
            @Override
            public void onResponse(Call<CatGroomingResponse> call, Response<CatGroomingResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    CatGroomingResponse catGroomingResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < catGroomingResponse.getResponse().size(); i++) {
                        locationTypeList.add(String.valueOf(catGroomingResponse.getResponse().get(i).getSearchLocations()));
                        for (int j = 0; j < catGroomingResponse.getResponse().get(i).getGroomingdata().size(); j++) {
                            breedarray.add(catGroomingResponse.getResponse().get(i).getGroomingdata().get(j).getBreedName());
                        }
                        // initList();
                        CatgroomingListAdapter catgroomingListAdapter = new CatgroomingListAdapter(CatGrooming.this, catGroomingResponse.getResponse());
                        catgroomingListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(CatGrooming.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(catgroomingListAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CatGroomingResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

    private void Searchdoggrooming(String breedselected, String loc, String ageselctd, String size, String salonlctn) {
        arrSubCateogry = new ArrayList<>();
        pDialog = new ProgressDialog(CatGrooming.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<CatsearchResponse> catsearchResponseCall = Utilss.getWebService().CATSEARCH_RESPONSE_CALL(breedselected, ageselctd, size, salonlctn, loc);
        catsearchResponseCall.enqueue(new Callback<CatsearchResponse>() {
            @Override
            public void onResponse(Call<CatsearchResponse> call, Response<CatsearchResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    CatsearchResponse catsearchResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < catsearchResponse.getResponse().size(); i++) {
                        //                        locationTypeList.add(String.valueOf(catsearchResponse.getResponse().get(i).getSearchLocations()));
                        //                        // initList();
                        if (salonpos.equals("Salon")) {
                            SingletonClass.getInstance().setSalonorhomeradio("Salon");
                        } else if (salonpos.equals("Home")) {
                            SingletonClass.getInstance().setSalonorhomeradio("Home");
                        }
                        CatsearchListAdapter catsearchListAdapter = new CatsearchListAdapter(CatGrooming.this, catsearchResponse.getResponse());
                        catsearchListAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(CatGrooming.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(catsearchListAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CatsearchResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

    private boolean validate() {

        if (selectbreed.getText().toString().equals("")) {
            Toast.makeText(CatGrooming.this, "Please Select Breed name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (selectage.getText().toString().equals("")) {
            Toast.makeText(CatGrooming.this, "Please Select Age", Toast.LENGTH_LONG).show();
            return false;
        }
        if (sleectsize.getText().toString().equals("")) {
            Toast.makeText(CatGrooming.this, "Please Select Size.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (salonlocation.getText().toString().equals("")) {
            Toast.makeText(CatGrooming.this, "Please enter salon location.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
