package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import dotcom.com.sam.Categeory;
import dotcom.com.sam.R;
import dotcom.com.sam.extras.Constants;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubCategeoryAdapter extends RecyclerView.Adapter<SubCategeoryAdapter.ViewHolder> {
    Context context;

    int currentPosition;

    public SubCategeoryAdapter(Context context) {
        this.context = context;
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
        ;
        if (Constants.shareInstace.arrSubCateogrySK.size() > 0) {

            //Constants.shareInstace.arrSubCateogrySK.clear();


            holder.cardView.setId(position);

        }

        HashMap<String, String> obj = Constants.shareInstace.arrSubCateogrySK.get(position);
        holder.subcat.setText(obj.get("SubCategoryName"));

    }

    @Override
    public int getItemCount() {

        return Constants.shareInstace.arrSubCateogrySK.size();
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
