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

import dotcom.com.sam.Activity.Diagnostics;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.SingaltonsClasses.DiagonsticSingalton;

public class DiagnosticListAdapter extends RecyclerView.Adapter<DiagnosticListAdapter.VetViewHolder> {
    Context context;
    private ArrayList<DiagonsticResponse.ResponseBean> arrSubCateogry;
    public static ArrayList<DiagonsticResponse.ResponseBean> filterItem;

    public DiagnosticListAdapter(Context context, List<DiagonsticResponse.ResponseBean> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<DiagonsticResponse.ResponseBean>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }
    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_diagnostic_layout, parent, false);

        DiagnosticListAdapter.VetViewHolder vetViewHolder = new DiagnosticListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Utils.moveNextWithAnimation(context,Diagnostics.class);

                DiagonsticSingalton.getInstance().setCenterName(arrSubCateogry.get(position).getCenterName());
                DiagonsticSingalton.getInstance().setServices(arrSubCateogry.get(position).getServices());
                DiagonsticSingalton.getInstance().setSampleType(arrSubCateogry.get(position).getSampleType());
                DiagonsticSingalton.getInstance().setSampleCollectionTimeing(arrSubCateogry.get(position).getSampleCollectionTimeing());
                DiagonsticSingalton.getInstance().setPetsType(arrSubCateogry.get(position).getPetsType());
                DiagonsticSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                DiagonsticSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                DiagonsticSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, Diagnostics.class);
                context.startActivity(intent, activityOptions.toBundle());


            }
        });


        holder.centername.setText(arrSubCateogry.get(position).getCenterName());
        holder.servic.setText(arrSubCateogry.get(position).getServices());
        holder.sampletype.setText(arrSubCateogry.get(position).getSampleType());
        holder.collentngtime.setText(arrSubCateogry.get(position).getSampleCollectionTimeing());
        holder.pettype.setText(arrSubCateogry.get(position).getPetsType());

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
            for (DiagonsticResponse.ResponseBean arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
                    ArrayList<DiagonsticResponse.ResponseBean> newList = new ArrayList<>();
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
