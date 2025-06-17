import java.util.Stack;

public class Recursions_Basic4_ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int element = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, element);
    }

}
