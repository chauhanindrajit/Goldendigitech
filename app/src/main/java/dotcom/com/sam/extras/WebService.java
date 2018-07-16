package dotcom.com.sam.extras;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 5/12/2017.
 */

public interface WebService {


    //direction api
    //json?origin=40.722543,-73.998585&destination=40.7064,-74.0094&waypoints=optimize:true|40.722543,-73.998585|40.7057,-73.9964|40.7064,-74.0094&key=AIzaSyCgXyTTLf_8kJf1nD24bDG2I1XlZWDeBfo&sensor=false



    // Get City List...
    @GET("api/SamVC/getShopByPetCategoryList")
    Call<RegistrationResponse> RESPONSE_CALL();



}
