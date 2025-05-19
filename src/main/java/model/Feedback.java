package model;

import java.util.Date;

public class Feedback {

    private int feedbackID;
    private int userID;
    private Integer stadiumID;
    private Integer foodItemID;
    private int rating;
    private String comment;
    private Date createdAt;

    public Feedback() {
    }

    public Feedback(int feedbackID, int userID, Integer stadiumID, Integer foodItemID, int rating, String comment, Date createdAt) {
        this.feedbackID = feedbackID;
        this.userID = userID;
        this.stadiumID = stadiumID;
        this.foodItemID = foodItemID;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Integer getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(Integer stadiumID) {
        this.stadiumID = stadiumID;
    }

    public Integer getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(Integer foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
