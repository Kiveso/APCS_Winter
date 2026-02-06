import java.util.NoSuchElementException;

public class LinearLinkedList {
    private ListNode firstNode;

    public LinearLinkedList() {
        firstNode = null; 
    }

    public boolean isEmpty() { 
        return firstNode == null; 
    } 

    public ListNode getFirstNode() { 
        return firstNode; 
    }

    public void setFirstNode(ListNode node) { 
        firstNode = node; 
    } 
    
    public void addFirst(Object o) { 
        if (isEmpty()) {
            firstNode = new ListNode(o, null); 
        } 

        else {
            firstNode = new ListNode(o, firstNode); 
        }
    }

    public void addLast(Object o) { 
        if (isEmpty()) {
            firstNode = new ListNode(o, null);
        } 
        
        else { 
            ListNode current = firstNode; 
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ListNode(o, null));
        }
    }

    public Object removeFirst() { 
        if (isEmpty()) { 
            throw new NoSuchElementException( "Can’t remove from empty list"); 
        }
        Object item = firstNode.getValue(); firstNode = firstNode.getNext(); 
        return item; 
    }
    
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException( "Can’t remove from empty list");
        }
        
        ListNode current = firstNode; 
        ListNode follow = null; 
        while (current.getNext() != null) { 
            follow = current; current = current.getNext(); 
        }

        if (follow == null) { 
            firstNode = null;
        }
        else {
            follow.setNext(null); return current.getValue(); 
        }
        return current.getValue();
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "empty.";
        }
        else {
            String s = "";
            ListNode current = firstNode;
        
            while(current != null) {
                s = s + current.getValue() + " "; 
                current = current.getNext();
            }
            return s;
        }
    }
}
