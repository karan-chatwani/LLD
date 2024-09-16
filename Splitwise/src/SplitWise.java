import models.Expense;
import models.Group;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SplitWise {
    private Map<String, Group> groupMap;

    public SplitWise() {
        groupMap = new HashMap<>();
    }

    public String createGroup(List<User> userList) {
        String groupId = UUID.randomUUID().toString();
        Group group = new Group(groupId, userList);
        groupMap.put(groupId, group);
        return groupId;
    }

    public void addExpenseToGroup(Expense expense, String groupId) {
        boolean valid = SplitFactory.getSplitValidator(expense.getSplitType()).validateSplitAmount(expense.getSplit(), expense.getAmount());
        if (!valid) {
            throw new RuntimeException();
        }
        Group group = groupMap.get(groupId);
        group.addExpense(expense);
        group.updateBalanceSheet(expense);
    }
}
