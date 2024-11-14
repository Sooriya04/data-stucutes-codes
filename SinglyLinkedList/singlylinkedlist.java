package Expirements.SinglyLinkedList;
import java.util.Scanner;
class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAnywhere(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            insertFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete a node at a specific position
    public void deleteAnywhere(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or empty list");
            return;
        }
        if (position == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    // Find a node with the given value and return its position
    public void findAnywhere(int data) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Value " + data + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Value " + data + " not found in the list.");
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert Anywhere");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete Anywhere");
            System.out.println("7. Find Anywhere");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at the beginning: ");
                    int dataFirst = scanner.nextInt();
                    list.insertFirst(dataFirst);
                    list.display();
                    break;
                case 2:
                    System.out.print("Enter data to insert at the end: ");
                    int dataLast = scanner.nextInt();
                    list.insertLast(dataLast);
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int dataAnywhere = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.insertAnywhere(dataAnywhere, position);
                    list.display();
                    break;
                case 4:
                    list.deleteFirst();
                    list.display();
                    break;
                case 5:
                    list.deleteLast();
                    list.display();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int delPosition = scanner.nextInt();
                    list.deleteAnywhere(delPosition);
                    list.display();
                    break;
                case 7:
                    System.out.print("Enter value to find: ");
                    int findValue = scanner.nextInt();
                    list.findAnywhere(findValue);
                    list.display();
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
