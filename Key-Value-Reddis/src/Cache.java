public class Cache<Key, Value> {
    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessded(key);
        } catch (RuntimeException e) {
            Key keyRemoved = evictionPolicy.evict();
            if (keyRemoved == null) {
                throw new RuntimeException("no key to evict");
            }
            storage.remove(keyRemoved);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessded(key);
            return value;
        } catch (RuntimeException e) {
            System.out.println("no key present");
            return null;
        }
    }
}
