package dotcom.com.sam.Utils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Adapters.PhotoAdapter;
import dotcom.com.sam.Adapters.PhotoListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.PhotoResponse;
import dotcom.com.sam.SingaltonsClasses.PhotoSingalton;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoMain extends AppCompatActivity {

    RecyclerView recyclerView;
    private ProgressDialog pDialog;
    private ArrayList<PhotoSingalton> arrSubCateogry;
    ArrayList tripSingaltonss;
    List<String> suu = new ArrayList<>();
    Toolbar toolbar;
    List<String> url = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_main);

        initView();

        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();

        if (Utils.isOnline(PhotoMain.this)) {

            checkAcceptTrip();

        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PhotoMain.this);
            builder.setTitle("Internet problem");
            builder.setMessage("Oops! seems you have lost internet connectivity. Please try again later.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            android.app.AlertDialog alert = builder.create();
            alert.show();
            Button nbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
            nbutton.setTextColor(Color.rgb(30, 144, 255));
        }

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("PetPhotography");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
        PhotoListAdapter photoAdapter=new PhotoListAdapter(this,suu);
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
        PhotoAdapter photoAdapter=new PhotoAdapter(this,arrSubCateogry);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(photoAdapter);

    }
    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();

        pDialog = new ProgressDialog(PhotoMain.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<PhotoResponse> photoResponseCall = Utilss.getWebService().PHOTO_RESPONSE_CALL();
        photoResponseCall.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                pDialog.hide();
                if (response.code() == 200) {
                    PhotoResponse photoResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < photoResponse.getResponse().size(); i++) {

                        PhotoSingalton photoSingalton = new PhotoSingalton();
                        photoSingalton.setName(photoResponse.getResponse().get(i).getName());
                        photoSingalton.setLocation(photoResponse.getResponse().get(i).getLocation());
                        photoSingalton.setPhotographerCategory(photoResponse.getResponse().get(i).getPhotographerCategory());
                        photoSingalton.setQualification(photoResponse.getResponse().get(i).getQualification());
                        photoSingalton.setAbout(photoResponse.getResponse().get(i).getAbout());
                        photoSingalton.setCourses(photoResponse.getResponse().get(i).getCourses());
                        photoSingalton.setExp(photoResponse.getResponse().get(i).getExp());
                        photoSingalton.setMultipalImage(photoResponse.getResponse().get(i).getMultipalImage());
                        photoSingalton.setImage(photoResponse.getResponse().get(i).getImage());
                        photoSingalton.setImgUrl(photoResponse.getResponse().get(i).getImgUrl());
                        photoSingalton.setPG_Id(photoResponse.getResponse().get(i).getPG_Id());
                        tripSingaltonss.add(photoSingalton);
                        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setAdapter(new PhotoAdapter(PhotoMain.this, tripSingaltonss));

                    }

                } else if (response.code() == 404) {
                    pDialog.hide();
                    Utils.customMessage(PhotoMain.this, "Sorry no data found.!!");
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }
}
