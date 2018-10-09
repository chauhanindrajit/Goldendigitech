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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Activity.Matinglast;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.MatingSingalton;

public class PetEventAdapter extends RecyclerView.Adapter<PetEventAdapter.VetViewHolder> {
    Context context;
    static List<MatingSingalton> matingSingaltons;
    public static ArrayList<MatingSingalton> filterItem;

    public PetEventAdapter(Context context, List<MatingSingalton> matingSingaltons) {
        this.context = context;
        this.matingSingaltons = matingSingaltons;
        this.filterItem = new ArrayList<>();
        filterItem.addAll(matingSingaltons);

    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_single_event, parent, false);

        PetEventAdapter.VetViewHolder vetViewHolder = new PetEventAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, int position) {

        holder.loc.setText(matingSingaltons.get(position).getLocation());
        // holder.pet.setText(matingSingaltons.get(position).getPettype());
        //  holder.gender.setText(matingSingaltons.get(position).getGender());
        //  holder.age.setText(matingSingaltons.get(position).getAge());
        //   holder.breed.setText(matingSingaltons.get(position).getBreedName());
//        holder.status.setText(matingSingaltons.get(position).getStatus());
        if (matingSingaltons.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + matingSingaltons.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
        if (matingSingaltons.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + matingSingaltons.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.bgimage);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.bgimage);

        }

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"diagnostic_image");
//                Intent intent=new Intent(context,Matinglast.class);
//                context.startActivity(intent,activityOptions.toBundle());
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return matingSingaltons.size();
    }


    public class VetViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, bgimage;
        TextView loc, pet, gender, age, breed, status;
        CardView cardView;

        public VetViewHolder(View itemView) {
            super(itemView);
            loc = itemView.findViewById(R.id.Mlocation);
            //  pet=itemView.findViewById(R.id.Mdogname);
            imageView = itemView.findViewById(R.id.mainimage);
            cardView = itemView.findViewById(R.id.matingcard);
            bgimage = itemView.findViewById(R.id.bgimage);
            // gender=itemView.findViewById(R.id.Mfemale);
            // age=itemView.findViewById(R.id.Mage);
            // breed=itemView.findViewById(R.id.Mbreed);


        }
    }

    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        matingSingaltons.clear();
        matingSingaltons = new ArrayList<>();
        if (charText.length() == 0) {
            matingSingaltons.addAll(filterItem);
            notifyDataSetChanged();
        } else {
            for (MatingSingalton matingSingalton : filterItem) {
                notifyDataSetChanged();
                if (matingSingalton.getLocation().toString().equalsIgnoreCase(charText) || matingSingalton.getBreedName().toString().equalsIgnoreCase(charText) || matingSingalton.getPettype().toString().equalsIgnoreCase(charText) || matingSingalton.getGender().toString().equalsIgnoreCase(charText)) {
                    ArrayList<MatingSingalton> newList = new ArrayList<>();
                    newList.add(matingSingalton);
                    matingSingaltons.addAll(newList);

                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

}
