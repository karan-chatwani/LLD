public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void addNodeFront(DoublyLinkedListNode<E> node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
    }

    public void removeNode(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> nextNode = node.next;
        DoublyLinkedListNode<E> prevNode = node.prev;
        node.prev.next = nextNode;
        node.next.prev = prevNode;
    }

    public DoublyLinkedListNode getFirstNode() {
        if (head.next == tail) {
            return null;
        }
        return head.next;
    }


}
