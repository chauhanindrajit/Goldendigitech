package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dotcom.com.sam.R;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubCategeoryAdapter extends RecyclerView.Adapter<SubCategeoryAdapter.ViewHolder> {
    Context context;

    public SubCategeoryAdapter(Context context)
    {
       this.context=context;
    }


    @Override
    public SubCategeoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_categeory,parent,false);

        SubCategeoryAdapter.ViewHolder viewHolderIN=new SubCategeoryAdapter.ViewHolder(view);

        return viewHolderIN;
    }

    @Override
    public void onBindViewHolder(SubCategeoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView) itemView.findViewById(R.id.cardview);
          //  cardView.setElevation(6f);
            /*recyclerView=itemView.findViewById(R.id.)*/
        }
    }
}
