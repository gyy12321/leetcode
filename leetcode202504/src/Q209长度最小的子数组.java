import java.util.Arrays;

public class Q209长度最小的子数组 {
    public static void main(String[] args) {
        int[] array=new int[]{3,5,8,9,10,19,33};
        System.out.println(Arrays.binarySearch(array,5));
    }

    //类似答案的滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int l=0;
        int r=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while (r<n){
            //控制右指针不断向右
            while (sum<s&&r<n){
                sum+=nums[r++];
            }
            //左指针往右走，不断去掉左边的仍满足条件
            while (sum>=s){
                ans=Math.min(ans,r-l);
                sum-=nums[l++];
            }
        }

        return ans==Integer.MAX_VALUE?0:ans;
    }
}

//暴力法浅显易懂,超时
class Solution209_1 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

//前缀和加二分查找
class Solution209_2 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        //计算前缀和
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            //二分搜索没搜到返回的值要做处理
            if (bound < 0) {
                bound = -bound - 1;
            }
            //做更新
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}


//每一轮迭代，将 nums[end] 加到 sum，如果 sum≥s，
//        则更新子数组的最小长度（此时子数组的长度是 end−start+1），
//        然后将 nums[start] 从 sum 中减去并将 start 右移，直到 sum<s，
//        在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end 右移。

//滑动窗口，最好的方法*****************
//****************

class Solution209_3 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        //答案的滑动窗口更好理解
        while (end < n) {
            sum += nums[end];
            //控制左指针不断右移
            //这一块逻辑和我的很像
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                //去掉左指针所在的数
                sum -= nums[start];
                //左指针友右移
                start++;
            }
            //右指针右移
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}




