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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.NewArrivalResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 3/8/2018.
 */

public class NewArrivalAdapter extends RecyclerView.Adapter<NewArrivalAdapter.ViewHOLDER> {
     Context context;
    ArrayList<String> stringList = new ArrayList<>();
    public static List<NewArrivalResponse.ResponseBean> arrSubCateogry;
     public NewArrivalAdapter(Context context, List<NewArrivalResponse.ResponseBean> arrSubCateogry, ArrayList<String>stringList)
    {
        this.arrSubCateogry =(ArrayList<NewArrivalResponse.ResponseBean>) arrSubCateogry;
       this.context=context;
       this.stringList=stringList;
    }

    @Override
    public NewArrivalAdapter.ViewHOLDER onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_new_arrival,parent,false);
        ViewHOLDER viewHolder=new ViewHOLDER(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NewArrivalAdapter.ViewHOLDER holder, final int position) {
//        HashMap<String, String> obj = Constants.shareInstace.arrcontactList1.get(position);
  //      Constants.shareInstace.arrSubCateogry1 = String.valueOf(Constants.shareInstace.arrcontactList1.get(position));
         holder.proddetails.setText(arrSubCateogry.get(position).getProductName());
         holder.prod.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ProductSingalton.getInstance().setProductName(arrSubCateogry.get(position).getProductName());
                 ProductSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                 ProductSingalton.getInstance().setPrice(arrSubCateogry.get(position).getPrice());
                 ProductSingalton.getInstance().setDiscount(arrSubCateogry.get(position).getDiscount());
                 ProductSingalton.getInstance().setDiscountPrice(String.valueOf(arrSubCateogry.get(position).getDiscountPrice()));
                 ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation((Activity)context,holder.imageView,"productimage");
                 Intent intent=new Intent(context,ProductDatailAcitvity.class);
                 context.startActivity(intent,options.toBundle());
             }
         });
        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/ProductImages/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }


    }

    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
    }

    public class ViewHOLDER extends RecyclerView.ViewHolder {
        //RecyclerView recyclerView;
        ImageView imageView;
        TextView proddetails;
        LinearLayout prod;
        public ViewHOLDER(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.prod_image);
            prod=(LinearLayout) itemView.findViewById(R.id.newarrival_layout);
proddetails =(TextView)itemView.findViewById(R.id.prdctdetail);
        }
    }




}
