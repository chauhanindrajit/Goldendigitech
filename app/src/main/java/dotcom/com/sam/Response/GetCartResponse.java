package dotcom.com.sam.Response;

import java.util.List;

/**
 * Created by Dotcom on 2/17/2017.
 */

public class GetCartResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"CRT_Id":77,"RJ_ID":8,"Session_Id":null,"QTY":0,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":78,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":79,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":80,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":81,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":83,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":89,"RJ_ID":8,"Session_Id":null,"QTY":35,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":2700,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":90,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":150,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":91,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":150,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":92,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":150,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":93,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":150,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":94,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":1,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p1-pop-2.png","Price":100,"Discount":"5","DiscountPrice":95,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":95,"RJ_ID":8,"Session_Id":null,"QTY":3,"PT_Id":2,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":810,"Ord_Id":null,"Image":"p4-1.png","Price":300,"Discount":"10","DiscountPrice":270,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null}]
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
         * CRT_Id : 77
         * RJ_ID : 8
         * Session_Id : null
         * QTY : 0
         * PT_Id : 1
         * Createdate : null
         * CreatedBy : null
         * Status : Active
         * DeleteStatus : No
         * TotalAmount : null
         * Amount : 0
         * Ord_Id : null
         * Image : p1-pop-2.png
         * Price : 100
         * Discount : 5
         * DiscountPrice : 95
         * ProductName : ROYAL CANIN GIANT PUPPY
         * Title1 : null
         * Title2 : null
         * Pack : null
         */

        private int CRT_Id;
        private int RJ_ID;
        private Object Session_Id;
        private int QTY;
        private int PT_Id;
        private Object Createdate;
        private Object CreatedBy;
        private String Status;
        private String DeleteStatus;
        private Object TotalAmount;
        private int Amount;
        private Object Ord_Id;
        private String Image;
        private int Price;
        private String Discount;
        private int DiscountPrice;
        private String ProductName;
        private Object Title1;
        private Object Title2;
        private Object Pack;

        public int getCRT_Id() {
            return CRT_Id;
        }

        public void setCRT_Id(int CRT_Id) {
            this.CRT_Id = CRT_Id;
        }

        public int getRJ_ID() {
            return RJ_ID;
        }

        public void setRJ_ID(int RJ_ID) {
            this.RJ_ID = RJ_ID;
        }

        public Object getSession_Id() {
            return Session_Id;
        }

        public void setSession_Id(Object Session_Id) {
            this.Session_Id = Session_Id;
        }

        public int getQTY() {
            return QTY;
        }

        public void setQTY(int QTY) {
            this.QTY = QTY;
        }

        public int getPT_Id() {
            return PT_Id;
        }

        public void setPT_Id(int PT_Id) {
            this.PT_Id = PT_Id;
        }

        public Object getCreatedate() {
            return Createdate;
        }

        public void setCreatedate(Object Createdate) {
            this.Createdate = Createdate;
        }

        public Object getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(Object CreatedBy) {
            this.CreatedBy = CreatedBy;
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

        public Object getTotalAmount() {
            return TotalAmount;
        }

        public void setTotalAmount(Object TotalAmount) {
            this.TotalAmount = TotalAmount;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public Object getOrd_Id() {
            return Ord_Id;
        }

        public void setOrd_Id(Object Ord_Id) {
            this.Ord_Id = Ord_Id;
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

        public Object getTitle1() {
            return Title1;
        }

        public void setTitle1(Object Title1) {
            this.Title1 = Title1;
        }

        public Object getTitle2() {
            return Title2;
        }

        public void setTitle2(Object Title2) {
            this.Title2 = Title2;
        }

        public Object getPack() {
            return Pack;
        }

        public void setPack(Object Pack) {
            this.Pack = Pack;
        }
    }
}
