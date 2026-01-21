import java.util.Scanner;
public class Loops_Exam_CheatSheet {

    public class LoopsCheatSheet {

        /*
         * ============================================================
         *                    LOOPS CHEAT SHEET (JAVA)
         * ============================================================
         *
         * Quick rules:
         * - for-loop: when you know how many times (definite repetition)
         * - while-loop: when you loop until something happens (condition-based)
         * - do-while: like while, but runs at least once
         * - enhanced for: best for "read-only" looping through arrays
         *
         * Common mistakes:
         * - Off-by-one: i < n vs i <= n
         * - Infinite loops: condition never becomes false
         * - Array index: valid indexes are 0 to length-1
         */

        public static void main(String[] args) {

            // Run any demo you want:
            basicForLoopDemo();
            basicWhileLoopDemo();
            basicDoWhileLoopDemo();

            arraysForLoopDemo();
            enhancedForLoopDemo();
            nestedLoop2DArrayDemo();

            breakContinueDemo();

            sumCountMinMaxDemo();
            searchDemo();

            patternPrintingDemo();
            gcdEuclidDemo();

            // Uncomment to see user-input loop patterns:
            // scannerLoopDemo();
        }

        // ------------------------------------------------------------
        // 1) FOR LOOP: definite repetition
        // ------------------------------------------------------------
        public static void basicForLoopDemo() {

            // Print 1 to 5
            for (int i = 1; i <= 5; i++) {
                System.out.println("for i = " + i);
            }

            // Count down 5 to 1
            for (int i = 5; i >= 1; i--) {
                System.out.println("countdown i = " + i);
            }

            // Step size of 2 (evens)
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("even i = " + i);
            }
        }

        // ------------------------------------------------------------
        // 2) WHILE LOOP: condition-based repetition (must change state!)
        // ------------------------------------------------------------
        public static void basicWhileLoopDemo() {

            int x = 0;

            // Keep going until x reaches 3
            while (x < 3) {
                System.out.println("while x = " + x);
                x++; // IMPORTANT: update x so the loop ends
            }

            // Example: loop until condition becomes false
            int a = 4;
            int b = 5;

            int guard = 0; // prevents accidental infinite loops
            while (a < b && guard < 3) {
                System.out.println("Hi there...");
                guard++;
            }
        }

        // ------------------------------------------------------------
        // 3) DO-WHILE: runs at least once
        // ------------------------------------------------------------
        public static void basicDoWhileLoopDemo() {

            int tries = 0;

            do {
                System.out.println("do-while runs at least once. tries=" + tries);
                tries++;
            } while (tries < 2);
        }

        // ------------------------------------------------------------
        // 4) ARRAYS + FOR LOOP (index-based)
        // ------------------------------------------------------------
        public static void arraysForLoopDemo() {

            int[] timeInMinutes = {1, 3, 5, 10};

            // Print each value + convert to seconds
            for (int i = 0; i < timeInMinutes.length; i++) {

                int minutes = timeInMinutes[i];
                int seconds = minutes * 60;

                System.out.println("minutes=" + minutes + " -> seconds=" + seconds);
            }
        }

        // ------------------------------------------------------------
        // 5) ENHANCED FOR LOOP (for-each)
        // ------------------------------------------------------------
        public static void enhancedForLoopDemo() {

            int[] data = {10, 20, 30};

            // Best when you just want values (not indexes)
            for (int value : data) {
                System.out.println("value=" + value);
            }

            // If you need index, use normal for-loop instead.
        }

        // ------------------------------------------------------------
        // 6) NESTED LOOPS + 2D ARRAYS
        // ------------------------------------------------------------
        public static void nestedLoop2DArrayDemo() {

            int[][] movement = {
                    {100, 100, 1000},
                    {70,  100, 2000},
                    {100, 70,  3000}
            };

            // Print all values row by row
            for (int row = 0; row < movement.length; row++) {

                for (int col = 0; col < movement[row].length; col++) {
                    System.out.print(movement[row][col] + " ");
                }

                System.out.println(); // new line after each row
            }
        }

        // ------------------------------------------------------------
        // 7) break / continue
        // ------------------------------------------------------------
        public static void breakContinueDemo() {

            // continue: skips to next iteration
            for (int i = 1; i <= 10; i++) {

                if (i % 2 == 0) {
                    continue; // skip evens
                }

                System.out.println("odd=" + i);
            }

            // break: exits loop completely
            for (int i = 1; i <= 10; i++) {

                if (i == 6) {
                    break; // stop when i hits 6
                }

                System.out.println("i=" + i);
            }
        }

        // ------------------------------------------------------------
        // 8) CLASSIC EXAM PATTERNS: sum, count, min, max
        // ------------------------------------------------------------
        public static void sumCountMinMaxDemo() {

            int[] nums = {5, -2, 10, 7, 7};

            // SUM
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
            }

            // COUNT (example: count how many are 7)
            int count7 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 7) {
                    count7++;
                }
            }

            // MIN / MAX (handle empty array safely)
            int min = 0;
            int max = 0;

            if (nums.length > 0) {
                min = nums[0];
                max = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] < min) {
                        min = nums[i];
                    }
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
            }

            System.out.println("sum=" + sum);
            System.out.println("count7=" + count7);
            System.out.println("min=" + min + ", max=" + max);
        }

        // ------------------------------------------------------------
        // 9) SEARCH PATTERN: find value (return index or -1)
        // ------------------------------------------------------------
        public static void searchDemo() {

            int[] nums = {3, 8, 12, 5};
            int target = 12;

            int foundIndex = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    foundIndex = i;
                    break; // stop once found
                }
            }

            System.out.println("target=" + target + " foundIndex=" + foundIndex);
        }

        // ------------------------------------------------------------
        // 10) PATTERN PRINTING (common loop exam style)
        // ------------------------------------------------------------
        public static void patternPrintingDemo() {

            // "++++++++++" (10 pluses)
            printCharNTimes('+', 10);

            // "---------" (9 dashes)
            printCharNTimes('-', 9);

            // "+-+-+-+-+-" (10 chars alternating)
            printAlternatingChars('+', '-', 10);

            // "*+-*+-*+-" (9 chars repeating pattern "*+-")
            printRepeatPattern("*+-", 9);

            // "***+++---***+++---" (repeat "***+++---" twice)
            printRepeatPattern("***+++---", 18);

            // New line after demo
            System.out.println();
        }

        // Prints a character n times on ONE line
        public static void printCharNTimes(char ch, int n) {
            for (int i = 0; i < n; i++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        // Alternates between a and b, total length n
        public static void printAlternatingChars(char a, char b, int n) {
            for (int i = 0; i < n; i++) {

                if (i % 2 == 0) {
                    System.out.print(a);
                } else {
                    System.out.print(b);
                }
            }
            System.out.println();
        }

        // Repeats a string pattern until totalChars printed (cuts if needed)
        public static void printRepeatPattern(String pattern, int totalChars) {

            int printed = 0;

            while (printed < totalChars) {

                for (int i = 0; i < pattern.length(); i++) {

                    if (printed >= totalChars) {
                        break;
                    }

                    System.out.print(pattern.charAt(i));
                    printed++;
                }
            }

            System.out.println();
        }

        // ------------------------------------------------------------
        // 11) EUCLID'S ALGORITHM (GCD) using WHILE LOOP
        // ------------------------------------------------------------
        public static void gcdEuclidDemo() {

            int a = 270;
            int b = 192;

            int gcd = gcdEuclid(a, b);

            System.out.println("gcd(" + a + "," + b + ")=" + gcd);
        }

        // Returns GCD of a and b (works for positive inputs)
        public static int gcdEuclid(int a, int b) {

            // Make them positive (optional safety)
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }

            // Edge cases
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }

            // Euclid: while b != 0, replace (a,b) with (b, a%b)
            while (b != 0) {
                int remainder = a % b;
                a = b;
                b = remainder;
            }

            return a;
        }

        // ------------------------------------------------------------
        // 12) SCANNER LOOP (input validation pattern)
        // ------------------------------------------------------------
        public static void scannerLoopDemo() {

            Scanner sc = new Scanner(System.in);

            // Keep asking until user enters an int between 1 and 10
            int value = -1;

            while (value < 1 || value > 10) {

                System.out.print("Enter an int 1..10: ");

                if (sc.hasNextInt()) {
                    value = sc.nextInt();
                } else {
                    sc.next(); // throw away bad token
                    System.out.println("Invalid input (not an int). Try again.");
                }
            }

            System.out.println("You entered: " + value);

            sc.close();
        }
    }

}
