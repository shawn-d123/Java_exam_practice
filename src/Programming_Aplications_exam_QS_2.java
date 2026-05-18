public class Programming_Aplications_exam_QS_2 {

    public static void main(String[] args)
    {
        System.out.println("===== Testing validWord =====");
        System.out.println("validWord(\"HELLO\") expected 0, got: " + validWord("HELLO"));
        System.out.println("validWord(\"DOG\") expected 0, got: " + validWord("DOG"));
        System.out.println("validWord(null) expected 1, got: " + validWord(null));
        System.out.println("validWord(\"\") expected 2, got: " + validWord(""));
        System.out.println("validWord(\"Dog\") expected 3, got: " + validWord("Dog"));
        System.out.println("validWord(\"DOG2\") expected 3, got: " + validWord("DOG2"));
        System.out.println("validWord(\"DOG \") expected 3, got: " + validWord("DOG "));

        System.out.println();

        System.out.println("===== Testing validWordV1 =====");
        System.out.println("validWordV1(\"HELLO\") expected true, got: " + validWordV1("HELLO"));
        System.out.println("validWordV1(\"DOG\") expected true, got: " + validWordV1("DOG"));
        System.out.println("validWordV1(null) expected false, got: " + validWordV1(null));
        System.out.println("validWordV1(\"\") expected false, got: " + validWordV1(""));
        System.out.println("validWordV1(\"Dog\") expected false, got: " + validWordV1("Dog"));
        System.out.println("validWordV1(\"DOG2\") expected false, got: " + validWordV1("DOG2"));
        System.out.println("validWordV1(\"DOG \") expected false, got: " + validWordV1("DOG "));

        System.out.println();

        System.out.println("===== Testing validWordV3 =====");
        System.out.println("validWordV3(\"HELLO\") expected 0, got: " + validWordV3("HELLO"));
        System.out.println("validWordV3(null) expected 1, got: " + validWordV3(null));
        System.out.println("validWordV3(\"\") expected 2, got: " + validWordV3(""));
        System.out.println("validWordV3(\"HELLo\") expected 3, got: " + validWordV3("HELLo"));
        System.out.println("validWordV3(\"DOG2\") expected 4, got: " + validWordV3("DOG2"));
        System.out.println("validWordV3(\"DOG!\") expected 5, got: " + validWordV3("DOG!"));
        System.out.println("validWordV3(\"DOG 2\") expected 5, got: " + validWordV3("DOG 2"));

        System.out.println();

        System.out.println("===== Testing validWordV4 =====");
        System.out.println("validWordV4(\"HELLO\") expected 0, got: " + validWordV4("HELLO"));
        System.out.println("validWordV4(null) expected -1, got: " + validWordV4(null));
        System.out.println("validWordV4(\"\") expected -2, got: " + validWordV4(""));
        System.out.println("validWordV4(\"HeLLO\") expected 1, got: " + validWordV4("HeLLO"));
        System.out.println("validWordV4(\"DOG2!\") expected 2, got: " + validWordV4("DOG2!"));
        System.out.println("validWordV4(\"d0g!\") expected 3, got: " + validWordV4("d0g!"));
    }

    public static int validSquare(char inputCharacter)
    {
        if( inputCharacter >= 'A' && inputCharacter <= 'Z'){
            return 0;
        }else{
            return 1;
        }
    }

    /*
     * Question 2 — Valid Word
     *
     * Write a method that checks whether a String is a valid game word.
     *
     * A valid word must:
     * - not be null
     * - not be empty
     * - contain only capital letters from 'A' to 'Z'
     *
     * Return:
     * 0 if the word is valid
     * 1 if the word is null
     * 2 if the word is empty
     * 3 if the word contains an invalid character
     */
    public static int validWord(String word)
    {
        if (word == null){
            return 1;
        }
        if(word.length() == 0){
            return 2;
        }
        for(int i = 0; i < word.length(); i++){

            if(validSquare(word.charAt(i)) == 1){
                return 3;
            }
            // below is the same logic that qs_1 does
            //if(word.charAt(i) < 'A' || word.charAt(i) > 'Z'){
            //
            // return 3;
            //}
        }
        return 0;
    }

    /*
     * Question 2 Variation — Valid Word Boolean
     *
     * Write a method that checks whether a String is a valid game word.
     *
     * A valid word must:
     * - not be null
     * - not be empty
     * - contain only capital letters from 'A' to 'Z'
     *
     * Return:
     * true if the word is valid
     * false if the word is invalid
     */
    public static boolean validWordV1(String word)
    {
        if (word == null || word.length() == 0){
            return false;
        }
        for(int i = 0; i < word.length(); i++){

            if(validSquare(word.charAt(i)) == 1){
                return false;
            }
        }
        return true;
    }


    /*
     * Question 2 Hard Variation — Detailed Invalid Word
     *
     * Write a method that checks a word and returns a different value
     * depending on the type of invalid character found first.
     *
     * Return:
     * 0 if the word is valid
     * 1 if the word is null
     * 2 if the word is empty
     * 3 if the first invalid character is a lowercase letter from 'a' to 'z'
     * 4 if the first invalid character is a digit from '0' to '9'
     * 5 if the first invalid character is anything else
     */
    public static int validWordV3(String word)
    {
        if(word == null){
            return 1;
        }
        if(word.length() == 0){
            return 2;
        }
        for(int i = 0; i < word.length(); i++){
            if (validSquareV3(word.charAt(i)) == 3){
                return 3;
            }
            if(validSquareV3(word.charAt(i)) == 4){
                return 4;
            }
            if(validSquareV3(word.charAt(i)) == 5){
                return 5;
            }
        }
        return 0;
    }

    public static int validSquareV3(char inputCharacter)
    {
        if( inputCharacter >= 'A' && inputCharacter <= 'Z'){
            return 0;
        }else{
            if(inputCharacter >= 'a' && inputCharacter <= 'z'){
                return 3;
            }
            if(inputCharacter >= '0' && inputCharacter <= '9'){
                return 4;
            }
        }
        return 5;
    }

    /*
     * Question 2 Hard Variation — Count Invalid Characters
     *
     * Write a method that counts how many invalid characters are in a word.
     *
     * A valid character is a capital letter from 'A' to 'Z'.
     *
     * Return:
     * -1 if the word is null
     * -2 if the word is empty
     * otherwise return the number of invalid characters in the word
     *
     * Examples:
     * "HELLO" returns 0
     * "HeLLO" returns 1
     * "DOG2!" returns 2
     */
    public static int validWordV4(String word)
    {
        // null check
        if (word == null){
            return -1;
        }
        if(word.length() == 0){
            return -2;
        }

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (validSquare(word.charAt(i)) == 1){
                count++;
            }
        }
        return count;
    }
}
