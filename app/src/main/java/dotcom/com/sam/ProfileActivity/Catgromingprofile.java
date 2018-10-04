package dotcom.com.sam.ProfileActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import dotcom.com.sam.Activity.CatGrooming;
import dotcom.com.sam.Activity.CatGroomingLastpage;
import dotcom.com.sam.Activity.GroomingLastpage;
import dotcom.com.sam.R;
import dotcom.com.sam.SingaltonsClasses.CatSingalton;
import dotcom.com.sam.SingaltonsClasses.DogSingalton;
import dotcom.com.sam.SingaltonsClasses.MicroChippingSingalton;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;

public class Catgromingprofile extends AppCompatActivity {
    Button button;
    TextView cntnm, servic, smpltype, pettype, loc, colntime;
    Toolbar toolbar;
    ImageView imag;
    Context context;
    String ID;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgromingprofile);
        button = findViewById(R.id.btn_bookpackage);
        cntnm = (TextView) findViewById(R.id.subcentername);
        servic = (TextView) findViewById(R.id.ssericess);
        smpltype = (TextView) findViewById(R.id.ssamtype);
        pettype = (TextView) findViewById(R.id.spettype);
        loc = (TextView) findViewById(R.id.blocation);
        colntime = (TextView) findViewById(R.id.scollectntimess);
        imag = (ImageView) findViewById(R.id.img);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CatGrooming");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cntnm.setText(CatSingalton.getInstance().getCenterName());
        ID= String.valueOf(CatSingalton.getInstance().getGroomingService_Id());
        Log.e("IDDD", "onCreate: "+ID);
        //OldpetRequest oldpetRequest= new OldpetRequest();
        if (CatSingalton.getInstance().getImages() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + CatSingalton.getInstance().getImages().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);
        }

//        cntnm.setText(DiagonsticSingalton.getInstance().getCenterName());
//        servic.setText(DiagonsticSingalton.getInstance().getServices());
//        smpltype.setText(DiagonsticSingalton.getInstance().getSampleType());
//        pettype.setText(DiagonsticSingalton.getInstance().getPetsType());
//        loc.setText(DiagonsticSingalton.getInstance().getLocation());
//        colntime.setText(DiagonsticSingalton.getInstance().getSampleCollectionTimeing());


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Catgromingprofile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        SingletonClass.getInstance().setDate(sdf.format(myCalendar.getTime()));
        // getdate.setText(sdf.format(myCalendar.getTime()));
        getTime();
        // enddtae.setText(sdf.format(myCalendar.getTime()));
    }

    void getTime() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        int second = mcurrentTime.get(Calendar.SECOND);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(Catgromingprofile.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                SingletonClass.getInstance().setTime(selectedHour + ":" + selectedMinute);
                Utils.moveNextWithAnimation(Catgromingprofile.this, GroomingLastpage.class);
                //starttime.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

}
