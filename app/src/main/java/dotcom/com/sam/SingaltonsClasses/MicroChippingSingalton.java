package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.HomeRespose;
import dotcom.com.sam.Response.MicroChippingRespose;

/**
 * Created by sanjay on 10/28/2017.
 */

public class MicroChippingSingalton implements Serializable {

    private static final MicroChippingSingalton ourInstance = new MicroChippingSingalton();

    public static MicroChippingSingalton getInstance() {
        return ourInstance;
    }

    public MicroChippingSingalton() {
    }

    public MicroChippingRespose microChippingRespose() {
        return microChippingRespose;
    }

    public void MicroChippingRespose(MicroChippingRespose microChippingRespose ) {
        this.microChippingRespose = microChippingRespose;
    }

    MicroChippingRespose microChippingRespose;


    private int PS_Id;
    private String Image;
    private String CenterName;
    private String Address;
    private String Location;
    private int Fees;
    private String Description;
    private String OpenDay;
    private String Time;
    private String CloseDay;
    private String MobileNo;
    private int SR_Id;
    private String CreatedDate;
    private String CreatedBy;
    private String ModifyDate;

    public int getPS_Id() {
        return PS_Id;
    }

    public void setPS_Id(int PS_Id) {
        this.PS_Id = PS_Id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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

    public String getOpenDay() {
        return OpenDay;
    }

    public void setOpenDay(String openDay) {
        OpenDay = openDay;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCloseDay() {
        return CloseDay;
    }

    public void setCloseDay(String closeDay) {
        CloseDay = closeDay;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public int getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(int SR_Id) {
        this.SR_Id = SR_Id;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String modifyDate) {
        ModifyDate = modifyDate;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
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

    public String getPdf() {
        return Pdf;
    }

    public void setPdf(String pdf) {
        Pdf = pdf;
    }

    private String ModifyBy;
    private String Status;
    private String DeleteStatus;
    private String Pdf;


}
