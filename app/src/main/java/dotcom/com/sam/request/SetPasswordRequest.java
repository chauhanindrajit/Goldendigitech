package dotcom.com.sam.request;

import com.google.gson.Gson;

/**
 * Created by sanjay on 11/8/2017.
 */

public class SetPasswordRequest {

    /**
     * NewPassword : Yogesh@123
     * Email : gadhekar.yogesh@worldindia.com
     * OTP : A49TZK
     */

    private String NewPassword;
    private String Email;
    private String OTP;

    public static SetPasswordRequest objectFromData(String str) {

        return new Gson().fromJson(str, SetPasswordRequest.class);
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }
}
