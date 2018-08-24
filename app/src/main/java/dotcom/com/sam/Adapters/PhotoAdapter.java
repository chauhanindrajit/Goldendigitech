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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.PetPhotography;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;
import dotcom.com.sam.SingaltonsClasses.PhotoSingalton;

/**
 * Created by sanjay on 3/12/2018.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolderPro> {
    Context context;
    private ArrayList<PhotoSingalton> arrSubCateogry;
    private List<String> url;
    public PhotoAdapter(Context context, List<PhotoSingalton> arrSubCateogry)
    {
        this.arrSubCateogry = (ArrayList<PhotoSingalton>) arrSubCateogry;
        this.url=(List<String>) url;
        this.context=context;
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_photo_layout,parent,false);
        PhotoAdapter.ViewHolderPro viewHolder=new PhotoAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, final int position) {
       holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetPhotograpgySingalton.getInstance().setName(arrSubCateogry.get(position).getName());
                GetPhotograpgySingalton.getInstance().setLocation(arrSubCateogry.get(position).getLocation());
                GetPhotograpgySingalton.getInstance().setPhotographerCategory(arrSubCateogry.get(position).getPhotographerCategory());
                GetPhotograpgySingalton.getInstance().setQualification(arrSubCateogry.get(position).getQualification());
                GetPhotograpgySingalton.getInstance().setAbout(arrSubCateogry.get(position).getAbout());
                GetPhotograpgySingalton.getInstance().setCourses(arrSubCateogry.get(position).getCourses());
                GetPhotograpgySingalton.getInstance().setExp(arrSubCateogry.get(position).getExp());
                GetPhotograpgySingalton.getInstance().setImage(arrSubCateogry.get(position).getImage());
                GetPhotograpgySingalton.getInstance().setMultipalImage(arrSubCateogry.get(position).getMultipalImage());
                GetPhotograpgySingalton.getInstance().setIds(arrSubCateogry.get(position).getPG_Id());
                GetPhotograpgySingalton.getInstance().setPG_Id(arrSubCateogry.get(position).getPG_Id());
                GetPhotograpgySingalton.getInstance().setImgUrl(arrSubCateogry.get(position).getImgUrl());

                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.imageView,"image");
            Intent intent=new Intent(context,PetPhotography.class);
            context.startActivity(intent,activityOptions.toBundle());

            }
        });
       holder.name.setText(arrSubCateogry.get(position).getName());
        holder.loc.setText(arrSubCateogry.get(position).getLocation());
        holder.course.setText(arrSubCateogry.get(position).getCourses());
        if (arrSubCateogry.get(position).getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + arrSubCateogry.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

        }
    }

    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView loc,name,course;
        public ViewHolderPro(View itemView) {
            super(itemView);
           imageView=itemView.findViewById(R.id.imageView);
            loc=itemView.findViewById(R.id.photoloc);
            name=itemView.findViewById(R.id.photoname);
            course=itemView.findViewById(R.id.photocourse);


        }

    }
}
