package Expirements.BinaryHeapTree;
import java.util.Arrays;
import java.util.Scanner;
public class BinaryHeapTree {
    private int[] heap;
    private int size;
    private int capacity;

    public BinaryHeapTree(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) { return (index - 1) / 2; }
    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full, cannot insert");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        while (index != 0 && heap[parent(index)] < heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int deleteMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int findMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public int findMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int min = heap[size / 2];
        for (int i = size / 2 + 1; i < size; i++) {
            if (heap[i] < min) min = heap[i];
        }
        return min;
    }

    public int findMaxRST() {
        int rightChild = rightChild(0);
        if (rightChild >= size) throw new IllegalStateException("No right subtree exists");
        return findMaxRec(rightChild);
    }

    public int findMinLST() {
        int leftChild = leftChild(0);
        if (leftChild >= size) throw new IllegalStateException("No left subtree exists");
        return findMinRec(leftChild);
    }

    private int findMaxRec(int index) {
        int max = heap[index];
        if (leftChild(index) < size) max = Math.max(max, findMaxRec(leftChild(index)));
        if (rightChild(index) < size) max = Math.max(max, findMaxRec(rightChild(index)));
        return max;
    }

    private int findMinRec(int index) {
        int min = heap[index];
        if (leftChild(index) < size) min = Math.min(min, findMinRec(leftChild(index)));
        if (rightChild(index) < size) min = Math.min(min, findMinRec(rightChild(index)));
        return min;
    }

    public void printHeap() {
        System.out.println("Heap elements: " + Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        BinaryHeapTree maxHeap = new BinaryHeapTree(15);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete Max");
            System.out.println("3. Find Max");
            System.out.println("4. Find Min");
            System.out.println("5. Find Max in Right Subtree");
            System.out.println("6. Find Min in Left Subtree");
            System.out.println("7. Print Heap");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    maxHeap.insert(value);
                    break;

                case 2:
                    try {
                        System.out.println("Deleted Max: " + maxHeap.deleteMax());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Max value: " + maxHeap.findMax());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Min value: " + maxHeap.findMin());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Max in Right Subtree: " + maxHeap.findMaxRST());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Min in Left Subtree: " + maxHeap.findMinLST());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    maxHeap.printHeap();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
