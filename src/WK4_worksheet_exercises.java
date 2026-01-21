public class WK4_worksheet_exercises {
    public static void main(String[] args) {

        int num = 12;

        // Divisible by 2 and 3
        if (num > 0 && num % 2 == 0 && num % 3 == 0) {
            System.out.println("Divisible by 2 and 3");
        }

        // Divisible by 7 or 9
        if (num > 0 && (num % 7 == 0 || num % 9 == 0)) {
            System.out.println("Divisible by 7 or 9");
        }

        // Divisible by 2 and 3 but not 5
        if (num > 0 && num % 2 == 0 && num % 3 == 0 && num % 5 != 0) {
            System.out.println("Divisible by 2 and 3 but not 5");
        }

    }
}