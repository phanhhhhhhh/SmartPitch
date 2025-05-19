package model;

import java.util.Date;
import java.sql.Time;

public class TimeSlot {

    private int timeSlotID;
    private int stadiumID;
    private Date date;
    private Time startTime;
    private Time endTime;
    private double price;

    public TimeSlot() {
    }

    public TimeSlot(int timeSlotID, int stadiumID, Date date, Time startTime, Time endTime, double price) {
        this.timeSlotID = timeSlotID;
        this.stadiumID = stadiumID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public void setTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(int stadiumID) {
        this.stadiumID = stadiumID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
