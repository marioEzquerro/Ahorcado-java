package Session_3_2;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(3));
    }




    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        return factorial(n-1) + factorial(n-2);
    }
}
