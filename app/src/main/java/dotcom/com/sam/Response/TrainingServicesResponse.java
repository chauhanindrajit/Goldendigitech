package dotcom.com.sam.Response;

import java.util.List;

public class TrainingServicesResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"TS_Id":1,"CenterName":"Dog Training Service Center","Address":"Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai","Location":"Goregaon ","Services":"Basic Training","Fees":null,"Discription":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has bbeen the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...","OpenDay":"Monday-Friday","Opentime":null,"CloseDay":"Sat-Sun","Image":"pet-old-age-home-1.jpg","SR_Id":null,"CreatedDate":null,"CretaedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Mobile":"7303066164"}]
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
         * TS_Id : 1
         * CenterName : Dog Training Service Center
         * Address : Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai
         * Location : Goregaon
         * Services : Basic Training
         * Fees : null
         * Discription : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has bbeen the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...
         * OpenDay : Monday-Friday
         * Opentime : null
         * CloseDay : Sat-Sun
         * Image : pet-old-age-home-1.jpg
         * SR_Id : null
         * CreatedDate : null
         * CretaedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * Mobile : 7303066164
         */

        private int TS_Id;
        private String CenterName;
        private String Address;
        private String Location;
        private String Services;
        private Object Fees;
        private String Discription;
        private String OpenDay;
        private Object Opentime;
        private String CloseDay;
        private String Image;
        private int SR_Id;
        private Object CreatedDate;
        private Object CretaedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private Object DeleteStatus;
        private String Mobile;

        public int getTS_Id() {
            return TS_Id;
        }

        public void setTS_Id(int TS_Id) {
            this.TS_Id = TS_Id;
        }

        public String getCenterName() {
            return CenterName;
        }

        public void setCenterName(String CenterName) {
            this.CenterName = CenterName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getServices() {
            return Services;
        }

        public void setServices(String Services) {
            this.Services = Services;
        }

        public Object getFees() {
            return Fees;
        }

        public void setFees(Object Fees) {
            this.Fees = Fees;
        }

        public String getDiscription() {
            return Discription;
        }

        public void setDiscription(String Discription) {
            this.Discription = Discription;
        }

        public String getOpenDay() {
            return OpenDay;
        }

        public void setOpenDay(String OpenDay) {
            this.OpenDay = OpenDay;
        }

        public Object getOpentime() {
            return Opentime;
        }

        public void setOpentime(Object Opentime) {
            this.Opentime = Opentime;
        }

        public String getCloseDay() {
            return CloseDay;
        }

        public void setCloseDay(String CloseDay) {
            this.CloseDay = CloseDay;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public Object getCreatedDate() {
            return CreatedDate;
        }

        public void setCreatedDate(Object CreatedDate) {
            this.CreatedDate = CreatedDate;
        }

        public Object getCretaedBy() {
            return CretaedBy;
        }

        public void setCretaedBy(Object CretaedBy) {
            this.CretaedBy = CretaedBy;
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

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }
    }
}
