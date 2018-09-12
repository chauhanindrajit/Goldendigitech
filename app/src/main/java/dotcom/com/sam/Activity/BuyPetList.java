package dotcom.com.sam.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import dotcom.com.sam.Adapters.BuyPetAdapter;
import dotcom.com.sam.Adapters.BuypetFilterAdapter;
import dotcom.com.sam.Adapters.FilterAdapter;
import dotcom.com.sam.Adapters.ProductAdapter;
import dotcom.com.sam.R;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Adapters.AdoptpetAdapter;
import dotcom.com.sam.Adapters.BuyPetAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.PetOldageListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.Response.BuypetResponse;
import dotcom.com.sam.Response.BuypetfilterResponse;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.AdoptaPetSingalton;
import dotcom.com.sam.SingaltonsClasses.BuyPetSingalton;
import dotcom.com.sam.extras.OnVerticalScrollListener;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.OldpetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class BuyPetList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList tripSingaltonss;
    CardView filterLaout;
    List<BuypetfilterResponse.ResponseBean> filterList;
    private ProgressDialog pDialog;
    private ArrayList<BuyPetSingalton> arrSubCateogry;
    Toolbar toolbar;

    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_pet_list);
        recyclerView=(RecyclerView)findViewById(R.id.recylcerview_products);
      //  filtrrecyview=(RecyclerView) findViewById(R.id.filtrrecyview);
        toolbar = findViewById(R.id.toolbar);
        filterLaout = (CardView)findViewById(R.id.footer_filter);
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
        //filterdata();
        setsummarydialog();

       // filterdata();
    }


    private void setRecyclerviewProduct() {
        //   recyclerView
        BuyPetAdapter productAdapter = new BuyPetAdapter(this,arrSubCateogry);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);


    }
    private void setsummarydialog() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view2 = inflater.inflate(R.layout.filter_dialog_layout, null);
        ImageView imageView = view2.findViewById(R.id.cancle_image);
        Button applyfilter = view2.findViewById(R.id.aplyfilter);
        final RecyclerView filtrrecyview = view2.findViewById(R.id.filtrrecyview);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view2);
        final AlertDialog dialog = builder.create();
        recyclerView.addOnScrollListener(new OnVerticalScrollListener(filterLaout));
        filterLaout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                pDialog = new ProgressDialog(BuyPetList.this);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();
                final Call<BuypetfilterResponse> buypetfilterResponseCall = Utilss.getWebService().BUYPETFILTER_RESPONSE_CALL();
                buypetfilterResponseCall.enqueue(new Callback<BuypetfilterResponse>() {
                    @Override
                    public void onResponse(Call<BuypetfilterResponse> call, Response<BuypetfilterResponse> response) {
                        pDialog.hide();
                        if (response.code() == 200) {
                            pDialog.hide();
                            BuypetfilterResponse buypetfilterResponse = response.body();
                            Log.e("dioglist", new GsonBuilder().create().toJson(response));
                            for (int i = 0; i < buypetfilterResponse.getResponse().size(); i++) {
                                mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                                filtrrecyview.setLayoutManager(mLayoutManager);
                                filtrrecyview.setAdapter(new BuypetFilterAdapter(BuyPetList.this, buypetfilterResponse.getResponse()));

                                //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BuypetfilterResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                        pDialog.hide();
                    }


                });



            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
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
                    pDialog.hide();
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
                        buyPetSingalton.setSR_Id(buypetResponse.getResponse().get(i).getSR_Id());
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
                pDialog.hide();
            }


        });

    }

    private void filterdata() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(BuyPetList.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<BuypetfilterResponse> buypetfilterResponseCall = Utilss.getWebService().BUYPETFILTER_RESPONSE_CALL();
        buypetfilterResponseCall.enqueue(new Callback<BuypetfilterResponse>() {
            @Override
            public void onResponse(Call<BuypetfilterResponse> call, Response<BuypetfilterResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    pDialog.hide();
                    BuypetfilterResponse buypetfilterResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < buypetfilterResponse.getResponse().size(); i++) {
                        pDialog.hide();

                        //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BuypetfilterResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
                pDialog.hide();
            }


        });

    }
}
