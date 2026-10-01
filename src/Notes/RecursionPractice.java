package Notes;

public class RecursionPractice {
    public static int power(int base, int exponent){
        if(exponent < 0){
            throw new IllegalArgumentException();
        }
        return powerRecursive(base,exponent);
    }

    private static int powerRecursive(int base, int exponent){
        if(exponent == 0) {
            return 1;
        }
        return powerRecursive(base, exponent-1) * base;
    }
}
