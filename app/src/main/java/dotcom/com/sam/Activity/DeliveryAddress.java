package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.AddnewAddressResponse;
import dotcom.com.sam.Response.AddressResponse;
import dotcom.com.sam.SingaltonsClasses.AddressSingalton;
import dotcom.com.sam.SingaltonsClasses.PlaceOrderService;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.AddnewaddressRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryAddress extends AppCompatActivity {
    private static final String TAG = DeliveryAddress.class.getSimpleName();
    RecyclerView recyclerView;
    Button newAddress, savendeliver, cancel;
    TextView address, phoneno;
    Toolbar toolbar;
    LinearLayout newadd;
    EditText fullname, contct, newaddress;
    RadioGroup visitGrp;
    RadioButton newaddressradio, existingadd;
    private ProgressDialog pDialog;
    PlaceOrderService placeOrderService;
    private String visitype = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);
        newAddress = (Button) findViewById(R.id.finalsummary);
        savendeliver = (Button) findViewById(R.id.saveanddeliver);
        cancel = (Button) findViewById(R.id.cancel);
        fullname = (EditText) findViewById(R.id.full_name);
        contct = (EditText) findViewById(R.id.contact_no);
        newaddress = (EditText) findViewById(R.id.addnewaddress);

        address = (TextView) findViewById(R.id.deliveryaddress);
        phoneno = (TextView) findViewById(R.id.deliverycontctno);
        newaddressradio = (RadioButton) findViewById(R.id.newaddressradio);
        existingadd = (RadioButton) findViewById(R.id.existingaddradio);

        newadd = (LinearLayout) findViewById(R.id.newaddlayout);
        visitGrp = (RadioGroup) findViewById(R.id.gender_grp);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setTitle("Delivery Address");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        visitGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();

                if (isChecked) {
                    int radioButtonID = group.getCheckedRadioButtonId();
                    View radioButton = group.findViewById(radioButtonID);
                    int position = group.indexOfChild(radioButton);
                    if (position == 0) {
                        SingletonClass.getInstance().setNewadd(false);
                        visitype = String.valueOf(checkedRadioButton.getText());
                        newadd.setVisibility(View.GONE);
                        newAddress.setVisibility(View.VISIBLE);
                    } else if (position == 2) {
                        SingletonClass.getInstance().setNewadd(true);
                        newAddress.setVisibility(View.GONE);
                        visitype = String.valueOf(checkedRadioButton.getText());
                        newadd.setVisibility(View.VISIBLE);
                    }
                    Log.e(" Gender Group ", "onCheckedChanged: " + checkedRadioButton.getText());
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullname.getText().clear();
                contct.getText().clear();
                newaddress.getText().clear();
                existingadd.setChecked(true);
                newaddressradio.setChecked(false);
                newadd.setVisibility(View.GONE);
                newAddress.setVisibility(View.VISIBLE);
            }
        });
        //call service here for news details
        placeOrderService = PlaceOrderService.getInstance();
        // getAddressList();
        Log.e(TAG, "order list : " + new GsonBuilder().create().toJson(placeOrderService));

        newAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryAddress.this, PaymentPage.class);
                startActivity(intent);
            }
        });
        savendeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newname = fullname.getText().toString().trim();
                String cont = contct.getText().toString().trim();
                String nwadd = newaddress.getText().toString().trim();
                if (validate()) {
                    Addnewaddress(newname, cont, nwadd);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        getAddressList();
    }

    private void getAddressList() {
        pDialog = new ProgressDialog(DeliveryAddress.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
        pDialog.show();
        pDialog.setContentView( R.layout.progress_bar );
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(DeliveryAddress.this);
        String value = sharedPreferences.getString("KEY", "");
        Call<AddressResponse> getAddressResponseCall = Utilss.getWebService().ADDRESS_RESPONSE_CALL(Integer.valueOf(value));
        Log.e(TAG, "getAddressList: " + getAddressResponseCall.request().url().toString());
        getAddressResponseCall.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                AddressResponse getAddressResponse = response.body();
                Log.e(TAG, "getAddressList: " + new GsonBuilder().create().toJson(getAddressResponse));
                if (response.code() == 200) {
                    existingadd.setText(getAddressResponse.getFullName());
                    address.setText(getAddressResponse.getAddress());
                    phoneno.setText(getAddressResponse.getMobNo());
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }

    private void Addnewaddress(String newname, String cont, String nwadd) {
        pDialog = new ProgressDialog(DeliveryAddress.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        AddnewaddressRequest addnewaddressRequest = new AddnewaddressRequest();
        addnewaddressRequest.setShipName(newname);
        addnewaddressRequest.setShipContactNo(cont);
        addnewaddressRequest.setShippingAddress(nwadd);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(DeliveryAddress.this);
        String value = sharedPreferences.getString("KEY", "");
        addnewaddressRequest.setRJ_ID(Integer.parseInt(value));
        Call<AddnewAddressResponse> addnewAddressResponseCall = Utilss.getWebService().ADDNEW_ADDRESS_RESPONSE_CALL(addnewaddressRequest);
        Log.e(TAG, "getAddressList: " + addnewAddressResponseCall.request().url().toString());
        addnewAddressResponseCall.enqueue(new Callback<AddnewAddressResponse>() {
            @Override
            public void onResponse(Call<AddnewAddressResponse> call, Response<AddnewAddressResponse> response) {
                AddnewAddressResponse addnewAddressResponse = response.body();
                Log.e(TAG, "getAddressList: " + new GsonBuilder().create().toJson(addnewAddressResponse));
                if (response.code() == 200) {
                    Utils.moveNextWithAnimation(DeliveryAddress.this, PaymentPage.class);
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<AddnewAddressResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }

    private boolean validate() {


        if (fullname.getText().toString().equals("")) {
            Toast.makeText(DeliveryAddress.this, "Please Enter User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (newaddress.getText().toString().equals("")) {
            Toast.makeText(DeliveryAddress.this, "Please enter delivery address.", Toast.LENGTH_LONG).show();
            return false;
        } else if (newaddress.getText().length() < 12) {
            Toast.makeText(DeliveryAddress.this, "Please Enter a Valid Address", Toast.LENGTH_LONG).show();
            return false;
        }
        if (contct.getText().toString().equals("")) {
            Toast.makeText(DeliveryAddress.this, "Please Enter Contact no.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
