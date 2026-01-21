public class Conditions_ternary {
    public class ConditionsAndTernaryCheatSheet {

        /*
         * ============================================================
         *        CONDITIONS & TERNARY OPERATOR (JAVA)
         * ============================================================
         *
         * This sheet covers:
         * - if / else / else if
         * - comparison operators
         * - logical operators
         * - boolean expressions
         * - ternary operator
         *
         * EXAM TIP:
         * If logic becomes long or nested → use if/else
         * If it's short and returns a value → ternary
         */

        public static void main(String[] args) {

            basicIfElse();
            comparisonOperators();
            logicalOperators();
            nestedConditions();
            ternaryBasics();
            commonExamPatterns();
            commonMistakes();
        }

        // ------------------------------------------------------------
        // 1) BASIC if / else
        // ------------------------------------------------------------
        public static void basicIfElse() {

            int age = 18;

            if (age >= 18) {
                System.out.println("Adult");
            } else {
                System.out.println("Minor");
            }
        }

        // ------------------------------------------------------------
        // 2) COMPARISON OPERATORS
        // ------------------------------------------------------------
        public static void comparisonOperators() {

            int a = 10;
            int b = 20;

            System.out.println(a == b);  // equal to
            System.out.println(a != b);  // not equal to
            System.out.println(a < b);   // less than
            System.out.println(a > b);   // greater than
            System.out.println(a <= b);  // less or equal
            System.out.println(a >= b);  // greater or equal

            // NOTE:
            // == compares VALUES for primitives
            // == compares REFERENCES for objects (use equals for objects)
        }

        // ------------------------------------------------------------
        // 3) LOGICAL OPERATORS
        // ------------------------------------------------------------
        public static void logicalOperators() {

            boolean isStudent = true;
            boolean hasID = false;

            // AND (both must be true)
            if (isStudent && hasID) {
                System.out.println("Student with ID");
            }

            // OR (one must be true)
            if (isStudent || hasID) {
                System.out.println("Allowed entry");
            }

            // NOT (inverts)
            if (!hasID) {
                System.out.println("No ID provided");
            }

            // Short-circuiting:
            // If first condition fails, second may not run
        }

        // ------------------------------------------------------------
        // 4) NESTED CONDITIONS
        // ------------------------------------------------------------
        public static void nestedConditions() {

            int mark = 67;

            if (mark >= 70) {
                System.out.println("First");
            } else if (mark >= 60) {
                System.out.println("Upper Second");
            } else if (mark >= 50) {
                System.out.println("Lower Second");
            } else {
                System.out.println("Fail");
            }
        }

        // ------------------------------------------------------------
        // 5) TERNARY OPERATOR BASICS
        // ------------------------------------------------------------
        public static void ternaryBasics() {

            int a = 5;
            int b = 9;

            // Syntax:
            // condition ? valueIfTrue : valueIfFalse

            int max = (a > b) ? a : b;
            System.out.println("max=" + max);

            // Equivalent if/else:
        /*
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        */
        }

        // ------------------------------------------------------------
        // 6) COMMON EXAM PATTERNS (VERY IMPORTANT)
        // ------------------------------------------------------------
        public static void commonExamPatterns() {

            // Pattern 1: Absolute value
            int x = -7;
            int abs = (x < 0) ? -x : x;
            System.out.println("abs=" + abs);

            // Pattern 2: Even or odd
            int n = 11;
            String type = (n % 2 == 0) ? "Even" : "Odd";
            System.out.println(type);

            // Pattern 3: Pass / Fail
            int mark = 42;
            String result = (mark >= 40) ? "Pass" : "Fail";
            System.out.println(result);

            // Pattern 4: Clamp a value
            int score = 120;
            int capped = (score > 100) ? 100 : score;
            System.out.println("capped=" + capped);

            // Pattern 5: Safe division check
            int a = 10;
            int b = 0;

            String message = (b == 0) ? "Cannot divide" : "Result=" + (a / b);
            System.out.println(message);
        }

        // ------------------------------------------------------------
        // 7) COMMON MISTAKES (EXAM TRAPS)
        // ------------------------------------------------------------
        public static void commonMistakes() {

            int x = 10;

            // ❌ Using = instead of ==
            // if (x = 5) { } // compile error

            // ❌ Comparing Strings with ==
            String a = "hi";
            String b = "hi";

            System.out.println(a == b);         // unreliable
            System.out.println(a.equals(b));    // correct

            // ❌ Overusing ternary
            // If it hurts readability → use if/else

            // ❌ Missing brackets in complex logic
            boolean p = true;
            boolean q = false;

            // Always use brackets for clarity
            if ((p && q) || !q) {
                System.out.println("Logic evaluated");
            }
        }
    }

}
