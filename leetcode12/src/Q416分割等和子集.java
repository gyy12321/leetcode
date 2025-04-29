public class Q416分割等和子集 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        if(nums.length==1)
            return false;
        int sum=0;
        int maxNum=0;
        for (int num : nums) {
            sum+=num;
            maxNum=Math.max(maxNum,num);
        }
        int target=sum/2;
        // 如果数组的和是奇数，则肯定不能划分为两个子集，返回 false
        //最大值大于总和的一半，则肯定不能划分
        if(sum%2!=0||maxNum>target)
            return false;

        //这个地方的加1不能忘
        //dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
        // 是否存在一种选取方案使得被选取的正整数的和等于 j。初始时，dp 中的全部元素都是 false
        boolean[][] dp=new boolean[nums.length][target+1];
        // 初始化第一列，和为0，不取即可，都为true
        for (int i = 0; i <nums.length; i++) {
            dp[i][0]=true;
        }
        //取第0个数，和为nums[0]，成立
        dp[0][nums[0]]=true;
        //到此为止，第0列以及第0行都初始化完成
        //从一行一列向右下不断求解，一行一行来
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                //核心逻辑，如果当前值大于j，则只能选择不取当前值，即dp[i-1][j]
                if(nums[i]>j)
                    dp[i][j]=dp[i-1][j];
                //如果当前值小于j，则两种情况都考虑，第i个数可以取也可以不取，即dp[i-1][j]和dp[i-1][j-nums[i]]
                else
                    dp[i][j]=dp[i-1][j-nums[i]] | dp[i-1][j];
            }
        }
        return dp[nums.length-1][target];
    }
}
//答案更精简的写法，只用了一维dp数组
class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        //保留一行
        boolean[] dp = new boolean[target + 1];
        //dp[0][0]=true;
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                //i=0
                //dp[0][j] |= dp[0][j - num];
                //分别对应上一行以及这一行
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}

