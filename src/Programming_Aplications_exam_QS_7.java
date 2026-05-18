import java.util.ArrayList;

public class Programming_Aplications_exam_QS_7 {

    public static void main(String[] args) {
        // Board where "CAT" appears 3 ways from (0,0): down, right, down-right
        char[][] board = {
                {'C', 'A', 'T', 'X', 'X'},
                {'A', 'A', 'X', 'X', 'X'},
                {'T', 'X', 'T', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        // Board where "CAT" appears up-right from (2,0)
        char[][] board2 = {
                {'X', 'X', 'T', 'X', 'X'},
                {'X', 'A', 'X', 'X', 'X'},
                {'C', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        System.out.println("=== Q1 validSquare ===");
        System.out.println(validSquare('A'));   // expect 0 (valid)
        System.out.println(validSquare('Z'));   // expect 0 (valid)
        System.out.println(validSquare('a'));   // expect 1 (invalid)
        System.out.println(validSquare('1'));   // expect 1 (invalid)
        System.out.println(validSquare(' '));   // expect 1 (invalid)

        System.out.println("=== Q2 validWord ===");
        System.out.println(validWord(null));      // expect 1
        System.out.println(validWord(""));        // expect 2
        System.out.println(validWord("Hello"));   // expect 3 (lowercase)
        System.out.println(validWord("CA1T"));    // expect 3 (digit)
        System.out.println(validWord("CAT"));     // expect 0 (valid)
        System.out.println(validWord("A"));       // expect 0 (valid)

        System.out.println("=== Q3 validBoard ===");
        System.out.println(validBoard(null));                                // expect 1
        System.out.println(validBoard(new char[0][0]));                      // expect 2
        System.out.println(validBoard(new char[][]{{'A','B'},{'C'}}));       // expect 3 (not square)
        System.out.println(validBoard(new char[][]{{'a'}}));                 // expect 4 (invalid char)
        System.out.println(validBoard(new char[][]{null, {'A','B'}}));       // expect 5 (null row)
        System.out.println(validBoard(new char[][]{{'A'}}));                 // expect 0 (valid 1x1)
        System.out.println(validBoard(board));                               // expect 0 (valid)

        System.out.println("=== Q6 findWord ===");
        System.out.println(findWord(null, board, 0, 0));     // expect 5 (invalid word)
        System.out.println(findWord("CAT", null, 0, 0));     // expect 6 (invalid board)
        System.out.println(findWord("CAT", board, -1, 0));   // expect 7 (out of bounds)
        System.out.println(findWord("CAT", board, 5, 0));    // expect 7 (out of bounds)
        System.out.println(findWord("CAT", board, 0, 0));    // expect 0 (down, checked first)
        System.out.println(findWord("DOG", board, 0, 0));    // expect 4 (not found)
        System.out.println(findWord("CAT", board2, 2, 0));   // expect 3 (up-right)

        System.out.println("=== Q6 countDirectionsFromStart ===");
        System.out.println(countDirectionsFromStart("CAT", board, 0, 0));    // expect 3 (down + right + down-right)
        System.out.println(countDirectionsFromStart("CAT", board2, 2, 0));   // expect 1 (up-right only)
        System.out.println(countDirectionsFromStart("DOG", board, 0, 0));    // expect 0

        System.out.println("=== Q7 countDictionary ===");
        String[] dictionary = {"CAT", "DOG"};
        int[] counts = countDictionary(board, dictionary);
        System.out.println("CAT: " + counts[0]);   // expect 3
        System.out.println("DOG: " + counts[1]);   // expect 0

        System.out.println("=== Q7 V1 ArrayList return ===");
        ArrayList<Integer> countsV1 = countDictionaryV1(board, dictionary);
        System.out.println("CAT: " + countsV1.get(0));   // expect 3
        System.out.println("DOG: " + countsV1.get(1));    // expect 0

        System.out.println("=== Q7 countTotalDictionaryWords ===");
        System.out.println(countTotalDictionaryWords(board, dictionary));   // expect 3

        System.out.println("=== Q7 countOneWord ===");
        System.out.println(countOneWord(board, "CAT"));   // expect 3
        System.out.println(countOneWord(board, "DOG"));   // expect 0
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
        if (startRow < 0 || startCol < 0 || startRow >= board.length || startCol >= board[0].length){
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
                    break;
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
                    break;
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
                    break;
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
                    break;
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
        //check invalid word
        if(validWord(word) != 0){
            return -1;
        }

        // check invalid board
        if(validBoard(board) != 0){
            return -2;
        }

        // out of bounds check
        if(startRow < 0 || startRow >= board.length || startCol < 0 || startCol >= board[0].length){
            return -3;
        }

        int count = 0;

        // check vertical
        boolean verticallyFound = true;
        if(startRow + word.length() <= board.length){
            for(int i = 0; i < word.length(); i++){
                if(board[startRow + i][startCol] != word.charAt(i)){
                    verticallyFound = false;
                    break;
                }
            }
            if(verticallyFound == true){
                count ++;
            }
        }

        // check horizontal
        boolean horizontallyFound = true;
        if(startCol + word.length() <= board.length){
            for(int i = 0; i < word.length(); i++){
                if(board[startRow][startCol + i] != word.charAt(i)){
                    horizontallyFound = false;
                    break;
                }
            }
            if(horizontallyFound == true){
                count ++;
            }
        }

        // check diagonally down
        boolean diagonallyDown = true;
        if(startRow + word.length() <= board.length && startCol + word.length() <= board.length){
            for(int i = 0; i < word.length(); i++){
                if(board[startRow + i][startCol + i] != word.charAt(i)){
                    diagonallyDown = false;
                    break;
                }
            }
            if(diagonallyDown == true){
                count ++;
            }
        }

        // check diagonally UP
        boolean diagonallyUp = true;
        if(startRow - (word.length() -1) >= 0 && startCol + word.length() <= board.length){
            for(int i = 0; i < word.length(); i++){
                if(board[startRow - i][startCol + i] != word.charAt(i)){
                    diagonallyUp = false;
                    break;
                }
            }
            if(diagonallyUp == true){
                count ++;
            }
        }

        return count;
    }

    /*
     * Question 7 — Count Dictionary
     *
     * Write a method that counts how many times each dictionary word
     * appears on the board.
     *
     * Assume:
     * - the board is valid
     * - the dictionary is valid
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * an int[] where each index matches the dictionary index.
     *
     * Example:
     * dictionary[0] = "CAT"
     * dictionary[1] = "DOG"
     *
     * If CAT appears 2 times and DOG appears 1 time,
     * return {2, 1}
     */
    public static int[] countDictionary(char[][] board, String[] dictionary)
    {
        int[] result = new int[dictionary.length];

        // for every word in dictionary...
        for(int i = 0; i < dictionary.length; i++){
            // for every row...
            for(int row = 0; row < board.length; row++){
                // for every column...
                for(int col = 0; col < board[row].length; col++){
                    // find total word count from that row and column position for that word
                    String word = dictionary[i];
                    int startRow = row;
                    int startCol = col;
                    // here we use countDirectionFromStart instead of the regular findWord as we need the total count.
                    // it would be best to directly set it to result avoids errors do it for the rest of the questions
                    int wordCount = countDirectionsFromStart(word, board, startRow, startCol);
                    result[i] += wordCount;
                }
            }
        }
        return result;
    }

    /*
     * Question 7 Variation — Count Dictionary Using ArrayList
     *
     * Write a method that counts how many times each dictionary word
     * appears on the board.
     *
     * Assume:
     * - the board is valid
     * - the dictionary is valid
     *
     * Return:
     * an ArrayList<Integer> where each index matches the dictionary index.
     */
    public static ArrayList<Integer> countDictionaryV1(char[][] board, String[] dictionary)
    {

        ArrayList<Integer> result = new ArrayList<Integer>();

        // for every word in dict...
        for(int i = 0; i < dictionary.length; i++){
            int wordCount = 0;
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length; col++){
                    String word = dictionary[i];
                    int startRow = row;
                    int startCol = col;
                    wordCount += countDirectionsFromStart(word, board, startRow, startCol);

                }
            }
            result.add(wordCount);
        }
    return result;
    }

    /*
     * Question 7 Variation — Dictionary as ArrayList
     *
     * Write a method that counts how many times each dictionary word
     * appears on the board.
     *
     * Assume:
     * - the board is valid
     * - the dictionary is valid
     *
     * Return:
     * an int[] where each index matches the dictionary index.
     */
    public static int[] countDictionaryV2(char[][] board, ArrayList<String> dictionary) {
        int[] result = new int[dictionary.size()];

        for (int i = 0; i < dictionary.size(); i++) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    String word = dictionary.get(i);
                    int startRow = row;
                    int startCol = col;
                    int wordCount = countDirectionsFromStart(word, board, startRow, startCol);
                    result[i] += wordCount;
                }
            }
        }
        return result;
    }

    /*
     * Question 7 Hard Variation — Total Dictionary Count
     *
     * Write a method that counts the total number of times all dictionary words
     * appear on the board.
     *
     * Assume:
     * - the board is valid
     * - the dictionary is valid
     *
     * Example:
     * dictionary = {"CAT", "DOG"}
     * CAT appears 2 times
     * DOG appears 1 time
     *
     * return 3
     */
    public static int countTotalDictionaryWords(char[][] board, String[] dictionary)
    {
        int count = 0;

        for(int i = 0; i < dictionary.length; i++){
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length; col++){
                    String word = dictionary[i];
                    int startRow = row;
                    int startCol = col;
                    int wordCount = countDirectionsFromStart(word, board, startRow, startCol);
                    count += wordCount;
                }
            }
        }
        return count;
    }


    /*
     * Question 7 Hard Variation — Count One Word
     *
     * Write a method that counts how many times one word appears
     * anywhere on the board.
     *
     * Assume:
     * - the board is valid
     * - the word is valid
     *
     * Valid directions:
     * - vertical down
     * - horizontal left-to-right
     * - diagonal down-right
     * - diagonal up-right
     *
     * Return:
     * the number of times the word appears on the board
     */
    public static int countOneWord(char[][] board, String word)
    {
        int count = 0;

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                int startRow = row;
                int startCol = col;
                int wordCount = countDirectionsFromStart(word, board, startRow, startCol);
                count += wordCount;
            }
        }
        return count;
    }

}
