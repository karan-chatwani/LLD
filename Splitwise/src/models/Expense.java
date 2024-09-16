package models;

import java.util.List;

public class Expense {
    private Double amount;
    private String userId;
    private List<Split> split;
    private SplitType splitType;

    public Expense(Double amount, String userId, List<Split> split, SplitType splitType) {
        this.amount = amount;
        this.userId = userId;
        this.split = split;
        this.splitType = splitType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Split> getSplit() {
        return split;
    }

    public void setSplit(List<Split> split) {
        this.split = split;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
}
