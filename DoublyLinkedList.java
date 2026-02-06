import java.util.NoSuchElementException;

class DoublyLinkedList {

    private final DoublyListNode headerNode;
    private final DoublyListNode trailerNode;

    // Construct an empty list.
    public DoublyLinkedList() {
        headerNode = new DoublyListNode(null, null, null);
        trailerNode = new DoublyListNode(headerNode, null, null);
        headerNode.setNext(trailerNode);
    }

    // Return true if list is empty, false otherwise.
    public boolean isEmpty() {
        return headerNode.getNext() == trailerNode;
        // or: return trailerNode.getPrev() == headerNode;
    }

    // Return first node in a nonempty list.
    public DoublyListNode getFirstNode() {
        return headerNode.getNext();
    }

    // Return last node in a nonempty list.
    public DoublyListNode getLastNode() {
        return trailerNode.getPrev();
    }

    // Insert object o at end of list.
    public void addLast(Object o) {
        DoublyListNode p = new DoublyListNode(trailerNode.getPrev(), o, trailerNode);
        trailerNode.getPrev().setNext(p);
        trailerNode.setPrev(p);
    }

    // Insert object o at front of list.
    public void addFirst(Object o) {
        DoublyListNode p =
            new DoublyListNode(headerNode, o, headerNode.getNext());

        headerNode.getNext().setPrev(p);
        headerNode.setNext(p);
    }

    // Remove and return first element.
    public Object removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Can’t remove from empty list");

        DoublyListNode p = headerNode.getNext();
        Object item = p.getValue();

        headerNode.setNext(p.getNext());
        p.getNext().setPrev(headerNode);

        return item;
    }

    // Remove and return last element.
    public Object removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Can’t remove from empty list");

        DoublyListNode p = trailerNode.getPrev();
        Object item = p.getValue();

        trailerNode.setPrev(p.getPrev());
        p.getPrev().setNext(trailerNode);

        return item;
    }

    // Add item to the left of node.
    // Precondition: node refers to an element in a nonempty list.
    void addLeft(Object item, DoublyListNode node) {

        DoublyListNode p =
            new DoublyListNode(node.getPrev(), item, node);

        node.getPrev().setNext(p);
        node.setPrev(p);
    }

    // Add item to the right of node.
    // Precondition: node refers to an element in a nonempty list.
    void addRight(Object item, DoublyListNode node) {

        DoublyListNode p =
            new DoublyListNode(node, item, node.getNext());

        node.getNext().setPrev(p);
        node.setNext(p);
    }

    // Remove element referred to by node from list.
    // Precondition: node points to element in list.
    public void remove(DoublyListNode node) {

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    // Return DoublyLinkedList as String.
    @Override
    public String toString() {

        if (isEmpty())
            return "empty.";

        String s = "";
        DoublyListNode p = headerNode.getNext();

        while (p != trailerNode) {
            s = s + p.getValue() + " ";
            p = p.getNext();
        }

        return s;
    }
}
