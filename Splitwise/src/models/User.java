package models;

public class User {
    private String userId;
    private BalanceSheet balanceSheet;

    public User() {
        balanceSheet = new BalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
