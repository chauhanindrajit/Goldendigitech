package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dotcom.com.sam.MainActivity;
import dotcom.com.sam.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;

/**
 * Created by sanjay on 3/9/2018.
 */

public class CatregeoryAdapter extends RecyclerView.Adapter<CatregeoryAdapter.ViewHolderIN> {
    Context context;
    public CatregeoryAdapter(Context context)
    {
        this.context=context;
    }
    @Override
    public ViewHolderIN onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_categeory_lyout,parent,false);

        ViewHolderIN viewHolderIN=new ViewHolderIN(view);

        return viewHolderIN;
    }

    @Override
    public void onBindViewHolder(ViewHolderIN holder, int position) {

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(horizontalLayoutManagaer);
  //      recyclerView.setAdapter(newArrivalAdapter);
        holder.recyclerView.setAdapter(new SubCategeoryAdapter(context));

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolderIN extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView view_all_txt;
        public ViewHolderIN(View itemView) {
            super(itemView);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.categeory);
            view_all_txt=(TextView) itemView.findViewById(R.id.txt_view);

            view_all_txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent=new Intent(context, ProductActivity.class);
                    context.startActivity(intent);
*/
                    Utils.moveNextWithAnimation(context,ProductActivity.class);
                }
            });
        }
    }





}
