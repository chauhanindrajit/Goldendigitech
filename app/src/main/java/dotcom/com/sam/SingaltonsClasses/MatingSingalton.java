package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.MatingResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class MatingSingalton implements Serializable {

    private static final MatingSingalton ourInstance = new MatingSingalton();

    public static MatingSingalton getInstance() {
        return ourInstance;
    }

    public MatingSingalton() {
    }

    public MatingResponse getMatingResponse() {
        return matingResponse;
    }

    public void MatingResponse(MatingResponse getHomeRespose) {
        this.matingResponse = getHomeRespose;
    }

    MatingResponse matingResponse;

    private int MAT_Id;
    private String PetName;
    private String Location;
    private String Pettype;
    private int B_Id;
    private String Gender;
    private String Age;
    private String OwnerName;
    private String ContactNo;
    private String Address;
    private String Image;
    private String Status;
    private Object DeleteStatus;

    public int getMAT_Id() {
        return MAT_Id;
    }

    public void setMAT_Id(int MAT_Id) {
        this.MAT_Id = MAT_Id;
    }

    public String getPetName() {
        return PetName;
    }

    public void setPetName(String petName) {
        PetName = petName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPettype() {
        return Pettype;
    }

    public void setPettype(String pettype) {
        Pettype = pettype;
    }

    public int getB_Id() {
        return B_Id;
    }

    public void setB_Id(int b_Id) {
        B_Id = b_Id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
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

    public Object getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Object createdBy) {
        CreatedBy = createdBy;
    }

    public Object getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Object createDate) {
        CreateDate = createDate;
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

    public Object getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(Object SR_Id) {
        this.SR_Id = SR_Id;
    }

    public String getBreedName() {
        return BreedName;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public Object getToDayDate() {
        return ToDayDate;
    }

    public void setToDayDate(Object toDayDate) {
        ToDayDate = toDayDate;
    }

    public int getCalYear() {
        return CalYear;
    }

    public void setCalYear(int calYear) {
        CalYear = calYear;
    }

    public int getCalmonth() {
        return Calmonth;
    }

    public void setCalmonth(int calmonth) {
        Calmonth = calmonth;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    private Object CreatedBy;
    private Object CreateDate;
    private Object ModifyDate;
    private Object ModifyBy;
    private Object SR_Id;
    private String BreedName;
    private Object ToDayDate;
    private int CalYear;
    private int Calmonth;
    private int Day;



}
