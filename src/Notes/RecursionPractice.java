package Notes;

public class RecursionPractice {
    public static int factorialLoop(int n){
        if(n>0){
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i = 2; i<= n; i++){
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive( int n){
        if(n<0){
            throw new IllegalArgumentException();
        }
        if(n<=1){
            return 1;
        }
        return factorialRecursive(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println("5! is " + factorialLoop(5));
        System.out.println("5! is " + factorialRecursive(5));
    }
}
