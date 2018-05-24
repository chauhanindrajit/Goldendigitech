package dotcom.com.sam.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import dotcom.com.sam.Adapters.ProductAdapter;
import dotcom.com.sam.MainActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.extras.OnVerticalScrollListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
    RecyclerView recyclerView;
    CardView filterLaout;

     int pos;
    public ProductFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ProductFragment(int pos) {
        this.pos=pos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txt=(TextView)getView().findViewById(R.id.txt);
        filterLaout=getView().findViewById(R.id.footer_filter);
        txt.setText(Integer.toString(pos));
        recyclerView=(RecyclerView) getView().findViewById(R.id.recylcerview_products);
        setRecyclerviewProduct();
        setBottomFillter();

    }


    private  void setRecyclerviewProduct()
    {
     //   recyclerView
        ProductAdapter productAdapter=new ProductAdapter(getContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
      //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
         recyclerView.setAdapter(productAdapter);


    }



    private void setBottomFillter()
    {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view2=inflater.inflate(R.layout.filter_dialog_layout,null);
        ImageView imageView=view2.findViewById(R.id.cancle_image);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view2);
        final AlertDialog dialog = builder.create();



        recyclerView.addOnScrollListener(new OnVerticalScrollListener(filterLaout));
        filterLaout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dialog.dismiss();
            }
        });


    }



}
