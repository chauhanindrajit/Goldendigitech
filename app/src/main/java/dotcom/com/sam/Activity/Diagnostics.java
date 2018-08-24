package dotcom.com.sam.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dotcom.com.sam.Utils.DiagnosticForm;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.SingaltonsClasses.DiagonsticSingalton;

public class Diagnostics extends AppCompatActivity {
    Button button;
    TextView cntnm, servic, smpltype, pettype, loc, colntime;
    ImageView imag;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostics);
        button = findViewById(R.id.btn_collection);
        cntnm = (TextView) findViewById(R.id.subcentername);
        servic = (TextView) findViewById(R.id.ssericess);
        smpltype = (TextView) findViewById(R.id.ssamtype);
        pettype = (TextView) findViewById(R.id.spettype);
        loc = (TextView) findViewById(R.id.blocation);
        colntime = (TextView) findViewById(R.id.scollectntimess);


        cntnm.setText(DiagonsticSingalton.getInstance().getCenterName());
        servic.setText(DiagonsticSingalton.getInstance().getServices());
        smpltype.setText(DiagonsticSingalton.getInstance().getSampleType());
        pettype.setText(DiagonsticSingalton.getInstance().getPetsType());
        loc.setText(DiagonsticSingalton.getInstance().getLocation());
        colntime.setText(DiagonsticSingalton.getInstance().getSampleCollectionTimeing());

        imag = (ImageView) findViewById(R.id.imgprofile);
        //OldpetRequest oldpetRequest= new OldpetRequest();

        if (DiagonsticSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + DiagonsticSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Diagnostics.this, DiagnosticForm.class);
            }
        });
    }
}
