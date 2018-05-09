package dotcom.com.sam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import dotcom.com.sam.Adapters.BuyPetAdapter;
import dotcom.com.sam.Adapters.ProductAdapter;

public class BuyPetList extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_pet_list);
        recyclerView=(RecyclerView)findViewById(R.id.recylcerview_products);

        setRecyclerviewProduct();
    }


    private  void setRecyclerviewProduct()
    {
        //   recyclerView
        BuyPetAdapter productAdapter=new BuyPetAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);


    }
}
