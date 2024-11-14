package Expirements.queue.Applications;
class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }
    //people is joining
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add more people.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
        System.out.println("Person " + value + " joined the line.");
    }
    //people left
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No one to serve.");
            return -1;
        }
        int removedPerson = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println("Person " + removedPerson + " has been served and left the line.");
        return removedPerson;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public void displayQueue() {
        System.out.print("Current line: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }
}

public class GroceryStoreLine {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.displayQueue();

        System.out.println("Current number of people in line: " + queue.size());
    }
}
