package model;

import java.util.Date;

public class FoodOrder {

    private int foodOrderID;
    private int userID;
    private int stadiumID;
    private Integer discountCodeID;
    private String status;
    private double totalAmount;
    private Date createdAt;

    public FoodOrder() {
    }

    public FoodOrder(int foodOrderID, int userID, int stadiumID, Integer discountCodeID, String status, double totalAmount, Date createdAt) {
        this.foodOrderID = foodOrderID;
        this.userID = userID;
        this.stadiumID = stadiumID;
        this.discountCodeID = discountCodeID;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    public int getFoodOrderID() {
        return foodOrderID;
    }

    public void setFoodOrderID(int foodOrderID) {
        this.foodOrderID = foodOrderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(int stadiumID) {
        this.stadiumID = stadiumID;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
