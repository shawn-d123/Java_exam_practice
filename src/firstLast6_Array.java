public class firstLast6_Array {

    public static void main(String[] args){
        System.out.println(firstLast6(new int[]{ 6, 7, 5, 6, 7, 89}));
    }

    public static boolean firstLast6(int[] nums){

        if(nums[0] == 6 || nums[nums.length -1]== 6){
            return(true);
        }
        else{
            return(false);
        }
    }
}
