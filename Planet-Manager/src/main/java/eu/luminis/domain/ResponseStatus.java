package eu.luminis.domain;

public class ResponseStatus {
    private boolean successful;
    private String message;

    public ResponseStatus(){}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public boolean isSuccessful() {
        return successful;
    }
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
