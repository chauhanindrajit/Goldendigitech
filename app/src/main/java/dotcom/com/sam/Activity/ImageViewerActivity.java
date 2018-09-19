package dotcom.com.sam.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.GetPhotograpgySingalton;

public class ImageViewerActivity extends AppCompatActivity {
    ImageView imageView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (GetPhotograpgySingalton.getInstance().getImgUrl() != null) {
            String i = (GetPhotograpgySingalton.getInstance().getImgUrl());
            Picasso.with(context).load(i).placeholder(R.drawable.progress_animation).into(imageView);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imageView);

        }
    }
}
