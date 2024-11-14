package Expirements.stack.Applications;
import java.util.Scanner;
class CustomStack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public CustomStack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full.");
        }
    }
    public char pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty.");
            return '\0';
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class StringReverser {
    public static String reverseString(String input) {
        int length = input.length();
        CustomStack stack = new CustomStack(length);
        for (int i = 0; i < length; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}
