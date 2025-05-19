package model;

import java.util.Date;

public class Booking {

    private int bookingID;
    private int userID;
    private int timeSlotID;
    private Integer discountCodeID;
    private String status;
    private Date createdAt;

    public Booking() {
    }

    public Booking(int bookingID, int userID, int timeSlotID, Integer discountCodeID, String status, Date createdAt) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.timeSlotID = timeSlotID;
        this.discountCodeID = discountCodeID;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public void setTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public Integer getDiscountCodeID() {
        return discountCodeID;
    }

    public void setDiscountCodeID(Integer discountCodeID) {
        this.discountCodeID = discountCodeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
