package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.Activity.DogGrooming;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.MicroChippingSingalton;
import dotcom.com.sam.SingaltonsClasses.PetsetterprofileSingalton;
import dotcom.com.sam.Utils.Utils;

public class Petsetterprofileprofile extends AppCompatActivity {
    Button button;
    TextView cntnm, descptin, availbity, fees, loc, colntime;
    ImageView imag;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petsetter_profile);
        button = findViewById(R.id.btn_collection);
        cntnm = (TextView) findViewById(R.id.setllepname);
        descptin = (TextView) findViewById(R.id.settleprdesption);
        availbity = (TextView) findViewById(R.id.petavilbityprofile);
        imag = (ImageView) findViewById(R.id.petstlimages);
        fees = (TextView) findViewById(R.id.settleprofilefee);
        loc = (TextView) findViewById(R.id.petsetprofloc);

        if (PetsetterprofileSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + PetsetterprofileSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }

        cntnm.setText(PetsetterprofileSingalton.getInstance().getName());
        descptin.setText(PetsetterprofileSingalton.getInstance().getDescription());
        availbity.setText("Pet Availability:" + String.valueOf(PetsetterprofileSingalton.getInstance().getPetAvailability()));
        fees.setText(String.valueOf(PetsetterprofileSingalton.getInstance().getFees()));
        loc.setText(PetsetterprofileSingalton.getInstance().getAddress());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Petsetterprofileprofile.this, DogGrooming.class);
            }
        });
    }
}
