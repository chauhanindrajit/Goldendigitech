package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.GsonBuilder;

import dotcom.com.sam.Adapters.ReviewAdapter;
import dotcom.com.sam.Adapters.ReviewsAdapter;
import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.BaseResponse;
import dotcom.com.sam.Response.DeleteallResponse;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.SingaltonsClasses.PlaceOrderService;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.ESPreferences;
import dotcom.com.sam.Utils.IOSProgress;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ManageCartRequest;
import dotcom.com.sam.request.PlaceOrderRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static dotcom.com.sam.Utils.Constants.CART_COUNT;


public class ReviewOrderActivity extends AppCompatActivity {

    private RecyclerView reviewRecyclerView;
    private Button checkout;
    TextView totalQtyPrice, totalprice;
    ImageView deleteCart;
    ReviewAdapter.ManageInterface manageInterface;
    PlaceOrderService placeOrderService;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Spannable text = new SpannableString("Review Order");
        text.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        actionBar.setTitle(text);
        checkout = (Button) findViewById(R.id.checkout);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        totalQtyPrice = (TextView) findViewById(R.id.t_qty_price);
        totalprice = (TextView) findViewById(R.id.totlprice);
        deleteCart = (ImageView) findViewById(R.id.delete_cart);
        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(ReviewOrderActivity.this, OrderSummaryActivity.class));
            }
        });
        placeOrderService = PlaceOrderService.getInstance();
        manageInterface = new ReviewAdapter.ManageInterface() {
            @Override
            public void manageCart(boolean b) {
                if (b) {
                    getCartList();
                }
            }
        };

        deleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ReviewOrderActivity.this);
                builder.setMessage("Are you sure to Remove all Items ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                pDialog = new ProgressDialog(ReviewOrderActivity.this);
                                pDialog.setMessage("Please wait...");
                                pDialog.setCancelable(false);
                                pDialog.show();
                                ManageCartRequest manageCartRequest = new ManageCartRequest();
                                manageCartRequest.setPT_Id(0);
                                manageCartRequest.setPrice(Integer.parseInt(String.valueOf(1)));
                                manageCartRequest.setQTY(1);
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReviewOrderActivity.this);
                                String value = sharedPreferences.getString("KEY", "");
                                if (value.equals("")) {
                                    // not having user id
                                    Utils.customMessage(ReviewOrderActivity.this, "SORRY USER ID NOT FOUND");
                                } else {
                                    manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                                    // user id is available
                                }
                                Call<DeleteallResponse> deleteallResponseCall = Utilss.getWebService().DELETEALL_RESPONSE_CALL(Integer.valueOf(value));
                                deleteallResponseCall.enqueue(new Callback<DeleteallResponse>() {
                                    @Override
                                    public void onResponse(Call<DeleteallResponse> call, Response<DeleteallResponse> response) {
                                        Log.e(TAG, "onResponse code: " + response.code());
                                        if (response.code() == 200) {
                                            //Utils.customMessage(mContext, "Added into cart");
                                            getCartList();
                                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReviewOrderActivity.this);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            String cont = String.valueOf("0");
                                            editor.putString("COU", cont);
                                            editor.apply();
                                            ProductActivity.conting.setText(cont);
                                            ProductDatailAcitvity.conting.setText(cont);
                                            pDialog.hide();
                                        } else if (response.code() == 500) {
                                            pDialog.hide();
                                            Utils.customMessage(ReviewOrderActivity.this, "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                                        } else {
                                            pDialog.hide();
                                            Utils.customMessage(ReviewOrderActivity.this, "Something went wrong.");
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<DeleteallResponse> call, Throwable t) {
                                        pDialog.hide();
                                    }
                                });
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                pbutton.setTextColor(Color.rgb(30, 144, 255));
                Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                nbutton.setTextColor(Color.rgb(30, 144, 255));
            }});
        reviewRecyclerView = (RecyclerView) findViewById(R.id.review_recyler_view);
        reviewRecyclerView.setFocusable(false);

        LinearLayoutManager offerlinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        offerlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reviewRecyclerView.setLayoutManager(offerlinearLayoutManager);
        reviewRecyclerView.setItemAnimator(new DefaultItemAnimator());

        getCartList();


    }

    private void getCartList() {
        pDialog = new ProgressDialog(ReviewOrderActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReviewOrderActivity.this);
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
                        pDialog.hide();
                        Double total = 0.0;
                        if (placeOrderService.getTbl_orders().size() > 0) {
                            placeOrderService.getTbl_orders().clear();
                        }

                        for (int i = 0; i < getCartResponse.getResponse().size(); i++) {
                            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
                            placeOrderRequest.setPT_Id(getCartResponse.getResponse().get(i).getPT_Id());
                            placeOrderRequest.setOrd_Id(getCartResponse.getResponse().get(i).getOrd_Id());
                            placeOrderRequest.setCRT_Id(getCartResponse.getResponse().get(i).getCRT_Id());
                            placeOrderRequest.setPrice(getCartResponse.getResponse().get(i).getPrice());
                            placeOrderRequest.setProductName(getCartResponse.getResponse().get(i).getProductName());
                            placeOrderRequest.setQTY(getCartResponse.getResponse().get(i).getQTY());
                            placeOrderRequest.setAmount(getCartResponse.getResponse().get(i).getAmount());
                            placeOrderRequest.setDiscount(getCartResponse.getResponse().get(i).getDiscount());
                            placeOrderRequest.setDiscountPrice(getCartResponse.getResponse().get(i).getDiscountPrice());
                            placeOrderRequest.setImage(getCartResponse.getResponse().get(i).getImage());
                            placeOrderRequest.setQTY(getCartResponse.getResponse().get(i).getQTY());

                            placeOrderService.addReport(placeOrderRequest);
                            total += Double.parseDouble(String.valueOf(getCartResponse.getResponse().get(i).getDiscountPrice())) * getCartResponse.getResponse().get(i).getQTY();
                        }

                        // ESPreferences.SSP().putLong(CART_COUNT, Long.valueOf(getCartResponse.getResponse().size()));
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReviewOrderActivity.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String cont = String.valueOf(getCartResponse.getResponse().size());
                        editor.putString("COU", cont);
                        editor.apply();
//                        ProductActivity.conting.setText(cont);
//                        ProductDatailAcitvity.conting.setText(cont);
                        totalQtyPrice.setText(getCartResponse.getResponse().size() + " Items - ₹" + total);
                        totalprice.setText("₹ " + total);
                        ReviewAdapter reviewAdapter = new ReviewAdapter(ReviewOrderActivity.this, getCartResponse.getResponse(), manageInterface);
                        reviewRecyclerView.setAdapter(reviewAdapter);
                    } else if (getCartResponse.getStatus() == 404) {
                        Utils.dataNotFound(ReviewOrderActivity.this, true);
                    }
                } else if (response.code() == 404) {
                    Utils.customMessage(ReviewOrderActivity.this, "sorry no data");
                    ReviewsAdapter reviewAdapter = new ReviewsAdapter(ReviewOrderActivity.this, manageInterface);
                    reviewRecyclerView.setAdapter(reviewAdapter);
                } else if (response.code() == 500) {
                    Utils.timeOutDialog(ReviewOrderActivity.this, true);
                } else {
                    Utils.customMessage(ReviewOrderActivity.this, "Something went wrong.");
                }
                pDialog.hide();
            }

            @Override
            public void onFailure(Call<GetCartResponse> call, Throwable t) {
                pDialog.hide();
                Utils.customMessage(ReviewOrderActivity.this, "Something went wrong.");
            }
        });
    }

    IOSProgress mProgressHUD;

    private void showProgressDialog() {
        mProgressHUD = IOSProgress.show(ReviewOrderActivity.this, "please wait...", true, false);
    }

    private void hideProgressDialog() {
        mProgressHUD.dismiss();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count <= 1) {
                    finish();
                } else {
                    getSupportFragmentManager().popBackStack();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
