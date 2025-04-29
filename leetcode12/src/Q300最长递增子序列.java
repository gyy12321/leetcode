import java.util.Arrays;

public class Q300最长递增子序列 {
    public static void main(String[] args) {

    }

    //第二次我写的,可以简化一下，把不同情况放一起，像是官方解法1那样
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if(len==1)
            return 1;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        //第i个数必须得取
        for(int i=1;i<len;++i){
            for(int j=0;j<=i-1;++j){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int max=0;
        for (int i : dp) {
            max=Math.max(max,i);
        }
        return max;
    }
}

class Solution300_1{
    //动态规划,效率18,
    //定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int res=1;
        for (int i=1;i<n;++i){
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res=Math.max(res,dp[i]);
        }
        for (int i : dp) {
            res=Math.max(res,i);
        }

        return res;
    }
}
class Solution300_2{
    //贪心加二分查找
    //还没看懂！！！！！！
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] d=new int[n];
        int len=1;
        d[0]=nums[0];
        for(int i=1;i<n;++i){
            int value=nums[i];
            int l=0,r=len-1,middle;
            while (l<=r){
                middle=l+(r-l)/2;
                if(d[middle]<value)
                    l=middle+1;
                else
                    r=middle-1;
            }
            d[l]=value;
            if(l==len)
                len++;
        }
        return len;
    }
}
