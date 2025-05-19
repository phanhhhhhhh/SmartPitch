package model;

import java.util.Date;

public class SystemLog {

    private int logID;
    private int userID;
    private String action;
    private String tableName;
    private String detail;
    private Date createdAt;

    public SystemLog() {
    }

    public SystemLog(int logID, int userID, String action, String tableName, String detail, Date createdAt) {
        this.logID = logID;
        this.userID = userID;
        this.action = action;
        this.tableName = tableName;
        this.detail = detail;
        this.createdAt = createdAt;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
