import java.util.ArrayList;
import java.util.Arrays;

//非常经典的动态规划，虽然不难，但值得再看看
public class Q53最大子数组和_ {
    public static void main(String[] args) {
        int[] x=new int[]{3,2,4,1,4,4,756};
        for (int i : x) {
            System.out.println(i);
        }

    }
    //有错误解法
//    public static int maxSubArray(int[] nums) {
//        int sum=0;
//        int max=Integer.MIN_VALUE;
//        int maxIndex=0;
//        int[] pre=new int[nums.length];
//        for (int i = 0; i < pre.length; i++) {
//            sum+=nums[i];
//            pre[i]=sum;
//            if(max<=pre[i]){
//                max=pre[i];
//                maxIndex=i;
//            }
//        }
//        int min=0;
//        for (int i = 0; i < maxIndex; i++) {
//            min=Math.min(min,pre[i]);
//        }
//        return max-min;
//    }

    //自己写的忘了啥意思了
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int[] pre=new int[nums.length];
        for (int i = 0; i < pre.length; i++) {
            sum+=nums[i];
            pre[i]=sum;
        }
        int min=0;
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            min=Math.min(min,pre[i-1]);
            res=Math.max(res,pre[i]-min);
        }
        return res;
    }

    //good类似dp解法
    public static int maxSubArray1(int[] nums) {
        //dp[i]表示以第i个元素结尾的子数组的最大值
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;++i){
            dp[i]=dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    //good官方解法dp，更简洁，节约空间
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    //官方解法分治，看不太懂
//    public class Status {
//        public int lSum, rSum, mSum, iSum;
//
//        public Status(int lSum, int rSum, int mSum, int iSum) {
//            this.lSum = lSum;
//            this.rSum = rSum;
//            this.mSum = mSum;
//            this.iSum = iSum;
//        }
//    }
//
//    public int maxSubArray(int[] nums) {
//        return getInfo(nums, 0, nums.length - 1).mSum;
//    }
//
//    public Status getInfo(int[] a, int l, int r) {
//        if (l == r) {
//            return new Status(a[l], a[l], a[l], a[l]);
//        }
//        int m = (l + r) >> 1;
//        Status lSub = getInfo(a, l, m);
//        Status rSub = getInfo(a, m + 1, r);
//        return pushUp(lSub, rSub);
//    }
//
//    public Status pushUp(Status l, Status r) {
//        int iSum = l.iSum + r.iSum;
//        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
//        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
//        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
//        return new Status(lSum, rSum, mSum, iSum);
//    }


}
