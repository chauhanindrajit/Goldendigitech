package dotcom.com.sam.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.Activity.VetList;
import dotcom.com.sam.ProfileActivity.VetProfileActivity;
import dotcom.com.sam.SingaltonsClasses.TripSingalton;

public class VetListAdapter extends RecyclerView.Adapter<VetListAdapter.VetViewHolder> implements Filterable {
    Context context;
    RecyclerView recyclerView;
    CardView cardView;
    TripSingalton tripSingalton = new TripSingalton();
    public static int glob;
    public static List<TripSingalton> arrSubCateogry;
    public static ArrayList<TripSingalton> filterItem;

    private int currentItem;

    public VetListAdapter(Context context, ArrayList<TripSingalton> arrSubCateogry) {


        this.context = context;
        if (!VetList.isfilter) {
            this.arrSubCateogry = (List<TripSingalton>) arrSubCateogry;
            this.filterItem = new ArrayList<>();
            filterItem.addAll(arrSubCateogry);

        }


    }


    @Override
    public VetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_vet_layout, parent, false);

        VetListAdapter.VetViewHolder vetViewHolder = new VetListAdapter.VetViewHolder(view);

        return vetViewHolder;
    }

    @Override
    public void onBindViewHolder(final VetViewHolder holder, final int position) {

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TripSingalton.getInstance().setDoctorName(arrSubCateogry.get(position).getDoctorName());
                TripSingalton.getInstance().setQualification(arrSubCateogry.get(position).getQualification());
                TripSingalton.getInstance().setWorkExperience(arrSubCateogry.get(position).getWorkExperience());
                TripSingalton.getInstance().setNearMeFees(arrSubCateogry.get(position).getNearMeFees());
                TripSingalton.getInstance().setAvailableTime(arrSubCateogry.get(position).getAvailableTime());
                TripSingalton.getInstance().setDescription(arrSubCateogry.get(position).getDescription());
                TripSingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                TripSingalton.getInstance().setDoctorType(arrSubCateogry.get(position).getDoctorType());
                TripSingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());

                Utils.moveNextWithAnimation(context, VetProfileActivity.class);
            }
        });

        // TripSingalton tripSingalton =this.tripSingalton.get(position);
        holder.drname.setText(arrSubCateogry.get(position).getDoctorName());
        holder.qualifictn.setText(arrSubCateogry.get(position).getQualification());
        holder.experiance.setText(arrSubCateogry.get(position).getWorkExperience());
        holder.homefeess.setText(String.valueOf(arrSubCateogry.get(position).getNearMeFees()));
        holder.opentime.setText(arrSubCateogry.get(position).getAvailableTime());

        if (PetDoctor.categeory == Constats.VET_NEAR_ME || PetDoctor.categeory == Constats.VACCINATION) {
            holder.layoutVetAtHome.setVisibility(View.GONE);
        } else if (PetDoctor.categeory == Constats.VET_AT_HOME) {
            holder.layoutVetAtHome.setVisibility(View.GONE);
        }
        glob = position;
        currentItem = position;
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
            for (TripSingalton arrSubCateogry1 : filterItem) {
                notifyDataSetChanged();
                if (arrSubCateogry1.getLocation().toString().equalsIgnoreCase(charText)) {
                    arrSubCateogry1.clear();
                    ArrayList<TripSingalton> newList = new ArrayList<>();
                    newList.add(arrSubCateogry1);
                    arrSubCateogry.addAll(newList);
                    refresh();
                    notifyDataSetChanged();

                }
            }
        }
        notifyDataSetChanged();

    }

    public void updateData(ArrayList<TripSingalton> viewModels) {
        viewModels.clear();
        viewModels.addAll(viewModels);
        notifyDataSetChanged();
    }

    public void addItem(int position, TripSingalton viewModel) {
        arrSubCateogry.add(position, viewModel);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        arrSubCateogry.remove(position);
        notifyItemRemoved(position);
    }

    public void setFilter(String s) {

        arrSubCateogry.addAll(tripSingalton);
        notifyDataSetChanged();
    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                VetListAdapter.this.notifyDataSetChanged();


            }
        }, 3000);
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    arrSubCateogry = filterItem;
                } else {

                    ArrayList<TripSingalton> filteredList = new ArrayList<>();

                    for (TripSingalton androidVersion : filterItem) {

                        if (androidVersion.getLocation().toString().equalsIgnoreCase(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    arrSubCateogry = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = arrSubCateogry;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrSubCateogry = (ArrayList<TripSingalton>) filterResults.values;
                notifyDataSetChanged();
                updateReceiptsList(filterItem);
            }
        };
    }


    public long getItemId(int position) {
        return position;
    }


    public void updateReceiptsList(List<TripSingalton> newlist) {
        arrSubCateogry.clear();
        arrSubCateogry.addAll(newlist);
        this.notifyDataSetChanged();
    }

    public class VetViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, rsimage;
        TextView drname, qualifictn, experiance, homefeess, opentime, desctription, locatn, subdoctortype;
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
            desctription = itemView.findViewById(R.id.detaildescription);
            //subdoctortype =itemView.findViewById(R.id.subdoctortype);
            locatn = itemView.findViewById(R.id.location);
            imageView = itemView.findViewById(R.id.profile_image);
            layoutVetAtHome = itemView.findViewById(R.id.visit_at_home_layout1);
        }
    }


}
