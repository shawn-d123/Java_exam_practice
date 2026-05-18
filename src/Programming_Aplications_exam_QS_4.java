import java.util.ArrayList;

public class Programming_Aplications_exam_QS_4 {

    public static void main(String[] args)
    {
        char[][] validBoard = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };

        char[][] invalidBoard = {
                {'A', 'B'},
                {'C'}
        };

        String[] validDictionary = {"CAT", "DOG"};
        String[] emptyDictionary = {};
        String[] invalidWordDictionary = {"CAT", "Dog"};
        String[] tooLongDictionary = {"ELEPHANT"};
        String[] duplicateDictionary = {"CAT", "DOG", "CAT"};

        System.out.println("===== Testing validDictionary =====");
        System.out.println("validDictionary(validBoard, validDictionary) expected 0, got: "
                + validDictionary(validBoard, validDictionary));
        System.out.println("validDictionary(validBoard, null) expected 1, got: "
                + validDictionary(validBoard, null));
        System.out.println("validDictionary(validBoard, emptyDictionary) expected 2, got: "
                + validDictionary(validBoard, emptyDictionary));
        System.out.println("validDictionary(invalidBoard, validDictionary) expected 3, got: "
                + validDictionary(invalidBoard, validDictionary));
        System.out.println("validDictionary(validBoard, invalidWordDictionary) expected 4, got: "
                + validDictionary(validBoard, invalidWordDictionary));
        System.out.println("validDictionary(validBoard, tooLongDictionary) expected 5, got: "
                + validDictionary(validBoard, tooLongDictionary));

        System.out.println();

        System.out.println("===== Testing validDictionaryV1 =====");
        System.out.println("validDictionaryV1(validBoard, validDictionary) expected true, got: "
                + validDictionaryV1(validBoard, validDictionary));
        System.out.println("validDictionaryV1(validBoard, null) expected false, got: "
                + validDictionaryV1(validBoard, null));
        System.out.println("validDictionaryV1(invalidBoard, validDictionary) expected false, got: "
                + validDictionaryV1(invalidBoard, validDictionary));
        System.out.println("validDictionaryV1(validBoard, invalidWordDictionary) expected false, got: "
                + validDictionaryV1(validBoard, invalidWordDictionary));

        System.out.println();

        ArrayList<String> validArrayListDictionary = new ArrayList<String>();
        validArrayListDictionary.add("CAT");
        validArrayListDictionary.add("DOG");

        ArrayList<String> emptyArrayListDictionary = new ArrayList<String>();

        ArrayList<String> invalidArrayListDictionary = new ArrayList<String>();
        invalidArrayListDictionary.add("CAT");
        invalidArrayListDictionary.add("Dog");

        ArrayList<String> tooLongArrayListDictionary = new ArrayList<String>();
        tooLongArrayListDictionary.add("ELEPHANT");

        System.out.println("===== Testing validDictionaryV2 =====");
        System.out.println("validDictionaryV2(validBoard, validArrayListDictionary) expected 0, got: "
                + validDictionaryV2(validBoard, validArrayListDictionary));
        System.out.println("validDictionaryV2(validBoard, null) expected 1, got: "
                + validDictionaryV2(validBoard, null));
        System.out.println("validDictionaryV2(validBoard, emptyArrayListDictionary) expected 2, got: "
                + validDictionaryV2(validBoard, emptyArrayListDictionary));
        System.out.println("validDictionaryV2(invalidBoard, validArrayListDictionary) expected 3, got: "
                + validDictionaryV2(invalidBoard, validArrayListDictionary));
        System.out.println("validDictionaryV2(validBoard, invalidArrayListDictionary) expected 4, got: "
                + validDictionaryV2(validBoard, invalidArrayListDictionary));
        System.out.println("validDictionaryV2(validBoard, tooLongArrayListDictionary) expected 5, got: "
                + validDictionaryV2(validBoard, tooLongArrayListDictionary));

        System.out.println();

        System.out.println("===== Testing validDictionaryV3 =====");
        System.out.println("validDictionaryV3(validBoard, validDictionary) expected 0, got: "
                + validDictionaryV3(validBoard, validDictionary));
        System.out.println("validDictionaryV3(validBoard, duplicateDictionary) expected 6, got: "
                + validDictionaryV3(validBoard, duplicateDictionary));
        System.out.println("validDictionaryV3(validBoard, invalidWordDictionary) expected 4, got: "
                + validDictionaryV3(validBoard, invalidWordDictionary));
        System.out.println("validDictionaryV3(validBoard, tooLongDictionary) expected 5, got: "
                + validDictionaryV3(validBoard, tooLongDictionary));
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
     * Question 4 — Valid Dictionary
     *
     * Write a method that checks whether a dictionary is valid for a given Word Search board.
     *
     * A valid dictionary must:
     * - not be null
     * - not be empty
     * - be used with a valid board
     * - contain only valid words
     * - contain no words longer than the board size
     *
     * Return:
     * 0 if the dictionary is valid
     * 1 if the dictionary is null
     * 2 if the dictionary is empty / too small
     * 3 if the board is invalid
     * 4 if the dictionary contains an invalid word
     * 5 if the dictionary contains a word that is too long for the board
     */
    public static int validDictionary(char[][] board, String[] dictionary)
    {
        // null dict check
        if(dictionary == null){
            return 1;
        }

        //empty Dict/too small check
        if(dictionary.length < 1){
            return 2;
        }

        // invalid board check
        if(validBoard(board) != 0){
            return 3;
        }

        int boardLength = board.length;

        for(int i = 0; i < dictionary.length; i++){

            // invalid word check
            if (validWord(dictionary[i]) != 0){
                return 4;
            }

            // too long word check
            if(dictionary[i].length() > boardLength){
                return 5;
            }
        }
        return 0;
    }

    /*
     * Question 4 Variation — Valid Dictionary Boolean
     *
     * Write a method that checks whether a dictionary is valid for a given Word Search board.
     *
     * A valid dictionary must:
     * - not be null
     * - not be empty
     * - be used with a valid board
     * - contain only valid words
     * - contain no words longer than the board size
     *
     * Return:
     * true if the dictionary is valid
     * false if the dictionary is invalid
     */
    public static boolean validDictionaryV1(char[][] board, String[] dictionary)
    {
        // null dict check
        if(dictionary == null){
            return false;
        }

        //empty Dict/too small check
        if(dictionary.length < 1){
            return false;
        }

        // invalid board check
        if(validBoard(board) != 0){
            return false;
        }

        int boardLength = board.length;

        for(int i = 0; i < dictionary.length; i++){

            // invalid word check
            if (validWord(dictionary[i]) != 0){
                return false;
            }

            // too long word check
            if(dictionary[i].length() > boardLength){
                return false;
            }
        }
        return true;
    }

    /*
     * Question 4 Variation — Valid Dictionary Using ArrayList
     *
     * Write a method that checks whether an ArrayList dictionary is valid
     * for a given Word Search board.
     *
     * A valid dictionary must:
     * - not be null
     * - not be empty
     * - be used with a valid board
     * - contain only valid words
     * - contain no words longer than the board size
     *
     * Return:
     * 0 if the dictionary is valid
     * 1 if the dictionary is null
     * 2 if the dictionary is empty / too small
     * 3 if the board is invalid
     * 4 if the dictionary contains an invalid word
     * 5 if the dictionary contains a word that is too long for the board
     */
    public static int validDictionaryV2(char[][] board, ArrayList<String> dictionary)
    {
        // null dict check
        if(dictionary == null){
            return 1;
        }

        // dict empty/too small
        if(dictionary.size() < 1){
            return 2;
        }

        // board valid check
        if(validBoard(board) != 0){
            return 3;
        }

        int boardLength = board.length;
        for (int i = 0; i < dictionary.size(); i++){

            // valid word check
            if (validWord(dictionary.get(i)) != 0){
                return 4;
            }

            // word too long
            if(dictionary.get(i).length() > boardLength){
                return 5;
            }
        }
        return 0;
    }

    /*
     * Question 4 Hard Variation — Valid Dictionary With Duplicate Check
     *
     * Write a method that checks whether a dictionary is valid.
     *
     * A valid dictionary must:
     * - not be null
     * - not be empty
     * - be used with a valid board
     * - contain only valid words
     * - contain no words longer than the board size
     * - contain no duplicate words
     *
     * Return:
     * 0 if the dictionary is valid
     * 1 if the dictionary is null
     * 2 if the dictionary is empty
     * 3 if the board is invalid
     * 4 if the dictionary contains an invalid word
     * 5 if the dictionary contains a word too long for the board
     * 6 if the dictionary contains a duplicate word
     */
    public static int validDictionaryV3(char[][] board, String[] dictionary)
    {
        // null dict check
        if(dictionary == null){
            return 1;
        }

        //empty Dict/too small check
        if(dictionary.length < 1){
            return 2;
        }

        // invalid board check
        if(validBoard(board) != 0){
            return 3;
        }

        int boardLength = board.length;

        for(int i = 0; i < dictionary.length; i++){

            // invalid word check
            if (validWord(dictionary[i]) != 0){
                return 4;
            }

            // too long word check
            if(dictionary[i].length() > boardLength){
                return 5;
            }
        }

        // duplicate word check
        for(int n = 0; n < dictionary.length; n++){
            for(int j = n + 1; j < dictionary.length; j++){
                String wordToFind = dictionary[n];
                if(wordToFind.equals(dictionary[j])){
                    return 6;
                }
            }
        }
        return 0;
    }

}
