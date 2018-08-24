package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.HomeRespose;
import dotcom.com.sam.Response.OldPetResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class OldHomeSingalton implements Serializable {

    private static final OldHomeSingalton ourInstance = new OldHomeSingalton();

    public static OldHomeSingalton getInstance() {
        return ourInstance;
    }

    private OldHomeSingalton() {
    }

    public OldPetResponse getHomeRespose() {
        return oldPetResponse;
    }

    public void OldPetResponse(OldPetResponse getHomeRespose) {
        this.oldPetResponse = getHomeRespose;
    }

    OldPetResponse oldPetResponse;

    private int OAH_Id;
    private String HomeName;
    private String Location;
    private String PetType;

    public int getOAH_Id() {
        return OAH_Id;
    }

    public void setOAH_Id(int OAH_Id) {
        this.OAH_Id = OAH_Id;
    }

    public String getHomeName() {
        return HomeName;
    }

    public void setHomeName(String homeName) {
        HomeName = homeName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPetType() {
        return PetType;
    }

    public void setPetType(String petType) {
        PetType = petType;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String aPackage) {
        Package = aPackage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getServicesType() {
        return ServicesType;
    }

    public void setServicesType(String servicesType) {
        ServicesType = servicesType;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Object getPdf() {
        return Pdf;
    }

    public void setPdf(Object pdf) {
        Pdf = pdf;
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

    public Object getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(Object SR_Id) {
        this.SR_Id = SR_Id;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    private int Amount;
    private String Package;
    private String Description;
    private String ServicesType;
    private String OwnerName;
    private String Address;
    private String Image;
    private Object Pdf;
    private Object CreatedDate;
    private Object CreatedBy;
    private Object ModifyDate;
    private Object ModifyBy;
    private String Status;
    private Object DeleteStatus;
    private Object SR_Id;
    private String MobileNo;


}
