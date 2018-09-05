package dotcom.com.sam.fragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import dotcom.com.sam.Activity.PetPhotography;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.Adapters.BasePhotoAdapter;
import dotcom.com.sam.Adapters.FilterAdapter;
import dotcom.com.sam.Adapters.ProductAdapter;
import dotcom.com.sam.Adapters.ProductPagerAdapter;
import dotcom.com.sam.Adapters.SubFilterAdapter;
import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductFilterdataResponse;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.MatingSingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.SingaltonsClasses.SubcategorySingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.OnVerticalScrollListener;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.ProductfilterdataRequest;
import dotcom.com.sam.request.RegistrationRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static dotcom.com.sam.Activity.ProductActivity.fragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ProductFragment extends Fragment {
    RecyclerView recyclerView,filterview;
    CardView filterLaout;
    Button applyfilter;
    Toolbar toolbar;
    ActionBar actionBar;
    TabLayout tabLayout;
    private ArrayList<ProductResponse.ResponseBean> arrSubCateogry;
    List<ProductResponse.ResponseBean.ProdListBean> count = new ArrayList<>();
    List<ProductResponse.ResponseBean.FilterListBean> filterList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<String>();
    ViewPager mViewPager;
    private String[] mValues;
    private ArrayList<ProductSingalton> tripSingaltonss;
    private ProgressDialog pDialog;
    int pos;
    int ID;
    List<String>type;
    private RecyclerView.LayoutManager mLayoutManager;
    @SuppressLint("ValidFragment")
    public ProductFragment(int pos, List<ProductResponse.ResponseBean.ProdListBean> count, List<ProductResponse.ResponseBean.FilterListBean> filterList) {

        this.pos=pos;
        this.count=count;
        this.filterList=filterList;


        // Required empty public constructor
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
        applyfilter=getView().findViewById(R.id.aplyfilter);
        txt.setText(Integer.toString(pos));
        tripSingaltonss = new ArrayList<>();
        recyclerView=(RecyclerView) getView().findViewById(R.id.recylcerview_products);

        setRecyclerviewProduct();
        setBottomFillter();

       // pos= SubcategorySingalton.getInstance().getSc_Id();
    }


    private  void setRecyclerviewProduct()
    {
        //   recyclerView
        ProductAdapter productAdapter=new ProductAdapter(getContext(),count,mValues);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
        productAdapter.notifyDataSetChanged();
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);


    }
//
//    private  void FilterRecyclerviewProducts()
//    {
//        //   recyclerView
//        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        filterview.setLayoutManager(mLayoutManager);
//        filterview.setAdapter(new FilterAdapter(getContext(), filterList));
//
//
//    }


    private void setBottomFillter()
    {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view2=inflater.inflate(R.layout.filter_dialog_layout,null);
        ImageView imageView=view2.findViewById(R.id.cancle_image);
        Button applyfilter=view2.findViewById(R.id.aplyfilter);
       final RecyclerView filterview=view2.findViewById(R.id.filtrrecyview);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view2);
        final AlertDialog dialog = builder.create();

        recyclerView.addOnScrollListener(new OnVerticalScrollListener(filterLaout));
        filterLaout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                filterview.setLayoutManager(mLayoutManager);
                filterview.setAdapter(new FilterAdapter(getContext(), filterList));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        applyfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                type=new ArrayList<>();
                type.add("Featured Product");
                checkAcceptTrip();
                Log.e("category", "onClick: "+SingletonClass.getInstance().getCatidlist() );
                Log.e("brand", "onClick: "+SingletonClass.getInstance().getBrandIdList() );
                Log.e("breed", "onClick: "+SingletonClass.getInstance().getBreedidlist() );
                Log.e("PriceName", "onClick: "+SingletonClass.getInstance().getPricename() );
                Log.e("AgeName", "onClick: "+SingletonClass.getInstance().getAgename() );

            }
        });
    }
    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        ProductfilterdataRequest productfilterdataRequest = new ProductfilterdataRequest();
        productfilterdataRequest.setCheckboxAge(SingletonClass.getInstance().getAgename());
        productfilterdataRequest.setCheckboxBrand(SingletonClass.getInstance().getBrandIdList());
        productfilterdataRequest.setCheckboxBreed(SingletonClass.getInstance().getBreedidlist());
        productfilterdataRequest.setCheckboxPrice(String.valueOf(SingletonClass.getInstance().getPricename()));
        productfilterdataRequest.setCheckboxCategory(SingletonClass.getInstance().getCatidlist());
        productfilterdataRequest.setCheckboxProductType(type);

        // pDialog.show();
        final Call<ProductFilterdataResponse> productFilterdataResponseCall = Utilss.getWebService().PRODUCT_FILTERDATA_RESPONSE_CALL(productfilterdataRequest);
        Log.e("URL", "checkAcceptTrip: " + productFilterdataResponseCall.request().url().toString());
        productFilterdataResponseCall.enqueue(new Callback<ProductFilterdataResponse>() {
            @Override
            public void onResponse(Call<ProductFilterdataResponse> call, Response<ProductFilterdataResponse> response) {
                pDialog.hide();
                    if (response.code() == 200) {
                        pDialog.hide();
                        Utils.customMessage(getActivity(), "Filtered Successfully");
                    } else if (response.code() == 400) {
                        pDialog.hide();
                        Utils.customMessage(getActivity(), "Something went wrong.");
                    } else if (response.code() == 404) {
                        pDialog.hide();
                        Utils.customMessage(getActivity(), "There is problem to filter.");
                    } else if (response.code() == 409) {
                        pDialog.hide();
                        Utils.customMessage(getActivity(), "Email id already exists.");
                    } else if (response.code() == 500) {
                        pDialog.hide();
                        Utils.customMessage(getActivity(), "Internal server error.");
                    }
                }


                @Override
            public void onFailure(Call<ProductFilterdataResponse> call, Throwable t) {
                pDialog.hide();
                Log.e("Failed", "onFailure: " + t);
                Toast.makeText(getContext(), "Failedd", Toast.LENGTH_LONG).show();
            }
        });

    }


}
