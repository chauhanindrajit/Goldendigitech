package dotcom.com.sam.Response;

import java.util.List;

public class PetSitterResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"PS_Id":0,"Name":"Jane Doe","OperatingLocation":"Home","PetAvailability":null,"Fees":400,"Description":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has bbeen the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type... ","ServicesType":"Bathing","Mobile":"7303066164","Email":"Rahul@gmail.com","Location":"Goregaon","Address":"Mumbai Goregaon","StartDate":null,"EndDate":null,"StartTime":"6pm","EndTime":"5pm","Image":"grooming-center1-2.jpg","SR_Id":null,"CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Duration":"short"}]
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
         * PS_Id : 0
         * Name : Jane Doe
         * OperatingLocation : Home
         * PetAvailability : null
         * Fees : 400
         * Description : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has bbeen the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...
         * ServicesType : Bathing
         * Mobile : 7303066164
         * Email : Rahul@gmail.com
         * Location : Goregaon
         * Address : Mumbai Goregaon
         * StartDate : null
         * EndDate : null
         * StartTime : 6pm
         * EndTime : 5pm
         * Image : grooming-center1-2.jpg
         * SR_Id : null
         * CreatedDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * Duration : short
         */

        private int PS_Id;
        private String Name;
        private String OperatingLocation;
        private Object PetAvailability;
        private int Fees;
        private String Description;
        private String ServicesType;
        private String Mobile;
        private String Email;
        private String Location;
        private String Address;
        private Object StartDate;
        private Object EndDate;
        private String StartTime;
        private String EndTime;
        private String Image;
        private Object SR_Id;
        private Object CreatedDate;
        private Object CreatedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private Object DeleteStatus;
        private String Duration;

        public int getPS_Id() {
            return PS_Id;
        }

        public void setPS_Id(int PS_Id) {
            this.PS_Id = PS_Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getOperatingLocation() {
            return OperatingLocation;
        }

        public void setOperatingLocation(String OperatingLocation) {
            this.OperatingLocation = OperatingLocation;
        }

        public Object getPetAvailability() {
            return PetAvailability;
        }

        public void setPetAvailability(Object PetAvailability) {
            this.PetAvailability = PetAvailability;
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

        public String getServicesType() {
            return ServicesType;
        }

        public void setServicesType(String ServicesType) {
            this.ServicesType = ServicesType;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public Object getStartDate() {
            return StartDate;
        }

        public void setStartDate(Object StartDate) {
            this.StartDate = StartDate;
        }

        public Object getEndDate() {
            return EndDate;
        }

        public void setEndDate(Object EndDate) {
            this.EndDate = EndDate;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public Object getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(Object SR_Id) {
            this.SR_Id = SR_Id;
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

        public String getDuration() {
            return Duration;
        }

        public void setDuration(String Duration) {
            this.Duration = Duration;
        }
    }
}
