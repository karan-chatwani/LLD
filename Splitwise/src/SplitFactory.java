import models.SplitType;

import java.util.Objects;

public class SplitFactory {
    public static SplitValidator getSplitValidator(SplitType splitType) {
        if (Objects.requireNonNull(splitType) == SplitType.EQUAL) {
            return new EqualSplitValidator();
        } else if (splitType == SplitType.UNEQUAL) {
            return new UnequalSplitValidator();
        }
        return null;
    }
}
