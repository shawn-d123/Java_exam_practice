import java.util.ArrayList;
import java.util.Arrays;

public class ExamThemePrep_Q6 {
    public static void main(String[] args) {

        System.out.println("Q1 answer is: " + compressRuns("aaabbccccd"));
        System.out.println("Q2 answer is: " + Arrays.toString(rotateRight(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3)));
        System.out.println();
        System.out.println("real qs 6.1: " + classifyTemperatures(new String[]{"8", " 15 ", "30", "abc", null}));
        System.out.println("real qs 6.2: " + Arrays.toString(shiftVector(new int[]{1,2,3,4,5}, 2)));
    }


    /*
     * Q6.1 compressRuns
     *
     * Write:
     *   public static String compressRuns(String text)
     *
     * Replace consecutive repeated characters with:
     *   character + count
     *
     * Examples:
     * - "aaabbccccd" -> "a3b2c4d1"
     * - "A" -> "A1"
     *
     * Rules:
     * - If text is null -> return null
     * - If text is "" -> return ""
     * - Case-sensitive ('A' != 'a')
     *
     * Extra exam readiness:
     * - MUST use StringBuilder
     * - Count is an int -> append it properly
     */
    public static String compressRuns(String text) {

        ///  can use string builder instead of string
        StringBuilder result = new StringBuilder();

        //String result = "";

        if (text == null){
            return null;
        }else if (text.isEmpty()){
            return "";
        }

        int count = 1;
        char current = text.charAt(0);

        for (int i = 1; i < text.length(); i++){

            if (text.charAt(i) == current){
                count++;
            }else{
                //result += "" + current + count; // have to have the "" to make it a string concatination

                /// using string builder
                result.append(current);
                result.append(count);

                current = text.charAt(i);
                count = 1;
            }
        }

        //result += "" + current + count;
        // append the FINAL run
        result.append(current);
        result.append(count);

        ///  with string builder you need to convert back to string
        return result.toString();
    }

    /*
     * Q6.2 sumMixedNumbers
     *
     * Write:
     *   public static double sumMixedNumbers(String[] data)
     *
     * data contains things like:
     *   "12", "  7  ", "-3", "5.5", "NaN", null, "", "abc", "4.0"
     *
     * Return the SUM of all valid numbers, where:
     * - Try parse as int first (Integer.parseInt)
     * - If that fails, try parse as double (Double.parseDouble)
     * - If both fail -> ignore it (add nothing)
     *
     * Extra exam readiness:
     * - Must use try/catch (NumberFormatException)
     * - Trim strings before parsing
     * - If data is null -> return 0.0
     */
    public static double sumMixedNumbers(String[] data) {

        // If data is null -> return 0.0
        if (data == null) {
            return 0.0;
        }

        double sum = 0.0;

        // Loop through the array
        for (int i = 0; i < data.length; i++) {

            String value = data[i];

            // Ignore null entries
            if (value == null) {
                continue;
            }

            // Trim spaces
            value = value.trim();

            // Ignore empty strings
            if (value.isEmpty()) {
                continue;
            }

            // Try parse as int first
            try {
                sum += Integer.parseInt(value);
            } catch (NumberFormatException e1) {

                // If int parsing fails, try double
                try {
                    double d = Double.parseDouble(value);

                    // Ignore NaN explicitly
                    if (!Double.isNaN(d)) {
                        sum += d;
                    }

                } catch (NumberFormatException e2) {
                    // Ignore invalid values
                }
            }
        }

        return sum;
    }

    /*
     * Q6.3 rotateRight
     *
     * Write:
     *   public static int[] rotateRight(int[] data, int k)
     *
     * Return a NEW array where elements are rotated right by k.
     *
     * Example:
     * data = {10,20,30,40,50}, k=2 -> {40,50,10,20,30}
     *
     * Rules:
     * - If data is null -> return null
     * - If data.length == 0 -> return new int[0]
     * - k can be negative or > length
     * - Use math to normalise k:
     *     k = k % length; if (k < 0) k += length;
     *
     * Extra exam readiness:
     * - Avoid ArrayIndexOutOfBounds by using modulo indexing carefully
     */
    public static int[] rotateRight(int[] data, int k) {

        int[] result= new int[data.length];

        // normalising k
        k = k % data.length;
        if (k < 0){
            k += data.length;
        }

        if(data == null){
            return null;
        }
        else if(data.length == 0){
            return new int[0];
        }else {

            for (int i = 0; i < data.length; i++) {
                int move = (i + k)  % data.length; // modulo indexing
                result[move] = data[i];
            }

        }
        return result;
    }

    ///  ----- Realistic Questions ------///

    /*
     * Question 6 — classifyTemperatures
     *
     * You are given a String[] temperatures, where each element represents
     * a temperature reading in Celsius.
     *
     * Each value must be classified as:
     *   1 -> Cold     (temp < 10)
     *   2 -> Mild     (10 <= temp <= 25)
     *   3 -> Hot      (temp > 25)
     *
     * Invalid rules:
     * - If temperatures is null -> return null
     * - If an element is null, empty, or cannot be parsed as an integer -> add -1
     *
     * Parsing rules:
     * - Trim spaces before parsing
     * - Use Integer.parseInt
     *
     * Return:
     * - An ArrayList<Integer> of the same size as temperatures
     *
     * Example:
     * Input:  {"8", " 15 ", "30", "abc", null}
     * Output: [1, 2, 3, -1, -1]
     */
    public static ArrayList<Integer> classifyTemperatures(String[] temperatures) {

        ArrayList<Integer> result = new ArrayList<>();

        // check if temps are null
        if  (temperatures == null) {
            return null;
        }
        for (int i = 0; i < temperatures.length; i++) {

            // is element empty
            if(temperatures[i] == null || temperatures[i].isEmpty()) {
                result.add(-1);

            } // element not empty
            else{
                String trimmed = temperatures[i].trim();
                try{
                    int value = Integer.parseInt(trimmed);
                    // classify
                    if(value < 10){ // cold
                        result.add(1);
                    }else if( 10 <= value && value <= 25){ // mild
                        result.add(2);
                    }else{ // hot
                        result.add(3);
                    }
                }catch(Exception e){
                    result.add(-1);
                }
            }
        }
        return result;
    }

    /*
     * Question 6 — shiftVector
     *
     * You are given an int[] vector and an integer shift.
     *
     * Return a NEW array where the elements are shifted LEFT by shift positions.
     *
     * Example:
     * vector = {1,2,3,4,5}, shift = 2
     * result = {3,4,5,1,2}
     *
     * Rules:
     * - If vector is null -> return null
     * - If vector.length == 0 -> return new int[0]
     * - shift may be negative or larger than vector.length
     *
     * Normalisation rule:
     *   shift = shift % vector.length
     *   if (shift < 0) shift += vector.length
     *
     * Extra exam readiness:
     * - Must avoid ArrayIndexOutOfBoundsException
     * - Must not modify the original array
     */
    public static int[] shiftVector(int[] vector, int shift) {

        int[] result = new int[vector.length];

        // validate input
        if (vector == null) {
            return null;
        }
        if (vector.length == 0) {
            return new int[0];
        }

        shift = shift % vector.length;
        if (shift < 0) {
            shift += vector.length;
        }

        for(int i = 0; i < vector.length; i++){
            int move = (i - shift) % vector.length;
            if(move <0){
                move += vector.length;
            }
            result[move] = vector[i];
        }

        return result;
    }


}
