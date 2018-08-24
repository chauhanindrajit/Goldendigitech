package dotcom.com.sam.Response;

import java.util.List;

/**
 * Created by sanjay on 10/25/2017.
 */

public class SubcategoryResponse {


    /**
     * success : true
     * Messege : sample string 2
     * status : 3
     * response : [{"Sc_Id":1,"SubCategoryName":"sample string 2","Cretaedate":"2018-08-10T09:58:57.3831239+05:30","CretaedBy":"sample string 3","ModifyDate":"2018-08-10T09:58:57.3831239+05:30","ModifyBy":"sample string 4","Status":"sample string 5","DeleteStatus":"sample string 6","C_Id":1,"CategosryName":"sample string 7","Image":"sample string 8"}]
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
         * Sc_Id : 1
         * SubCategoryName : sample string 2
         * Cretaedate : 2018-08-10T09:58:57.3831239+05:30
         * CretaedBy : sample string 3
         * ModifyDate : 2018-08-10T09:58:57.3831239+05:30
         * ModifyBy : sample string 4
         * Status : sample string 5
         * DeleteStatus : sample string 6
         * C_Id : 1
         * CategosryName : sample string 7
         * Image : sample string 8
         */

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
    }
}
