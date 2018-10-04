package dotcom.com.sam.Adapters;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import dotcom.com.sam.Activity.GroomingLastpage;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DogcatpackageResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;

/**
 * Created by sanjay on 3/8/2018.
 */

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ViewHOLDER> {
    Context context;
    final Calendar myCalendar = Calendar.getInstance();
    ArrayList<String> stringList = new ArrayList<>();
    public static List<DogcatpackageResponse.ResponseBean.GroomingPackagesBean> arrSubCateogry;
    List<String> breedarray = new ArrayList<>();
    List<String> agearray = new ArrayList<>();

    public PackageAdapter(Context context, List<DogcatpackageResponse.ResponseBean.GroomingPackagesBean> response) {
        this.context = context;
        this.arrSubCateogry = response;

    }


    @Override
    public PackageAdapter.ViewHOLDER onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_package_arrival, parent, false);
        ViewHOLDER viewHolder = new ViewHOLDER(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PackageAdapter.ViewHOLDER holder, final int position) {
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
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        holder.packagename.setText(arrSubCateogry.get(position).getPackageTitle());
        holder.servicesincludes.setText(arrSubCateogry.get(position).getServicesIncluded());
        holder.salonprice.setText(String.valueOf(arrSubCateogry.get(position).getSalonPrice()));
        holder.homeprice.setText(String.valueOf(arrSubCateogry.get(position).getAtHomePrice()));
        if (breedarray.size() > 0) {
            breedarray.clear();
        }
        final ArrayAdapter<String> loadTypeArrayAdapter1 = new ArrayAdapter<>(context, R.layout.custom_spinner_item, breedarray);
        loadTypeArrayAdapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        holder.addonservices.setThreshold(1);
        holder.addonservices.setAdapter(loadTypeArrayAdapter1);
        holder.addonservices.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (breedarray.size() > 0) {
                    breedarray.clear();
                }
                for (int i = 0; i < arrSubCateogry.get(position).getAddOns().size(); i++) {
                    // breedarray.clear();
                    breedarray.add(arrSubCateogry.get(position).getAddOns().get(i).getAddOnnName());
                }

                holder.addonservices.showDropDown();
                return false;
            }
        });
        breedarray.clear();


    }

    @Override
    public int getItemCount() {
        return arrSubCateogry.size();
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
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                SingletonClass.getInstance().setTime(selectedHour + ":" + selectedMinute);
                Utils.moveNextWithAnimation(context, GroomingLastpage.class);
                //starttime.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    public class ViewHOLDER extends RecyclerView.ViewHolder {
        //RecyclerView recyclerView;
        ImageView imageView;
        TextView packagename, servicesincludes, salonprice, homeprice;
        LinearLayout prod;
        Button button;
        AutoCompleteTextView addonservices;


        public ViewHOLDER(View itemView) {
            super(itemView);
            packagename = itemView.findViewById(R.id.packagetitle);
            servicesincludes = itemView.findViewById(R.id.serviceincludes);
            salonprice = itemView.findViewById(R.id.salonrate);
            homeprice = itemView.findViewById(R.id.homerate);
            button = itemView.findViewById(R.id.btn_bookpackage);
            addonservices = itemView.findViewById(R.id.addonservices);
        }
    }


}
