package dotcom.com.sam.Response;

import java.util.List;

public class DiagonsticResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"DIG_Id":1,"Location":"Goregaon ","CenterName":"Aspira Diagnostics","Services":"X-Rays, CT Scan, MRI ","SampleType":"Blood, Urine, Stool","SampleCollectionTimeing":"11 am - 6 pm","PetsType":"Dog, Cat ","OpenDay":null,"CloseDay":null,"OpenDayTime":"Monday-Friday (10am - 6pm) Closed: Sat-Sun","Address":"Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai","CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Image":"pathology-labs.jpg","Email":null,"SR_Id":null},{"DIG_Id":2,"Location":"Vile Parle","CenterName":"Bipin Diagnostic Centre","Services":"X-Rays, CT Scan, MRI ","SampleType":"Blood, Urine, Stool","SampleCollectionTimeing":"11 am - 6 pm","PetsType":"Dog, Cat ","OpenDay":null,"CloseDay":null,"OpenDayTime":"Monday-Friday (10am - 6pm) Closed: Sat-Sun","Address":"Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai","CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Image":"pathology-labs-1.jpg","Email":null,"SR_Id":null}]
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
         * DIG_Id : 1
         * Location : Goregaon
         * CenterName : Aspira Diagnostics
         * Services : X-Rays, CT Scan, MRI
         * SampleType : Blood, Urine, Stool
         * SampleCollectionTimeing : 11 am - 6 pm
         * PetsType : Dog, Cat
         * OpenDay : null
         * CloseDay : null
         * OpenDayTime : Monday-Friday (10am - 6pm) Closed: Sat-Sun
         * Address : Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai
         * CreatedDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * Image : pathology-labs.jpg
         * Email : null
         * SR_Id : null
         */

        private int DIG_Id;
        private String Location;
        private String CenterName;
        private String Services;
        private String SampleType;
        private String SampleCollectionTimeing;
        private String PetsType;
        private Object OpenDay;
        private Object CloseDay;
        private String OpenDayTime;
        private String Address;
        private Object CreatedDate;
        private Object CreatedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private Object DeleteStatus;
        private String Image;
        private Object Email;
        private int SR_Id;

        public int getDIG_Id() {
            return DIG_Id;
        }

        public void setDIG_Id(int DIG_Id) {
            this.DIG_Id = DIG_Id;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getCenterName() {
            return CenterName;
        }

        public void setCenterName(String CenterName) {
            this.CenterName = CenterName;
        }

        public String getServices() {
            return Services;
        }

        public void setServices(String Services) {
            this.Services = Services;
        }

        public String getSampleType() {
            return SampleType;
        }

        public void setSampleType(String SampleType) {
            this.SampleType = SampleType;
        }

        public String getSampleCollectionTimeing() {
            return SampleCollectionTimeing;
        }

        public void setSampleCollectionTimeing(String SampleCollectionTimeing) {
            this.SampleCollectionTimeing = SampleCollectionTimeing;
        }

        public String getPetsType() {
            return PetsType;
        }

        public void setPetsType(String PetsType) {
            this.PetsType = PetsType;
        }

        public Object getOpenDay() {
            return OpenDay;
        }

        public void setOpenDay(Object OpenDay) {
            this.OpenDay = OpenDay;
        }

        public Object getCloseDay() {
            return CloseDay;
        }

        public void setCloseDay(Object CloseDay) {
            this.CloseDay = CloseDay;
        }

        public String getOpenDayTime() {
            return OpenDayTime;
        }

        public void setOpenDayTime(String OpenDayTime) {
            this.OpenDayTime = OpenDayTime;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
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

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public Object getEmail() {
            return Email;
        }

        public void setEmail(Object Email) {
            this.Email = Email;
        }

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }
    }
}
