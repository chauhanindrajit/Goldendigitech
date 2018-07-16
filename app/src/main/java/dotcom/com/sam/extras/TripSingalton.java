package dotcom.com.sam.extras;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sanjay on 10/28/2017.
 */

public class TripSingalton implements Serializable {


    @SerializedName("success")
    public boolean success;
    @SerializedName("Messege")
    public String Messege;
    @SerializedName("status")
    public int status;
    @SerializedName("response")
    public List<Response> response;

    public static class SubCategories {
        @SerializedName("Sc_Id")
        public int Sc_Id;
        @SerializedName("SubCategoryName")
        public String SubCategoryName;
        @SerializedName("Cretaedate")
        public String Cretaedate;
        @SerializedName("CretaedBy")
        public String CretaedBy;
        @SerializedName("ModifyDate")
        public String ModifyDate;
        @SerializedName("ModifyBy")
        public String ModifyBy;
        @SerializedName("Status")
        public String Status;
        @SerializedName("DeleteStatus")
        public String DeleteStatus;
        @SerializedName("C_Id")
        public int C_Id;
        @SerializedName("CategosryName")
        public String CategosryName;
        @SerializedName("Image")
        public String Image;
        @SerializedName("prodList")
        public String prodList;
    }

    public static class Response {
        @SerializedName("C_Id")
        public int C_Id;
        @SerializedName("CategosryName")
        public String CategosryName;
        @SerializedName("Createdate")
        public String Createdate;
        @SerializedName("CreatedBy")
        public String CreatedBy;
        @SerializedName("ModifyBy")
        public String ModifyBy;
        @SerializedName("ModifyDate")
        public String ModifyDate;
        @SerializedName("Status")
        public String Status;
        @SerializedName("DeleteStatus")
        public String DeleteStatus;
        @SerializedName("subCategories")
        public List<SubCategories> subCategories;
    }
}
