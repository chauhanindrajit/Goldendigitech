package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Adapters.CatregeoryAdapter;
import dotcom.com.sam.Adapters.ReviewAdapter;
import dotcom.com.sam.Adapters.ReviewsAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.SubcategoryResponse;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.SubcategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.SingaltonsClasses.TripSingalton;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.PlaceOrderRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class Categeory extends AppCompatActivity {
    RecyclerView categeoryLayout;
    ArrayList Adddata;
    ArrayList Suncatdddata;
    RecyclerView recyclerView;
    TextView SubCtegeryLayout;
    RegistrationResponse registrationResponse;
    ListView listView;
    ArrayList<String> stringList = new ArrayList<>();
    private ListView stationsListView;
    private String TAG = MainActivity.class.getSimpleName();
    private RecyclerView.Adapter mAdapter;
    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "http://worldindia.in/SamApi/api/SamVC/getShopByPetCategoryList";
    public static ArrayList<HashMap<String, String>> contactList;
    private ArrayList<RegistrationResponse.ResponseBean> arrSubCateogry;
    private ArrayList<String> arrSubCateogry1;
    List<RegistrationResponse.ResponseBean.SubCategoriesBean> arrTemp = new ArrayList<>();
    private ArrayAdapter<TripSingalton> stationListAdapter;
    TextView catname;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categeory);
        Utils.setExplodTransition(this);
        catname = (TextView) findViewById(R.id.categeoryName);

        toolbar = findViewById(R.id.toolbar);
        arrSubCateogry = new ArrayList<>();
        Adddata = new ArrayList<>();
        Suncatdddata = new ArrayList<>();
        contactList = new ArrayList<>();
        toolbar.setTitle("SAM");
     //   subcat();
        // subcat();
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (Utils.isOnline(Categeory.this)) {
            checkAcceptTrip();
            getCartList();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Categeory.this);
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
        intitView();
        setCategeoryLayout();

    }

    private void intitView() {
        categeoryLayout = (RecyclerView) findViewById(R.id.categeoryLayout);
    }

    void setCategeoryLayout() {
        CatregeoryAdapter catregeoryAdapterr = new CatregeoryAdapter(Categeory.this, arrSubCateogry,stringList);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);
        categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
        categeoryLayout.setAdapter(catregeoryAdapterr);
        catregeoryAdapterr.notifyDataSetChanged();


    }


    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();
        pDialog = new ProgressDialog(Categeory.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<RegistrationResponse> registrationResponseCall = Utilss.getWebService().RESPONSE_CALL();
        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    pDialog.dismiss();
                    RegistrationResponse registrationResponse = response.body();
                    Log.e("summmm", new GsonBuilder().create().toJson(response));
                    List<List<RegistrationResponse.ResponseBean>> dataList = Collections.singletonList(registrationResponse.getResponse());

                    for (int i = 0; i < registrationResponse.getResponse().size(); i++) {
                            List<RegistrationResponse.ResponseBean.SubCategoriesBean> arrTemp = new ArrayList<>(registrationResponse.getResponse().get(i).getSubCategories());
                            CategorySingalton categorySingalton = new CategorySingalton();

                            stringList.add(registrationResponse.getResponse().get(i).getSubCategories().get(i).getSubCategoryName());
                            CatregeoryAdapter catregeoryAdapterr = new CatregeoryAdapter(Categeory.this,registrationResponse.getResponse(),stringList);
                            LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);
                            categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
                            categeoryLayout.setAdapter(catregeoryAdapterr);
                            catregeoryAdapterr.notifyDataSetChanged();
//                        recyclerView.setAdapter(mAdapter);
                            // recyclerView.setAdapter(catregeoryAdapterr);
                            catregeoryAdapterr.notifyItemInserted(0);
                        // catregeoryAdapterr.getItemCount();

                    }

                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }


    private void subcat() {
        arrSubCateogry = new ArrayList<>();
        pDialog = new ProgressDialog(Categeory.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<SubcategoryResponse> subcategoryResponseCall = Utilss.getWebService().SUBCATEGORY_RESPONSE_CALL();
        subcategoryResponseCall.enqueue(new Callback<SubcategoryResponse>() {
            @Override
            public void onResponse(Call<SubcategoryResponse> call, Response<SubcategoryResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    SubcategoryResponse subcategoryResponse = response.body();
                    Log.e("subcccccc", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < subcategoryResponse.getResponse().size(); i++) {

                        SubcategorySingalton subcategorySingalton = new SubcategorySingalton();

                        subcategorySingalton.setSubCategoryName(subcategoryResponse.getResponse().get(i).getCategosryName());

                        pDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<SubcategoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Categeory.this,MainActivity.class);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }



    private void getCartList() {
    //    pDialog = new ProgressDialog(Categeory.this);
//        pDialog.setMessage("Please wait...");
//        pDialog.setCancelable(false);
//        pDialog.show();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Categeory.this);
        String value = sharedPreferences.getString("KEY", "");
        Call<GetCartResponse> getCartResponseCall = Utilss.getWebService().getAllCartList(Integer.valueOf((value)));
        Log.e("115 ", ": :" + getCartResponseCall.request().url().toString());
        getCartResponseCall.enqueue(new Callback<GetCartResponse>() {
            @Override
            public void onResponse(Call<GetCartResponse> call, Response<GetCartResponse> response) {
                GetCartResponse getCartResponse = response.body();
                Log.e(TAG, "onResponse: " + new GsonBuilder().create().toJson(response.body()));
                Log.e(TAG, "onResponse code: " + response.code());
                if (response.code() == 200) {
                    if (getCartResponse.getStatus() == 200) {
                       // pDialog.dismiss();
                        // ESPreferences.SSP().putLong(CART_COUNT, Long.valueOf(getCartResponse.getResponse().size()));
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Categeory.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String cont= String.valueOf(getCartResponse.getResponse().size());
                        editor.putString("COU",cont);
                        editor.apply();


                    } else if (getCartResponse.getStatus() == 404) {

                } else if (response.code() == 404) {

                } else if (response.code() == 500) {
                    Utils.timeOutDialog(Categeory.this, true);
                } else {
                    Utils.customMessage(Categeory.this, "Something went wrong.");
                }
                //pDialog.dismiss();
            }}

            @Override
            public void onFailure(Call<GetCartResponse> call, Throwable t) {
               // pDialog.dismiss();
                Utils.customMessage(Categeory.this, "Something went wrong.");
            }
        });
    }
}

