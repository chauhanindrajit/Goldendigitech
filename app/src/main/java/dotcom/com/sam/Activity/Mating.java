package dotcom.com.sam.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
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

import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.MatingSearchAdapter;
import dotcom.com.sam.Adapters.MatingSingleAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.MatingResponse;
import dotcom.com.sam.Response.MatingsearchResponse;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.SingaltonsClasses.MatingSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.MatingsearchRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mating extends AppCompatActivity {

    CardView up_button, down_button;
    LinearLayout seachlayout;
    Animation visbile_anim, invisible_anim;
    RecyclerView recyclerView;
    RecyclerView categeoryLayout;
    Button searchdoct;
    private ProgressDialog pDialog;
    ImageView pdnitm;
    AutoCompleteTextView acTextView, pet_type, breed_type, gender_typea;
    private ArrayList<MatingSingalton> tripSingaltonss;
    private ArrayList<MatingsearchRequest> tripSingaltonsas;
    List<String> locationTypeList = new ArrayList<>();
    List<String> Pettypelist = new ArrayList<>();
    List<String> breedtypelist = new ArrayList<>();
    List<String> gendertypelist = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    ArrayList<String> item = new ArrayList<>();
    MatingsearchRequest matingsearchRequest;
    int postn;
    ;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mating);
        recyclerView = (RecyclerView) findViewById(R.id.recylcerview_products);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonsas = new ArrayList<>();
        if (Utils.isOnline(Mating.this)) {
            checkAcceptTrip();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Mating.this);
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
        intitViewS();
        searchDrawer();
        setViewVisiblity();
        toolbar = findViewById(R.id.toolbar);
        //initList();
        setRecyclerviewProduct();
        acTextView = (AutoCompleteTextView) findViewById(R.id.languages);
        pet_type = (AutoCompleteTextView) findViewById(R.id.pettypedrp);
        breed_type = (AutoCompleteTextView) findViewById(R.id.breeddrp);
        gender_typea = (AutoCompleteTextView) findViewById(R.id.gendrdrp);
        acTextView.setCursorVisible(true);
        pdnitm = (ImageView) findViewById(R.id.pdnitm);
        pdnitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acTextView.moveCursorToVisibleOffset();
            }
        });
        toolbar.setTitle("Mating");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final ArrayAdapter<String> loadTypeArrayAdapter = new ArrayAdapter<>(Mating.this, R.layout.custom_spinner_item, locationTypeList);
        loadTypeArrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        acTextView.setThreshold(1);
        acTextView.setAdapter(loadTypeArrayAdapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final MatingSingleAdapter matingSingleAdapter = new MatingSingleAdapter(Mating.this, tripSingaltonss);
//
        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(Mating.this, R.layout.custom_spinner_item, Pettypelist);
        loadTypeArrayAdapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        pet_type.setThreshold(1);
        pet_type.setAdapter(loadTypeArrayAdapter1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final MatingSingleAdapter matingSingleAdapter1 = new MatingSingleAdapter(Mating.this, tripSingaltonss);


//

        final ArrayAdapter<String> loadTypeArrayAdapter2 = new ArrayAdapter<>(Mating.this, R.layout.custom_spinner_item, breedtypelist);
        loadTypeArrayAdapter2.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        breed_type.setThreshold(1);
        breed_type.setAdapter(loadTypeArrayAdapter2);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final MatingSingleAdapter matingSingleAdapter2 = new MatingSingleAdapter(Mating.this, tripSingaltonss);

        breed_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selection = (String) parent.getItemAtPosition(i);
                MatingsearchRequest matingsearchRequest = new MatingsearchRequest();
                matingsearchRequest.setB_Id(Integer.parseInt(String.valueOf(i)));
                postn = i;
            }
        });
//
        final ArrayAdapter<String> loadTypeArrayAdapter3 = new ArrayAdapter<>(Mating.this, R.layout.custom_spinner_item, gendertypelist);
        loadTypeArrayAdapter3.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        gender_typea.setThreshold(1);
        gender_typea.setAdapter(loadTypeArrayAdapter3);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        final MatingSingleAdapter matingSingleAdapter3 = new MatingSingleAdapter(Mating.this, tripSingaltonss);

//
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

                    matingSingleAdapter.filter(acTextView.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    matingSingleAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(matingSingleAdapter);
                } catch (Exception e) {
                    acTextView.getText().clear();
                    acTextView.setText("");

                }


            }
        });

        pet_type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    matingSingleAdapter.filter(pet_type.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    matingSingleAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(matingSingleAdapter);
                } catch (Exception e) {
                    pet_type.getText().clear();
                    pet_type.setText("");

                }


            }
        });
        breed_type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    matingSingleAdapter.filter(breed_type.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    matingSingleAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(matingSingleAdapter);
                } catch (Exception e) {
                    breed_type.getText().clear();
                    breed_type.setText("");

                }


            }
        });
        gender_typea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    matingSingleAdapter.filter(gender_typea.getText().toString().toLowerCase(Locale.getDefault()));
                    adapter.notifyDataSetChanged();
                    matingSingleAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(matingSingleAdapter);
                } catch (Exception e) {
                    gender_typea.getText().clear();
                    gender_typea.setText("");

                }


            }
        });

        searchdoct = (Button) findViewById(R.id.seachbtn);
        searchdoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MatingsearchRequest matingsearchRequest = new MatingsearchRequest();
                String id = String.valueOf(postn);
                String actxtvw = acTextView.getText().toString().trim();
                String pettype = pet_type.getText().toString().trim();
                //String breedtype = breed_type.getText().toString().trim();
                String gendr = gender_typea.getText().toString().trim();

                Searchmatingdata(id, actxtvw, pettype, gendr);
                acTextView.setAdapter(loadTypeArrayAdapter);
                gender_typea.setAdapter(loadTypeArrayAdapter3);
                breed_type.setAdapter(loadTypeArrayAdapter2);
                pet_type.setAdapter(loadTypeArrayAdapter1);
                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY", -seachlayout.getHeight());
                animation.setDuration(800);
                animation.start();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

//                ArrayList<TripSingalton> newList = new ArrayList<>();
//                tripSingaltonss.addAll(Mating.filterItem);

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
        pet_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pet_type.getText().clear();
            }
        });
        breed_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breed_type.getText().clear();
            }
        });
        gender_typea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender_typea.getText().clear();
            }
        });

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void setRecyclerviewProduct() {
        //   recyclerView
        MatingSingleAdapter matingSingleAdapter = new MatingSingleAdapter(this, tripSingaltonss);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(matingSingleAdapter);


    }

    private void checkAcceptTrip() {
        tripSingaltonss = new ArrayList<>();
        pDialog = new ProgressDialog(Mating.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<MatingResponse> matingResponseCall = Utilss.getWebService().MATING_RESPONSE_CALL();
        matingResponseCall.enqueue(new Callback<MatingResponse>() {
            @Override
            public void onResponse(Call<MatingResponse> call, Response<MatingResponse> response) {

                if (response.code() == 200) {
                    pDialog.hide();
                    MatingResponse matingResponse = response.body();
                    Log.e("Vetlist", new GsonBuilder().create().toJson(response));
                    // initList();
                    for (int i = 0; i < matingResponse.getResponse().size(); i++) {
                        MatingSingalton matingSingalton = new MatingSingalton();
                        matingSingalton.setPettype(matingResponse.getResponse().get(i).getPettype());
                        matingSingalton.setPetName(matingResponse.getResponse().get(i).getPetName());
                        matingSingalton.setBreedName(matingResponse.getResponse().get(i).getBreedName());
                        matingSingalton.setGender(matingResponse.getResponse().get(i).getGender());
                        matingSingalton.setSR_Id(matingResponse.getResponse().get(i).getSR_Id());
                        matingSingalton.setAge(matingResponse.getResponse().get(i).getAge());
                        matingSingalton.setB_Id(Integer.parseInt(String.valueOf(matingResponse.getResponse().get(i).getB_Id())));
                        matingSingalton.setLocation(matingResponse.getResponse().get(i).getLocation());
                        matingSingalton.setStatus(matingResponse.getResponse().get(i).getStatus());
                        matingSingalton.setImage(matingResponse.getResponse().get(i).getImage());
                        tripSingaltonss.add(matingSingalton);
                        locationTypeList.add(matingResponse.getResponse().get(i).getLocation());
                        Pettypelist.add(matingResponse.getResponse().get(i).getPettype());
                        breedtypelist.add(matingResponse.getResponse().get(i).getBreedName());
                        gendertypelist.add(matingResponse.getResponse().get(i).getGender());
                        MatingSingleAdapter matingSingleAdapter = new MatingSingleAdapter(Mating.this, tripSingaltonss);
                        matingSingleAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(Mating.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(matingSingleAdapter);
                        matingSingleAdapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MatingResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                pDialog.hide();

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
        recyclerView = findViewById(R.id.recylcerview_products);


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
            //  adapter = new PetOldageListAdapter(this);
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

    private void Searchmatingdata(String actxtvw, String pettype, String breedtype, String gendr) {
        tripSingaltonss = new ArrayList<>();
        pDialog = new ProgressDialog(Mating.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        Call<MatingsearchResponse> matingsearchResponseCall = Utilss.getWebService().MATINGSEARCH_RESPONSE_CALL(actxtvw, pettype, breedtype, gendr);
        matingsearchResponseCall.enqueue(new Callback<MatingsearchResponse>() {
            @Override
            public void onResponse(Call<MatingsearchResponse> call, Response<MatingsearchResponse> response) {
                if (response.code() == 200) {
                    tripSingaltonss.clear();
                    tripSingaltonsas.clear();
                    pDialog.hide();
                    MatingsearchResponse matingsearchResponse = response.body();
                    Log.e("Vetlist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < matingsearchResponse.getResponse().size(); i++) {
                        MatingsearchRequest matingsearchRequest = new MatingsearchRequest();
                        matingsearchRequest.setPettype(matingsearchResponse.getResponse().get(i).getPettype());
                        matingsearchRequest.setBreedName(matingsearchResponse.getResponse().get(i).getBreedName());
                        matingsearchRequest.setB_Id(matingsearchResponse.getResponse().get(i).getB_Id());
                        matingsearchRequest.setGender(matingsearchResponse.getResponse().get(i).getGender());
                        matingsearchRequest.setAge(matingsearchResponse.getResponse().get(i).getAge());
                        matingsearchRequest.setLocation(matingsearchResponse.getResponse().get(i).getLocation());
                        matingsearchRequest.setStatus(matingsearchResponse.getResponse().get(i).getStatus());
                        tripSingaltonsas.add(matingsearchRequest);
                        tripSingaltonss.clear();
                        MatingSearchAdapter matingSearchAdapter = new MatingSearchAdapter(Mating.this, tripSingaltonsas);
                        matingSearchAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(Mating.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(matingSearchAdapter);
                        matingSearchAdapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();


                        // initList();
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                } else pDialog.hide();
            }

            @Override
            public void onFailure(Call<MatingsearchResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                pDialog.hide();

            }


        });

    }


}
