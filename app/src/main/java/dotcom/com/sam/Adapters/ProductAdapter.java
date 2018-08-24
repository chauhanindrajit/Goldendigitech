package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;

/**
 * Created by sanjay on 3/12/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolderPro> {
    Context context;
    private ArrayList<ProductSingalton> details;

    public ProductAdapter(Context context, List<ProductSingalton> details)
    {
        this.details =(ArrayList<ProductSingalton>)details;
        this.context=context;
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_product,parent,false);
        ProductAdapter.ViewHolderPro viewHolder=new ProductAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, int position) {


        holder.pdctname.setText(details.get(position).getProductName());
        holder.withdiscont.setText(details.get(position).getDiscountPrice());
        holder.actualprce.setText(String.valueOf(details.get(position).getPrice()));

        if (details.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + details.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"productimage");
           Intent intent=new Intent(context,ProductDatailAcitvity.class);
           context.startActivity(intent,activityOptions.toBundle());


            }
        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView pdctname,withdiscont,actualprce;
        public ViewHolderPro(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.prod_image);
            pdctname=itemView.findViewById(R.id.proctname);
            withdiscont=itemView.findViewById(R.id.withdiscount);
            actualprce=itemView.findViewById(R.id.actual_price);


        }

    }
}
