import java.util.Arrays;
import java.util.ArrayList;

public class ExamThemePrep_Q4 {
    public static void main(String[] args){

        System.out.println("Q1 answer is: " + Arrays.toString(reverseAll(new String[]{"hello", "jello", "kello", null, "fello"})));
        System.out.println("Q2 answer is: " + filterValidInts(new String[]{"55", null, " ", "", "NaN", "-91", " 12 "}));
        System.out.println("Q3 answer is: " + middleStats(new int[]{35,7,8,90,11,5}));
    }

    /*
    Q4 — Arrays + ArrayLists + built-in methods
    Q4.1 reverseAll

    Write:

    public static String[] reverseAll(String[] data)

    Return a new array where each string is reversed.

    Rules:

    If element is null, output null at that position.

    If input array is null, return null.

    Example:

    {"hi", null, "abc"} → {"ih", null, "cba"}
     */
    public static String[] reverseAll(String[] data){

        String[] result  = new String[data.length];

        // iterate through arr
        for(int i = 0; i < data.length; i++){
            // check if string in array is valid
            if(data[i] == null){
                result[i] = null;
            }else{
                String value = "";
                // loop through string in reverse order
                for(int j = data[i].length() -1; j >= 0 ; j--){
                    value += data[i].charAt(j);
                }
                // add new string to new arr
                result[i] = value;
            }

        }
        return result;
    }

    /*
    Q4.2 filterValidInts

    Write:

    public static ArrayList<Integer> filterValidInts(String[] data)


    Convert each entry to an int (trim spaces).

    Add valid ints to the output list.

    Skip invalid values (including null, " ", "", "NaN", "55.3", "abc").

    Example input:
    {"55", null, " ", "", "NaN", "-91", " 12 "} → output [55, -91, 12]
     */
    public static ArrayList<Integer> filterValidInts(String[] data){

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            try{
                String value = "";
                // use the .trim() method to remove trailing spaces
                value = data[i].trim();
                result.add(Integer.parseInt(value));
            }catch (Exception e){
                // do nothing
            }
        }
        return result;
    }

    /*
    Q4.3 middleStats

    Write:

    public static double middleStats(int[] data)


    Return the mean of the array excluding the first and last elements.

    Rules:

    If data is null or length < 3 return Double.NaN.
     */

    public static double middleStats(int[] data){
        double total = 0;
        if(data.length < 3){
            return(Double.NaN);
        }
        for(int i = 1; i < data.length - 1; i++){
            total += data[i];
        }
        return total / (double)data.length - 2;
    }

}
