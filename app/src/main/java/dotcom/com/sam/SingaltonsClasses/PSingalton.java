package dotcom.com.sam.SingaltonsClasses;


import java.io.Serializable;
import java.util.List;

import dotcom.com.sam.Response.MatingResponse;
import dotcom.com.sam.Response.ProductResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class PSingalton implements Serializable {

    private static final PSingalton ourInstance = new PSingalton();
    /**
     * success : true
     * Messege : sample string 2
     * status : 3
     * response : [{"Sc_Id":1,"SubCategoryName":"sample string 2","Cretaedate":"2018-08-24T13:28:48.3340521+05:30","CretaedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","Status":"sample string 5","DeleteStatus":"sample string 6","C_Id":1,"CategosryName":"sample string 7","Image":"sample string 8","prodList":[{"PT_Id":1,"Image":"sample string 2","Price":1,"Discount":"sample string 3","DiscountPrice":1,"ProductName":"sample string 4","Title1":"sample string 5","Title2":"sample string 6","Pack":"sample string 7","C_Id":1,"Sc_Id":1,"P_Id":1,"CreateDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 8","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 9","Status":"sample string 10","DeleteStatus":"sample string 11","SubCategoryName":"sample string 12","CategosryName":"sample string 13","ProductCategoryName":"sample string 14","Brand":"sample string 15","Age":"sample string 16","Breed":"sample string 17","Foodtype":"sample string 18","FoodCategories":"sample string 19","ProductFeatured":"sample string 20","SR_Id":1,"B_Id":1,"BreedName":"sample string 21","BRAND_Id":1,"BrandName":"sample string 22"},{"PT_Id":1,"Image":"sample string 2","Price":1,"Discount":"sample string 3","DiscountPrice":1,"ProductName":"sample string 4","Title1":"sample string 5","Title2":"sample string 6","Pack":"sample string 7","C_Id":1,"Sc_Id":1,"P_Id":1,"CreateDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 8","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 9","Status":"sample string 10","DeleteStatus":"sample string 11","SubCategoryName":"sample string 12","CategosryName":"sample string 13","ProductCategoryName":"sample string 14","Brand":"sample string 15","Age":"sample string 16","Breed":"sample string 17","Foodtype":"sample string 18","FoodCategories":"sample string 19","ProductFeatured":"sample string 20","SR_Id":1,"B_Id":1,"BreedName":"sample string 21","BRAND_Id":1,"BrandName":"sample string 22"}],"filterList":[{"SMS_Id":1,"CatName":"sample string 2","CreatedDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","status":"sample string 5","DeleteStatus":"sample string 6","SubList":[{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"},{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"}]},{"SMS_Id":1,"CatName":"sample string 2","CreatedDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","status":"sample string 5","DeleteStatus":"sample string 6","SubList":[{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"},{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"}]}]},{"Sc_Id":1,"SubCategoryName":"sample string 2","Cretaedate":"2018-08-24T13:28:48.3340521+05:30","CretaedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","Status":"sample string 5","DeleteStatus":"sample string 6","C_Id":1,"CategosryName":"sample string 7","Image":"sample string 8","prodList":[{"PT_Id":1,"Image":"sample string 2","Price":1,"Discount":"sample string 3","DiscountPrice":1,"ProductName":"sample string 4","Title1":"sample string 5","Title2":"sample string 6","Pack":"sample string 7","C_Id":1,"Sc_Id":1,"P_Id":1,"CreateDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 8","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 9","Status":"sample string 10","DeleteStatus":"sample string 11","SubCategoryName":"sample string 12","CategosryName":"sample string 13","ProductCategoryName":"sample string 14","Brand":"sample string 15","Age":"sample string 16","Breed":"sample string 17","Foodtype":"sample string 18","FoodCategories":"sample string 19","ProductFeatured":"sample string 20","SR_Id":1,"B_Id":1,"BreedName":"sample string 21","BRAND_Id":1,"BrandName":"sample string 22"},{"PT_Id":1,"Image":"sample string 2","Price":1,"Discount":"sample string 3","DiscountPrice":1,"ProductName":"sample string 4","Title1":"sample string 5","Title2":"sample string 6","Pack":"sample string 7","C_Id":1,"Sc_Id":1,"P_Id":1,"CreateDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 8","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 9","Status":"sample string 10","DeleteStatus":"sample string 11","SubCategoryName":"sample string 12","CategosryName":"sample string 13","ProductCategoryName":"sample string 14","Brand":"sample string 15","Age":"sample string 16","Breed":"sample string 17","Foodtype":"sample string 18","FoodCategories":"sample string 19","ProductFeatured":"sample string 20","SR_Id":1,"B_Id":1,"BreedName":"sample string 21","BRAND_Id":1,"BrandName":"sample string 22"}],"filterList":[{"SMS_Id":1,"CatName":"sample string 2","CreatedDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","status":"sample string 5","DeleteStatus":"sample string 6","SubList":[{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"},{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"}]},{"SMS_Id":1,"CatName":"sample string 2","CreatedDate":"2018-08-24T13:28:48.3340521+05:30","CreatedBy":"sample string 3","ModifyDate":"2018-08-24T13:28:48.3340521+05:30","ModifyBy":"sample string 4","status":"sample string 5","DeleteStatus":"sample string 6","SubList":[{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"},{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"}]}]}]
     */

    private boolean success;
    private String Messege;
    private int status;
    private List<ProductResponse.ResponseBean> response;

    public static PSingalton getInstance() {
        return ourInstance;
    }

    public PSingalton() {
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
        private String ModifyDate;
        private String ModifyBy;
        private String Status;
        private String DeleteStatus;
        private int C_Id;
        private String CategosryName;
        private String Image;
        private List<ProdListBean> prodList;
        private List<FilterListBean> filterList;

        public int getSc_Id() {
            return Sc_Id;
        }

        public void setSc_Id(int Sc_Id) {
            this.Sc_Id = Sc_Id;
        }

        public String getSubCategoryName() {
            return SubCategoryName;
        }

        public void setSubCategoryName(String SubCategoryName) {
            this.SubCategoryName = SubCategoryName;
        }

        public String getCretaedate() {
            return Cretaedate;
        }

        public void setCretaedate(String Cretaedate) {
            this.Cretaedate = Cretaedate;
        }

        public String getCretaedBy() {
            return CretaedBy;
        }

        public void setCretaedBy(String CretaedBy) {
            this.CretaedBy = CretaedBy;
        }

        public String getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(String ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public String getModifyBy() {
            return ModifyBy;
        }

        public void setModifyBy(String ModifyBy) {
            this.ModifyBy = ModifyBy;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(String DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }

        public int getC_Id() {
            return C_Id;
        }

        public void setC_Id(int C_Id) {
            this.C_Id = C_Id;
        }

        public String getCategosryName() {
            return CategosryName;
        }

        public void setCategosryName(String CategosryName) {
            this.CategosryName = CategosryName;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public List<ProdListBean> getProdList() {
            return prodList;
        }

        public void setProdList(List<ProdListBean> prodList) {
            this.prodList = prodList;
        }

        public List<FilterListBean> getFilterList() {
            return filterList;
        }

        public void setFilterList(List<FilterListBean> filterList) {
            this.filterList = filterList;
        }

        public static class ProdListBean {
            /**
             * PT_Id : 1
             * Image : sample string 2
             * Price : 1
             * Discount : sample string 3
             * DiscountPrice : 1
             * ProductName : sample string 4
             * Title1 : sample string 5
             * Title2 : sample string 6
             * Pack : sample string 7
             * C_Id : 1
             * Sc_Id : 1
             * P_Id : 1
             * CreateDate : 2018-08-24T13:28:48.3340521+05:30
             * CreatedBy : sample string 8
             * ModifyDate : 2018-08-24T13:28:48.3340521+05:30
             * ModifyBy : sample string 9
             * Status : sample string 10
             * DeleteStatus : sample string 11
             * SubCategoryName : sample string 12
             * CategosryName : sample string 13
             * ProductCategoryName : sample string 14
             * Brand : sample string 15
             * Age : sample string 16
             * Breed : sample string 17
             * Foodtype : sample string 18
             * FoodCategories : sample string 19
             * ProductFeatured : sample string 20
             * SR_Id : 1
             * B_Id : 1
             * BreedName : sample string 21
             * BRAND_Id : 1
             * BrandName : sample string 22
             */

            private int PT_Id;
            private String Image;
            private int Price;
            private String Discount;
            private int DiscountPrice;
            private String ProductName;
            private String Title1;
            private String Title2;
            private String Pack;
            private int C_Id;
            private int Sc_Id;
            private int P_Id;
            private String CreateDate;
            private String CreatedBy;
            private String ModifyDate;
            private String ModifyBy;
            private String Status;
            private String DeleteStatus;
            private String SubCategoryName;
            private String CategosryName;
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

            public int getDiscountPrice() {
                return DiscountPrice;
            }

            public void setDiscountPrice(int DiscountPrice) {
                this.DiscountPrice = DiscountPrice;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public String getTitle1() {
                return Title1;
            }

            public void setTitle1(String Title1) {
                this.Title1 = Title1;
            }

            public String getTitle2() {
                return Title2;
            }

            public void setTitle2(String Title2) {
                this.Title2 = Title2;
            }

            public String getPack() {
                return Pack;
            }

            public void setPack(String Pack) {
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

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public String getCreatedBy() {
                return CreatedBy;
            }

            public void setCreatedBy(String CreatedBy) {
                this.CreatedBy = CreatedBy;
            }

            public String getModifyDate() {
                return ModifyDate;
            }

            public void setModifyDate(String ModifyDate) {
                this.ModifyDate = ModifyDate;
            }

            public String getModifyBy() {
                return ModifyBy;
            }

            public void setModifyBy(String ModifyBy) {
                this.ModifyBy = ModifyBy;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public String getDeleteStatus() {
                return DeleteStatus;
            }

            public void setDeleteStatus(String DeleteStatus) {
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

            public String getBrand() {
                return Brand;
            }

            public void setBrand(String Brand) {
                this.Brand = Brand;
            }

            public String getAge() {
                return Age;
            }

            public void setAge(String Age) {
                this.Age = Age;
            }

            public String getBreed() {
                return Breed;
            }

            public void setBreed(String Breed) {
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

            public int getSR_Id() {
                return SR_Id;
            }

            public void setSR_Id(int SR_Id) {
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

        public static class FilterListBean {
            /**
             * SMS_Id : 1
             * CatName : sample string 2
             * CreatedDate : 2018-08-24T13:28:48.3340521+05:30
             * CreatedBy : sample string 3
             * ModifyDate : 2018-08-24T13:28:48.3340521+05:30
             * ModifyBy : sample string 4
             * status : sample string 5
             * DeleteStatus : sample string 6
             * SubList : [{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"},{"Sub_Id":1,"SubCatName":"sample string 2","BrandName":"sample string 3","BreedName":"sample string 4"}]
             */

            private int SMS_Id;
            private String CatName;
            private String CreatedDate;
            private String CreatedBy;
            private String ModifyDate;
            private String ModifyBy;
            private String status;
            private String DeleteStatus;
            private List<SubListBean> SubList;

            public int getSMS_Id() {
                return SMS_Id;
            }

            public void setSMS_Id(int SMS_Id) {
                this.SMS_Id = SMS_Id;
            }

            public String getCatName() {
                return CatName;
            }

            public void setCatName(String CatName) {
                this.CatName = CatName;
            }

            public String getCreatedDate() {
                return CreatedDate;
            }

            public void setCreatedDate(String CreatedDate) {
                this.CreatedDate = CreatedDate;
            }

            public String getCreatedBy() {
                return CreatedBy;
            }

            public void setCreatedBy(String CreatedBy) {
                this.CreatedBy = CreatedBy;
            }

            public String getModifyDate() {
                return ModifyDate;
            }

            public void setModifyDate(String ModifyDate) {
                this.ModifyDate = ModifyDate;
            }

            public String getModifyBy() {
                return ModifyBy;
            }

            public void setModifyBy(String ModifyBy) {
                this.ModifyBy = ModifyBy;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDeleteStatus() {
                return DeleteStatus;
            }

            public void setDeleteStatus(String DeleteStatus) {
                this.DeleteStatus = DeleteStatus;
            }

            public List<SubListBean> getSubList() {
                return SubList;
            }

            public void setSubList(List<SubListBean> SubList) {
                this.SubList = SubList;
            }

            public static class SubListBean {
                /**
                 * Sub_Id : 1
                 * SubCatName : sample string 2
                 * BrandName : sample string 3
                 * BreedName : sample string 4
                 */

                private int Sub_Id;
                private String SubCatName;
                private String BrandName;
                private String BreedName;

                public int getSub_Id() {
                    return Sub_Id;
                }

                public void setSub_Id(int Sub_Id) {
                    this.Sub_Id = Sub_Id;
                }

                public String getSubCatName() {
                    return SubCatName;
                }

                public void setSubCatName(String SubCatName) {
                    this.SubCatName = SubCatName;
                }

                public String getBrandName() {
                    return BrandName;
                }

                public void setBrandName(String BrandName) {
                    this.BrandName = BrandName;
                }

                public String getBreedName() {
                    return BreedName;
                }

                public void setBreedName(String BreedName) {
                    this.BreedName = BreedName;
                }
            }
        }
    }

