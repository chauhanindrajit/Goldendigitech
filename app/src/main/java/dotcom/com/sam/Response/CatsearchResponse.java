package dotcom.com.sam.Response;

import java.util.List;

public class CatsearchResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"GroomingService_Id":2,"ListingTitle":"Elite Pet Grooming Services","CenterName":"Elite Pet Grooming Services Pvt. Ltd","OwnerName":"Sagar Girase","OwnerPhone":"12345678","OwnerEmail":"adhf@gmfsd.co","OwnerAddress":"Testing adddress ","ListingDesciption":null,"AtHomeFees":null,"SalonFees":null,"SearchLocations":null,"AgeUpto":5,"SizeUpto":4,"ServicesAt":"Salon","OpeningTime":null,"ClosingTime":null,"CloseDays":null,"Images":"01AANew.jpg","CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","SR_Id":4,"DeleteStatus":null,"PetType":"Dog","B_Id":null,"B_Ids":null,"GroomingPackages":null,"GroomingPackagedata":null,"AddOns":null,"totalAddon":null,"TotalAmount":null,"Groomingdata":null}]
     */

    private boolean success;
    private String Messege;
    private int status;
    private List<ResponseBean> response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessege() {
        return Messege;
    }

    public void setMessege(String Messege) {
        this.Messege = Messege;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * GroomingService_Id : 2
         * ListingTitle : Elite Pet Grooming Services
         * CenterName : Elite Pet Grooming Services Pvt. Ltd
         * OwnerName : Sagar Girase
         * OwnerPhone : 12345678
         * OwnerEmail : adhf@gmfsd.co
         * OwnerAddress : Testing adddress
         * ListingDesciption : null
         * AtHomeFees : null
         * SalonFees : null
         * SearchLocations : null
         * AgeUpto : 5
         * SizeUpto : 4
         * ServicesAt : Salon
         * OpeningTime : null
         * ClosingTime : null
         * CloseDays : null
         * Images : 01AANew.jpg
         * CreatedDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * SR_Id : 4
         * DeleteStatus : null
         * PetType : Dog
         * B_Id : null
         * B_Ids : null
         * GroomingPackages : null
         * GroomingPackagedata : null
         * AddOns : null
         * totalAddon : null
         * TotalAmount : null
         * Groomingdata : null
         */

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
        private Object Groomingdata;

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

        public Object getGroomingdata() {
            return Groomingdata;
        }

        public void setGroomingdata(Object Groomingdata) {
            this.Groomingdata = Groomingdata;
        }
    }
}
