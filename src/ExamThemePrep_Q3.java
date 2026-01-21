import java.beans.PropertyEditorSupport;

public class ExamThemePrep_Q3 {
    public static void main(String[] args) {
        System.out.println("Q1 answer is: " + repeatBlocks(6));
        System.out.println("Q2 answer is: "+ patternPlusMinus(6));
        System.out.println("Q3 answer is: "+ countDivisible(15,-2,2));
    }

    /*
    Q3 -- One-dimensional loops + pattern generation --
    Q3.1 repeatBlocks

    Write:

    public static String repeatBlocks(int n)


    Generate blocks from 1 to n like:

    For n = 5 →
    "1 22 333 4444 55555"

    Rules:

    If n <= 0 return empty string ""

    Exactly one space between blocks, no trailing space.
     */
    public static String repeatBlocks(int n){

        if(n <= 0){
            return("");
        }

        String result = "";

        for(int i = 1; i <= n; i++){
            // loop again printing i
            for(int j = 0; j < i; j++){
                result += i;
            }
            // add a gap
            result += " ";

        }
        return(result);
    }

    /*
    Q3.2 patternPlusMinus

Write:

public static String patternPlusMinus(int blocks)


Create alternating blocks of + then -, increasing lengths:

For blocks = 4 → "+ -- +++ ----"? ❌ (not this)

Correct rule:

block 1: + repeated 1

block 2: - repeated 2

block 3: + repeated 3

block 4: - repeated 4

concatenate with no spaces

So blocks=4 → "+--+++----"

If blocks <= 0 → ""
     */
    public static String patternPlusMinus(int blocks){

        String result = "";
        for(int i = 0; i <= blocks; i++){
            for(int j = 0; j < i; j++){
                if(i % 2 == 0){
                    result += "-";
                }else{
                    result += "+";
                }
            }
        }
        return(result);
    }

    /*
    Q3.3 countDivisible

    Write:
    public static int countDivisible(int start, int end, int k)

    Count how many integers in [start, end] are divisible by k.

    Rules:

    If k == 0 return -1

    Works even if start > end (swap internally, or loop safely)
     */
    public static int countDivisible(int start, int end, int k){

        int result = 0;
        if( k == 0){
            return(-1);
        }
        if(end < start){
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start; i <= end; i++){
            if (i % k == 0){
                result ++;
            }
        }
        return(result);
    }

}
