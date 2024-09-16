import models.Split;

import java.util.HashMap;
import java.util.List;

public class UnequalSplitValidator extends SplitValidator {
    @Override
    public boolean validateSplitAmount(List<Split> splits, double totalAmount) {
        if (!super.validateSplitAmount(splits, totalAmount)) {
            return false;
        }
        return true;
    }
}
