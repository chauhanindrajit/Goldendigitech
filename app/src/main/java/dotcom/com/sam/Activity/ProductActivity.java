package dotcom.com.sam.Activity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dotcom.com.sam.Adapters.ProductPagerAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.PSingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.SingaltonsClasses.SubcategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Converter;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.Activity.AddorRemoveCallbacks;
import dotcom.com.sam.fragments.ProductMainFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AddorRemoveCallbacks {
    public static FragmentManager fragmentManager;
    ViewPager mViewPager;
    Toolbar toolbar;
    ActionBar actionBar;
    ImageView addtocart;
    TabLayout tabLayout;
    private ArrayList<ProductResponse.ResponseBean> arrSubCateogry;
    List<RegistrationResponse.ResponseBean> count = new ArrayList<>();
    ArrayList<List<ProductResponse.ResponseBean>> stringList = new ArrayList<List<ProductResponse.ResponseBean>>();
    private ProgressDialog pDialog;
    Integer ID, IDS;
    String sum;
    public static TextView nodat, conting;
    int subcatid;
    Menu customMenu;
    ArrayList tripSingaltonss;
    private static int cart_count = 10;
    FloatingActionButton fab;
    public static int notificationCountCart = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Utils.setExplodTransition(this);
        initView();
        arrSubCateogry = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        addtocart = (ImageView) findViewById(R.id.addtocard);
        conting = (TextView) findViewById(R.id.count);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductActivity.this, ReviewOrderActivity.class);
                startActivity(i);
            }
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ProductActivity.this);
        String value = sharedPreferences.getString("COU", "");
        if (value.equals("") || value.isEmpty() || value.equals("0")) {
            // not having user id
            conting.setVisibility(View.INVISIBLE);

            // Utils.customMessage(ProductActivity.this, "NO CART DATA FOUND");
        } else {
            conting.setVisibility(View.VISIBLE);
            conting.setText(String.valueOf(value));
            // user id is available
        }
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        actionBar = getSupportActionBar();
        fragmentManager = getSupportFragmentManager();
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        nodat = (TextView) findViewById(R.id.nodata);
        subcatid = SubcategorySingalton.getInstance().getSc_Id();
        if (CategorySingalton.getInstance().getCat() != null) {
            IDS = CategorySingalton.getInstance().getCateID();
            subcatid = 0;
            checkAcceptTrip(IDS, subcatid);
            toolbar.setTitle(CategorySingalton.getInstance().getCategosryName());

            ;
        } else {
            ID = CategorySingalton.getInstance().getSubcateID();
            subcatid = SubcategorySingalton.getInstance().getSc_Id();
            checkAcceptTrip(ID, subcatid);
            toolbar.setTitle(CategorySingalton.getInstance().getCategosryName());
        }
        sum = SubcategorySingalton.getInstance().getSubCategoryName();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_add_shopping_cart_black_24dp);
        // actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_cart);
        menuItem.setIcon(Converter.convertLayoutToImage(ProductActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();


    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();


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

    private void checkAcceptTrip(Integer ID, final int subcatid) {
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
                pDialog.dismiss();
                if (stringList.size() > 0) {
                    stringList.clear();
                }
                if (response.code() == 200) {


                    ProductResponse productResponse = response.body();
                    // checkAcceptTrip1();

                    Log.e("Proct", new GsonBuilder().create().toJson(response));

                    for (int i = 0; i < productResponse.getResponse().size(); i++) {

                        ProductSingalton productSingalton = new ProductSingalton();
                        PSingalton pSingalton = new PSingalton();
                        for (int j = 0; j < productResponse.getResponse().get(i).getProdList().size(); j++) {
                            Bundle bundle = new Bundle(); //I guess you're missing this
                            bundle.putInt("category", SubcategorySingalton.getInstance().getSc_Id());
                            productSingalton.setProductName(productResponse.getResponse().get(i).getProdList().get(j).getProductName());
                            productSingalton.setDiscount(productResponse.getResponse().get(i).getProdList().get(j).getDiscount());
                            productSingalton.setPrice(productResponse.getResponse().get(i).getProdList().get(j).getPrice());
                            productSingalton.setDiscountPrice(productResponse.getResponse().get(i).getProdList().get(j).getDiscountPrice());
                            productSingalton.setCategosryName(productResponse.getResponse().get(i).getProdList().get(j).getCategosryName());
                            productSingalton.setSubCategoryName(productResponse.getResponse().get(i).getProdList().get(j).getSubCategoryName());
                            productSingalton.setImage(productResponse.getResponse().get(i).getProdList().get(j).getImage());
                            tripSingaltonss.add(productSingalton);
                        }
                        // tripSingaltonss.add(productSingalton);
                        stringList.add(productResponse.getResponse());
                        productSingalton.setSc_Id(tabLayout.getSelectedTabPosition());
                        ProductPagerAdapter productPagerAdapter = new ProductPagerAdapter(fragmentManager, stringList, (productResponse.getResponse()));
                        mViewPager.setAdapter(productPagerAdapter);
                        productPagerAdapter.notifyDataSetChanged();
//                        if(productResponse.getResponse().size()>0){
//                            nodat.setVisibility(View.INVISIBLE);
//                        }
//                        else {
//                            nodat.setVisibility(View.VISIBLE);
//                        }
                        tabLayout.addTab(tabLayout.newTab().setText(productResponse.getResponse().get(i).getSubCategoryName()));
                        tabLayout.getTabCount();
                        if (productResponse.getResponse().get(i).getSc_Id() == subcatid) {

                            tabLayout.setScrollPosition(i, 0f, true);
                            mViewPager.setCurrentItem(i);
                            mViewPager.getCurrentItem();
                            mViewPager.setOffscreenPageLimit(3);
                            TabListener();
                            final int finalI = i;
                            mViewPager.post(new Runnable() {
                                @Override
                                public void run() {
                                    mViewPager.setCurrentItem(finalI);
                                    TabListener();
                                }
                            });
                        }
                        TabListener();
                    }

                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                pDialog.dismiss();
                Log.e("Failed", "onFailure: " + t);
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void TabListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // mViewPager.setPage(tab.getPosition());
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
            public void onPageSelected(final int position) {
                tabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                tabLayout.getTabAt(state);


            }

        });


    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        final int pos = 3;
//        mViewPager.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                mViewPager.setCurrentItem(subcatid-1);
//            }
//        }, 100);
//    }

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
                pDialog.dismiss();
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            this.finish();
        }
    }

}
