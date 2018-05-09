package dotcom.com.sam.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dotcom.com.sam.ImageViewerActivity;
import dotcom.com.sam.PetPhotography;
import dotcom.com.sam.R;

/**
 * Created by sanjay on 3/12/2018.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolderPro> {
    Context context;
    public PhotoListAdapter(Context context)
    {
        this.context=context;
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_pet_photo_layout,parent,false);
        PhotoListAdapter.ViewHolderPro viewHolder=new PhotoListAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, int position) {
        if(position%2==0)
        {
            holder.imageView.setImageResource(R.drawable.sample_dog);
        }
      /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"image");
           Intent intent=new Intent(context,PetPhotography.class);
           context.startActivity(intent,activityOptions.toBundle());

            }
        });*/
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 22;
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolderPro(View itemView) {
            super(itemView);
         imageView=itemView.findViewById(R.id.imageView);

        }

    }
}
