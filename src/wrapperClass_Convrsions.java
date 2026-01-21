public class wrapperClass_Convrsions {
    public class WrapperClassesCheatSheet {

        /*
         * ============================================================
         *        WRAPPER CLASSES & TYPE CONVERSION (JAVA)
         * ============================================================
         *
         * KEY IDEA:
         * - Wrapper classes are OBJECT versions of primitives
         * - Used when:
         *   • working with Strings
         *   • parsing input
         *   • using collections (ArrayList etc.)
         *
         * Primitive  -> Wrapper
         * int        -> Integer
         * double     -> Double
         * char       -> Character
         * boolean    -> Boolean
         */

        public static void main(String[] args) {

            wrapperBasics();
            autoboxingDemo();
            parsingDemo();
            charUtilitiesDemo();
            conversionsDemo();
            commonExamPitfalls();
        }

        // ------------------------------------------------------------
        // 1) WRAPPER CLASS BASICS
        // ------------------------------------------------------------
        public static void wrapperBasics() {

            // Primitive
            int a = 10;

            // Wrapper object
            Integer b = Integer.valueOf(10);

            // Both represent the same VALUE
            System.out.println(a);
            System.out.println(b);

            // Wrapper classes have METHODS
            System.out.println("Integer max = " + Integer.MAX_VALUE);
            System.out.println("Integer min = " + Integer.MIN_VALUE);

            // you can also turn an integer to a sting using:
            int x = 42;
            String s = Integer.toString(x);

            // or you can use:
            int y = 42;
            String str = String.valueOf(x);

        }

        // ------------------------------------------------------------
        // 2) AUTOBOXING & UNBOXING
        // ------------------------------------------------------------
        public static void autoboxingDemo() {

            // AUTOBOXING: primitive -> wrapper (automatic)
            int x = 5;
            Integer obj = x;

            // UNBOXING: wrapper -> primitive (automatic)
            int y = obj;

            System.out.println("x=" + x);
            System.out.println("obj=" + obj);
            System.out.println("y=" + y);

            // Exam note:
            // Java handles this automatically — no casting needed
        }

        // ------------------------------------------------------------
        // 3) PARSING STRINGS TO NUMBERS (VERY EXAM IMPORTANT)
        // ------------------------------------------------------------
        public static void parsingDemo() {

            String intText = "123";
            String doubleText = "45.67";

            // String -> int
            int num = Integer.parseInt(intText);

            // String -> double
            double value = Double.parseDouble(doubleText);

            System.out.println("num=" + num);
            System.out.println("value=" + value);

            // ❌ This will crash if string is not numeric
            // int bad = Integer.parseInt("abc");
        }

        // ------------------------------------------------------------
        // 4) CHARACTER CLASS UTILITIES
        // ------------------------------------------------------------
        public static void charUtilitiesDemo() {

            char c1 = '7';
            char c2 = 'A';
            char c3 = ' ';

            // Check if digit
            System.out.println(Character.isDigit(c1)); // true
            System.out.println(Character.isDigit(c2)); // false

            // Check if letter
            System.out.println(Character.isLetter(c2)); // true

            // Check whitespace
            System.out.println(Character.isWhitespace(c3)); // true

            // Convert case
            char lower = Character.toLowerCase('B');
            char upper = Character.toUpperCase('c');

            System.out.println(lower);
            System.out.println(upper);
        }

        // ------------------------------------------------------------
        // 5) COMMON TYPE CONVERSIONS (EXAM PATTERNS)
        // ------------------------------------------------------------
        public static void conversionsDemo() {

            // -------- CHAR -> INT (digit) --------
            char digitChar = '8';

            // WRONG (ASCII value)
            int wrong = digitChar;
            System.out.println("wrong=" + wrong);

            // CORRECT
            int correct = digitChar - '0';
            System.out.println("correct=" + correct);

            // -------- INT -> STRING --------
            int n = 42;
            String s1 = Integer.toString(n);
            String s2 = "" + n; // also valid

            System.out.println(s1);
            System.out.println(s2);

            // -------- DOUBLE -> STRING --------
            double d = 3.14;
            String s3 = Double.toString(d);
            System.out.println(s3);

            // -------- STRING -> CHAR --------
            String word = "Hello";
            char first = word.charAt(0);
            System.out.println(first);
        }

        // ------------------------------------------------------------
        // 6) COMMON EXAM PITFALLS (LEARN THESE)
        // ------------------------------------------------------------
        public static void commonExamPitfalls() {

            // ❌ Using == instead of equals for wrappers
            Integer a = 100;
            Integer b = 100;

            System.out.println(a == b);        // may be true (cache)
            System.out.println(a.equals(b));   // ALWAYS correct

            // ❌ Parsing without trimming
            String text = " 25 ";
            // int bad = Integer.parseInt(text); // crash

            // ✅ FIX
            int good = Integer.parseInt(text.trim());
            System.out.println(good);

            // ❌ Character.getNumericValue vs subtraction confusion
            char c = '9';

            int methodWay = Character.getNumericValue(c);
            int subtractWay = c - '0';

            System.out.println(methodWay);
            System.out.println(subtractWay);

            // For exams: subtraction is clearer and expected
        }
    }

}
