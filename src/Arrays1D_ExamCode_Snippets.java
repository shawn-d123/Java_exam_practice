import java.util.Arrays;
public class Arrays1D_ExamCode_Snippets {
    /*
=====================================================
JAVA ARRAYS – COMMON EXAM TECHNIQUES (EASY VERSION)
=====================================================

Purpose:
- Fast recall in exams
- Copy patterns and adapt
- No advanced tricks

RULES TO REMEMBER:
- Arrays are FIXED SIZE
- Index starts at 0
- Last index = arr.length - 1
- Always check for null / empty if asked
*/


    /* =====================================================
       1) ARRAY CREATION (EXAM BASICS)
       ===================================================== */

    public static void arrayCreation() {

        // Declare + set size (defaults)
        int[] a = new int[5];           // {0,0,0,0,0}
        double[] b = new double[3];     // {0.0,0.0,0.0}
        String[] c = new String[2];     // {null, null}

        // Declare + initialise
        int[] marks = {10, 20, 30, 40};

        // Using new (often seen in methods)
        int[] nums = new int[]{5, 6, 7};

        System.out.println(Arrays.toString(marks));
    }

/* =====================================================
   2) DIRECT INDEXING (READ / WRITE)
   ===================================================== */

    public static void indexing() {
        int[] data = {10, 20, 30};

        int first = data[0];                 // read
        data[1] = 99;                        // write

        int last = data[data.length - 1];    // last element

        System.out.println(Arrays.toString(data));
    }

/* =====================================================
   3) LOOP THROUGH ARRAY (MOST IMPORTANT)
   ===================================================== */

    public static void looping() {
        int[] arr = {3, 5, 7, 9};

        // Standard loop (BEST for exams)
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // Enhanced for (read-only style)
        for (int x : arr) {
            System.out.println(x);
        }
    }

/* =====================================================
   4) SUM / AVERAGE PATTERN (VERY COMMON)
   ===================================================== */

    public static int sumArray(int[] arr) {
        if (arr == null) return 0;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static double averageArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0.0;

        int sum = sumArray(arr);
        return (double) sum / arr.length;
    }

/* =====================================================
   5) FIND MAX / MIN (EXAM CLASSIC)
   ===================================================== */

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MAX_VALUE;

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

/* =====================================================
   6) SEARCH (LINEAR SEARCH)
   ===================================================== */

    public static int indexOf(int[] arr, int target) {
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // not found
    }

/* =====================================================
   7) COPY ARRAY (NEW ARRAY)
   ===================================================== */

    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;

        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

/* =====================================================
   8) REVERSE ARRAY (NEW ARRAY)
   ===================================================== */

    public static int[] reverse(int[] arr) {
        if (arr == null) return null;

        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

/* =====================================================
   9) SHIFT LEFT / RIGHT (IN PLACE)
   ===================================================== */

    // Shift LEFT: first value lost
    public static void shiftLeft(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    // Shift RIGHT: last value lost
    public static void shiftRight(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = 0;
    }

/* =====================================================
   10) ADD / REMOVE ELEMENT (NEW ARRAY)
   ===================================================== */

    // Insert value at index
    public static int[] insertAt(int[] arr, int index, int value) {
        if (arr == null) return null;

        int[] out = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            out[i] = arr[i];
        }

        out[index] = value;

        for (int i = index; i < arr.length; i++) {
            out[i + 1] = arr[i];
        }

        return out;
    }

    // Remove element at index
    public static int[] removeAt(int[] arr, int index) {
        if (arr == null || arr.length == 0) return arr;

        int[] out = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            out[i] = arr[i];
        }

        for (int i = index + 1; i < arr.length; i++) {
            out[i - 1] = arr[i];
        }

        return out;
    }

/* =====================================================
   11) SORTING (BUILT-IN)
   ===================================================== */

    public static void sorting() {
        int[] arr = {5, 2, 9, 1};

        Arrays.sort(arr); // sorts in place

        System.out.println(Arrays.toString(arr));
    }

/* =====================================================
   12) ROTATE RIGHT (EXAM FAVOURITE)
   ===================================================== */

    public static int[] rotateRight(int[] data, int k) {
        if (data == null) return null;
        if (data.length == 0) return new int[0];

        int n = data.length;

        // normalise k
        k = k % n;
        if (k < 0) k += n;

        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            out[newIndex] = data[i];
        }

        return out;
    }
}

/*
=====================================================
EXAM QUICK CHECKLIST (MEMORISE)
=====================================================

✔ for-loop: i < arr.length
✔ last element: arr[arr.length - 1]
✔ searching: linear search
✔ adding/removing → NEW ARRAY
✔ shifting → IN PLACE
✔ sorting: Arrays.sort(arr)
✔ rotate: use modulo (%)
✔ null / empty checks if stated

=====================================================
*/


