import java.util.ArrayList;

public class Q42接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right;
        int sum = 0;
        int n = height.length;
        if (n <= 2)
            return 0;
        while (height[left] == 0 && left <= n - 3)
            left++;
        while (left <= n - 3) {
            right = left + 1;
            int top = -1;
            int topIdx = -1;
            while (right <= n - 1) {
                if (height[right] > top) {
                    topIdx = right;
                    if (height[right] >= height[left]) {
                        top = height[left];
                        break;
                    } else
                        top = height[right];
                }
                right++;
            }
            if (top == 0)
                break;
            sum += Math.min(height[left], top) * (topIdx - left - 1);
            for (int i = left + 1; i <= topIdx - 1; i++) {
                sum -= height[i];
            }
            left = topIdx;
        }

        return sum;

    }
}

//动态规划法可以看懂
class Solution42_1 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}

//单调栈看不懂和双指针法勉强
class Solution42_2_3 {

}
