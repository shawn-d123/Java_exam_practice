public class double23_Arrays {
    public static void main(String[] args){
        System.out.println(double23(new int[] {2,2}));
    }
    public static boolean double23(int[] nums) {

        int d2count = 0;
        int d3count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 2){
                d2count ++;
            }
            else if(nums[i] == 3){
                d3count ++;
            }
        }
        if (d2count >= 2 || d3count >= 2){
            return(true);
        }else{
            return(false);
        }

    }
}
