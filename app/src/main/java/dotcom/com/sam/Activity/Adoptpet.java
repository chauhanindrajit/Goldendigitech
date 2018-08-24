package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import dotcom.com.sam.Adapters.AdoptpetAdapter;
import dotcom.com.sam.Adapters.BuyPetAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.PetOldageListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.SingaltonsClasses.AdoptaPetSingalton;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.OldpetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adoptpet extends AppCompatActivity {
RecyclerView recyclerView;
    ArrayList tripSingaltonss;
    private ProgressDialog pDialog;
    private ArrayList<AdoptaPetSingalton> arrSubCateogry;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptpet);
        recyclerView=(RecyclerView)findViewById(R.id.recylcerview_products);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        checkAcceptTrip();
        setRecyclerviewProduct();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Adopt A Pet ");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private  void setRecyclerviewProduct()
    {
        //   recyclerView
        AdoptpetAdapter adoptpetAdapter=new AdoptpetAdapter(this,arrSubCateogry);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 1);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adoptpetAdapter);


    }
    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(Adoptpet.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<AdoptpetResponse> adoptpetResponseCall = Utilss.getWebService().ADOPTPET_RESPONSE_CALL();
        adoptpetResponseCall.enqueue(new Callback<AdoptpetResponse>() {
            @Override
            public void onResponse(Call<AdoptpetResponse> call, Response<AdoptpetResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    AdoptpetResponse adoptpetResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < adoptpetResponse.getResponse().size(); i++) {
                        AdoptaPetSingalton adoptaPetSingalton = new AdoptaPetSingalton();

                        adoptaPetSingalton.setPet_Name(adoptpetResponse.getResponse().get(i).getPet_Name());
                        adoptaPetSingalton.setAge(adoptpetResponse.getResponse().get(i).getAge());
                        adoptaPetSingalton.setBreedName(adoptpetResponse.getResponse().get(i).getBreedName());
                        adoptaPetSingalton.setGender(adoptpetResponse.getResponse().get(i).getGender());
                        adoptaPetSingalton.setOwnerName(adoptpetResponse.getResponse().get(i).getOwnerName());
                        adoptaPetSingalton.setOwnerAddress(adoptpetResponse.getResponse().get(i).getOwnerAddress());
                        adoptaPetSingalton.setOwnerContact(adoptpetResponse.getResponse().get(i).getOwnerContact());
                        adoptaPetSingalton.setImage(adoptpetResponse.getResponse().get(i).getImage());
                        adoptaPetSingalton.setOwnerEmail(adoptpetResponse.getResponse().get(i).getOwnerEmail());
                        adoptaPetSingalton.setStatus(adoptpetResponse.getResponse().get(i).getStatus());
                        adoptaPetSingalton.setCondition(adoptpetResponse.getResponse().get(i).getCondition());
                        adoptaPetSingalton.setLocation(adoptpetResponse.getResponse().get(i).getLocation());
                        //adoptaPetSingalton.setn(adoptpetResponse.getResponse().get(i).getPet_Name());
                        tripSingaltonss.add(adoptaPetSingalton);
                        AdoptpetAdapter adoptpetAdapter = new AdoptpetAdapter(Adoptpet.this, tripSingaltonss);
                        adoptpetAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(Adoptpet.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(adoptpetAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<AdoptpetResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }


        });

    }
}
