import java.util.Arrays;

public class ExamThemePrep_Q1 {
    public static void main(String[] args) {
        System.out.println(calcExpressionA(5,-7.3,5.0));
        System.out.println(safeAverage(5,12,-5));
    }

    /*
     * Q1.1 calcExpressionA
     *
     * Write a method:
     *   public static double calcExpressionA(int a, double b, double c)
     *
     * Return:
     *   (a^2 + sqrt(|c|)) / (b + 1)
     *
     * Rules / exam traps:
     * - Use Math.pow, Math.sqrt, Math.abs.
     * - Ensure the division is done as double division (it should be anyway, but be careful).
     * - If (b + 1) == 0, return Double.NaN (avoid division by zero).
     *
     * Examples:
     * - calcExpressionA(10, 2.0, -9.0) -> (100 + 3) / 3 = 34.3333333333...
     * - calcExpressionA(5, -1.0, 4.0) -> denominator is 0 -> Double.NaN
     */
    public static double calcExpressionA(int a, double b, double c) {

        return(Math.pow(a,2) + Math.sqrt(Math.abs(c)) / ( b + 1));
    }

    // Return the average of the largest two numbers only (ignore the smallest).
    //Example: safeAverage(10, 2, 6) → average of 10 and 6 → 8.0
    public static double safeAverage(int x, int y, int z){

        // another way to solve it
        int smallest = x;

        if (y < smallest) {
            smallest = y;
        }
        if (z < smallest) {
            smallest = z;
        }

        int sumOfAll = x + y + z;
        int sumOfLargestTwo = sumOfAll - smallest;

        //return sumOfLargestTwo / 2.0;

        // solve using arrays .sort():
        int[] arr = {x,y,z};
        Arrays.sort(arr);
        double average = (arr[1] + arr[2]) / 2.0;

        // and sort using if statements or using the array method
        if( x < y && y < z){
            return( (y + z) / 2.0);
        }else if(y < x && x < z){
            return( (x + z) / 2.0);
        } else{
            return((y + x) / 2.0);
        }


      //return(average);

    }

}
