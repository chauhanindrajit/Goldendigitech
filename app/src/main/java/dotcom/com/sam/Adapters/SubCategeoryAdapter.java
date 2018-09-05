package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.SubcategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 3/9/2018.
 */

public class SubCategeoryAdapter extends RecyclerView.Adapter<SubCategeoryAdapter.ViewHolder> {
    Context context;
    public static int length;
    int id;
    ArrayList<String> stringList = new ArrayList<String>();
    public static ArrayList<String> arrSubCateogry1;
    public  static ArrayList<RegistrationResponse.ResponseBean.SubCategoriesBean>subCategoriesBeans;
    List<RegistrationResponse.ResponseBean.SubCategoriesBean> arrTemp;
    public SubCategeoryAdapter(Context context, ArrayList<RegistrationResponse.ResponseBean.SubCategoriesBean> arrTemp)
    {
        //this.dataBeen=response;
        this.context=context;
        this.arrTemp = (ArrayList<RegistrationResponse.ResponseBean.SubCategoriesBean>)arrTemp;
        this.arrSubCateogry1 =  arrSubCateogry1;
    }



    @Override
    public SubCategeoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_categeory, parent, false);

        SubCategeoryAdapter.ViewHolder viewHolderIN = new SubCategeoryAdapter.ViewHolder(view);

        return viewHolderIN;


    }

    @Override
    public void onBindViewHolder(final SubCategeoryAdapter.ViewHolder holder, final int position) {
        if (arrTemp.size() > 0) {
            // arrSubCateogry1.clear();
            id = CategorySingalton.getInstance().getC_Id();
            holder.cardView.setId(id);
            holder.setIsRecyclable(false);
            holder.subcat.setText(arrTemp.get(position).getSubCategoryName());
            stringList.add(arrTemp.get(position).getSubCategoryName());
            SubcategorySingalton.getInstance().setSubCategoryName(arrTemp.get(position).getSubCategoryName());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SubcategorySingalton.getInstance().setSc_Id(arrTemp.get(position).getSc_Id());
                    CategorySingalton.getInstance().setCategosryName(arrTemp.get(position).getCategosryName());
                    SubcategorySingalton.getInstance().setSubCategoryName(arrTemp.get(position).getSubCategoryName());
                    CategorySingalton.getInstance().setCat(null);
                    CategorySingalton.getInstance().setSubcateID(arrTemp.get(position).getC_Id());
                    Utils.moveNextWithAnimation(context,ProductActivity.class);
                }
            });
            if (arrTemp.get(position).getImage() != null) {
                Picasso.with(context).load("http://mrsam.in/sam/ProductImages/" + arrTemp.get(position).getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(holder.imageView);
            } else {
                Picasso.with(context).load(R.drawable.noimage).into(holder.imageView);

            }

        }
    }

    @Override
    public int getItemCount() {

        return arrTemp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        CardView cardView;
        TextView categeoryName, subcat;
ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            subcat = (TextView) itemView.findViewById(R.id.text_subcat);
            imageView = (ImageView) itemView.findViewById(R.id.subimage);
        }
    }
}
