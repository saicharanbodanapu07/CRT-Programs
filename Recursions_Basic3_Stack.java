import java.util.Stack;

public class Recursions_Basic3_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        pushBottom(stack, 40);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    public static void pushBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int val = stack.pop();
        pushBottom(stack, element);
        stack.push(val);
    }
}