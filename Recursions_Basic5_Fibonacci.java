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
