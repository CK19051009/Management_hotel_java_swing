package com.example.models;

import java.sql.Date;

public class Voucher {

    private int id;
    private String code;
    private String description;
    private String discountType;
    private double discountValue;
    private double minOrderValue;
    private double maxDiscountValue;
    private Date startDate;
    private Date endDate;
    private int usageLimit;
    private int usedCount = 0;
    private String status = "active";

    public Voucher() {
    }

    public Voucher(String description, String discountType, double discountValue, double minOrderValue,
            double maxDiscountValue, Date startDate, Date endDate, int usageLimit, String status) {
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderValue = minOrderValue;
        this.maxDiscountValue = maxDiscountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageLimit = usageLimit;
        this.status = status;
    }

    public Voucher(String code, String description, String discountType, double discountValue, double minOrderValue,
            double maxDiscountValue, Date startDate, Date endDate, int usageLimit, int usedCount, String status) {
        this.code = code;
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderValue = minOrderValue;
        this.maxDiscountValue = maxDiscountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageLimit = usageLimit;
        this.usedCount = usedCount;
        this.status = status;
    }

    public Voucher(int id, String code, String description, String discountType, double discountValue,
            double minOrderValue, double maxDiscountValue, Date startDate, Date endDate, int usageLimit, int usedCount,
            String status) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderValue = minOrderValue;
        this.maxDiscountValue = maxDiscountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageLimit = usageLimit;
        this.usedCount = usedCount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(double minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public double getMaxDiscountValue() {
        return maxDiscountValue;
    }

    public void setMaxDiscountValue(double maxDiscountValue) {
        this.maxDiscountValue = maxDiscountValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(int usageLimit) {
        this.usageLimit = usageLimit;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voucher [id=" + id + ", code=" + code + ", description=" + description + ", discountType="
                + discountType + ", discountValue=" + discountValue + ", minOrderValue=" + minOrderValue
                + ", maxDiscountValue=" + maxDiscountValue + ", startDate=" + startDate + ", endDate=" + endDate
                + ", usageLimit=" + usageLimit + ", usedCount=" + usedCount + ", status=" + status + "]";
    }

}