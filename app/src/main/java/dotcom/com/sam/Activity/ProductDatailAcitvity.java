package dotcom.com.sam.Activity;

import android.app.FragmentManager;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.ProductSingalton;
import dotcom.com.sam.fragments.ProdiuctDetailsFragment;

public class ProductDatailAcitvity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fragmentManager;
    FrameLayout container;
    TextView prodctname,actualprce,discountprice;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_datail_acitvity);
        fragmentManager = getSupportFragmentManager();
        container = (FrameLayout) findViewById(R.id.containerFrame);
        fragmentManager.beginTransaction().add(R.id.containerFrame, new ProdiuctDetailsFragment()).commit();




    }
}
