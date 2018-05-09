package dotcom.com.sam.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dotcom.com.sam.fragments.ProductFragment;

/**
 * Created by sanjay on 3/12/2018.
 */

public class ProductPagerAdapter extends FragmentPagerAdapter {
int count;

    public ProductPagerAdapter(FragmentManager fm,int count) {
        super(fm);
        this.count=count;
    }

    @Override
    public Fragment getItem(int position) {
        ProductFragment fragment=new ProductFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return count;
    }
}
