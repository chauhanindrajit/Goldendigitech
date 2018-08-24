package dotcom.com.sam.Activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Adapters.BasePhotoAdapter;
import dotcom.com.sam.Adapters.PhotoAdapter;
import dotcom.com.sam.Adapters.PhotoListAdapter;
import dotcom.com.sam.Response.PhotoResponse;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;
import dotcom.com.sam.SingaltonsClasses.PhotoSingalton;
import dotcom.com.sam.SingaltonsClasses.TrainingSingalton;
import dotcom.com.sam.Utils.PhotoMain;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetPhotography extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    LinearLayout photoCountLayout;
    private ProgressDialog pDialog;
    private ArrayList<PhotoSingalton> arrSubCateogry;
    ArrayList tripSingaltonss;
    List<String> suu = new ArrayList<>();
    List<String> url = new ArrayList<>();
    RecyclerView recyclerView;
    ImageView imageView1, imageView2, imageView3, imageView4,imag;
    TextView  actegrry,course,qualifictn,expe,aboutme,morepic;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Context context;
    int id;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_photography);
        context = this;
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tripSingaltonss = new ArrayList<>();
        tripSingaltonss.clear();
        collapsingToolbarLayout =(CollapsingToolbarLayout)findViewById(R.id.profilename);
        actegrry =(TextView)findViewById(R.id.profilecategorye);
        course =(TextView)findViewById(R.id.profiletxtcourse);
        qualifictn =(TextView)findViewById(R.id.profilequalification);
        morepic =(TextView)findViewById(R.id.morephoto);
        expe =(TextView)findViewById(R.id.profileexperiance);
        aboutme =(TextView)findViewById(R.id.profileaboutme);
        imag =(ImageView)findViewById(R.id.photoprofileimage) ;
        collapsingToolbarLayout.setTitle(GetPhotograpgySingalton.getInstance().getName());
        actegrry.setText(GetPhotograpgySingalton.getInstance().getPhotographerCategory());
        course.setText(GetPhotograpgySingalton.getInstance().getCourses());
        qualifictn.setText(GetPhotograpgySingalton.getInstance().getQualification());
        expe.setText(GetPhotograpgySingalton.getInstance().getExp());
        aboutme.setText(GetPhotograpgySingalton.getInstance().getAbout());
        if (GetPhotograpgySingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + GetPhotograpgySingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        initView();
        id=GetPhotograpgySingalton.getInstance().getPG_Id();
        checkAcceptTrip();
        setRecyclerviewPhoto();
        recyclerView.setNestedScrollingEnabled(false);
    }

    private void setRecyclerviewPhoto() {
        BasePhotoAdapter basePhotoAdapter=new BasePhotoAdapter(this,url);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 2);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(PetPhotography.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(basePhotoAdapter);
    }

    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();
        final String siteurl = Utils.getStringUserPreference(PetPhotography.this, Constants.SITE_URL);
        Log.e("", "siterurl" + siteurl);
        pDialog = new ProgressDialog(PetPhotography.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<PhotoResponse> photoResponseCall = Utilss.getWebService().PHOTO_RESPONSE_CALL();
        photoResponseCall.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                pDialog.hide();
                if (url.size() > 0) {
                    url.clear();
                }
                if (response.code() == 200) {
                    PhotoResponse photoResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < photoResponse.getResponse().size(); i++) {
                       if(photoResponse.getResponse().get(i).getPG_Id()==id){
                        PhotoSingalton photoSingalton = new PhotoSingalton();
                        photoSingalton.setName(photoResponse.getResponse().get(i).getName());
                        photoSingalton.setLocation(photoResponse.getResponse().get(i).getLocation());
                        photoSingalton.setPhotographerCategory(photoResponse.getResponse().get(i).getPhotographerCategory());
                        photoSingalton.setQualification(photoResponse.getResponse().get(i).getQualification());
                        photoSingalton.setAbout(photoResponse.getResponse().get(i).getAbout());
                        photoSingalton.setCourses(photoResponse.getResponse().get(i).getCourses());
                        photoSingalton.setExp(photoResponse.getResponse().get(i).getExp());
                        photoSingalton.setImage(photoResponse.getResponse().get(i).getImage());
                        photoSingalton.setMultipalImage(photoResponse.getResponse().get(i).getMultipalImage());
                        if (photoResponse.getResponse().get(i).getImgUrl().size()<=0){
                            Utils.customMessage(PetPhotography.this,"Opps!! No Image Found");
                            //  finish();
                        }
                        Log.e("Gallery", "galleryList" + photoResponse.getResponse().get(i).getImgUrl().size());
                        // List<String> url = new ArrayList<>();
                        for (int j = 0; j < photoResponse.getResponse().get(i).getImgUrl().size(); j++) {
                            url.add("http://mrsam.in/sam/PhotographerImages/" + "" + photoResponse.getResponse().get(i).getImgUrl().get(j));
                        }

                        if (photoResponse.getResponse().get(i).getImgUrl().size() >= 4) {
                            morepic.setText(String.valueOf(photoResponse.getResponse().get(i).getImgUrl().size()-4));
                        } else {
                            morepic.setText("0");
                        }
                        if (photoResponse.getResponse().get(i).getImgUrl().size() > 4) {
                            setListners();
                        }
                        tripSingaltonss.add(photoSingalton);
                        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setAdapter(new BasePhotoAdapter(PetPhotography.this, url));

                    }}

                } else if (response.code() == 404) {
                    pDialog.hide();
                    Utils.customMessage(PetPhotography.this, "Sorry no data found.!!");
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

    private void setListners() {

        photoCountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetPhotograpgySingalton.getInstance().setPG_Id(id);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(PetPhotography.this);
                Intent intent = new Intent(PetPhotography.this, PhotoViewerMutiple.class);
                intent.putExtra("comeFrom", "petPhotography");
                startActivity(intent, activityOptions.toBundle());
            }
        });
    }

    private void initView() {
        photoCountLayout = findViewById(R.id.photo_count_layout);
//        imageView1 = findViewById(R.id.imageView1);
//        imageView2 = findViewById(R.id.imageView2);
//        imageView3 = findViewById(R.id.imageView3);
//        imageView4 = findViewById(R.id.imageView4);
        recyclerView=findViewById(R.id.recyclerview);
    }


}
