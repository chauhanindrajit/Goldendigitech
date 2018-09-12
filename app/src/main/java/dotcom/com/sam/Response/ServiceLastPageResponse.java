package dotcom.com.sam.Response;

/**
 * Created by sanjay on 10/25/2017.
 */

public class ServiceLastPageResponse {


    /**
     * success : true
     * Messege : Register Successfull
     * status : 200
     */

    private boolean success;
    private String Messege;
    private int status;

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
}
