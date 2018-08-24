package dotcom.com.sam.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;

public class PetDoctor extends AppCompatActivity {

    public static int categeory = 0;
    Button btnVetNearMe, btnVetAtHome, btnDiagnostic, btnVaccination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_doctor);
        btnVetNearMe = findViewById(R.id.btn_vetnear);
        btnVetAtHome = findViewById(R.id.btn_vet_at_home);
        btnDiagnostic = findViewById(R.id.btn_diagnostic);
        btnVaccination = findViewById(R.id.btn_vaccination);

        btnVetNearMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(PetDoctor.this, VetList.class);
                categeory = Constats.VET_NEAR_ME;

            }
        });
        btnVetAtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(PetDoctor.this, HomeList.class);
                categeory = Constats.VET_AT_HOME;
            }
        });
        btnDiagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(PetDoctor.this, DiagoHome.class);
                categeory = Constats.DIAGNOSTICS;
            }
        });
        btnVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(PetDoctor.this, VacccinationHome.class);
                categeory = Constats.VACCINATION;
            }
        });
    }
}
