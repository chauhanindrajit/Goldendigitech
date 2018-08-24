package dotcom.com.sam.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.R;

public class PetSitterWalking extends AppCompatActivity {
    Toolbar toolbar;
    Button btn_sitter, btn_walking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settleandwalking_service);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Pet Sitter & Walking");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_sitter = (Button) findViewById(R.id.btn_petsitter);
        btn_walking = (Button) findViewById(R.id.btn_petwalking);

        btn_sitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PetSitterWalking.this, PetSetter.class);
                startActivity(i);
            }
        });
        btn_walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PetSitterWalking.this, PetWalking.class);
                startActivity(i);
            }
        });

    }
}
