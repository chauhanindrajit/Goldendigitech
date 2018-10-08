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

import dotcom.com.sam.Activity.ServicesLastPage;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.request.MatingsearchRequest;

public class MatingSearchAdapter extends RecyclerView.Adapter<MatingSearchAdapter.VetViewHolder> {
    Context context;
    static List<MatingsearchRequest> matingsearchRequests;
    public static ArrayList<MatingsearchRequest> filterItem;

    public MatingSearchAdapter(Context context, List<MatingsearchRequest> matingsearchRequests)
    {
        this.context=context;
        this.matingsearchRequests=matingsearchRequests;
//        this.filterItem = new ArrayList<>();
//        filterItem.addAll(matingSingaltons);

    }

    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.activity_search_mating,parent,false);

        MatingSearchAdapter.VetViewHolder vetViewHolder=new MatingSearchAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.loc.setText(matingsearchRequests.get(position).getLocation());
        holder.pet.setText(matingsearchRequests.get(position).getPettype());
        holder.gender.setText(matingsearchRequests.get(position).getGender());
        holder.age.setText(matingsearchRequests.get(position).getAge());
        holder.breed.setText(matingsearchRequests.get(position).getBreedName());
        holder.status.setText(matingsearchRequests.get(position).getStatus());
        if (matingsearchRequests.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + matingsearchRequests.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
        if (matingsearchRequests.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + matingsearchRequests.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.bgimage);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.bgimage);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonClass.getInstance().setCentername(matingsearchRequests.get(position).getPetName());
                SingletonClass.getInstance().setSRID(String.valueOf(matingsearchRequests.get(position).getSR_Id()));
                SingletonClass.getInstance().setActivityname("Mating");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "diagnostic_image");
                Intent intent = new Intent(context, ServicesLastPage.class);
                context.startActivity(intent, activityOptions.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return matingsearchRequests.size();
    }


    public class VetViewHolder extends RecyclerView.ViewHolder {
       TextView loc,pet,gender,age,breed,status;
        ImageView imageView, bgimage;
        CardView cardView;
        public VetViewHolder(View itemView) {
            super(itemView);
            loc=itemView.findViewById(R.id.Mlocation);
            pet=itemView.findViewById(R.id.Mdogname);
            gender=itemView.findViewById(R.id.Mfemale);
            age=itemView.findViewById(R.id.Mage);
            bgimage = itemView.findViewById(R.id.bgimage);
            breed=itemView.findViewById(R.id.Mbreed);
            status=itemView.findViewById(R.id.Mstatus);
            imageView = itemView.findViewById(R.id.mainimage);
            cardView = itemView.findViewById(R.id.matingcard);


        }
    }
//    public void filter(String charText) {
//
//        charText = charText.toLowerCase(Locale.getDefault());
//        matingSingaltons.clear();
//        matingSingaltons = new ArrayList<>();
//        if (charText.length() == 0) {
//            matingSingaltons.addAll(filterItem);
//            notifyDataSetChanged();
//        } else {
//            for (MatingsearchRequest matingSingalton : filterItem) {
//                notifyDataSetChanged();
//                if (matingSingalton.getLocation().toString().equalsIgnoreCase(charText)||matingSingalton.getBreedName().toString().equalsIgnoreCase(charText) ||matingSingalton.getPettype().toString().equalsIgnoreCase(charText)||matingSingalton.getGender().toString().equalsIgnoreCase(charText)) {
//                    ArrayList<MatingSingalton> newList = new ArrayList<>();
//                    newList.add(matingSingalton);
//                    matingSingaltons.addAll(newList);
//
//                    notifyDataSetChanged();
//
//                }
//            }
//        }
//        notifyDataSetChanged();
//
//    }

}
