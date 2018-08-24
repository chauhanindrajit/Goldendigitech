package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class CategorySingalton implements Serializable {

    private static final CategorySingalton ourInstance = new CategorySingalton();

    public static CategorySingalton getInstance() {
        return ourInstance;
    }

    public CategorySingalton() {
    }

    public RegistrationResponse getRegistrationResponse() {
        return registrationResponse;
    }

    public void RegistrationResponse(RegistrationResponse getRegistrationResponse) {
        this.registrationResponse = registrationResponse;
    }

    RegistrationResponse registrationResponse;



    private int C_Id;
    private String CategosryName;

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

    public Object getStatus() {
        return Status;
    }

    public void setStatus(Object status) {
        Status = status;
    }

    public Object getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(Object deleteStatus) {
        DeleteStatus = deleteStatus;
    }
    public List<RegistrationResponse.ResponseBean.SubCategoriesBean> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<RegistrationResponse.ResponseBean.SubCategoriesBean> subCategories) {
        this.subCategories = subCategories;
    }

    private Object Createdate;
    private Object CreatedBy;
    private Object ModifyBy;
    private Object ModifyDate;
    private Object Status;
    private Object DeleteStatus;
    private Integer cateID;
    private Integer SubcateID;
    private String subname;
    private String Cat;
    public ArrayList<String> SUBCATNAME;
    private List<RegistrationResponse.ResponseBean.SubCategoriesBean> subCategories;


    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }


    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public Integer getSubcateID() {
        return SubcateID;
    }

    public void setSubcateID(Integer subcateID) {
        SubcateID = subcateID;
    }

    public String getCat() {
        return Cat;
    }

    public void setCat(String cat) {
        Cat = cat;
    }

    public ArrayList<String> getSUBCATNAME() {
        return SUBCATNAME;
    }

    public void setSUBCATNAME(ArrayList<String> SUBCATNAME) {
        this.SUBCATNAME = SUBCATNAME;
    }
}
