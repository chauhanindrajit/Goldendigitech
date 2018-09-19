package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.DiagonsticResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class DiagonsticSingalton implements Serializable {

    private static final DiagonsticSingalton ourInstance = new DiagonsticSingalton();

    public static DiagonsticSingalton getInstance() {
        return ourInstance;
    }

    private DiagonsticSingalton() {
    }

    public DiagonsticResponse diagonsticResponse() {
        return diagonsticResponse;
    }

    public void DiagonsticResponse(DiagonsticResponse diagonsticResponse) {
        this.diagonsticResponse = diagonsticResponse;
    }

    DiagonsticResponse diagonsticResponse;
    private int DIG_Id;
    private String Location;
    private String CenterName;
    private String Services;
    private String SampleType;
    private String SampleCollectionTimeing;
    private String PetsType;
    private Object OpenDay;
    private Object CloseDay;

    public int getDIG_Id() {
        return DIG_Id;
    }

    public void setDIG_Id(int DIG_Id) {
        this.DIG_Id = DIG_Id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public String getSampleType() {
        return SampleType;
    }

    public void setSampleType(String sampleType) {
        SampleType = sampleType;
    }

    public String getSampleCollectionTimeing() {
        return SampleCollectionTimeing;
    }

    public void setSampleCollectionTimeing(String sampleCollectionTimeing) {
        SampleCollectionTimeing = sampleCollectionTimeing;
    }

    public String getPetsType() {
        return PetsType;
    }

    public void setPetsType(String petsType) {
        PetsType = petsType;
    }

    public Object getOpenDay() {
        return OpenDay;
    }

    public void setOpenDay(Object openDay) {
        OpenDay = openDay;
    }

    public Object getCloseDay() {
        return CloseDay;
    }

    public void setCloseDay(Object closeDay) {
        CloseDay = closeDay;
    }

    public String getOpenDayTime() {
        return OpenDayTime;
    }

    public void setOpenDayTime(String openDayTime) {
        OpenDayTime = openDayTime;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Object getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Object createdDate) {
        CreatedDate = createdDate;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Object getEmail() {
        return Email;
    }

    public void setEmail(Object email) {
        Email = email;
    }

    public int getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(int SR_Id) {
        this.SR_Id = SR_Id;
    }

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


}
