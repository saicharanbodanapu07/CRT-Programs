public class StackUsingLinkedLists {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
    }
}

class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {

    Node1 top;

    Stack() {
        this.top = null;
    }

    void push(int data) {
        Node1 newNode = new Node1(data);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {
        Node1 current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}