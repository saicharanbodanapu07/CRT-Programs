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
