package BinarySearchTrees;
import java.util.Scanner;
public class BinarySearchTree {
    class Node {
        int element;
        Node left, right;

        Node(int e, Node l, Node r) {
            element = e;
            left = l;
            right = r;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node insert(Node temp, int e) {
        if (temp != null) {
            if (e < temp.element) {
                temp.left = insert(temp.left, e);
            } else if (e > temp.element) {
                temp.right = insert(temp.right, e);
            }
        } else {
            Node n = new Node(e, null, null);
            temp = n;
        }
        return temp;
    }

    public boolean search(Node temp, int e) {
        if (temp != null) {
            if (e == temp.element) {
                return true;
            } else if (e < temp.element) {
                return search(temp.left, e);
            } else if (e > temp.element) {
                return search(temp.right, e);
            }
        }
        return false;
    }

    public int count(Node temp) {
        if (temp != null) {
            int x = count(temp.left);
            int y = count(temp.right);
            return x + y + 1;
        }
        return 0;
    }

    public int height(Node temp) {
        if (temp != null) {
            int x = height(temp.left);
            int y = height(temp.right);
            return Math.max(x, y) + 1;
        }
        return 0;
    }

    public Node findMin(Node temp) {
        if (temp != null) {
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        return null;
    }

    public Node findMax(Node temp) {
        if (temp != null) {
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        }
        return null;
    }

    public Node delete(Node temp, int e) {
        if (temp == null) {
            return null;
        }
        if (e < temp.element) {
            temp.left = delete(temp.left, e);
        } else if (e > temp.element) {
            temp.right = delete(temp.right, e);
        } else {
            if (temp.left == null) {
                return temp.right;
            } else if (temp.right == null) {
                return temp.left;
            }
            Node minRight = findMin(temp.right);
            temp.element = minRight.element;
            temp.right = delete(temp.right, minRight.element);
        }
        return temp;
    }

    public void preorder(Node temp) {
        if (temp != null) {
            System.out.print(temp.element + " ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }

    public void inorder(Node temp) {
        if (temp != null) {
            inorder(temp.left);
            System.out.print(temp.element + " ");
            inorder(temp.right);
        }
    }

    public void postorder(Node temp) {
        if (temp != null) {
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.element + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display (Inorder)");
            System.out.println("5. Display (Preorder)");
            System.out.println("6. Display (Postorder)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int elementToInsert = scanner.nextInt();
                    bst.root = bst.insert(bst.root, elementToInsert);
                    System.out.println("Element inserted.");
                    break;
                case 2:
                    System.out.print("Enter element to search: ");
                    int elementToSearch = scanner.nextInt();
                    boolean found = bst.search(bst.root, elementToSearch);
                    if (found) {
                        System.out.println("Element found in the tree.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter element to delete: ");
                    int elementToDelete = scanner.nextInt();
                    bst.root = bst.delete(bst.root, elementToDelete);
                    System.out.println("Element deleted (if it existed).");
                    break;
                case 4:
                    System.out.println("Inorder Traversal:");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Preorder Traversal:");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Postorder Traversal:");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
