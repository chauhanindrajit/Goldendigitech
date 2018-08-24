package dotcom.com.sam.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Adapters.ProductPagerAdapter;
import dotcom.com.sam.Activity.ProductActivity;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductMainFragment extends Fragment {

    ViewPager mViewPager;
    TabLayout tabLayout;
    private ArrayList<ProductSingalton> arrSubCateogry;
    ArrayList<List<ProductResponse.ResponseBean>> stringList = new ArrayList<List<ProductResponse.ResponseBean>>();
    public ProductMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_main, container, false);
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        addTab();
       ProductPagerAdapter productPagerAdapter=new ProductPagerAdapter(ProductActivity.fragmentManager,stringList, arrSubCateogry);
        mViewPager.setAdapter(productPagerAdapter);
        TabListener();
    }


    private void initView(View view)
    {
        mViewPager=(ViewPager) view.findViewById(R.id.pager);
        tabLayout=(TabLayout) view.findViewById(R.id.tablayout);

    }

    private void addTab()
    {
        tabLayout.addTab(tabLayout.newTab().setText("FEED"));
        tabLayout.addTab(tabLayout.newTab().setText("APPAREL"));
        tabLayout.addTab(tabLayout.newTab().setText("SHOES"));
        tabLayout.addTab(tabLayout.newTab().setText("TOYS"));
        tabLayout.addTab(tabLayout.newTab().setText("KENNEL"));

    }


    private void TabListener()
    {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // mViewPager.setPage tab.getPosition();
                mViewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }





}
