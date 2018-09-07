package dotcom.com.sam.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubFilterAdapter extends RecyclerView.Adapter<SubFilterAdapter.ViewHolder> {
    Context context;
    List<ProductResponse.ResponseBean.FilterListBean.SubListBean> filterList = new ArrayList<>();
    ArrayList<ProductResponse.ResponseBean.FilterListBean.SubListBean> mUserItems = new ArrayList<ProductResponse.ResponseBean.FilterListBean.SubListBean>();
    String catname;
    ArrayList tripSingaltonss;
    ArrayList<Integer>subcatid;
    int data;
    RadioGroup genderGrp;
    ArrayList<String> selchkboxlist=new ArrayList<String>();
    CheckBox[] cbs;
    private int selectedPosition = -1;
    ArrayList<String> userid= new ArrayList<String>();
    boolean[] checkBoxState;
    private String[] udis;
    String Price="Price",Age="Age";
    private RadioButton lastCheckedRB = null;


    public SubFilterAdapter(Context context, List<ProductResponse.ResponseBean.FilterListBean.SubListBean> subList, String catname) {
        this.context=context;
        this.filterList=subList;
        this.catname=catname;
    }


    @Override
    public SubFilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_filter, parent, false);
        SubFilterAdapter.ViewHolder viewHolderIN = new SubFilterAdapter.ViewHolder(view);
        return viewHolderIN;


    }

    @Override
    public void onBindViewHolder(final SubFilterAdapter.ViewHolder holder, final int position) {
        final ProductResponse.ResponseBean.FilterListBean.SubListBean pBean = filterList.get(position);
        holder.subcat.setText(filterList.get(position).getSubCatName());
        holder.checkBox.setText("Checkbox " + position);
        final int pos=position;
        holder.checkBox.setChecked(selectedPosition == position);
//        if(catname.equals("Price")) {
//            holder.linearlayout.setVisibility(View.VISIBLE);
//            holder.checkBox.setVisibility(View.GONE);
//            holder.subcat.setVisibility(View.GONE);
//            holder.radionprice.setText(filterList.get(position).getSubCatName());
//            holder.genderGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                    RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
//                    boolean isChecked = checkedRadioButton.isChecked();
//                    if (isChecked) {
//
//
//                        if (lastCheckedRB != null) {
//                            lastCheckedRB.setChecked(false);
//                        }
//                        //store the clicked radiobutton
//                        else {
//                            lastCheckedRB = holder.radionprice;
//                            holder.radionprice.setChecked(true);
//                            //   lastCheckedRB.setChecked(true);
//                        }
//                        //radiogroup.check(radiogroup.getChildAt(0).getId());
//
//                        // holder.genderGrp.check(pBean.getSub_Id());
//                        SingletonClass.getInstance().addPricename(String.valueOf(checkedRadioButton.getText()));
//                        Log.e(" Gender Group ", "onCheckedChanged: " + checkedRadioButton.getText());
//                    }
//                    else{
//                        SingletonClass.getInstance().removepricename(String.valueOf(checkedRadioButton.getText()));
//
//                        // gender = String.valueOf(checkedRadioButton.getText());
//
//                    }
//                }
//            });
//        }
//
//
//        else{
//            // parentView.removeView(childView);
//            holder.childlayout.removeView(holder.linearlayout);
//        }
        // holder.checkBox.setChecked(Boolean.parseBoolean(String.valueOf(filterList.get(position).getSelected())));
        holder.checkBox.setTag(position);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();

        //final ProductResponse.ResponseBean.FilterListBean.SubListBean pBean = filterList.get(position);
//        try {
//            for (int i = 0; i < SingletonClass.getInstance().getBrandIdList().size(); i++) {
//                if (pBean.getSub_Id() == SingletonClass.getInstance().getBrandIdList().get(i))
//                    holder.checkBox.setChecked(false);
//            }
//
//        } catch (Exception e) {
//
//        }

        //  holder.catId.setText(String.valueOf(pBean.getBrandid()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!catname.equals("Price") || !catname.equals("Age")) {
                    if (isChecked) {
                        if(catname.equals("Category")){
                            SingletonClass.getInstance().removecatId(0);
                            SingletonClass.getInstance().addcatId(pBean.getSub_Id());
                        }
                        if(catname.equals("Brand")){
                            SingletonClass.getInstance().removeBrand(0);
                            SingletonClass.getInstance().addBrand(pBean.getSub_Id());

                        }
                        if(catname.equals("Breed")){
                            SingletonClass.getInstance().removeBreedId(0);
                            SingletonClass.getInstance().addBreedId(pBean.getSub_Id());
                        }
                        if (catname.equals("Price")){
                            selectedPosition = pos;
                            notifyDataSetChanged();
                            if(selectedPosition == position){
                                holder.checkBox.setChecked(true);
                            }
                            else{
                                holder.checkBox.setChecked(false);
                            }
                            SingletonClass.getInstance().addPricename(pBean.getSubCatName());
                            SingletonClass.getInstance().removepricename(catname);
                            SingletonClass.getInstance().removeAgename(catname);
                        }
                        if (catname.equals("Age")){
                            SingletonClass.getInstance().removepricename(catname);
                            SingletonClass.getInstance().removeAgename(catname);
                            SingletonClass.getInstance().addAgename(pBean.getSubCatName());
                        }
                        else {
                        }
                    } else {
                        SingletonClass.getInstance().removeBrand(pBean.getSub_Id());
                        SingletonClass.getInstance().removeBreedId(pBean.getSub_Id());
                        SingletonClass.getInstance().removecatId(pBean.getSub_Id());
                        SingletonClass.getInstance().removepricename(pBean.getSubCatName());
                        SingletonClass.getInstance().removeAgename(pBean.getSubCatName());
                    }

                }
            }
        });




//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Integer pos = (Integer) holder.checkBox.getTag();
//                if(holder.checkBox.isChecked()){
//                Toast.makeText(context, catname+ ":"+filterList.get(pos).getSub_Id(), Toast.LENGTH_SHORT).show();
//                mUserItems.add(filterList.get(pos));
//                selchkboxlist.addAll(Collections.singleton(filterList.get(pos).getSubCatName()));
//                    Toast.makeText(context, catname+ ":"+filterList.get(pos).getSub_Id(), Toast.LENGTH_SHORT).show();
//                    selchkboxlist.size();
//
//                }
//
//                 else {
//                    selchkboxlist.remove(filterList.get(pos).getSubCatName());
//                    Toast.makeText(context, "REMOVED"+ " clicked!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        holder.checkBox.setTag(position);
//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//                                           private Integer s;
//                                           @Override
//                                           public void onClick(View v) {
//                                               if (((CheckBox) v).isChecked()){
//                                                 //  checkBoxState[position]=true;
//                                                  // data.setChecked(true);
//                                                   //  isChecked=true;
//                                                   s=filterList.get(position).getSub_Id();
//                                                   Log.e("IDDDDDDDD", String.valueOf(s));
//
//                                                   userid.add(String.valueOf(s));
//                                                   Log.e("ADDED ID", userid.toString());
//                                               }
//                                               else{
//
//                                                   s=filterList.get(position).getSub_Id();
//                                                   userid.remove(s);
//                                                   Log.e("Removed ID", userid.toString());
//                                               }
//                                               SharedPreferences app_preferences = PreferenceManager
//                                                       .getDefaultSharedPreferences(context);
//                                               SharedPreferences.Editor editor = app_preferences.edit();
//
//                                               editor.putString("userid", TextUtils.join(",", userid));
//                                               editor.commit();
//                                           }






//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(holder.checkBox.isChecked()==true){
//                    mUserItems.add(filterList.get(position));
//                }
//                else{
//
//                    mUserItems.remove(filterList.get(position));
//                    //filterList.get(position).setSub_Id();
//                }
//                mUserItems.size();
//            }});



//    });
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
        LinearLayout linearlayout,childlayout;
        RadioGroup genderGrp;
        RadioButton radionprice;
        public ViewHolder(View itemView) {
            super(itemView);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkbox);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            subcat = (TextView) itemView.findViewById(R.id.subcaty);
            //  linearlayout = (LinearLayout) itemView.findViewById(R.id.linearFilter);
            //  childlayout = (LinearLayout) itemView.findViewById(R.id.child);
            // radionprice = (RadioButton) itemView.findViewById(R.id.radbtn);
            // genderGrp = (RadioGroup) itemView.findViewById(R.id.grop);
        }
    }
}
