package dotcom.com.sam.ProfileActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.TrainingSingalton;
import dotcom.com.sam.SingaltonsClasses.WalkingSingalton;

public class TrainingProfile extends AppCompatActivity {
   Context context;
    TextView name,address,petavil,anount,desption;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_profile);
        name=(TextView)findViewById(R.id.tpcentername);
        context = TrainingProfile.this;
        address=(TextView)findViewById(R.id.tpaddress);
        anount=(TextView)findViewById(R.id.tpfess);
        desption=(TextView)findViewById(R.id.tpdescription);
        //spec =(TextView)findViewById(R.id.specilist);
        imag =(ImageView)findViewById(R.id.tpimage);
        //OldpetRequest oldpetRequest= new OldpetRequest();
        if (TrainingSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + TrainingSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }
        name.setText(TrainingSingalton.getInstance().getCenterName());
        address.setText(TrainingSingalton.getInstance().getAddress());
        anount.setText(String.valueOf(TrainingSingalton.getInstance().getFees()));
        desption.setText(TrainingSingalton.getInstance().getDiscription());
       // spec.setText("Specialist: "+WalkingSingalton.getInstance().getProfile());
    }
}
