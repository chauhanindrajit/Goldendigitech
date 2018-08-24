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
import dotcom.com.sam.ProfileActivity.Petsetterprofileprofile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.SingaltonsClasses.DiagonsticSingalton;
import dotcom.com.sam.SingaltonsClasses.PetSitterSingalton;
import dotcom.com.sam.SingaltonsClasses.PetsetterprofileSingalton;

public class PetsitterAdapter extends RecyclerView.Adapter<PetsitterAdapter.VetViewHolder> {
    Context context;
    private ArrayList<PetSitterSingalton> arrSubCateogry;
    public static ArrayList<PetSitterSingalton> filterItem;

    public PetsitterAdapter(Context context, List<PetSitterSingalton> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<PetSitterSingalton>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }
    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_petstetter_layout, parent, false);

        PetsitterAdapter.VetViewHolder vetViewHolder = new PetsitterAdapter.VetViewHolder(view);

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

    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        arrSubCateogry.clear();
        arrSubCateogry = new ArrayList<>();
        if (charText.length() == 0) {
            arrSubCateogry.addAll(filterItem);
            notifyDataSetChanged();
        } else {
            for (PetSitterSingalton arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
//                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
//                    ArrayList<PetSitterSingalton> newList = new ArrayList<>();
//                    newList.add(arrSubCateogry1);
//                    arrSubCateogry.addAll(newList);
//                    notifyDataSetChanged();
//
//                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        TextView centername, loc, availbilty, fee, pettype;
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);
            centername = itemView.findViewById(R.id.settlename);
            loc = itemView.findViewById(R.id.settleloc);
            availbilty = itemView.findViewById(R.id.settleavailbilty);
            fee = itemView.findViewById(R.id.settlefee);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
