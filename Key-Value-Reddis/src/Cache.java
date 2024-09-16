public class Cache<Key, Value> {
    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key, Value> storage;
}
