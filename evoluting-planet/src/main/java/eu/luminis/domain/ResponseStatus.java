package eu.luminis.domain;

/**
 * Created by gerardverbeek on 04/09/16.
 */
public class ResponseStatus {
    private boolean successful;
    private String message;

    public ResponseStatus(boolean successful) {
        this.successful = successful;
    }

    public ResponseStatus(String message, boolean successful) {
        this.message = message;
        this.successful = successful;
    }

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public boolean isSuccessful() {
        return successful;
    }
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
