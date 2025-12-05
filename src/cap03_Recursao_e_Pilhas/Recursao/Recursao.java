package cap03_Recursao_e_Pilhas.Recursao;

public class Recursao {

    public static int fatorialRecursivo(int n){
        if(n < 0) throw new IllegalArgumentException("It is not possible to calculate the factorial of a negative integer.");
        if(n == 0) return 1;

        if(n > 1){
            return n * fatorialRecursivo(n-1);
        }
        return n;
    }

    public static int fibonacciRecursivo(int n){
        if(n < 0) throw new IllegalArgumentException("It is not possible to calculate of a negative integer.");
        if (n == 0) return 0;
        if(n == 1) return 1;
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }


}
