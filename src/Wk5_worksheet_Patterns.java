public class Wk5_worksheet_Patterns {
    public static void main(String[] args){
        patternGen();
    }

    public static void patternGen() {

        // pattern: ++++++++++
        String result = "";
        for(int i = 0; i <= 10; i++){
            result = result + "+";
        }
        System.out.println(result);

        //pattern: ---------
        String result2 = "";
        for( int i  = 0; i < 10; i++){

            result2 = result2 + "-";
        }
        System.out.println(result2);

        // pattern: +-+-+-+-+-
        String result3 = "";
        for( int i  = 1; i <= 11; i++){
            result3 += (i % 2 == 0)? "+":"-"; // used ternary function
        }
        System.out.println(result3);

        // pattern: *+-*+-*+-
        String result4 = "";
        for( int i  = 0; i < 9; i++){
            if(i % 3 == 0){
                result4 += "*";
            } else if( i % 3 == 1){
                result4 += "+";
            }else{
                result4 += "-";
            }
        }
        System.out.println(result4);

        // pattern: *+-*+-*+-*
        String result5 = "";
        for( int i  = 0; i < 10; i++){
            if (i % 3 == 0){
                result5 += "*";
            }else if (i % 3 == 1){
                result5 += "+";
            }
            else{
                result5 += "-";
            }
        }
        System.out.println(result5);

        // pattern: **++**++**++
        String result6 = "";
        for( int i  = 0; i < 12; i++){
            if (i % 4 == 0 || i % 4 == 1){
                result6 += "*";
            }else{
                result6 += "+";
            }
        }
        System.out.println(result6);

        // pattern: ***+++---***+++---
        String result7 = "";
        for( int i  = 0; i < 18; i++){
            if (i % 9 < 3){
                result7 += "*";
            }else if( i % 9 > 2 && i % 9 < 6){
                result7 += "+";
            }else{
                result7 += "-";
            }
        }
        System.out.println(result7);

        // pattern: ***+++------+++***
        String result8 = "";
        for( int i  = 0; i < 18; i++){
            if (i < 3) {
                result8 += ("*");
            } else if (i < 6) {
                result8 += ("+");
            } else if (i < 12) {
                result8 += ("-");
            } else if (i < 15) {
                result8 += ("+");
            } else {
                result8 += ("*");
            }
        }
        System.out.println(result8);

    }

}
