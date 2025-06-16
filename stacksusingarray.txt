public class StackUsingArrays {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.display();

        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.display();

        System.out.println("Current size of the stack: " + stack.getSize());

        stack.clear();
        stack.display();
    }
}

class Stack {
    int[] stack;
    int size;
    int top;

    Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value + " to stack.");
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int value = stack[top--];
        System.out.println("Popped " + value + " from stack.");
        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stack[top];
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    void clear() {
        top = -1;
        System.out.println("Stack cleared.");
    }

    int getSize() {
        return top + 1;
    }
}