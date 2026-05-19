public class Programming_Aplications_Actual_exam {

    public static void main(String[] args) {

        // question 1 tests
        System.out.println("Question 1 tests");
        System.out.println( Q1ValidSquare('A'));

        // question 2 tests
        System.out.println("Question 2 tests");

        // question 5 tests
        System.out.println();
        System.out.println("Question 5 tests");
        System.out.println( Q5LocateWord( "", new String[]{"PAT", "BAT", "CAT", "fOG"}));

        // question 6 tests
        System.out.println();
        System.out.println("Question 6 tests");
        System.out.println( Q6FindWord( "DOG" ,new char[][]{{'D','O', 'G'}, {'D','O', 'G'}, {'D','O', 'G'}}, 4, 4));

    }


    // question 1
    public static boolean Q1ValidSquare(char square){
        if (square >= 'A' && square <= 'Z'){
            return true;
        } else {
            return false;
        }
    }

    // question 2
    public static int Q2ValidWord(String word){
        if (word == null){
            return -1;
        }
        if(word.length() == 0){
            return -2;
        }
        for(int i = 0; i < word.length(); i++){

            if(Q1ValidSquare(word.charAt(i)) == false){
                return -3;
            }
        }
        return 1;
    }

    /*
    Test 1: If the input (board) is null, return -1  (0.50 marks)

    Test 2: If the input (board) is zero in size (rows and/or columns), return -2 (0.50 marks)

    Test 3: If the input (board) is not square, return -3 (0.50 marks)

    Test 4: If the input (board) contains invalid characters, return -4 (1 mark)

    Test 5: Otherwise, return +1 for a valid input board (0.5 marks)
     */


    // question 3
    public static int Q3ValidBoard(char[][] board){
        // null check
        if (board == null){
            return -1;
        }

        // Test 2: If the input (board) is zero in size (rows and/or columns), return -2
        if(board.length == 0){
            return -2;
        }
        for(int i = 0; i < board.length; i++){

            //empty row check
            if(board[i].length == 0){
                return -2;
            }
            for(int j = 0; j < board[i].length; j++){
                // coloumn empty check
                if(Q1ValidSquare(board[i][j]) == false){
                    return -2;
                }
            }

        }
        // not square check - for loop
        int boardLength = board.length;
        for(int i = 0; i < boardLength; i++){

            // null row check
            if(board[i] == null){
                return -2;
            }

            // not square check
            if(board[i].length != boardLength){
                return -3;
            }

            // invalid character check
            for (int j = 0; j < board[i].length; j++){
                if(Q1ValidSquare(board[i][j]) == false){
                    return -4;
                }
            }
        }
        return 1;
    }

    //question 4
    public static int Q4ValidDictionary(char[][] board, String[] dictionary){
        // null dict check
        if(dictionary == null){
            return -1;
        }

        //empty Dict/too small check
        if(dictionary.length == 0){
            return -2;
        }

        int boardLength = board.length;

        for(int i = 0; i < dictionary.length; i++){

            // invalid word check
            if (Q2ValidWord(dictionary[i]) != 1){
                return -4;
            }

            // too long word check
            if(dictionary[i].length() > boardLength){
                return -3;
            }
        }
        return 1;
    }

    // question 5
    public static int Q5LocateWord(String word, String[] dictionary)
    {
        // word null check
        if(word == null){
            return -1;
        }
        // word empty check
        if (word.isEmpty()){
            return -2;
        }

        // check if word in dict
        for(int i = 0; i < dictionary.length; i++){
            if (word.equals(dictionary[i])){
                return 1;
            }
        }
        // not in dict
        return -3;
    }

    // question 6
    public static int Q6FindWord(String word, char[][] board, int row, int col){

        // Test 1: If the row coordinate is invalid but the column coordinate is valid, return -1
        if((row < 0 || row >= board.length) && (col >= 0 && col < board.length)){
            return -1;
        }

        // Test 2: If the column coordinate is invalid but the row coordinate is valid, return -2
        if((row >= 0 && row < board.length) && (col < 0 || col >= board.length)){
            return -2;
        }

        // Test 3: If both the row and column coordinates are invalid, return -3
        if ((row < 0 || row >= board.length) && (col < 0 || col >= board.length)){
            return -3;
        }

        int count = 0;

        int wordLength = word.length();
        int boardLength = board.length;

        // check vertically downward
        boolean verticallyFound = true;
        // if the word fits the board from startRow
        if(row + wordLength <= boardLength){
            // iterate for the length of the word
            for(int i = 0; i < wordLength; i++){
                // if the character in the board does not match the character in the word, we set verticallyFound to false
                if(board[row + i][col] != word.charAt(i)){
                    verticallyFound = false;
                    break;
                }
            }
            // if it manages to remain true for the length of the word, we have found the word.
            if(verticallyFound == true){
                count++;
            }
        }

        // check horizontally right
        boolean horizontallyFound = true;
        // if the word fits the board from startCol
        if(col + wordLength <= boardLength){
            // iterate for the length of the word
            for(int i = 0; i < wordLength; i++){
                if(board[row][col + i] != word.charAt(i)){
                    horizontallyFound = false;
                    break;
                }
            }
            // if it manages to remain true for the length of the word, we have found the word.
            if(horizontallyFound == true){
                count++;
            }
        }

        // check diagonally down-right
        boolean diagonallyDown = true;
        // if the word fits the board from startRow (+) and startCol (+)
        if(row + wordLength <= boardLength && col + wordLength <= boardLength){
            for(int i = 0; i < wordLength; i++){
                if(board[row + i][col + i] != word.charAt(i)){
                    diagonallyDown = false;
                    break;
                }
            }
            if(diagonallyDown == true){
                count++;
            }
        }

        // check diagonally UP-right
        boolean diagonallyUp = true;
        // subtract from row and ensure it is >= 0, and column is less than board length, ie: word fits
        if(row - (wordLength - 1) >= 0 && col + wordLength <= boardLength){
            for(int i = 0; i < wordLength; i++){
                if(board[row - i][col + i] != word.charAt(i)){
                    diagonallyUp = false;
                    break;
                }
            }
            if(diagonallyUp == true){
                count++;
            }
        }
        return count;
    }

    // question 7
        /*
    Test 1: If the dictionary words do not match the board size, return null  (1 mark)

    Test 2: Otherwise, return a count of how many times each word in the dictionary appears in the board (A percentage of 3 marks; based on the correct count of the words in the dictionary)
     */

    public static int[] Q7CountDictionary(char[][] board, String[] dictionary){

        // words in dict too big for board
        for(int i = 0; i < dictionary.length; i++){
            if(dictionary[i].length() > board.length){
                return null;
            }
        }

        int[] result = new int[dictionary.length];

        for(int i = 0; i < dictionary.length; i++){
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length; col++){
                    String word = dictionary[i];
                    int currentRow = row;
                    int currentCol = col;
                    int wordCount = Q6FindWord(word, board, currentRow, currentCol);
                    result[i] += wordCount;
                }
            }
        }
        return result;
    }


}
