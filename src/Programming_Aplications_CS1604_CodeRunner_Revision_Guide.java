public class Programming_Aplications_CS1604_CodeRunner_Revision_Guide {
    public static void main(String[] args)
    {
        /*
         * Use this file as a revision/reference guide.
         * In the real CodeRunner exam, DO NOT paste this whole class.
         * CodeRunner usually wants only the method being asked for and any helper methods it uses.
         */
    }

    /*
     ====================================================================================================
     CS1604 PROGRAMMING APPLICATIONS CODERUNNER REVISION GUIDE
     ====================================================================================================

     MAIN ASSESSMENT IDEA
     ----------------------------------------------------------------------------------------------------
     The assessment is based on a Word Search game.

     The board:
     - is square: n x n
     - is stored as a 2D array, usually char[][]
     - contains only capital letters from 'A' to 'Z'

     The dictionary:
     - stores valid words
     - usually uses String[] or possibly ArrayList<String>
     - words must contain only capital letters from 'A' to 'Z'

     Valid word directions:
     - vertical down
     - horizontal left-to-right
     - diagonal down-right
     - diagonal up-right

     The seven questions build on each other:

     Q1: Check one character
     Q2: Check one word
     Q3: Check the board
     Q4: Check the dictionary
     Q5: Check if a word is inside the dictionary
     Q6: Check if a word appears from one start position
     Q7: Count all dictionary word appearances across the full board

     IMPORTANT CODERUNNER RULE
     ----------------------------------------------------------------------------------------------------
     In your IDE, you can use:
     - public class Main
     - public static void main(String[] args)
     - print statements for testing

     In CodeRunner, you usually submit:
     - only the required method
     - plus any helper methods it calls

     Do NOT submit:
     - the class wrapper
     - the main method
     - test print statements

     If Q7 calls countDirectionsFromStart(),
     and countDirectionsFromStart() calls validWord(), validBoard(), and validSquare(),
     then the Q7 CodeRunner submission must include all of those helper methods too.

     GENERAL JAVA TECHNIQUES TO KNOW
     ----------------------------------------------------------------------------------------------------

     1. Primitive types cannot be null:

        int
        char
        double
        boolean

        Invalid:
        int number = null;
        char letter = null;

     2. Object/reference types can be null:

        String
        arrays
        ArrayList
        objects

        Valid:
        String word = null;
        char[][] board = null;
        ArrayList<String> dictionary = null;

     3. Length / size differences:

        Array:
        array.length

        String:
        word.length()

        ArrayList:
        list.size()

     4. Accessing values:

        Array:
        array[i]

        2D array:
        board[row][col]

        String character:
        word.charAt(i)

        ArrayList:
        list.get(i)

     5. String comparison:

        Correct:
        word.equals(otherWord)

        Wrong for text comparison:
        word == otherWord

        Reason:
        == compares memory reference.
        .equals() compares the actual text.

     6. Setting vs accumulating:

        Use = when setting/replacing a value:
        count = wordCount;

        Use += when adding to a total:
        count += wordCount;

        Q7 usually needs += because you are adding counts from many board positions.

     ====================================================================================================
     Q1 — VALID SQUARE
     ====================================================================================================

     WHAT Q1 TESTS
     ----------------------------------------------------------------------------------------------------
     Q1 checks whether one character is valid.

     A valid square is:
     'A' to 'Z'

     Main method style:
     public static int validSquare(char inputCharacter)

     Typical return rules:
     return 0 if valid
     return 1 if invalid

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     inputCharacter >= 'A' && inputCharacter <= 'Z'

     THINGS TO LOOK OUT FOR
     ----------------------------------------------------------------------------------------------------
     Do NOT rely on Character.isLetter(inputCharacter) for the original question.

     Why?
     Because Character.isLetter() can accept lowercase letters or non-English letters.
     The exam wants exactly capital letters from 'A' to 'Z'.

     CHAR RULES
     ----------------------------------------------------------------------------------------------------
     A char cannot be null.
     A char cannot be empty.
     A char can be a space.

     Valid char examples:
     'A'
     'Z'
     ' '
     '1'
     '#'

     Invalid Java:
     ''

     Invalid check:
     inputCharacter == null

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Return values may be swapped:
        return 1 if valid
        return 0 if invalid

     2. Boolean version:
        public static boolean validSquare(char inputCharacter)

     3. More detailed invalid checks:
        uppercase = one return value
        lowercase = another return value
        digit = another return value
        symbol/space = another return value

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Q1 is easy, but return values may change.
     Always read the return table carefully.

     ====================================================================================================
     Q2 — VALID WORD
     ====================================================================================================

     WHAT Q2 TESTS
     ----------------------------------------------------------------------------------------------------
     Q2 checks whether a String is a valid word.

     A valid word must:
     - not be null
     - not be empty
     - contain only capital letters from 'A' to 'Z'

     Main method style:
     public static int validWord(String word)

     Typical return rules:
     return 0 if valid
     return 1 if word is null
     return 2 if word is empty
     return 3 if word contains an invalid character

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Check null first
     2. Check empty second
     3. Loop through every character
     4. Check each character using 'A' to 'Z' logic or validSquare()
     5. Return valid at the end

     IMPORTANT ORDER
     ----------------------------------------------------------------------------------------------------
     Correct:
     if (word == null)
     if (word.length() == 0)

     Wrong:
     if (word.length() == 0)
     if (word == null)

     Reason:
     If word is null, word.length() crashes.

     JAVA TECHNIQUES
     ----------------------------------------------------------------------------------------------------
     Null check:
     word == null

     Empty check:
     word.length() == 0

     Alternative empty check:
     word.isEmpty()

     Loop through String:
     for (int i = 0; i < word.length(); i++)

     Get character:
     word.charAt(i)

     COMMON MISTAKES
     ----------------------------------------------------------------------------------------------------
     Wrong:
     word[i]

     Correct:
     word.charAt(i)

     Wrong:
     word == ""

     Better:
     word.length() == 0
     or
     word.equals("")

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Boolean valid word:
        public static boolean validWord(String word)

     2. Different return values:
        return 1 if valid
        return -1 if null
        return -2 if empty
        return -3 if invalid character

     3. Detailed invalid character:
        lowercase gets one return value
        digit gets another return value
        symbol/space gets another return value

     4. Count invalid characters:
        return number of invalid characters
        return special values for null/empty

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Calling word.length(), word.isEmpty(), or word.charAt(i) before checking word == null.

     ====================================================================================================
     Q3 — VALID BOARD
     ====================================================================================================

     WHAT Q3 TESTS
     ----------------------------------------------------------------------------------------------------
     Q3 checks whether a board is valid.

     Board is usually:
     char[][] board

     A valid board must:
     - not be null
     - not be empty
     - have no null rows
     - be square
     - contain only capital letters from 'A' to 'Z'

     Main method style:
     public static int validBoard(char[][] board)

     Typical return rules:
     return 0 if valid
     return 1 if board is null
     return 2 if board is empty / too small
     return 3 if board is not square
     return 4 if board contains an invalid character
     return 5 if any row is null

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Check board null
     2. Check board length is not 0
     3. Store board length
     4. Loop through rows
     5. Check each row is not null
     6. Check each row length equals board length
     7. Loop through each character
     8. Check each character with validSquare()
     9. Return valid

     JAVA TECHNIQUES
     ----------------------------------------------------------------------------------------------------
     Number of rows:
     board.length

     Row length:
     board[i].length

     One character:
     board[i][j]

     Arrays use:
     .length

     Strings use:
     .length()

     SQUARE CHECK
     ----------------------------------------------------------------------------------------------------
     A board is square if:

     number of rows == number of columns in every row

     Pattern:
     board[i].length != board.length

     If true, board is not square.

     IMPORTANT ORDER
     ----------------------------------------------------------------------------------------------------
     Check row null before checking row length.

     Correct:
     if (board[i] == null)
     if (board[i].length != board.length)

     Wrong:
     if (board[i].length != board.length)
     if (board[i] == null)

     Reason:
     If board[i] is null, board[i].length crashes.

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Boolean validBoard:
        public static boolean validBoard(char[][] board)

     2. Different return values:
        valid = 1
        null = -1
        empty = -2
        not square = -3
        invalid character = -4
        null row = -5

     3. Count invalid squares:
        return number of invalid characters in the board

     4. Board stored as String[]:
        public static int validBoard(String[] board)

        In that case:
        board[i].length()
        board[i].charAt(j)

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Mixing up:

     array.length
     String.length()
     ArrayList.size()

     ====================================================================================================
     Q4 — VALID DICTIONARY
     ====================================================================================================

     WHAT Q4 TESTS
     ----------------------------------------------------------------------------------------------------
     Q4 checks whether a dictionary is valid for a given board.

     Dictionary is usually:
     String[] dictionary

     A valid dictionary must:
     - not be null
     - not be empty
     - be used with a valid board
     - contain only valid words
     - contain no word longer than the board size

     Main method style:
     public static int validDictionary(char[][] board, String[] dictionary)

     Typical return rules:
     return 0 if dictionary is valid
     return 1 if dictionary is null
     return 2 if dictionary is empty / too small
     return 3 if board is invalid
     return 4 if dictionary contains an invalid word
     return 5 if dictionary contains a word too long for the board

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Check dictionary null
     2. Check dictionary empty
     3. Check validBoard(board)
     4. Store board length
     5. Loop through dictionary
     6. Check validWord(dictionary[i])
     7. Check dictionary[i].length() <= board length
     8. Return valid

     HELPER METHODS
     ----------------------------------------------------------------------------------------------------
     validBoard(board)
     validWord(dictionary[i])

     IMPORTANT ORDER
     ----------------------------------------------------------------------------------------------------
     Check validWord(dictionary[i]) before dictionary[i].length().

     Reason:
     If dictionary[i] is null, validWord catches it safely.
     If you call dictionary[i].length() first, it crashes.

     JAVA TECHNIQUES
     ----------------------------------------------------------------------------------------------------
     String array:
     dictionary.length
     dictionary[i]

     ArrayList<String>:
     dictionary.size()
     dictionary.get(i)

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Boolean valid dictionary:
        public static boolean validDictionary(char[][] board, String[] dictionary)

     2. ArrayList dictionary:
        public static int validDictionary(char[][] board, ArrayList<String> dictionary)

     3. Count invalid dictionary words:
        return how many words are invalid

     4. Duplicate check:
        return error if dictionary contains duplicate words

     DUPLICATE CHECK PATTERN
     ----------------------------------------------------------------------------------------------------
     for i
         for j = i + 1
             compare dictionary[i] and dictionary[j]

     Use .equals() for String comparison.

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Looping over the wrong length.

     Wrong for ArrayList dictionary:
     for (int i = 0; i < board.length; i++)

     Correct:
     for (int i = 0; i < dictionary.size(); i++)

     ====================================================================================================
     Q5 — LOCATE WORD
     ====================================================================================================

     WHAT Q5 TESTS
     ----------------------------------------------------------------------------------------------------
     Q5 checks whether a given word appears inside the dictionary.

     Main method style:
     public static int locateWord(String word, String[] dictionary)

     Typical return rules:
     return 0 if word appears
     return 1 if word is null
     return 2 if word is empty
     return 3 if dictionary is null
     return 4 if dictionary is empty
     return 5 if word does not appear

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Check word null
     2. Check word empty
     3. Check dictionary null
     4. Check dictionary empty
     5. Loop through dictionary
     6. Compare word to dictionary[i] using .equals()
     7. Return found / not found

     JAVA TECHNIQUES
     ----------------------------------------------------------------------------------------------------
     Correct String comparison:
     word.equals(dictionary[i])

     Do not use:
     word == dictionary[i]

     WHY word.equals(dictionary[i]) IS SAFE
     ----------------------------------------------------------------------------------------------------
     You already checked word is not null.
     So even if dictionary[i] is null, word.equals(dictionary[i]) will not crash.
     It will just return false.

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Boolean version:
        public static boolean locateWord(String word, String[] dictionary)

     2. Return index:
        return the index where the word appears
        return negative values for errors/not found

     3. ArrayList version:
        public static int locateWord(String word, ArrayList<String> dictionary)

     4. Count word occurrences in dictionary:
        return how many times the word appears in the dictionary

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Using == instead of .equals().

     ====================================================================================================
     Q6 — FIND WORD
     ====================================================================================================

     WHAT Q6 TESTS
     ----------------------------------------------------------------------------------------------------
     Q6 checks whether one word appears on the board from one starting position.

     Main method style:
     public static int findWord(String word, char[][] board, int startRow, int startCol)

     Typical return rules:
     return 0 if found vertically down
     return 1 if found horizontally left-to-right
     return 2 if found diagonally down-right
     return 3 if found diagonally up-right
     return 4 if not found
     return 5 if word is invalid
     return 6 if board is invalid
     return 7 if start coordinates are out of bounds

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Check validWord(word)
     2. Check validBoard(board)
     3. Check startRow and startCol are in bounds
     4. Check vertical down
     5. Check horizontal right
     6. Check diagonal down-right
     7. Check diagonal up-right
     8. Return not found

     DIRECTION FORMULAS
     ----------------------------------------------------------------------------------------------------
     Vertical down:
     board[startRow + i][startCol]

     Horizontal right:
     board[startRow][startCol + i]

     Diagonal down-right:
     board[startRow + i][startCol + i]

     Diagonal up-right:
     board[startRow - i][startCol + i]

     FIT CHECKS
     ----------------------------------------------------------------------------------------------------
     Vertical down fits if:
     startRow + word.length() <= board.length

     Horizontal right fits if:
     startCol + word.length() <= board.length

     Diagonal down-right fits if:
     startRow + word.length() <= board.length
     &&
     startCol + word.length() <= board.length

     Diagonal up-right fits if:
     startRow - (word.length() - 1) >= 0
     &&
     startCol + word.length() <= board.length

     OUT OF BOUNDS CHECK
     ----------------------------------------------------------------------------------------------------
     startRow < 0
     startRow >= board.length
     startCol < 0
     startCol >= board[0].length

     Because validBoard() confirms the board is square, board[0].length is safe after validBoard passes.

     BOOLEAN SEARCH PATTERN
     ----------------------------------------------------------------------------------------------------
     boolean found = true;

     loop through letters:
         if mismatch:
             found = false;
             break;

     after loop:
         if found:
             return direction code;

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. Boolean version:
        return true if found in any direction

     2. String direction version:
        return "VERTICAL"
        return "HORIZONTAL"
        return "DIAGONAL_DOWN"
        return "DIAGONAL_UP"
        return "NOT_FOUND"

     3. Coordinate array:
        public static int findWord(String word, char[][] board, int[] startPosition)

        startPosition[0] = row
        startPosition[1] = column

        Need to check:
        startPosition == null
        startPosition.length == 2

     4. Count directions from one start:
        return how many directions contain the word from this one starting position

     MAIN DANGER
     ----------------------------------------------------------------------------------------------------
     Q6 returns a direction code, not a count.

     Example:
     0 = vertical
     1 = horizontal
     2 = diagonal down
     3 = diagonal up
     4 = not found

     Do not treat these numbers as word counts in Q7.

     ====================================================================================================
     Q7 — COUNT DICTIONARY
     ====================================================================================================

     WHAT Q7 TESTS
     ----------------------------------------------------------------------------------------------------
     Q7 counts how many times each dictionary word appears on the board.

     Main method style:
     public static int[] countDictionary(char[][] board, String[] dictionary)

     The question usually assumes:
     - board is valid
     - dictionary is valid

     Return:
     an int[] or list where each index matches the dictionary index.

     Example:
     dictionary[0] = "CAT"
     dictionary[1] = "DOG"

     If CAT appears 2 times and DOG appears 1 time:
     return {2, 1}

     CORE PATTERN
     ----------------------------------------------------------------------------------------------------
     1. Create result array/list
     2. Loop through every dictionary word
     3. Loop through every board row
     4. Loop through every board column
     5. Count how many directions contain that word from that square
     6. Add that count to the correct dictionary index
     7. Return result

     STRONGEST HELPER METHOD
     ----------------------------------------------------------------------------------------------------
     Use:
     countDirectionsFromStart(word, board, row, col)

     Better than:
     findWord(word, board, row, col)

     Why?
     findWord() stops after the first direction.
     Q7 says "how many times", so the safer version counts every valid direction occurrence.

     CORRECT ACCUMULATION
     ----------------------------------------------------------------------------------------------------
     For int[] result:
     result[i] += wordCount;

     Do NOT use:
     result[i] = wordCount;

     Reason:
     = overwrites previous counts.
     += adds counts from all board positions.

     ARRAYLIST RESULT PATTERN
     ----------------------------------------------------------------------------------------------------
     If return type is ArrayList<Integer>:

     for each dictionary word:
         int count = 0;
         scan whole board
         count += countDirectionsFromStart(...)
         result.add(count);

     Do NOT add to the ArrayList inside the row/column loop.
     That creates too many result entries.

     LIKELY VARIATIONS
     ----------------------------------------------------------------------------------------------------
     1. int[] result with String[] dictionary:
        public static int[] countDictionary(char[][] board, String[] dictionary)

     2. ArrayList<Integer> result:
        public static ArrayList<Integer> countDictionary(char[][] board, String[] dictionary)

     3. ArrayList<String> dictionary:
        public static int[] countDictionary(char[][] board, ArrayList<String> dictionary)

     4. Count one word:
        public static int countOneWord(char[][] board, String word)

     5. Count total dictionary words:
        public static int countTotalDictionaryWords(char[][] board, String[] dictionary)

     MAIN DANGERS
     ----------------------------------------------------------------------------------------------------
     1. Adding direction codes instead of counts.

        Wrong:
        result[i] += findWord(word, board, row, col);

        Why wrong?
        findWord returns 0, 1, 2, 3, or 4 as direction/status codes.
        Those are not counts.

     2. Using = instead of +=.

        Wrong inside board loops:
        result[i] = wordCount;

        Correct:
        result[i] += wordCount;

     3. ArrayList add in wrong place.

        Wrong:
        result.add(wordCount) inside row/column loop.

        Correct:
        result.add(totalCountForThisWord) after scanning the full board for that word.

     4. Only counting one direction from a start square.

        A word can appear in multiple directions from the same starting square.
        Example board:

        A A A
        A A X
        A X A

        Word "AAA" appears multiple times, including multiple directions from the same start.

     Q7 TEST CASES TO CHECK YOUR CODE
     ----------------------------------------------------------------------------------------------------

     Test 1: word not found
     Expected: {0}

     Test 2: one horizontal word
     Expected: {1}

     Test 3: one vertical word
     Expected: {1}

     Test 4: one diagonal down-right word
     Expected: {1}

     Test 5: one diagonal up-right word
     Expected: {1}

     Test 6: multiple dictionary words
     Expected example: {1, 1, 0}

     Test 7: repeated word in different places
     Expected example: {2}

     Test 8: multiple directions from same start
     Board:
     A A A
     A A X
     A X A

     Dictionary:
     {"AAA"}

     Expected:
     {4}

     Test 9: harder combined test
     Board:
     A A A
     A A X
     A X A

     Dictionary:
     {"AAA", "AA", "AXA", "DOG"}

     Expected:
     {4, 11, 2, 0}

     ====================================================================================================
     FINAL EXAM CHECKLIST
     ====================================================================================================

     Before writing code, ask:

     1. What is the exact method signature?
     2. What is the return type?
     3. What are the exact return values?
     4. Does the question require validation?
     5. Can I reuse earlier helper methods?
     6. If I call helper methods, have I included them in my CodeRunner submission?
     7. Am I using .length, .length(), or .size() correctly?
     8. Am I comparing Strings with .equals()?
     9. Am I setting a value with = or accumulating with +=?
     10. Am I returning the correct type?
     11. Am I submitting only methods, not class/main?

     PRIORITY REVISION ORDER
     ----------------------------------------------------------------------------------------------------
     If short on time:

     Priority 1:
     - Q1 valid character
     - Q2 valid word
     - Q3 valid board
     - Q6 direction formulas
     - Q7 counting pattern

     Priority 2:
     - Q4 dictionary validation
     - Q5 locate word
     - ArrayList variations
     - String[] board variation

     Priority 3:
     - duplicate dictionary words
     - count invalid words
     - count invalid board squares
     - coordinate array variation
     - total count variation

     CODERUNNER SURVIVAL RULES
     ----------------------------------------------------------------------------------------------------
     - Read return values carefully.
     - Exact return values may change.
     - Do not use AI/chat/tools during the exam.
     - Test in Eclipse/IDE before submitting/checking.
     - Use checks carefully.
     - Include all helper methods needed for each question.
     - Do not include class or main in CodeRunner submission unless explicitly asked.
     - No print statements in final CodeRunner answers.
     - CodeRunner marks outputs, not intentions.
     - Hard test cases expose hidden mistakes.
     */
}
