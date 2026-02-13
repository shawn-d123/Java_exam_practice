public class question_5_practice {

    public static void main(String[] args) {

        System.out.println(MakeCubeSequence(1, 5));
        System.out.println(MakeEvenSequence(3, 20));
        System.out.println(AlternatingSquares(2, 20));
    }

    public static String MakeCubeSequence(int S, int N){

        String result = "";

        if (S <= 0 || N <= 0){
            return "ERROR#1";
        }
        if (N < S){
            return "ERROR#2";
        }

        for(int i = S; i <= N; i++){
            if(i < N){
                result += (i * i * i) + " ";
            }
            else{
                result += (i * i * i);
            }
        }
        return result;
    }

    public static String MakeEvenSequence(int S, int N){

        String result = "";
        for(int i  = S; i <= N; i ++){
            if (i % 2 == 0){
                if(i < N){
                    result += i + " ";
                }
                else{
                    result += i;
                }
            }
        }
        return result;
    }

    public static String AlternatingSquares(int S, int N){

        String result = "";

        for(int i  = S; i <= N; i ++) {

            if (i % 2 == 0) {
                if (i < N) {
                    result += ((i * i) * -1) + " ";
                } else {
                    result += ((i * i) * -1);
                }
            } else if (i % 2 != 0){
                if (i < N) {
                    result += (i * i) + " ";
                } else {
                    result += (i * i);
                }
            }
        }
        return result;
    }

    public static String MakePrimeSequence(int S, int N){

        return null;
    }

// class bracket
}
