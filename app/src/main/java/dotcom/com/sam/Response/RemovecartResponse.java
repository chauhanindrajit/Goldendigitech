package dotcom.com.sam.Response;

import java.util.List;

public class RemovecartResponse {


    /**
     * success : true
     * Messege : sample string 2
     * status : 3
     * response : [{"CRT_Id":1,"RJ_ID":1,"Session_Id":"sample string 2","QTY":1,"PT_Id":1,"Createdate":"2018-09-20T11:22:10.1664951+05:30","CreatedBy":"sample string 3","Status":"sample string 4","DeleteStatus":"sample string 5","TotalAmount":1,"Amount":1,"Ord_Id":1,"Image":"sample string 6","Price":1,"Discount":"sample string 7","DiscountPrice":1,"ProductName":"sample string 8","Title1":"sample string 9","Title2":"sample string 10","Pack":"sample string 11"},{"CRT_Id":1,"RJ_ID":1,"Session_Id":"sample string 2","QTY":1,"PT_Id":1,"Createdate":"2018-09-20T11:22:10.1664951+05:30","CreatedBy":"sample string 3","Status":"sample string 4","DeleteStatus":"sample string 5","TotalAmount":1,"Amount":1,"Ord_Id":1,"Image":"sample string 6","Price":1,"Discount":"sample string 7","DiscountPrice":1,"ProductName":"sample string 8","Title1":"sample string 9","Title2":"sample string 10","Pack":"sample string 11"}]
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
         * CRT_Id : 1
         * RJ_ID : 1
         * Session_Id : sample string 2
         * QTY : 1
         * PT_Id : 1
         * Createdate : 2018-09-20T11:22:10.1664951+05:30
         * CreatedBy : sample string 3
         * Status : sample string 4
         * DeleteStatus : sample string 5
         * TotalAmount : 1
         * Amount : 1
         * Ord_Id : 1
         * Image : sample string 6
         * Price : 1
         * Discount : sample string 7
         * DiscountPrice : 1
         * ProductName : sample string 8
         * Title1 : sample string 9
         * Title2 : sample string 10
         * Pack : sample string 11
         */

        private int CRT_Id;
        private int RJ_ID;
        private String Session_Id;
        private int QTY;
        private int PT_Id;
        private String Createdate;
        private String CreatedBy;
        private String Status;
        private String DeleteStatus;
        private int TotalAmount;
        private int Amount;
        private int Ord_Id;
        private String Image;
        private int Price;
        private String Discount;
        private int DiscountPrice;
        private String ProductName;
        private String Title1;
        private String Title2;
        private String Pack;

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

        public String getSession_Id() {
            return Session_Id;
        }

        public void setSession_Id(String Session_Id) {
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

        public String getCreatedate() {
            return Createdate;
        }

        public void setCreatedate(String Createdate) {
            this.Createdate = Createdate;
        }

        public String getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(String CreatedBy) {
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

        public int getTotalAmount() {
            return TotalAmount;
        }

        public void setTotalAmount(int TotalAmount) {
            this.TotalAmount = TotalAmount;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public int getOrd_Id() {
            return Ord_Id;
        }

        public void setOrd_Id(int Ord_Id) {
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
    }
}
