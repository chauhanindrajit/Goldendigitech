package dotcom.com.sam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;

public class Adoption extends AppCompatActivity {

    Button btnBuyPet,btnAdoptPet,btnOldAgeHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
        btnBuyPet=findViewById(R.id.btn_buy_pet);
        btnAdoptPet=findViewById(R.id.btn_adopt_pet);
        btnOldAgeHome=findViewById(R.id.btn_old_age_home);

        btnAdoptPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this,VetList.class);
                MainActivity.module_name= Constats.Module.ADOPTED;
            }
        });

        btnBuyPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this,BuyPetList.class);
                MainActivity.module_name= Constats.Module.BUY_PET;
            }
        });

    }
}
