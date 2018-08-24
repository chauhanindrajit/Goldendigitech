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

import dotcom.com.sam.ProfileActivity.AdoptpetProfile;
import dotcom.com.sam.ProfileActivity.BuypetProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.AdoptaPetSingalton;
import dotcom.com.sam.SingaltonsClasses.AdoptprofileSingalton;
import dotcom.com.sam.SingaltonsClasses.BuyPetSingalton;
import dotcom.com.sam.SingaltonsClasses.BuypetprofileSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;

public class BuyPetAdapter extends RecyclerView.Adapter<BuyPetAdapter.VetViewHolder> {
    Context context;
    private ArrayList<BuyPetSingalton> arrSubCateogry;
    //public static ArrayList<AdoptaPetSingalton> filterItem;
    public BuyPetAdapter(Context context, List<BuyPetSingalton> arrSubCateogry)
    {
        this.context=context;
        this.arrSubCateogry = (ArrayList<BuyPetSingalton>) arrSubCateogry;
       // this.filterItem = new ArrayList<>();
//       filterItem.addAll(arrSubCateogry);
    }


    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_buypet_profile,parent,false);

        BuyPetAdapter.VetViewHolder vetViewHolder=new BuyPetAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //  Utils.moveNextWithAnimation(context,AdoptpetProfile.class);

                BuypetprofileSingalton.getInstance().setPet_Name(arrSubCateogry.get(position).getPet_Name());
                BuypetprofileSingalton.getInstance().setAge(arrSubCateogry.get(position).getAge());
                BuypetprofileSingalton.getInstance().setBreedName(arrSubCateogry.get(position).getBreedName());
                BuypetprofileSingalton.getInstance().setGender(arrSubCateogry.get(position).getGender());
                BuypetprofileSingalton.getInstance().setOwnerName(arrSubCateogry.get(position).getOwnerName());
                BuypetprofileSingalton.getInstance().setOwnerAddress(arrSubCateogry.get(position).getOwnerAddress());
                BuypetprofileSingalton.getInstance().setOwnerContact(arrSubCateogry.get(position).getOwnerContact());
                BuypetprofileSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                BuypetprofileSingalton.getInstance().setOwnerEmail(arrSubCateogry.get(position).getOwnerEmail());
                BuypetprofileSingalton.getInstance().setStatus(arrSubCateogry.get(position).getStatus());
                BuypetprofileSingalton.getInstance().setCondition(arrSubCateogry.get(position).getCondition());
                BuypetprofileSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());

           ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"diagnostic_image");
           Intent intent=new Intent(context,BuypetProfile.class);
           context.startActivity(intent,activityOptions.toBundle());



            }
        });
        String siteUrl = Utils.getStringUserPreference(context, Constants.SITE_URL);
        Log.e("siteUrl", "" + siteUrl);

        holder.name.setText(arrSubCateogry.get(position).getPet_Name());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.petavail.setText(arrSubCateogry.get(position).getStatus());

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

    public class VetViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;
        TextView loc,petavail,amount,name;
        public VetViewHolder(View itemView) {
            super(itemView);
            loc=itemView.findViewById(R.id.apetlicatn);
            petavail=itemView.findViewById(R.id.txt_availiblity);
            name=itemView.findViewById(R.id.apetname);
            cardView=itemView.findViewById(R.id.cardview);
            imageView=itemView.findViewById(R.id.main_image);
            layoutVetAtHome=itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
