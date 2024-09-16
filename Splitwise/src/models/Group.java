package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private String groudId;
    private List<User> userList;
    private List<Expense> expenses;
    private Map<String, User> userMap;

    public Group(String groudId, List<User> userList) {
        this.groudId = groudId;
        this.userList = userList;
        userMap = new HashMap<>();
        for (User user : userList) {
            userMap.put(user.getUserId(), user);
        }
        expenses = new ArrayList<>();
    }

    public String getGroudId() {
        return groudId;
    }

    public void setGroudId(String groudId) {
        this.groudId = groudId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);

    }

    public synchronized void updateBalanceSheet(Expense expense) {
        User userPaid = userMap.get(expense.getUserId());
        BalanceSheet userPaidBalanceSheet = userPaid.getBalanceSheet();
        userPaidBalanceSheet.addTotalExpenses(expense.getAmount());
        for (Split split : expense.getSplit()) {
            User userlent = userMap.get(split.getUserId());
            if (userlent.equals(userPaid)) {
                continue;
            }
            updateUserPaidBalanceSheet(userPaidBalanceSheet, split.getUserId(), split.getLentAmount());
            BalanceSheet userOwedBalanceSheet = userlent.getBalanceSheet();
            updateUserOweBalanceSheet(userOwedBalanceSheet, expense.getUserId(), split.getLentAmount());
        }
    }

    private void updateUserPaidBalanceSheet(BalanceSheet userPaidBalanceSheet, String userOewId, double amount) {
        Balance balance = userPaidBalanceSheet.getUserBalanceSheetMap().get(userOewId);
        if (balance == null) {
            balance = new Balance();
            balance.addGetBackAmount(amount);
            userPaidBalanceSheet.getUserBalanceSheetMap().put(userOewId, balance);
            return;
        }
        balance.addGetBackAmount(amount);

    }

    private void updateUserOweBalanceSheet(BalanceSheet userPaidBalanceSheet, String userPaidId, double amount) {
        Balance balance = userPaidBalanceSheet.getUserBalanceSheetMap().get(userPaidId);
        if (balance == null) {
            balance = new Balance();
            balance.addGiveBackAmount(amount);
            userPaidBalanceSheet.getUserBalanceSheetMap().put(userPaidId, balance);
            return;
        }
        balance.addGiveBackAmount(amount);
    }

}
