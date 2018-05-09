package dotcom.com.sam;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import dotcom.com.sam.fragments.ProdiuctDetailsFragment;

public class ProductDatailAcitvity extends AppCompatActivity {
android.support.v4.app.FragmentManager fragmentManager;
FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_datail_acitvity);
        fragmentManager=getSupportFragmentManager();
        container=(FrameLayout) findViewById(R.id.containerFrame);
        fragmentManager.beginTransaction().add(R.id.containerFrame,new ProdiuctDetailsFragment()).commit();


    }
}
