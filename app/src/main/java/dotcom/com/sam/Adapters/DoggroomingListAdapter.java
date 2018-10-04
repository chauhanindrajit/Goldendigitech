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

import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.ProfileActivity.Doggromingprofile;
import dotcom.com.sam.Response.DogGroomingResponse;
import dotcom.com.sam.SingaltonsClasses.CatSingalton;
import dotcom.com.sam.SingaltonsClasses.DogSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;

public class DoggroomingListAdapter extends RecyclerView.Adapter<DoggroomingListAdapter.VetViewHolder> {
    Context context;
    private ArrayList<DogGroomingResponse.ResponseBean> arrSubCateogry;
    public static ArrayList<DogGroomingResponse.ResponseBean> filterItem;

    public DoggroomingListAdapter(Context context, List<DogGroomingResponse.ResponseBean> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<DogGroomingResponse.ResponseBean>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }
    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_doggroming_layout, parent, false);

        DoggroomingListAdapter.VetViewHolder vetViewHolder = new DoggroomingListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogSingalton.getInstance().setCenterName(arrSubCateogry.get(position).getCenterName());
                DogSingalton.getInstance().setImages(arrSubCateogry.get(position).getImages());
                SingletonClass.getInstance().setPackagename("Dog");
                DogSingalton.getInstance().setGroomingService_Id(arrSubCateogry.get(position).getGroomingService_Id());
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, Doggromingprofile.class);
                context.startActivity(intent, activityOptions.toBundle());


            }
        });


        holder.centername.setText(arrSubCateogry.get(position).getCenterName());
        holder.servic.setText(arrSubCateogry.get(position).getOwnerAddress());
        if (arrSubCateogry.get(position).getImages() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImages().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
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
            for (DogGroomingResponse.ResponseBean arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getSearchLocations().toString().equalsIgnoreCase(charText)) {
                    ArrayList<DogGroomingResponse.ResponseBean> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        TextView centername, servic, sampletype, collentngtime, pettype;
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);
            centername = itemView.findViewById(R.id.diagnosticsname);
            servic = itemView.findViewById(R.id.services);
            sampletype = itemView.findViewById(R.id.sampletype);
            collentngtime = itemView.findViewById(R.id.blodcollectntime);
            pettype = itemView.findViewById(R.id.pettype);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
