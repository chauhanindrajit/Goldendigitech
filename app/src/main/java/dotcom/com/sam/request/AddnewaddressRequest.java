package dotcom.com.sam.request;

import java.util.List;

/**
 * Created by sanjay on 11/8/2017.
 */

public class AddnewaddressRequest {


    /**
     * RJ_ID : 1
     * FullName : sample string 2
     * Email : sample string 3
     * MobNo : sample string 4
     * Password : sample string 5
     * CnfPassword : sample string 6
     * Address : sample string 7
     * CreatedDate : 2018-09-25T10:26:06.3959182+05:30
     * CreatedBy : sample string 8
     * ModifyBy : sample string 9
     * ModifyDate : 2018-09-25T10:26:06.3959182+05:30
     * Status : sample string 10
     * DeleteStatus : sample string 11
     * ShippingAddress : sample string 12
     * ShipName : sample string 13
     * ShipContactNo : sample string 14
     * DATALIST : [{"CRT_Id":1,"RJ_ID":1,"Session_Id":"sample string 2","QTY":1,"PT_Id":1,"Createdate":"2018-09-25T10:26:06.3959182+05:30","CreatedBy":"sample string 3","Status":"sample string 4","DeleteStatus":"sample string 5","TotalAmount":1,"Amount":1,"Ord_Id":1,"Image":"sample string 6","Price":1,"Discount":"sample string 7","DiscountPrice":1,"ProductName":"sample string 8","Title1":"sample string 9","Title2":"sample string 10","Pack":"sample string 11"},{"CRT_Id":1,"RJ_ID":1,"Session_Id":"sample string 2","QTY":1,"PT_Id":1,"Createdate":"2018-09-25T10:26:06.3959182+05:30","CreatedBy":"sample string 3","Status":"sample string 4","DeleteStatus":"sample string 5","TotalAmount":1,"Amount":1,"Ord_Id":1,"Image":"sample string 6","Price":1,"Discount":"sample string 7","DiscountPrice":1,"ProductName":"sample string 8","Title1":"sample string 9","Title2":"sample string 10","Pack":"sample string 11"}]
     */

    private int RJ_ID;
    private String FullName;
    private String Email;
    private String MobNo;
    private String Password;
    private String CnfPassword;
    private String Address;
    private String CreatedDate;
    private String CreatedBy;
    private String ModifyBy;
    private String ModifyDate;
    private String Status;
    private String DeleteStatus;
    private String ShippingAddress;
    private String ShipName;
    private String ShipContactNo;
    private List<DATALISTBean> DATALIST;

    public int getRJ_ID() {
        return RJ_ID;
    }

    public void setRJ_ID(int RJ_ID) {
        this.RJ_ID = RJ_ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String MobNo) {
        this.MobNo = MobNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCnfPassword() {
        return CnfPassword;
    }

    public void setCnfPassword(String CnfPassword) {
        this.CnfPassword = CnfPassword;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String ModifyBy) {
        this.ModifyBy = ModifyBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String ModifyDate) {
        this.ModifyDate = ModifyDate;
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

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }

    public String getShipContactNo() {
        return ShipContactNo;
    }

    public void setShipContactNo(String ShipContactNo) {
        this.ShipContactNo = ShipContactNo;
    }

    public List<DATALISTBean> getDATALIST() {
        return DATALIST;
    }

    public void setDATALIST(List<DATALISTBean> DATALIST) {
        this.DATALIST = DATALIST;
    }

    public static class DATALISTBean {
        /**
         * CRT_Id : 1
         * RJ_ID : 1
         * Session_Id : sample string 2
         * QTY : 1
         * PT_Id : 1
         * Createdate : 2018-09-25T10:26:06.3959182+05:30
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
