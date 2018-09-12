package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.Response.MatingResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class AdoptaPetSingalton implements Serializable {

    public int getPet_Id() {
        return Pet_Id;
    }

    public void setPet_Id(int pet_Id) {
        Pet_Id = pet_Id;
    }

    public String getPet_Name() {
        return Pet_Name;
    }

    public void setPet_Name(String pet_Name) {
        Pet_Name = pet_Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Object getB_Id() {
        return B_Id;
    }

    public void setB_Id(Object b_Id) {
        B_Id = b_Id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getPetStatus() {
        return PetStatus;
    }

    public void setPetStatus(String petStatus) {
        PetStatus = petStatus;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getOwnerContact() {
        return OwnerContact;
    }

    public void setOwnerContact(String ownerContact) {
        OwnerContact = ownerContact;
    }

    public String getOwnerEmail() {
        return OwnerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        OwnerEmail = ownerEmail;
    }

    public String getCreated_Date() {
        return Created_Date;
    }

    public void setCreated_Date(String created_Date) {
        Created_Date = created_Date;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public Object getModified_Date() {
        return Modified_Date;
    }

    public void setModified_Date(Object modified_Date) {
        Modified_Date = modified_Date;
    }

    public Object getModified_By() {
        return Modified_By;
    }

    public void setModified_By(Object modified_By) {
        Modified_By = modified_By;
    }

    public String getDeleteStutus() {
        return DeleteStutus;
    }

    public void setDeleteStutus(String deleteStutus) {
        DeleteStutus = deleteStutus;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Object getCGST() {
        return CGST;
    }

    public void setCGST(Object CGST) {
        this.CGST = CGST;
    }

    public Object getSGST() {
        return SGST;
    }

    public void setSGST(Object SGST) {
        this.SGST = SGST;
    }

    public String getOwnerAddress() {
        return OwnerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        OwnerAddress = ownerAddress;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getBreedName() {
        return BreedName;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public int getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(int SR_Id) {
        this.SR_Id = SR_Id;
    }

    public Object getType() {
        return Type;
    }

    public void setType(Object type) {
        Type = type;
    }

    public Object getC_Id() {
        return C_Id;
    }

    public void setC_Id(Object c_Id) {
        C_Id = c_Id;
    }

    public Object getAdoptPetCount() {
        return AdoptPetCount;
    }

    public void setAdoptPetCount(Object adoptPetCount) {
        AdoptPetCount = adoptPetCount;
    }

    public Object getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(Object pageNumber) {
        PageNumber = pageNumber;
    }

    private int Pet_Id;
    private String Pet_Name;
    private String Title;
    private Object B_Id;
    private String Gender;
    private String Location;
    private String Age;
    private String Condition;
    private String PetStatus;
    private String OwnerName;
    private String OwnerContact;
    private String OwnerEmail;
    private String Created_Date;
    private String Created_By;
    private Object Modified_Date;
    private Object Modified_By;
    private String DeleteStutus;
    private String Status;
    private Object CGST;
    private Object SGST;
    private String OwnerAddress;
    private String Image;
    private int Price;
    private String BreedName;
    private int SR_Id;
    private Object Type;
    private Object C_Id;
    private Object AdoptPetCount;
    private Object PageNumber;


}
