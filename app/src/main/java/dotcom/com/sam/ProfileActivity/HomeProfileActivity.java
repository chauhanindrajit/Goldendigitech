package dotcom.com.sam.ProfileActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import dotcom.com.sam.Activity.GroomingLastpage;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.SingaltonsClasses.VacccinationSingalton;
import dotcom.com.sam.Utils.PatientDetails;
import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.SingaltonsClasses.HomeSingalton;

public class HomeProfileActivity extends AppCompatActivity {
    ImageView profileImage;
    Button btnBook,button;
    TextView drname,qualifictn,experiance,homefeess,subdoctortype,desctription,locatn,subcharge,sshomefee;
    LinearLayout visitAtHomeLayout,vaccinationLayoput;
    ImageView imag;
    Context context;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_profile);
        drname = (TextView)findViewById(R.id.hdoctname);
        qualifictn = (TextView)findViewById(R.id.hqualification);
        experiance = (TextView)findViewById(R.id.hexperiance);
        homefeess = (TextView)findViewById(R.id.hvisitathomefee);
        subdoctortype =(TextView)findViewById(R.id.hdoctortype);
        subcharge =(TextView)findViewById(R.id.hcharge);
        //opentime = (TextView)findViewById(R.id.availabletime);
        button = findViewById(R.id.btn_bookapointment);
        desctription = (TextView)findViewById(R.id.hdetaildescription);
        locatn = (TextView)findViewById(R.id.hlocation);
        drname.setText(HomeSingalton.getInstance().getDoctorName());
        qualifictn.setText(HomeSingalton.getInstance().getQualification());
        experiance.setText(HomeSingalton.getInstance().getWorkExperience());
        homefeess.setText(String.valueOf(HomeSingalton.getInstance().getAtHomeFees())+"- Visit At Home");
        subdoctortype.setText(HomeSingalton.getInstance().getDoctorType());
       // opentime.setText(HomeSingalton.getInstance().getAvailableTime());
        desctription.setText(HomeSingalton.getInstance().getDescription());
        locatn.setText(HomeSingalton.getInstance().getLocation());
        subcharge.setText(String.valueOf(HomeSingalton.getInstance().getDiagnosticsFees()));
        imag =(ImageView)findViewById(R.id.profile_image);
        //OldpetRequest oldpetRequest= new OldpetRequest();
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
                new DatePickerDialog(HomeProfileActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });
        if (HomeSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + HomeSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
        } else {
            Picasso.with(context).load(R.drawable.noimage).into(imag);

        }


        initView();
        initListner();
        setVisilityView();

    }

    private void setVisilityView() {

        if(PetDoctor.categeory== Constats.VET_AT_HOME)
        {
            visitAtHomeLayout.setVisibility(View.VISIBLE);
            vaccinationLayoput.setVisibility(View.GONE);
        }
        else if(PetDoctor.categeory== Constats.VET_NEAR_ME)
        {
            visitAtHomeLayout.setVisibility(View.GONE);
            vaccinationLayoput.setVisibility(View.GONE);
        }
        else if(PetDoctor.categeory== Constats.VACCINATION)
        {
            visitAtHomeLayout.setVisibility(View.GONE);
            vaccinationLayoput.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        profileImage=findViewById(R.id.profile_image);
       // Bitmap bitmap= BitmapFactory.decodeResource()
        btnBook=findViewById(R.id.btn_bookapointment);
        visitAtHomeLayout=findViewById(R.id.visit_at_home_layout);
        vaccinationLayoput=findViewById(R.id.vaccination_layout);
    }


    private void initListner()
    {

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
        mTimePicker = new TimePickerDialog(HomeProfileActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                SingletonClass.getInstance().setTime(selectedHour + ":" + selectedMinute);
                SingletonClass.getInstance().setCentername(HomeSingalton.getInstance().getDoctorName());
                SingletonClass.getInstance().setSRID(String.valueOf(HomeSingalton.getInstance().getSR_Id()));
                SingletonClass.getInstance().setActivityname("Vet At Home");
                Utils.moveNextWithAnimation(HomeProfileActivity.this, PatientDetails.class);
                //starttime.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
}
