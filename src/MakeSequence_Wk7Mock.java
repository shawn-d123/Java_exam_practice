public class MakeSequence_Wk7Mock {

    public static void main(String[] args) {
        System.out.println(MakeSequence(5));
    }
    public static String MakeSequence(int n){

        String result = "";
        // validate
        if(n < 1){
            return "";
        } // valid
        else{
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < i; j++){
                    result += i;
                }
            }
        }
        return result;
    }
}

