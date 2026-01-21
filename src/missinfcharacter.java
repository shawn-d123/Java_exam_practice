public class missinfcharacter {

    public static void main(String[] args){

        System.out.println(missingChar("happy", 3));

    }

    public static String missingChar(String str, int n ) {

        String front = null;
        String end = null;
        try {
            front = str.substring(0, n);
            end = str.substring(n + 1, str.length());
        } catch (Exception e) {
            System.out.println("error on substring convert");
        }


        return (front + end);
    }

}

