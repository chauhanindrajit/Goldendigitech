package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.Adapters.BasePhotoAdapter;
import dotcom.com.sam.Adapters.PhotoListAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.PhotoResponse;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;
import dotcom.com.sam.SingaltonsClasses.PhotoSingalton;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoViewerMutiple extends AppCompatActivity {
    RecyclerView recyclerView;
    private ProgressDialog pDialog;
    private ArrayList<PhotoSingalton> arrSubCateogry;
    ArrayList tripSingaltonss;
    List<String> suu = new ArrayList<>();
    List<String> url = new ArrayList<>();
    Toolbar toolbar;
    int id;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer_mutiple);
        initView();
        setRecyclerviewPhoto();
        checkAcceptTrip();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Photography");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        id = GetPhotograpgySingalton.getInstance().getPG_Id();
    }

    private void setRecyclerviewPhoto() {
        PhotoListAdapter photoAdapter = new PhotoListAdapter(this, suu);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        //  LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.Gr, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(photoAdapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();
        final String siteurl = Utils.getStringUserPreference(PhotoViewerMutiple.this, Constants.SITE_URL);
        Log.e("", "siterurl" + siteurl);
        pDialog = new ProgressDialog(PhotoViewerMutiple.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<PhotoResponse> photoResponseCall = Utilss.getWebService().PHOTO_RESPONSE_CALL();
        photoResponseCall.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                pDialog.dismiss();
                if (url.size() > 0) {
                    url.clear();
                }
                if (response.code() == 200) {
                    PhotoResponse photoResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < photoResponse.getResponse().size(); i++) {
                        if (photoResponse.getResponse().get(i).getPG_Id() == id) {
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
                            if (photoResponse.getResponse().get(i).getImgUrl().size() <= 0) {
                                Utils.customMessage(PhotoViewerMutiple.this, "Opps!! No Image Found");
                                //      finish();
                            }
                            Log.e("Gallery", "galleryList" + photoResponse.getResponse().get(i).getImgUrl().size());
                            for (int j = 0; j < photoResponse.getResponse().get(i).getImgUrl().size(); j++) {
                                suu.add("http://mrsam.in/sam/PhotographerImages/" + "" + photoResponse.getResponse().get(i).getImgUrl().get(j));
                                url.add("http://mrsam.in/sam/PhotographerImages/" + "" + photoResponse.getResponse().get(i).getImgUrl().get(j));
                            }
                            // url.add("http://mrsam.in/sam/PhotographerImages/" + "" + photoResponse.getResponse().get(i).getMultipalImage());
                            //tripSingaltonss.add(photoSingalton);
                            mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setAdapter(new PhotoListAdapter(PhotoViewerMutiple.this, url));
                        }
                    }
                } else if (response.code() == 404) {
                    pDialog.dismiss();
                    Utils.customMessage(PhotoViewerMutiple.this, "Sorry no data found.!!");
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }
}
