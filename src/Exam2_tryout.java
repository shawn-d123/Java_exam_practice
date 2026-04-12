public class Exam2_tryout {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }

        boolean isrunning = true;
        while(isrunning == true){
            System.out.println("Hello World!");

            for (int i = 0; i <= 10; i++){
                if (i == 5){
                    isrunning = false;
                }
                else{
                    System.out.println(i);
                    callName("Kevin");
                }
            }
            System.out.println("=====================");
        }
    }

    private static void callName(String name) {
        System.out.println("Hello " + name);
    }



}
