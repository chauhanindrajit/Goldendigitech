package dotcom.com.sam.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import dotcom.com.sam.Adapters.BuyPetAdapter;
import dotcom.com.sam.Adapters.ProductAdapter;
import dotcom.com.sam.R;
import android.app.ProgressDialog;
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
import dotcom.com.sam.Response.BuypetResponse;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.SingaltonsClasses.AdoptaPetSingalton;
import dotcom.com.sam.SingaltonsClasses.BuyPetSingalton;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.OldpetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class BuyPetList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList tripSingaltonss;
    private ProgressDialog pDialog;
    private ArrayList<BuyPetSingalton> arrSubCateogry;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_pet_list);
        recyclerView=(RecyclerView)findViewById(R.id.recylcerview_products);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Buy Pet");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        checkAcceptTrip();
        setRecyclerviewProduct();
    }


    private void setRecyclerviewProduct() {
        //   recyclerView
        BuyPetAdapter productAdapter = new BuyPetAdapter(this,arrSubCateogry);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);


    }
    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(BuyPetList.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<BuypetResponse> buypetResponseCall = Utilss.getWebService().BUYPET_RESPONSE_CALL();
        buypetResponseCall.enqueue(new Callback<BuypetResponse>() {
            @Override
            public void onResponse(Call<BuypetResponse> call, Response<BuypetResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    BuypetResponse buypetResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < buypetResponse.getResponse().size(); i++) {
                        BuyPetSingalton buyPetSingalton = new BuyPetSingalton();

                        buyPetSingalton.setPet_Name(buypetResponse.getResponse().get(i).getPet_Name());
                        buyPetSingalton.setAge(buypetResponse.getResponse().get(i).getAge());
                        buyPetSingalton.setBreedName(buypetResponse.getResponse().get(i).getBreedName());
                        buyPetSingalton.setGender(buypetResponse.getResponse().get(i).getGender());
                        buyPetSingalton.setOwnerName(buypetResponse.getResponse().get(i).getOwnerName());
                        buyPetSingalton.setOwnerAddress(buypetResponse.getResponse().get(i).getOwnerAddress());
                        buyPetSingalton.setOwnerContact(buypetResponse.getResponse().get(i).getOwnerContact());
                        buyPetSingalton.setImage(buypetResponse.getResponse().get(i).getImage());
                        buyPetSingalton.setOwnerEmail(buypetResponse.getResponse().get(i).getOwnerEmail());
                        buyPetSingalton.setStatus(buypetResponse.getResponse().get(i).getStatus());
                        buyPetSingalton.setCondition(buypetResponse.getResponse().get(i).getCondition());
                        buyPetSingalton.setLocation(buypetResponse.getResponse().get(i).getLocation());
                        //adoptaPetSingalton.setn(adoptpetResponse.getResponse().get(i).getPet_Name());
                        tripSingaltonss.add(buyPetSingalton);
                        BuyPetAdapter buyPetAdapter = new BuyPetAdapter(BuyPetList.this, tripSingaltonss);
                        buyPetAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(BuyPetList.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(buyPetAdapter);
                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BuypetResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }


        });

    }
}
