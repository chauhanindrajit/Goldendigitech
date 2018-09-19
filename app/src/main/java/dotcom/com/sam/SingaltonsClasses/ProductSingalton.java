package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;
import java.util.List;

import dotcom.com.sam.Response.ProductResponse;
import dotcom.com.sam.extras.RegistrationResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class ProductSingalton implements Serializable {

    private static final ProductSingalton ourInstance = new ProductSingalton();

    public static ProductSingalton getInstance() {
        return ourInstance;
    }

    public ProductSingalton() {
    }

    public ProductResponse productResponse() {
        return productResponse;
    }

    public void ProductResponse(ProductResponse productResponse) {
        this.productResponse = productResponse;
    }

    ProductResponse productResponse;
    private int Sc_Id;
    private String SubCategoryName;
    private String Cretaedate;
    private String CretaedBy;

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

    public String getCretaedate() {
        return Cretaedate;
    }

    public void setCretaedate(String cretaedate) {
        Cretaedate = cretaedate;
    }

    public String getCretaedBy() {
        return CretaedBy;
    }

    public void setCretaedBy(String cretaedBy) {
        CretaedBy = cretaedBy;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public List<ProductResponse.ResponseBean.ProdListBean> getProdList() {
        return prodList;
    }

    public void setProdList(List<ProductResponse.ResponseBean.ProdListBean> prodList) {
        this.prodList = prodList;
    }

    public List<ProductResponse.ResponseBean.FilterListBean> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<ProductResponse.ResponseBean.FilterListBean> filterList) {
        this.filterList = filterList;
    }

    private String ModifyDate;
    private String ModifyBy;
    private String Status;
    private String DeleteStatus;
    private int C_Id;
    private String CategosryName;
    private String Image;
    private List<ProductResponse.ResponseBean.ProdListBean> prodList;
    private List<ProductResponse.ResponseBean.FilterListBean> filterList;
    private int PT_Id;
    private int Price;
    private String Discount;
    private String DiscountPrice;

    public int getPT_Id() {
        return PT_Id;
    }

    public void setPT_Id(int PT_Id) {
        this.PT_Id = PT_Id;
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

    public String getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        DiscountPrice = discountPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getTitle1() {
        return Title1;
    }

    public void setTitle1(String title1) {
        Title1 = title1;
    }

    public String getTitle2() {
        return Title2;
    }

    public void setTitle2(String title2) {
        Title2 = title2;
    }

    public String getPack() {
        return Pack;
    }

    public void setPack(String pack) {
        Pack = pack;
    }

    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int p_Id) {
        P_Id = p_Id;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getProductCategoryName() {
        return ProductCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        ProductCategoryName = productCategoryName;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
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

    public int getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(int SR_Id) {
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

    private String ProductName;
    private String Title1;
    private String Title2;
    private String Pack;

    private int P_Id;
    private String CreateDate;
    private String CreatedBy;

    private String ProductCategoryName;
    private String Brand;
    private String Age;
    private String Breed;
    private String Foodtype;
    private String FoodCategories;
    private String ProductFeatured;
    private int SR_Id;
    private int B_Id;
    private String BreedName;
    private int BRAND_Id;
    private String BrandName;

    private int SMS_Id;

    public int getSMS_Id() {
        return SMS_Id;
    }

    public void setSMS_Id(int SMS_Id) {
        this.SMS_Id = SMS_Id;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public List<ProductResponse.ResponseBean.FilterListBean.SubListBean> getSubList() {
        return SubList;
    }

    public void setSubList(List<ProductResponse.ResponseBean.FilterListBean.SubListBean> subList) {
        SubList = subList;
    }

    private String CatName;
    private String CreatedDate;

    private String status;

    private List<ProductResponse.ResponseBean.FilterListBean.SubListBean> SubList;

    public int getSub_Id() {
        return Sub_Id;
    }

    public void setSub_Id(int sub_Id) {
        Sub_Id = sub_Id;
    }

    public String getSubCatName() {
        return SubCatName;
    }

    public void setSubCatName(String subCatName) {
        SubCatName = subCatName;
    }

    private int Sub_Id;
    private String SubCatName;


}
