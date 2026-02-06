public class DoublyListNode {

    private Object value;
    private DoublyListNode next;
    private DoublyListNode prev;

    // Constructor
    public DoublyListNode(DoublyListNode initPrev, Object initValue, DoublyListNode initNext) {
        prev = initPrev;
        value = initValue;
        next = initNext;
    }

    // Getter and Setter for prev
    public DoublyListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyListNode theNewPrev) {
        prev = theNewPrev;
    }

    // Getter and Setter for value
    public Object getValue() {
        return value;
    }

    public void setValue(Object theNewValue) {
        value = theNewValue;
    }

    // Getter and Setter for next
    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode theNewNext) {
        next = theNewNext;
    }
}

