package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import dotcom.com.sam.MainActivity;
import dotcom.com.sam.ProductDatailAcitvity;
import dotcom.com.sam.R;

/**
 * Created by sanjay on 3/8/2018.
 */

public class NewArrivalAdapter extends RecyclerView.Adapter<NewArrivalAdapter.ViewHOLDER> {
     Context context;

     public NewArrivalAdapter(Context context)
    {
       this.context=context;
    }

    @Override
    public NewArrivalAdapter.ViewHOLDER onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_new_arrival,parent,false);
        ViewHOLDER viewHolder=new ViewHOLDER(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NewArrivalAdapter.ViewHOLDER holder, int position) {

         holder.prod.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation((Activity)context,holder.imageView,"productimage");
                 Intent intent=new Intent(context,ProductDatailAcitvity.class);
                 context.startActivity(intent,options.toBundle());
             }
         });


    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHOLDER extends RecyclerView.ViewHolder {
        //RecyclerView recyclerView;
        ImageView imageView;
        LinearLayout prod;
        public ViewHOLDER(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.prod_image);
            prod=(LinearLayout) itemView.findViewById(R.id.newarrival_layout);

        }
    }



    private void setcategeory(RecyclerView recyclerView)
    {

//        SubCategeoryAdapter subCategeoryAdapter=new SubCategeoryAdapter(context);
//        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManagaer);
//        recyclerView.setAdapter(subCategeoryAdapter);

    }
}
