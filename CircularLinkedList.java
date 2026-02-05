import java.util.NoSuchElementException;

public class CircularLinkedList {

    private ListNode lastNode;  

    public CircularLinkedList() {
        lastNode = null;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    public ListNode getLastNode() {
        if (isEmpty()) return null;
        return lastNode;
    }

    public void addFirst(Object o) {

        if (isEmpty()) {
            lastNode = new ListNode(o, null);
            lastNode.setNext(lastNode);  
        }
        else {
            ListNode first = lastNode.getNext();
            ListNode newNode = new ListNode(o, first);
            lastNode.setNext(newNode); 
        }
    }

    public void addLast(Object o) {

        if (isEmpty()) {
            lastNode = new ListNode(o, null);
            lastNode.setNext(lastNode);
        }
        else {
            ListNode p = new ListNode(o, lastNode.getNext());
            lastNode.setNext(p);
            lastNode = p;
        }
    }

    public Object removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("Can’t remove from empty list");
        }

        ListNode first = lastNode.getNext();
        Object item = first.getValue();

        if (first == lastNode) {
            lastNode = null;
        }
        else {
            lastNode.setNext(first.getNext());
        }

        return item;
    }

    public Object removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException("Can’t remove from empty list");
        }

        ListNode first = lastNode.getNext();

        if (first == lastNode) {
            Object item = lastNode.getValue();
            lastNode = null;
            return item;
        }

        ListNode current = first;
        while (current.getNext() != lastNode) {
            current = current.getNext();
        }

        Object item = lastNode.getValue();

        current.setNext(first);
        lastNode = current;

        return item;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "empty.";
        }
        else {
            String s = "";
            ListNode current = lastNode.getNext();
            while (current != lastNode) {
                s = s + current.getValue() + " ";
                current = current.getNext();
            }
            s = s + current.getValue();
            return s;
        }
    }
}
