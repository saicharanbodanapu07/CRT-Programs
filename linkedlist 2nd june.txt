public class ClassLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertBig(55);
        list.insertPos(15, 2);
        list.display();
        int[] arr = { 10, 20, 30, 40 };
        Node head = LinkedList.arrayToList(arr);
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertBig(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertPos(int data, int pos) {
        if (pos > 0 && pos <= length()) {
            Node newNode = new Node(data);
            if (pos == 0) {
                insertBig(data);
                return;
            } else if (pos == length()) {
                insertEnd(data);
                return;
            } else if (head == null) {
                System.out.println("List is empty, inserting at the beginning");
                head = newNode;
                return;
            }
            Node current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Invalid position");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int deleteBeg() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from beginning.");
            return -1;
        }
        int deletedData = head.data;
        head = head.next;
        return deletedData;
    }

    public int deleteEnd() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from end.");
            return -1;
        }
        int deletedData;
        if (head.next == null) {
            deletedData = head.data;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            deletedData = current.next.data;
            current.next = null;
        }
        return deletedData;
    }

    public int deleteAtPos(int pos) {
        int len = length();
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return -1;
        }
        if (pos < 0 || pos >= len) {
            System.out.println(
                    "Invalid position. Position should be between 0 and " + (len - 1) + " (inclusive). Got: " + pos);
            return -1;
        }
        if (pos == 0) {
            return deleteBeg();
        }
        if (pos == length() - 1) {
            return deleteEnd();
        }
        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        int deletedData = current.next.data;
        current.next = current.next.next;
        return deletedData;
    }

    public void deleteAll() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    static Node arrayToList(int[] arr) {
        LinkedList list = new LinkedList();
        for (int value : arr) {
            list.insertEnd(value);
        }
        return list.head;
    }

    static int[] listToArray(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int[] arr = new int[length];
        current = head;
        for (int i = 0; i < length; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }
}