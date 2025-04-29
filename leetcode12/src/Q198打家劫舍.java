public class Q198打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        int length = nums.length;
        if(length==1)
            return nums[0];
        if(length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[length-1];
    }
//    public static int rob(int[] nums) {
//        int length = nums.length;
//        if(length==1)
//            return nums[0];
//        int sum1=0,sum2=0;
//        for(int i=length-1;i>=0;i-=2){
//            sum1+=nums[i];
//        }
//        for(int i=length-2;i>=0;i-=2){
//            sum2+=nums[i];
//        }
//        return Math.max(sum1,sum2);
//    }




}
class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}

