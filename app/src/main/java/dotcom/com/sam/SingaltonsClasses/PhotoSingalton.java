package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;
import java.util.List;

/**
 * Created by sanjay on 10/28/2017.
 */

public class PhotoSingalton implements Serializable {

    private int PG_Id;
    private String Name;
    private String PhotographerCategory;

    public int getPG_Id() {
        return PG_Id;
    }

    public void setPG_Id(int PG_Id) {
        this.PG_Id = PG_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhotographerCategory() {
        return PhotographerCategory;
    }

    public void setPhotographerCategory(String photographerCategory) {
        PhotographerCategory = photographerCategory;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getCourses() {
        return Courses;
    }

    public void setCourses(String courses) {
        Courses = courses;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getMultipalImage() {
        return MultipalImage;
    }

    public void setMultipalImage(String multipalImage) {
        MultipalImage = multipalImage;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
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

    public void setModifyDate(Object modifyDate) {
        ModifyDate = modifyDate;
    }

    public Object getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Object modifyBy) {
        ModifyBy = modifyBy;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        DeleteStatus = deleteStatus;
    }

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

    public String getImgUrl() {
        return String.valueOf(imgUrl);
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }
}
