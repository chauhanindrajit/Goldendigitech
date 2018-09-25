package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

/**
 * Created by sanjay on 10/28/2017.
 */

public class AddressSingalton implements Serializable {

    private int RJ_ID;
    private String FullName;

    public int getRJ_ID() {
        return RJ_ID;
    }

    public void setRJ_ID(int RJ_ID) {
        this.RJ_ID = RJ_ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String mobNo) {
        MobNo = mobNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCnfPassword() {
        return CnfPassword;
    }

    public void setCnfPassword(String cnfPassword) {
        CnfPassword = cnfPassword;
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

    public Object getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Object modifyBy) {
        ModifyBy = modifyBy;
    }

    public Object getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Object modifyDate) {
        ModifyDate = modifyDate;
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

    public Object getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(Object shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public Object getShipName() {
        return ShipName;
    }

    public void setShipName(Object shipName) {
        ShipName = shipName;
    }

    public Object getShipContactNo() {
        return ShipContactNo;
    }

    public void setShipContactNo(Object shipContactNo) {
        ShipContactNo = shipContactNo;
    }

    public Object getDATALIST() {
        return DATALIST;
    }

    public void setDATALIST(Object DATALIST) {
        this.DATALIST = DATALIST;
    }

    private String Email;
    private String MobNo;
    private String Password;
    private String CnfPassword;
    private String Address;
    private Object CreatedDate;
    private Object CreatedBy;
    private Object ModifyBy;
    private Object ModifyDate;
    private String Status;
    private Object DeleteStatus;
    private Object ShippingAddress;
    private Object ShipName;
    private Object ShipContactNo;
    private Object DATALIST;
}
