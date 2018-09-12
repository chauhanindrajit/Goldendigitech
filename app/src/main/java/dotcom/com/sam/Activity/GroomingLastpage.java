package dotcom.com.sam.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;

public class GroomingLastpage extends AppCompatActivity {
    Toolbar toolbar;
    EditText time, date;
    Button confirm;

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
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);
        confirm = (Button) findViewById(R.id.confirmbtn);
        time.setText(SingletonClass.getInstance().getTime());
        date.setText(SingletonClass.getInstance().getDate());

        setsummarydialog();

    }

    private void setsummarydialog() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view2 = inflater.inflate(R.layout.summary_dialog_layout, null);
        ImageView imageView = view2.findViewById(R.id.cancle_image);
        Button applyfilter = view2.findViewById(R.id.aplyfilter);
        final RecyclerView filterview = view2.findViewById(R.id.filtrrecyview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view2);
        final AlertDialog dialog = builder.create();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
    }
}