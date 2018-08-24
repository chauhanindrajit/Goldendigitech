package dotcom.com.sam.ProfileActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.squareup.picasso.Picasso;

import java.util.Calendar;

import dotcom.com.sam.Activity.PetDoctor;
import dotcom.com.sam.SingaltonsClasses.OldHomeSingalton;
import dotcom.com.sam.Utils.PatientDetails;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.SingaltonsClasses.TripSingalton;

public class VetProfileActivity extends AppCompatActivity {
    ImageView profileImage;
    Button btnBook;
    TextView drname,qualifictn,experiance,homefeess,subdoctortype,desctription,locatn,subcharge;
    LinearLayout visitAtHomeLayout,vaccinationLayoput;
    ImageView imag;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_profile);
        drname = (TextView)findViewById(R.id.doctname);
        qualifictn = (TextView)findViewById(R.id.subqualification);
        experiance = (TextView)findViewById(R.id.subexperiance);
        homefeess = (TextView)findViewById(R.id.subvisitathomefee);
        subdoctortype =(TextView)findViewById(R.id.subdoctortype);
        subcharge =(TextView)findViewById(R.id.vetsubcharge);
        //opentime = (TextView)findViewById(R.id.availabletime);
        desctription = (TextView)findViewById(R.id.detaildescription);
        locatn = (TextView)findViewById(R.id.location);
        drname.setText(TripSingalton.getInstance().getDoctorName());
        qualifictn.setText(TripSingalton.getInstance().getQualification());
        experiance.setText(TripSingalton.getInstance().getWorkExperience());
        subcharge.setText(String.valueOf(TripSingalton.getInstance().getNearMeFees()));
        subdoctortype.setText(TripSingalton.getInstance().getDoctorType());
       // opentime.setText(TripSingalton.getInstance().getAvailableTime());
        desctription.setText(TripSingalton.getInstance().getDescription());
        locatn.setText(TripSingalton.getInstance().getLocation());

        imag =(ImageView)findViewById(R.id.profile_image);
        //OldpetRequest oldpetRequest= new OldpetRequest();

        if (TripSingalton.getInstance().getImage() != null) {
            Picasso.with(context).load("http://mrsam.in/sam/MainImage/" + TripSingalton.getInstance().getImage().toString().replaceAll(" ", "%20")).placeholder(R.drawable.progress_animation).into(imag);
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
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate();

            }
        });
    }

    private void getDate()
    {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                getTime();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
        datePickerDialog.show();
    }

    void getTime()
    {
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                //
                Utils.moveNextWithAnimation(VetProfileActivity.this,PatientDetails.class);
            }
        },12,60,false);
        timePickerDialog.show();
    }
}
