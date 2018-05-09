package dotcom.com.sam;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import dotcom.com.sam.Utils.Constats;

public class PatientDetails extends AppCompatActivity {
    LinearLayout vet_near_layout;
    TextInputLayout vet_at_home_address_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        initView();
        setVisiblityLayout();
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
