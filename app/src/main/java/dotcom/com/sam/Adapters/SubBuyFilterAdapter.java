package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.BuypetfilterResponse;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubBuyFilterAdapter extends RecyclerView.Adapter<SubBuyFilterAdapter.ViewHolder> {
    Context context;
    List<BuypetfilterResponse.ResponseBean.BreedListBean> filterList = new ArrayList<>();
    ArrayList<ProductResponse.ResponseBean.FilterListBean.SubListBean> mUserItems = new ArrayList<ProductResponse.ResponseBean.FilterListBean.SubListBean>();
    String catname;
    ArrayList tripSingaltonss;
    ArrayList<Integer> subcatid;
    int data;
    RadioGroup genderGrp;
    ArrayList<String> selchkboxlist = new ArrayList<String>();
    CheckBox[] cbs;
    private int selectedPosition = -1;
    ArrayList<String> userid = new ArrayList<String>();
    boolean[] checkBoxState;
    private String[] udis;
    String Price = "Price", Age = "Age";
    private RadioButton lastCheckedRB = null;


    public SubBuyFilterAdapter(Context context, List<BuypetfilterResponse.ResponseBean.BreedListBean> subList, String catname) {
        this.context = context;
        this.filterList = subList;
        this.catname = catname;
    }


    @Override
    public SubBuyFilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_sub_filter, parent, false);
        SubBuyFilterAdapter.ViewHolder viewHolderIN = new SubBuyFilterAdapter.ViewHolder(view);
        return viewHolderIN;


    }

    @Override
    public void onBindViewHolder(final SubBuyFilterAdapter.ViewHolder holder, final int position) {
        final BuypetfilterResponse.ResponseBean.BreedListBean pBean = filterList.get(position);
        holder.subcat.setText(filterList.get(position).getBreedName());
        holder.checkBox.setText("Checkbox " + position);
        final int pos = position;
        holder.checkBox.setChecked(selectedPosition == position);
        holder.checkBox.setTag(position);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!catname.equals("Price") || !catname.equals("Age")) {
                    if (isChecked) {
//                        if (catname.equals("Category")) {
//                            SingletonClass.getInstance().removecatId(0);
//                            SingletonClass.getInstance().addcatId(pBean.getSub_Id());
//                        }
//                        if (catname.equals("Brand")) {
//                            SingletonClass.getInstance().removeBrand(0);
//                            SingletonClass.getInstance().addBrand(pBean.getSub_Id());
//
//                        }
//                        if (catname.equals("Breed")) {
//                            SingletonClass.getInstance().removeBreedId(0);
//                            SingletonClass.getInstance().addBreedId(pBean.getSub_Id());
//                        }
//                        if (catname.equals("Price")) {
//                            selectedPosition = pos;
//                            notifyDataSetChanged();
//                            if (selectedPosition == position) {
//                                holder.checkBox.setChecked(true);
//                            } else {
//                                holder.checkBox.setChecked(false);
//                            }
//                            SingletonClass.getInstance().addPricename(pBean.getSubCatName());
//                            SingletonClass.getInstance().removepricename(catname);
//                            SingletonClass.getInstance().removeAgename(catname);
//                        }
//                        if (catname.equals("Age")) {
//                            SingletonClass.getInstance().removepricename(catname);
//                            SingletonClass.getInstance().removeAgename(catname);
//                            SingletonClass.getInstance().addAgename(pBean.getSubCatName());
//                        } else {
//                        }
//                    } else {
//                        SingletonClass.getInstance().removeBrand(pBean.getSub_Id());
//                        SingletonClass.getInstance().removeBreedId(pBean.getSub_Id());
//                        SingletonClass.getInstance().removecatId(pBean.getSub_Id());
//                        SingletonClass.getInstance().removepricename(pBean.getSubCatName());
//                        SingletonClass.getInstance().removeAgename(pBean.getSubCatName());
//                    }

                //}
            }}}
        });

    }


    @Override
    public int getItemCount() {

        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        CardView cardView;
        CheckBox checkBox;
        TextView categeoryName, subcat;
        LinearLayout linearlayout, childlayout;
        RadioGroup genderGrp;
        RadioButton radionprice;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            subcat = (TextView) itemView.findViewById(R.id.subcaty);
        }
    }
}
