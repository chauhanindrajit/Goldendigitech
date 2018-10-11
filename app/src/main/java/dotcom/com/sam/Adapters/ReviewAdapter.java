package dotcom.com.sam.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.Activity.ReviewOrderActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.BaseResponse;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.IncrDecResponse;
import dotcom.com.sam.Response.ManageCartResponse;
import dotcom.com.sam.Response.RemovecartResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Constants;
import dotcom.com.sam.Utils.ESPreferences;
import dotcom.com.sam.Utils.IOSProgress;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ManageCartRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Dotcom on 1/30/2017.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    Context mContext;
    View convertView;
    private ProgressDialog pDialog;
    private List<GetCartResponse.ResponseBean> responseBeen;
    ManageInterface manageInterface;
    Double total = 0.0;
    Double saveprice = 0.0;

    public ReviewAdapter(Context context, List<GetCartResponse.ResponseBean> size, ManageInterface manageInterface) {
        this.responseBeen = size;
        this.mContext = context;
        this.manageInterface = manageInterface;
    }

    public ReviewAdapter(ReviewOrderActivity reviewOrderActivity, ManageInterface manageInterface) {
    }

    public interface ManageInterface {

        void manageCart(boolean b);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout listLayout, removelayout;
        TextView prName, prPrice, prQty, qty, discountprice, discount;
        ImageView groceryIv, incQty, decQty;

        private ViewHolder(View convertView) {
            super(convertView);
            prName = (TextView) convertView.findViewById(R.id.productname);
            prPrice = (TextView) convertView.findViewById(R.id.baseprice);
            discountprice = (TextView) convertView.findViewById(R.id.discountpricee);
            discount = (TextView) convertView.findViewById(R.id.discont);
            qty = (TextView) convertView.findViewById(R.id.qty);
            incQty = (ImageView) convertView.findViewById(R.id.inc_qty);
            decQty = (ImageView) convertView.findViewById(R.id.dec_qty);
            groceryIv = (ImageView) convertView.findViewById(R.id.image_cartlist);
            removelayout = (LinearLayout) convertView.findViewById(R.id.removelayout);
        }
    }

    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_adapter_item, parent, false);
        return new ReviewAdapter.ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(final ReviewAdapter.ViewHolder viewHolder, final int position) {

        if (responseBeen.get(position).getImage() != null) {
            Picasso.with(mContext).load("http://mrsam.in/sam/ProductImages/" + responseBeen.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(viewHolder.groceryIv);
        } else {
            Picasso.with(mContext).load(R.drawable.noimage).into(viewHolder.groceryIv);
        }

        viewHolder.prName.setText(responseBeen.get(position).getProductName());
        if (responseBeen.get(position).getQTY() == 0) {
            viewHolder.qty.setText("0");
        } else {
            viewHolder.qty.setText(String.valueOf(responseBeen.get(position).getQTY()));
        }
        viewHolder.prPrice.setPaintFlags(viewHolder.prPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        total += Double.parseDouble(String.valueOf(responseBeen.get(position).getDiscountPrice())) * responseBeen.get(position).getQTY();
        viewHolder.discountprice.setText(String.valueOf(responseBeen.get(position).getDiscountPrice() * responseBeen.get(position).getQTY()));
        viewHolder.discount.setText(String.valueOf("₹" + responseBeen.get(position).getDiscount() + " off"));
        viewHolder.qty.setText(String.valueOf(responseBeen.get(position).getQTY()));
        viewHolder.prPrice.setText(String.format("₹%s", Double.parseDouble(String.valueOf(responseBeen.get(position).getPrice())) * responseBeen.get(position).getQTY()));
        viewHolder.qty.setText(String.valueOf(responseBeen.get(position).getQTY()));
        saveprice += Double.parseDouble(String.valueOf(responseBeen.get(position).getPrice() * responseBeen.get(position).getQTY()));
        SingletonClass.getInstance().setSavePrice(String.valueOf(Double.parseDouble(String.valueOf(saveprice - total))));


        viewHolder.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog = new ProgressDialog(mContext);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();

                Log.e(TAG, "onClick: " + responseBeen.get(position).getPT_Id() + " " + responseBeen.get(position).getPrice() + " " + responseBeen.get(position).getOrd_Id());
                ManageCartRequest manageCartRequest = new ManageCartRequest();
                manageCartRequest.setPT_Id(responseBeen.get(position).getPT_Id());
                manageCartRequest.setQTY(Integer.parseInt(viewHolder.qty.getText().toString()) + 1);
                //manageCartRequest.setQTY(responseBeen.get(position).getStock_ID());
                String inc = "Add";
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                String value = sharedPreferences.getString("KEY", "");
                if (value.equals("")) {
                    // not having user id
                    Utils.customMessage(mContext, "SORRY USER ID NOT FOUND");
                } else {
                    manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                    // user id is available
                }

                Call<IncrDecResponse> incrDecResponseCall = Utilss.getWebService().INCR_DEC_RESPONSE_CALL(responseBeen.get(position).getCRT_Id(), Integer.valueOf(value), inc);
                Log.e("Add into cart ", ": :" + new GsonBuilder().create().toJson(manageCartRequest));
                incrDecResponseCall.enqueue(new Callback<IncrDecResponse>() {
                    @Override
                    public void onResponse(Call<IncrDecResponse> call, Response<IncrDecResponse> response) {
                        Log.e(TAG, "onResponse code: " + response.code());
                        if (response.code() == 200) {
                            manageInterface.manageCart(true);
                            pDialog.dismiss();
                        } else if (response.code() == 503) {
                            pDialog.dismiss();
                            Utils.customMessage(mContext, "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                        } else {
                            pDialog.dismiss();
                            Utils.customMessage(mContext, "Something went wrong.");
                        }


                    }

                    @Override
                    public void onFailure(Call<IncrDecResponse> call, Throwable t) {
                        pDialog.dismiss();
                    }
                });

            }
        });
        if (Integer.parseInt(viewHolder.qty.getText().toString()) > 1) {
            viewHolder.decQty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(viewHolder.qty.getText().toString()) > 1) {
                        pDialog = new ProgressDialog(mContext);
                        pDialog.setMessage("Please wait...");
                        pDialog.setCancelable(false);
                        pDialog.show();
                        Log.e(TAG, "onClick: " + responseBeen.get(position).getPT_Id() + " " + responseBeen.get(position).getPrice() + " " + responseBeen.get(position).getOrd_Id());

                        ManageCartRequest manageCartRequest = new ManageCartRequest();
                        manageCartRequest.setPT_Id(responseBeen.get(position).getPT_Id());
                        manageCartRequest.setQTY(Integer.parseInt(viewHolder.qty.getText().toString()) + 1);
                        //manageCartRequest.setQTY(responseBeen.get(position).getOrd_Id());
                        String dec = "Remove";
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                        String value = sharedPreferences.getString("KEY", "");
                        if (value.equals("")) {
                            // not having user id
                            Utils.customMessage(mContext, "SORRY USER ID NOT FOUND");
                        } else {
                            manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                            // user id is available
                        }
                        Call<IncrDecResponse> incrDecResponseCall = Utilss.getWebService().INCR_DEC_RESPONSE_CALL(responseBeen.get(position).getCRT_Id(), Integer.valueOf(value), dec);
                        Log.e("Add into cart ", ": :" + new GsonBuilder().create().toJson(manageCartRequest));
                        incrDecResponseCall.enqueue(new Callback<IncrDecResponse>() {
                            @Override
                            public void onResponse(Call<IncrDecResponse> call, Response<IncrDecResponse> response) {
                                Log.e(TAG, "onResponse code: " + response.code());
                                if (response.code() == 200) {
                                    //Utils.customMessage(mContext, "Added into cart");
                                    manageInterface.manageCart(true);
                                    pDialog.dismiss();
                                } else if (response.code() == 503) {
                                    pDialog.dismiss();
                                    Utils.customMessage(mContext, "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                                } else {
                                    pDialog.dismiss();
                                    Utils.customMessage(mContext, "Something went wrong.");
                                }


                            }

                            @Override
                            public void onFailure(Call<IncrDecResponse> call, Throwable t) {
                                pDialog.dismiss();
                            }
                        });
                    }
                }
            });
        }

        viewHolder.removelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog = new ProgressDialog(mContext);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();
                Log.e(TAG, "onClick: " + responseBeen.get(position).getCRT_Id() + " " + responseBeen.get(position).getRJ_ID() + " " + responseBeen.get(position).getPT_Id());

                ManageCartRequest manageCartRequest = new ManageCartRequest();
                manageCartRequest.setPT_Id(responseBeen.get(position).getPT_Id());
                manageCartRequest.setQTY(Integer.parseInt(viewHolder.qty.getText().toString()) + 1);
                //manageCartRequest.setQTY(responseBeen.get(position).getOrd_Id());

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                String value = sharedPreferences.getString("KEY", "");
                if (value.equals("")) {
                    // not having user id
                    Utils.customMessage(mContext, "SORRY USER ID NOT FOUND");
                } else {
                    manageCartRequest.setRJ_ID(Integer.parseInt((value)));
                    // user id is available
                }
                Call<RemovecartResponse> removecartResponseCall = Utilss.getWebService().REMOVECART_RESPONSE_CALL(responseBeen.get(position).getCRT_Id(), Integer.valueOf(value));
                Log.e("115 ", ": :" + removecartResponseCall.request().url().toString());
                removecartResponseCall.enqueue(new Callback<RemovecartResponse>() {
                    @Override
                    public void onResponse(Call<RemovecartResponse> call, Response<RemovecartResponse> response) {
                        Log.e(TAG, "onResponse code: " + response.code());
                        if (response.code() == 200) {
                            RemovecartResponse removecartResponse = response.body();
                            manageInterface.manageCart(true);
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            String cont = String.valueOf(removecartResponse.getResponse().size());
                            editor.putString("COU", cont);
                            editor.apply();

                            try {
                                MainActivity.conting.setText(cont);
                                ProductActivity.conting.setText(cont);
                                ProductDatailAcitvity.conting.setText(cont);

                            } catch (Exception e) {

                            }
                            removecartResponse.getResponse().size();
                            notifyDataSetChanged();
                            //Utils.customMessage(mContext, "Added into cart");
                            // manageInterface.manageCart(true);
                            pDialog.dismiss();
                            if (cont.equals("0")) {
                                MainActivity.conting.setVisibility(View.GONE);
                            }
                        } else if (response.code() == 400) {
                            pDialog.dismiss();
                            Utils.customMessage(mContext, "Service Unavailable \nOur server is currently unavailable or down for maintenance. Please try again in a while.");
                        } else {
                            pDialog.dismiss();
                            Utils.customMessage(mContext, "Something went wrong.");
                        }


                    }

                    @Override
                    public void onFailure(Call<RemovecartResponse> call, Throwable t) {
                        pDialog.dismiss();
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {

        return responseBeen.size();
    }


}

