package Notes;


public class TwoDimensionalArrayDemo {
    public static double [][] fill (int rowCount, int columnCount, double value){
        double [][] result = new double [rowCount][columnCount];
        for(int rowIndex = 0; rowIndex < result.length; rowIndex++){
            for (int columnIndex = 0; columnIndex < result[rowIndex].length; columnIndex++){
                result[rowIndex][columnIndex] = value;
            }
        }
        return result;
    }

    public static void print(double [][] array) {
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array[rowIndex].length; columnIndex++) {
                System.out.println(array[rowIndex][columnIndex] + " ");

            }System.out.println();


        }
    }

    public static void main(String[] args) {
        double [][] matrix = new double[3][2];
        matrix[0][0] = 2.5;
        matrix[0][1] = 2.5;
        matrix[1][1] = 2.5;
        matrix[0][0] = 2.5;
        matrix[0][0] = 2.5;
        matrix[0][0] = 2.5;
        System.out.println(matrix);

    }
}
