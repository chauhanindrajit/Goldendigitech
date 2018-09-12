package dotcom.com.sam.Response;

import java.util.List;

public class MatingResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"MAT_Id":1,"PetName":"Rambo (Bangalore)","Location":"Goregaon East","Pettype":"DOG","B_Id":1,"Gender":"Male","Age":"2018-05-17","OwnerName":"Rahul kumar","ContactNo":"7303066164","Address":"Mumbai Goregaon East ","Image":"adopted-pet-2.jpg","Status":"Active","DeleteStatus":null,"CreatedBy":null,"CreateDate":null,"ModifyDate":null,"ModifyBy":null,"SR_Id":null,"BreedName":"Affenpinscher","ToDayDate":null,"CalYear":0,"Calmonth":2,"Day":8},{"MAT_Id":2,"PetName":"Shera","Location":"Goregaon West","Pettype":"DOG","B_Id":3,"Gender":"Male","Age":"2018-04-11","OwnerName":"Rahul kumar","ContactNo":"7303066164","Address":"Goregaon West","Image":"adopted-pet-2-1.jpg","Status":"Active","DeleteStatus":null,"CreatedBy":null,"CreateDate":null,"ModifyDate":null,"ModifyBy":null,"SR_Id":null,"BreedName":"Airedale Terrier","ToDayDate":null,"CalYear":0,"Calmonth":3,"Day":14},{"MAT_Id":3,"PetName":"Tony","Location":"Kandiwali","Pettype":"DOG","B_Id":1,"Gender":"Female","Age":"2017-11-24","OwnerName":"Rahul kumar","ContactNo":"7303066164","Address":"Kandiwali East","Image":"adopted-pet-2-2.jpg","Status":"Active","DeleteStatus":null,"CreatedBy":null,"CreateDate":null,"ModifyDate":null,"ModifyBy":null,"SR_Id":null,"BreedName":"Affenpinscher","ToDayDate":null,"CalYear":1,"Calmonth":-4,"Day":1}]
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
         * MAT_Id : 1
         * PetName : Rambo (Bangalore)
         * Location : Goregaon East
         * Pettype : DOG
         * B_Id : 1
         * Gender : Male
         * Age : 2018-05-17
         * OwnerName : Rahul kumar
         * ContactNo : 7303066164
         * Address : Mumbai Goregaon East
         * Image : adopted-pet-2.jpg
         * Status : Active
         * DeleteStatus : null
         * CreatedBy : null
         * CreateDate : null
         * ModifyDate : null
         * ModifyBy : null
         * SR_Id : null
         * BreedName : Affenpinscher
         * ToDayDate : null
         * CalYear : 0
         * Calmonth : 2
         * Day : 8
         */

        private int MAT_Id;
        private String PetName;
        private String Location;
        private String Pettype;
        private int B_Id;
        private String Gender;
        private String Age;
        private String OwnerName;
        private String ContactNo;
        private String Address;
        private String Image;
        private String Status;
        private Object DeleteStatus;
        private Object CreatedBy;
        private Object CreateDate;
        private Object ModifyDate;
        private Object ModifyBy;
        private int SR_Id;
        private String BreedName;
        private Object ToDayDate;
        private int CalYear;
        private int Calmonth;
        private int Day;

        public int getMAT_Id() {
            return MAT_Id;
        }

        public void setMAT_Id(int MAT_Id) {
            this.MAT_Id = MAT_Id;
        }

        public String getPetName() {
            return PetName;
        }

        public void setPetName(String PetName) {
            this.PetName = PetName;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getPettype() {
            return Pettype;
        }

        public void setPettype(String Pettype) {
            this.Pettype = Pettype;
        }

        public int getB_Id() {
            return B_Id;
        }

        public void setB_Id(int B_Id) {
            this.B_Id = B_Id;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getContactNo() {
            return ContactNo;
        }

        public void setContactNo(String ContactNo) {
            this.ContactNo = ContactNo;
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

        public Object getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(Object CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public Object getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(Object CreateDate) {
            this.CreateDate = CreateDate;
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

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public String getBreedName() {
            return BreedName;
        }

        public void setBreedName(String BreedName) {
            this.BreedName = BreedName;
        }

        public Object getToDayDate() {
            return ToDayDate;
        }

        public void setToDayDate(Object ToDayDate) {
            this.ToDayDate = ToDayDate;
        }

        public int getCalYear() {
            return CalYear;
        }

        public void setCalYear(int CalYear) {
            this.CalYear = CalYear;
        }

        public int getCalmonth() {
            return Calmonth;
        }

        public void setCalmonth(int Calmonth) {
            this.Calmonth = Calmonth;
        }

        public int getDay() {
            return Day;
        }

        public void setDay(int Day) {
            this.Day = Day;
        }
    }
}
