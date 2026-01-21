
import java.util.ArrayList;
public class conversions {

    public static void main(String[] args) {

    /* ================================
       1) PRIMITIVE → PRIMITIVE
       ================================ */

        // Widening (automatic)
        int i = 10;
        double d = i;

        // Narrowing (cast required)
        double x = 9.8;
        int y = (int) x;   // truncates to 9


    /* ================================
       2) PRIMITIVE ↔ STRING
       ================================ */

        // int → String
        String s1 = String.valueOf(42);
        String s2 = Integer.toString(42);

        // double → String
        String s3 = String.valueOf(5.5);

        // String → int
        int a = Integer.parseInt("100");

        // String → double
        double b = Double.parseDouble("3.14");


    /* ================================
       3) WRAPPER CLASSES
       ================================ */

        // Autoboxing
        Integer obj = a;

        // Unboxing
        int c = obj;

        // Wrapper → String
        String s4 = obj.toString();

        // String → Wrapper
        Integer w = Integer.valueOf("20");
        Double z = Double.valueOf("6.28");


    /* ================================
       4) CHAR CONVERSIONS
       ================================ */

        // char → int (ASCII / Unicode)
        char ch = 'A';
        int ascii = ch;   // 65

        // int → char
        char letter = (char) 65;  // 'A'

        // char → String
        String charStr = String.valueOf('k');

        // String → char
        char firstChar = charStr.charAt(0);


    /* ================================
       5) BOOLEAN CONVERSIONS
       ================================ */

        // boolean → String
        String boolStr = String.valueOf(true);

        // String → boolean
        boolean flag = Boolean.parseBoolean("true");


    /* ================================
       6) ARRAY ↔ ARRAYLIST
       ================================ */

        // Array → ArrayList
        int[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();

        for (int v : arr) {
            list.add(v);
        }

        // ArrayList → Array (Object type)
        Integer[] arrObj = list.toArray(new Integer[0]);

        // ArrayList → Primitive array
        int[] arrPrim = new int[list.size()];
        for (int idx = 0; idx < list.size(); idx++) {
            arrPrim[idx] = list.get(idx);
        }


    /* ================================
       7) COMMON EXAM NOTES
       ================================ */

        // (int) 7.9        → 7
        // Integer.parseInt("5.5") → NumberFormatException
        // "10" + 5         → "105"
        // 10 + "5"         → "105"

        System.out.println("Cheat sheet loaded successfully.");
    }

}
