package dotcom.com.sam.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;

public class Adoption extends AppCompatActivity {

    Button btngromg, btntraing, btnsitel, btnmicrocgip;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Pet Services");
        btngromg = (Button) findViewById(R.id.btngroming);
        btnsitel = (Button) findViewById(R.id.btnsitter);
        btnmicrocgip = (Button) findViewById(R.id.btn_micochipping);
        btntraing = (Button) findViewById(R.id.btn_traing_services);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btngromg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this, GroomingService.class);
                //MainActivity.module_name= Constats.Module.ADOPTED;
            }
        });
        btnmicrocgip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this, MicroChipping.class);
                //MainActivity.module_name= Constats.Module.ADOPTED;
            }
        });
        btnsitel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this, PetSitterWalking.class);
                //MainActivity.module_name= Constats.Module.ADOPTED;
            }
        });
        btntraing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(Adoption.this, TrainigServices.class);
            }
        });
//
//        btnBuyPet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Utils.moveNextWithAnimation(Adoption.this,BuyPetList.class);
//                MainActivity.module_name= Constats.Module.BUY_PET;
//            }
//        });
//
//        btnOldAgeHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Utils.moveNextWithAnimation(Adoption.this,PetOldAgeHome.class);
//              //  MainActivity.module_name= Constats.Module.PET_OLDAGE_HOME;
//            }
//        });

    }
}
