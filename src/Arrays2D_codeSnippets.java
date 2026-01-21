import java.util.Arrays;

public class Arrays2D_codeSnippets {
    /*
=====================================================
JAVA 2D ARRAYS – EXAM + NICE-TO-KNOW CHEAT SHEET
=====================================================

This is the "2D arrays" version of your array cheat sheet.
Designed for CS1603 / CodeRunner style questions.

-----------------------------------------------------
BY GLANCE (sections)
-----------------------------------------------------
1) What a 2D array is (rows/cols, indexing)
2) ALL ways to create / initialise 2D arrays
3) Access + update (direct indexing)
4) Looping patterns (nested loops + enhanced loops)
5) Rectangular vs Jagged (ragged) arrays (VERY IMPORTANT)
6) Common operations (sum, row sums, col sums, max, search)
7) Copying 2D arrays (shallow vs deep copy) (EXAM TRAP)
8) Sorting 2D arrays (common exam approaches)
9) Shifting / moving rows/cols (exam-ish)
10) Common patterns for exam questions (templates)
11) Common mistakes / heads-up

REFERENCES:
- Arrays start at 0, use arr.length for rows and arr[row].length for columns.
- Your Week 7 lab shows nested loop printing of a 2D array :contentReference[oaicite:0]{index=0}

Paste into IntelliJ. Everything is runnable.
*/

    public class TwoDArrayCheatSheet {

        public static void main(String[] args) {
            // Quick testing:
            // section1_basics();
            // section2_creation();
            // section3_accessUpdate();
            // section4_looping();
            // section5_rectangularVsJagged();
            // section6_commonOperations();
            // section7_copying();
            // section8_sorting2D();
            // section9_shiftRowsCols();
            // section10_examTemplates();
            // section11_commonMistakes();
        }

    /* =====================================================
       1) WHAT A 2D ARRAY IS (rows + cols)
       ===================================================== */

        public static void section1_basics() {
            int[][] grid = {
                    {1, 2, 3},
                    {4, 5, 6}
            };

            // grid.length = number of rows
            System.out.println("rows = " + grid.length); // 2

            // grid[row].length = number of columns in that row
            System.out.println("cols in row 0 = " + grid[0].length); // 3

            // Access: grid[row][col]
            System.out.println("grid[1][2] = " + grid[1][2]); // 6
        }

    /* =====================================================
       2) ALL WAYS TO CREATE / INITIALISE 2D ARRAYS
       ===================================================== */

        public static void section2_creation() {

            // A) Declare + allocate (rectangular)
            int[][] a = new int[3][4]; // 3 rows, 4 cols each (defaults 0)

            // B) Initialise with values (literal)
            int[][] b = {
                    {10, 20, 30},
                    {40, 50, 60}
            };

            // C) Jagged (ragged) arrays: rows can have different lengths
            int[][] c = new int[3][];
            c[0] = new int[2];
            c[1] = new int[4];
            c[2] = new int[1];

            // D) Jagged array literal
            int[][] d = {
                    {1, 2},
                    {3, 4, 5, 6},
                    {7}
            };

            // E) Different data types
            double[][] doubles = new double[2][3];
            String[][] names = {
                    {"Fred", "Jo"},
                    {"Zoe", "Harry"}
            };
            boolean[][] flags = new boolean[2][2];

            System.out.println("b = " + Arrays.deepToString(b));
            System.out.println("d = " + Arrays.deepToString(d));
            System.out.println("names = " + Arrays.deepToString(names));
        }

    /* =====================================================
       3) DIRECT ACCESS + UPDATE (grid[r][c])
       ===================================================== */

        public static void section3_accessUpdate() {
            int[][] m = {
                    {1, 2, 3},
                    {4, 5, 6}
            };

            int value = m[0][1];     // 2
            m[1][2] = 999;           // update 6 -> 999

            System.out.println("value = " + value);
            System.out.println("m = " + Arrays.deepToString(m));
        }

    /* =====================================================
       4) LOOPING PATTERNS (nested loops)
       ===================================================== */

        public static void section4_looping() {
            int[][] movement = {
                    {100, 100, 1000},
                    {70, 100, 2000},
                    {100, 70, 3000}
            };

            // A) Standard nested loops (EXAM STANDARD) :contentReference[oaicite:1]{index=1}
            for (int r = 0; r < movement.length; r++) {
                for (int c = 0; c < movement[r].length; c++) {
                    System.out.print(movement[r][c] + " ");
                }
                System.out.println();
            }

            // B) Enhanced for loops (good for reading)
            for (int[] row : movement) {
                for (int x : row) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }

    /* =====================================================
       5) RECTANGULAR vs JAGGED (RAGGED) – VERY IMPORTANT
       ===================================================== */

        public static void section5_rectangularVsJagged() {

            int[][] rectangular = new int[2][3]; // every row has 3 cols

            int[][] jagged = {
                    {1, 2},
                    {3, 4, 5},
                    {6}
            };

            System.out.println("rectangular rows = " + rectangular.length);
            System.out.println("rectangular cols row0 = " + rectangular[0].length);

            System.out.println("jagged rows = " + jagged.length);
            System.out.println("jagged cols row0 = " + jagged[0].length);
            System.out.println("jagged cols row1 = " + jagged[1].length);
            System.out.println("jagged cols row2 = " + jagged[2].length);

        /*
        EXAM HEADS-UP:
        - NEVER assume same column length for every row unless told.
        - Always loop columns using arr[r].length (not arr[0].length).
        */
        }

    /* =====================================================
       6) COMMON OPERATIONS (exam favourites)
       ===================================================== */

        public static void section6_commonOperations() {
            int[][] a = {
                    {1, 2, 3},
                    {4, 5},
                    {6}
            };

            System.out.println("sumAll = " + sumAll(a));
            System.out.println("maxValue = " + maxValue(a));

            System.out.println("rowSums = " + Arrays.toString(rowSums(a)));

            // column sums only make sense if rectangular
            int[][] rect = {
                    {1, 2, 3},
                    {4, 5, 6}
            };
            System.out.println("colSums = " + Arrays.toString(colSumsRectangular(rect)));

            System.out.println("contains 5? " + contains(a, 5));
            System.out.println("position of 5 = " + Arrays.toString(findFirst(a, 5))); // [row,col] or [-1,-1]
        }

        // Sum of all values
        public static int sumAll(int[][] arr) {
            if (arr == null) return 0;

            int sum = 0;
            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) continue; // row might be null in jagged arrays
                for (int c = 0; c < arr[r].length; c++) {
                    sum += arr[r][c];
                }
            }
            return sum;
        }

        // Max value
        public static int maxValue(int[][] arr) {
            if (arr == null) return Integer.MIN_VALUE;

            boolean foundAny = false;
            int max = Integer.MIN_VALUE;

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) continue;
                for (int c = 0; c < arr[r].length; c++) {
                    if (!foundAny) {
                        max = arr[r][c];
                        foundAny = true;
                    } else if (arr[r][c] > max) {
                        max = arr[r][c];
                    }
                }
            }

            if (!foundAny) return Integer.MIN_VALUE;
            return max;
        }

        // Row sums (works for jagged too)
        public static int[] rowSums(int[][] arr) {
            if (arr == null) return null;

            int[] sums = new int[arr.length];

            for (int r = 0; r < arr.length; r++) {
                int sum = 0;
                if (arr[r] != null) {
                    for (int c = 0; c < arr[r].length; c++) {
                        sum += arr[r][c];
                    }
                }
                sums[r] = sum;
            }

            return sums;
        }

        // Column sums (rectangular only)
        public static int[] colSumsRectangular(int[][] arr) {
            if (arr == null || arr.length == 0) return new int[0];
            if (arr[0] == null) return new int[0];

            int cols = arr[0].length;
            int[] sums = new int[cols];

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null || arr[r].length != cols) {
                    // exam-safe choice: return empty to indicate "not rectangular"
                    return new int[0];
                }
                for (int c = 0; c < cols; c++) {
                    sums[c] += arr[r][c];
                }
            }

            return sums;
        }

        // Contains value?
        public static boolean contains(int[][] arr, int target) {
            if (arr == null) return false;

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) continue;
                for (int c = 0; c < arr[r].length; c++) {
                    if (arr[r][c] == target) return true;
                }
            }
            return false;
        }

        // Find first occurrence -> [row, col] or [-1, -1]
        public static int[] findFirst(int[][] arr, int target) {
            if (arr == null) return new int[]{-1, -1};

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) continue;
                for (int c = 0; c < arr[r].length; c++) {
                    if (arr[r][c] == target) {
                        return new int[]{r, c};
                    }
                }
            }
            return new int[]{-1, -1};
        }

    /* =====================================================
       7) COPYING 2D ARRAYS (SHALLOW vs DEEP) – EXAM TRAP
       ===================================================== */

        public static void section7_copying() {
            int[][] a = {
                    {1, 2},
                    {3, 4}
            };

            // SHALLOW copy of outer array only (rows still shared)
            int[][] shallow = a.clone();

            // DEEP copy (new rows too)
            int[][] deep = deepCopy(a);

            shallow[0][0] = 999;
            System.out.println("a after shallow change: " + Arrays.deepToString(a)); // changed!

            deep[1][1] = 777;
            System.out.println("a after deep change: " + Arrays.deepToString(a));   // unchanged
            System.out.println("deep: " + Arrays.deepToString(deep));
        }

        public static int[][] deepCopy(int[][] arr) {
            if (arr == null) return null;

            int[][] copy = new int[arr.length][];

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) {
                    copy[r] = null;
                } else {
                    copy[r] = new int[arr[r].length];
                    for (int c = 0; c < arr[r].length; c++) {
                        copy[r][c] = arr[r][c];
                    }
                }
            }
            return copy;
        }

    /* =====================================================
       8) SORTING 2D ARRAYS (common exam approaches)
       ===================================================== */

        public static void section8_sorting2D() {

            // A) Sort each row (very common + easy)
            int[][] arr = {
                    {3, 1, 2},
                    {9, 7, 8}
            };

            for (int r = 0; r < arr.length; r++) {
                Arrays.sort(arr[r]);
            }
            System.out.println("row-sorted: " + Arrays.deepToString(arr));

            // B) Sort rows by their sum (nice-to-know / sometimes asked)
            int[][] arr2 = {
                    {5, 5},   // sum 10
                    {1, 2, 3},// sum 6
                    {9}       // sum 9
            };

            sortRowsBySum(arr2);
            System.out.println("rows sorted by sum: " + Arrays.deepToString(arr2));
        }

        // Simple bubble-sort style: sort rows by their sum ascending
        public static void sortRowsBySum(int[][] arr) {
            if (arr == null) return;

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    int sumA = rowSum(arr[j]);
                    int sumB = rowSum(arr[j + 1]);

                    if (sumA > sumB) {
                        int[] temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        private static int rowSum(int[] row) {
            if (row == null) return 0;
            int sum = 0;
            for (int x : row) sum += x;
            return sum;
        }

    /* =====================================================
       9) SHIFT / MOVE ROWS or COLS (exam-ish)
       ===================================================== */

        public static void section9_shiftRowsCols() {
            int[][] a = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            shiftRowsDown(a);
            System.out.println("shiftRowsDown: " + Arrays.deepToString(a));

            // For columns, easiest is do it per row (rectangular expected)
            shiftColsRightRectangular(a);
            System.out.println("shiftColsRight: " + Arrays.deepToString(a));
        }

        // Shift rows down by 1 (last row moves to top)
        public static void shiftRowsDown(int[][] arr) {
            if (arr == null || arr.length <= 1) return;

            int[] last = arr[arr.length - 1];
            for (int r = arr.length - 1; r > 0; r--) {
                arr[r] = arr[r - 1];
            }
            arr[0] = last;
        }

        // Shift columns right by 1 in each row (rectangular expected)
        public static void shiftColsRightRectangular(int[][] arr) {
            if (arr == null) return;

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null || arr[r].length <= 1) continue;

                int last = arr[r][arr[r].length - 1];
                for (int c = arr[r].length - 1; c > 0; c--) {
                    arr[r][c] = arr[r][c - 1];
                }
                arr[r][0] = last;
            }
        }

    /* =====================================================
       10) EXAM TEMPLATES (copy/paste patterns)
       ===================================================== */

        public static void section10_examTemplates() {

            int[][] data = {
                    {10, 20, 30},
                    {40, 50, 60}
            };

            // TEMPLATE: print all values with row/col
            printWithCoordinates(data);

            // TEMPLATE: build a new 2D array based on formula
            int[][] doubled = mapMultiply(data, 2);
            System.out.println("doubled = " + Arrays.deepToString(doubled));

            // TEMPLATE: validate rectangular
            System.out.println("isRectangular? " + isRectangular(data));
        }

        public static void printWithCoordinates(int[][] arr) {
            if (arr == null) {
                System.out.println("null");
                return;
            }

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) {
                    System.out.println("row " + r + " is null");
                    continue;
                }
                for (int c = 0; c < arr[r].length; c++) {
                    System.out.println("arr[" + r + "][" + c + "] = " + arr[r][c]);
                }
            }
        }

        // Build NEW array where each element is multiplied by factor
        public static int[][] mapMultiply(int[][] arr, int factor) {
            if (arr == null) return null;

            int[][] out = new int[arr.length][];

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) {
                    out[r] = null;
                } else {
                    out[r] = new int[arr[r].length];
                    for (int c = 0; c < arr[r].length; c++) {
                        out[r][c] = arr[r][c] * factor;
                    }
                }
            }

            return out;
        }

        public static boolean isRectangular(int[][] arr) {
            if (arr == null || arr.length == 0) return true; // depends on your policy
            if (arr[0] == null) return false;

            int cols = arr[0].length;

            for (int r = 0; r < arr.length; r++) {
                if (arr[r] == null) return false;
                if (arr[r].length != cols) return false;
            }

            return true;
        }

    /* =====================================================
       11) COMMON MISTAKES / HEADS-UP (read fast)
       ===================================================== */

        public static void section11_commonMistakes() {

            int[][] a = {
                    {1, 2},
                    {3, 4, 5}
            };

            // MISTAKE 1: Assuming same columns for every row (jagged crash)
            // for (int c = 0; c < a[0].length; c++) { System.out.println(a[1][c]); } // may crash

            // Correct:
            for (int r = 0; r < a.length; r++) {
                for (int c = 0; c < a[r].length; c++) {
                    System.out.print(a[r][c] + " ");
                }
                System.out.println();
            }

            // MISTAKE 2: Printing 2D array with Arrays.toString
            System.out.println(Arrays.toString(a));       // prints references
            System.out.println(Arrays.deepToString(a));   // prints values

            // MISTAKE 3: Shallow copying
            int[][] shallow = a.clone();
            shallow[0][0] = 999;
            System.out.println("a after shallow edit: " + Arrays.deepToString(a));
        }
    }

/*
=====================================================
FAST EXAM NOTES (HIGH VALUE)
=====================================================

1) Dimensions:
   rows = arr.length
   cols = arr[r].length

2) Loop safely:
   for (int r=0; r<arr.length; r++)
       for (int c=0; c<arr[r].length; c++)

3) Jagged arrays exist:
   arr[0].length is NOT reliable unless you know it’s rectangular.

4) Deep print:
   Arrays.deepToString(arr)

5) Copying trap:
   arr.clone() only copies OUTER array (rows are shared)
   Use deep copy if you need independence.

6) Common exam tasks:
   - Print matrix
   - Row sums
   - Column sums (rectangular)
   - Find max / find value
   - Transform (build new 2D array)
   - Validate rows / handle null rows

=====================================================
*/

}
