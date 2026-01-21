import java.util.Arrays;

public class ExamThemePrep_Q5 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rowStats(new int[][]{{1, 2, 3}, null, {}, {-5, 10}})));
        System.out.println(Arrays.deepToString(safeParse2D(new String[][]{
                {"abc", "12x", "5"},
                {"@", "?", " 9 "}
        })));
        System.out.println(Arrays.toString(coordinatesDistance(new int[][]{
                {0, 0, 6, 8, 1, 1},
                null,
                {1, 2, 3, 4}
        })));
        System.out.println(numberPyramid1(5));
    }


    /*
    Q5 — 2D arrays + invalid rows + parsing + try/catch + methods (big one)
    Q5.1 rowStats

    Write:

    public static double[][] rowStats(int[][] data)


    Return a 2D double array with shape [data.length][3].

    For each row i, compute:

    col 0: sum of the row

    col 1: mean of the row

    col 2: max of the row

    Invalid row rules:

    if data[i] == null OR data[i].length == 0
    set all 3 outputs to Double.NaN
     */

    public static double[][] rowStats(int[][] data){
        double[][] result = new double[data.length][3];
        for(int row = 0; row < data.length; row++){
            if (data[row] == null || data[row].length == 0){
                result[row][0] = Double.NaN;
                result[row][1] = Double.NaN;
                result[row][2] = Double.NaN;
            }
            else{
                int total = 0;
                int max = data[row][0];
                for(int col = 0; col < data[row].length; col++){
                    total += data[row][col];
                    if (max < data[row][col]){
                        max = data[row][col];
                    }
                }
                result[row][0] = total;
                result[row][1] = total / (double)data[row].length;
                result[row][2] = max;
            }
        }
        return result;
    }

    /*
     * Q5.2 safeParse2D
     *
     * Write:
     *   public static int[][] safeParse2D(String[][] text)
     *
     * Convert a 2D String array into a 2D int array of the SAME shape.
     *
     * Rules:
     * - If text is null -> return null // coloum
     * - If a row is null -> output row should be null (keep it null) // subarrays
     * - For each cell:
     *     - trim spaces
     *     - if null or empty after trim -> store 0
     *     - if not a valid int -> store 0
     *     - else store parsed value
     *
     * Extra exam readiness:
     * - Must use try/catch for parsing (NumberFormatException)
     * - Use Integer.parseInt (not Double)
     */

    public static int[][] safeParse2D(String[][] text) {

        if  (text == null){
            return null;
        }
        // here we initialised a 2D array but we dont know the size of the inner array
        int[][] result = new int[text.length][]; // so we set it as []

        for(int row = 0; row < text.length; row++){

            if  (text[row] == null){
                result[row] = null;
            }else{

                // since the row is not null
                // we create the coloums for the row, ie the inner array
                result[row] = new int[text[row].length]; // made same number of coloums as the input

                for(int col = 0; col < text[row].length; col++){

                    int value = 0;

                    if(text[row][col] != null){
                        String trimmed = text[row][col].trim();
                        if ( trimmed.length() != 0 ){

                            try{
                                value = Integer.parseInt(trimmed);
                            }catch (Exception e){
                                value = 0;
                            }

                        }
                    }
                result[row][col] = value;
                }
            }
        }
        return result;
    }
    /*
     * Q5.3 coordinatesDistance
     *
     * Write:
     *   public static double[] coordinatesDistance(int[][] coordinates)
     *
     * Each VALID row must have length 6:
     *   {x1, y1, x2, y2, x3, y3}
     *
     * For each row, return the distance from (x1,y1) to (x2,y2):
     *   d = sqrt((x2-x1)^2 + (y2-y1)^2)
     *
     * Rules:
     * - If coordinates is null -> return null
     * - For invalid rows (null or length != 6) -> Double.NaN at that index
     * - Return array length must equal coordinates.length
     *
     * Extra exam readiness:
     * - Use Math.pow OR manual squaring (both OK)
     * - Be careful with int overflow when squaring: cast to double before squaring
     */
    public static double[] coordinatesDistance(int[][] coordinates) {

        double[] result = new double[coordinates.length];

        for(int row = 0; row < coordinates.length; row++){

            double distance = 0;
            // check if row is valid
            if(coordinates[row] == null || coordinates[row].length != 6){
                result[row] = Double.NaN;
            }
            else{
                int x1 = coordinates[row][0];
                int y1 = coordinates[row][1];
                int x2 = coordinates[row][2];
                int y2 = coordinates[row][3];

                distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
            }
            result[row] = distance;
        }

        return result;
    }
    /*
 QUESTION 5 – Number Pyramid

     Write a method:
         public static String numberPyramid(int n)

     OUTPUT:
     For n = 4, return:
     "1
      22
      333
      4444"

     RULES:
     - Each line i contains digit i repeated i times
     - Lines separated by newline '\n'
     - If n <= 0 -> return ""
    */
    public static String numberPyramid(int n) {

        // If n is 0 or negative, return empty string
        if (n <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Loop through each line
        for (int i = 1; i <= n; i++) {

            // Repeat digit i, i times
            for (int j = 0; j < i; j++) {
                result.append(i);
            }

            // Add newline after each line except the last
            if (i < n) {
                result.append('\n');
            }
        }

        return result.toString();
    }

    ///  you can also do it without string builder: ///
/*
    public static String numberPyramid(int n) {

        // Handle invalid input
        if (n <= 0) {
            return "";
        }

        String result = "";

        // Build each line
        for (int i = 1; i <= n; i++) {

            // Repeat digit i, i times
            for (int j = 0; j < i; j++) {
                result = result + i;
            }

            // New line after each line except the last
            if (i < n) {
                result = result + '\n';
            }
        }

        return result;
    }
    */

    public static String numberPyramid1(int n){
        String result = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result += i;
            }
            result += '\n';
        }
        return result;
    }


}
