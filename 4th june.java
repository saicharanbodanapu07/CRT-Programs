public class Recursions_Basic1_printRange {
    public static void printRange(int start, int end) {
        if (start > end)
            return;
        printRange(start + 1, end);
        System.out.println(start);
    }

    public static void main(String[] args) {
        printRange(1, 5);
    }
}
----------------------------------------------------------
public class Recursions_Basic2_factorial {
    public static void main(String[] args) {
        System.out.println(factorial(27));
    }

    public static int factorial(int num) {
        int result = 1;
        if (num == 1)
            return 1;
        result = num * factorial(num - 1);
        return result;
    }
}
----------------------------------------------------------------
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
---------------------------------------------------------
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
-----------------------------------------------------------
public class Recursions_Basic5_Fibonacci {
    public static void main(String[] args) {
        int num = 10;
        for (int i = 0; i <= num; i++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int num) {
        if (num <= 0)
            return 0;
        if (num == 1)
            return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
-----------------------------------------------------------------