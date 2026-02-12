import java.util.Arrays;

public class question_6_exam {

    public static void main(String[] args) {
        double[] T = {14.5, 15.2, 16.0, 15.8, 17.1, 18.3, 19.0};
        System.out.println(Arrays.toString(PredictWeather(T, 7)));
    }

    public static double[] PredictWeather(double[] T, int xdays) {

        // test 1
        if (T == null || T.length == 0) {
            return new double[]{-1.0};
        }

        // test 2
        if (xdays < 1) {
            return new double[]{-2.0};
        }

        // test 3 (check all values first)
        for (int i = 0; i < T.length; i++) {
            if (T[i] < -89.2 || T[i] > 56.7) {
                return new double[]{-3.0};
            }
        }

        // step 1: sum consecutive differences
        double sumDifferences = 0.0;
        for (int i = 1; i < T.length; i++) {
            sumDifferences += (T[i] - T[i - 1]);
        }

        // average daily change
        double change = sumDifferences / (T.length - 1);

        // step 2: predict xdays into the future
        double[] P = new double[xdays];
        for (int i = 0; i < xdays; i++) {
            P[i] = T[T.length - 1] + (change * (i + 1));
        }

        return P;
    }
}