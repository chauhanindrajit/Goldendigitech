package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;

import dotcom.com.sam.Response.AdoptpetResponse;
import dotcom.com.sam.Response.NewArrivalResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class NewArrivalSingalton implements Serializable {

    private static final NewArrivalSingalton ourInstance = new NewArrivalSingalton();

    public static NewArrivalSingalton getInstance() {
        return ourInstance;
    }

    public NewArrivalSingalton() {
    }

    public NewArrivalResponse newArrivalResponse() {
        return newArrivalResponse;
    }

    public void NewArrivalResponse(NewArrivalResponse newArrivalResponse) {
        this.newArrivalResponse = newArrivalResponse;
    }

    NewArrivalResponse newArrivalResponse;

    private int PT_Id;
    private String Image;
    private int Price;

    public int getPT_Id() {
        return PT_Id;
    }

    public void setPT_Id(int PT_Id) {
        this.PT_Id = PT_Id;
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

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public int getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        DiscountPrice = discountPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Object getTitle1() {
        return Title1;
    }

    public void setTitle1(Object title1) {
        Title1 = title1;
    }

    public String getTitle2() {
        return Title2;
    }

    public void setTitle2(String title2) {
        Title2 = title2;
    }

    public Object getPack() {
        return Pack;
    }

    public void setPack(Object pack) {
        Pack = pack;
    }

    public int getC_Id() {
        return C_Id;
    }

    public void setC_Id(int c_Id) {
        C_Id = c_Id;
    }

    public int getSc_Id() {
        return Sc_Id;
    }

    public void setSc_Id(int sc_Id) {
        Sc_Id = sc_Id;
    }

    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int p_Id) {
        P_Id = p_Id;
    }

    public Object getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Object createDate) {
        CreateDate = createDate;
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

    public String getSubCategoryName() {
        return SubCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        SubCategoryName = subCategoryName;
    }

    public String getCategosryName() {
        return CategosryName;
    }

    public void setCategosryName(String categosryName) {
        CategosryName = categosryName;
    }

    public String getProductCategoryName() {
        return ProductCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        ProductCategoryName = productCategoryName;
    }

    public Object getBrand() {
        return Brand;
    }

    public void setBrand(Object brand) {
        Brand = brand;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Object getBreed() {
        return Breed;
    }

    public void setBreed(Object breed) {
        Breed = breed;
    }

    public String getFoodtype() {
        return Foodtype;
    }

    public void setFoodtype(String foodtype) {
        Foodtype = foodtype;
    }

    public String getFoodCategories() {
        return FoodCategories;
    }

    public void setFoodCategories(String foodCategories) {
        FoodCategories = foodCategories;
    }

    public String getProductFeatured() {
        return ProductFeatured;
    }

    public void setProductFeatured(String productFeatured) {
        ProductFeatured = productFeatured;
    }

    public Object getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(Object SR_Id) {
        this.SR_Id = SR_Id;
    }

    public int getB_Id() {
        return B_Id;
    }

    public void setB_Id(int b_Id) {
        B_Id = b_Id;
    }

    public String getBreedName() {
        return BreedName;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public int getBRAND_Id() {
        return BRAND_Id;
    }

    public void setBRAND_Id(int BRAND_Id) {
        this.BRAND_Id = BRAND_Id;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    private String Discount;
    private int DiscountPrice;
    private String ProductName;
    private Object Title1;
    private String Title2;
    private Object Pack;
    private int C_Id;
    private int Sc_Id;
    private int P_Id;
    private Object CreateDate;
    private Object CreatedBy;
    private Object ModifyDate;
    private Object ModifyBy;
    private String Status;
    private Object DeleteStatus;
    private String SubCategoryName;
    private String CategosryName;
    private String ProductCategoryName;
    private Object Brand;
    private String Age;
    private Object Breed;
    private String Foodtype;
    private String FoodCategories;
    private String ProductFeatured;
    private Object SR_Id;
    private int B_Id;
    private String BreedName;
    private int BRAND_Id;
    private String BrandName;

}
