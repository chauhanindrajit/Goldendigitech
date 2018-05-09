package dotcom.com.sam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;

public class VetProfileActivity extends AppCompatActivity {
    ImageView profileImage;
    Button btnBook;
    LinearLayout visitAtHomeLayout,vaccinationLayoput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_profile);
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
