import java.util.Arrays;

public class Q215数组中的第K个最大元素 {
    //有点烦先不做了
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
