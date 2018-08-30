package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;

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

    public SubFilterAdapter(Context context, List<ProductResponse.ResponseBean.FilterListBean.SubListBean> subList, String catName) {
        this.context=context;
        this.filterList=subList;
        this.catname=catName;
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
        holder.subcat.setText(filterList.get(position).getSubCatName());
        holder.checkBox.setText("Checkbox " + position);
       // holder.checkBox.setChecked(Boolean.parseBoolean(String.valueOf(filterList.get(position).getSelected())));
        holder.checkBox.setTag(position);
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer) holder.checkBox.getTag();
                if(holder.checkBox.isChecked()){
                Toast.makeText(context, catname+ ":"+filterList.get(pos).getSub_Id(), Toast.LENGTH_SHORT).show();
                mUserItems.add(filterList.get(pos));

                    for (int i = 0; i < filterList.size(); i++){
                        ProductSingalton productSingalton=new ProductSingalton();
                        productSingalton.setSc_Id(filterList.get(pos).getSub_Id());
                        tripSingaltonss.add(productSingalton);
                    }

                }

                 else {
                    Toast.makeText(context, "REMOVED"+ " clicked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkbox);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            subcat = (TextView) itemView.findViewById(R.id.subcaty);
        }
    }
}
