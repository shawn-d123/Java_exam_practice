public class maxSpan_arrays {
    public static void main(String[] args){
        System.out.println(maxSpan(new int[] {1, 2, 1, 1, 3,1}));
    }

    private static int maxSpan(int[] nums) {
        int mspan = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if( nums[i] == nums[j] ){
                    int span = (j - i) + 1;
                    if(span > mspan){
                        mspan = span;
                    }
                }


            }
        }
        return(mspan);
    }
}
