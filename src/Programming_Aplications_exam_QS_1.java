public class Programming_Aplications_exam_QS_1 {

    public static void main(String[] args) {

        System.out.println("Testing validSquare:");
        System.out.println("validSquare('A') expected 0, got: " + validSquare('A'));
        System.out.println("validSquare('Z') expected 0, got: " + validSquare('Z'));
        System.out.println("validSquare('a') expected 1, got: " + validSquare('a'));
        System.out.println("validSquare('5') expected 1, got: " + validSquare('5'));
        System.out.println("validSquare(' ') expected 1, got: " + validSquare(' '));
        System.out.println("validSquare('#') expected 1, got: " + validSquare('#'));

        System.out.println();

        System.out.println("Testing validSquareV1:");
        System.out.println("validSquareV1('A') expected true, got: " + validSquareV1('A'));
        System.out.println("validSquareV1('Z') expected true, got: " + validSquareV1('Z'));
        System.out.println("validSquareV1('a') expected false, got: " + validSquareV1('a'));
        System.out.println("validSquareV1('5') expected false, got: " + validSquareV1('5'));
        System.out.println("validSquareV1(' ') expected false, got: " + validSquareV1(' '));
        System.out.println("validSquareV1('#') expected false, got: " + validSquareV1('#'));

        System.out.println();

        System.out.println("Testing validSquareV2:");
        System.out.println("validSquareV2('A') expected 0, got: " + validSquareV2('A'));
        System.out.println("validSquareV2('Z') expected 0, got: " + validSquareV2('Z'));
        System.out.println("validSquareV2('a') expected 1, got: " + validSquareV2('a'));
        System.out.println("validSquareV2('z') expected 1, got: " + validSquareV2('z'));
        System.out.println("validSquareV2('5') expected 2, got: " + validSquareV2('5'));
        System.out.println("validSquareV2(' ') expected 3, got: " + validSquareV2(' '));
        System.out.println("validSquareV2('#') expected 3, got: " + validSquareV2('#'));

        System.out.println();

        System.out.println("Testing validSquareV3:");
        System.out.println("validSquareV3('A') expected 0, got: " + validSquareV3('A'));
        System.out.println("validSquareV3('Z') expected 0, got: " + validSquareV3('Z'));
        System.out.println("validSquareV3('a') expected 1, got: " + validSquareV3('a'));
        System.out.println("validSquareV3('z') expected 1, got: " + validSquareV3('z'));
        System.out.println("validSquareV3('5') expected 2, got: " + validSquareV3('5'));
        System.out.println("validSquareV3(' ') expected 2, got: " + validSquareV3(' '));
        System.out.println("validSquareV3('#') expected 2, got: " + validSquareV3('#'));

    }

    /*
     * Question 1 — Valid Square
     *
     * Write a method that checks whether a character is a valid square
     * in the Word Search board.
     *
     * A valid square is a capital letter from 'A' to 'Z'.
     *
     * Return:
     * 0 if the character is valid
     * 1 if the character is invalid
     */
    public static int validSquare(char inputCharacter)
    {
        if( inputCharacter >= 'A' && inputCharacter <= 'Z'){
            return 0;
        }else{
            return 1;
        }
    }

    public static boolean Q1ValidSquare(char square){
        if (square >= 'A' && square <= 'Z'){
            return true;
        } else {
            return false;
        }
    }

    /*
     * Question 1 — Valid Square
     *
     * A valid square is a capital letter from 'A' to 'Z'.
     *
     * Return true if the character is valid.
     * Return false if the character is invalid.
     */
    public static boolean validSquareV1(char inputCharacter)
    {
        if (inputCharacter >= 'A' && inputCharacter <= 'Z'){
            return true;
        } else {
            return false;
        }
    }

    /*
     * Question 1 — Valid Square Advanced
     *
     * A valid square is a capital letter from 'A' to 'Z'.
     *
     * Return:
     * 0 if the character is valid
     * 1 if the character is a lowercase letter
     * 2 if the character is a digit
     * 3 if the character is anything else
     */
    public static int validSquareV2(char inputCharacter)
    {
        if (inputCharacter >= 'A' && inputCharacter <= 'Z')
        {
            return 0;
        }

        if (inputCharacter >= 'a' && inputCharacter <= 'z')
        {
            return 1;
        }

        if (inputCharacter >= '0' && inputCharacter <= '9')
        {
            return 2;
        }

        return 3;
    }

    /*
     * Question 1 — Valid Square Advanced
     *
     * A square is acceptable if it is an English letter from A-Z or a-z.
     *
     * Return:
     * 0 if the character is already uppercase A-Z
     * 1 if the character is lowercase a-z
     * 2 if the character is not an English letter
     */
    public static int validSquareV3(char inputCharacter)
    {
        if (inputCharacter >= 'A' && inputCharacter <= 'Z' ){
            return 0;
        }
        if ( inputCharacter >= 'a' && inputCharacter <= 'z' ){
            return 1;
        }
        else{
            return 2;
        }
    }

}
