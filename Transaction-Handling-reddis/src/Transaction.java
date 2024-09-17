import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Transaction {
    Map<String, VersionedValue> readSets;
    Map<String, String> writeSets;
    Set<String> deleteSets;

    public Transaction() {
        readSets = new HashMap<>();
        writeSets = new HashMap<>();
        deleteSets = new HashSet<>();
    }
}

