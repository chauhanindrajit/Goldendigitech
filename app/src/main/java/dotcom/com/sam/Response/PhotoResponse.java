package dotcom.com.sam.Response;

import java.util.List;

public class PhotoResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"PG_Id":1,"Name":"Rahul","PhotographerCategory":"All Pet","Location":"Goregaon","Qualification":"B.E","Courses":"Advanced Diploma in Photography","Exp":"2.5","About":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ","MultipalImage":"Puppy-2.jpg,Puppy2-2.jpg,","Image":"photographer-1-2.jpg","SR_Id":null,"createdate":null,"createdBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":"No","imgUrl":["Puppy-2.jpg","Puppy2-2.jpg",""]}]
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
         * PG_Id : 1
         * Name : Rahul
         * PhotographerCategory : All Pet
         * Location : Goregaon
         * Qualification : B.E
         * Courses : Advanced Diploma in Photography
         * Exp : 2.5
         * About : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
         * MultipalImage : Puppy-2.jpg,Puppy2-2.jpg,
         * Image : photographer-1-2.jpg
         * SR_Id : null
         * createdate : null
         * createdBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : No
         * imgUrl : ["Puppy-2.jpg","Puppy2-2.jpg",""]
         */

        private int PG_Id;
        private String Name;
        private String PhotographerCategory;
        private String Location;
        private String Qualification;
        private String Courses;
        private String Exp;
        private String About;
        private String MultipalImage;
        private String Image;
        private Object SR_Id;
        private Object createdate;
        private Object createdBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private String DeleteStatus;
        private List<String> imgUrl;

        public int getPG_Id() {
            return PG_Id;
        }

        public void setPG_Id(int PG_Id) {
            this.PG_Id = PG_Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getPhotographerCategory() {
            return PhotographerCategory;
        }

        public void setPhotographerCategory(String PhotographerCategory) {
            this.PhotographerCategory = PhotographerCategory;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getQualification() {
            return Qualification;
        }

        public void setQualification(String Qualification) {
            this.Qualification = Qualification;
        }

        public String getCourses() {
            return Courses;
        }

        public void setCourses(String Courses) {
            this.Courses = Courses;
        }

        public String getExp() {
            return Exp;
        }

        public void setExp(String Exp) {
            this.Exp = Exp;
        }

        public String getAbout() {
            return About;
        }

        public void setAbout(String About) {
            this.About = About;
        }

        public String getMultipalImage() {
            return MultipalImage;
        }

        public void setMultipalImage(String MultipalImage) {
            this.MultipalImage = MultipalImage;
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

        public Object getCreatedate() {
            return createdate;
        }

        public void setCreatedate(Object createdate) {
            this.createdate = createdate;
        }

        public Object getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Object createdBy) {
            this.createdBy = createdBy;
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

        public String getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(String DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }

        public List<String> getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(List<String> imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
