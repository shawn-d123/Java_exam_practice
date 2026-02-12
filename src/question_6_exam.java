import java.util.Arrays;

public class question_6_exam {

    public static void main(String[] args) {
        double[] T = {14.5, 15.2, 16.0, 15.8, 17.1, 18.3, 19.0};
    }

    public static double[] PredictWeather(double[] T, int xdays) {

        // test  1
        if (T == null || T.length == 0) {
            double[] test1 = {-1.0};
            return test1;
        }
        // test 2
        if(xdays < 1 ){
            double[] test2 = {-2.0};
            return test2;
        }

        double total = 0;
        // step 1
        for (int i = 0; i < T.length; i++) {

            // test 3
            if (T[i] < -89.2 || T[i] > 56.7){
                double[] test3 = {-3.0};
                return test3;
            }
            // handle rest of values
            if(i > 0 && i < T.length-1){
                total += T[i + 1] - T[i];
            }

        }

        System.out.println("Total is: " + total);
        // step 2
        double[] P = new double[xdays];

        for (int i = 0; i < P.length; i++) {

            P[i] = T[T.length - 1] + (total * (i + 1) );
        }
        System.out.println("P is: " + Arrays.toString(P));

        return P;
    }
}
