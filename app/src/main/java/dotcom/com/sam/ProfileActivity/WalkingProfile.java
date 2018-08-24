package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.MicroChippingSingalton;
import dotcom.com.sam.SingaltonsClasses.WalkingSingalton;

public class WalkingProfile extends AppCompatActivity {
   Context context;
    TextView name,spec,address,petavil,anount,serviceavail,desption;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking_profile);
        name=(TextView)findViewById(R.id.wpname);
        context = WalkingProfile.this;
        address=(TextView)findViewById(R.id.wpaddress);
        anount=(TextView)findViewById(R.id.wpfees);
        desption=(TextView)findViewById(R.id.wpdescription);
        spec =(TextView)findViewById(R.id.specilist);
        imag =(ImageView)findViewById(R.id.wpimage);
        //OldpetRequest oldpetRequest= new OldpetRequest();
        if (WalkingSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + WalkingSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(WalkingSingalton.getInstance().getName());
        address.setText(WalkingSingalton.getInstance().getAddress());
        anount.setText(String.valueOf(WalkingSingalton.getInstance().getPerDayCost()));
        desption.setText(WalkingSingalton.getInstance().getDescription());
        spec.setText("Specialist: "+WalkingSingalton.getInstance().getProfile());


    }
}
