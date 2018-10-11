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

import dotcom.com.sam.ProfileActivity.TrainingProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.ProfileActivity.Doggromingprofile;
import dotcom.com.sam.SingaltonsClasses.TrainingSingalton;
import dotcom.com.sam.request.TrainingRequest;

public class TrainingservicesListAdapter extends RecyclerView.Adapter<TrainingservicesListAdapter.VetViewHolder> {
    Context context;
    private ArrayList<TrainingRequest> arrSubCateogry;
    public static ArrayList<TrainingRequest> filterItem;

    public TrainingservicesListAdapter(Context context, List<TrainingRequest> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<TrainingRequest>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }
    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_trainingservices_layout, parent, false);

        TrainingservicesListAdapter.VetViewHolder vetViewHolder = new TrainingservicesListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Utils.moveNextWithAnimation(context,Diagnostics.class);

                TrainingSingalton.getInstance().setCenterName(arrSubCateogry.get(position).getCenterName());
                TrainingSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                TrainingSingalton.getInstance().setAddress(arrSubCateogry.get(position).getAddress());
                TrainingSingalton.getInstance().setFees(arrSubCateogry.get(position).getFees());
                TrainingSingalton.getInstance().setOpenDay(arrSubCateogry.get(position).getOpenDay());
                TrainingSingalton.getInstance().setCloseDay(arrSubCateogry.get(position).getCloseDay());
                TrainingSingalton.getInstance().setServices(arrSubCateogry.get(position).getServices());
                TrainingSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                TrainingSingalton.getInstance().setMobile(arrSubCateogry.get(position).getMobile());
                TrainingSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, TrainingProfile.class);
                context.startActivity(intent, activityOptions.toBundle());


            }
        });


        holder.centername.setText(arrSubCateogry.get(position).getCenterName());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.fee.setText(String.valueOf(arrSubCateogry.get(position).getFees()));
        holder.opntym.setText("Open: " + arrSubCateogry.get(position).getOpenDay());
        holder.closetym.setText("Close: " + arrSubCateogry.get(position).getCloseDay());

        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }


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
            for (TrainingRequest arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText) || arrSubCateogry1.getServices().toString().equalsIgnoreCase(charText)) {
                    ArrayList<TrainingRequest> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        TextView centername, loc, fee, opntym, closetym;
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);
            centername = itemView.findViewById(R.id.diagnosticsname);
            loc = itemView.findViewById(R.id.tloc);
            fee = itemView.findViewById(R.id.tfee);
            opntym = itemView.findViewById(R.id.opentimes);
            closetym = itemView.findViewById(R.id.closetime);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
