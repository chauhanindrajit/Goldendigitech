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

import dotcom.com.sam.ProfileActivity.AdoptProfile;
import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;

public class MatingAdapter extends RecyclerView.Adapter<MatingAdapter.VetViewHolder> {
    Context context;


    public MatingAdapter(Context context)
    {
        this.context=context;

    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_mate_profile,parent,false);

        MatingAdapter.VetViewHolder vetViewHolder=new MatingAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, int position) {
      //for mating----------------------
        if(MainActivity.module_name==Constats.Module.MATING) {
            holder.layoutAdopt.setVisibility(View.GONE);
            holder.layoutMating.setVisibility(View.VISIBLE);

            if (position % 1 == 0) {
                holder.mainImage.setBackgroundResource(R.drawable.cat_sample);
                holder.background.setBackgroundResource(R.drawable.cat_sample);
                holder.txt_availiblity.setBackgroundResource(R.drawable.unavailable_shpe);
                holder.txt_availiblity.setText("UNAVAILABLE");


            }
        }//for adopt
        if(MainActivity.module_name==Constats.Module.ADOPTED) {
            holder.layoutAdopt.setVisibility(View.VISIBLE);
            holder.layoutMating.setVisibility(View.GONE);
            if (position % 1 == 0) {
                holder.mainImage.setBackgroundResource(R.drawable.cat_sample);
                holder.background.setBackgroundResource(R.drawable.cat_sample);
               // holder.txt_availiblity.setBackgroundResource(R.drawable.unavailable_shpe);
                holder.txt_availiblity.setText("NEW");

            }
            else {
                holder.txt_availiblity.setVisibility(View.GONE);
            }

        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.module_name==Constats.Module.ADOPTED) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.mainImage, "image");
                    Intent intent = new Intent(context, AdoptProfile.class);
                    context.startActivity(intent, activityOptions.toBundle());
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return 8;
    }


    public class VetViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage,background;
        LinearLayout layoutMating,layoutAdopt;
        TextView txt_availiblity;
        CardView cardView;

        public VetViewHolder(View itemView) {
            super(itemView);
            mainImage=itemView.findViewById(R.id.main_image);
            background=itemView.findViewById(R.id.backgrond_img);
            txt_availiblity=itemView.findViewById(R.id.txt_availiblity);
            layoutMating=itemView.findViewById(R.id.mating_layout);
            layoutAdopt=itemView.findViewById(R.id.adopt_layout);
            cardView=itemView.findViewById(R.id.cardview);


        }
    }

}
