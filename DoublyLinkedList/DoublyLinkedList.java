package Expirements.DoublyLinkedList;

import java.util.Scanner;
class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;
    Node tail;
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        newNode.prev = temp;
        temp.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (tail.prev == null) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

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
        int count = 1;
        while (temp != null && count < position) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

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

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

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
                    break;
                case 2:
                    System.out.print("Enter data to insert at the end: ");
                    int dataLast = scanner.nextInt();
                    list.insertLast(dataLast);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int dataAnywhere = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.insertAnywhere(dataAnywhere, position);
                    break;
                case 4:
                    list.deleteFirst();
                    break;
                case 5:
                    list.deleteLast();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int delPosition = scanner.nextInt();
                    list.deleteAnywhere(delPosition);
                    break;
                case 7:
                    System.out.print("Enter value to find: ");
                    int findValue = scanner.nextInt();
                    list.findAnywhere(findValue);
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
