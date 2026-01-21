public class gHappy_loopsAndStringQs {

    public static void main(String[] args) {
        System.out.println(gHappy("g"));
    }

    public static boolean gHappy(String str) {
        boolean isHappy = false;
        for (int i = 0; i < str.length() - 1; i++) {
            // checks first
            if (str.charAt(i) == 'g' && i == 0) {
                isHappy = str.charAt(i + 1) == 'g';
            }// checks middle
            else if (str.charAt(i) == 'g' && i < str.length() -1) {
                isHappy = str.charAt(i + 1) == 'g' || str.charAt(i - 1) == 'g';

            } // checks last
            else if (str.charAt(i) == 'g' && i == str.length() - 1) {
                isHappy = str.charAt(i - 1) == 'g';
            }

        }
        return(isHappy);
    }
}