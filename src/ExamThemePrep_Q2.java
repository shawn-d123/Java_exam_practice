public class ExamThemePrep_Q2 {
    public static void main(String[] args) {
        System.out.println("Q1 answer is: " + gradeCategory( "99"));
        System.out.println("Q2 answer is: " + daysInMonthNumber(2, 2000));
        System.out.println("Q3 answer is: " + isValidPassword("kirkakK1"));

    }
   //----- Conditions + Operators + Parsing (if / else-if / switch) ----- //

    /*
    Q2.1 gradeCategory

    Write:

    public static String gradeCategory(String markText)


    markText may be "78", " 65 ", null, "", "NaN", "52rr".

    If it cannot be parsed as an integer → return "INVALID".

    Otherwise:

            >= 70 → "FIRST"

            >= 60 → "2:1"

            >= 50 → "2:2"

            >= 40 → "THIRD"

            else → "FAIL"
    */
    public static String gradeCategory(String markText){

        // check if input is valid_ using try...catch
        int grade;
        try{
            grade = Integer.parseInt(markText);
        }catch(Exception e){
            return "Invalid";
        }

        // assign grade with if statements
        if(grade >= 70){
            return "First";
        }else if(grade >= 60){
            return "2:1";
        }else if(grade >= 50){
            return "2:2";
        }else if(grade >= 40){
            return "Third";
        }else{
            return "Fail";
        }
    }

    /*
    Q2.2 daysInMonthNumber

    Write (use switch):

    public static int daysInMonthNumber(int month, int year)


    month is 1..12, else return -1.

    February depends on leap year:

    Leap year rule: divisible by 400 OR (divisible by 4 AND not divisible by 100)

     */

    public static int daysInMonthNumber(int month, int year){

        int daysInMonth = 0;

        switch(month){
            case 1:
                daysInMonth = 31;
                break;
            case 2:
                // check for leap year
                if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
                    daysInMonth = 29;
                }
                else{ // not a leap year
                    daysInMonth = 28;
                }
                break;
            case 3:
                daysInMonth = 30;
                break;
            case 4:
                daysInMonth = 31;
                break;
            case 5:
                daysInMonth = 30;
                break;
            case 6:
                daysInMonth = 31;
                break;
            case 7:
                daysInMonth = 30;
                break;
            case 8:
                daysInMonth = 31;
                break;
            case 9:
                daysInMonth = 30;
                break;
            case 10:
                daysInMonth = 31;
                break;
            case 11:
                daysInMonth = 30;
                break;
            case 12:
                daysInMonth = 31;
                break;
            default:
                return -1;
        }
        return daysInMonth;
    }

    /*
    Q2.3 isValidPassword

    Write:

    public static boolean isValidPassword(String password)


    Return true only if:

    not null

    length ≥ 8

    contains at least one digit

    contains at least one uppercase letter

    No regex needed (but allowed). Use loops + Character.isDigit, Character.isUpperCase.
     */

    public static boolean isValidPassword(String password){

        boolean digit = false;
        boolean uppercase = false;

        // validate length
        if (password == null || password.length() < 8) {
            return false;
        }

        // check for digit and uppercase
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                uppercase = true;
            }
        }

        return digit && uppercase;
    }



}
