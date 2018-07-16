package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Categeory;
import dotcom.com.sam.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.extras.TripSingalton;

/**
 * Created by sanjay on 3/9/2018.
 */


public class CatregeoryAdapter extends RecyclerView.Adapter<CatregeoryAdapter.ViewHolderIN> {
    Context context;
    public static int glob;


    private List<RegistrationResponse.ResponseBean> dataBeen;


    public CatregeoryAdapter(Context context)
    {
        //this.dataBeen=response;
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
        holder.recyclerView.setAdapter(new SubCategeoryAdapter(context));
        holder.recyclerView.setTag(position);
        HashMap<String, String> obj = Constants.shareInstace.arrcontactList.get(position);
        Constants.shareInstace.arrSubCateogrySK = Constants.shareInstace.arrSubCateogry.get(position);
        holder.categeoryName.setText(obj.get("CategosryName"));
        holder.recyclerView.setTag(position);

//        final int glob =  Integer.valueOf(String.valueOf(holder.recyclerView.setTag(position)));
//        CatregeoryAdapter.glob = glob;

        holder.recyclerView.getAdapter();



    }

    @Override
    public int getItemCount() {


            return Constants.shareInstace.arrcontactList.size();



    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolderIN extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView view_all_txt;
        TextView categeoryName;
        public ViewHolderIN(View itemView) {
            super(itemView);

            recyclerView=(RecyclerView) itemView.findViewById(R.id.categeory);
            categeoryName=(TextView)itemView.findViewById(R.id.categeoryName);
            view_all_txt=(TextView) itemView.findViewById(R.id.txt_view);


            view_all_txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent=new Intent(context, ProductActivity.class);
                    context.startActivity(intent);
*/
                    try {
                        Utils.moveNextWithAnimation(context,ProductActivity.class);
                    }
                    catch (Exception e){
                        Utils.moveNextWithAnimation(context,ProductActivity.class);
                    }

                }
            });
        }
    }





}
