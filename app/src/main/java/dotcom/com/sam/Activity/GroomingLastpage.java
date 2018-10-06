package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import dotcom.com.sam.Adapters.PackageAdapter;
import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.ProfileActivity.Doggromingprofile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.DateandtimeResponse;
import dotcom.com.sam.Response.DogcatpackageResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroomingLastpage extends AppCompatActivity {
    Toolbar toolbar;
    EditText time, date;
    Button confirm;
    private ProgressDialog pDialog;
    TextView loc, salonprice, packagename, addonname, addonprice, addonnames;
    String Bookingdate,SRID,name;
    String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry",
            "WebOS", "Ubuntu", "Windows7", "Max OS X"};

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
        loc = (TextView) findViewById(R.id.loc);
        salonprice = (TextView) findViewById(R.id.salonorhometxt);
        packagename = (TextView) findViewById(R.id.packagename);
        addonname = (TextView) findViewById(R.id.addonservicename);
        addonprice = (TextView) findViewById(R.id.priceaddon);
        addonnames = (TextView) findViewById(R.id.addonname);

        date.setText(SingletonClass.getInstance().getDate());
        packagename.setText(SingletonClass.getInstance().getDogcatpackagename() + " :");
        packagename.setPaintFlags(packagename.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        addonnames.setPaintFlags(addonnames.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        addonprice.setText(SingletonClass.getInstance().getAddonprice());
        // salonprice.setText(SingletonClass.getInstance().getSalonorhome());
        salonprice.setText(Html.fromHtml("<br/><b><medium><font color='" + Color.BLACK + "'>" +
                "<medium> <font color='" + Color.RED + "'>" + SingletonClass.getInstance().getSalonorhome() + "</font>" + "<br />"
        ));
        addonname.setText(Html.fromHtml("<br/><b><medium><font color='" + Color.BLACK + "'>" +
                "<medium> <font color='" + Color.RED + "'>" + SingletonClass.getInstance().getAddonservices() + " :" + "</font>" + "<br />"
        ));
        loc.setText(SingletonClass.getInstance().getOwneraddress());

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view2 = inflater.inflate(R.layout.summary_dialog_layout, null);
        ImageView imageView = view2.findViewById(R.id.cancle_image);
        Button submit = view2.findViewById(R.id.submitapi);
        final RecyclerView filterview = view2.findViewById(R.id.filtrrecyview);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view2);
        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, myList);
        final ListView listView = (ListView) view2.findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {
                for (int i = 0; i < listView.getChildCount(); i++) {
                    if (position == i) {
                        listView.getChildAt(i).setBackgroundColor(Color.LTGRAY);
                    } else {
                        listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                 name = arg0.getItemAtPosition(position).toString();
                time.setText(name);
                //Utils.customMessage(GroomingLastpage.this,name);
            }
        });
        final AlertDialog dialog = builder.create();
        SRID=SingletonClass.getInstance().getSRRRID();
        Bookingdate=SingletonClass.getInstance().getDate();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // checkAcceptTrip(name,SRID,Bookingdate);

                pDialog = new ProgressDialog(GroomingLastpage.this);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();
                final Call<DateandtimeResponse> dateandtimeResponseCall = Utilss.getWebService().DATEANDTIME_RESPONSE_CALL(name,SRID,Bookingdate);
                dateandtimeResponseCall.enqueue(new Callback<DateandtimeResponse>() {
                    @Override
                    public void onResponse(Call<DateandtimeResponse> call, Response<DateandtimeResponse> response) {
                        pDialog.dismiss();
                        if (response.code() == 200) {
                            DateandtimeResponse dateandtimeResponse = response.body();
                            Log.e("dioglist", new GsonBuilder().create().toJson(response));
                            Utils.customMessage(GroomingLastpage.this,dateandtimeResponse.getMessege());
                            if(dateandtimeResponse.getMessege().equals("NotBooked")){

                                dialog.dismiss();
                            }
                            else{
                                Utils.customMessage(GroomingLastpage.this,"Please Select Other Time slot. Thank you");
                            }

                        }
                        else{
                            Utils.customMessage(GroomingLastpage.this,"Please Select Time slot.");
                        }
                    }

                    @Override
                    public void onFailure(Call<DateandtimeResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

                    }


                });
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);


    }

    private boolean Validate() {
        if (name.toString().equals("")) {
            Toast.makeText(GroomingLastpage.this,"Please Select Time Slot",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}