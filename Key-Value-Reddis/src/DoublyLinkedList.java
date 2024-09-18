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
        head.next = node;
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    public void removeNode(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> nextNode = node.next;
        DoublyLinkedListNode<E> prevNode = node.prev;
        node.prev.next = nextNode;
        node.next.prev = prevNode;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (head.next == tail) {
            System.out.println("retuning null as first node");
            return null;
        }
        return head.next;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (tail.prev == head) {
            System.out.println("retuning null as last node");
            return null;
        }
        return tail.prev;
    }


}
