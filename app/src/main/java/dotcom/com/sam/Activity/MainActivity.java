package dotcom.com.sam.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Adapters.NewArrivalAdapter;
import dotcom.com.sam.Credentials.LoginActivity;
import dotcom.com.sam.Utils.PhotoMain;
import dotcom.com.sam.R;
import dotcom.com.sam.Utils.UserSessionManager;
import dotcom.com.sam.Utils.Constats;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.Utils.WishlistActivity;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.HttpHandler;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Button btn_shopBypet, btn_vet, btn_mate, btn_adobpet, btn_photo, buyapet, adoptapet, petoldhome, petevents,e_dctor;
    public static int module_name = 0;

    RecyclerView categeoryLayout;
    TextView SubCtegeryLayout;

    ListView listView;
    List<String> stringList = new ArrayList<>();
    private ListView stationsListView;


    private ProgressDialog pDialog;
    private ListView lv;
    UserSessionManager session;
    // URL to get contacts JSON
    private static String url = "http://worldindia.in/SamApi/api/ShopByPetVC/getFeaturedproduct?Featured=new";

    public static ArrayList<HashMap<String, String>> contactList;
    public static ArrayList<ArrayList<HashMap<String, String>>> arrSubCateogry;

    TextView catname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        //setTransition
        Utils.setExplodTransition(this);
        contactList = new ArrayList<>();
        arrSubCateogry = new ArrayList<ArrayList<HashMap<String, String>>>();
        session = new UserSessionManager(getApplicationContext());

        if (Utils.isOnline(MainActivity.this)) {
            new GetContacts().execute();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Internet problem");
            builder.setMessage("Oops! seems you have lost internet connectivity. Please try again later.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            android.app.AlertDialog alert = builder.create();
            alert.show();
            Button nbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
            nbutton.setTextColor(Color.rgb(30, 144, 255));
        }
        initView();
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setRecyclerView();
        buttonClickEvent();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Logout ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (Boolean.valueOf(Utils.getStringUserPreference(MainActivity.this, Constants.RJ_ID)) == true) {
                                session.logoutUser();
                            } else {

                            }
                            Utils.clearAllPreference(MainActivity.this);
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                            /*    HomeActivity.this.finish();*/
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
            pbutton.setTextColor(Color.rgb(30, 144, 255));
            Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
            nbutton.setTextColor(Color.rgb(30, 144, 255));
        }
        else if (id == R.id.my_wishlist) {
            startActivity(new Intent(MainActivity.this, WishlistActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recylcerview_newarrival);
        btn_shopBypet = (Button) findViewById(R.id.btn_shobypet);
        btn_vet = (Button) findViewById(R.id.btn_vet);
        adoptapet = (Button) findViewById(R.id.adoptapet);
        buyapet = (Button) findViewById(R.id.buyapet);
        petoldhome = (Button) findViewById(R.id.petoldhome);
        btn_mate = findViewById(R.id.btn_mating);
        btn_adobpet = findViewById(R.id.btn_adopt);
        btn_photo = findViewById(R.id.btn_photo);
        e_dctor = findViewById(R.id.e_doctor);
        petevents=findViewById(R.id.petevent);
    }


    void setRecyclerView() {
        NewArrivalAdapter newArrivalAdapter = new NewArrivalAdapter(MainActivity.this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(newArrivalAdapter);
    }


    private void buttonClickEvent() {
        btn_shopBypet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getApplicationContext(),Categeory.class);
                // startActivity(intent);
                Utils.moveNextWithAnimation(MainActivity.this, Categeory.class);
                module_name = 0;
            }
        });
        btn_vet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, PetDoctor.class);
                module_name = 0;
            }
        });
        buyapet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getApplicationContext(),Categeory.class);
                // startActivity(intent);
                Utils.moveNextWithAnimation(MainActivity.this, BuyPetList.class);
                module_name = 0;
            }
        });
        adoptapet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, Adoptpet.class);
                module_name = 0;
                /*Utils.moveNextWithAnimation(MainActivity.this,VetList.class);
                module_name= Constats.Module.ADOPTED;
    */
            }
        });
        petoldhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, PetOldAgeHome.class);
                module_name = 0;
                /*Utils.moveNextWithAnimation(MainActivity.this,VetList.class);
                module_name= Constats.Module.ADOPTED;
    */
            }
        });
        btn_mate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, Mating.class);
                module_name = 0;
                // module_name= Constats.Module.MATING;
            }
        });

        btn_adobpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, Adoption.class);
                module_name = 0;
                /*Utils.moveNextWithAnimation(MainActivity.this,VetList.class);
                module_name= Constats.Module.ADOPTED;
    */
            }
        });
        e_dctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, EDoctor.class);
                module_name = Constats.Module.PHOTO;
            }
        });
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, PhotoMain.class);
                module_name = Constats.Module.PHOTO;
            }
        });
        petevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.moveNextWithAnimation(MainActivity.this, PetEvent.class);
                module_name = Constats.Module.PHOTO;
            }
        });
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);


            contactList.clear();
            arrSubCateogry.clear();
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("response");

                    //
                    //


                    // looping through All Contacts

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);


                        String CategosryName = c.getString("ProductName");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value

                        contact.put("ProductName", CategosryName);

                        // adding contact to contact list
                        contactList.add(contact);

                        Constants.shareInstace.arrSubCateogry1 = String.valueOf(contactList);


                    }
                    Constants.shareInstace.arrcontactList1 = contactList;
                } catch (final JSONException e) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            setRecyclerView();
        }

    }

}
