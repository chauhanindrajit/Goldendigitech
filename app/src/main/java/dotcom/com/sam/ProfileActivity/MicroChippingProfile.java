package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.MicroChippingSingalton;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;

public class MicroChippingProfile extends AppCompatActivity {
Context context;
    TextView name,loc,address,petavil,anount,serviceavail,desption;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microchipping_profile);
        name=(TextView)findViewById(R.id.oldpname);
        address=(TextView)findViewById(R.id.oldpaddress);
        anount=(TextView)findViewById(R.id.oldpamont);
        desption=(TextView)findViewById(R.id.oldpdescription);
        imag =(ImageView)findViewById(R.id.oldpimages);
        //OldpetRequest oldpetRequest= new OldpetRequest();
        if (MicroChippingSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + MicroChippingSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(MicroChippingSingalton.getInstance().getCenterName());
        address.setText(MicroChippingSingalton.getInstance().getAddress());
        anount.setText(String.valueOf(MicroChippingSingalton.getInstance().getFees()));
        desption.setText(MicroChippingSingalton.getInstance().getDescription());


    }
}
