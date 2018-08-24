package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class SubcategorySingalton implements Serializable {

    private static final SubcategorySingalton ourInstance = new SubcategorySingalton();

    public static SubcategorySingalton getInstance() {
        return ourInstance;
    }

    public SubcategorySingalton() {
    }

    public RegistrationResponse getRegistrationResponse() {
        return registrationResponse;
    }

    public void RegistrationResponse(RegistrationResponse getRegistrationResponse) {
        this.registrationResponse = registrationResponse;
    }

    RegistrationResponse registrationResponse;

    private int Sc_Id;
    private String SubCategoryName;
    private Object Cretaedate;

    public int getSc_Id() {
        return Sc_Id;
    }

    public void setSc_Id(int sc_Id) {
        Sc_Id = sc_Id;
    }

    public String getSubCategoryName() {
        return SubCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        SubCategoryName = subCategoryName;
    }

    public Object getCretaedate() {
        return Cretaedate;
    }

    public void setCretaedate(Object cretaedate) {
        Cretaedate = cretaedate;
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

    public String getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        DeleteStatus = deleteStatus;
    }

    public int getC_Id() {
        return C_Id;
    }

    public void setC_Id(int c_Id) {
        C_Id = c_Id;
    }

    public String getCategosryName() {
        return CategosryName;
    }

    public void setCategosryName(String categosryName) {
        CategosryName = categosryName;
    }

    public Object getImage() {
        return Image;
    }

    public void setImage(Object image) {
        Image = image;
    }

    public Object getProdList() {
        return prodList;
    }

    public void setProdList(Object prodList) {
        this.prodList = prodList;
    }

    private Object CretaedBy;
    private Object ModifyDate;
    private Object ModifyBy;
    private String Status;
    private String DeleteStatus;
    private int C_Id;
    private String CategosryName;
    private Object Image;
    private Object prodList;
    private int S_tag;

    public int getS_tag() {
        return S_tag;
    }

    public void setS_tag(int s_tag) {
        S_tag = s_tag;
    }
}
