import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class KeyValueStore implements Cache {
    private Map<String, VersionedValue> data = new HashMap<>(); //always add when confirm(no transaction) or commit(last phase of transaction)
    private ThreadLocal<Transaction> currentTransaction = new ThreadLocal<>();
    private AtomicLong globalVersion = new AtomicLong(0);

    @Override
    public String get(String key) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            if (transaction.deleteSets.contains(key)) {
                return null;
            }
            if (transaction.writeSets.containsKey(key)) {
                return transaction.writeSets.get(key);
            }
        }
        VersionedValue versionedValue = data.get(key);
        if (versionedValue == null) return null;
        if (transaction != null) {
            transaction.readSets.put(key, versionedValue);
        }
        return versionedValue.getValue();
    }

    @Override
    public void set(String key, String value) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            transaction.deleteSets.remove(key);
            transaction.writeSets.put(key, value);
        } else {
            VersionedValue versionedValue = new VersionedValue(value, globalVersion.getAndIncrement());
            data.put(key, versionedValue);
        }
    }

    @Override
    public void remove(String key) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            transaction.writeSets.remove(key);
            transaction.deleteSets.add(key);
        } else {
            data.remove(key);
        }
    }

    @Override
    public void begin() {
        if (currentTransaction.get() != null) {
            throw new IllegalStateException("Tranaction already created");
        }
        currentTransaction.set(new Transaction());
    }

    @Override
    public boolean commit() {
        if (currentTransaction.get() == null) {
            throw new IllegalStateException("No Tranaction to commit");
        }
        for (Map.Entry<String, VersionedValue> entry : currentTransaction.get().readSets.entrySet()) {
            VersionedValue versionInCommit = entry.getValue();
            VersionedValue versionCommited = data.get(entry.getKey());
            if (versionInCommit.getVersion() != versionCommited.getVersion()) {
                currentTransaction.remove();
                return false;
            }
        }
        for (Map.Entry<String, String> entry : currentTransaction.get().writeSets.entrySet()) {
            data.put(entry.getKey(), new VersionedValue(entry.getValue(), globalVersion.getAndIncrement()));
        }
        for (String key : currentTransaction.get().deleteSets) {
            data.remove(key);
        }
        currentTransaction.remove();

        return true;
    }

    @Override
    public void rollback() {
        if (currentTransaction.get() == null) {
            throw new IllegalStateException("No Tranaction to rollback");
        }
        currentTransaction.remove();
    }
}
