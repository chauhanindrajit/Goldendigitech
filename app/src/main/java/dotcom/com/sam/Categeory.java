package dotcom.com.sam;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dotcom.com.sam.Adapters.CatregeoryAdapter;
import dotcom.com.sam.Adapters.SubCategeoryAdapter;
import dotcom.com.sam.Utils.Utils;
import dotcom.com.sam.extras.Constants;
import dotcom.com.sam.extras.HttpHandler;
import dotcom.com.sam.extras.RegistrationResponse;
import dotcom.com.sam.extras.TripSingalton;
import dotcom.com.sam.extras.Utilss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Categeory extends AppCompatActivity {
    RecyclerView categeoryLayout;
    TextView SubCtegeryLayout;
    RegistrationResponse registrationResponse;
    ListView listView;
    List<String> stringList = new ArrayList<>();
    private ListView stationsListView;
    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "http://worldindia.in/SamApi/api/SamVC/getShopByPetCategoryList";

    public static ArrayList<HashMap<String, String>> contactList;
    private ArrayList<RegistrationResponse.ResponseBean> arrSubCateogry;
    private ArrayAdapter<TripSingalton> stationListAdapter;
    TextView catname;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categeory);
        Utils.setExplodTransition(this);
        catname = (TextView) findViewById(R.id.categeoryName);
        toolbar = findViewById(R.id.toolbar);
        arrSubCateogry = new ArrayList<>();
        contactList = new ArrayList<>();
        //  arrSubCateogry = new ArrayList<ArrayList<HashMap<String, String>>>();

        // new GetContacts().execute();
        toolbar.setTitle("SAM");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        checkAcceptTrip();
        intitView();
        setCategeoryLayout();
//        intitView1();
//        setCategeoryLayout1();

    }

    private void intitView() {
        categeoryLayout = (RecyclerView) findViewById(R.id.categeoryLayout);
    }

    void setCategeoryLayout() {
        CatregeoryAdapter catregeoryAdapterr = new CatregeoryAdapter(Categeory.this,arrSubCateogry);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);
        categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
        categeoryLayout.setAdapter(catregeoryAdapterr);


    }

//    private void intitView1()
//    {
//        SubCtegeryLayout=(TextView) findViewById(R.id.text_subcat);
//    }
//
//    void setCategeoryLayout1()
//    {
//        SubCategeoryAdapter subCategeoryAdapter=new SubCategeoryAdapter(Categeory.this);
//        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.HORIZONTAL, false);
//        categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
//        categeoryLayout.setAdapter(subCategeoryAdapter);
//
//
//    }

    private void checkAcceptTrip() {
        arrSubCateogry = new ArrayList<>();
        contactList=new ArrayList<>();
        pDialog = new ProgressDialog(Categeory.this);
           pDialog.setMessage("Please wait...");
           pDialog.setCancelable(false);
           pDialog.show();
        final Call<RegistrationResponse> registrationResponseCall = Utilss.getWebService().RESPONSE_CALL();
        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
pDialog.hide();
                if (response.code() == 200) {
                    RegistrationResponse registrationResponse = response.body();
                    Log.e("summmm", new GsonBuilder().create().toJson(response));
                    List<List<RegistrationResponse.ResponseBean>> dataList = Collections.singletonList(registrationResponse.getResponse());

                   // arrSubCateogry.clear();
                      ArrayList<HashMap<String, String>> arrTemp = new ArrayList<>();;
                    for (int i = 0; i <  response.body().getResponse().get(0).getC_Id(); i++) {



            CatregeoryAdapter catregeoryAdapterr = new CatregeoryAdapter(Categeory.this,registrationResponse.getResponse());
                    SubCategeoryAdapter subCategeoryAdapter = new SubCategeoryAdapter(Categeory.this,registrationResponse.getResponse())  ;
            LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);

            categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
           categeoryLayout.setAdapter((catregeoryAdapterr));
             catregeoryAdapterr.getItemCount();
          Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();

                    }


//                    for (int i = 0; i < dataList.size(); i++) {
                    //   stringList.add(registrationResponse.getResponse().get(i).getCategosryName());

                    //  }
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failedd", Toast.LENGTH_LONG).show();

            }


        });

    }

//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Showing progress dialog
//            pDialog = new ProgressDialog(Categeory.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//
//            // Making a request to url and getting response
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//            contactList.clear();
//            arrSubCateogry.clear();
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    // Getting JSON Array node
//                    JSONArray contacts = jsonObj.getJSONArray("response");
//
//                    //
//                    //
//
//
//                    // looping through All Contacts
//
//                    for (int i = 0; i < contacts.length(); i++) {
//                        JSONObject c = contacts.getJSONObject(i);
//
//                        String C_Id = c.getString("C_Id");
//                        String CategosryName = c.getString("CategosryName");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> contact = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
//                        contact.put("C_Id", C_Id);
//                        contact.put("CategosryName", CategosryName);
//
//                        // adding contact to contact list
//                        contactList.add(contact);
//
//                        JSONArray arrSubCategories = c.getJSONArray("subCategories");
//                        ArrayList<HashMap<String, String>> arrSubCategoriesTemp = new ArrayList<>();
//                        for (int j = 0; j < arrSubCategories.length(); j++) {
//                            JSONObject sObj = arrSubCategories.getJSONObject(j);
//                            // String Sc_Id = sObj.getString("Sc_Id");
//                            String SubCategoryName = sObj.getString("SubCategoryName");
//                            // String Status = sObj.getString("Status");
//                            //  String DeleteStatus = sObj.getString("DeleteStatus");
//                            //   String CategosryName1 = sObj.getString("CategosryName");
//                            String C_Id1 = sObj.getString("C_Id");
//
//                            // tmp hash map for single contact
//                            HashMap<String, String> subCategoriesModel = new HashMap<>();
//                            //subCategoriesModel.put("Sc_Id", Sc_Id);
//                            subCategoriesModel.put("SubCategoryName", SubCategoryName);
//                            subCategoriesModel.put("C_Id", C_Id1);
//                            // subCategoriesModel.put("CategosryName", CategosryName1);
//                            // subCategoriesModel.put("DeleteStatus", DeleteStatus);
//                            subCategoriesModel.put("CategosryName", CategosryName);
//                            arrSubCategoriesTemp.add(subCategoriesModel);
//                        }
//
//                        arrSubCateogry.add(arrSubCategoriesTemp);
//                        Constants.shareInstace.arrSubCateogry = arrSubCateogry;
//
//
//                    }
//                    Constants.shareInstace.arrcontactList = contactList;
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    });
//
//                }
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });
//
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            // Dismiss the progress dialog
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//            /**
//             * Updating parsed JSON data into ListView
//             * */
////            CatregeoryAdapter adapter = new CatregeoryAdapter(
////                    Categeory.this, Constants.shareInstace.arrcontactList,
////                    R.layout.single_categeory_lyout, new String[]{"C_Id", "CategosryName",
////                    "CategoryName"}, new int[]{R.id.categeoryName});
//
//            CatregeoryAdapter catregeoryAdapterr = new CatregeoryAdapter(Categeory.this,arrSubCateogry);
//            SubCategeoryAdapter subCategeoryAdapter = new SubCategeoryAdapter(Categeory.this);
//            LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Categeory.this, LinearLayoutManager.VERTICAL, false);
//            LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(Categeory.this, LinearLayoutManager.HORIZONTAL, false);
//            categeoryLayout.setLayoutManager(horizontalLayoutManagaer);
//            //     SubCtegeryLayout.setLayoutManager(horizontalLayoutManagaer1);
////           SubCtegeryLayout.setAdapter(subCategeoryAdapter);
//            categeoryLayout.setAdapter((catregeoryAdapterr));
//            //   catregeoryAdapterr.getItemCount();
////            subCategeoryAdapter.getItemCount();
//
//            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
//
//
//        }
//
//    }

}

