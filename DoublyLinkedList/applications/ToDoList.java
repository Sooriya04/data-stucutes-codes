public class ToDoList {
    class TaskNode {
        String task;
        TaskNode prev;
        TaskNode next;
    
        public TaskNode(String task) {
            this.task = task;
            this.prev = null;
            this.next = null;
        }
    }    
    private TaskNode head;
    private TaskNode tail;
    public void addTask(String task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Added task: " + task);
    }

    public void deleteTask(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position! No task deleted.");
            return;
        }

        TaskNode current = head;
        int index = 1;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position out of range. No task deleted.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        System.out.println("Deleted task at position " + position + ": " + current.task);
    }

    public void moveUp(int position) {
        if (position <= 1 || head == null) {
            System.out.println("Cannot move up. Position is already at the top or invalid.");
            return;
        }

        TaskNode current = head;
        int index = 1;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null || current.prev == null) {
            System.out.println("Cannot move up. Position is invalid.");
            return;
        }

        TaskNode previous = current.prev;

        if (previous.prev != null) {
            previous.prev.next = current;
        } else {
            head = current;
        }
        if (current.next != null) {
            current.next.prev = previous;
        } else {
            tail = previous;
        }

        current.prev = previous.prev;
        previous.next = current.next;
        current.next = previous;
        previous.prev = current;

        System.out.println("Moved up task at position " + position + ": " + current.task);
    }

    public void moveDown(int position) {
        TaskNode current = head;
        int index = 1;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            System.out.println("Cannot move down. Position is at the bottom or invalid.");
            return;
        }

        TaskNode next = current.next;

        if (current.prev != null) {
            current.prev.next = next;
        } else {
            head = next;
        }
        if (next.next != null) {
            next.next.prev = current;
        } else {
            tail = current;
        }

        current.next = next.next;
        next.prev = current.prev;
        next.next = current;
        current.prev = next;

        System.out.println("Moved down task at position " + position + ": " + current.task);
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        TaskNode temp = head;
        int position = 1;
        System.out.println("\n--- To-Do List ---");
        while (temp != null) {
            System.out.println(position + ": " + temp.task);
            temp = temp.next;
            position++;
        }
        System.out.println("-------------------\n");
    }

    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();

        toDoList.addTask("Complete assignment");

        toDoList.addTask("Wakeup at 6 AM");

        toDoList.addTask("Go for a walk");
        
        toDoList.addTask("Buy groceries");

        toDoList.displayTasks();

        toDoList.moveUp(2);

        toDoList.displayTasks();

        toDoList.moveDown(1);

        toDoList.displayTasks();

        toDoList.deleteTask(2);

        toDoList.displayTasks();
    }
}
