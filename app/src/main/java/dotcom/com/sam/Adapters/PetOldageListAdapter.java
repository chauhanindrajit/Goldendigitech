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

import dotcom.com.sam.Diagnostics;
import dotcom.com.sam.PetDoctor;
import dotcom.com.sam.PetOldAgeHomeProfile;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;

public class PetOldageListAdapter extends RecyclerView.Adapter<PetOldageListAdapter.VetViewHolder> {
    Context context;

    public PetOldageListAdapter(Context context)
    {
        this.context=context;

    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_pet_oldage_home,parent,false);

        PetOldageListAdapter.VetViewHolder vetViewHolder=new PetOldageListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //  Utils.moveNextWithAnimation(context,Diagnostics.class);


           ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"diagnostic_image");
           Intent intent=new Intent(context,PetOldAgeHomeProfile.class);
           context.startActivity(intent,activityOptions.toBundle());



            }
        });

        if(PetDoctor.categeory== Constats.VET_NEAR_ME)
        {
            holder.layoutVetAtHome.setVisibility(View.GONE);
        }
        else if(PetDoctor.categeory== Constats.VET_AT_HOME)
        {
            holder.layoutVetAtHome.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return 8;
    }


    public class VetViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        LinearLayout layoutVetAtHome;
        public VetViewHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardview);
            imageView=itemView.findViewById(R.id.profile_image);
            layoutVetAtHome=itemView.findViewById(R.id.visit_at_home_layout);
        }
    }

}
