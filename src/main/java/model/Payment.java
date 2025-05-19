package model;

import java.util.Date;

public class Payment {

    private int paymentID;
    private Integer bookingID;
    private Integer foodOrderID;
    private String paymentMethod;
    private double amount;
    private Date paymentDate;
    private String status;
    private String transactionID;

    public Payment() {
    }

    public Payment(int paymentID, Integer bookingID, Integer foodOrderID, String paymentMethod, double amount, Date paymentDate, String status, String transactionID) {
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.foodOrderID = foodOrderID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.transactionID = transactionID;
    }
}
