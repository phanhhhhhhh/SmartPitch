package model;

import java.util.Date;

public class DiscountCode {

    private int discountCodeID;
    private String code;
    private int discountPercent;
    private Date expiryDate;
    private int maxUsage;
    private int usedCount;

    public DiscountCode() {
    }

    public DiscountCode(int discountCodeID, String code, int discountPercent, Date expiryDate, int maxUsage, int usedCount) {
        this.discountCodeID = discountCodeID;
        this.code = code;
        this.discountPercent = discountPercent;
        this.expiryDate = expiryDate;
        this.maxUsage = maxUsage;
        this.usedCount = usedCount;
    }

    public int getDiscountCodeID() {
        return discountCodeID;
    }

    public void setDiscountCodeID(int discountCodeID) {
        this.discountCodeID = discountCodeID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(int maxUsage) {
        this.maxUsage = maxUsage;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }
}
