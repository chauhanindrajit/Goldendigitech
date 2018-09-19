package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.HomeRespose;

/**
 * Created by sanjay on 10/28/2017.
 */

public class HomeSingalton implements Serializable {

    private static final HomeSingalton ourInstance = new HomeSingalton();

    public static HomeSingalton getInstance() {
        return ourInstance;
    }

    private HomeSingalton() {
    }

    public HomeRespose getHomeRespose() {
        return homeRespose;
    }

    public void HomeRespose(HomeRespose getHomeRespose) {
        this.homeRespose = getHomeRespose;
    }

    HomeRespose homeRespose;

    public int getVNM_Id() {
        return VNM_Id;
    }

    public void setVNM_Id(int VNM_Id) {
        this.VNM_Id = VNM_Id;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(String doctorType) {
        DoctorType = doctorType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Object getCost() {
        return Cost;
    }

    public void setCost(Object cost) {
        Cost = cost;
    }

    public String getAvailableday() {
        return Availableday;
    }

    public void setAvailableday(String availableday) {
        Availableday = availableday;
    }

    public String getAvailableTime() {
        return AvailableTime;
    }

    public void setAvailableTime(String availableTime) {
        AvailableTime = availableTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Object getLink() {
        return Link;
    }

    public void setLink(Object link) {
        Link = link;
    }

    public Object getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(Object createdate) {
        Createdate = createdate;
    }

    public Object getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Object createdBy) {
        CreatedBy = createdBy;
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

    public Object getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(Object deleteStatus) {
        DeleteStatus = deleteStatus;
    }

    public Object getType() {
        return Type;
    }

    public void setType(Object type) {
        Type = type;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
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

    public void setAtHomeFees(int atHomeFees) {
        AtHomeFees = atHomeFees;
    }

    public int getNearMeFees() {
        return NearMeFees;
    }

    public void setNearMeFees(int nearMeFees) {
        NearMeFees = nearMeFees;
    }

    public int getDiagnosticsFees() {
        return DiagnosticsFees;
    }

    public void setDiagnosticsFees(int diagnosticsFees) {
        DiagnosticsFees = diagnosticsFees;
    }

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




}
