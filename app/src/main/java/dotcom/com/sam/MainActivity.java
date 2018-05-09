package dotcom.com.sam;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.Adapters.NewArrivalAdapter;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;


public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
RecyclerView recyclerView;
Button btn_shopBypet,btn_vet,btn_mate,btn_adobpet,btn_photo;
public static int module_name=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);

        //setTransition
         Utils.setExplodTransition(this);

        initView();
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setRecyclerView();
        buttonClickEvent();

    }


    void initView()
    {
        recyclerView=(RecyclerView) findViewById(R.id.recylcerview_newarrival);
        btn_shopBypet= (Button) findViewById(R.id.btn_shobypet);
        btn_vet=(Button)findViewById(R.id.btn_vet);
        btn_mate=findViewById(R.id.btn_mating);
        btn_adobpet=findViewById(R.id.btn_adopt);
        btn_photo=findViewById(R.id.btn_photo);
    }


    void setRecyclerView()
    {
        NewArrivalAdapter newArrivalAdapter=new NewArrivalAdapter(MainActivity.this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(newArrivalAdapter);
    }


    private void buttonClickEvent()
    {
        btn_shopBypet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getApplicationContext(),Categeory.class);
               // startActivity(intent);
                Utils.moveNextWithAnimation(MainActivity.this,Categeory.class);
                module_name=0;
            }
        });
        btn_vet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this,PetDoctor.class);
                module_name=0;
            }
        });
        btn_mate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this,VetList.class);
                module_name= Constats.Module.MATING;
            }
        });

        btn_adobpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this,Adoption.class);
                /*Utils.moveNextWithAnimation(MainActivity.this,VetList.class);
                module_name= Constats.Module.ADOPTED;
    */
            }
        });
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this,PhotoMain.class);
                module_name= Constats.Module.PHOTO;
            }
        });
    }
}
