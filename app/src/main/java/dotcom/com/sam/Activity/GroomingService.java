package dotcom.com.sam.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.R;

public class GroomingService extends AppCompatActivity {
    Toolbar toolbar;
    Button btn_doggr, btn_catgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming_service);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Grooming Services");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_doggr = (Button) findViewById(R.id.btn_dog_groming);
        btn_catgr = (Button) findViewById(R.id.btn_cat_grooming);

        btn_doggr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GroomingService.this, DogGrooming.class);
                startActivity(i);
            }
        });
        btn_catgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GroomingService.this, CatGrooming.class);
                startActivity(i);
            }
        });

    }
}
