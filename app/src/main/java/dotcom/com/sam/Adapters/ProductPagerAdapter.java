package dotcom.com.sam.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.fragments.ProductFragment;

/**
 * Created by sanjay on 3/12/2018.
 */

public class ProductPagerAdapter extends FragmentPagerAdapter {
    ArrayList<List<ProductResponse.ResponseBean>> count = new ArrayList<>();
    private boolean doNotifyDataSetChangedOnce = false;

    List<ProductResponse.ResponseBean> tripSingaltonss = new ArrayList<>();

    public ProductPagerAdapter(FragmentManager fragmentManager, ArrayList<List<ProductResponse.ResponseBean>> count, List<ProductResponse.ResponseBean> tripSingaltonss) {
        super(fragmentManager);
        notifyDataSetChanged();
        this.count = count;
        this.tripSingaltonss = tripSingaltonss;
    }

    @Override
    public Fragment getItem(int position) {

        //  notifyDataSetChanged();
        ProductFragment fragment = new ProductFragment(position, tripSingaltonss.get(position).getProdList(), tripSingaltonss.get(position).getFilterList());
        return fragment;
    }

    @Override
    public int getCount() {
        if (doNotifyDataSetChangedOnce) {
            doNotifyDataSetChangedOnce = false;
            notifyDataSetChanged();
        }

        return count.size();
    }

}
