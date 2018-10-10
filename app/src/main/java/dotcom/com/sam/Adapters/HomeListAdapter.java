package dotcom.com.sam.Adapters;

import android.content.Context;
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

import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.HomeRespose;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.ProfileActivity.HomeProfileActivity;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.SingaltonsClasses.HomeSingalton;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.VetViewHolder> {
    Context context;

    private ArrayList<HomeRespose.ResponseBean> arrSubCateogry;
    public static ArrayList<HomeRespose.ResponseBean> filterItem;

    public HomeListAdapter(Context context, List<HomeRespose.ResponseBean> arrSubCateogry) {
        this.context = context;
        this.arrSubCateogry = (ArrayList<HomeRespose.ResponseBean>) arrSubCateogry;
        this.filterItem = new ArrayList<>();
        try {
            filterItem.addAll(arrSubCateogry);
        } catch (Exception e) {
        }

    }


    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_home_layout, parent, false);

        HomeListAdapter.VetViewHolder vetViewHolder = new HomeListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HomeSingalton.getInstance().setDoctorName(arrSubCateogry.get(position).getDoctorName());
                HomeSingalton.getInstance().setQualification(arrSubCateogry.get(position).getQualification());
                HomeSingalton.getInstance().setWorkExperience(arrSubCateogry.get(position).getWorkExperience());
                HomeSingalton.getInstance().setNearMeFees(arrSubCateogry.get(position).getNearMeFees());
                HomeSingalton.getInstance().setAvailableTime(arrSubCateogry.get(position).getAvailableTime());
                HomeSingalton.getInstance().setDescription(arrSubCateogry.get(position).getDescription());
                HomeSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                HomeSingalton.getInstance().setDoctorType(arrSubCateogry.get(position).getDoctorType());
                HomeSingalton.getInstance().setDiagnosticsFees(arrSubCateogry.get(position).getDiagnosticsFees());
                HomeSingalton.getInstance().setAtHomeFees(arrSubCateogry.get(position).getAtHomeFees());
                HomeSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                HomeSingalton.getInstance().setSR_Id(arrSubCateogry.get(position).getSR_Id());
                Utils.moveNextWithAnimation(context, HomeProfileActivity.class);


            }
        });

        if (PetDoctor.categeory == Constats.VET_NEAR_ME || PetDoctor.categeory == Constats.VACCINATION) {
            holder.layoutVetAtHome.setVisibility(View.GONE);
        } else if (PetDoctor.categeory == Constats.VET_AT_HOME) {
            holder.layoutVetAtHome.setVisibility(View.GONE);
        }


        holder.drname.setText(arrSubCateogry.get(position).getDoctorName());
        holder.qualifictn.setText(arrSubCateogry.get(position).getQualification());
        holder.experiance.setText(arrSubCateogry.get(position).getWorkExperience());
        holder.homefeess.setText(String.valueOf(arrSubCateogry.get(position).getNearMeFees()));
        holder.opentime.setText(arrSubCateogry.get(position).getAvailableTime());

        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
//        holder.ssdiacharge.setText(arrSubCateogry.get(position).getDiagnosticsFees());
        //       holder.sshomecharge.setText(arrSubCateogry.get(position).getAtHomeFees());

        // holder.subdoctortype.setText(arrSubCateogry.get(position).getDoctorType());
        //  holder.desctription.setText(arrSubCateogry.get(position).getDescription());
//        holder.locatn.setText(arrSubCateogry.get(position).getLocation());


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
            for (HomeRespose.ResponseBean arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
                    ArrayList<HomeRespose.ResponseBean> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public class VetViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView, rsimage;
        TextView drname, qualifictn, experiance, homefeess, opentime, desctription, locatn, subdoctortype, ssdiacharge, sshomecharge;
        LinearLayout layoutVetAtHome;

        public VetViewHolder(View itemView) {
            super(itemView);
            drname = itemView.findViewById(R.id.doctorname);
            qualifictn = itemView.findViewById(R.id.doctorqualification);
            experiance = itemView.findViewById(R.id.doctorexperiance);
            homefeess = itemView.findViewById(R.id.docthomefees);
            opentime = itemView.findViewById(R.id.availabletime);
            cardView = itemView.findViewById(R.id.cardview);
            rsimage = itemView.findViewById(R.id.rupessimages);
            ssdiacharge = itemView.findViewById(R.id.hcharge);
            sshomecharge = itemView.findViewById(R.id.hvisitathomefee);
            desctription = itemView.findViewById(R.id.detaildescription);
            //subdoctortype =itemView.findViewById(R.id.subdoctortype);
            locatn = itemView.findViewById(R.id.location);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout1);

        }
    }

}
