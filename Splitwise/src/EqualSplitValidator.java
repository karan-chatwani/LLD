import models.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EqualSplitValidator extends SplitValidator {

    @Override
    public boolean validateSplitAmount(List<Split> splits, double totalAmount) {
        if (!super.validateSplitAmount(splits, totalAmount)) {
            return false;
        }
        HashMap<Double, Integer> m = new HashMap<>();
        for (Split split : splits) {
            m.put(split.getLentAmount(), 1);
        }
        return m.size() == 1;
    }
}
