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

import dotcom.com.sam.ProfileActivity.Petsetterprofileprofile;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.PetsetterprofileSingalton;
import dotcom.com.sam.request.MatingsearchRequest;
import dotcom.com.sam.request.PetSettersearchRequest;

public class PetSetterSearchAdapter extends RecyclerView.Adapter<PetSetterSearchAdapter.VetViewHolder> {
    Context context;
    static List<PetSettersearchRequest> arrSubCateogry;
    public static ArrayList<PetSettersearchRequest> filterItem;

    public PetSetterSearchAdapter(Context context, List<PetSettersearchRequest> arrSubCateogry)
    {
        this.context=context;
        this.arrSubCateogry=arrSubCateogry;
//        this.filterItem = new ArrayList<>();
//        filterItem.addAll(matingSingaltons);

    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.activity_petcsearchsetter_mating,parent,false);

        PetSetterSearchAdapter.VetViewHolder vetViewHolder=new PetSetterSearchAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PetsetterprofileSingalton.getInstance().setName(arrSubCateogry.get(position).getName());
                PetsetterprofileSingalton.getInstance().setAddress(arrSubCateogry.get(position).getAddress());
                PetsetterprofileSingalton.getInstance().setDescription(arrSubCateogry.get(position).getDescription());
                PetsetterprofileSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                PetsetterprofileSingalton.getInstance().setServicesType(arrSubCateogry.get(position).getServicesType());
                PetsetterprofileSingalton.getInstance().setFees(arrSubCateogry.get(position).getFees());
                PetsetterprofileSingalton.getInstance().setPetAvailability(arrSubCateogry.get(position).getPetAvailability());
                PetsetterprofileSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, Petsetterprofileprofile.class);
                context.startActivity(intent, activityOptions.toBundle());


            }
        });
        holder.centername.setText(arrSubCateogry.get(position).getName());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.fee.setText(String.valueOf(arrSubCateogry.get(position).getFees()));
        holder.availbilty.setText(" Pet Availability:" + arrSubCateogry.get(position).getPetAvailability());
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
        TextView centername, loc, availbilty, fee, pettype;
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);

            centername = itemView.findViewById(R.id.sname);
            loc = itemView.findViewById(R.id.sloction);
            availbilty = itemView.findViewById(R.id.spetavailabilty);
            fee = itemView.findViewById(R.id.sfee);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);

        }
    }


}
