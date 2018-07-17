package dotcom.com.sam.extras;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sanjay on 10/26/2017.
 */

public  class Constants {

    public static Constants shareInstace = new Constants();

    public static final String ACCESS_TOKEN ="CategosryName";
    public static final String ACCESS_TYPE = "accessType";
    public static final String USER_NAME = "userName";
    public static final String FIRST_NAME = "firstName";
    public static final String ROLE = "role";
    public static final String USER_ID = "C_Id";
    public static final String AVAILABILITY ="availability" ;
    public static final String ALLOCATE_TRIP ="allocateTrip";
    public  static  final String STAR_TRIP="starttrip";

    public  static  final String STOP_TRIP="stoptrip";
    public  static  final String TRIP_SHARED="tripshred";
    public  static  ArrayList<HashMap<String, String>> arrcontactList;
    public  static String arrSubCateogry;
    public  ArrayList<HashMap<String, String>> arrSubCateogrySK;
    Constants(){
        arrcontactList = new ArrayList<>();
        arrSubCateogry = String.valueOf(new ArrayList<>());
        arrSubCateogrySK = new ArrayList<>();
    }
}
