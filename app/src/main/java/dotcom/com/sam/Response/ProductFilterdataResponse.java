package dotcom.com.sam.Response;

import java.util.List;

/**
 * Created by sanjay on 10/25/2017.
 */

public class ProductFilterdataResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"PT_Id":1,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":2,"Sc_Id":16,"P_Id":9,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"Food","CategosryName":"DOGS","ProductCategoryName":"CANNED FOOD","Brand":null,"Age":"Puppy","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Wet Food","ProductFeatured":"Popular","SR_Id":null,"B_Id":1,"BreedName":"Affenpinscher","BRAND_Id":1,"BrandName":"Royals"},{"PT_Id":2,"Image":"p4-1.png","Price":300,"Discount":"10","DiscountPrice":270,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":2,"Sc_Id":16,"P_Id":9,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"Food","CategosryName":"DOGS","ProductCategoryName":"CANNED FOOD","Brand":null,"Age":"Puppy","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Dry Food","ProductFeatured":"New","SR_Id":null,"B_Id":1,"BreedName":"Affenpinscher","BRAND_Id":2,"BrandName":"Parle"},{"PT_Id":3,"Image":"p6.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":1,"Sc_Id":1,"P_Id":1,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"FOOD","CategosryName":"CAT","ProductCategoryName":"Wet food","Brand":null,"Age":"Puppy","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Dry Food","ProductFeatured":"Popular","SR_Id":null,"B_Id":1,"BreedName":"Affenpinscher","BRAND_Id":2,"BrandName":"Parle"},{"PT_Id":4,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":1,"Sc_Id":2,"P_Id":5,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"Special Treats","CategosryName":"CAT","ProductCategoryName":"Meat Treats","Brand":null,"Age":"Puppy","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Wet Food","ProductFeatured":"New","SR_Id":null,"B_Id":1,"BreedName":"Affenpinscher","BRAND_Id":2,"BrandName":"Parle"},{"PT_Id":5,"Image":"prod-description-1.jpg","Price":300,"Discount":"5","DiscountPrice":285,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":1,"Sc_Id":1,"P_Id":2,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"FOOD","CategosryName":"CAT","ProductCategoryName":"Dry Food","Brand":null,"Age":"Adult","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Dry Food","ProductFeatured":"Popular","SR_Id":null,"B_Id":1,"BreedName":"Affenpinscher","BRAND_Id":2,"BrandName":"Parle"},{"PT_Id":6,"Image":"p3-1.png","Price":6840,"Discount":"25","DiscountPrice":5130,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":1,"Sc_Id":1,"P_Id":2,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"FOOD","CategosryName":"CAT","ProductCategoryName":"Dry Food","Brand":null,"Age":"Adult","Breed":null,"Foodtype":"Vegetarian","FoodCategories":"Puppy Food","ProductFeatured":"New","SR_Id":null,"B_Id":2,"BreedName":"Afghan Hound","BRAND_Id":4,"BrandName":"Cop Rice"},{"PT_Id":8,"Image":"p2-1.png","Price":250,"Discount":"5","DiscountPrice":237.5,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":"NEW","Pack":null,"C_Id":1,"Sc_Id":1,"P_Id":4,"CreateDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","DeleteStatus":null,"SubCategoryName":"FOOD","CategosryName":"CAT","ProductCategoryName":"Diet Controal Food","Brand":null,"Age":"Adult","Breed":null,"Foodtype":"Non Vegetarian","FoodCategories":"Puppy Food","ProductFeatured":"Featured","SR_Id":null,"B_Id":2,"BreedName":"Afghan Hound","BRAND_Id":2,"BrandName":"Parle"}]
     */

    private boolean success;
    private String Messege;
    private int status;
    private List<ResponseBean> response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessege() {
        return Messege;
    }

    public void setMessege(String Messege) {
        this.Messege = Messege;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * PT_Id : 1
         * Image : p1-pop-2.png
         * Price : 100
         * Discount : 5
         * DiscountPrice : 95
         * ProductName : ROYAL CANIN GIANT PUPPY
         * Title1 : null
         * Title2 : NEW
         * Pack : null
         * C_Id : 2
         * Sc_Id : 16
         * P_Id : 9
         * CreateDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * DeleteStatus : null
         * SubCategoryName : Food
         * CategosryName : DOGS
         * ProductCategoryName : CANNED FOOD
         * Brand : null
         * Age : Puppy
         * Breed : null
         * Foodtype : Non Vegetarian
         * FoodCategories : Wet Food
         * ProductFeatured : Popular
         * SR_Id : null
         * B_Id : 1
         * BreedName : Affenpinscher
         * BRAND_Id : 1
         * BrandName : Royals
         */

        private int PT_Id;
        private String Image;
        private int Price;
        private String Discount;
        private String DiscountPrice;
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

        public int getPT_Id() {
            return PT_Id;
        }

        public void setPT_Id(int PT_Id) {
            this.PT_Id = PT_Id;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public String getDiscount() {
            return Discount;
        }

        public void setDiscount(String Discount) {
            this.Discount = Discount;
        }

        public String getDiscountPrice() {
            return DiscountPrice;
        }

        public void setDiscountPrice(String DiscountPrice) {
            this.DiscountPrice = DiscountPrice;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public Object getTitle1() {
            return Title1;
        }

        public void setTitle1(Object Title1) {
            this.Title1 = Title1;
        }

        public String getTitle2() {
            return Title2;
        }

        public void setTitle2(String Title2) {
            this.Title2 = Title2;
        }

        public Object getPack() {
            return Pack;
        }

        public void setPack(Object Pack) {
            this.Pack = Pack;
        }

        public int getC_Id() {
            return C_Id;
        }

        public void setC_Id(int C_Id) {
            this.C_Id = C_Id;
        }

        public int getSc_Id() {
            return Sc_Id;
        }

        public void setSc_Id(int Sc_Id) {
            this.Sc_Id = Sc_Id;
        }

        public int getP_Id() {
            return P_Id;
        }

        public void setP_Id(int P_Id) {
            this.P_Id = P_Id;
        }

        public Object getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(Object CreateDate) {
            this.CreateDate = CreateDate;
        }

        public Object getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(Object CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public Object getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(Object ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public Object getModifyBy() {
            return ModifyBy;
        }

        public void setModifyBy(Object ModifyBy) {
            this.ModifyBy = ModifyBy;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public Object getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(Object DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }

        public String getSubCategoryName() {
            return SubCategoryName;
        }

        public void setSubCategoryName(String SubCategoryName) {
            this.SubCategoryName = SubCategoryName;
        }

        public String getCategosryName() {
            return CategosryName;
        }

        public void setCategosryName(String CategosryName) {
            this.CategosryName = CategosryName;
        }

        public String getProductCategoryName() {
            return ProductCategoryName;
        }

        public void setProductCategoryName(String ProductCategoryName) {
            this.ProductCategoryName = ProductCategoryName;
        }

        public Object getBrand() {
            return Brand;
        }

        public void setBrand(Object Brand) {
            this.Brand = Brand;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }

        public Object getBreed() {
            return Breed;
        }

        public void setBreed(Object Breed) {
            this.Breed = Breed;
        }

        public String getFoodtype() {
            return Foodtype;
        }

        public void setFoodtype(String Foodtype) {
            this.Foodtype = Foodtype;
        }

        public String getFoodCategories() {
            return FoodCategories;
        }

        public void setFoodCategories(String FoodCategories) {
            this.FoodCategories = FoodCategories;
        }

        public String getProductFeatured() {
            return ProductFeatured;
        }

        public void setProductFeatured(String ProductFeatured) {
            this.ProductFeatured = ProductFeatured;
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

        public void setB_Id(int B_Id) {
            this.B_Id = B_Id;
        }

        public String getBreedName() {
            return BreedName;
        }

        public void setBreedName(String BreedName) {
            this.BreedName = BreedName;
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

        public void setBrandName(String BrandName) {
            this.BrandName = BrandName;
        }
    }
}
