public class mirrorEnds_strings {

    public static void main(String[] Args){
        System.out.println(mirrorEnds("aafghtjgfaa"));
    }

    public static String mirrorEnds(String string){

        int left = 0;
        int right = string.length() -1;

        String result = "";

        while(left <= string.length() && right >= 0){
            if(string.charAt(left) == string.charAt(right)){
                result = result + string.charAt(left);
                left ++;
                right--;
            } else{
                break;
            }
        }
    return(result);
    }
}
