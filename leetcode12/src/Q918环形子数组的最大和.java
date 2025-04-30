public class Q918环形子数组的最大和 {
    public static void main(String[] args) {

    }

}
//稍微有些复杂，现在懂了，但之后还需要再研究
//https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/2350660/huan-xing-zi-shu-zu-de-zui-da-he-by-leet-elou/?envType=study-plan-v2&envId=top-interview-150
class Solution918_1 {
    //
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        //leftMax[i]表示0-0,0-1,0-2.。。0-i这些里面的和的最大值
        int[] leftMax = new int[n];
        // 对坐标为 0 处的元素单独处理，避免考虑子数组为空的情况
        leftMax[0] = nums[0];
        int leftSum = nums[0];

        int pre = nums[0];
        int res = nums[0];

        //第一种情况，类似最大子数组和
        for (int i = 1; i < n; i++) {
            //res表示以第i位为末尾的子数组和的最大值
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
            //为第二种情况做铺垫
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        // 从右到左枚举后缀，固定后缀，选择最大前缀
        //第二种情况
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }
        return res;
    }
}

class Solution918_2 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int preMax = nums[0], maxRes = nums[0];
        int preMin = nums[0], minRes = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            //第一种情况仍然一样,最大子数组和
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxRes = Math.max(maxRes, preMax);

            //第二种情况换一个做法，preMin和preMax刚好意义相反
            preMin = Math.min(preMin + nums[i], nums[i]);
            minRes = Math.min(minRes, preMin);
            sum += nums[i];
        }
        if (maxRes < 0) {
            return maxRes;
        } else {
            //精华，两种情况取较大的那个
            return Math.max(maxRes, sum - minRes);
        }
    }
}

//方法三单调队列没看