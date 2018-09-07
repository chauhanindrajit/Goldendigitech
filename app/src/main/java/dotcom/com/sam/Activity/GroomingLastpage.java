package dotcom.com.sam.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;

public class GroomingLastpage extends AppCompatActivity {
    Toolbar toolbar;
    EditText time,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming_lastpage);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("DogGrooming");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        time=(EditText)findViewById(R.id.time);
        date=(EditText)findViewById(R.id.date);

        time.setText(SingletonClass.getInstance().getTime());
        date.setText(SingletonClass.getInstance().getDate());
    }
}
