import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(Hello("jack", "james", 47));
        double[] Temps = new double[]{14.5,15.2,16.0,15.8,17.1,18.3,19.0};
        System.out.println(Arrays.toString(PredictWeather1(Temps, 5)));

        System.out.println(MakeSequence(7,9));


    }
    public static String Hello(String forename, String surname, int age) {
        String result = "Hello " + forename + " " + surname + " are you " + age + " " + "years old?";
        return result;
    }

    public static double B(double w, double h) {
        if (w <= 0 || h <= 0) {
            return -1;
        }else{return (h/((w*w)));}

    }

    public static int ValidPoints(int x1, int y1, int x2, int y2) {
        boolean x1in = false;
        boolean y1in = false;
        boolean x2in = false;
        boolean y2in = false;

        if( x1 <= 100 && x1 >= -100){
        x1in = true;
        }
        if( x2 <= 100 && x2 >= -100){
            x2in = true;
        }
        if( y1 <= 100 && y1 >= -100){
            y1in = true;
        }
        if( y2 <= 100 && y2 >= -100){
            y2in = true;
        }

        if( x1in && y1in && x2in && y2in){
            return 1;
        } else if (x1in && y1in) {
            return 2;
        }else if (x2in && y2in) {
            return 3;
        }else{
            return 4;
        }
    }

    public static double KineticEnergy(double m, double v) {
        if(m <0 || v < 0){
            return -1;
        }
        else{
            return (0.5*m*(Math.pow(v,2)));
        }
    }

    // question 7
    public static double[] PredictWeather(double[] T, int xdays) {

        // if null or empty
        if(T == null || T.length == 0){
            return (new double[]{-1.0});
        }
        // if xdays less than 1
        if(xdays < 1){
            return(new  double[]{-2.0});
        }
        boolean isvalid = true;

        // check for invalid temp in arr
        for(int i = 0; i < T.length; i++){
            if(T[i] < -89.2 || T[i] > 56.7){
            return(new  double[]{-3.0});
            }
        }

        double totalChange = 0.0;
        // loop to calc change
        for(int i = 0; i < T.length - 1; i++){
            totalChange += (T[i + 1] -  T[i]);
        }
        double averagechange = totalChange / T.length -1;

        int xdays1 = xdays;

        double[] arr = new double[5];

        for(int i = 0; i < arr.length ; i++){
            arr[i] = T[T.length -1] + (averagechange * (i +1));
        }

        return arr;

    }
    public static double[] PredictWeather1(double[] T, int xdays) {

        // if null or empty
        if (T == null || T.length == 0) {
            return new double[] { -1.0 };
        }

        // if xdays less than 1
        if (xdays < 1) {
            return new double[] { -2.0 };
        }

        // check for invalid temps in arr
        for (int i = 0; i < T.length; i++) {
            if (T[i] < -89.2 || T[i] > 56.7) {
                return new double[] { -3.0 };
            }
        }

        // if only 1 day given, assume no change
        double averageChange = 0.0;

        if (T.length > 1) {
            double totalChange = 0.0;

            // loop to calc change
            for (int i = 0; i < T.length - 1; i++) {
                totalChange += (T[i + 1] - T[i]);
            }

            // average daily change across (T.length - 1) gaps
            averageChange = totalChange / (T.length - 1);
        }

        double[] predictions = new double[xdays];

        for (int i = 0; i < predictions.length; i++) {
            predictions[i] = T[T.length - 1] + (averageChange * (i + 1));
        }

        return predictions;
    }

    public static String MakeSequence(int S, int N) {

        String S1 = String.valueOf(S);
        String N1 = String.valueOf(N);
        try{
            int a = Integer.parseInt(S1);
            int b = Integer.parseInt(N1);
        } catch (Exception e) {
            return "ERROR#1";
        }
        if(N < S){
            return "ERROR#2";
        }

        String result = "";
        for(int i = S; i <= N; i++){
            int value = i * i;
            if (result == "") {
                result += value;
            }else{
            result +=  " " + value;
            }
        }
        return result;
    }


    public static String MakeSequence1(int S, int N) {

        if(S < 0 || N < 0){
            return "ERROR#1";
        }
        if(N < S){
            return "ERROR#2";
        }

        String result = "";
        for(int i = S; i <= N; i++){
            int value = i * i;
            if (result == "") {
                result += value;
            }else{
                result +=  " " + value;
            }
        }
        return result;
    }



}
