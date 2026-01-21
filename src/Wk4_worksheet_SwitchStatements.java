public class Wk4_worksheet_SwitchStatements {
    public static void main(String[] args){

        String month = "April";
        int daysInMonth = 0;

        // we can make a switch statement
        switch (month){

            case "jan":
                daysInMonth = 31;
                break; // break to prevent it from going to the next line
            case "feb":
                daysInMonth = 28;
                break;
            case "march":
                daysInMonth = 31;
                break;
            case "April":
                daysInMonth = 30;
                break;
                // and on and on

            default: // like an else have to have this
                daysInMonth = -1;
                break;
        }
        System.out.println("Days in month " + month + " = " + daysInMonth);


        ///  you can also merge this switch statement so it is not so redundant

        int daysinmonth = 0;

        String month1 = "February";

        switch (month1)
        {
            case "January": case "March": case "May": case "July": case "August": case "October": case "December":
            daysinmonth = 31;
            break;
            case "February":
                daysinmonth = 28;
                break;
            case "April": case "June": case "September": case "November":
            daysinmonth = 30;
            break;
            default:
                daysinmonth = -1;
                break;
        }
        System.out.println("Days in month " + month1 + " = " + daysinmonth);


        //  ternary operatiors from the worrkeet seminar (we are turning the below code into ternary operator)

        int x = 1; // Raining?
        int y = 1; // Snowing?

    //    if (x == 1 || y == 1) {
      //      System.out.println("There will be sleet");
    //    } else {
     //       System.out.println("No sleet, perhaps just rain?");
      //  }

        // 2 ways of doing this either save it to a variable(method 1) or print it(method 2)

        // method 1
        String message = ((x == 1 || y == 1) ? "There will be sleet" : "No sleet, perhaps just rain?");
        System.out.println(message + " method 1");

        // method 2
        System.out.println((x == 1 || y == 1) ? "There will be sleet" : "No sleet, perhaps just rain?");
    }
}
