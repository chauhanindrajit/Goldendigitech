package dotcom.com.sam.request;

import com.google.gson.Gson;

/**
 * Created by sanjay on 10/25/2017.
 */

public class LoginRequest {

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

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String modifyDate) {
        ModifyDate = modifyDate;
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

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipContactNo() {
        return ShipContactNo;
    }

    public void setShipContactNo(String shipContactNo) {
        ShipContactNo = shipContactNo;
    }

    private int RJ_ID;
    private String FullName;
    private String Email;
    private String MobNo;
    private String Password;
    private String CnfPassword;
    private String Address;
    private String CreatedDate;
    private String CreatedBy;
    private String ModifyBy;
    private String ModifyDate;
    private String Status;
    private String DeleteStatus;
    private String ShippingAddress;
    private String ShipName;
    private String ShipContactNo;
}
