package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

import dotcom.com.sam.ProfileActivity.Doggromingprofile;
import dotcom.com.sam.ProfileActivity.WalkingProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.SingaltonsClasses.WalkingSingalton;
import dotcom.com.sam.request.PetWalkingRequest;

public class PetWalkingListAdapter extends RecyclerView.Adapter<PetWalkingListAdapter.VetViewHolder> {
    Context context;
    private ArrayList<PetWalkingRequest> arrSubCateogry;
    public static ArrayList<PetWalkingRequest> filterItem;

    public PetWalkingListAdapter(Context context, List<PetWalkingRequest> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<PetWalkingRequest>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }
    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_petwalking_layout, parent, false);

        PetWalkingListAdapter.VetViewHolder vetViewHolder = new PetWalkingListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Utils.moveNextWithAnimation(context,Diagnostics.class);

                WalkingSingalton.getInstance().setName(arrSubCateogry.get(position).getName());
                WalkingSingalton.getInstance().setAddress(arrSubCateogry.get(position).getAddress());
                WalkingSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                WalkingSingalton.getInstance().setAddress(arrSubCateogry.get(position).getAddress());
                WalkingSingalton.getInstance().setDuration(arrSubCateogry.get(position).getDuration());
                WalkingSingalton.getInstance().setDay(arrSubCateogry.get(position).getDay());
                WalkingSingalton.getInstance().setStarttime(arrSubCateogry.get(position).getStarttime());
                WalkingSingalton.getInstance().setEndTime(arrSubCateogry.get(position).getEndTime());
                WalkingSingalton.getInstance().setOpratingLocation(arrSubCateogry.get(position).getOpratingLocation());
                WalkingSingalton.getInstance().setOpenDays(arrSubCateogry.get(position).getOpenDays());
                WalkingSingalton.getInstance().setCloseDays(arrSubCateogry.get(position).getCloseDays());
                WalkingSingalton.getInstance().setEmail(arrSubCateogry.get(position).getEmail());
                WalkingSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                WalkingSingalton.getInstance().setMobile(arrSubCateogry.get(position).getMobile());
                WalkingSingalton.getInstance().setPerhoureCost(arrSubCateogry.get(position).getPerhoureCost());
                WalkingSingalton.getInstance().setPerDayCost(arrSubCateogry.get(position).getPerDayCost());
                WalkingSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());
                WalkingSingalton.getInstance().setDescription(String.valueOf(arrSubCateogry.get(position).getDescription()));
                WalkingSingalton.getInstance().setProfile(arrSubCateogry.get(position).getProfile());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, WalkingProfile.class);
                context.startActivity(intent, activityOptions.toBundle());


            }
        });


        holder.centername.setText(arrSubCateogry.get(position).getName());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.fee.setText(String.valueOf(arrSubCateogry.get(position).getPerDayCost()));


        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
        //  holder.availbe.setText(arrSubCateogry.get(position).getStatus());

//        if(PetDoctor.categeory== Constats.VET_NEAR_ME)
//        {
//            holder.layoutVetAtHome.setVisibility(View.GONE);
//        }
//        else if(PetDoctor.categeory== Constats.VET_AT_HOME)
//        {
//            holder.layoutVetAtHome.setVisibility(View.VISIBLE);
//        }

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
            for (PetWalkingRequest arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
                    ArrayList<PetWalkingRequest> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        TextView centername, loc, fee, availbe;
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);
            centername = itemView.findViewById(R.id.wname);
            loc = itemView.findViewById(R.id.wloctn);
            fee = itemView.findViewById(R.id.wfee);
            availbe = itemView.findViewById(R.id.wavailble);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
