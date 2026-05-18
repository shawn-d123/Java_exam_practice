public class Programming_Aplications_exam_QS_3 {

    public static void main(String[] args)
    {
        char[][] validBoard = {
                {'A', 'B'},
                {'C', 'D'}
        };

        char[][] emptyBoard = new char[0][0];

        char[][] notSquareBoard = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'}
        };

        char[][] invalidCharacterBoard = {
                {'A', 'B'},
                {'C', 'd'}
        };

        char[][] nullRowBoard = new char[2][];
        nullRowBoard[0] = new char[]{'A', 'B'};
        nullRowBoard[1] = null;

        System.out.println("===== Testing validBoard =====");
        System.out.println("validBoard(validBoard) expected 0, got: " + validBoard(validBoard));
        System.out.println("validBoard(null) expected 1, got: " + validBoard(null));
        System.out.println("validBoard(emptyBoard) expected 2, got: " + validBoard(emptyBoard));
        System.out.println("validBoard(notSquareBoard) expected 3, got: " + validBoard(notSquareBoard));
        System.out.println("validBoard(invalidCharacterBoard) expected 4, got: " + validBoard(invalidCharacterBoard));
        System.out.println("validBoard(nullRowBoard) expected 5, got: " + validBoard(nullRowBoard));

        System.out.println();

        System.out.println("===== Testing validBoardV1 =====");
        System.out.println("validBoardV1(validBoard) expected true, got: " + validBoardV1(validBoard));
        System.out.println("validBoardV1(null) expected false, got: " + validBoardV1(null));
        System.out.println("validBoardV1(emptyBoard) expected false, got: " + validBoardV1(emptyBoard));
        System.out.println("validBoardV1(notSquareBoard) expected false, got: " + validBoardV1(notSquareBoard));
        System.out.println("validBoardV1(invalidCharacterBoard) expected false, got: " + validBoardV1(invalidCharacterBoard));
        System.out.println("validBoardV1(nullRowBoard) expected false, got: " + validBoardV1(nullRowBoard));

        System.out.println();

        System.out.println("===== Testing countInvalidSquares =====");
        System.out.println("countInvalidSquares(validBoard) expected 0, got: " + countInvalidSquares(validBoard));
        System.out.println("countInvalidSquares(null) expected -1, got: " + countInvalidSquares(null));
        System.out.println("countInvalidSquares(emptyBoard) expected -2, got: " + countInvalidSquares(emptyBoard));
        System.out.println("countInvalidSquares(nullRowBoard) expected -3, got: " + countInvalidSquares(nullRowBoard));
        System.out.println("countInvalidSquares(notSquareBoard) expected -4, got: " + countInvalidSquares(notSquareBoard));
        System.out.println("countInvalidSquares(invalidCharacterBoard) expected 1, got: " + countInvalidSquares(invalidCharacterBoard));

        System.out.println();

        String[] validStringBoard = {"CAT", "AAA", "DOG"};
        String[] emptyStringBoard = new String[0];
        String[] nullStringRowBoard = {"CAT", null, "DOG"};
        String[] emptyStringRowBoard = {"CAT", "", "DOG"};
        String[] notSquareStringBoard = {"CAT", "AAA"};
        String[] invalidStringBoard = {"CAT", "AaA", "DOG"};

        System.out.println("===== Testing validBoardV3 =====");
        System.out.println("validBoardV3(validStringBoard) expected 0, got: " + validBoardV3(validStringBoard));
        System.out.println("validBoardV3(null) expected 1, got: " + validBoardV3(null));
        System.out.println("validBoardV3(emptyStringBoard) expected 2, got: " + validBoardV3(emptyStringBoard));
        System.out.println("validBoardV3(nullStringRowBoard) expected 3, got: " + validBoardV3(nullStringRowBoard));
        System.out.println("validBoardV3(emptyStringRowBoard) expected 4, got: " + validBoardV3(emptyStringRowBoard));
        System.out.println("validBoardV3(notSquareStringBoard) expected 5, got: " + validBoardV3(notSquareStringBoard));
        System.out.println("validBoardV3(invalidStringBoard) expected 6, got: " + validBoardV3(invalidStringBoard));
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
     * Question 3 — Valid Board
     *
     * Write a method that checks whether a 2D char array is a valid Word Search board.
     *
     * A valid board must:
     * - not be null
     * - not be empty
     * - be square
     * - contain no null rows
     * - contain only valid capital letters from 'A' to 'Z'
     *
     * Return:
     * 0 if the board is valid
     * 1 if the board is null
     * 2 if the board is empty / too small
     * 3 if the board is not square
     * 4 if the board contains an invalid character
     * 5 if any row is null
     */
    public static int validBoard(char[][] board)
    {
        // null check
        if (board == null){
            return 1;
        }
        // empty/ too small check
        if (board.length < 1){
            return 2;
        }
        // not square check - for loop
        int boardLength = board.length;
        for(int i = 0; i < boardLength; i++){

            // null row check
            if(board[i] == null){
                return 5;
            }

            // not square check
            if(board[i].length != boardLength){
                return 3;
            }

            // invalid character check
            for (int j = 0; j < board[i].length; j++){
                if(validSquare(board[i][j]) == 1){
                    return 4;
                }
            }
        }
        return 0;
    }

    /*
     * Question 3 Variation — Valid Board Boolean
     *
     * Write a method that checks whether a 2D char array is a valid Word Search board.
     *
     * A valid board must:
     * - not be null
     * - not be empty
     * - be square
     * - contain no null rows
     * - contain only capital letters from 'A' to 'Z'
     *
     * Return:
     * true if the board is valid
     * false if the board is invalid
     */
    public static boolean validBoardV1(char[][] board)
    {
        // null check
        if (board == null){
            return false;
        }
        // empty/ too small check
        if (board.length < 1){
            return false;
        }
        // not square check - for loop
        int boardLength = board.length;
        for(int i = 0; i < boardLength; i++){

            // null row check
            if(board[i] == null){
                return false;
            }

            // not square check
            if(board[i].length != boardLength){
                return false;
            }

            // invalid character check
            for (int j = 0; j < board[i].length; j++){
                if(validSquare(board[i][j]) == 1){
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Question 3 Hard Variation — Count Invalid Squares
     *
     * Write a method that counts how many invalid characters are inside the board.
     *
     * A valid character is a capital letter from 'A' to 'Z'.
     *
     * Return:
     * -1 if the board is null
     * -2 if the board is empty
     * -3 if any row is null
     * -4 if the board is not square
     * otherwise return the number of invalid characters in the board
     *
     * Examples:
     * {{'A','B'}, {'C','D'}} returns 0
     * {{'A','b'}, {'C','1'}} returns 2
     */
    public static int countInvalidSquares(char[][] board)
    {
        // null check
        if(board == null){
            return -1;
        }

        // empty check
        if(board.length < 1){
            return -2;
        }

        int boardLength = board.length;
        int countInvalidSquares = 0;
        for(int i = 0; i < boardLength; i++){

            if(board[i] == null){
                return -3;
            }

            if (board[i].length != boardLength){
                return -4;
            }

            for(int j = 0; j < board[i].length; j++){
                if(validSquare(board[i][j]) == 1){
                    countInvalidSquares++;
                }
            }
        }
        return countInvalidSquares;
    }

    /*
     * Question 3 Hard Variation — Valid Board as String Array
     *
     * In this version, the board is stored as a String array.
     * Each String represents one row of the board.
     *
     * Example:
     * {"CAT", "AAA", "DOG"}
     *
     * A valid board must:
     * - not be null
     * - not be empty
     * - contain no null rows
     * - contain no empty rows
     * - be square
     * - contain only capital letters from 'A' to 'Z'
     *
     * Return:
     * 0 if the board is valid
     * 1 if the board is null
     * 2 if the board is empty
     * 3 if any row is null
     * 4 if any row is empty
     * 5 if the board is not square
     * 6 if the board contains an invalid character
     */
    public static int validBoardV3(String[] board)
    {
        // null check
        if(board == null){
            return 1;
        }

        // empty check
        if(board.length < 1){
            return 2;
        }
        int boardLength = board.length;

        for(int i = 0; i < boardLength; i++){

            // null row check
            if(board[i] == null){
                return 3;
            }

            // empty row check
            if(board[i].isEmpty()){
                return 4;
            }

            // square check
            if(board[i].length() != boardLength){
                return 5;
            }

            // invalid character check
            for (int j = 0; j < board[i].length(); j++){
                if(validSquare(board[i].charAt(j)) == 1 ){
                    return 6;
                }
            }
        }
        return 0;
    }
}
