package dotcom.com.sam.extras;


import dotcom.com.sam.Response.AddnewAddressResponse;
import dotcom.com.sam.Response.AddressResponse;
import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.Response.BaseResponse;
import dotcom.com.sam.Response.BuypetResponse;
import dotcom.com.sam.Response.BuypetfilterResponse;
import dotcom.com.sam.Response.CatGroomingResponse;
import dotcom.com.sam.Response.CatsearchResponse;
import dotcom.com.sam.Response.ChangePassResponse;
import dotcom.com.sam.Response.DateandtimeResponse;
import dotcom.com.sam.Response.DeleteallResponse;
import dotcom.com.sam.Response.DiagonsticResponse;
import dotcom.com.sam.Response.DogGroomingResponse;
import dotcom.com.sam.Response.DogcatpackageResponse;
import dotcom.com.sam.Response.DogsearchResponse;
import dotcom.com.sam.Response.ForgotPassResponse;
import dotcom.com.sam.Response.GetCartResponse;
import dotcom.com.sam.Response.GroomingFinalBookingResponse;
import dotcom.com.sam.Response.HomeRespose;
import dotcom.com.sam.Response.IncrDecResponse;
import dotcom.com.sam.Response.LoginResponse;
import dotcom.com.sam.Response.ManageCartResponse;
import dotcom.com.sam.Response.MatingResponse;
import dotcom.com.sam.Response.MatingsearchResponse;
import dotcom.com.sam.Response.MicroChippingRespose;
import dotcom.com.sam.Response.NewArrivalAllResponse;
import dotcom.com.sam.Response.NewArrivalResponse;
import dotcom.com.sam.Response.OldPetResponse;
import dotcom.com.sam.Response.PaymentResponse;
import dotcom.com.sam.Response.PetSitterResponse;
import dotcom.com.sam.Response.PetSittersearchResponse;
import dotcom.com.sam.Response.PetWalkingResponse;
import dotcom.com.sam.Response.PhotoResponse;
import dotcom.com.sam.Response.ProductFilterdataResponse;
import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.Response.RegisttnResponsemain;
import dotcom.com.sam.Response.RemovecartResponse;
import dotcom.com.sam.Response.ServiceLastPageResponse;
import dotcom.com.sam.Response.SubcategoryResponse;
import dotcom.com.sam.Response.TrainingServicesResponse;
import dotcom.com.sam.Response.VaccinationResponse;
import dotcom.com.sam.Response.VetNearMeResponse;
import dotcom.com.sam.Response.WalkingsearchResponse;
import dotcom.com.sam.request.AddnewaddressRequest;
import dotcom.com.sam.request.ChangePassRequest;
import dotcom.com.sam.request.ForgetPassRequest;
import dotcom.com.sam.request.GroomingfinalRequest;
import dotcom.com.sam.request.ManageCartRequest;
import dotcom.com.sam.request.ProductfilterdataRequest;
import dotcom.com.sam.request.RegistrationRequest;
import dotcom.com.sam.request.RemoveCartRequest;
import dotcom.com.sam.request.ServicelastpageRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by admin on 5/12/2017.
 */

public interface WebService {


    //direction api
    //json?origin=40.722543,-73.998585&destination=40.7064,-74.0094&waypoints=optimize:true|40.722543,-73.998585|40.7057,-73.9964|40.7064,-74.0094&key=AIzaSyCgXyTTLf_8kJf1nD24bDG2I1XlZWDeBfo&sensor=false


    // Get City List...
    @GET("api/ShopByPetVC/getShopByPetCategoryList")
    Call<RegistrationResponse> RESPONSE_CALL();

    @GET("api/ShopByPetVC/getShopByPetCategoryList")
    Call<SubcategoryResponse> SUBCATEGORY_RESPONSE_CALL();

    //fyygy
    @GET("api/ShopByPetVC/getVetNearMedata")
    Call<VetNearMeResponse> VET_NEAR_ME_RESPONSE_CALL();

    @GET("api/ShopByPetVC/getAtHomedata")
    Call<HomeRespose> HOME_RESPOSE_CALL();

    @GET("api/ShopByPetVC/getDiagnosticsdata")
    Call<DiagonsticResponse> DIAGONSTIC_RESPONSE_CALL();

    @GET("api/ShopByPetVC/getVaccinationdata")
    Call<VaccinationResponse> VACCINATION_RESPONSE_CALL();

    @GET("api/ShopByPetVC/getAllMatingdata")
    Call<MatingResponse> MATING_RESPONSE_CALL();

    @POST("api/ShopByPetVC/UserNormalRegister")
    Call<RegisttnResponsemain> registration(@Body RegistrationRequest registrationRequest);


    @FormUrlEncoded
    @POST("api/ShopByPetVC/UserSignin")
    Call<LoginResponse> login(
            @Field(value = "Email", encoded = true) String Email,
            @Field(value = "Password", encoded = true) String Password);

    @POST("api/ShopByPetVC/ForgotPassword")
    Call<ForgotPassResponse> getForgotPassword(@Body ForgetPassRequest forgetPassRequest);


    @POST("api/ShopByPetVC/ResetPassword")
    Call<ChangePassResponse> getChangePassword(@Body ChangePassRequest changePassRequest);


    @GET("api/ShopByPetVC/getMatingdataBySearch?")
    Call<MatingsearchResponse> MATINGSEARCH_RESPONSE_CALL(@Query("id") String id,
                                                          @Query("Location") String Location,
                                                          @Query("Pettype") String Pettype,
                                                          @Query("Gender") String Gender);


    @GET("api/ShopByPetVC/OldAgehomeData")
    Call<OldPetResponse> PET_OLD_RESPONSE_CALL();

    @GET("api/ShopByPetVC/Microchippingdata")
    Call<MicroChippingRespose> MICRO_CHIPPING_RESPOSE_CALL();


    @GET("api/ShopByPetVC/PetSitterData")
    Call<PetSitterResponse> PET_SITTER_RESPONSE_CALL();


    @GET("api/ShopByPetVC/PetSitterBySearchData?")
    Call<PetSittersearchResponse> PET_SITTERSEARCH_RESPONSE_CALL(@Query("StartDate") String startdate,
                                                                 @Query("EndDates") String enddates,
                                                                 @Query("StrtTime") String starttime,
                                                                 @Query("Endtime") String endtime,
                                                                 @Query("location") String location,
                                                                 @Query("shortTime") String shorttime);


    @GET("api/ShopByPetVC/getAllAdoptPetData")
    Call<AdoptpetResponse> ADOPTPET_RESPONSE_CALL();

    @GET("api/ShopByPetVC/getAllBuyPetData")
    Call<BuypetResponse> BUYPET_RESPONSE_CALL();

    @GET("api/ShopByPetVC/PetWalkerData")
    Call<PetWalkingResponse> PET_WALKING_RESPONSE_CALL();

    @GET("api/ShopByPetVC/PetSitterBySearchData?")
    Call<WalkingsearchResponse> WALKINGSEARCH_RESPONSE_CALL(@Query("location") String startdate,
                                                            @Query("Day") String enddates,
                                                            @Query("StrtTime") String starttime,
                                                            @Query("Endtime") String endtime);

    @GET("api/ShopByPetVC/Trainingdata")
    Call<TrainingServicesResponse> TRAINING_SERVICES_RESPONSE_CALL();

    @GET("api/ShopByPetVC/AllPhotographerData")
    Call<PhotoResponse> PHOTO_RESPONSE_CALL();

    @GET("api/ShopByPetVC/ShopByPetSubCategoryProductListbyCid/{id}")
    Call<ProductResponse> PRODUCT_RESPONSE_CALL(@Path("id") Integer id);

    @GET("api/ShopByPetVC/getFeaturedproduct?Featured=new")
    Call<NewArrivalResponse> NEW_ARRIVAL_RESPONSE_CALL();

    @POST("api/ShopByPetVC/ShopByPetFilter")
    Call<ProductFilterdataResponse> PRODUCT_FILTERDATA_RESPONSE_CALL(@Body ProductfilterdataRequest productfilterdataRequest);

    @GET("api/ShopByPetVC/getAllBuyPetfilterData")
    Call<BuypetfilterResponse> BUYPETFILTER_RESPONSE_CALL();

    @POST("api/ShopByPetVC/SMSSendbyRequest")
    Call<ServiceLastPageResponse> SERVICE_LAST_PAGE_RESPONSE_CALL(@Body ServicelastpageRequest servicelastpageRequest);


    //extra
    @GET("api/ShopByPetVC/CartProduct?")
    Call<GetCartResponse> getAllCartList(@Query("id") Integer id);

    @POST("cart/edit")
    Call<BaseResponse> removeCart(@Body ManageCartRequest cartRequest);

    @POST("api/ShopByPetVC/AddToCart")
    Call<ManageCartResponse> manageCart(@Body ManageCartRequest cartRequest);

    @GET("api/ShopByPetVC/CartRemoveProduct?")
    Call<RemovecartResponse> REMOVECART_RESPONSE_CALL(@Query("CRT_Id") Integer crtid, @Query("RJ_Id") Integer id);

    @GET("api/ShopByPetVC/AllCartDataRemoveProduct?")
    Call<DeleteallResponse> DELETEALL_RESPONSE_CALL(@Query("RJ_ID") Integer id);

    @GET("api/ShopByPetVC/DataAddMinusRemoveProduct?")
    Call<IncrDecResponse> INCR_DEC_RESPONSE_CALL(@Query("CRT_ID") Integer id, @Query("RJ_Id") Integer rj_id, @Query("AddRemove") String addremove);

    @GET("api/ShopByPetVC/DeliveryAddress?")
    Call<AddressResponse> ADDRESS_RESPONSE_CALL(@Query("RJ_ID") Integer id);

    @GET("api/ShopByPetVC/FinalSummryData?")
    Call<PaymentResponse> PAYMENT_RESPONSE_CALL(@Query("RJ_ID") Integer id);

    @POST("api/ShopByPetVC/AddNewDeliveryAddress")
    Call<AddnewAddressResponse> ADDNEW_ADDRESS_RESPONSE_CALL(@Body AddnewaddressRequest addnewaddressRequest);

    @GET("api/ShopByPetVC/ShopByPetNewArrival?")
    Call<NewArrivalAllResponse> NEW_ARRIVAL_ALL_RESPONSE_CALL(@Query("New") String New);


    @GET("api/ShopByPetVC/NewArrivalAllData/{New}")
    Call<ProductResponse> RESPONSE_CALL(@Path("New") String New);

    @GET("api/ShopByPetVC/DOgGroomingAllData")
    Call<DogGroomingResponse> DOG_GROOMING_RESPONSE_CALL();

    @GET("api/ShopByPetVC/CatGroomingAlldata")
    Call<CatGroomingResponse> CAT_GROOMING_RESPONSE_CALL();

    @GET("api/ShopByPetVC/getDogGroomingSearch?")
    Call<DogsearchResponse> DOGSEARCH_RESPONSE_CALL(@Query("Breed") String breed,
                                                    @Query("Age") String age,
                                                    @Query("Size") String size,
                                                    @Query("ServiceAt") String serviceat,
                                                    @Query("Location") String location
    );

    @GET("api/ShopByPetVC/getCatGroomingSearch?")
    Call<CatsearchResponse> CATSEARCH_RESPONSE_CALL(@Query("Breed") String breed,
                                                    @Query("Age") String age,
                                                    @Query("Size") String size,
                                                    @Query("ServiceAt") String serviceat,
                                                    @Query("Location") String location
    );

    @GET("api/ShopByPetVC/GroomingDetailsdata?")
    Call<DogcatpackageResponse> DOGCATPACKAGE_RESPONSE_CALL(@Query("id") String id);

    @GET("api/ShopByPetVC/TimeSlotCheack?")
    Call<DateandtimeResponse> DATEANDTIME_RESPONSE_CALL(@Query("Times") String time,
                                                        @Query("SRID") String srid,
                                                        @Query("Dates") String date
    );

    @POST("api/ShopByPetVC/GroomingAppoinmentBooking")
    Call<GroomingFinalBookingResponse> GROOMING_FINAL_BOOKING_RESPONSE_CALL(@Body GroomingfinalRequest groomingfinalRequest);
}
