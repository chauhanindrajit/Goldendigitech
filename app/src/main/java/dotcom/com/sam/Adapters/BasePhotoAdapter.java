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
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import dotcom.com.sam.Activity.ImageViewerActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;
import dotcom.com.sam.SingaltonsClasses.PhotoSingalton;

/**
 * Created by sanjay on 3/12/2018.
 */

public class BasePhotoAdapter extends RecyclerView.Adapter<BasePhotoAdapter.ViewHolderPro> {
    Context context;
    public static int i;
    private List<String> arrSubCateogry;
    public BasePhotoAdapter(Context context, List<String> arrSubCateogry)
    {
        this.arrSubCateogry = (List<String>) arrSubCateogry;
        this.context=context;
    }
    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_base_photo_layout,parent,false);
        BasePhotoAdapter.ViewHolderPro viewHolder=new BasePhotoAdapter.ViewHolderPro(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, final int position) {
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
