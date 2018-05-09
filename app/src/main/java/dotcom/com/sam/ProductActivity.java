package dotcom.com.sam;



import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import dotcom.com.sam.Adapters.ProductPagerAdapter;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.fragments.ProductMainFragment;

public class ProductActivity extends AppCompatActivity {
    public  static FragmentManager fragmentManager;
    ViewPager mViewPager;
    Toolbar toolbar;
    ActionBar actionBar;
    TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Utils.setExplodTransition(this);
        initView();

        toolbar=findViewById(R.id.toolbar);
        initView();
        toolbar.setTitle("DOG");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        actionBar=getSupportActionBar();
        fragmentManager=getSupportFragmentManager();



       addTab();


        ProductPagerAdapter productPagerAdapter=new ProductPagerAdapter(fragmentManager,tabLayout.getTabCount());
        mViewPager.setAdapter(productPagerAdapter);

        TabListener();


    }
    private void initView()
    {
        mViewPager=(ViewPager) findViewById(R.id.pager);
        tabLayout=(TabLayout) findViewById(R.id.tablayout);


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


    public void addfragment()
    {
        fragmentManager.beginTransaction().add(R.id.main_conainer,new ProductMainFragment()).commit();
    }


}
