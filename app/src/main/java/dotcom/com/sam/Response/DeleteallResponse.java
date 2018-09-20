package dotcom.com.sam.Response;

import java.util.List;

/**
 * Created by Dotcom on 2/20/2017.
 */

public class DeleteallResponse {


    /**
     * success : false
     * Messege : Data Not Found
     * status : 404
     * response : []
     */

    private boolean success;
    private String Messege;
    private int status;
    private List<?> response;

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

    public List<?> getResponse() {
        return response;
    }

    public void setResponse(List<?> response) {
        this.response = response;
    }
}
