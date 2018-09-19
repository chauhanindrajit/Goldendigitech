package dotcom.com.sam.Response;

import java.util.List;

public class HomeRespose {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"VNM_Id":1,"DoctorName":"Dr. Neerav Poriya","Qualification":"B.V.Sc & A.H, MVSC - Medicine","WorkExperience":"3 Yr","DoctorType":"Veterinarian","Description":"Dr. Krishna Ingole, (B.V.Sc. &A.H.,M.V.Sc Medicine) working as Hospital Registrar, at Bombay Vetterinary College since April 2008.He was Executive production (4 years) at Indian Immunological LTD, Hyderabad.He was responsible for Production of Bacterial vaccine: HS, BQ, ET, Anthrax, Leptospira, and Brucella.Production of viral vaccine: CDV, CAV1, CAV2, CPV, CV, sheep pox, PPR, Blue tongue and Production of Protozoal vaccine: Theileriosis vaccine. Preparation of master and working cell line and media preparation. ","Address":"Thakur Complex Kandiwali ","Cost":null,"Availableday":"Today","AvailableTime":"Monday-Friday (10am - 6pm) Not available: Sat-Sun","Location":"Kandiwali","Link":null,"Createdate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Type":null,"Image":"photo.jpg","SR_Id":null,"AtHomeFees":500,"NearMeFees":300,"DiagnosticsFees":400},{"VNM_Id":2,"DoctorName":"Bipin More","Qualification":"B.V.Sc & A.H, MVSC - Medicine","WorkExperience":"15","DoctorType":"Veterinarian","Description":"Dr. Krishna Ingole, (B.V.Sc. &A.H.,M.V.Sc Medicine) working as Hospital Registrar, at Bombay Vetterinary College since April 2008.He was Executive production (4 years) at Indian Immunological LTD, Hyderabad.He was responsible for Production of Bacterial vaccine: HS, BQ, ET, Anthrax, Leptospira, and Brucella.Production of viral vaccine: CDV, CAV1, CAV2, CPV, CV, sheep pox, PPR, Blue tongue and Production of Protozoal vaccine: Theileriosis vaccine. Preparation of master and working cell line and media preparation","Address":"Shop Number 22, Jangid Home CHS, Jangid Complex Road, Landmark: Near Jangid Estate & Opposite Hetal Park,Mumbai","Cost":null,"Availableday":"Today","AvailableTime":"Monday-Friday (10am - 6pm) Closed: Sat-Sun","Location":"Vile Parle","Link":null,"Createdate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Type":null,"Image":"images (5).jpg","SR_Id":null,"AtHomeFees":600,"NearMeFees":400,"DiagnosticsFees":350},{"VNM_Id":3,"DoctorName":"Dr. Sagar Girase","Qualification":"B.V.Sc & A.H, MVSC - Medicine","WorkExperience":"3","DoctorType":null,"Description":"Dr. Nihar Jayakar is a Veterinary Surgeon and Veterinary Physician in Goregaon West, Mumbai and has an experience of 15 years in these fields. Dr. Nihar Jayakar practices at Pawprints Veterinary Clinic in Goregaon West, Mumbai and Dr. Hitesh Swali's Animal Care Center in Andheri West, Mumbai. He completed B.Sc Microbiology from Bhavans College in 1996, B.V.Sc from Bombay Veterinary College, Mumbai in 2001 and M.V.Sc (Surgery) from Bombay Veterinary College, Mumbai in 2004.","Address":"Shop No. 8, Buildling No. 24, Vaibhav CHS, Shashtri Nagar Road, Landmark: Near Siddarth Hospital, Mumbai","Cost":null,"Availableday":"Today","AvailableTime":"Monday-Friday (10am - 6pm) Closed: Sat-Sun","Location":"Goregaon ","Link":null,"Createdate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Type":null,"Image":"images (7)-1.jpg","SR_Id":null,"AtHomeFees":500,"NearMeFees":null,"DiagnosticsFees":null},{"VNM_Id":4,"DoctorName":"Dr. Harendra Gupta","Qualification":"B.V.Sc & A.H, MVSC - Medicine","WorkExperience":"4","DoctorType":null,"Description":"hop No 8, Sheetal Indraprastha, Sheetal Nagar, Opposite MTNL, Mira Road - 401107","Address":"Borivali Mumbai ","Cost":null,"Availableday":"Today","AvailableTime":"Monday-Friday (10am - 6pm) Closed: Sat-Sun","Location":"Vile Parle","Link":null,"Createdate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"Type":null,"Image":"download (1).jpg","SR_Id":null,"AtHomeFees":500,"NearMeFees":400,"DiagnosticsFees":400}]
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
         * VNM_Id : 1
         * DoctorName : Dr. Neerav Poriya
         * Qualification : B.V.Sc & A.H, MVSC - Medicine
         * WorkExperience : 3 Yr
         * DoctorType : Veterinarian
         * Description : Dr. Krishna Ingole, (B.V.Sc. &A.H.,M.V.Sc Medicine) working as Hospital Registrar, at Bombay Vetterinary College since April 2008.He was Executive production (4 years) at Indian Immunological LTD, Hyderabad.He was responsible for Production of Bacterial vaccine: HS, BQ, ET, Anthrax, Leptospira, and Brucella.Production of viral vaccine: CDV, CAV1, CAV2, CPV, CV, sheep pox, PPR, Blue tongue and Production of Protozoal vaccine: Theileriosis vaccine. Preparation of master and working cell line and media preparation.
         * Address : Thakur Complex Kandiwali
         * Cost : null
         * Availableday : Today
         * AvailableTime : Monday-Friday (10am - 6pm) Not available: Sat-Sun
         * Location : Kandiwali
         * Link : null
         * Createdate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * Type : null
         * Image : photo.jpg
         * SR_Id : null
         * AtHomeFees : 500
         * NearMeFees : 300
         * DiagnosticsFees : 400
         */

        private int VNM_Id;
        private String DoctorName;
        private String Qualification;
        private String WorkExperience;
        private String DoctorType;
        private String Description;
        private String Address;
        private Object Cost;
        private String Availableday;
        private String AvailableTime;
        private String Location;
        private Object Link;
        private Object Createdate;
        private Object CreatedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private Object DeleteStatus;
        private Object Type;
        private String Image;
        private int SR_Id;
        private int AtHomeFees;
        private int NearMeFees;
        private int DiagnosticsFees;

        public int getVNM_Id() {
            return VNM_Id;
        }

        public void setVNM_Id(int VNM_Id) {
            this.VNM_Id = VNM_Id;
        }

        public String getDoctorName() {
            return DoctorName;
        }

        public void setDoctorName(String DoctorName) {
            this.DoctorName = DoctorName;
        }

        public String getQualification() {
            return Qualification;
        }

        public void setQualification(String Qualification) {
            this.Qualification = Qualification;
        }

        public String getWorkExperience() {
            return WorkExperience;
        }

        public void setWorkExperience(String WorkExperience) {
            this.WorkExperience = WorkExperience;
        }

        public String getDoctorType() {
            return DoctorType;
        }

        public void setDoctorType(String DoctorType) {
            this.DoctorType = DoctorType;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public Object getCost() {
            return Cost;
        }

        public void setCost(Object Cost) {
            this.Cost = Cost;
        }

        public String getAvailableday() {
            return Availableday;
        }

        public void setAvailableday(String Availableday) {
            this.Availableday = Availableday;
        }

        public String getAvailableTime() {
            return AvailableTime;
        }

        public void setAvailableTime(String AvailableTime) {
            this.AvailableTime = AvailableTime;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public Object getLink() {
            return Link;
        }

        public void setLink(Object Link) {
            this.Link = Link;
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

        public Object getType() {
            return Type;
        }

        public void setType(Object Type) {
            this.Type = Type;
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

        public int getAtHomeFees() {
            return AtHomeFees;
        }

        public void setAtHomeFees(int AtHomeFees) {
            this.AtHomeFees = AtHomeFees;
        }

        public int getNearMeFees() {
            return NearMeFees;
        }

        public void setNearMeFees(int NearMeFees) {
            this.NearMeFees = NearMeFees;
        }

        public int getDiagnosticsFees() {
            return DiagnosticsFees;
        }

        public void setDiagnosticsFees(int DiagnosticsFees) {
            this.DiagnosticsFees = DiagnosticsFees;
        }
    }
}
