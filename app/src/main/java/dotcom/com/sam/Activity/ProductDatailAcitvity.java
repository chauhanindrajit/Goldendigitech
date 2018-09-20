package dotcom.com.sam.Activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.CategorySingalton;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.fragments.ProdiuctDetailsFragment;

public class ProductDatailAcitvity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fragmentManager;
    FrameLayout container;
    TextView prodctname, actualprce, discountprice;
    ImageView image;
    Toolbar toolbar;
    public static TextView nodat, conting;
    private static int cart_count = 10;
    ImageView addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_datail_acitvity);
        fragmentManager = getSupportFragmentManager();
        container = (FrameLayout) findViewById(R.id.containerFrame);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setTitle(CategorySingalton.getInstance().getCategosryName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        fragmentManager.beginTransaction().add(R.id.containerFrame, new ProdiuctDetailsFragment()).commit();
        addtocart = (ImageView) findViewById(R.id.addtocard);
        conting = (TextView) findViewById(R.id.count);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ProductDatailAcitvity.this);
        String value = sharedPreferences.getString("COU", "");
        if (value.equals("") || value.isEmpty() || value.equals("0")) {
            // not having user id
            conting.setVisibility(View.GONE);
        } else {
            conting.setText(String.valueOf(value));
            // user id is available
        }
        // conting.setText(String.valueOf(cart_count));
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDatailAcitvity.this, ReviewOrderActivity.class);
                startActivity(i);
            }
        });


    }
}
