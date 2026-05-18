public class Programming_Aplications_exam_QS_2 {

    public static void main(String[] args) {

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



}
