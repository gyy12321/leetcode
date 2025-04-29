import java.util.ArrayList;
import java.util.Arrays;

public class Q41缺失的第一个整数 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int index=0;
        while (index<n&&nums[index]<=0)
            index++;
        if(index==n)
            return 1;
        int target=1;
        if(nums[index]>1)
            return 1;

        while (index<n){
            if(nums[index]==target){
                index++;
            }
            else if(nums[index]-target==1){
                target++;
                index++;
            }
            else
                return target+1;
        }
        return nums[n-1]+1;
    }
}
//哈希，还没懂
class Solution41_1 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}


//置换，勉强理解
class Solution41_2 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            //nums[i]放在nums[i]-1这个正确位置上，模拟哈希表
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}


