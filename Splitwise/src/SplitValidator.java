import models.Split;

import java.util.List;

public abstract class SplitValidator {

    protected boolean validateSplitAmount(List<Split> splits, double totalAmount) {
        double expenses = 0.0;
        for (Split split : splits) {
            expenses += split.getLentAmount();
        }
        return expenses == totalAmount;
    }
}
