package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Activity.Categeory;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 3/9/2018.
 */


public class CatregeoryAdapter extends RecyclerView.Adapter<CatregeoryAdapter.ViewHolderIN> {
    Context context;
    public static int glob;
    private List<RegistrationResponse.ResponseBean.SubCategoriesBean> values;
    private RecyclerView.Adapter variantAdapter;
    ArrayList<RegistrationResponse.ResponseBean> arrTemp = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();
    private RecyclerView.LayoutManager variantLayoutManager;
    public  static List<RegistrationResponse.ResponseBean.SubCategoriesBean>subCategoriesBeans;
    //public static ArrayList<RegistrationResponse.ResponseBean.SubCategoriesBean> arrSubCateogry1;
    public ArrayList<RegistrationResponse.ResponseBean> arrSubCateogry1;
    public static List<RegistrationResponse.ResponseBean> arrSubCateogry;


    public CatregeoryAdapter(Categeory context, List<RegistrationResponse.ResponseBean> arrSubCateogry,ArrayList<String>stringList ){
        this.stringList=stringList;
        this.context=context;
        this.arrTemp = (ArrayList<RegistrationResponse.ResponseBean>)arrTemp;
        this.arrSubCateogry = (ArrayList<RegistrationResponse.ResponseBean>) arrSubCateogry;
        // this.arrSubCateogry1 = arrSubCateogry1;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView categeoryName;

        private ViewHolder(View convertView) {
            super(convertView);

            recyclerView=(RecyclerView) itemView.findViewById(R.id.categeory);
            categeoryName=(TextView)itemView.findViewById(R.id.categeoryName);

        }
    }


    @Override
    public ViewHolderIN onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_categeory_lyout,parent,false);

        ViewHolderIN viewHolderIN=new ViewHolderIN(view);

        return viewHolderIN;

    }


    @Override
    public void onBindViewHolder(ViewHolderIN holder, final int position) {
        ArrayList res = new ArrayList();
        arrSubCateogry1 = res;
       // CategorySingalton.getInstance().setSubname(arrSubCateogry.get(position).getSubname());
        SubCategeoryAdapter subCatregeoryAdapterr = new SubCategeoryAdapter(context ,arrSubCateogry.get(position).getSubCategories());
//        notifyDataSetChanged();

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(horizontalLayoutManagaer);
        holder.recyclerView.setAdapter(subCatregeoryAdapterr);
//        holder.recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Utils.moveNextWithAnimation(context,ProductActivity.class);
//            }
//        });
        glob = position;
        holder.categeoryName.setText(arrSubCateogry.get(position).getCategosryName());

        holder.setIsRecyclable(false);
        holder.recyclerView.getRecycledViewPool().clear();
        holder.recyclerView.stopScroll();
        holder.view_all_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*Intent intent=new Intent(context, ProductActivity.class);
                    context.startActivity(intent);
*/
                    stringList.add(CategorySingalton.getInstance().getCategosryName());
                    CategorySingalton.getInstance().setCat(arrSubCateogry.get(position).getCategosryName());
                    CategorySingalton.getInstance().setCateID(arrSubCateogry.get(position).getC_Id());
                    Utils.moveNextWithAnimation(context,ProductActivity.class);


            }
        });

    }
    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
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


//            view_all_txt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    /*Intent intent=new Intent(context, ProductActivity.class);
//                    context.startActivity(intent);
//*/
//                    try {
//
//                        Utils.moveNextWithAnimation(context,ProductActivity.class);
//                    }
//                    catch (Exception e){
//                        Utils.moveNextWithAnimation(context,ProductActivity.class);
//                    }
//
//                }
//            });
        }
    }





}
