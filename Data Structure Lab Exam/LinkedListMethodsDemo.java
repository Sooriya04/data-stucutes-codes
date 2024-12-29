import java.util.*;

public class LinkedListMethodsDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        System.out.println("Initial LinkedList: " + linkedList);

        List<String> moreFruits = Arrays.asList("Date", "Elderberry");
        LinkedList<String> linkedListFromCollection = new LinkedList<>(moreFruits);
        System.out.println("LinkedList from collection: " + linkedListFromCollection);

        linkedList.addFirst("Blueberry");
        System.out.println("After adding Blueberry to the beginning: " + linkedList);

        linkedList.addLast("Fig");
        System.out.println("After adding Fig to the end: " + linkedList);

        System.out.println("First element: " + linkedList.getFirst());

        System.out.println("Last element: " + linkedList.getLast());

        linkedList.removeFirst();
        System.out.println("After removing the first element: " + linkedList);

        linkedList.removeLast();
        System.out.println("After removing the last element: " + linkedList);
    }
}