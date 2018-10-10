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

import dotcom.com.sam.ProfileActivity.AdoptpetProfile;
import dotcom.com.sam.ProfileActivity.PetOldAgeHomeProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.SingaltonsClasses.AdoptaPetSingalton;
import dotcom.com.sam.SingaltonsClasses.AdoptprofileSingalton;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.request.OldpetRequest;

public class AdoptpetAdapter extends RecyclerView.Adapter<AdoptpetAdapter.VetViewHolder> {
    Context context;
    private ArrayList<AdoptaPetSingalton> arrSubCateogry;

    //public static ArrayList<AdoptaPetSingalton> filterItem;
    public AdoptpetAdapter(Context context, List<AdoptaPetSingalton> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<AdoptaPetSingalton>) arrSubCateogry;
        // this.filterItem = new ArrayList<>();
//       filterItem.addAll(arrSubCateogry);
    }


    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_adopt_profile, parent, false);

        AdoptpetAdapter.VetViewHolder vetViewHolder = new AdoptpetAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Utils.moveNextWithAnimation(context,AdoptpetProfile.class);

                AdoptprofileSingalton.getInstance().setPet_Name(arrSubCateogry.get(position).getPet_Name());
                AdoptprofileSingalton.getInstance().setAge(arrSubCateogry.get(position).getAge());
                AdoptprofileSingalton.getInstance().setBreedName(arrSubCateogry.get(position).getBreedName());
                AdoptprofileSingalton.getInstance().setGender(arrSubCateogry.get(position).getGender());
                AdoptprofileSingalton.getInstance().setOwnerName(arrSubCateogry.get(position).getOwnerName());
                AdoptprofileSingalton.getInstance().setOwnerAddress(arrSubCateogry.get(position).getOwnerAddress());
                AdoptprofileSingalton.getInstance().setOwnerContact(arrSubCateogry.get(position).getOwnerContact());
                AdoptprofileSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                AdoptprofileSingalton.getInstance().setOwnerEmail(arrSubCateogry.get(position).getOwnerEmail());
                AdoptprofileSingalton.getInstance().setStatus(arrSubCateogry.get(position).getStatus());
                AdoptprofileSingalton.getInstance().setCondition(arrSubCateogry.get(position).getCondition());
                AdoptprofileSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                AdoptprofileSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, AdoptpetProfile.class);
                context.startActivity(intent, activityOptions.toBundle());


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
        TextView loc, petavail, amount, name;

        public VetViewHolder(View itemView) {
            super(itemView);
            loc = itemView.findViewById(R.id.apetlicatn);
            petavail = itemView.findViewById(R.id.txt_availiblity);
            name = itemView.findViewById(R.id.apetname);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.main_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
