package dotcom.com.sam.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dotcom.com.sam.Adapters.ProductAdapter;
import dotcom.com.sam.MainActivity;
import dotcom.com.sam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
    RecyclerView recyclerView;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txt=(TextView)getView().findViewById(R.id.txt);
        txt.setText(Integer.toString(pos));
       recyclerView=(RecyclerView) getView().findViewById(R.id.recylcerview_products);
        setRecyclerviewProduct();

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
}
