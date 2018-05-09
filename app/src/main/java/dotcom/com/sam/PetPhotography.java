package dotcom.com.sam;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;

public class PetPhotography extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    LinearLayout photoCountLayout;
    ImageView imageView1,imageView2,imageView3,imageView4;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_photography);
        context=this;
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        initView();
        setListners();
    }

    private void setListners() {
        photoCountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions= ActivityOptions.makeSceneTransitionAnimation(PetPhotography.this);
                Intent intent=new Intent(PetPhotography.this,PhotoMain.class);
                intent.putExtra("comeFrom","petPhotography");
                startActivity(intent,activityOptions.toBundle());
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,imageView1,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,imageView2,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,imageView3,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation((Activity) context,imageView4,"image");
                Intent intent=new Intent(context,ImageViewerActivity.class);
                context.startActivity(intent,activityOptions.toBundle());
            }
        });
    }

    private void initView() {
        photoCountLayout=findViewById(R.id.photo_count_layout);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);

    }



}
