package Expirements.queue;
import java.util.Scanner;
class Queue{
    private int front, rear, size;
    private int[] queue;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add element.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = value;
            System.out.println("Enqueued " + value);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove element.");
        } else {
            System.out.println("Dequeued " + queue[front]);
            front++;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
