package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import dotcom.com.sam.Adapters.PaymentAdapter;
import dotcom.com.sam.Adapters.ReviewAdapter;
import dotcom.com.sam.Adapters.ReviewsAdapter;
import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.PaymentResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.PlaceOrderRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class PaymentPage extends AppCompatActivity {
    private RecyclerView reviewRecyclerView;
    private ProgressDialog pDialog;
    LinearLayout savepricelayout;
    TextView totalfinal, name, shippingadd,savedprice;
    ReviewAdapter.ManageInterface manageInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        totalfinal = (TextView) findViewById(R.id.totalfinal);
        name = (TextView) findViewById(R.id.name);
        shippingadd = (TextView) findViewById(R.id.shippingadd);
        savedprice = (TextView) findViewById(R.id.saveprice);
        savepricelayout = (LinearLayout) findViewById(R.id.savedpagelayout);
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
        Spannable text = new SpannableString("Payment");
        text.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        actionBar.setTitle(text);
        reviewRecyclerView = (RecyclerView) findViewById(R.id.review_recyler_view);
        reviewRecyclerView.setFocusable(false);

        LinearLayoutManager offerlinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        offerlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reviewRecyclerView.setLayoutManager(offerlinearLayoutManager);
        reviewRecyclerView.setItemAnimator(new DefaultItemAnimator());
        getCartList();
        totalfinal.setText("Total Amount :" + SingletonClass.getInstance().getFinalPrice());
    }

    private void getCartList() {
        pDialog = new ProgressDialog(PaymentPage.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(PaymentPage.this);
        String value = sharedPreferences.getString("KEY", "");
        Call<PaymentResponse> paymentResponseCall = Utilss.getWebService().PAYMENT_RESPONSE_CALL(Integer.valueOf((value)));
        Log.e("115 ", ": :" + paymentResponseCall.request().url().toString());
        paymentResponseCall.enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
                PaymentResponse paymentResponse = response.body();
                Log.e(TAG, "onResponse: " + new GsonBuilder().create().toJson(response.body()));
                Log.e(TAG, "onResponse code: " + response.code());
                if (response.code() == 200) {
                    if (SingletonClass.getInstance().isNewadd() == true) {
                        if (!(paymentResponse.getShipName().equals("") || paymentResponse.getShippingAddress().equals(""))) {
                            name.setText(String.valueOf(paymentResponse.getShipName()));
                            shippingadd.setText(String.valueOf(paymentResponse.getShippingAddress()));
                        }
                    } else if (SingletonClass.getInstance().isNewadd() == false) {
                        name.setText(paymentResponse.getFullName());
                        shippingadd.setText(paymentResponse.getAddress());
                    }
                    if(!SingletonClass.getInstance().getSavePrice().equals("0")){
                        savepricelayout.setVisibility(View.VISIBLE);
                        savedprice.setText(String.valueOf("₹" +SingletonClass.getInstance().getSavePrice()));
                    }
                    PaymentAdapter paymentAdapter = new PaymentAdapter(PaymentPage.this, paymentResponse.getDATALIST(), (PaymentAdapter.ManageInterface) manageInterface);
                    reviewRecyclerView.setAdapter(paymentAdapter);
                } else if (response.code() == 404) {
                    Utils.customMessage(PaymentPage.this, "sorry no data");
                    ReviewsAdapter reviewAdapter = new ReviewsAdapter(PaymentPage.this, manageInterface);
                    reviewRecyclerView.setAdapter(reviewAdapter);
                } else if (response.code() == 500) {
                    Utils.timeOutDialog(PaymentPage.this, true);
                } else {
                    Utils.customMessage(PaymentPage.this, "Something went wrong.");
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PaymentResponse> call, Throwable t) {
                pDialog.dismiss();
                Utils.customMessage(PaymentPage.this, "Something went wrong.");
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you don't want to order at this time ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      PaymentPage.this.finish();
                        /*    HomeActivity.this.finish();*/
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
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
    }
}
