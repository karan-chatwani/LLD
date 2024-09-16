import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LruEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> doublyLinkedList = new DoublyLinkedList<>();
    Map<Key, DoublyLinkedListNode<Key>> doublyLinkedListNodeMap;

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
        DoublyLinkedListNode<Key> firstNode = doublyLinkedList.getFirstNode();
        if (firstNode == null) return null;
        doublyLinkedList.removeNode(firstNode);
        return firstNode.element;
    }
}
