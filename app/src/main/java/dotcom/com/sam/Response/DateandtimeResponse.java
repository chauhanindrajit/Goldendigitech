package dotcom.com.sam.Response;

/**
 * Created by Dotcom on 2/20/2017.
 */

public class DateandtimeResponse {


    /**
     * success : true
     * Messege : NotBooked
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
