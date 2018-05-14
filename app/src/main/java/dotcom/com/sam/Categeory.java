package dotcom.com.sam;

import android.graphics.Color;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import dotcom.com.sam.Adapters.CatregeoryAdapter;
import dotcom.com.sam.Utils.Utils;

public class Categeory extends AppCompatActivity {
    RecyclerView categeoryLayout,SubCtegeryLayout;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categeory);
        Utils.setExplodTransition(this);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onBackPressed();
            }
        });



        intitView();
        setCategeoryLayout();

    }

    private void intitView()
    {
        categeoryLayout=(RecyclerView) findViewById(R.id.categeoryLayout);
    }

    void setCategeoryLayout()
    {
           CatregeoryAdapter catregeoryAdapterr=new CatregeoryAdapter(Categeory.this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);
        categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
        categeoryLayout.setAdapter(catregeoryAdapterr);


    }
}

