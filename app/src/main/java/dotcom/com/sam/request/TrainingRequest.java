package dotcom.com.sam.request;

/**
 * Created by sanjay on 10/25/2017.
 */

public class TrainingRequest {

    private int TS_Id;
    private String CenterName;
    private String Address;
    private String Location;
    private String Services;
    private Object Fees;
    private String Discription;
    private String OpenDay;
    private Object Opentime;
    private String CloseDay;

    public int getTS_Id() {
        return TS_Id;
    }

    public void setTS_Id(int TS_Id) {
        this.TS_Id = TS_Id;
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

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public Object getFees() {
        return Fees;
    }

    public void setFees(Object fees) {
        Fees = fees;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public String getOpenDay() {
        return OpenDay;
    }

    public void setOpenDay(String openDay) {
        OpenDay = openDay;
    }

    public Object getOpentime() {
        return Opentime;
    }

    public void setOpentime(Object opentime) {
        Opentime = opentime;
    }

    public String getCloseDay() {
        return CloseDay;
    }

    public void setCloseDay(String closeDay) {
        CloseDay = closeDay;
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

    public Object getCretaedBy() {
        return CretaedBy;
    }

    public void setCretaedBy(Object cretaedBy) {
        CretaedBy = cretaedBy;
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    private String Image;
    private Object SR_Id;
    private Object CreatedDate;
    private Object CretaedBy;
    private Object ModifyDate;
    private Object ModifyBy;
    private String Status;
    private Object DeleteStatus;
    private String Mobile;
}
