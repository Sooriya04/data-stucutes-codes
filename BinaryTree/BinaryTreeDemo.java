package Expirements.BinaryTree;
import java.util.Scanner;
class BinaryTree {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert node
    public void insertNode(int data) {
        root = insertNodeRec(root, data);
    }
    private Node insertNodeRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertNodeRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertNodeRec(root.right, data);
        }
        return root;
    }
    //delete the node
    public void deleteNode(int data) {
        root = deleteNodeRec(root, data);
    }
    private Node deleteNodeRec(Node root, int data) {
        if (root == null) 
            return root;

        if (data < root.data) {
            root.left = deleteNodeRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNodeRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = findMinRec(root.right).data;

            root.right = deleteNodeRec(root.right, root.data);
        }
        return root;
    }
    //find minimum
    public Node findMin() {
        return findMinRec(root);
    }

    private Node findMinRec(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    //find Maximum
    public Node findMax() {
        return findMaxRec(root);
    }

    private Node findMaxRec(Node root) {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public Node findMaxLST() {
        if (root != null && root.left != null) {
            return findMaxRec(root.left);
        }
        return null;
    }
    public Node findMinRST() {
        if (root != null && root.right != null) {
            return findMinRec(root.right);
        }
        return null;
    }
    //Display 
    private void displayTreeRec(Node node, int space) {
        if (node == null) {
            return;
        }
        space += 5;
        displayTreeRec(node.right, space);
        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" "); 
        }
        System.out.println(node.data);
        displayTreeRec(node.left, space);
    }
    
    public void displayTree() {
        displayTreeRec(root, 0);
    }
    
}
public class BinaryTreeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        while (true) {
            System.out.println("\n--- Binary Tree Operations ---");
            System.out.println("1. Insert Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Find Max");
            System.out.println("4. Find Min");
            System.out.println("5. Find Max LST");
            System.out.println("6. Find Min RST");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int insertValue = scanner.nextInt();
                    tree.insertNode(insertValue);
                    break;
                case 2:
                    System.out.print("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    tree.deleteNode(deleteValue);
                    break;
                case 3:
                    BinaryTree.Node maxNode = tree.findMax();
                    System.out.println("Maximum value: " + (maxNode != null ? maxNode.data : "Tree is empty"));
                    break;
                case 4:
                    BinaryTree.Node minNode = tree.findMin();
                    System.out.println("Minimum value: " + (minNode != null ? minNode.data : "Tree is empty"));
                    break;
                case 5:
                    BinaryTree.Node maxLSTNode = tree.findMaxLST();
                    System.out.println("Max in Left Subtree: " + (maxLSTNode != null ? maxLSTNode.data : "No left subtree"));
                    break;
                case 6:
                    BinaryTree.Node minRSTNode = tree.findMinRST();
                    System.out.println("Min in Right Subtree: " + (minRSTNode != null ? minRSTNode.data : "No right subtree"));
                    break;
                case 7:
                    System.out.println("Tree : ");
                    tree.displayTree();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
//50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85