import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class ArrayList_Exam_cheatSheet {

/*
==========================================================
ARRAYLIST CHEAT SHEET — EXAM STYLE (CS1603 / Q5–Q7)
==========================================================

FOCUS:
- What you ACTUALLY need in exams
- Copy–paste ready
- Clear patterns you can recognise instantly
- No advanced Java (streams, lambdas, etc.)

----------------------------------------------------------
CORE DIFFERENCE (ARRAY vs ARRAYLIST)
----------------------------------------------------------
Array:
✔ Fixed size
✔ Faster
✘ Cannot grow/shrink

ArrayList:
✔ Dynamic size (can grow/shrink)
✔ Built-in methods (add, remove, contains…)
✘ Slightly slower than arrays

Syntax:
ArrayList<Integer> list = new ArrayList<Integer>();

==========================================================
*/


    public class Main {

    /* ======================================================
       1) CREATE ARRAYLIST (ALL COMMON WAYS)
       ====================================================== */

        public static void createArrayList() {

            // Empty ArrayList
            ArrayList<Integer> a = new ArrayList<Integer>();

            // Add values
            a.add(10);
            a.add(20);
            a.add(30);

            // From array
            Integer[] arr = {1, 2, 3};
            ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(arr));

            System.out.println(a);
            System.out.println(b);
        }

    /* ======================================================
       2) BASIC OPERATIONS (VERY COMMON)
       ====================================================== */

        public static void basicOperations() {

            ArrayList<Integer> list = new ArrayList<Integer>();

            list.add(10);          // add to end
            list.add(20);
            list.add(1, 15);       // insert at index 1

            int x = list.get(0);   // read value
            list.set(1, 99);       // replace value at index

            int size = list.size();

            System.out.println(list);
            System.out.println("first = " + x);
            System.out.println("size = " + size);
        }

    /* ======================================================
       3) REMOVE ELEMENTS (EXAM TRAP!)
       ====================================================== */

        public static void removeElements() {

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(20);

            // Remove by INDEX
            list.remove(1);        // removes element at index 1

            // Remove by VALUE (IMPORTANT!)
            list.remove(Integer.valueOf(20));  // removes first 20

            System.out.println(list);
        }

    /*
    ⚠ EXAM TRAP:
    list.remove(1)  → index
    list.remove(20) → index 20 (CRASH!)
    ALWAYS use Integer.valueOf(value)
    */

    /* ======================================================
       4) LOOPING THROUGH ARRAYLIST
       ====================================================== */

        public static void loopingArrayList() {

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(5);
            list.add(10);
            list.add(15);

            // Standard for loop (BEST for exams)
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            // Enhanced for loop
            for (int x : list) {
                System.out.println(x);
            }
        }

    /* ======================================================
       5) SEARCHING ARRAYLIST
       ====================================================== */

        public static void searchingArrayList() {

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            list.add(20);
            list.add(30);

            boolean has20 = list.contains(20);   // true
            int index30 = list.indexOf(30);      // 2
            int index99 = list.indexOf(99);      // -1

            System.out.println(has20);
            System.out.println(index30);
            System.out.println(index99);
        }

    /* ======================================================
       6) CONVERT ARRAY ↔ ARRAYLIST (EXAM FAVOURITE)
       ====================================================== */

        public static void arrayConversions() {

            // Array → ArrayList
            int[] arr = {1, 2, 3};

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : arr) {
                list.add(x);
            }

            // ArrayList → Array
            int[] back = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                back[i] = list.get(i);
            }

            System.out.println(list);
            System.out.println(Arrays.toString(back));
        }

    /* ======================================================
       7) SORTING ARRAYLIST
       ====================================================== */

        public static void sortingArrayList() {

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(5);
            list.add(1);
            list.add(9);

            Collections.sort(list); // ascending

            System.out.println(list);
        }

    /* ======================================================
       8) REMOVE WHILE LOOPING (COMMON Q7 BUG)
       ====================================================== */

        public static void removeWhileLooping() {

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(2);
            list.add(3);

            // CORRECT WAY (loop backwards)
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == 2) {
                    list.remove(i);
                }
            }

            System.out.println(list);
        }

    /* ======================================================
       9) FILTER ARRAYLIST (BUILD NEW LIST)
       ====================================================== */

        public static ArrayList<Integer> keepEven(ArrayList<Integer> input) {

            if (input == null) return null;

            ArrayList<Integer> result = new ArrayList<Integer>();

            for (int x : input) {
                if (x % 2 == 0) {
                    result.add(x);
                }
            }

            return result;
        }

    /* ======================================================
       10) ARRAYLIST + INVALID INPUT PATTERN (Q6/Q7)
       ====================================================== */

        public static ArrayList<Integer> safeProcess(int[][] data) {

            if (data == null) return null;

            ArrayList<Integer> result = new ArrayList<Integer>();

            for (int i = 0; i < data.length; i++) {

                if (data[i] == null || data[i].length == 0) {
                    result.add(-1);
                    continue;
                }

                result.add(data[i][0]); // example logic
            }

            return result;
        }
    }
}

/*
==========================================================
EXAM RECOGNITION GUIDE
==========================================================

If you see:
✔ “Dynamic size”
✔ “Return ArrayList<Integer>”
✔ “Add -1 for invalid rows”
✔ “Remove elements”

→ USE ARRAYLIST

----------------------------------------------------------
TOP EXAM MISTAKES (MEMORISE)
----------------------------------------------------------
✘ Using remove(value) instead of remove(index)
✘ Looping forward when removing
✘ Forgetting list.size()
✘ Using [] instead of get/set
✘ Forgetting Integer wrapper

----------------------------------------------------------
MOST IMPORTANT METHODS
----------------------------------------------------------
add(value)
add(index, value)
get(index)
set(index, value)
remove(index)
remove(Integer.valueOf(value))
size()
contains(value)
indexOf(value)
Collections.sort(list)

==========================================================
FINAL TIP
==========================================================
If the question says:
“Return results for EACH input row”
→ ArrayList is usually expected.

==========================================================

*/
