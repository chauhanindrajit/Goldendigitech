package dotcom.com.sam.request;

/**
 * Created by sanjay on 11/8/2017.
 */

public class ChangePassRequest {


    /**
     * RJ_ID : 1
     * FullName : sample string 2
     * Email : sample string 3
     * MobNo : sample string 4
     * Password : sample string 5
     * CnfPassword : sample string 6
     * Address : sample string 7
     * CreatedDate : 2018-08-01T14:58:16.3926254+05:30
     * CreatedBy : sample string 8
     * ModifyBy : sample string 9
     * ModifyDate : 2018-08-01T14:58:16.3926254+05:30
     * Status : sample string 10
     * DeleteStatus : sample string 11
     * ShippingAddress : sample string 12
     * ShipName : sample string 13
     * ShipContactNo : sample string 14
     */


    private String Email;
    private String Password;
    private String CnfPassword;
    private String CreatedBy;




    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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


    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }




}
