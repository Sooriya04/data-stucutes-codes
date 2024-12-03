package Hashing;
import java.util.*;
class HashTable {
    class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
    private Node[] table;
    private int size;
    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
    }
    private int hashFunction(int key) {
        return key % size;
    }
    public void insert(int key) {
        int index = hashFunction(key);
        Node newNode = new Node(key);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public boolean search(int key) {
        int index = hashFunction(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public boolean delete(int key) {
        int index = hashFunction(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print(current.key + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
public class Chaining  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable hashTable = new HashTable(5);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    hashTable.insert(keyToInsert);
                    System.out.println("Key " + keyToInsert + " inserted.");
                    break;

                case 2:
                    System.out.print("Enter a key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    if (hashTable.delete(keyToDelete)) {
                        System.out.println("Key " + keyToDelete + " deleted.");
                    } else {
                        System.out.println("Key " + keyToDelete + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter a key to search: ");
                    int keyToSearch = scanner.nextInt();
                    if (hashTable.search(keyToSearch)) {
                        System.out.println("Key " + keyToSearch + " found.");
                    } else {
                        System.out.println("Key " + keyToSearch + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Hash Table:");
                    hashTable.display();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
