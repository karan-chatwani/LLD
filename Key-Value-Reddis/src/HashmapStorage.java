import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;

public class HashmapStorage<Key, Value> implements Storage<Key, Value> {
    private HashMap<Key, Value> hashMap = new HashMap<>();

    @Override
    public Value get(Key key) {
        return hashMap.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        hashMap.put(key, value);
    }

    @Override
    public void remove(Key key) {
        hashMap.remove(key);
    }
}
