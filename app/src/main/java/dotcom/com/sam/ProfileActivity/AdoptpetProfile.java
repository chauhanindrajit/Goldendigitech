package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.AdoptprofileSingalton;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;

public class AdoptpetProfile extends AppCompatActivity {
Context context;
    TextView name,dogname,loctn,breedname,status,condition,gender,age,ownername,contctno,emailid,lc;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_profile);

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
        //OldpetRequest oldpetRequest= new OldpetRequest();

        if (AdoptprofileSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + AdoptprofileSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(AdoptprofileSingalton.getInstance().getPet_Name());
        dogname.setText(AdoptprofileSingalton.getInstance().getPet_Name());
        loctn.setText(AdoptprofileSingalton.getInstance().getLocation());
        lc.setText(AdoptprofileSingalton.getInstance().getLocation());
        breedname.setText(AdoptprofileSingalton.getInstance().getBreedName());
        status.setText(AdoptprofileSingalton.getInstance().getStatus());
        condition.setText(AdoptprofileSingalton.getInstance().getCondition());
        gender.setText(AdoptprofileSingalton.getInstance().getGender());
        age.setText(AdoptprofileSingalton.getInstance().getAge());
        ownername.setText(AdoptprofileSingalton.getInstance().getOwnerName());
        contctno.setText(String.valueOf(AdoptprofileSingalton.getInstance().getOwnerContact()));
        emailid.setText(AdoptprofileSingalton.getInstance().getOwnerEmail());







    }
}
