import java.util.Arrays;

public class maxEnd3_arrays {

    public static void main(String[] args){
        System.out.println(Arrays.toString(maxEnd3(new int[]{1, 2, 3, 4, 6, 7, 8, 9})));
    }

    public static int[] maxEnd3(int[] nums) {
        int max = 0;
        if (nums[0] > nums[nums.length -1]){
            max = nums[0];
        } else{
            max = nums[nums.length -1];}

        for(int i = 0; i < nums.length; i++){
            nums[i] = max;
        }
        return(nums);
    }
}
