public class TextEditor {
    class Node {
        String line;
        Node next;

        public Node(String line) {
            this.line = line;
            this.next = null;
        }
    }
    Node head;
    int lineCount = 0;

    public void addLine(String line) { 
        Node newNode = new Node(line);
        lineCount++;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added line " + lineCount + ": " + line);
    }

    public void insertLine(int position, String line) {
        if (position < 1 || position > lineCount + 1) {
            System.out.println("Invalid position! Please enter a valid position.");
            return;
        }

        Node newNode = new Node(line);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        lineCount++;
        System.out.println("Inserted line at position " + position + ": " + line);
    }

    public void deleteLine(int position) {
        if (position < 1 || position > lineCount) {
            System.out.println("Invalid position! Please enter a valid position.");
            return;
        }

        if (position == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        lineCount--;
        System.out.println("Deleted line at position " + position);
    }

    public void displayDocument() {
        if (head == null) {
            System.out.println("The document is empty.");
            return;
        }
        Node temp = head;
        int lineNumber = 1;
        System.out.println("\n--- Document Content ---");
        while (temp != null) {
            System.out.println(lineNumber + ": " + temp.line);
            temp = temp.next;
            lineNumber++;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addLine("First line.");
        editor.addLine("Second line.");
        editor.addLine("Third line.");
        
        editor.displayDocument();
        
        editor.insertLine(2, "Line is inserted at position 2.");
        
        editor.deleteLine(4);
        
        editor.displayDocument();
    }
}
