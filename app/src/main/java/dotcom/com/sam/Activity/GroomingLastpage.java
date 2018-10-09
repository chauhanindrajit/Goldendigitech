package dotcom.com.sam.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
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
import java.util.regex.Pattern;

import dotcom.com.sam.Adapters.PackageAdapter;
import dotcom.com.sam.Credentials.Registration;
import dotcom.com.sam.ProfileActivity.Doggromingprofile;
import dotcom.com.sam.R;
import dotcom.com.sam.Response.AddnewAddressResponse;
import dotcom.com.sam.Response.DateandtimeResponse;
import dotcom.com.sam.Response.DogcatpackageResponse;
import dotcom.com.sam.Response.GroomingFinalBookingResponse;
import dotcom.com.sam.SingaltonsClasses.SingletonClass;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Utilss;
import dotcom.com.sam.request.AddnewaddressRequest;
import dotcom.com.sam.request.GroomingfinalRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroomingLastpage extends AppCompatActivity {
    Toolbar toolbar;
    EditText time, date, clientname, clenmob, cleemail, cleadd;
    Button confirm;
    private ProgressDialog pDialog;
    TextView loc, salonprice, packagename, addonname, addonprice, addonnames;
    String Bookingdate, SRID, name;
    int Price, addonpr;
    int Totalprice;
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
        clientname = (EditText) findViewById(R.id.clientname);
        clenmob = (EditText) findViewById(R.id.clientnumber);
        cleemail = (EditText) findViewById(R.id.clientemailid);
        cleadd = (EditText) findViewById(R.id.cleinetaddress);

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
        Price = Integer.parseInt((SingletonClass.getInstance().getPrice().replaceAll("\n", "")));
        addonpr = Integer.parseInt(SingletonClass.getInstance().getAddonprice());
        Totalprice += Integer.parseInt(String.valueOf(Price + addonpr));
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
        SRID = SingletonClass.getInstance().getSRRRID();
        Bookingdate = SingletonClass.getInstance().getDate();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checkAcceptTrip(name,SRID,Bookingdate);

                pDialog = new ProgressDialog(GroomingLastpage.this);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();
                final Call<DateandtimeResponse> dateandtimeResponseCall = Utilss.getWebService().DATEANDTIME_RESPONSE_CALL(name, SRID, Bookingdate);
                dateandtimeResponseCall.enqueue(new Callback<DateandtimeResponse>() {
                    @Override
                    public void onResponse(Call<DateandtimeResponse> call, Response<DateandtimeResponse> response) {
                        pDialog.dismiss();
                        if (response.code() == 200) {
                            DateandtimeResponse dateandtimeResponse = response.body();
                            Log.e("dioglist", new GsonBuilder().create().toJson(response));
                            if (dateandtimeResponse.getMessege().equals("Booked")) {
                                Utils.customMessage(GroomingLastpage.this, "Please Select Other Time slot. Thank you");
                            }
                            if (dateandtimeResponse.getMessege().equals("NotBooked")) {
                                dialog.dismiss();
                            } else {

                            }

                        } else {
                            Utils.customMessage(GroomingLastpage.this, "Please Select some other date or Time slot.");
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
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()) {
                    String srid = SRID;
                    String packgename = packagename.getText().toString().trim();
                    String servicet = salonprice.getText().toString().trim();
                    String addon = addonname.getText().toString().trim();
                    String bookingtym = time.getText().toString().trim();
                    String bookingdate = date.getText().toString().trim();
                    String clientnam = clientname.getText().toString().trim();
                    String clinumbr = clenmob.getText().toString().trim();
                    String clebtemail = cleemail.getText().toString().trim();
                    String clebnadd = cleadd.getText().toString().trim();
                    String totalprice = String.valueOf(Totalprice);
                    if (validate1()) {
                        Addnewaddress(srid, packgename, servicet, addon, bookingtym, bookingdate, clientnam, clinumbr, clebtemail, clebnadd, totalprice);

                    }
                }
            }
        });
        dialog.setOnKeyListener(new Dialog.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface arg0, int keyCode,
                                 KeyEvent event) {
                // TODO Auto-generated method stub
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    GroomingLastpage.this.finish();
                }
                return true;
            }
        });

    }

    private boolean Validate() {

        if (clientname.getText().toString().equals("")) {
            Toast.makeText(GroomingLastpage.this, "Please Enter Valid User Name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (cleadd.getText().toString().equals("")) {
            Toast.makeText(GroomingLastpage.this, "Please enter Address.", Toast.LENGTH_LONG).show();
            return false;
        } else if (cleadd.getText().length() < 12) {
            Toast.makeText(GroomingLastpage.this, "Please enter a valid Address", Toast.LENGTH_LONG).show();
            return false;
        }
        if (cleemail.getText().toString().equals("")) {
            Toast.makeText(GroomingLastpage.this, "Please Enter email id.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (clenmob.getText().toString().equals("")) {
            Toast.makeText(GroomingLastpage.this, "Please enter contact number.", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void Addnewaddress(String srid, String packgename, String servicet, String addon, String bookingtym, String bookingdate, String clientnam, String clinumbr, String clebtemail, String clebnadd, String totalprice) {
        pDialog = new ProgressDialog(GroomingLastpage.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        GroomingfinalRequest groomingfinalRequest = new GroomingfinalRequest();
        groomingfinalRequest.setSR_Id(Integer.parseInt(srid));
        groomingfinalRequest.setBookingTime(bookingtym);
        groomingfinalRequest.setBookingDate(bookingdate);
        String myString = servicet;
        String newString = myString.substring(0, myString.indexOf(" :"));
        groomingfinalRequest.setServiceType(newString);
        groomingfinalRequest.setAddOnServices(addon.replace(":", ""));
        groomingfinalRequest.setClientName(clientnam);
        groomingfinalRequest.setClientAddress(clebnadd);
        groomingfinalRequest.setClientPhone(clinumbr);
        groomingfinalRequest.setClientEmail(clebtemail);
        groomingfinalRequest.setBookingPackage(packgename);
        groomingfinalRequest.setTotalAmount(Integer.parseInt(totalprice));


        Call<GroomingFinalBookingResponse> groomingFinalBookingResponseCall = Utilss.getWebService().GROOMING_FINAL_BOOKING_RESPONSE_CALL(groomingfinalRequest);
        Log.e("dioglist", "getAddressList: " + groomingFinalBookingResponseCall.request().url().toString());
        groomingFinalBookingResponseCall.enqueue(new Callback<GroomingFinalBookingResponse>() {
            @Override
            public void onResponse(Call<GroomingFinalBookingResponse> call, Response<GroomingFinalBookingResponse> response) {
                GroomingFinalBookingResponse groomingFinalBookingResponse = response.body();
                Log.e("dioglist", "getAddressList: " + new GsonBuilder().create().toJson(groomingFinalBookingResponse));
                if (response.code() == 200) {
                    String bkngid = String.valueOf(groomingFinalBookingResponse.getGroomingId());
                    Utils.customMessage(GroomingLastpage.this, " Your Booking id :" + bkngid);
                    GroomingLastpage.this.finish();
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<GroomingFinalBookingResponse> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }


    public static boolean isValidEmaillId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    private boolean validate1() {
        boolean temp = true;
        String checkemail = cleemail.getText().toString();

        if (!isValidEmaillId(checkemail)) {
            Toast.makeText(GroomingLastpage.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            temp = false;
        }
        return temp;
    }
}