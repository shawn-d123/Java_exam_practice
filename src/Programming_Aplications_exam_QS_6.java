public class Programming_Aplications_exam_QS_6 {
    public static void main(String[] args) {

    }

    // question 1 - Valid Square
    public static int validSquare(char inputCharacter)
    {
        if( inputCharacter >= 'A' && inputCharacter <= 'Z'){
            return 0;
        }else{
            return 1;
        }
    }

    //Question 2 — Valid Word
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

    // Question 3 — Valid Board
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
     * Question 6 — Find Word
     *
     * Write a method that checks whether a word appears on the board
     * from a given starting position.
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * 0 if the word is found vertically down
     * 1 if the word is found horizontally left-to-right
     * 2 if the word is found diagonally down-right
     * 3 if the word is found diagonally up-right
     * 4 if the word is not found from the given starting position
     * 5 if the word is invalid
     * 6 if the board is invalid
     * 7 if the start coordinates are out of bounds
     */
    public static int findWord(String word, char[][] board, int startRow, int startCol)
    {
        // invalid word check
        if(validWord(word) != 0){
            return 5;
        }

        // invalid board check
        if(validBoard(board) != 0){
            return 6;
        }

        // out of bounds check
        if(startRow < 0 || startCol < 0 || startRow >= board[0].length || startCol >= board.length){
            return 7;
        }

        int wordLength = word.length();
        int boardLength = board.length;

        // check vertically downward
        boolean verticallyFound = true;
        // if the word fits the board from startRow
        if(startRow + wordLength <= boardLength){
            // iterate for the length of the word
            for(int i = 0; i < wordLength; i++){
                // if the character in the board does not match the character in the word, we set verticallyFound to false
                if(board[startRow + i][startCol] != word.charAt(i)){
                    verticallyFound = false;
                }
            }
            // if it manages to remain true for the length of the word, we have found the word.
            if(verticallyFound == true){
                return 0;
            }
        }

        // check horizontally right
        boolean horizontallyFound = true;
        // if the word fits the board from startCol
        if(startCol + wordLength <= boardLength){
            // iterate for the length of the word
            for(int i = 0; i < wordLength; i++){
                if(board[startRow][startCol + i] != word.charAt(i)){
                    horizontallyFound = false;
                }
            }
            // if it manages to remain true for the length of the word, we have found the word.
            if(horizontallyFound == true){
                return 1;
            }
        }

        // check diagonally down-right
        boolean diagonallyDown = true;
        // if the word fits the board from startRow (+) and startCol (+)
        if(startRow + wordLength <= boardLength && startCol + wordLength <= boardLength){
            for(int i = 0; i < wordLength; i++){
                if(board[startRow + i][startCol + i] != word.charAt(i)){
                    diagonallyDown = false;
                }
            }
            if(diagonallyDown == true){
                return 2;
            }
        }

        // check diagonally UP-right
        boolean diagonallyUp = true;
        // subtract from row and ensure it is >= 0, and column is less than board length, ie: word fits
        if(startRow - (wordLength - 1) >= 0 && startCol + wordLength <= boardLength){
            for(int i = 0; i < wordLength; i++){
                if(board[startRow - i][startCol + i] != word.charAt(i)){
                    diagonallyUp = false;
                }
            }
            if(diagonallyUp == true){
                return 3;
            }
        }
        // word not found from given starting position
        return 4;
    }

    /*
     * Question 6 Variation — Find Word Boolean
     *
     * Write a method that checks whether a word appears on the board
     * from a given starting position in any valid direction.
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * true if the word appears in any valid direction from the starting position
     * false otherwise
     */
    public static boolean findWordV1(String word, char[][] board, int startRow, int startCol)
    {
        // Write your answer here.
    }


    /*
     * Question 6 Variation — Return Direction as String
     *
     * Write a method that checks whether a word appears on the board
     * from a given starting position.
     *
     * Return:
     * "VERTICAL" if the word is found vertically down
     * "HORIZONTAL" if the word is found horizontally left-to-right
     * "DIAGONAL_DOWN" if the word is found diagonally down-right
     * "DIAGONAL_UP" if the word is found diagonally up-right
     * "NOT_FOUND" if the word is not found
     * "INVALID_WORD" if the word is invalid
     * "INVALID_BOARD" if the board is invalid
     * "INVALID_POSITION" if the start coordinates are out of bounds
     */
    public static String findWordV2(String word, char[][] board, int startRow, int startCol)
    {
        // Write your answer here.
    }


    /*
     * Question 6 Hard Variation — Find Word Using Coordinate Array
     *
     * The starting position is provided as an int array:
     * startPosition[0] is the row
     * startPosition[1] is the column
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * 0 if the word is found vertically down
     * 1 if the word is found horizontally left-to-right
     * 2 if the word is found diagonally down-right
     * 3 if the word is found diagonally up-right
     * 4 if the word is not found
     * 5 if the word is invalid
     * 6 if the board is invalid
     * 7 if startPosition is null
     * 8 if startPosition does not contain exactly 2 values
     * 9 if the start coordinates are out of bounds
     */
    public static int findWordV3(String word, char[][] board, int[] startPosition)
    {
        // Write your answer here.
    }


    /*
     * Question 6 Hard Variation — Count Directions From One Start Position
     *
     * Write a method that counts how many valid directions contain the word
     * from the given starting position.
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * -1 if the word is invalid
     * -2 if the board is invalid
     * -3 if the start coordinates are out of bounds
     * otherwise return the number of directions where the word is found
     *
     * Example:
     * If the word appears horizontally and diagonally down from the same start,
     * return 2.
     */
    public static int countDirectionsFromStart(String word, char[][] board, int startRow, int startCol)
    {
        // Write your answer here.
    }

}
