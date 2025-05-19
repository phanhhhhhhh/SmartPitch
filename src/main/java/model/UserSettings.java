package model;

public class UserSettings {

    private int userID;
    private boolean receiveEmail;
    private boolean receiveSMS;
    private boolean receivePush;

    public UserSettings() {
    }

    public UserSettings(int userID, boolean receiveEmail, boolean receiveSMS, boolean receivePush) {
        this.userID = userID;
        this.receiveEmail = receiveEmail;
        this.receiveSMS = receiveSMS;
        this.receivePush = receivePush;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(boolean receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    public boolean isReceiveSMS() {
        return receiveSMS;
    }

    public void setReceiveSMS(boolean receiveSMS) {
        this.receiveSMS = receiveSMS;
    }

    public boolean isReceivePush() {
        return receivePush;
    }

    public void setReceivePush(boolean receivePush) {
        this.receivePush = receivePush;
    }
}
