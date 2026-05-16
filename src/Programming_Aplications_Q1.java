public class Programming_Aplications_Q1 {

    public static void main(String[] args)
    {
        // You can use this area to test your methods.

        char[][] testBoard = {
                {'A', 'B'},
                {'C', 'D'}
        };

        String[] testDictionary = {"CAT", "DOG", "BIRD"};

        System.out.println(validSquare('A'));                  // Expected: 0
        System.out.println(validWord("HELLO"));                // Expected: 0
        System.out.println(validBoard(testBoard));             // Expected: 0
        System.out.println(locateWord("DOG", testDictionary)); // Expected: 0
    }

    /*
     * Question 1 — Valid Square
     *
     * Method line:
     * public static int validSquare(char inputCharacter)
     *
     * Practice return rules:
     * return 0 if inputCharacter is a valid capital letter from 'A' to 'Z'
     * return 1 if inputCharacter is not valid
     */
    public static int validSquare(char inputCharacter)
    {
        if (inputCharacter >= 'A' && inputCharacter <= 'Z')
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /*
     * Question 2 — Valid Word
     *
     * Method line:
     * public static int validWord(String word)
     *
     * Practice return rules:
     * return 0 if the word is valid
     * return 1 if the word is null
     * return 2 if the word is empty
     * return 3 if the word contains any character not between 'A' and 'Z'
     */
    public static int validWord(String word)
    {
        if (word == null)
        {
            return 1;
        }

        if (word.length() == 0)
        {
            return 2;
        }

        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) < 'A' || word.charAt(i) > 'Z')
            {
                return 3;
            }
        }

        return 0;
    }

    /*
     * Question 3 — Valid Board
     *
     * Method line:
     * public static int validBoard(char[][] board)
     *
     * Practice return rules:
     * return 0 if the board is valid
     * return 1 if the board is null
     * return 2 if the board is too small
     * return 3 if the board is not square
     * return 4 if the board contains any invalid character
     * return 5 if any row is null
     */
    public static int validBoard(char[][] board)
    {
        if (board == null)
        {
            return 1;
        }

        if (board.length <= 0)
        {
            return 2;
        }

        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == null)
            {
                return 5;
            }

            if (board[i].length != board.length)
            {
                return 3;
            }

            for (int j = 0; j < board[i].length; j++)
            {
                if (validSquare(board[i][j]) != 0)
                {
                    return 4;
                }
            }
        }

        return 0;
    }

    /*
     * Question 4 — Valid Dictionary
     *
     * Write this method:
     * public static int validDictionary(char[][] board, String[] dictionary)
     *
     * Practice return rules:
     * return 0 if the dictionary is valid
     * return 1 if the dictionary is null
     * return 2 if the dictionary is too small / empty
     * return 3 if the board is invalid
     * return 4 if the dictionary contains an invalid word
     * return 5 if the dictionary contains a word too big for the board
     *
     * A valid dictionary must:
     * - not be null
     * - not be empty
     * - be used with a valid board
     * - contain only valid words
     * - contain no word longer than the board size
     *
     * You should use these helper methods:
     * - validBoard(board)
     * - validWord(dictionary[i])
     */
    public static int validDictionary(char[][] board, String[] dictionary)
    {
        if(board == null){
            return 1;
        }
        if(board.length <= 1){
            return 2;
        }


        return -1;
    }

    /*
     * Question 5 — Locate Word
     *
     * Method line:
     * public static int locateWord(String word, String[] dictionary)
     *
     * Practice return rules:
     * return 0 if the word appears in the dictionary
     * return 1 if the word is null
     * return 2 if the word is empty
     * return 3 if the dictionary is null
     * return 4 if the dictionary is empty
     * return 5 if the word does not appear in the dictionary
     */
    public static int locateWord(String word, String[] dictionary)
    {
        if (word == null)
        {
            return 1;
        }

        if (word.equals(""))
        {
            return 2;
        }

        if (dictionary == null)
        {
            return 3;
        }

        if (dictionary.length == 0)
        {
            return 4;
        }

        for (int i = 0; i < dictionary.length; i++)
        {
            if (dictionary[i].equals(word))
            {
                return 0;
            }
        }

        return 5;
    }

    /*
     * Question 6 — Find Word
     *
     * Method line:
     * public static int findWord(String word, char[][] board, int startRow, int startCol)
     *
     * You have not written this answer yet.
     */
    public static int findWord(String word, char[][] board, int startRow, int startCol)
    {
        // TODO: Write this method later.
        return -1;
    }

    /*
     * Question 7 — Count Dictionary
     *
     * Method line:
     * public static int[] countDictionary(char[][] board, String[] dictionary)
     *
     * You have not written this answer yet.
     */
    public static int[] countDictionary(char[][] board, String[] dictionary)
    {
        // TODO: Write this method later.
        return null;
    }
}
