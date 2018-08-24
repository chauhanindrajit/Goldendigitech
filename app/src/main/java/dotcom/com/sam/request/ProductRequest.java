package dotcom.com.sam.request;

/**
 * Created by sanjay on 11/8/2017.
 */

public class ProductRequest {



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
