import models.Expense;
import models.Split;
import models.SplitType;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //user group expense split balance sheet
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User();
        user1.setUserId("karan");
        User user2 = new User();
        user2.setUserId("laxman");
        User user3 = new User();
        user3.setUserId("puneet");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        SplitWise splitWise = new SplitWise();
        String groupId = splitWise.createGroup(userList);
        Split split = new Split("laxman", 100);
        Split split2 = new Split("puneet", 100);
        Split spli3 = new Split("karan", 100);
        List<Split> splitList = new ArrayList<>();
        splitList.add(split);
        splitList.add(split2);
        splitList.add(spli3);
        Expense expense = new Expense(300.0, "karan", splitList, SplitType.EQUAL);
        splitWise.addExpenseToGroup(expense, groupId);
        System.out.println(user1.getBalanceSheet().getTotalExpenses());
        System.out.println(user1.getBalanceSheet().getTotalOwes());
        System.out.println(user1.getBalanceSheet().getTotalDue());

        Expense expense1 = new Expense(300.0, "puneet", splitList, SplitType.EQUAL);
        splitWise.addExpenseToGroup(expense1, groupId);
        System.out.println(user1.getBalanceSheet().getTotalExpenses());
        System.out.println(user1.getBalanceSheet().getTotalOwes());
        System.out.println(user1.getBalanceSheet().getTotalDue());

    }
}