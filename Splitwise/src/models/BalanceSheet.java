package models;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    Map<String, Balance> userBalanceSheetMap;
    private double totalExpenses;
    private double totalOwes;
    private double totalDue;

    public BalanceSheet() {
        userBalanceSheetMap = new HashMap<>();
        totalExpenses = 0.0;
        totalOwes = 0.0;
        totalDue = 0.0;
    }

    public Map<String, Balance> getUserBalanceSheetMap() {
        return userBalanceSheetMap;
    }

    public void setUserBalanceSheetMap(Map<String, Balance> userBalanceSheetMap) {
        this.userBalanceSheetMap = userBalanceSheetMap;
    }


    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void addTotalExpenses(double amount) {
        totalExpenses = totalExpenses + amount;
    }

    public double getTotalOwes() {
        double oweAmount = 0.0;
        for (Balance balance : userBalanceSheetMap.values()) {
            if (balance.getBackAmount > 0) {
                oweAmount += balance.getBackAmount;
            }
        }
        return oweAmount;
    }

    public void addTotalOwes(double amount) {
        totalOwes = totalOwes + amount;
    }

    public double getTotalDue() {
        double dueAmount = 0.0;
        for (Balance balance : userBalanceSheetMap.values()) {
            if (balance.giveBackAmount > 0) {
                dueAmount += balance.giveBackAmount;
            }
        }
        return dueAmount;
    }

    public void addTotalDue(double amount) {
        totalDue = totalDue + amount;
    }
}
