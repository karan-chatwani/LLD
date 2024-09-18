import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LruEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> doublyLinkedList = new DoublyLinkedList<>();
    Map<Key, DoublyLinkedListNode<Key>> doublyLinkedListNodeMap = new HashMap<>();

    @Override
    public void keyAccessded(Key key) {
        if (!doublyLinkedListNodeMap.containsKey(key)) {
            doublyLinkedList.addNodeFront(new DoublyLinkedListNode<>(key));
            doublyLinkedListNodeMap.put(key, doublyLinkedList.getFirstNode());
        } else {
            DoublyLinkedListNode<Key> accessedNode = doublyLinkedListNodeMap.get(key);
            doublyLinkedList.removeNode(accessedNode);
            doublyLinkedList.addNodeFront(new DoublyLinkedListNode<>(key));
            doublyLinkedListNodeMap.put(key, doublyLinkedList.getFirstNode());
        }

    }

    @Override
    public Key evict() {
        DoublyLinkedListNode<Key> lastNode = doublyLinkedList.getLastNode();
        if (lastNode == null) return null;
        doublyLinkedList.removeNode(lastNode);
        System.out.println("key evicted" + lastNode.element);
        return lastNode.element;
    }
}
