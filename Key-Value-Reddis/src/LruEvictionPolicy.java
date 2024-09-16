import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LruEvictionPolicy<Key> implements EvictionPolicy<Key> {
    Deque<Key> deque = new ArrayDeque<>();

    @Override
    public void keyAccessded(Key key) {

    }

    @Override
    public Key evict() {
        return null;
    }
}
