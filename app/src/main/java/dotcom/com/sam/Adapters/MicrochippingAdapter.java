package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.ProfileActivity.MicroChippingProfile;
import dotcom.com.sam.ProfileActivity.PetOldAgeHomeProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.SingaltonsClasses.MicroChippingSingalton;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.request.OldpetRequest;

public class MicrochippingAdapter extends RecyclerView.Adapter<MicrochippingAdapter.VetViewHolder> {
    Context context;
    private ArrayList<MicroChippingSingalton> arrSubCateogry;
    public static ArrayList<MicroChippingSingalton> filterItem;
    public MicrochippingAdapter(Context context, List<MicroChippingSingalton> arrSubCateogry)
    {
        this.context=context;
        this.arrSubCateogry = (ArrayList<MicroChippingSingalton>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
       filterItem.addAll(arrSubCateogry);
    }
    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_microchipping_home,parent,false);

        MicrochippingAdapter.VetViewHolder vetViewHolder=new MicrochippingAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //  Utils.moveNextWithAnimation(context,Diagnostics.class);
               // OldpetRequest oldpetRequest = new OldpetRequest();

                MicroChippingSingalton.getInstance().setCenterName(arrSubCateogry.get(position).getCenterName());
                MicroChippingSingalton.getInstance().setAddress(arrSubCateogry.get(position).getAddress());
                MicroChippingSingalton.getInstance().setFees(arrSubCateogry.get(position).getFees());
                MicroChippingSingalton.getInstance().setDescription(arrSubCateogry.get(position).getDescription());
                MicroChippingSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());



           ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"diagnostic_image");
           Intent intent=new Intent(context,MicroChippingProfile.class);
           context.startActivity(intent,activityOptions.toBundle());



            }
        });
        String siteUrl = Utils.getStringUserPreference(context, Constants.SITE_URL);
        Log.e("siteUrl", "" + siteUrl);
//        if(PetDoctor.categeory== Constats.VET_NEAR_ME)
//        {
//            holder.layoutVetAtHome.setVisibility(View.GONE);
//        }
//        else if(PetDoctor.categeory== Constats.VET_AT_HOME)
//        {
////            holder.layoutVetAtHome.setVisibility(View.VISIBLE);
//        }
        holder.name.setText(arrSubCateogry.get(position).getCenterName());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.amount.setText(String.valueOf(arrSubCateogry.get(position).getFees()));
        holder.petavail.setText(arrSubCateogry.get(position).getTime());

        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
    }

    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
    }
    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        arrSubCateogry.clear();
        arrSubCateogry = new ArrayList<>();
        if (charText.length() == 0) {
            arrSubCateogry.addAll(filterItem);
            notifyDataSetChanged();
        } else {
            for (MicroChippingSingalton arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
                    ArrayList<MicroChippingSingalton> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;
        TextView loc,petavail,amount,name;
        public VetViewHolder(View itemView) {
            super(itemView);
            loc=itemView.findViewById(R.id.oldlicatn);
            petavail=itemView.findViewById(R.id.oldpetavailibilty);
            amount=itemView.findViewById(R.id.oldamount);
            name=itemView.findViewById(R.id.oldname);
            cardView=itemView.findViewById(R.id.cardview);
            imageView=itemView.findViewById(R.id.profile_image);
            layoutVetAtHome=itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
