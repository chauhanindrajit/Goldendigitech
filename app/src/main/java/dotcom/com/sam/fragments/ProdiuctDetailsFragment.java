package dotcom.com.sam.fragments;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dotcom.com.sam.Activity.MainActivity;
import dotcom.com.sam.Activity.NotificationCountSetClass;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.Utils.ImageUrlUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProdiuctDetailsFragment extends Fragment {
    TextView prodctname,actualprce,discountprice;
    ImageView image;
Button btnaddtocart;
    int imagePosition;
    String stringImageUri;
    public ProdiuctDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prodiuct_details, container, false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prodctname=(TextView)getView().findViewById(R.id.profilepructname);
        actualprce=(TextView)getView().findViewById(R.id.actualprice);
        discountprice=(TextView)getView().findViewById(R.id.discountprice);
        image=(ImageView) getView().findViewById(R.id.productimage);
        btnaddtocart=(Button)getView().findViewById(R.id.addtocart);
        prodctname.setText(ProductSingalton.getInstance().getProductName());
        actualprce.setText(String.valueOf(ProductSingalton.getInstance().getPrice()));
        actualprce.setPaintFlags(actualprce.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discountprice.setText(ProductSingalton.getInstance().getDiscountPrice());
        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.productname(ProductSingalton.getInstance().getProductName());
                Toast.makeText(getContext(),"Item added to cart.",Toast.LENGTH_SHORT).show();
                ProductActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(ProductActivity.notificationCountCart);
            }
        });

        // pos= SubcategorySingalton.getInstance().getSc_Id();
    }
}
