package dotcom.com.sam.Response;

import java.util.List;

public class WalkingsearchResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"PW_Id":1,"Location":"Andheri","Duration":null,"Day":"Tuesday","Starttime":"07:00","EndTime":"12:00","Name":"Ajay Kumbhare","OpratingLocation":"Andheri","PerhoureCost":100,"PerDayCost":500,"Profile":"Can manage anything","Description":"Testing Description","OpenDays":"Mom-Fri","CloseDays":"Sat-Sun","OpenTime":null,"CreatedDate":"2018-07-12T12:57:13.207","CreatedBy":"dbd9fe7f-affa-44b8-978b-f0d24d4c0acd","ModifyDate":"2018-07-12T15:01:12.913","ModifyBy":"dbd9fe7f-affa-44b8-978b-f0d24d4c0acd","Status":"Active","DeleteStatus":"No","SR_Id":null,"Address":"Andheri DN Nagar","Email":"omkar2@gmail.com","Mobile":"9819716441","Image":"person-male.png"}]
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
         * PW_Id : 1
         * Location : Andheri
         * Duration : null
         * Day : Tuesday
         * Starttime : 07:00
         * EndTime : 12:00
         * Name : Ajay Kumbhare
         * OpratingLocation : Andheri
         * PerhoureCost : 100
         * PerDayCost : 500
         * Profile : Can manage anything
         * Description : Testing Description
         * OpenDays : Mom-Fri
         * CloseDays : Sat-Sun
         * OpenTime : null
         * CreatedDate : 2018-07-12T12:57:13.207
         * CreatedBy : dbd9fe7f-affa-44b8-978b-f0d24d4c0acd
         * ModifyDate : 2018-07-12T15:01:12.913
         * ModifyBy : dbd9fe7f-affa-44b8-978b-f0d24d4c0acd
         * Status : Active
         * DeleteStatus : No
         * SR_Id : null
         * Address : Andheri DN Nagar
         * Email : omkar2@gmail.com
         * Mobile : 9819716441
         * Image : person-male.png
         */

        private int PW_Id;
        private String Location;
        private Object Duration;
        private String Day;
        private String Starttime;
        private String EndTime;
        private String Name;
        private String OpratingLocation;
        private int PerhoureCost;
        private int PerDayCost;
        private String Profile;
        private String Description;
        private String OpenDays;
        private String CloseDays;
        private Object OpenTime;
        private String CreatedDate;
        private String CreatedBy;
        private String ModifyDate;
        private String ModifyBy;
        private String Status;
        private String DeleteStatus;
        private int SR_Id;
        private String Address;
        private String Email;
        private String Mobile;
        private String Image;

        public int getPW_Id() {
            return PW_Id;
        }

        public void setPW_Id(int PW_Id) {
            this.PW_Id = PW_Id;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public Object getDuration() {
            return Duration;
        }

        public void setDuration(Object Duration) {
            this.Duration = Duration;
        }

        public String getDay() {
            return Day;
        }

        public void setDay(String Day) {
            this.Day = Day;
        }

        public String getStarttime() {
            return Starttime;
        }

        public void setStarttime(String Starttime) {
            this.Starttime = Starttime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getOpratingLocation() {
            return OpratingLocation;
        }

        public void setOpratingLocation(String OpratingLocation) {
            this.OpratingLocation = OpratingLocation;
        }

        public int getPerhoureCost() {
            return PerhoureCost;
        }

        public void setPerhoureCost(int PerhoureCost) {
            this.PerhoureCost = PerhoureCost;
        }

        public int getPerDayCost() {
            return PerDayCost;
        }

        public void setPerDayCost(int PerDayCost) {
            this.PerDayCost = PerDayCost;
        }

        public String getProfile() {
            return Profile;
        }

        public void setProfile(String Profile) {
            this.Profile = Profile;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getOpenDays() {
            return OpenDays;
        }

        public void setOpenDays(String OpenDays) {
            this.OpenDays = OpenDays;
        }

        public String getCloseDays() {
            return CloseDays;
        }

        public void setCloseDays(String CloseDays) {
            this.CloseDays = CloseDays;
        }

        public Object getOpenTime() {
            return OpenTime;
        }

        public void setOpenTime(Object OpenTime) {
            this.OpenTime = OpenTime;
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

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }
    }
}
