package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;
import java.util.List;

import dotcom.com.sam.Response.CatGroomingResponse;
import dotcom.com.sam.Response.DiagonsticResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class CatSingalton implements Serializable {

    private static final CatSingalton ourInstance = new CatSingalton();

    public static CatSingalton getInstance() {
        return ourInstance;
    }

    private CatSingalton() {
    }

    public CatGroomingResponse catGroomingResponse() {
        return catGroomingResponse;
    }

    public void CatGroomingResponse(CatGroomingResponse catGroomingResponse) {
        this.catGroomingResponse = catGroomingResponse;
    }

    CatGroomingResponse catGroomingResponse;

    private int GroomingService_Id;
    private String ListingTitle;
    private String CenterName;
    private String OwnerName;
    private String OwnerPhone;
    private String OwnerEmail;
    private String OwnerAddress;
    private Object ListingDesciption;
    private Object AtHomeFees;
    private Object SalonFees;
    private Object SearchLocations;
    private int AgeUpto;
    private int SizeUpto;
    private String ServicesAt;
    private Object OpeningTime;
    private Object ClosingTime;
    private Object CloseDays;
    private String Images;
    private Object CreatedDate;
    private Object CreatedBy;
    private Object ModifyDate;
    private Object ModifyBy;
    private String Status;
    private int SR_Id;
    private Object DeleteStatus;
    private String PetType;
    private Object B_Id;
    private Object B_Ids;
    private Object GroomingPackages;
    private Object GroomingPackagedata;
    private Object AddOns;
    private Object totalAddon;
    private Object TotalAmount;
    private List<CatGroomingResponse.ResponseBean.GroomingdataBean> Groomingdata;

    public int getGroomingService_Id() {
        return GroomingService_Id;
    }

    public void setGroomingService_Id(int GroomingService_Id) {
        this.GroomingService_Id = GroomingService_Id;
    }

    public String getListingTitle() {
        return ListingTitle;
    }

    public void setListingTitle(String ListingTitle) {
        this.ListingTitle = ListingTitle;
    }

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String CenterName) {
        this.CenterName = CenterName;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getOwnerPhone() {
        return OwnerPhone;
    }

    public void setOwnerPhone(String OwnerPhone) {
        this.OwnerPhone = OwnerPhone;
    }

    public String getOwnerEmail() {
        return OwnerEmail;
    }

    public void setOwnerEmail(String OwnerEmail) {
        this.OwnerEmail = OwnerEmail;
    }

    public String getOwnerAddress() {
        return OwnerAddress;
    }

    public void setOwnerAddress(String OwnerAddress) {
        this.OwnerAddress = OwnerAddress;
    }

    public Object getListingDesciption() {
        return ListingDesciption;
    }

    public void setListingDesciption(Object ListingDesciption) {
        this.ListingDesciption = ListingDesciption;
    }

    public Object getAtHomeFees() {
        return AtHomeFees;
    }

    public void setAtHomeFees(Object AtHomeFees) {
        this.AtHomeFees = AtHomeFees;
    }

    public Object getSalonFees() {
        return SalonFees;
    }

    public void setSalonFees(Object SalonFees) {
        this.SalonFees = SalonFees;
    }

    public Object getSearchLocations() {
        return SearchLocations;
    }

    public void setSearchLocations(Object SearchLocations) {
        this.SearchLocations = SearchLocations;
    }

    public int getAgeUpto() {
        return AgeUpto;
    }

    public void setAgeUpto(int AgeUpto) {
        this.AgeUpto = AgeUpto;
    }

    public int getSizeUpto() {
        return SizeUpto;
    }

    public void setSizeUpto(int SizeUpto) {
        this.SizeUpto = SizeUpto;
    }

    public String getServicesAt() {
        return ServicesAt;
    }

    public void setServicesAt(String ServicesAt) {
        this.ServicesAt = ServicesAt;
    }

    public Object getOpeningTime() {
        return OpeningTime;
    }

    public void setOpeningTime(Object OpeningTime) {
        this.OpeningTime = OpeningTime;
    }

    public Object getClosingTime() {
        return ClosingTime;
    }

    public void setClosingTime(Object ClosingTime) {
        this.ClosingTime = ClosingTime;
    }

    public Object getCloseDays() {
        return CloseDays;
    }

    public void setCloseDays(Object CloseDays) {
        this.CloseDays = CloseDays;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    public Object getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Object CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public Object getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Object CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Object getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Object ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public Object getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Object ModifyBy) {
        this.ModifyBy = ModifyBy;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(int SR_Id) {
        this.SR_Id = SR_Id;
    }

    public Object getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(Object DeleteStatus) {
        this.DeleteStatus = DeleteStatus;
    }

    public String getPetType() {
        return PetType;
    }

    public void setPetType(String PetType) {
        this.PetType = PetType;
    }

    public Object getB_Id() {
        return B_Id;
    }

    public void setB_Id(Object B_Id) {
        this.B_Id = B_Id;
    }

    public Object getB_Ids() {
        return B_Ids;
    }

    public void setB_Ids(Object B_Ids) {
        this.B_Ids = B_Ids;
    }

    public Object getGroomingPackages() {
        return GroomingPackages;
    }

    public void setGroomingPackages(Object GroomingPackages) {
        this.GroomingPackages = GroomingPackages;
    }

    public Object getGroomingPackagedata() {
        return GroomingPackagedata;
    }

    public void setGroomingPackagedata(Object GroomingPackagedata) {
        this.GroomingPackagedata = GroomingPackagedata;
    }

    public Object getAddOns() {
        return AddOns;
    }

    public void setAddOns(Object AddOns) {
        this.AddOns = AddOns;
    }

    public Object getTotalAddon() {
        return totalAddon;
    }

    public void setTotalAddon(Object totalAddon) {
        this.totalAddon = totalAddon;
    }

    public Object getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Object TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public List<CatGroomingResponse.ResponseBean.GroomingdataBean> getGroomingdata() {
        return Groomingdata;
    }

    public void setGroomingdata(List<CatGroomingResponse.ResponseBean.GroomingdataBean> Groomingdata) {
        this.Groomingdata = Groomingdata;
    }

    public static class GroomingdataBean {
        /**
         * B_Id : 49
         * C_Id : 3
         * CategoryName : FISH
         * BreedName : Neon Tetra
         * Createdate : null
         * CreatedBy : null
         * ModifyBy : null
         * ModifyDate : null
         * Status : Active
         * DeleteStatus : No
         */

        private int B_Id;
        private int C_Id;
        private String CategoryName;
        private String BreedName;
        private Object Createdate;
        private Object CreatedBy;
        private Object ModifyBy;
        private Object ModifyDate;
        private String Status;
        private String DeleteStatus;

        public int getB_Id() {
            return B_Id;
        }

        public void setB_Id(int B_Id) {
            this.B_Id = B_Id;
        }

        public int getC_Id() {
            return C_Id;
        }

        public void setC_Id(int C_Id) {
            this.C_Id = C_Id;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public String getBreedName() {
            return BreedName;
        }

        public void setBreedName(String BreedName) {
            this.BreedName = BreedName;
        }

        public Object getCreatedate() {
            return Createdate;
        }

        public void setCreatedate(Object Createdate) {
            this.Createdate = Createdate;
        }

        public Object getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(Object CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public Object getModifyBy() {
            return ModifyBy;
        }

        public void setModifyBy(Object ModifyBy) {
            this.ModifyBy = ModifyBy;
        }

        public Object getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(Object ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(String DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }
    }



}
