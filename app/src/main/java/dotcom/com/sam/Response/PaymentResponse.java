package dotcom.com.sam.Response;

import java.util.List;

/**
 * Created by Dotcom on 2/20/2017.
 */

public class PaymentResponse {


    /**
     * RJ_ID : 8
     * FullName : sjsjdjdj
     * Email : indrajit@gmail.com
     * MobNo : 123456789
     * Password : 123456
     * CnfPassword : 123456
     * Address : chatgjjk
     * CreatedDate : null
     * CreatedBy : null
     * ModifyBy : null
     * ModifyDate : null
     * Status : Active
     * DeleteStatus : null
     * ShippingAddress : null
     * ShipName : null
     * ShipContactNo : null
     * DATALIST : [{"CRT_Id":157,"RJ_ID":8,"Session_Id":null,"QTY":2,"PT_Id":2,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":540,"Ord_Id":null,"Image":"p4-1.png","Price":300,"Discount":"10","DiscountPrice":270,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":158,"RJ_ID":8,"Session_Id":null,"QTY":1,"PT_Id":6,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":5130,"Ord_Id":null,"Image":"p3-1.png","Price":6840,"Discount":"25","DiscountPrice":5130,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null},{"CRT_Id":160,"RJ_ID":8,"Session_Id":null,"QTY":0,"PT_Id":4,"Createdate":null,"CreatedBy":null,"Status":"Active","DeleteStatus":"No","TotalAmount":null,"Amount":0,"Ord_Id":null,"Image":"p5.png","Price":100,"Discount":"25","DiscountPrice":75,"ProductName":"ROYAL CANIN GIANT PUPPY","Title1":null,"Title2":null,"Pack":null}]
     */

    private int RJ_ID;
    private String FullName;
    private String Email;
    private String MobNo;
    private String Password;
    private String CnfPassword;
    private String Address;
    private Object CreatedDate;
    private Object CreatedBy;
    private Object ModifyBy;
    private Object ModifyDate;
    private String Status;
    private Object DeleteStatus;
    private Object ShippingAddress;
    private Object ShipName;
    private Object ShipContactNo;
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

    public Object getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Object CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public Object getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Object CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Object getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Object ModifyBy) {
        this.ModifyBy = ModifyBy;
    }

    public Object getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Object ModifyDate) {
        this.ModifyDate = ModifyDate;
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

    public Object getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(Object ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public Object getShipName() {
        return ShipName;
    }

    public void setShipName(Object ShipName) {
        this.ShipName = ShipName;
    }

    public Object getShipContactNo() {
        return ShipContactNo;
    }

    public void setShipContactNo(Object ShipContactNo) {
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
         * CRT_Id : 157
         * RJ_ID : 8
         * Session_Id : null
         * QTY : 2
         * PT_Id : 2
         * Createdate : null
         * CreatedBy : null
         * Status : Active
         * DeleteStatus : No
         * TotalAmount : null
         * Amount : 540
         * Ord_Id : null
         * Image : p4-1.png
         * Price : 300
         * Discount : 10
         * DiscountPrice : 270
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
