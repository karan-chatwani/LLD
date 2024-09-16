public interface Storage<Key, Value> {
    Value get(Key key);
    void put(Key key,Value value);
    void remove(Key key);
}
