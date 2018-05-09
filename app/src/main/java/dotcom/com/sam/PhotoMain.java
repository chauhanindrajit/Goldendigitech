package dotcom.com.sam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import dotcom.com.sam.Adapters.PhotoAdapter;
import dotcom.com.sam.Adapters.PhotoListAdapter;
import dotcom.com.sam.Adapters.ProductAdapter;

public class PhotoMain extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_main);
        initView();


        if(getIntent().getStringExtra("comeFrom")==null)
        {
            setRecyclerviewProduct();
        }
        else
            {
                setRecyclerviewPhoto();
            }
    }

    private void setRecyclerviewPhoto() {
        PhotoListAdapter photoAdapter=new PhotoListAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 3);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(photoAdapter);
    }

    private void initView() {
        recyclerView=findViewById(R.id.recyclerview);
    }

    private  void setRecyclerviewProduct()
    {
        //   recyclerView
        PhotoAdapter photoAdapter=new PhotoAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(photoAdapter);

    }
}
