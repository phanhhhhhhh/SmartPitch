package model;

import java.util.Date;

public class Stadium {

    private int stadiumID;
    private String name;
    private String location;
    private String description;
    private String status;
    private Date createdAt;
    private String phoneNumber;
    private int OwnerID;
    private Double latitude;
    private Double longitude;
    private Double distance; // dùng để sắp xếp sân gần


    public Stadium() {
    }


    public Stadium(int stadiumID, String name, String location, String description, String status, Date createdAt, String phoneNumber, int OwnerID) {
        this.stadiumID = stadiumID;
        this.name = name;
        this.location = location;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
        this.OwnerID = OwnerID;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(int stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }
    
    
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
    
}
