public class MathsAndRandomNumGen {
    public class MathAndRandomCheatSheet {

        /*
         * ============================================================
         *      MATH FUNCTIONS + RANDOM NUMBERS (JAVA)
         * ============================================================
         *
         * This cheat sheet covers:
         * - Math built-in functions (exam level)
         * - Integer vs double behaviour
         * - Rounding
         * - Random number generation using Math.random()
         *
         * EXAM RULE:
         * - Math.random() returns a DOUBLE between 0.0 (inclusive)
         *   and 1.0 (exclusive)
         */

        public static void main(String[] args) {

            mathBasics();
            roundingDemo();
            powerAndRoot();
            minMaxAbs();
            randomBasics();
            randomRanges();
            commonExamPatterns();
            commonMistakes();
        }

        // ------------------------------------------------------------
        // 1) BASIC MATH FUNCTIONS
        // ------------------------------------------------------------
        public static void mathBasics() {

            int a = -10;
            int b = 7;

            // Absolute value
            System.out.println(Math.abs(a)); // 10

            // Minimum / Maximum
            System.out.println(Math.min(a, b)); // -10
            System.out.println(Math.max(a, b)); // 7

            // PI constant
            System.out.println(Math.PI);
        }

        // ------------------------------------------------------------
        // 2) ROUNDING FUNCTIONS (VERY EXAM IMPORTANT)
        // ------------------------------------------------------------
        public static void roundingDemo() {

            double x = 3.6;
            double y = 3.2;

            // round(): nearest whole number (returns long!)
            long r1 = Math.round(x); // 4
            long r2 = Math.round(y); // 3

            // floor(): always round DOWN
            double f = Math.floor(3.9); // 3.0

            // ceil(): always round UP
            double c = Math.ceil(3.1); // 4.0

            System.out.println(r1);
            System.out.println(r2);
            System.out.println(f);
            System.out.println(c);
        }

        // ------------------------------------------------------------
        // 3) POWERS & ROOTS
        // ------------------------------------------------------------
        public static void powerAndRoot() {

            // Power
            double square = Math.pow(5, 2); // 25.0
            double cube = Math.pow(2, 3);   // 8.0

            // Square root
            double root = Math.sqrt(16);    // 4.0

            System.out.println(square);
            System.out.println(cube);
            System.out.println(root);
        }

        // ------------------------------------------------------------
        // 4) MIN / MAX / ABS (COMMON EXAM USE)
        // ------------------------------------------------------------
        public static void minMaxAbs() {

            int x = -4;
            int y = 9;

            int absX = Math.abs(x);
            int max = Math.max(x, y);
            int min = Math.min(x, y);

            System.out.println(absX);
            System.out.println(max);
            System.out.println(min);
        }

        // ------------------------------------------------------------
        // 5) RANDOM NUMBER BASICS
        // ------------------------------------------------------------
        public static void randomBasics() {

            // Math.random() gives double in range:
            // 0.0 <= value < 1.0

            double r = Math.random();
            System.out.println(r);

            // Convert to int (0 or 1)
            int zeroOrOne = (int) (Math.random() * 2);
            System.out.println(zeroOrOne);
        }

        // ------------------------------------------------------------
        // 6) RANDOM NUMBER RANGES (VERY EXAM IMPORTANT)
        // ------------------------------------------------------------
        public static void randomRanges() {

            // RANDOM 0 to 9
            int r0to9 = (int) (Math.random() * 10);

            // RANDOM 1 to 10
            int r1to10 = (int) (Math.random() * 10) + 1;

            // RANDOM 5 to 15
            int r5to15 = (int) (Math.random() * 11) + 5;

            // RANDOM index for array of length n
            int n = 8;
            int index = (int) (Math.random() * n);

            System.out.println(r0to9);
            System.out.println(r1to10);
            System.out.println(r5to15);
            System.out.println(index);
        }

        /*
         * GENERAL RANDOM FORMULA (MEMORISE THIS):
         *
         * min to max (inclusive):
         *
         * (int)(Math.random() * (max - min + 1)) + min
         */

        // ------------------------------------------------------------
        // 7) COMMON EXAM PATTERNS
        // ------------------------------------------------------------
        public static void commonExamPatterns() {

            // Dice roll (1–6)
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("dice=" + dice);

            // Coin flip
            String coin = (Math.random() < 0.5) ? "Heads" : "Tails";
            System.out.println(coin);

            // Random percentage (0–100)
            int percent = (int) (Math.random() * 101);
            System.out.println(percent);

            // Random even number between 2 and 20
            int even = ((int) (Math.random() * 10) + 1) * 2;
            System.out.println(even);
        }

        // ------------------------------------------------------------
        // 8) COMMON MISTAKES (EXAM TRAPS)
        // ------------------------------------------------------------
        public static void commonMistakes() {

            // ❌ Casting too early
            int wrong = (int) Math.random() * 10; // ALWAYS 0
            System.out.println("wrong=" + wrong);

            // ✅ Correct
            int correct = (int) (Math.random() * 10);
            System.out.println("correct=" + correct);

            // ❌ Forgetting +1 when range should be inclusive
            int wrongDice = (int) (Math.random() * 6); // 0–5
            System.out.println("wrongDice=" + wrongDice);

            // ✅ Correct dice
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("dice=" + dice);

            // ❌ Integer division before Math
            int a = 1 / 2; // 0
            double bad = Math.sqrt(a);
            System.out.println(bad);

            // ✅ Correct
            double good = Math.sqrt(1.0 / 2);
            System.out.println(good);
        }
    }

}
