public class WK5_Worksheet_NestLoops {
    public static void main(String[] args){

        // Pattern: 122333444455555
        String result = "";
        for(int i = 1; i <= 5; i ++){
            for(int j = 0 ; j < i; j++){
                result += i;
            }
        }
        System.out.println(result);

        // Pattern: 22333444455555666666
        String result1 = "";
        for(int i = 2; i <= 6; i ++){
            for(int j = 0 ; j < i; j++){
                result1 += i;
            }
        }
        System.out.println(result1);

        // Pattern: 133355555
        String result2 = "";
        for(int i = 1; i <= 5; i += 2){
            for(int j = 0 ; j < i; j++){
                result2 += i;
            }
        }
        System.out.println(result2);

        // Pattern: 1335557777 - second loop via count
        String result3 = "";
        int count = 1;
        for(int i = 1; i <= 7; i += 2){
            for(int j = 0 ; j < count; j++){
                result3 += i;
            }
            count ++;
        }
        System.out.println(result3);

        // Pattern: 555554444333221
        String result4 = "";
        for(int i = 5; i >=  1; i --){
            for(int j = i ; j > 0; j--){
                result4 += i;
            }
        }
        System.out.println(result4);

        // Pattern: 544333222211111
        String result5 = "";
        int count1 = 1;
        for(int i = 5; i >=  1; i --){
            for(int j = 0; j < count1; j++){
                result5 += i;
            }
            count1 ++;
        }
        System.out.println(result5);

        // pattern:	+**+++****+++++
        String result6 = "";
        int counter = 1;
        for(int i = 0; i <= 4; i++ ){
            for(int j = 0; j < counter; j++){
                // check what block i represents
                if( i % 2 == 0){
                    result6 += "+";
                }else{
                    result6 += "*";
                }
            }
            counter ++;
        }
        System.out.println(result6);


        // Pattern: --***++++-----******+++++++
        String result7 = "";
        int counter1 = 2;
        for(int i = 0; i <= 5; i++ ){
            for(int j = 1; j <= counter1; j++){
                // check what block i represents
                if( i % 3 == 0){
                    result7 += "-";
                } else if(i % 3 == 1){
                    result7 += "*";
                }else{
                    result7 += "+";
                }
            }
            counter1 ++;
        }
        System.out.println(result7);

    }


}
