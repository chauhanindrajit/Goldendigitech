package dotcom.com.sam.Response;

import java.util.List;

public class MicroChippingRespose {


    /**
     * success : true
     * Messege : sample string 2
     * status : 3
     * response : [{"PS_Id":1,"Image":"sample string 2","CenterName":"sample string 3","Address":"sample string 4","Location":"sample string 5","Fees":1,"Description":"sample string 6","OpenDay":"sample string 7","Time":"sample string 8","CloseDay":"sample string 9","MobileNo":"sample string 10","SR_Id":1,"CreatedDate":"2018-08-07T15:50:08.7810318+05:30","CreatedBy":"sample string 11","ModifyDate":"2018-08-07T15:50:08.7810318+05:30","ModifyBy":"sample string 12","Status":"sample string 13","DeleteStatus":"sample string 14","Pdf":"sample string 15"},{"PS_Id":1,"Image":"sample string 2","CenterName":"sample string 3","Address":"sample string 4","Location":"sample string 5","Fees":1,"Description":"sample string 6","OpenDay":"sample string 7","Time":"sample string 8","CloseDay":"sample string 9","MobileNo":"sample string 10","SR_Id":1,"CreatedDate":"2018-08-07T15:50:08.7810318+05:30","CreatedBy":"sample string 11","ModifyDate":"2018-08-07T15:50:08.7810318+05:30","ModifyBy":"sample string 12","Status":"sample string 13","DeleteStatus":"sample string 14","Pdf":"sample string 15"}]
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
         * PS_Id : 1
         * Image : sample string 2
         * CenterName : sample string 3
         * Address : sample string 4
         * Location : sample string 5
         * Fees : 1
         * Description : sample string 6
         * OpenDay : sample string 7
         * Time : sample string 8
         * CloseDay : sample string 9
         * MobileNo : sample string 10
         * SR_Id : 1
         * CreatedDate : 2018-08-07T15:50:08.7810318+05:30
         * CreatedBy : sample string 11
         * ModifyDate : 2018-08-07T15:50:08.7810318+05:30
         * ModifyBy : sample string 12
         * Status : sample string 13
         * DeleteStatus : sample string 14
         * Pdf : sample string 15
         */

        private int PS_Id;
        private String Image;
        private String CenterName;
        private String Address;
        private String Location;
        private int Fees;
        private String Description;
        private String OpenDay;
        private String Time;
        private String CloseDay;
        private String MobileNo;
        private int SR_Id;
        private String CreatedDate;
        private String CreatedBy;
        private String ModifyDate;
        private String ModifyBy;
        private String Status;
        private String DeleteStatus;
        private String Pdf;

        public int getPS_Id() {
            return PS_Id;
        }

        public void setPS_Id(int PS_Id) {
            this.PS_Id = PS_Id;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
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

        public int getFees() {
            return Fees;
        }

        public void setFees(int Fees) {
            this.Fees = Fees;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getOpenDay() {
            return OpenDay;
        }

        public void setOpenDay(String OpenDay) {
            this.OpenDay = OpenDay;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public String getCloseDay() {
            return CloseDay;
        }

        public void setCloseDay(String CloseDay) {
            this.CloseDay = CloseDay;
        }

        public String getMobileNo() {
            return MobileNo;
        }

        public void setMobileNo(String MobileNo) {
            this.MobileNo = MobileNo;
        }

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public String getCreatedDate() {
            return CreatedDate;
        }

        public void setCreatedDate(String CreatedDate) {
            this.CreatedDate = CreatedDate;
        }

        public String getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(String CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public String getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(String ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public String getModifyBy() {
            return ModifyBy;
        }

        public void setModifyBy(String ModifyBy) {
            this.ModifyBy = ModifyBy;
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

        public String getPdf() {
            return Pdf;
        }

        public void setPdf(String Pdf) {
            this.Pdf = Pdf;
        }
    }
}
