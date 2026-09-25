package Notes;

public class Lecture_16_09_26 {

    /**
     * This method computes 1/2 of the given input
     *
     * @param input - The given input
     * @return
     */
    public static double half(double input){
        return input/2.0;
    }
    public static double calculateArea(double radius){
        double pi = 3.14;
        return pi *radius * radius;
    }




    public static void main(String[] args) {
        double halved = half(10.5);
        System.out.println(halved);
        
        System.out.println(calculateArea(7.8));
        double radius = 0;
        System.out.println(calculateArea(radius));
        double pi = 0;
        System.out.println(pi + "\n");



    }

}
