
import java.util.HashMap;

public class HashmapStorage<Key, Value> implements Storage<Key, Value> {
    private HashMap<Key, Value> hashMap;
    private int capacity;

    public HashmapStorage(int capacity) {
        hashMap = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public Value get(Key key) {
        if (!hashMap.containsKey(key)) {
            throw new RuntimeException("no key found");
        }
        return hashMap.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        if (hashMap.size() >= capacity) {
            throw new RuntimeException("storage full");
        }
        hashMap.put(key, value);
    }

    @Override
    public void remove(Key key) {
        if (!hashMap.containsKey(key)) {
            throw new RuntimeException("no key found");
        }
        hashMap.remove(key);
    }
}
