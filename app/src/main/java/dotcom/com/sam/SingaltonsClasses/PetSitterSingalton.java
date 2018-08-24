package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.MatingResponse;
import dotcom.com.sam.Response.PetSitterResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class PetSitterSingalton implements Serializable {

    private static final PetSitterSingalton ourInstance = new PetSitterSingalton();

    public static PetSitterSingalton getInstance() {
        return ourInstance;
    }

    public PetSitterSingalton() {
    }

    public PetSitterResponse petSitterResponse() {
        return petSitterResponse;
    }

    public void PetSitterResponse(PetSitterResponse petSitterResponse) {
        this.petSitterResponse = petSitterResponse;
    }

    PetSitterResponse petSitterResponse;

    public int getPS_Id() {
        return PS_Id;
    }

    public void setPS_Id(int PS_Id) {
        this.PS_Id = PS_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOperatingLocation() {
        return OperatingLocation;
    }

    public void setOperatingLocation(String operatingLocation) {
        OperatingLocation = operatingLocation;
    }

    public Object getPetAvailability() {
        return PetAvailability;
    }

    public void setPetAvailability(Object petAvailability) {
        PetAvailability = petAvailability;
    }

    public int getFees() {
        return Fees;
    }

    public void setFees(int fees) {
        Fees = fees;
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Object getStartDate() {
        return StartDate;
    }

    public void setStartDate(Object startDate) {
        StartDate = startDate;
    }

    public Object getEndDate() {
        return EndDate;
    }

    public void setEndDate(Object endDate) {
        EndDate = endDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
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

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

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

}
