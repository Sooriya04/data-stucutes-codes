package BinarySearchTrees;
public class BinarySearchTree {
    class Node{
        int element;
        Node left, right;

        public Node(int e, Node l, Node r){
            element = e;
            left = l;
            right = r;
        }
    }
    Node root;
    public BinarySearchTree(){
        root = null;
    }
    public Node insert(Node temp, int e){
        if(temp != null){
            if(e < temp.element){
                temp.left = insert(temp.left, e);
            }else if(e > temp.element){
                temp.right = insert(temp.right, e);
            }
        }else{
            Node n = new Node(e, null, null);
            temp = n;
        }
        return temp;
    }
    public boolean search(Node temp, int e){
        if(temp != null){
            if(e == temp.element){
                return true;
            }else if(e < temp.element){
                return search(temp.left, e);
            }else if(e > temp.element){
                return search(temp.right, e);
            }
        }
        return false;
    }
    public int count(Node temp){
        if(temp != null){
            int x = count(temp.left);
            int y = count(temp.right);
            return x + y + 1;
        }
        return 0;
    }
    public int Height(Node temp){
        if(temp != null){
            int x = Height(temp.left);
            int y = Height(temp.right);
            if(x  > y)
                return x + 1;
            else
                return y + 1;
        }
        return 0;
    }
    
    public Node findMin(Node temp){
        if(temp != null){
            while(temp.left != null){
                temp = temp.left;
            }
        }
        return temp;
    }
    public Node findMax(Node temp){
        if(temp!= null){
            while(temp.right != null){
                temp = temp.right;
            }
        }
        return temp;
    }
    public Node findMaxinLeft(Node temp){
        if(temp != null && temp.left != null){
            return findMax(temp.left);
        }
        return null;
    }
    public Node findMinRight(Node temp){
        if(temp != null && temp.right != null){
            return findMin(temp.right);
        }
        return null;
    }
    public void inorder(Node temp){
        if(temp != null){
            inorder(temp.left);
            System.out.print(temp.element + " ");
            inorder(temp.right);
        }
    }
    public void preorder(Node temp){
        if(temp != null){
            System.out.print(temp.element + " ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }
    public void postorder(Node temp){
        if(temp != null){
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.element+ " ");
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.root = bTree.insert(bTree.root, 52);
        bTree.root = bTree.insert(bTree.root, 8);
        bTree.root = bTree.insert(bTree.root, 15);
        bTree.root = bTree.insert(bTree.root, 4);
        bTree.root = bTree.insert(bTree.root, 9);
        bTree.root = bTree.insert(bTree.root, 18);
        System.out.print("Inoder Traversal : ");
        bTree.inorder(bTree.root);
        System.out.println("");
        System.out.print("Preorder Traversal : ");
        bTree.preorder(bTree.root);
        System.out.println("");
        System.out.print("Postorder Traversal : ");
        bTree.postorder(bTree.root);
        System.out.println("");
        System.out.println("No of nodes are " + bTree.count(bTree.root));
        System.out.println("Height of the binary search tree is " + bTree.Height(bTree.root) );
        System.out.println("Searching Result : "+ bTree.search(bTree.root, 15));
        System.out.println("The Maximum element is " + bTree.findMax(bTree.root).element);
        System.out.println("The Minimum element is " + bTree.findMin(bTree.root).element);
        Node maxLeft = bTree.findMaxinLeft(bTree.root);
        if(maxLeft == null){
            System.out.println("The Maximum element of left sub tree is not found");
        }else{
            System.out.println("The Maximum element of left sub tree is " + maxLeft.element);
        }
        Node minRight = bTree.findMinRight(bTree.root);
        if(minRight == null){
            System.out.print("The minimum element in the right subtree is not found");
        }else{
            System.out.println("The Minimum element of left sub tree is " + minRight.element);
        }
    }
}