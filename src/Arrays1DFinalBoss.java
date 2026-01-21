import java.util.Arrays;
public class Arrays1DFinalBoss {

    /*
=====================================================
JAVA ARRAYS (1D) – FULL EXAM CHEAT SHEET (CS1603 STYLE)
=====================================================

RULES / MENTAL MODEL (read once):
- An array is a FIXED-SIZE block of memory holding SAME-TYPE values.
- Indexing starts at 0.
- last index = arr.length - 1
- If you go outside bounds → ArrayIndexOutOfBoundsException
- If array is null → NullPointerException when you access .length or arr[i]

-----------------------------------------------------
CONTENTS (by glance)
-----------------------------------------------------
A) Declaring + Initialising (ALL ways)
B) Direct Indexing + Updates
C) Looping (for / enhanced for) + common patterns
D) Copying arrays (reference vs clone vs Arrays.copyOf)
E) Adding / Removing / Shifting (manual techniques)
F) Searching (linear + binary) + Arrays.binarySearch
G) Sorting (Arrays.sort) + custom sorts (primitive vs objects)
H) Useful Arrays utilities (fill, equals, toString, copyOfRange)
I) Common exam snippets (rotate, reverse, max/min, frequency, insert/remove)
J) Common mistakes / heads-up (exam traps)

You can paste this file directly into IntelliJ.
Everything is in methods so you can run parts if you want.
*/



        public static void main(String[] args) {
            // Uncomment to test sections quickly:
            // sectionA_initialisationExamples();
            // sectionB_indexingExamples();
            // sectionC_loopingPatterns();
            // sectionD_copying();
            // sectionE_addRemoveShift();
            // sectionF_searching();
            // sectionG_sorting();
            // sectionH_arraysUtilities();
            // sectionI_examSnippets();
            // sectionJ_commonMistakes();
        }

    /* =====================================================
       A) DECLARING + INITIALISING (ALL ways)
       ===================================================== */

        public static void sectionA_initialisationExamples() {

            // 1) Declare then allocate size (all values default)
            int[] a = new int[5];          // {0,0,0,0,0}
            double[] b = new double[3];    // {0.0,0.0,0.0}
            boolean[] c = new boolean[4];  // {false,false,false,false}
            char[] d = new char[3];        // {'\u0000','\u0000','\u0000'} (null char)
            String[] e = new String[2];    // {null, null}

            System.out.println("int[] defaults: " + Arrays.toString(a));
            System.out.println("double[] defaults: " + Arrays.toString(b));
            System.out.println("boolean[] defaults: " + Arrays.toString(c));
            System.out.println("char[] defaults: " + Arrays.toString(d));
            System.out.println("String[] defaults: " + Arrays.toString(e));

            // 2) Declare + initialise with values (array literal)
            int[] marks = {70, 55, 90};
            String[] names = {"Fred", "Jo", "Zoe"};
            char[] letters = {'A', 'B', 'C'};

            System.out.println("marks: " + Arrays.toString(marks));
            System.out.println("names: " + Arrays.toString(names));
            System.out.println("letters: " + Arrays.toString(letters));

            // 3) Using 'new type[] { ... }' (common in method calls)
            int[] numbers = new int[]{10, 20, 30, 40};
            System.out.println("numbers: " + Arrays.toString(numbers));

            // 4) Create and fill using loop
            int n = 6;
            int[] squares = new int[n];
            for (int i = 0; i < squares.length; i++) {
                squares[i] = (i + 1) * (i + 1);
            }
            System.out.println("squares: " + Arrays.toString(squares));

            // 5) Create from String by parsing
            String[] raw = {"10", "  20 ", "xyz", "", "5"};
            int[] parsed = parseIntArrayOrZero(raw);
            System.out.println("parsed (invalid -> 0): " + Arrays.toString(parsed));
        }

        private static int[] parseIntArrayOrZero(String[] raw) {
            if (raw == null) {
                return null;
            }
            int[] out = new int[raw.length];

            for (int i = 0; i < raw.length; i++) {
                String s = raw[i];
                if (s == null) {
                    out[i] = 0;
                } else {
                    s = s.trim();
                    try {
                        out[i] = Integer.parseInt(s);
                    } catch (Exception ex) {
                        out[i] = 0;
                    }
                }
            }
            return out;
        }

    /* =====================================================
       B) DIRECT INDEXING + UPDATES
       ===================================================== */

        public static void sectionB_indexingExamples() {
            int[] data = {10, 20, 30, 40, 50};

            // Direct indexing (read)
            int first = data[0];                  // 10
            int last = data[data.length - 1];     // 50

            System.out.println("first = " + first);
            System.out.println("last  = " + last);

            // Update an element
            data[2] = 999; // change 30 -> 999
            System.out.println("after update: " + Arrays.toString(data));

            // Swap two positions (exam common)
            swap(data, 1, 3); // swap 20 and 40
            System.out.println("after swap: " + Arrays.toString(data));

            // Heads-up: invalid index throws exception
            // int bad = data[5]; // ArrayIndexOutOfBoundsException
        }

        private static void swap(int[] arr, int i, int j) {
            if (arr == null) {
                return;
            }
            if (i < 0 || i >= arr.length) {
                return;
            }
            if (j < 0 || j >= arr.length) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    /* =====================================================
       C) LOOPING THROUGH ARRAYS (ALL patterns)
       ===================================================== */

        public static void sectionC_loopingPatterns() {
            int[] data = {3, 7, 2, 9, 7};

            // 1) Standard for loop (best when you need the index)
            for (int i = 0; i < data.length; i++) {
                System.out.println("index " + i + " value " + data[i]);
            }

            // 2) Enhanced for loop (for-each)
            // Good for reading values, but you do NOT get the index easily.
            for (int x : data) {
                System.out.println("value " + x);
            }

            // 3) Reverse loop (exam common)
            for (int i = data.length - 1; i >= 0; i--) {
                System.out.println("reverse value " + data[i]);
            }

            // 4) Sum / average pattern
            int sum = 0;
            for (int i = 0; i < data.length; i++) {
                sum += data[i];
            }
            double avg = 0.0;
            if (data.length > 0) {
                avg = (double) sum / data.length;
            }
            System.out.println("sum=" + sum + " avg=" + avg);

            // 5) Count a value pattern
            int target = 7;
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == target) {
                    count++;
                }
            }
            System.out.println("count of 7 = " + count);

            // 6) Find first match index pattern
            int firstIndex = indexOf(data, 9);
            System.out.println("indexOf(9) = " + firstIndex);

            // 7) Build a new transformed array pattern
            int[] doubled = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                doubled[i] = data[i] * 2;
            }
            System.out.println("doubled: " + Arrays.toString(doubled));
        }

        private static int indexOf(int[] arr, int value) {
            if (arr == null) {
                return -1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    return i;
                }
            }
            return -1;
        }

    /* =====================================================
       D) COPYING ARRAYS (REFERENCE vs CLONE vs copyOf)
       ===================================================== */

        public static void sectionD_copying() {
            int[] a = {1, 2, 3};

            // 1) This is NOT a copy: both refer to same array
            int[] b = a;
            b[0] = 999;
            System.out.println("a after b change: " + Arrays.toString(a)); // [999,2,3]

            // 2) clone() makes a new array (shallow copy, fine for primitives)
            int[] c = a.clone();
            c[0] = 111;
            System.out.println("a: " + Arrays.toString(a));
            System.out.println("c: " + Arrays.toString(c));

            // 3) Arrays.copyOf
            int[] d = Arrays.copyOf(a, a.length);
            System.out.println("d: " + Arrays.toString(d));

            // 4) Arrays.copyOfRange (end is exclusive)
            int[] middle = Arrays.copyOfRange(a, 1, 3); // indices 1..2
            System.out.println("middle: " + Arrays.toString(middle));
        }

    /* =====================================================
       E) ADD / REMOVE / SHIFT (MANUAL – arrays are fixed size)
       ===================================================== */

        public static void sectionE_addRemoveShift() {
            int[] data = {10, 20, 30, 40};

            // INSERT at index (creates NEW array with +1 size)
            int[] inserted = insertAt(data, 2, 999); // {10,20,999,30,40}
            System.out.println("inserted: " + Arrays.toString(inserted));

            // REMOVE at index (creates NEW array with -1 size)
            int[] removed = removeAt(data, 1); // remove 20 => {10,30,40}
            System.out.println("removed: " + Arrays.toString(removed));

            // SHIFT RIGHT by 1 (within same array, last value lost)
            int[] shiftRight = data.clone();
            shiftRightInPlace(shiftRight);
            System.out.println("shiftRightInPlace: " + Arrays.toString(shiftRight));

            // SHIFT LEFT by 1 (within same array, first value lost)
            int[] shiftLeft = data.clone();
            shiftLeftInPlace(shiftLeft);
            System.out.println("shiftLeftInPlace: " + Arrays.toString(shiftLeft));
        }

        // Insert value at position index, shifting others right
        public static int[] insertAt(int[] arr, int index, int value) {
            if (arr == null) {
                return null;
            }
            if (index < 0) {
                index = 0;
            }
            if (index > arr.length) {
                index = arr.length;
            }

            int[] out = new int[arr.length + 1];

            // copy left part
            for (int i = 0; i < index; i++) {
                out[i] = arr[i];
            }

            // insert
            out[index] = value;

            // copy right part shifted
            for (int i = index; i < arr.length; i++) {
                out[i + 1] = arr[i];
            }

            return out;
        }

        // Remove element at index, shifting others left
        public static int[] removeAt(int[] arr, int index) {
            if (arr == null) {
                return null;
            }
            if (arr.length == 0) {
                return new int[0];
            }
            if (index < 0 || index >= arr.length) {
                // exam-safe choice: return copy of original
                return arr.clone();
            }

            int[] out = new int[arr.length - 1];

            // copy left part
            for (int i = 0; i < index; i++) {
                out[i] = arr[i];
            }

            // copy right part shifted
            for (int i = index + 1; i < arr.length; i++) {
                out[i - 1] = arr[i];
            }

            return out;
        }

        // Shift all values right by 1; arr[0] becomes 0 (or any "empty" value you choose)
        public static void shiftRightInPlace(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            for (int i = arr.length - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = 0; // fill value
        }

        // Shift all values left by 1; arr[last] becomes 0
        public static void shiftLeftInPlace(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0; // fill value
        }

    /* =====================================================
       F) SEARCHING ARRAYS (linear + binary)
       ===================================================== */

        public static void sectionF_searching() {
            int[] data = {40, 10, 50, 20, 30};

            // 1) Linear search (works on any array)
            System.out.println("linear indexOf 20: " + indexOf(data, 20)); // 3

            // 2) Binary search (array MUST be sorted)
            Arrays.sort(data); // now sorted
            System.out.println("sorted: " + Arrays.toString(data));

            int pos = Arrays.binarySearch(data, 20);
            System.out.println("binarySearch 20: " + pos);

            // If not found, binarySearch returns a negative number:
            int notFound = Arrays.binarySearch(data, 999);
            System.out.println("binarySearch 999: " + notFound);

        /*
        Heads-up:
        If result is negative:
        insertionPoint = -(result + 1)
        */
            if (notFound < 0) {
                int insertionPoint = -(notFound + 1);
                System.out.println("insertionPoint for 999: " + insertionPoint);
            }
        }

    /* =====================================================
       G) SORTING ARRAYS (primitive + objects)
       ===================================================== */

        public static void sectionG_sorting() {

            // 1) Sorting primitives
            int[] data = {5, 2, 9, 2, 1};
            Arrays.sort(data);
            System.out.println("sorted int: " + Arrays.toString(data));

            // Sorting doubles
            double[] d = {3.3, -1.2, 5.0, 5.0};
            Arrays.sort(d);
            System.out.println("sorted double: " + Arrays.toString(d));

            // Sorting chars (alphabetical by ASCII)
            char[] letters = {'z', 'A', 'b', 'a'};
            Arrays.sort(letters);
            System.out.println("sorted char: " + Arrays.toString(letters));

            // 2) Sorting Strings (lexicographic)
            String[] names = {"Zoe", "Fred", "Jo", "alice"};
            Arrays.sort(names);
            System.out.println("sorted String: " + Arrays.toString(names));

        /*
        Heads-up:
        - String sort is lexicographic and case-sensitive.
          Uppercase often comes before lowercase due to ASCII/Unicode ordering.
        - For exams, mention it or normalise by toLowerCase() when needed.
        */

            // 3) Custom sort for objects uses Comparator (more advanced, but useful)
            // In many intro exams, you won't need this, but it’s good to recognise:
            // Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        }

    /* =====================================================
       H) USEFUL Arrays UTILITIES (EXAM FRIENDLY)
       ===================================================== */

        public static void sectionH_arraysUtilities() {
            int[] a = new int[5];

            // fill
            Arrays.fill(a, 7);
            System.out.println("fill: " + Arrays.toString(a)); // [7,7,7,7,7]

            // equals (compares contents)
            int[] b = {7, 7, 7, 7, 7};
            System.out.println("equals: " + Arrays.equals(a, b)); // true

            // toString (good for debugging)
            System.out.println("toString: " + Arrays.toString(b));

            // copyOf
            int[] c = Arrays.copyOf(b, b.length + 2); // extends with zeros
            System.out.println("copyOf bigger: " + Arrays.toString(c));

            // copyOfRange
            int[] sub = Arrays.copyOfRange(b, 1, 4);
            System.out.println("copyOfRange: " + Arrays.toString(sub));
        }

    /* =====================================================
       I) COMMON EXAM SNIPPETS (high frequency)
       ===================================================== */

        public static void sectionI_examSnippets() {

            int[] data = {10, 20, 30, 40, 50};

            System.out.println("reverse NEW: " + Arrays.toString(reverseNew(data)));
            System.out.println("rotateRight k=2 NEW: " + Arrays.toString(rotateRight(data, 2)));
            System.out.println("max: " + maxValue(data));
            System.out.println("min: " + minValue(data));

            System.out.println("frequency of 20: " + frequency(data, 20));
            System.out.println("isSorted? " + isSortedAscending(data));

            int[] removedFirst = removeFirstOccurrence(data, 30);
            System.out.println("remove first 30: " + Arrays.toString(removedFirst));
        }

        // Reverse array and RETURN NEW (no side effects)
        public static int[] reverseNew(int[] arr) {
            if (arr == null) {
                return null;
            }
            int[] out = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                out[i] = arr[arr.length - 1 - i];
            }
            return out;
        }

        // Rotate right by k and RETURN NEW (CodeRunner style)
        public static int[] rotateRight(int[] data, int k) {
            if (data == null) {
                return null;
            }
            if (data.length == 0) {
                return new int[0];
            }

            int length = data.length;

            // normalise k (exam standard)
            k = k % length;
            if (k < 0) {
                k += length;
            }

            int[] out = new int[length];

            // newIndex = (oldIndex + k) % length
            for (int i = 0; i < length; i++) {
                int newIndex = (i + k) % length;
                out[newIndex] = data[i];
            }

            return out;
        }

        public static int maxValue(int[] arr) {
            if (arr == null || arr.length == 0) {
                return Integer.MIN_VALUE; // exam-safe sentinel
            }
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

        public static int minValue(int[] arr) {
            if (arr == null || arr.length == 0) {
                return Integer.MAX_VALUE;
            }
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        public static int frequency(int[] arr, int target) {
            if (arr == null) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    count++;
                }
            }
            return count;
        }

        public static boolean isSortedAscending(int[] arr) {
            if (arr == null) {
                return false;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    return false;
                }
            }
            return true;
        }

        // Remove first occurrence of target (NEW array). If not found, return copy.
        public static int[] removeFirstOccurrence(int[] arr, int target) {
            if (arr == null) {
                return null;
            }
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return arr.clone();
            }
            return removeAt(arr, index);
        }

    /* =====================================================
       J) COMMON MISTAKES / HEADS-UP (exam traps)
       ===================================================== */

        public static void sectionJ_commonMistakes() {

            // 1) Using == for arrays compares references, not contents
            int[] a = {1, 2, 3};
            int[] b = {1, 2, 3};

            System.out.println(a == b); // false (different objects)
            System.out.println(Arrays.equals(a, b)); // true (same contents)

            // 2) Printing an array directly prints a memory-like string
            System.out.println(a); // [I@something (not useful)
            System.out.println(Arrays.toString(a)); // [1, 2, 3]

            // 3) Null safety
            int[] c = null;
            // c.length; // NullPointerException

            // 4) Off-by-one
            // for (int i = 0; i <= a.length; i++) { } // ❌ wrong (hits a.length)
            for (int i = 0; i < a.length; i++) { // ✅ correct
                // do something
            }
        }
    }

/*
=====================================================
EXAM QUICK NOTES (read fast)
=====================================================

- Arrays are FIXED SIZE:
  - "Add" or "Remove" means you build a NEW array and copy elements.
- Arrays.sort(...) sorts in-place (modifies original).
- Arrays.binarySearch(...) only works correctly on a SORTED array.
- arr == otherArr checks if they are the SAME array object.
  Use Arrays.equals(arr, otherArr) for contents.
- Printing: Arrays.toString(arr) for 1D arrays.
- Common CodeRunner checks:
  - if (arr == null) return null;
  - if (arr.length == 0) return new int[0];
=====================================================
*/

