package dotcom.com.sam.Activity;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dotcom.com.sam.Adapters.ProductPagerAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.SingaltonsClasses.SubcategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.fragments.ProductMainFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    ViewPager mViewPager;
    Toolbar toolbar;
    ActionBar actionBar;
    TabLayout tabLayout;
    private ArrayList<ProductResponse.ResponseBean> arrSubCateogry;
    List<RegistrationResponse.ResponseBean> count = new ArrayList<>();
    ArrayList<List<ProductResponse.ResponseBean>> stringList = new ArrayList<List<ProductResponse.ResponseBean>>();
    private ProgressDialog pDialog;
    Integer ID, IDS;
    String sum;
    private ArrayList<ProductSingalton> tripSingaltonss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Utils.setExplodTransition(this);
        initView();
        arrSubCateogry = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        initView();
        toolbar.setTitle("DOG");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        actionBar = getSupportActionBar();
        fragmentManager = getSupportFragmentManager();
        tripSingaltonss = new ArrayList<>();
        if (CategorySingalton.getInstance().getCat() != null) {
            IDS = CategorySingalton.getInstance().getCateID();
            checkAcceptTrip(IDS);
            ;
        } else {
            ID = CategorySingalton.getInstance().getSubcateID();

            checkAcceptTrip(ID);
        }
        sum= SubcategorySingalton.getInstance().getSubCategoryName();

        //addTab();
        //stringList.add(String.valueOf(CategorySingalton.getInstance().getCategosryName()));
       //tabLayout.addTab(tabLayout.newTab().setText(""));
       // tabLayout.getTabAt(Integer.parseInt(SubcategorySingalton.getInstance().getSubCategoryName()));

//        ProductPagerAdapter productPagerAdapter = new ProductPagerAdapter(fragmentManager, stringList);
//        mViewPager.setAdapter(productPagerAdapter);
//        productPagerAdapter.notifyDataSetChanged();
//        productPagerAdapter.getCount();

        TabListener();



    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);


    }

    private void addTab() {
        tabLayout.addTab(tabLayout.newTab().setText("FEED"));
        tabLayout.addTab(tabLayout.newTab().setText("APPAREL"));
        tabLayout.addTab(tabLayout.newTab().setText("SHOES"));
        tabLayout.addTab(tabLayout.newTab().setText("TOYS"));
        tabLayout.addTab(tabLayout.newTab().setText("KENNEL"));

    }

    private void checkAcceptTrip(Integer ID) {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(ProductActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<ProductResponse> productResponseCall = Utilss.getWebService().PRODUCT_RESPONSE_CALL(ID);
        Log.e("URL", "checkAcceptTrip: " + productResponseCall.request().url().toString());
        productResponseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    ProductResponse productResponse = response.body();
                    // checkAcceptTrip1();

                    Log.e("Proct", new GsonBuilder().create().toJson(response));

                    for (int i = 0; i < productResponse.getResponse().size(); i++) {
                        ProductSingalton productSingalton=new ProductSingalton();

                        for(int j = 0;j< productResponse.getResponse().get(i).getProdList().size();j++){

                            productSingalton.setProductName(productResponse.getResponse().get(i).getProdList().get(j).getProductName());
                            productSingalton.setDiscount(productResponse.getResponse().get(i).getProdList().get(j).getDiscount());
                            productSingalton.setPrice(productResponse.getResponse().get(i).getProdList().get(j).getPrice());
                            productSingalton.setDiscountPrice(productResponse.getResponse().get(i).getProdList().get(j).getDiscountPrice());
                            productSingalton.setCategosryName(productResponse.getResponse().get(i).getProdList().get(j).getCategosryName());
                            productSingalton.setSubCategoryName(productResponse.getResponse().get(i).getProdList().get(j).getSubCategoryName());
                            productSingalton.setImage(productResponse.getResponse().get(i).getProdList().get(j).getImage());
                            productSingalton.setC_Id(SubcategorySingalton.getInstance().getSc_Id());
                            tripSingaltonss.add(productSingalton);
                        }

                        stringList.add(productResponse.getResponse());
                        tabLayout.addTab(tabLayout.newTab().setText(productResponse.getResponse().get(i).getSubCategoryName()));
                        if(productResponse.getResponse().get(i).getSc_Id()==SubcategorySingalton.getInstance().getSc_Id()){
                            //tabLayout.getTabAt(3).getPosition();
                        }
                        ProductPagerAdapter productPagerAdapter = new ProductPagerAdapter(fragmentManager, stringList,tripSingaltonss);
                        mViewPager.setAdapter(productPagerAdapter);
                        productPagerAdapter.notifyDataSetChanged();
                    }

                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                pDialog.hide();
                Log.e("Failed", "onFailure: " + t);
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void TabListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // mViewPager.setPage tab.getPosition();
                mViewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public void addfragment() {
        fragmentManager.beginTransaction().add(R.id.main_conainer, new ProductMainFragment()).commit();
    }

    public void checkAcceptTrip1() {
        arrSubCateogry = new ArrayList<>();
        pDialog = new ProgressDialog(ProductActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<RegistrationResponse> registrationResponseCall = Utilss.getWebService().RESPONSE_CALL();
        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    RegistrationResponse registrationResponse = response.body();
                    Log.e("summmm", new GsonBuilder().create().toJson(response));
                    List<List<RegistrationResponse.ResponseBean>> dataList = Collections.singletonList(registrationResponse.getResponse());

                    for (int i = 0; i < registrationResponse.getResponse().size(); i++) {
                        // tabLayout.addTab(tabLayout.newTab().setText(registrationResponse.getResponse().get(i).getSubCategories().get(i).getSubCategoryName()));
                        // catregeoryAdapterr.getItemCount();

                    }
//                    ProductPagerAdapter productPagerAdapter = new ProductPagerAdapter(fragmentManager, registrationResponse.getResponse());
//                    mViewPager.setAdapter(productPagerAdapter);
//                    productPagerAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }


}
