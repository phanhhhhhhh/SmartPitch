package model;

public class FoodOrderItem {

    private int foodOrderItemID;
    private int foodOrderID;
    private int foodItemID;
    private int quantity;
    private double price;

    public FoodOrderItem() {
    }

    public FoodOrderItem(int foodOrderItemID, int foodOrderID, int foodItemID, int quantity, double price) {
        this.foodOrderItemID = foodOrderItemID;
        this.foodOrderID = foodOrderID;
        this.foodItemID = foodItemID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getFoodOrderItemID() {
        return foodOrderItemID;
    }

    public void setFoodOrderItemID(int foodOrderItemID) {
        this.foodOrderItemID = foodOrderItemID;
    }

    public int getFoodOrderID() {
        return foodOrderID;
    }

    public void setFoodOrderID(int foodOrderID) {
        this.foodOrderID = foodOrderID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
