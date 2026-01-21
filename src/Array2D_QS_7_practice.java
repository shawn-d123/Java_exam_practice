import java.util.Arrays;

public class Array2D_QS_7_practice {

    public static void main(String[] args){

        // qs1
        int[][] data = {
                { 4, 1, 9, -2 },
                {},
                null,
                { 10 },
                { 3, 3, 3, 3, 3 },
                { -5, -1, -9 }
        };

        //qs 2
        int[][] values = {
                { 2, 4, 6, 8 },
                null,
                { 5, 5, 5 },
                {},
                { -3, 0, 3, 6 }
        };

        // final qs 1
        int[][] matrix = {
                {2, 4, 6},
                null,
                {5, 5, 5},
                {},
                {-3, 0, 3, 6}
        };

        // qs 1
        System.out.println(Arrays.deepToString(rowStats(data)) + "   this is qs 1");

        // qs 2
        System.out.println(Arrays.deepToString(normaliseRows(values))+ "   this is qs 2");

        // finsla qs today
        System.out.println(Arrays.deepToString(standardiseRows(matrix))+ "   this is final qs 1");

    }


    /*
QUESTION 1 – Processing Rows of a 2D Array

You are given a 2D integer array called data.
Each row in data may be:
- valid
- empty
- null

Example input:
int[][] data = {
    { 4, 1, 9, -2 },
    {},
    null,
    { 10 },
    { 3, 3, 3, 3, 3 },
    { -5, -1, -9 }
};

TASK:
Write a static method with the prototype:

    public static double[][] rowStats(int[][] data)

OUTPUT:
Return a 2D double array called stats with:
- the SAME number of rows as data
- EXACTLY 3 columns in each row

COLUMN MEANING:
- stats[i][0] → sum of values in row i
- stats[i][1] → average of values in row i
- stats[i][2] → standard deviation of values in row i

ROW VALIDITY RULES:
- If data[i] == null:
    -> stats[i] must be {NaN, NaN, NaN}
- Else if data[i].length == 0:
    -> stats[i] must be {NaN, NaN, NaN}
- Else:
    -> calculate sum, average, and standard deviation

STANDARD DEVIATION:
Use POPULATION standard deviation:

    σ = sqrt( (1/n) * Σ(x - mean)² )

Where:
- n = number of elements in the row
- mean = average of the row
*/
    public static double[][] rowStats(int[][] data){

        // initialise the 2D array
        // here a new double 2D array has a set size of same amount of rows(i) as data and 3 coloums(j)
        double[][] stats = new double[data.length][3];

        // looping through each row(i == rows)
        for(int i = 0; i < data.length; i++){

            // check if the row is valid
            // if it is not valid we set the row in stats as {NaN, NaN, NaN}
            if(data[i] == null || data[i].length == 0){
                stats[i][0] = Double.NaN;
                stats[i][1] = Double.NaN;
                stats[i][2] = Double.NaN;
            } // now we calculate and add the value to the j
            else{
                // the sum of row
                double sum = 0;
                for( int j = 0; j < data[i].length; j++){
                    sum += data[i][j];
                }
                stats[i][0] = sum;

                // calculate average and place it in output
                double average = sum / data[i].length;
                stats[i][1] = average;

                // calculate the varience
                double variancetotal = 0;
                for( int j = 0; j < data[i].length; j++){
                    variancetotal += Math.pow(data[i][j] - average, 2);
                }
                double variance =  variancetotal / data[i].length;

                // add the square root of variance to the output
                double sd = Math.sqrt(variance);
                stats[i][2] = sd;
            }
        }
        return(stats);
    }





    /*
    QUESTION 2 – Normalising Rows of a 2D Array

    You are given a 2D integer array called data.
    Each row in data may be:
    - valid
    - empty
    - null

    Example input:
    int[][] data = {
        { 2, 4, 6, 8 },
        null,
        { 5, 5, 5 },
        {},
        { -3, 0, 3, 6 }
    };

    TASK:
    Write a static method with the prototype:

        public static double[][] normaliseRows(int[][] data)

    NORMALISATION RULE:
    For each valid row, convert each value using:

        x' = (x - min) / (max - min)

    Where:
    - min is the smallest value in the row
    - max is the largest value in the row

    OUTPUT RULES:
    - The returned array must have the SAME number of rows as data
    - For each row i:
        - If data[i] == null:
            -> result[i] must be null
        - Else if data[i].length == 0:
            -> result[i] must be an empty double array (new double[0])
        - Else (valid row):
            -> result[i] must be a new double array of length data[i].length
            -> fill it with normalised values

    SPECIAL CASE:
    - If max == min (e.g. {5,5,5}):
        -> all values in the output row must be 0.0
    */

    public static double[][] normaliseRows(int[][] values){

        double[][] result = new double[values.length][];

        for(int row = 0; row < values.length; row++){

            // check if valid
            if(values[row] == null ){
                result[row] = null;
            }else if(values[row].length == 0){
                result[row] = new double[0];
            }else{

                //int min = Arrays.stream(values[row]).min().getAsInt();
                //int max = Arrays.stream(values[row]).max().getAsInt();

                // we can do it the normal way using for loops
                int min = values[row][0];
                int max = values[row][0];

                for(int col = 0; col < values[row].length; col++){
                    if(values[row][col] < min){
                        min = values[row][col];
                    }
                    if(values[row][col] > max){
                        max = values[row][col];
                    }
                }
                result[row] = new double[values[row].length];
                if(min == max){
                    for(int col = 0; col < values[row].length; col++){
                        result[row][col] = 0.0;
                    }
                }else{
                    for(int col = 0; col < values[row].length; col++){
                        result[row][col] = (values[row][col] - min) / (double)(max - min);
                    }
                }
            }
        }
        return(result);
    }

    /*
 QUESTION 7 – Standardising Rows of a 2D Array

 You are given a 2D integer array called data.
 Each row in data may be:
 - valid
 - empty
 - null

 TASK:
 Write a static method with the prototype:

     public static double[][] standardiseRows(int[][] data)

 STANDARDISATION RULE:
 For each valid row, convert each value using:

     z = (x - mean) / range

 Where:
 - mean is the average of the row
 - range = max - min

 OUTPUT RULES:
 - The returned array must have the SAME number of rows as data
 - If data is null -> return null
 - If data[i] == null -> result[i] must be null
 - If data[i].length == 0 -> result[i] must be new double[0]

 SPECIAL CASES:
 - If range == 0:
     -> all values in that row must be 0.0

 EXAMPLE:
 Input row: {2, 4, 6}
 mean = 4, min = 2, max = 6, range = 4
 Output row: {-0.5, 0.0, 0.5}
*/
    public static double[][] standardiseRows(int[][] data){

        if(data == null){
            return null;
        }

        double[][] result = new double[data.length][];

        for(int row = 0; row < data.length; row++){
            if(data[row] == null){
                result[row] = null;
            }
            else if(data[row].length == 0){
                result[row] = new double[0];
            }
            else{
                ///  have to create coloums in the rows
                // CREATE output row (this was missing)
                result[row] = new double[data[row].length]; // inner array same length as the inner array of data

                // loop through inner array to find, sum, max, min
                double min = data[row][0];
                double max = data[row][0];
                double sum = 0;
                for(int col = 0; col < data[row].length; col++){
                    // check for min
                    if(data[row][col] < min){
                        min = data[row][col];
                        // find max
                    }else if (data[row][col] > max){
                        max = data[row][col];
                    }
                    // get sum
                    sum += data[row][col];
                }
                double mean = sum / data[row].length;
                double range = max - min;
                // calculate each value
                if(range  != 0){
                    for(int col = 0; col < data[row].length; col++){
                        result[row][col] = (data[row][col] - mean) / range;
                    }
                }else{
                    for(int col = 0; col < data[row].length; col++){
                        result[row][col] = 0.0;
                    }
                }

            }
        }

    return(result);
    }


}
