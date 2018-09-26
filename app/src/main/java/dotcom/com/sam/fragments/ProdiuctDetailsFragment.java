package dotcom.com.sam.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dotcom.com.sam.Activity.AddorRemoveCallbacks;
import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.Activity.NotificationCountSetClass;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.Activity.ReviewOrderActivity;
import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ManageCartResponse;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.SingaltonsClasses.BuypetprofileSingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSinglton;
import dotcom.com.sam.SingaltonsClasses.Products;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.ESPreferences;
import dotcom.com.sam.Utils.ImageUrlUtils;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ManageCartRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static dotcom.com.sam.Utils.Constants.CART_COUNT;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProdiuctDetailsFragment extends Fragment {
    TextView prodctname, actualprce, discountprice, addedCart;
    ImageView image, favimage;
    Button btnaddtocart, buynow ,btn_checkout;
    Context context;
    CardView radiocard;
    int count = 1;
    RadioGroup quantygrp;
    LinearLayout checkoutlayout,buynowlayout;
    int prtID;
    int postnid;
    private String qunatype = "";
    CountInterface countInterface;
    private ProgressDialog pDialog;
    Toolbar toolbar;

    public interface CountInterface {

        void cartCount(int count);
    }

    int imagePosition;
    String stringImageUri;

    public ProdiuctDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prodiuct_details, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prodctname = (TextView) getView().findViewById(R.id.profilepructname);
        addedCart = (TextView) getView().findViewById(R.id.already_added);
        actualprce = (TextView) getView().findViewById(R.id.actualprice);
        discountprice = (TextView) getView().findViewById(R.id.discountprice);
        quantygrp = (RadioGroup) getView().findViewById(R.id.gender_grp);
        checkoutlayout=(LinearLayout)getView().findViewById(R.id.checkoutlayout);
        buynowlayout=(LinearLayout)getView().findViewById(R.id.buynowlayout);
        image = (ImageView) getView().findViewById(R.id.productimage);
        radiocard=(CardView)getView().findViewById(R.id.radiopack);
        favimage = (ImageView) getView().findViewById(R.id.favimage);
        btnaddtocart = (Button) getView().findViewById(R.id.addtocart);
        btn_checkout = (Button) getView().findViewById(R.id.btn_checkout);
        buynow = (Button) getView().findViewById(R.id.buynow);
        prodctname.setText(ProductSingalton.getInstance().getProductName());
        actualprce.setText(String.valueOf(ProductSingalton.getInstance().getPrice()));
        actualprce.setPaintFlags(actualprce.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discountprice.setText(ProductSingalton.getInstance().getDiscountPrice());
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        prtID = ProductSingalton.getInstance().getPT_Id();
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(getContext(),ReviewOrderActivity.class);
            }
        });

        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    ManageCartRequest manageCartRequest = new ManageCartRequest();
                    manageCartRequest.setPT_Id(prtID);

                    if (qunatype != null) {
                        manageCartRequest.setQTY(Integer.parseInt(qunatype));
                    } else {
                        manageCartRequest.setQTY(1);
                    }

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String value = sharedPreferences.getString("KEY", "");
                    if (value.equals("")) {
                        // not having user id
                        Utils.customMessage(getContext(), "SORRY USER ID NOT FOUND");
                    } else {
                        manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                        // user id is available
                    }
                    pDialog = new ProgressDialog(getContext());
                    pDialog.setMessage("Please wait...");
                    pDialog.setCancelable(false);
                    pDialog.show();
                    Call<ManageCartResponse> manageCartResponseCall = Utilss.getWebService().manageCart(manageCartRequest);
                    Log.e("Add into cart ", ": :" + new GsonBuilder().create().toJson(manageCartRequest));
                    Log.e("URL", "checkAcceptTrip: " + manageCartResponseCall.request().url().toString());
                    manageCartResponseCall.enqueue(new Callback<ManageCartResponse>() {
                        @Override
                        public void onResponse(Call<ManageCartResponse> call, Response<ManageCartResponse> response) {
                            Log.e(TAG, "onResponse code: " + response.code());
                            if (response.code() == 200) {
                                ManageCartResponse manageCartResponse = response.body();

                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("COU", manageCartResponse.getMessege());
                                editor.apply();
                                if (SingletonClass.getInstance().getActivityname().equals("New Arrivals")) {
                                    try {
                                        ProductActivity.conting.setVisibility(View.VISIBLE);
                                        ProductDatailAcitvity.conting.setVisibility(View.VISIBLE);
                                        ProductActivity.conting.setText(manageCartResponse.getMessege());
                                        ProductDatailAcitvity.conting.setText(manageCartResponse.getMessege());
                                    } catch (Exception e) {

                                    }
                                }
                                try {
                                    ProductActivity.conting.setVisibility(View.VISIBLE);
                                    ProductDatailAcitvity.conting.setVisibility(View.VISIBLE);
                                    ProductActivity.conting.setText(manageCartResponse.getMessege());
                                    ProductDatailAcitvity.conting.setText(manageCartResponse.getMessege());
                                } catch (Exception e) {

                                }

//                                btnaddtocart.setVisibility(View.GONE);
//                                addedCart.setVisibility(View.VISIBLE);

                                // ProductSinglton.getInstance().getProductListFinal().get(prtID).setIsIncart(true);
                                //  ProductSinglton.getInstance().getProductListResponse().getResponse().get(position).setIsIncart(true);
                                SingletonClass.getInstance().productid().add(prtID);
                                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                                imageUrlUtils.productname(ProductSingalton.getInstance().getProductName());
                                Utils.moveNextWithAnimation(getContext(),ReviewOrderActivity.class);
                               // Toast.makeText(getContext(), "Item added to cart.", Toast.LENGTH_SHORT).show();
                                ProductActivity.notificationCountCart++;
                                NotificationCountSetClass.setNotifyCount(ProductActivity.notificationCountCart);
                                pDialog.dismiss();

                            } else if (response.code() == 400) {
                                pDialog.dismiss();
                                Utils.customMessage(getContext(), "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                            } else {
                                pDialog.dismiss();
                                // btnaddtocart.setVisibility(View.GONE);
                                //  addedCart.setVisibility(View.VISIBLE);
                                Utils.customMessage(getContext(), "Something went wrong.");
                            }


                        }

                        @Override
                        public void onFailure(Call<ManageCartResponse> call, Throwable t) {
                            pDialog.dismiss();
                        }
                    });

                }
            }
        });
//        if(SingletonClass.getInstance().productid().get(0).equals(prtID))
//        {
//            Utils.customMessage(getContext(),"already added");
//        }
        favimage.setImageResource(SingletonClass.getInstance().getFav());
        Addedornot();
        favimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
                    count = 2;
                    ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                    SingletonClass.getInstance().setFav(R.drawable.redfav);
                    ;
                    favimage.setImageResource(R.drawable.redfav);

                    Toast.makeText(getContext(), "Item added to wishlist.", Toast.LENGTH_SHORT).show();
                } else if (count != 1) {
                    count = 1;
                    ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                    SingletonClass.getInstance().setFav(R.mipmap.ic_heart_non_selected);
                    ;
                    favimage.setImageResource(R.mipmap.ic_heart_non_selected);
                    Toast.makeText(getContext(), "Item Removed from wishlist.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        quantygrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked) {
                    qunatype = String.valueOf(checkedRadioButton.getText());
                    Log.e(" Quantity Group ", "onCheckedChanged: " + checkedRadioButton.getText());
                }
            }
        });


        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ProductActivity.conting.setText(String.valueOf(count + 1));
                // ProductDatailAcitvity.conting.setText(String.valueOf(count + 1));
                if (validate()) {
                    ManageCartRequest manageCartRequest = new ManageCartRequest();
                    manageCartRequest.setPT_Id(prtID);

                    if (qunatype != null) {
                        manageCartRequest.setQTY(Integer.parseInt(qunatype));
                    } else {
                        manageCartRequest.setQTY(1);
                    }

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String value = sharedPreferences.getString("KEY", "");
                    if (value.equals("")) {
                        // not having user id
                        Utils.customMessage(getContext(), "SORRY USER ID NOT FOUND");
                    } else {
                        manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                        // user id is available
                    }
                    pDialog = new ProgressDialog(getContext());
                    pDialog.setMessage("Please wait...");
                    pDialog.setCancelable(false);
                    pDialog.show();
                    Call<ManageCartResponse> manageCartResponseCall = Utilss.getWebService().manageCart(manageCartRequest);
                    Log.e("Add into cart ", ": :" + new GsonBuilder().create().toJson(manageCartRequest));
                    Log.e("URL", "checkAcceptTrip: " + manageCartResponseCall.request().url().toString());
                    manageCartResponseCall.enqueue(new Callback<ManageCartResponse>() {
                        @Override
                        public void onResponse(Call<ManageCartResponse> call, Response<ManageCartResponse> response) {
                            Log.e(TAG, "onResponse code: " + response.code());
                            if (response.code() == 200) {
                                ManageCartResponse manageCartResponse = response.body();

                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("COU", manageCartResponse.getMessege());
                                editor.apply();
                                if (SingletonClass.getInstance().getActivityname().equals("New Arrivals")) {
                                    try {
                                        ProductActivity.conting.setVisibility(View.VISIBLE);
                                        ProductDatailAcitvity.conting.setVisibility(View.VISIBLE);
                                        ProductActivity.conting.setText(manageCartResponse.getMessege());
                                        ProductDatailAcitvity.conting.setText(manageCartResponse.getMessege());
                                    } catch (Exception e) {

                                    }
                                }
                                try {
                                    ProductActivity.conting.setVisibility(View.VISIBLE);
                                    ProductDatailAcitvity.conting.setVisibility(View.VISIBLE);
                                    ProductActivity.conting.setText(manageCartResponse.getMessege());
                                    ProductDatailAcitvity.conting.setText(manageCartResponse.getMessege());
                                } catch (Exception e) {

                                }

                                btnaddtocart.setVisibility(View.GONE);
                                addedCart.setVisibility(View.VISIBLE);
                                checkoutlayout.setVisibility(View.VISIBLE);
                                buynowlayout.setVisibility(View.GONE);
                                // ProductSinglton.getInstance().getProductListFinal().get(prtID).setIsIncart(true);
                                //  ProductSinglton.getInstance().getProductListResponse().getResponse().get(position).setIsIncart(true);
                                SingletonClass.getInstance().productid().add(prtID);
                                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                                imageUrlUtils.productname(ProductSingalton.getInstance().getProductName());
                                Toast.makeText(getContext(), "Item added to cart.", Toast.LENGTH_SHORT).show();
                                ProductActivity.notificationCountCart++;
                                NotificationCountSetClass.setNotifyCount(ProductActivity.notificationCountCart);
                                pDialog.dismiss();

                            } else if (response.code() == 400) {
                                pDialog.dismiss();
                                Utils.customMessage(getContext(), "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                            } else {
                                pDialog.dismiss();
                                // btnaddtocart.setVisibility(View.GONE);
                                //  addedCart.setVisibility(View.VISIBLE);
                                Utils.customMessage(getContext(), "Something went wrong.");
                            }


                        }

                        @Override
                        public void onFailure(Call<ManageCartResponse> call, Throwable t) {
                            pDialog.dismiss();
                        }
                    });

                }
            }
        });


        if (ProductSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/ProductImages/" + ProductSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(image);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(image);

        }
        // pos= SubcategorySingalton.getInstance().getSc_Id();
    }

    private boolean validate() {
        if (qunatype.equals("")) {
            Toast.makeText(getContext(), "Please select Quantity", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void Addedornot() {
        ManageCartRequest manageCartRequest = new ManageCartRequest();
        manageCartRequest.setPT_Id(prtID);

//        if (qunatype != null) {
//            manageCartRequest.setQTY(Integer.parseInt(qunatype));
//        } else {
//            manageCartRequest.setQTY(1);
//        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String value = sharedPreferences.getString("KEY", "");
        if (value.equals("")) {
            // not having user id
            Utils.customMessage(getContext(), "SORRY USER ID NOT FOUND");
        } else {
            manageCartRequest.setRJ_ID(Integer.parseInt((value)));
            // user id is available
        }
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        Call<ManageCartResponse> manageCartResponseCall = Utilss.getWebService().manageCart(manageCartRequest);
        Log.e("Add into cart ", ": :" + new GsonBuilder().create().toJson(manageCartRequest));
        Log.e("URL", "checkAcceptTrip: " + manageCartResponseCall.request().url().toString());
        manageCartResponseCall.enqueue(new Callback<ManageCartResponse>() {
            @Override
            public void onResponse(Call<ManageCartResponse> call, Response<ManageCartResponse> response) {
                Log.e(TAG, "onResponse code: " + response.code());
                if (response.code() == 200) {
                    ManageCartResponse manageCartResponse = response.body();
                    if (manageCartResponse.isSuccess() == false) {
                        btnaddtocart.setVisibility(View.GONE);
                        addedCart.setVisibility(View.VISIBLE);
                        checkoutlayout.setVisibility(View.VISIBLE);
                        buynowlayout.setVisibility(View.GONE);
                        radiocard.setVisibility(View.GONE);
                    }
                    pDialog.dismiss();

                } else if (response.code() == 400) {
                    pDialog.dismiss();
                    Utils.customMessage(getContext(), "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                } else {
                    pDialog.dismiss();
                    // btnaddtocart.setVisibility(View.GONE);
                    //  addedCart.setVisibility(View.VISIBLE);
                    Utils.customMessage(getContext(), "Something went wrong.");
                }


            }

            @Override
            public void onFailure(Call<ManageCartResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });


    }

}
