package dotcom.com.sam.Utils;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Constats;

public class PatientDetails extends AppCompatActivity {
    LinearLayout vet_near_layout;
    TextInputLayout vet_at_home_address_layout;
    TextView time,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        initView();
        setVisiblityLayout();
        time =(TextView)findViewById(R.id.patenttime);
        date =(TextView)findViewById(R.id.patentdate);

        time.setText(SingletonClass.getInstance().getTime());
        date.setText(SingletonClass.getInstance().getDate());
    }


    private void initView()
    {
        vet_near_layout=findViewById(R.id.vet_near_layout);
        vet_at_home_address_layout=findViewById(R.id.vet_at_home_address_layout);


    }

    private  void setVisiblityLayout(){
        if(PetDoctor.categeory== Constats.VET_NEAR_ME||PetDoctor.categeory== Constats.VACCINATION)
        {
            vet_at_home_address_layout.setVisibility(View.GONE);
            vet_near_layout.setVisibility(View.VISIBLE);
        }
        else if(PetDoctor.categeory== Constats.VET_AT_HOME)
        {
            vet_near_layout.setVisibility(View.GONE);
            vet_at_home_address_layout.setVisibility(View.VISIBLE);
        }



    }
}
