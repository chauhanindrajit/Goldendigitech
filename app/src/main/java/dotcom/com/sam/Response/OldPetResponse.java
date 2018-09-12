package dotcom.com.sam.Response;

import java.util.List;

public class OldPetResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"OAH_Id":1,"HomeName":"Tailspin","Location":"Goregaon ","PetType":"Dog Cat ","Amount":5000,"Package":"1 Month","Description":"Lorem Ipsum is simply dummy text of the printing and typesettinng industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...","ServicesType":"Bathing Food Walking","OwnerName":"Rahul kumar","Address":" Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai","Image":"pet-old-age-home.jpg","Pdf":null,"CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":null,"MobileNo":"7303066164"}]
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
         * OAH_Id : 1
         * HomeName : Tailspin
         * Location : Goregaon
         * PetType : Dog Cat
         * Amount : 5000
         * Package : 1 Month
         * Description : Lorem Ipsum is simply dummy text of the printing and typesettinng industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...
         * ServicesType : Bathing Food Walking
         * OwnerName : Rahul kumar
         * Address :  Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai
         * Image : pet-old-age-home.jpg
         * Pdf : null
         * CreatedDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * SR_Id : null
         * MobileNo : 7303066164
         */

        private int OAH_Id;
        private String HomeName;
        private String Location;
        private String PetType;
        private int Amount;
        private String Package;
        private String Description;
        private String ServicesType;
        private String OwnerName;
        private String Address;
        private String Image;
        private Object Pdf;
        private Object CreatedDate;
        private Object CreatedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private Object DeleteStatus;
        private int SR_Id;
        private String MobileNo;

        public int getOAH_Id() {
            return OAH_Id;
        }

        public void setOAH_Id(int OAH_Id) {
            this.OAH_Id = OAH_Id;
        }

        public String getHomeName() {
            return HomeName;
        }

        public void setHomeName(String HomeName) {
            this.HomeName = HomeName;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getPetType() {
            return PetType;
        }

        public void setPetType(String PetType) {
            this.PetType = PetType;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getPackage() {
            return Package;
        }

        public void setPackage(String Package) {
            this.Package = Package;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getServicesType() {
            return ServicesType;
        }

        public void setServicesType(String ServicesType) {
            this.ServicesType = ServicesType;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public Object getPdf() {
            return Pdf;
        }

        public void setPdf(Object Pdf) {
            this.Pdf = Pdf;
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

        public Object getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(Object DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public String getMobileNo() {
            return MobileNo;
        }

        public void setMobileNo(String MobileNo) {
            this.MobileNo = MobileNo;
        }
    }
}
