package dotcom.com.sam.ProfileActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dotcom.com.sam.Activity.CatGrooming;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;

public class Catgromingprofile extends AppCompatActivity {
    Button button;
    TextView cntnm,servic,smpltype,pettype,loc,colntime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgromingprofile);
        button= findViewById(R.id.btn_collection);
        cntnm=(TextView)findViewById(R.id.subcentername);
        servic=(TextView)findViewById(R.id.ssericess);
        smpltype=(TextView)findViewById(R.id.ssamtype);
        pettype=(TextView)findViewById(R.id.spettype);
        loc=(TextView)findViewById(R.id.blocation);
        colntime=(TextView)findViewById(R.id.scollectntimess);


//        cntnm.setText(DiagonsticSingalton.getInstance().getCenterName());
//        servic.setText(DiagonsticSingalton.getInstance().getServices());
//        smpltype.setText(DiagonsticSingalton.getInstance().getSampleType());
//        pettype.setText(DiagonsticSingalton.getInstance().getPetsType());
//        loc.setText(DiagonsticSingalton.getInstance().getLocation());
//        colntime.setText(DiagonsticSingalton.getInstance().getSampleCollectionTimeing());




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Catgromingprofile.this,CatGrooming.class);
            }
        });
    }
}
