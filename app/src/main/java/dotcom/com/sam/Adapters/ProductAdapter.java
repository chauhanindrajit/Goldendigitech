package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.Utils.ImageUrlUtils;
import dotcom.com.sam.fragments.ProductFragment;

/**
 * Created by sanjay on 3/12/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolderPro> {
    Context context;
    int pos;
    private String[] mValues;
    private static ProductActivity mActivity;
    private List<ProductResponse.ResponseBean.ProdListBean> details;
    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";

    public ProductAdapter(Context context, List<ProductResponse.ResponseBean.ProdListBean> details ,String[] mValues)
    {

        this.details =details;
        this.context=context;
        this.mValues=mValues;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_product,parent,false);
        ProductAdapter.ViewHolderPro viewHolder=new ProductAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, final int position) {

        holder.pdctname.setText(details.get(position).getProductName());
        holder.withdiscont.setText(details.get(position).getDiscountPrice());
        holder.actualprce.setText(String.valueOf(details.get(position).getPrice()));
        holder.actualprce.setPaintFlags(holder.actualprce.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        if (details.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/ProductImages/" + details.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductSingalton.getInstance().setProductName(details.get(position).getProductName());
                ProductSingalton.getInstance().setImage(details.get(position).getImage());
                ProductSingalton.getInstance().setPrice(details.get(position).getPrice());
                ProductSingalton.getInstance().setDiscount(details.get(position).getDiscount());
                ProductSingalton.getInstance().setDiscountPrice(details.get(position).getDiscountPrice());

                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"productimage");
                Intent intent=new Intent(context,ProductDatailAcitvity.class);
                context.startActivity(intent,activityOptions.toBundle());


            }
        });
        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.productname(details.get(position).getProductName());
                holder.wishlist.setImageResource(R.drawable.ic_favorite_black_18dp);
                notifyDataSetChanged();
                //Toast.makeText(mActivity,"Item added to wishlist.",Toast.LENGTH_SHORT).show();

            }
        });
        pos=position;
    }

    @Override
    public int getItemCount() {

        return details.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView,wishlist;
        TextView pdctname,withdiscont,actualprce;
        public ViewHolderPro(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.prod_image);
            pdctname=itemView.findViewById(R.id.proctname);
            withdiscont=itemView.findViewById(R.id.withdiscount);
            actualprce=itemView.findViewById(R.id.actual_price);
            wishlist=itemView.findViewById(R.id.wishlist);


        }

    }
}
