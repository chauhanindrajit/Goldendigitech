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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.Activity.ReviewOrderActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.IncrDecResponse;
import dotcom.com.sam.Response.PaymentResponse;
import dotcom.com.sam.Response.RemovecartResponse;
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
public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {

    Context mContext;
    View convertView;
    private ProgressDialog pDialog;
    private List<PaymentResponse.DATALISTBean> responseBeen;
    ManageInterface manageInterface;
    Double total = 0.0;

    public PaymentAdapter(Context context, List<PaymentResponse.DATALISTBean> size, ManageInterface manageInterface) {
        this.responseBeen = size;
        this.mContext = context;
        this.manageInterface = manageInterface;
    }

    public PaymentAdapter(ReviewOrderActivity reviewOrderActivity, ManageInterface manageInterface) {
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
            discountprice = (TextView) convertView.findViewById(R.id.discountpricee);
            qty = (TextView) convertView.findViewById(R.id.qty);
            groceryIv = (ImageView) convertView.findViewById(R.id.image_cartlist);
        }
    }

    @Override
    public PaymentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_list_adapter_item, parent, false);
        return new PaymentAdapter.ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(final PaymentAdapter.ViewHolder viewHolder, final int position) {

        if (responseBeen.get(position).getImage() != null) {
            Picasso.with(mContext).load("http://mrsam.in/sam/ProductImages/" + responseBeen.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(viewHolder.groceryIv);
        } else {
            Picasso.with(mContext).load(R.drawable.noimage).into(viewHolder.groceryIv);
        }

        viewHolder.prName.setText(responseBeen.get(position).getProductName());
        if (responseBeen.get(position).getQTY() == 0) {
            viewHolder.qty.setText("qty :" + "0");
        } else {
            viewHolder.qty.setText(String.valueOf("qty :" + responseBeen.get(position).getQTY()));
        }

        viewHolder.discountprice.setText(String.valueOf(responseBeen.get(position).getDiscountPrice()));
        viewHolder.qty.setText(String.valueOf("qty :" + responseBeen.get(position).getQTY()));


    }

    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

}

