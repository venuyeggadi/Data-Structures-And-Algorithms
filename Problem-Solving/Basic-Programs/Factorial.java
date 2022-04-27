import java.util.*;
class Factorial {
    static int loopFactorial(int n) {
        if(n <= 0)
            return 1;
        int fact = 1;
        for(int i = 2; i <= n; i++)
            fact *= i;

        return fact;
    }

    static int recursiveFactorial(int n) {
        if(n <= 1)
            return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        System.out.println( loopFactorial(num) );
        System.out.println( recursiveFactorial(num));
    }
}
