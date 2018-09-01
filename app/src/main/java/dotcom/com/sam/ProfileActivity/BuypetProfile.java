package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.Activity.Buypetlast;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.BuypetprofileSingalton;

public class BuypetProfile extends AppCompatActivity {
Context context;
Button enuirynow;
    TextView name,dogname,loctn,breedname,status,condition,gender,age,ownername,contctno,emailid,lc;
    ImageView imag;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buypet_profile);

        name=(TextView)findViewById(R.id.apname);
        dogname=(TextView)findViewById(R.id.apdogname);
        loctn=(TextView)findViewById(R.id.aplocatn);
        breedname=(TextView)findViewById(R.id.apbreedname);
        status=(TextView)findViewById(R.id.apstatus);
        lc=(TextView)findViewById(R.id.aplocatnn);
        condition=(TextView)findViewById(R.id.aphealth);
        gender=(TextView)findViewById(R.id.apgender);
        age=(TextView)findViewById(R.id.apage);
        ownername=(TextView)findViewById(R.id.apowenername);
        contctno=(TextView)findViewById(R.id.apcontctno);
        emailid=(TextView)findViewById(R.id.apemailid);
        imag =(ImageView)findViewById(R.id.profile_image);
        enuirynow=(Button)findViewById(R.id.btn_enuiry);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Buy Pet ");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //OldpetRequest oldpetRequest= new OldpetRequest();

        if (BuypetprofileSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + BuypetprofileSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(BuypetprofileSingalton.getInstance().getPet_Name());
        dogname.setText(BuypetprofileSingalton.getInstance().getPet_Name());
        loctn.setText(BuypetprofileSingalton.getInstance().getLocation());
        lc.setText(BuypetprofileSingalton.getInstance().getLocation());
        breedname.setText(BuypetprofileSingalton.getInstance().getBreedName());
        status.setText(BuypetprofileSingalton.getInstance().getStatus());
        condition.setText(BuypetprofileSingalton.getInstance().getCondition());
        gender.setText(BuypetprofileSingalton.getInstance().getGender());
        age.setText(BuypetprofileSingalton.getInstance().getAge());
        ownername.setText(BuypetprofileSingalton.getInstance().getOwnerName());
        contctno.setText(String.valueOf(BuypetprofileSingalton.getInstance().getOwnerContact()));
        emailid.setText(BuypetprofileSingalton.getInstance().getOwnerEmail());



enuirynow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(BuypetProfile.this, Buypetlast.class);
        startActivity(i);
    }
});



    }
}
