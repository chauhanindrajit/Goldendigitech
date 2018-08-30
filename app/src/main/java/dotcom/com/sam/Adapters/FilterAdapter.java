package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dotcom.com.sam.Activity.ProductDatailAcitvity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;

/**
 * Created by sanjay on 3/12/2018.
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolderPro> {
    Context context;
    int pos;
    private List<ProductResponse.ResponseBean.FilterListBean> details;

    public FilterAdapter(Context context, List<ProductResponse.ResponseBean.FilterListBean> details)
    {

        this.details =details;
        this.context=context;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.search_product,parent,false);
        FilterAdapter.ViewHolderPro viewHolder=new FilterAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, int position) {
        SubFilterAdapter subFilterAdapter = new SubFilterAdapter(context ,details.get(position).getSubList(),details.get(position).getCatName());
//        notifyDataSetChanged();

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(horizontalLayoutManagaer);
        holder.recyclerView.setAdapter(subFilterAdapter);
        holder.catname.setText(details.get(position).getCatName());
        //holder.subcatname.setText(details.get(position).getSubList().get(position).getSubCatName());

    }

    @Override
    public int getItemCount() {

        return details.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView;
        RecyclerView recyclerView;
        TextView catname,subcatname;
        public ViewHolderPro(View itemView) {
            super(itemView);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.categeory);
            catname=itemView.findViewById(R.id.categname);
            subcatname=itemView.findViewById(R.id.subcaty);



        }

    }
}
