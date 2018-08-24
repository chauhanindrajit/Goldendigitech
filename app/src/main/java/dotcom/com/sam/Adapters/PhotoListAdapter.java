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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.ImageViewerActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;

/**
 * Created by sanjay on 3/12/2018.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolderPro> {
    Context context;
    public static int i;
    private List<String> arrSubCateogry;
    public PhotoListAdapter(Context context, List<String> arrSubCateogry)
    {
        this.arrSubCateogry = (ArrayList<String>) arrSubCateogry;
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
    public void onBindViewHolder(final ViewHolderPro holder, final int position) {
//        if(position%2==0)
//        {
//            holder.imageView.setImageResource(R.drawable.sample_dog);
//        }
      /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"image");
           Intent intent=new Intent(context,PetPhotography.class);
           context.startActivity(intent,activityOptions.toBundle());

            }
        });*/
        Picasso.with(context).load(arrSubCateogry.get(position).replaceAll(" ", "%20")).fit().placeholder(R.drawable.noimage).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetPhotograpgySingalton.getInstance().setImgUrl((arrSubCateogry.get(position).replaceAll(" ", "%20")));
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolderPro(View itemView) {
            super(itemView);
         imageView=itemView.findViewById(R.id.imageView);

        }

    }
}
