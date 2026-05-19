import java.util.ArrayList;

public class Programming_Aplications_exam_QS_5 {

    public static void main(String[] args)
    {
        String[] dictionary = {"CAT", "DOG", "BIRD"};
        String[] repeatedDictionary = {"CAT", "DOG", "CAT", "BIRD"};
        String[] emptyDictionary = {};

        ArrayList<String> arrayListDictionary = new ArrayList<String>();
        arrayListDictionary.add("CAT");
        arrayListDictionary.add("DOG");
        arrayListDictionary.add("BIRD");

        ArrayList<String> emptyArrayListDictionary = new ArrayList<String>();

        System.out.println("===== Testing locateWord =====");
        System.out.println("locateWord(\"DOG\", dictionary) expected 0, got: "
                + locateWord("DOG", dictionary));
        System.out.println("locateWord(null, dictionary) expected 1, got: "
                + locateWord(null, dictionary));
        System.out.println("locateWord(\"\", dictionary) expected 2, got: "
                + locateWord("", dictionary));
        System.out.println("locateWord(\"DOG\", null) expected 3, got: "
                + locateWord("DOG", null));
        System.out.println("locateWord(\"DOG\", emptyDictionary) expected 4, got: "
                + locateWord("DOG", emptyDictionary));
        System.out.println("locateWord(\"FISH\", dictionary) expected 5, got: "
                + locateWord("FISH", dictionary));

        System.out.println();

        System.out.println("===== Testing locateWordV1 =====");
        System.out.println("locateWordV1(\"DOG\", dictionary) expected true, got: "
                + locateWordV1("DOG", dictionary));
        System.out.println("locateWordV1(\"FISH\", dictionary) expected false, got: "
                + locateWordV1("FISH", dictionary));
        System.out.println("locateWordV1(null, dictionary) expected false, got: "
                + locateWordV1(null, dictionary));
        System.out.println("locateWordV1(\"\", dictionary) expected false, got: "
                + locateWordV1("", dictionary));

        System.out.println();

        System.out.println("===== Testing locateWordV2 =====");
        System.out.println("locateWordV2(\"CAT\", dictionary) expected 0, got: "
                + locateWordV2("CAT", dictionary));
        System.out.println("locateWordV2(\"DOG\", dictionary) expected 1, got: "
                + locateWordV2("DOG", dictionary));
        System.out.println("locateWordV2(\"BIRD\", dictionary) expected 2, got: "
                + locateWordV2("BIRD", dictionary));
        System.out.println("locateWordV2(\"FISH\", dictionary) expected -5, got: "
                + locateWordV2("FISH", dictionary));

        System.out.println();

        System.out.println("===== Testing locateWordV3 =====");
        System.out.println("locateWordV3(\"DOG\", arrayListDictionary) expected 0, got: "
                + locateWordV3("DOG", arrayListDictionary));
        System.out.println("locateWordV3(null, arrayListDictionary) expected 1, got: "
                + locateWordV3(null, arrayListDictionary));
        System.out.println("locateWordV3(\"\", arrayListDictionary) expected 2, got: "
                + locateWordV3("", arrayListDictionary));
        System.out.println("locateWordV3(\"DOG\", null) expected 3, got: "
                + locateWordV3("DOG", null));
        System.out.println("locateWordV3(\"DOG\", emptyArrayListDictionary) expected 4, got: "
                + locateWordV3("DOG", emptyArrayListDictionary));
        System.out.println("locateWordV3(\"FISH\", arrayListDictionary) expected 5, got: "
                + locateWordV3("FISH", arrayListDictionary));

        System.out.println();

        System.out.println("===== Testing countWordInDictionary =====");
        System.out.println("countWordInDictionary(\"CAT\", repeatedDictionary) expected 2, got: "
                + countWordInDictionary("CAT", repeatedDictionary));
        System.out.println("countWordInDictionary(\"DOG\", repeatedDictionary) expected 1, got: "
                + countWordInDictionary("DOG", repeatedDictionary));
        System.out.println("countWordInDictionary(\"FISH\", repeatedDictionary) expected 0, got: "
                + countWordInDictionary("FISH", repeatedDictionary));
        System.out.println("countWordInDictionary(null, repeatedDictionary) expected -1, got: "
                + countWordInDictionary(null, repeatedDictionary));
        System.out.println("countWordInDictionary(\"\", repeatedDictionary) expected -2, got: "
                + countWordInDictionary("", repeatedDictionary));
        System.out.println("countWordInDictionary(\"CAT\", null) expected -3, got: "
                + countWordInDictionary("CAT", null));
        System.out.println("countWordInDictionary(\"CAT\", emptyDictionary) expected -4, got: "
                + countWordInDictionary("CAT", emptyDictionary));
    }

    /*
     * Question 5 — Locate Word
     *
     * Write a method that checks whether a given word appears in a dictionary.
     *
     * Return:
     * 0 if the word appears in the dictionary
     * 1 if the word is null
     * 2 if the word is empty
     * 3 if the dictionary is null
     * 4 if the dictionary is empty
     * 5 if the word does not appear in the dictionary
     */
    public static int locateWord(String word, String[] dictionary)
    {
        // word null check
        if(word == null){
            return 1;
        }
        // word empty check
        if (word.isEmpty()){
            return 2;
        }
        // dict null check
        if (dictionary == null){
            return 3;
        }
        // dict empty check
        if (dictionary.length == 0){
            return 4;
        }

        for(int i = 0; i < dictionary.length; i++){
            if (word.equals(dictionary[i])){
                return 0;
            }
        }
        // not in dict
        return 5;
    }

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


    /*
     * Question 5 Variation — Locate Word Boolean
     *
     * Write a method that checks whether a given word appears in a dictionary.
     *
     * Return:
     * true if the word appears in the dictionary
     * false if the word does not appear, or if the input is invalid
     */
    public static boolean locateWordV1(String word, String[] dictionary)
    {
        // word null check
        if(word == null){
            return false;
        }
        // word empty check
        if (word.isEmpty()){
            return false;
        }
        // dict null check
        if (dictionary == null){
            return false;
        }
        // dict empty check
        if (dictionary.length == 0){
            return false;
        }

        for(int i = 0; i < dictionary.length; i++){
            if (word.equals(dictionary[i])){
                return true;
            }
        }
        // not in dict
        return false;
    }

    /*
     * Question 5 Variation — Locate Word Index
     *
     * Write a method that finds the position of a word in the dictionary.
     *
     * Return:
     * index position if the word appears in the dictionary
     * -1 if the word is null
     * -2 if the word is empty
     * -3 if the dictionary is null
     * -4 if the dictionary is empty
     * -5 if the word does not appear in the dictionary
     *
     * Example:
     * dictionary = {"CAT", "DOG", "BIRD"}
     * locateWordV2("DOG", dictionary) returns 1
     */
    public static int locateWordV2(String word, String[] dictionary)
    {
        // word null check
        if(word == null){
            return -1;
        }
        // word empty check
        if (word.isEmpty()){
            return -2;
        }
        // dict null check
        if (dictionary == null){
            return -3;
        }
        // dict empty check
        if (dictionary.length == 0){
            return -4;
        }

        for(int i = 0; i < dictionary.length; i++){
            if (word.equals(dictionary[i])){
                return i;
            }
        }
        // not in dict
        return -5;
    }

    /*
     * Question 5 Hard Variation — Locate Word in ArrayList
     *
     * Write a method that checks whether a given word appears in an ArrayList dictionary.
     *
     * Return:
     * 0 if the word appears in the dictionary
     * 1 if the word is null
     * 2 if the word is empty
     * 3 if the dictionary is null
     * 4 if the dictionary is empty
     * 5 if the word does not appear in the dictionary
     */
    public static int locateWordV3(String word, ArrayList<String> dictionary)
    {
        // word null check
        if(word == null){
            return 1;
        }
        // word empty check
        if (word.isEmpty()){
            return 2;
        }
        // dict null check
        if (dictionary == null){
            return 3;
        }
        // dict empty check
        if (dictionary.size() == 0){
            return 4;
        }

        for(int i = 0; i < dictionary.size(); i++){
            if (word.equals(dictionary.get(i))){
                return 0;
            }
        }
        // not in dict
        return 5;
    }

    /*
     * Question 5 Hard Variation — Count Word Occurrences
     *
     * Write a method that counts how many times a word appears in the dictionary.
     *
     * Return:
     * -1 if the word is null
     * -2 if the word is empty
     * -3 if the dictionary is null
     * -4 if the dictionary is empty
     * otherwise return the number of times the word appears
     *
     * Example:
     * dictionary = {"CAT", "DOG", "CAT", "BIRD"}
     * countWordInDictionary("CAT", dictionary) returns 2
     */
    public static int countWordInDictionary(String word, String[] dictionary)
    {
        // word null check
        if(word == null){
            return -1;
        }
        // word empty check
        if (word.isEmpty()){
            return -2;
        }
        // dict null check
        if (dictionary == null){
            return -3;
        }
        // dict empty check
        if (dictionary.length == 0){
            return -4;
        }

        int count = 0;
        for(int i = 0; i < dictionary.length; i++){
            if(word.equals(dictionary[i])){
                count++;
            }
        }
        return count;
    }

}
