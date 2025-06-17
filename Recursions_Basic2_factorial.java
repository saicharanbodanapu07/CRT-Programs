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
