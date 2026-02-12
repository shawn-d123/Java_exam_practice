public class question_6_exam {

    public static void main(String[] args) {
        double[] T = {14.5, 15.2, 16.0, 15.8, 17.1, 18.3, 19.0};
    }

    public static double[] PredictWeather(double[] T, int xdays) {

        double total = 0;
        // step 1
        for (int i = 0; i < T.length; i++) {

            // handle rest of values
            if(i > 0 && i < T.length-1){
                total += T[i + 1] - T[i];
            }

        }

        System.out.println("Total is: " + total);
        // step 2
        double[] P = new double[xdays];

        for (int i = 0; i < P.length; i++) {

        }

        return T;
    }
}
