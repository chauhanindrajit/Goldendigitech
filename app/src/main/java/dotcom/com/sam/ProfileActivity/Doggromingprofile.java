package dotcom.com.sam.ProfileActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dotcom.com.sam.Adapters.PackageAdapter;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DogcatpackageResponse;
import dotcom.com.sam.SingaltonsClasses.CatSingalton;
import dotcom.com.sam.SingaltonsClasses.DogSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Doggromingprofile extends AppCompatActivity {
    Button button;
    TextView cntnm, servic, smpltype, pettype, loc, colntime;
    Toolbar toolbar;
    ImageView imag;
    Context context;
    RecyclerView recyclerView;
    List<DogcatpackageResponse.ResponseBean> mainrespose = new ArrayList<>();
    public static List<DogcatpackageResponse.ResponseBean.GroomingPackagesBean> arrSubCateogry;
    private ProgressDialog pDialog;
    String ID;
    List<String> agearray = new ArrayList<>();
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doggromingprofile);
        button = findViewById(R.id.btn_bookpackage);
        cntnm = (TextView) findViewById(R.id.subcentername);
        servic = (TextView) findViewById(R.id.ssericess);
        smpltype = (TextView) findViewById(R.id.ssamtype);
        pettype = (TextView) findViewById(R.id.spettype);
        imag = (ImageView) findViewById(R.id.img);
        loc = (TextView) findViewById(R.id.blocation);
        colntime = (TextView) findViewById(R.id.scollectntimess);
        recyclerView = (RecyclerView) findViewById(R.id.recylcerview_newarrival);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("DogGrooming");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cntnm.setText(DogSingalton.getInstance().getCenterName());
        if (SingletonClass.getInstance().getPackagename().equals("Cat")) {
            cntnm.setText(CatSingalton.getInstance().getCenterName());
            ID = String.valueOf(CatSingalton.getInstance().getGroomingService_Id());
            checkAcceptTrip(ID);
        } else if (SingletonClass.getInstance().getPackagename().equals("Dog")) {
            cntnm.setText(DogSingalton.getInstance().getCenterName());
            ID = String.valueOf(DogSingalton.getInstance().getGroomingService_Id());
            checkAcceptTrip(ID);
        }
        Log.e("IDDD", "onCreate: " + ID);

        if (DogSingalton.getInstance().getImages() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + DogSingalton.getInstance().getImages().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);
        }

    }

    void setRecyclerView() {
        PackageAdapter packageAdapter = new PackageAdapter(this, arrSubCateogry, mainrespose);
        packageAdapter.getItemCount();
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(Doggromingprofile.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.setAdapter(packageAdapter);
    }

    private void checkAcceptTrip(String ID) {

        pDialog = new ProgressDialog(Doggromingprofile.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        final Call<DogcatpackageResponse> dogcatpackageResponseCall = Utilss.getWebService().DOGCATPACKAGE_RESPONSE_CALL(ID);
        dogcatpackageResponseCall.enqueue(new Callback<DogcatpackageResponse>() {
            @Override
            public void onResponse(Call<DogcatpackageResponse> call, Response<DogcatpackageResponse> response) {
                pDialog.dismiss();
                if (response.code() == 200) {
                    DogcatpackageResponse dogcatpackageResponse = response.body();
                    Log.e("dioglist", new GsonBuilder().create().toJson(response));
                    for (int i = 0; i < dogcatpackageResponse.getResponse().size(); i++) {

                        PackageAdapter packageAdapter = new PackageAdapter(Doggromingprofile.this, dogcatpackageResponse.getResponse().get(i).getGroomingPackages(),dogcatpackageResponse.getResponse());
                        packageAdapter.getItemCount();
                        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(Doggromingprofile.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(verticalLayoutManager);
                        recyclerView.setAdapter(packageAdapter);
                        recyclerView.getLayoutManager().setMeasurementCacheEnabled(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<DogcatpackageResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }
}
