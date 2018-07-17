package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Categeory;
import dotcom.com.sam.R;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubCategeoryAdapter extends RecyclerView.Adapter<SubCategeoryAdapter.ViewHolder> {
    Context context;
public static int glob;
    int currentPosition;
    private ArrayList<RegistrationResponse.ResponseBean> arrSubCateogry;


    public SubCategeoryAdapter(Context context, List<RegistrationResponse.ResponseBean> arrSubCateogry)
    {
        //this.dataBeen=response;
        this.context=context;
        this.arrSubCateogry = (ArrayList<RegistrationResponse.ResponseBean>) arrSubCateogry;
    }



    @Override
    public SubCategeoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_categeory, parent, false);

        SubCategeoryAdapter.ViewHolder viewHolderIN = new SubCategeoryAdapter.ViewHolder(view);

        return viewHolderIN;


    }

    @Override
    public void onBindViewHolder(SubCategeoryAdapter.ViewHolder holder, int position) {
       // glob =holder.categeoryName.getTag();
        holder.subcat.setText(arrSubCateogry.get(position).getSubCategories().get(position).getSubCategoryName());


    }

    @Override
    public int getItemCount() {

       return Integer.parseInt(String.valueOf(arrSubCateogry.get(glob).getSubCategories().size()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        CardView cardView;
        TextView categeoryName, subcat;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            subcat = (TextView) itemView.findViewById(R.id.text_subcat);
        }
    }
}
