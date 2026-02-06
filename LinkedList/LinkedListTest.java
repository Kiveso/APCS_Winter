import java.util.Scanner;

public class LinkedListTest {
    public static LinearLinkedList getList(Scanner scanner) {

        final String SENTINEL = "-999";
        LinearLinkedList list = new LinearLinkedList();

        System.out.print("Enter list of words. ");
        System.out.println("Terminate with " + SENTINEL);

        String word = scanner.next();   // read user input

        while (!(word.equals(SENTINEL))) {
            list.addLast(word);
            word = scanner.next();      // read user input
        }

        return list;
    }

    public static boolean search(LinearLinkedList list, Object key) {

        ListNode current = list.getFirstNode();

        while (current != null) {
            if (current.getValue().equals(key))
                return true;

            current = current.getNext();
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinearLinkedList list = getList(scanner);

        System.out.print("List is: ");
        System.out.println(list);

        /*
        String first = (String) list.removeFirst();
        System.out.println("First element was: " + first);

        String last = (String) list.removeLast();
        System.out.println("Last element was: " + last);

        System.out.print("List is: ");
        System.out.println(list);
        */

        System.out.print("Enter key word for search: ");
        String key = scanner.next();    

        if (search(list, key))
            System.out.println(key + " is in the list.");
        else
            System.out.println(key + " is not in the list.");

        scanner.close();
    }
}
