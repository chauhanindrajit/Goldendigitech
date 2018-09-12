package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dotcom.com.sam.R;
import dotcom.com.sam.Response.BuypetfilterResponse;
import dotcom.com.sam.Response.ProductResponse;
import retrofit2.Callback;

/**
 * Created by sanjay on 3/12/2018.
 */

public class BuypetFilterAdapter extends RecyclerView.Adapter<BuypetFilterAdapter.ViewHolderPro> {
    Context context;
    int pos;
    private List<BuypetfilterResponse.ResponseBean> details;

    public BuypetFilterAdapter(Context context, List<BuypetfilterResponse.ResponseBean> details)
    {

        this.details =details;
        this.context=  context;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.buy_pet_search_product,parent,false);
        BuypetFilterAdapter.ViewHolderPro viewHolder=new BuypetFilterAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, int position) {
        SubBuyFilterAdapter subBuyFilterAdapter = new SubBuyFilterAdapter(context ,details.get(position).getBreedList(),details.get(position).getCategosryName());
//        notifyDataSetChanged();

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(horizontalLayoutManagaer);
       holder.recyclerView.setAdapter(subBuyFilterAdapter);
        holder.catname.setText(details.get(position).getCategosryName());
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
