package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;
import dotcom.com.sam.request.OldpetRequest;

public class PetOldAgeHomeProfile extends AppCompatActivity {
Context context;
    TextView name,loc,address,petavil,anount,serviceavail,desption;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_old_age_home_profile);

        name=(TextView)findViewById(R.id.oldpname);
        loc=(TextView)findViewById(R.id.oldplocation);
        address=(TextView)findViewById(R.id.oldpaddress);
        petavil=(TextView)findViewById(R.id.oldpetavilvilty);
        anount=(TextView)findViewById(R.id.oldpamont);
        serviceavail=(TextView)findViewById(R.id.oldpserviceavailbilty);
        desption=(TextView)findViewById(R.id.oldpdescription);
        imag =(ImageView)findViewById(R.id.oldpimages);
        //OldpetRequest oldpetRequest= new OldpetRequest();

        if (OldHomeSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + OldHomeSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(OldHomeSingalton.getInstance().getHomeName());
        loc.setText(OldHomeSingalton.getInstance().getLocation());
        address.setText(OldHomeSingalton.getInstance().getAddress());
        petavil.setText(OldHomeSingalton.getInstance().getPetType());
        anount.setText(String.valueOf(OldHomeSingalton.getInstance().getAmount()));
        serviceavail.setText(OldHomeSingalton.getInstance().getServicesType());
        desption.setText(OldHomeSingalton.getInstance().getDescription());


    }
}
