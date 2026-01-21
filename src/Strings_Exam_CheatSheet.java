import java.util.Scanner;
public class Strings_Exam_CheatSheet {

    public class StringAndStringBuilderCheatSheet {

        /*
         * ============================================================
         *           STRING + STRINGBUILDER CHEAT SHEET (JAVA)
         * ============================================================
         *
         * KEY IDEA:
         * - String is IMMUTABLE (cannot be changed once created)
         *   -> operations like +, concat, replace create NEW Strings
         *
         * - StringBuilder is MUTABLE (you can edit it)
         *   -> faster for lots of appending / editing in loops
         *
         * EXAM RULE OF THUMB:
         * - If you're building text in a loop: use StringBuilder
         * - If you're doing a few simple operations: String is fine
         */

        public static void main(String[] args) {

            // ===== STRING BASICS =====
            stringBasics();

            // ===== IMPORTANT STRING METHODS =====
            stringMethods();

            // ===== COMMON EXAM PATTERNS =====
            stringExamPatterns();

            // ===== STRINGBUILDER BASICS =====
            stringBuilderBasics();

            // ===== STRINGBUILDER EXAM PATTERNS =====
            stringBuilderExamPatterns();

            // Uncomment if you want to test input examples
            // scannerStringDemo();
        }

        // ------------------------------------------------------------
        // 1) STRING BASICS (immutability, == vs equals)
        // ------------------------------------------------------------
        public static void stringBasics() {

            String a = "hello";
            String b = "hello";
            String c = new String("hello");

            // == compares REFERENCES (memory location), NOT contents
            System.out.println("a == b: " + (a == b)); // usually true due to string pool
            System.out.println("a == c: " + (a == c)); // false (different object)

            // equals compares CONTENTS (what you usually want)
            System.out.println("a.equals(c): " + a.equals(c)); // true

            // equalsIgnoreCase ignores case
            System.out.println("HELLO equalsIgnoreCase hello: " + "HELLO".equalsIgnoreCase("hello"));

            // Strings are immutable: this creates a NEW string
            String original = "cat";
            String changed = original + "s"; // original stays "cat"
            System.out.println("original=" + original + ", changed=" + changed);
        }

        // ------------------------------------------------------------
        // 2) USEFUL STRING METHODS (you'll see these in exams)
        // ------------------------------------------------------------
        public static void stringMethods() {

            String s = "  Brunel University London  ";

            // length(): number of characters
            System.out.println("length=" + s.length());

            // trim(): removes spaces at start/end
            String trimmed = s.trim();
            System.out.println("trimmed='" + trimmed + "'");

            // toLowerCase() / toUpperCase()
            System.out.println(trimmed.toLowerCase());
            System.out.println(trimmed.toUpperCase());

            // charAt(index): get a character (0..length-1)
            char first = trimmed.charAt(0);
            System.out.println("first char=" + first);

            // substring(start) or substring(start, end) (end is EXCLUSIVE)
            String sub1 = trimmed.substring(0, 6); // "Brunel"
            System.out.println("substring(0,6)=" + sub1);

            // indexOf: find position of a char or string (-1 if not found)
            int pos = trimmed.indexOf("University");
            System.out.println("indexOf('University')=" + pos);

            // startsWith / endsWith
            System.out.println("startsWith('Brun')=" + trimmed.startsWith("Brun"));
            System.out.println("endsWith('London')=" + trimmed.endsWith("London"));

            // contains: checks if substring exists
            System.out.println("contains('Uni')=" + trimmed.contains("Uni"));

            // replace: returns a NEW string (does not change original)
            String replaced = trimmed.replace("London", "UK");
            System.out.println("replaced=" + replaced);

            // split: turns a string into an array using a delimiter
            String csv = "10,20,30";
            String[] parts = csv.split(",");
            System.out.println("split length=" + parts.length + " first=" + parts[0]);

            // IMPORTANT: if you need to compare strings, use equals not ==
            String x = "abc";
            String y = "ABC";
            System.out.println("equals: " + x.equals(y));              // false
            System.out.println("equalsIgnoreCase: " + x.equalsIgnoreCase(y)); // true
        }

        // ------------------------------------------------------------
        // 3) COMMON STRING EXAM PATTERNS
        // ------------------------------------------------------------
        public static void stringExamPatterns() {

            // Pattern A: Count something in a string
            String s = "aabcaAA";
            int countA = countCharIgnoreCase(s, 'a');
            System.out.println("count of 'a' (ignore case) = " + countA);

            // Pattern B: Check if string is empty / blank
            String empty = "";
            String spaces = "   ";
            System.out.println("empty length==0: " + (empty.length() == 0));
            System.out.println("spaces.trim().length==0: " + (spaces.trim().length() == 0));

            // Pattern C: Reverse a string (StringBuilder easiest)
            String word = "Hello";
            String reversed = reverseString(word);
            System.out.println("reversed=" + reversed);

            // Pattern D: Safe parsing int from string (try-catch)
            String numberText = "123";
            int number = parseIntSafe(numberText);
            System.out.println("parsed=" + number);

            // Pattern E: Convert char digit -> int digit
            char digitChar = '7';
            int digit = digitChar - '0'; // '7' becomes 7
            System.out.println("digit=" + digit);

            // Pattern F: Build a repeated string (use StringBuilder in loop)
            String repeated = repeatText("Hi", 4); // "HiHiHiHi"
            System.out.println("repeated=" + repeated);
        }

        // Counts occurrences of a character ignoring case
        public static int countCharIgnoreCase(String s, char target) {

            if (s == null) {
                return 0;
            }

            char lowerTarget = Character.toLowerCase(target);
            int count = 0;

            for (int i = 0; i < s.length(); i++) {

                char current = Character.toLowerCase(s.charAt(i));

                if (current == lowerTarget) {
                    count++;
                }
            }

            return count;
        }

        // Reverse using StringBuilder (fast and simple)
        public static String reverseString(String s) {

            if (s == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder(s);
            sb.reverse(); // built-in reverse
            return sb.toString();
        }

        // Safe parse: returns 0 if invalid
        public static int parseIntSafe(String text) {

            if (text == null) {
                return 0;
            }

            text = text.trim(); // remove spaces around it

            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        // Repeat text n times safely using StringBuilder
        public static String repeatText(String text, int n) {

            if (text == null) {
                return null;
            }
            if (n <= 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(text);
            }

            return sb.toString();
        }

        // ------------------------------------------------------------
        // 4) STRINGBUILDER BASICS (mutable, append, insert, delete)
        // ------------------------------------------------------------
        public static void stringBuilderBasics() {

            // Create
            StringBuilder sb = new StringBuilder();

            // append(): add to the end
            sb.append("Hello");
            sb.append(" ");
            sb.append("World");
            System.out.println("sb=" + sb);

            // length(): current number of characters
            System.out.println("length=" + sb.length());

            // charAt: read a character
            System.out.println("charAt(1)=" + sb.charAt(1));

            // setCharAt: CHANGE a character (String can't do this)
            sb.setCharAt(0, 'h');
            System.out.println("after setCharAt=" + sb);

            // insert(index, text): insert into the middle
            sb.insert(5, " BIG");
            System.out.println("after insert=" + sb);

            // delete(start, end): remove characters (end exclusive)
            sb.delete(5, 9); // deletes " BIG"
            System.out.println("after delete=" + sb);

            // replace(start, end, text): replace segment
            sb.replace(0, 5, "Hey");
            System.out.println("after replace=" + sb);

            // reverse(): reverse characters
            sb.reverse();
            System.out.println("after reverse=" + sb);

            // Convert back to String
            String finalString = sb.toString();
            System.out.println("finalString=" + finalString);
        }

        // ------------------------------------------------------------
        // 5) STRINGBUILDER EXAM PATTERNS (build output in loops)
        // ------------------------------------------------------------
        public static void stringBuilderExamPatterns() {

            // Pattern A: Join array items with commas
            String[] names = {"Shawn", "Ayo", "Maya"};
            String joined = joinWithComma(names);
            System.out.println("joined=" + joined);

            // Pattern B: Filter only digits from a string
            String mixed = "a1b2c3!";
            String digits = keepOnlyDigits(mixed);
            System.out.println("digitsOnly=" + digits);

            // Pattern C: Make a simple "report" with lines
            String report = buildReport("Alice", 3, 67.5);
            System.out.println(report);
        }

        // Join an array with commas using StringBuilder
        public static String joinWithComma(String[] data) {

            if (data == null) {
                return null;
            }
            if (data.length == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < data.length; i++) {

                sb.append(data[i]);

                // add comma AFTER each item except the last one
                if (i < data.length - 1) {
                    sb.append(", ");
                }
            }

            return sb.toString();
        }

        // Keep only digits from a string (useful for validation)
        public static String keepOnlyDigits(String s) {

            if (s == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    sb.append(ch);
                }
            }

            return sb.toString();
        }

        // Build multi-line output (often needed for coderunner style)
        public static String buildReport(String name, int level, double score) {

            StringBuilder sb = new StringBuilder();

            sb.append("===== REPORT =====\n");
            sb.append("Name: ").append(name).append("\n");
            sb.append("Level: ").append(level).append("\n");
            sb.append("Score: ").append(score).append("\n");
            sb.append("==================\n");

            return sb.toString();
        }

        // ------------------------------------------------------------
        // 6) SCANNER + STRING INPUT (common gotchas)
        // ------------------------------------------------------------
        public static void scannerStringDemo() {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your full name: ");
            String name = sc.nextLine(); // reads whole line (including spaces)

            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine(); // IMPORTANT: consume leftover newline

            System.out.print("Enter a short message: ");
            String msg = sc.nextLine();

            System.out.println("Name=" + name);
            System.out.println("Age=" + age);
            System.out.println("Msg=" + msg);

            sc.close();
        }
    }

}
