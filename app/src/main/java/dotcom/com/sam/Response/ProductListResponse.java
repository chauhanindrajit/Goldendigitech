package dotcom.com.sam.Response;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/17/2017.
 */

public class ProductListResponse {

    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"productid":6,"productname":"moong dal","about":null,"nutrition":null,"benefit":null,"productcategory":[{"productsize":"1 kg pouch","productid":6,"stockid":2,"description":"abc","price":100,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/dal.jpg","discount":12,"offerprice":80,"store_id":2,"cartid":0},{"productsize":"2 kg pouch","productid":6,"stockid":17,"description":"bb Royal Urad Whole/Gota, 500 gm Pouch","price":500,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/amg","discount":0,"offerprice":0,"store_id":2,"cartid":0},{"productsize":"1 kg pouch","productid":6,"stockid":18,"description":"abc","price":90,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/dal.jpg","discount":0,"offerprice":0,"store_id":2,"cartid":0}],"brandname":"brand1","size":null,"isIncart":false,"store_id":0,"userid":0}]
     */

    private boolean success;
    private String Messege;
    private int status;
    private ArrayList<ResponseBean> response;

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

    public ArrayList<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<ResponseBean> response) {
        this.response = response;
    }



    public static class ResponseBean {
        /**
         * productid : 6
         * productname : moong dal
         * about : null
         * nutrition : null
         * benefit : null
         * productcategory : [{"productsize":"1 kg pouch","productid":6,"stockid":2,"description":"abc","price":100,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/dal.jpg","discount":12,"offerprice":80,"store_id":2,"cartid":0},{"productsize":"2 kg pouch","productid":6,"stockid":17,"description":"bb Royal Urad Whole/Gota, 500 gm Pouch","price":500,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/amg","discount":0,"offerprice":0,"store_id":2,"cartid":0},{"productsize":"1 kg pouch","productid":6,"stockid":18,"description":"abc","price":90,"image":"http://worldindia.in/EasyShoppingbeta/content/image/product/dal.jpg","discount":0,"offerprice":0,"store_id":2,"cartid":0}]
         * brandname : brand1
         * size : null
         * isIncart : false
         * store_id : 0
         * userid : 0
         */

        private int productid;
        private String productname;
        private String about;
        private String nutrition;
        private String benefit;
        private String brandname;
        private Object size;
        private boolean isIncart;
        private int store_id;
        private int userid;
        private List<ProductcategoryBean> productcategory;

        protected ResponseBean(Parcel in) {
            productid = in.readInt();
            productname = in.readString();
            brandname = in.readString();
            isIncart = in.readByte() != 0;
            store_id = in.readInt();
            userid = in.readInt();
        }



        public int getProductid() {
            return productid;
        }

        public void setProductid(int productid) {
            this.productid = productid;
        }

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getNutrition() {
            return nutrition;
        }

        public void setNutrition(String nutrition) {
            this.nutrition = nutrition;
        }

        public String getBenefit() {
            return benefit;
        }

        public void setBenefit(String benefit) {
            this.benefit = benefit;
        }

        public String getBrandname() {
            return brandname;
        }

        public void setBrandname(String brandname) {
            this.brandname = brandname;
        }

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public boolean isIsIncart() {
            return isIncart;
        }

        public void setIsIncart(boolean isIncart) {
            this.isIncart = isIncart;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public List<ProductcategoryBean> getProductcategory() {
            return productcategory;
        }

        public void setProductcategory(List<ProductcategoryBean> productcategory) {
            this.productcategory = productcategory;
        }



        public static class ProductcategoryBean {
            /**
             * productsize : 1 kg pouch
             * productid : 6
             * stockid : 2
             * description : abc
             * price : 100
             * image : http://worldindia.in/EasyShoppingbeta/content/image/product/dal.jpg
             * discount : 12
             * offerprice : 80
             * store_id : 2
             * cartid : 0
             */

            private String productsize;
            private int productid;
            private int stockid;
            private String description;
            private int price;
            private String image;
            private int discount;
            private int offerprice;
            private int store_id;
            private int cartid;

            protected ProductcategoryBean(Parcel in) {
                productsize = in.readString();
                productid = in.readInt();
                stockid = in.readInt();
                description = in.readString();
                price = in.readInt();
                image = in.readString();
                discount = in.readInt();
                offerprice = in.readInt();
                store_id = in.readInt();
                cartid = in.readInt();
            }



            public String getProductsize() {
                return productsize;
            }

            public void setProductsize(String productsize) {
                this.productsize = productsize;
            }

            public int getProductid() {
                return productid;
            }

            public void setProductid(int productid) {
                this.productid = productid;
            }

            public int getStockid() {
                return stockid;
            }

            public void setStockid(int stockid) {
                this.stockid = stockid;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public int getOfferprice() {
                return offerprice;
            }

            public void setOfferprice(int offerprice) {
                this.offerprice = offerprice;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public int getCartid() {
                return cartid;
            }

            public void setCartid(int cartid) {
                this.cartid = cartid;
            }


        }
    }
}
