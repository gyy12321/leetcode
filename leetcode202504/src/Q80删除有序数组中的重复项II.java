public class Q80删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {

        int left=1;
        int right=1;
        int duplicate=1;

        while (right<nums.length){
            if(nums[right]!=nums[left-1]){
                nums[left++]=nums[right];
                duplicate=1;
            }
            else if(duplicate==1){
                nums[left++]=nums[right];
                duplicate++;
            }
            right++;
        }
        return left;
    }
}

//答案的双指针更巧妙一些
class Solution80_1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

